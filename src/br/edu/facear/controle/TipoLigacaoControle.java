package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.TipoLigacaoBO;
import br.edu.facear.entity.Tipo_Ligacao;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped

public class TipoLigacaoControle {
	
	Tipo_Ligacao liga;
	Facade facade = new Facade();
	
	public TipoLigacaoControle(){
		liga = new Tipo_Ligacao();
	}
	
	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			facade.cadastrarTipoLigacao(liga);
		}catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tipo ligação salvo com sucesso","salvo"));
		return null;
		
	}
	
	public Collection<Tipo_Ligacao> getLista(){
		return facade.listarTipoLigacao();
	}

	public Tipo_Ligacao getLiga() {
		return liga;
	}

	public void setLiga(Tipo_Ligacao liga) {
		this.liga = liga;
	}
	
}
