package br.edu.facear.controle;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import br.edu.facear.entity.Negocio;
import br.edu.facear.entity.NegocioProduto;
import br.edu.facear.entity.Produto;
import br.edu.facear.facade.Facade;

@ManagedBean
@SessionScoped
public class NegocioProdutoControle {
	
	Facade facade = new Facade();
	Negocio negocio;
	Produto produto;
	NegocioProduto negopro;
	
	public NegocioProdutoControle(){
		negocio = new Negocio();
		produto= new Produto();
		negopro = new NegocioProduto();
	}
	
	@PostConstruct
	public void init(){
			negocio =(Negocio)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_negocio");
			System.out.println("*****negocio******"+negocio);
		
		
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			negopro.setNegocio(negocio);
			facade.cadastrarNegocioProduto(negopro);
			System.out.println("#########negocio###########"+negocio);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "listanegocio?faces-redirect=true";
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
			negopro.setNegocio(negocio);
			facade.cadastrarNegocioProduto(negopro);
			System.out.println("#########negocio###########"+negocio);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_negocio", negocio);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "negocioproduto?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso","salvo"));
		return "";
	
	}
	
public Collection<NegocioProduto> getlista(){
		
		return facade.listarNegocioProduto();
	}

	public String voltar(){
		facade.listarNegocioProduto();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "listanegocio.xhtml";
		
	}

	public NegocioProduto getNegopro() {
		return negopro;
	}

	public void setNegopro(NegocioProduto negopro) {
		this.negopro = negopro;
	}
	
	

}
