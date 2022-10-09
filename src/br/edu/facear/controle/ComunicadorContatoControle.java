package br.edu.facear.controle;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.entity.Comunicador_Contato;
import br.edu.facear.entity.Contato;
import br.edu.facear.facade.Facade;

@ManagedBean
@SessionScoped
public class ComunicadorContatoControle {
	
	Comunicador_Contato comu;
	Contato contato;
	Facade facade = new Facade();
	
	public ComunicadorContatoControle(){
		comu = new Comunicador_Contato();
		contato = new Contato();
	}
	
	@PostConstruct
	public void init(){
		contato =(Contato)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_contato");
		System.out.println("*****COMuNICADOR******"+contato);
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			comu.setContato(contato);
			facade.cadastrarComunicadorContato(comu);
			System.out.println("#########COMUNICADOR###########"+contato);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_contato", contato);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "contatoempresa?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso","salvo"));
		return "null";
	
	}
	
	public String mais(){
		
		try{
			comu.setContato(contato);
			facade.cadastrarComunicadorContato(comu);
			System.out.println("##########MAIS###############"+contato);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_contato", contato);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "cadastrarcomunicadorC.xhtml?faces-redirect=true";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String salvar1(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.cadastrarComunicadorContato(comu);
			
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Comunicador adicionado com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "null";
	
	}
	
	public Collection<Comunicador_Contato> getLista(){
		return facade.listarComunicadorC();
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.alterarComunicadorContato(comu);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Comunicador editado com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}
	
	public String voltar(){
		facade.listarComunicadorC();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "contato.xhtml";
		
	}

	public Comunicador_Contato getComu() {
		return comu;
	}

	public void setComu(Comunicador_Contato comu) {
		this.comu = comu;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	

}
