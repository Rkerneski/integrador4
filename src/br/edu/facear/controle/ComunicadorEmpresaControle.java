package br.edu.facear.controle;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.TelefoneEmpresaBO;
import br.edu.facear.bo.tipoTelefoneBO;
import br.edu.facear.entity.Comunicador_Empresa;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Telefone;
import br.edu.facear.facade.Facade;
@ManagedBean
//@RequestScoped
@SessionScoped
public class ComunicadorEmpresaControle {
	
	Comunicador_Empresa comu;
	Empresa empresa;
	Facade facade = new Facade();
	
	public ComunicadorEmpresaControle(){
		comu = new Comunicador_Empresa();
		empresa = new Empresa();
	}
	
	@PostConstruct
	public void init(){
		empresa =(Empresa)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_empresa");
		System.out.println("*****COMuNICADOR******"+empresa);
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			comu.setEmpresa(empresa);
			facade.cadastrarComunicadorEmpresa(comu);
			System.out.println("#########COMUNICADOR###########"+empresa);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "empresacontato?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso","salvo"));
		return "null";
	
	}
	
	public String mais(){
		
		try{
			comu.setEmpresa(empresa);
			facade.cadastrarComunicadorEmpresa(comu);
			System.out.println("##########MAIS###############"+empresa);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "cadastrarcomunicadorE.xhtml?faces-redirect=true";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public Collection<Comunicador_Empresa> getLista(){
		return facade.listarComunicadorE();
	}
	
	public String voltar(){
		facade.listarComunicadorE();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "empresa.xhtml";
		
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.alterarComunicadorE(comu);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Comunicador editado com sucesso","salvo"));
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}
	
	public String salvar1(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.cadastrarComunicadorEmpresa(comu);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Comunicador adicionado com sucesso","salvo"));
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "null";
	
	}

	public Comunicador_Empresa getComu() {
		return comu;
	}

	public void setComu(Comunicador_Empresa comu) {
		this.comu = comu;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
