package br.edu.facear.controle;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.EmpresaContatoBO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.EmpresaContato;
import br.edu.facear.facade.Facade;

@ManagedBean
//@RequestScoped
@SessionScoped
public class EmpresaContatoControle {
	
	EmpresaContato empresacontato;
	Empresa empresa;
	Facade facade = new Facade();
	Contato contato;
	
	public EmpresaContatoControle(){
		empresacontato = new EmpresaContato();
		empresa = new Empresa();
		contato = new Contato();
	}
	
	@PostConstruct
	public void init(){
		empresa =(Empresa)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_empresa");
		System.out.println("*****EC******"+empresa);
		
		contato =(Contato)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_contato");
		System.out.println("*****ECcontato******"+contato);
	}
	
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			empresacontato.setEmpresa(empresa);
			facade.cadastrarEmpresaContato(empresacontato);
			System.out.println("#########EC###########"+empresa);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "empresa?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso","salvo"));
		return "";
	
	}
	
	public String salvar1(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.cadastrarEmpresaContato(empresacontato);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Adicionado com sucesso","salvo"));
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	
	}
	
public String mais(){
		
		try{
			empresacontato.setEmpresa(empresa);
			facade.cadastrarEmpresaContato(empresacontato);
			System.out.println("##########MAIS###############"+empresa);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "empresacontato?faces-redirect=true";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public Collection<EmpresaContato> getlista(){
		
		return facade.listarEmpresaContato();
	}
	
	public String voltar(){
		facade.listarEmpresaContato();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "empresa.xhtml";
		
	}

	public String salvarC(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			empresacontato.setContato(contato);
			facade.cadastrarEmpresaContato(empresacontato);
			System.out.println("#########ECcontato###########"+contato);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "contato?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso","salvo"));
		return "";
	
	}
	
	public String maisC(){
		
		try{
			empresacontato.setContato(contato);
			facade.cadastrarEmpresaContato(empresacontato);
			System.out.println("##########MAISc###############"+contato);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_contato", contato);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "contatoempresa?faces-redirect=true";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String voltarC(){
		facade.listarEmpresaContato();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "contato.xhtml";
		
	}
	
	public EmpresaContato getEmpresacontato() {
		return empresacontato;
	}

	public void setEmpresacontato(EmpresaContato empresacontato) {
		this.empresacontato = empresacontato;
	}
	
	

}
