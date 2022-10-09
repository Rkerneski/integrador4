package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import br.edu.facear.bo.EmpresaBO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
//@SessionScoped


public class EmpresaControle {
	
	Empresa empresa;
	
	boolean skip;
	
	Facade facade = new Facade();
	
	public EmpresaControle(){
		
		empresa = new Empresa();
		
		
	}
	//@PostConstruct
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//EmpresaBO bo = new EmpresaBO();
			//bo.salvar(empresa);
			facade.cadastrarEmpresa(empresa);
			
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_empresa", empresa);
			
			return "cadastrarfone?faces-redirect=true";
		} catch (Exception e) {
		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso","salvo"));
		return "null";
	
	}
	
	

	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.alterarEmpresa(empresa);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		context.addMessage(null, new FacesMessage("Empresa editada com sucesso"));
		return "";
	
	}
	
	public String excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.excluirEmpresa(empresa);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Empresa excluido com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		
		this.empresa = empresa;
	}
	
	
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }


	public Collection<Empresa> getlista(){
		
		//return new EmpresaBO().listar();
		return  facade.listarEmpresa();
		
	}
	


}


