package br.edu.facear.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import br.edu.facear.bo.TelefoneEmpresaBO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Telefone_Empresa;
import br.edu.facear.entity.Tipo_Telefone;
import br.edu.facear.facade.Facade;

@ManagedBean
//@RequestScoped
@SessionScoped
public class TelefoneEmpresaControle {
	
	Telefone_Empresa te;
	Collection<Tipo_Telefone> tipofone;
	Empresa empresa;
	Facade facade = new Facade();
	
	
		public TelefoneEmpresaControle() {
			te = new Telefone_Empresa();
			tipofone = new ArrayList<Tipo_Telefone>();
			empresa = new Empresa();
			
		}
		@PostConstruct
		public void init(){
			empresa =(Empresa)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_empresa");
			System.out.println("***********"+empresa);
		}
		
		
		public String salvar(){
			
			try{
				te.setEmpresa(empresa);
				facade.cadastrarTelefoneEmpresa(te);
				System.out.println("#########################"+empresa);
				FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				return "cadastrarcomunicadorE?faces-redirect=true";
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		public String mais(){
			TelefoneEmpresaBO bo;
			
			try{
				bo = new TelefoneEmpresaBO();
				te.setEmpresa(empresa); 
				facade.cadastrarTelefoneEmpresa(te);
				System.out.println("##########MAIS###############"+empresa);
				FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				return "cadastrarfone.xhtml?faces-redirect=true";
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		
		public Collection<Telefone_Empresa> getlista(){
			return facade.ListarTelefoenEmpresa();
		}
		
		public String voltar(){
			facade.ListarTelefoenEmpresa();
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "empresa.xhtml";
			
		}
		
		public String editar(){
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				facade.alterarTelefoneEmpresa(te);
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Telefone editado com sucesso","salvo"));
				return "";
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
			}
			
			return "";
		}
		
public String salvar1(){
	FacesContext context = FacesContext.getCurrentInstance();
			try{
				
				facade.cadastrarTelefoneEmpresa(te);
				//System.out.println("#########################"+empresa);
				//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
				FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Telefone adicionado com sucesso","salvo"));
				return "";
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		
	
		public Telefone_Empresa getTe() {
			return te;
		}

		public void setTe(Telefone_Empresa te) {
			this.te = te;
		}
		public Empresa getEmpresa() {
			return empresa;
		}
		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}
		

	
		
}
