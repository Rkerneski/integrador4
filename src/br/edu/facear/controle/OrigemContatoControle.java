package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.OrigemContatoBO;
import br.edu.facear.entity.Origem_Contato;

@ManagedBean
@RequestScoped
public class OrigemContatoControle {
	Origem_Contato origem;
	
	public OrigemContatoControle(){
		origem = new Origem_Contato();
	}
	
	public String salvar(){
		OrigemContatoBO bo;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			bo = new OrigemContatoBO();
			bo.salvar(origem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Origem salvo com sucesso","salvo"));
		return "";
	}
	
	public Collection<Origem_Contato> getlista(){
		return new OrigemContatoBO().listar();
	}

	public Origem_Contato getOrigem() {
		return origem;
	}

	public void setOrigem(Origem_Contato origem) {
		this.origem = origem;
	}
   
}
