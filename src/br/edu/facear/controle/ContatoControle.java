package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.ContatoBO;
import br.edu.facear.entity.Contato;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class ContatoControle {
	Contato contato;
	Facade facade = new Facade();
	
	public ContatoControle(){
		contato = new Contato();
	}
	
	public String salvar(){
		try {
			facade.cadastrarContato(contato);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_contato", contato);
			
			return "cadastrarFoneContato?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "null";
	
	}
	
	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.alterarContato(contato);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		context.addMessage(null, new FacesMessage("Contato editado com sucesso"));
		return "";
	
	}
	public Collection<Contato> getlista(){
		
		return facade.listarContato();
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
