package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.edu.facear.entity.Situacao;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class SituacaoControle {
	Situacao si;
	Facade facade = new Facade();
	
	public SituacaoControle(){
		si = new Situacao();
	}
	
	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			facade.cadastrarSituacao(si);
		}catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Situação salva com sucesso","salvo"));
		return null;
		
	}
	
	
	public Collection<Situacao> getLista(){
		return facade.listarSituacao();
	}

	public Situacao getSi() {
		return si;
	}

	public void setSi(Situacao si) {
		this.si = si;
	}

}
