package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.dao.NegocioDAO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Negocio;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class NegocioControle {
	
	Negocio negocio;
	Empresa empresa;
	Contato contato;
	Facade facade = new Facade();
	
	public NegocioControle(){
		negocio = new Negocio();
		empresa = new Empresa();
		contato = new Contato();
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.cadastrarNegocio(negocio);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_negocio", negocio);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}

		//context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Negocio salvo com sucesso","salvo"));
		return "negocioproduto.xhtml";
	}
	
public Collection<Negocio> getlista(){
		
		return facade.listarNegocio();
	}

	public Negocio getNegocio() {
		return negocio;
	}

	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}
	
	

}
