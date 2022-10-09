package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.tipoTelefoneBO;
import br.edu.facear.entity.Tipo_Telefone;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class TipoFoneControle {
		Tipo_Telefone fone;
		Facade facade = new Facade();
		
	public TipoFoneControle(){
		fone = new Tipo_Telefone();
	}

	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			facade.cadastrarTipoTelefone(fone);
		}catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tipo telefone salvo com sucesso","salvo"));
		return null;
		
	}
	
	
	public Collection<Tipo_Telefone> getLista(){
		return new tipoTelefoneBO().listar();
	}
	
	public Tipo_Telefone getFone() {
		return fone;
	}

	public void setFone(Tipo_Telefone fone) {
		this.fone = fone;
	}
	
}

