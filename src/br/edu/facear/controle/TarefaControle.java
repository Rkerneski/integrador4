package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.entity.Atividade_Tarefa;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class TarefaControle {
	
	Atividade_Tarefa tarefa;
	Facade facade = new Facade();
	Empresa empresa;
	Contato contato;
	
	public TarefaControle(){
		tarefa = new Atividade_Tarefa();
		empresa = new Empresa();
		contato = new Contato();
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.cadastrarTarefa(tarefa);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tarefa salvo com sucesso","salvo"));
		return "listartarefa.xhtml";
	}
	
	public String salvar1(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.cadastrarTarefa(tarefa);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso, selecionar mais um contato","salvo"));
		return "";
	}

	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.alterarTarefa(tarefa);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tarefa editada com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}
	
	public String excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.excluirTarefa(tarefa);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tarefa excluida com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}
	
	public Collection<Atividade_Tarefa> getlista(){
		return facade.listarTarefa();
	}

	public Atividade_Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Atividade_Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	

}
