package br.edu.facear.controle;

import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.ProdutoBO;
import br.edu.facear.dao.ProdutoDAO;

import br.edu.facear.entity.Produto;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class ProdutoControle {
	Produto pro;
	Facade facade = new Facade();

	public ProdutoControle(){
		pro = new Produto();
	}
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			facade.cadastrarProduto(pro);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto salvo com sucesso","salvo"));
		return "";
	}

	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.alterarProduto(pro);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto editado com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}
	
	public String excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.excluirProduto(pro);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Produto excluido com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		
		return "";
	}

	public Produto getPro() {
		return pro;
	}
	public void setPro(Produto pro) {
		this.pro = pro;
	}
	public Collection<Produto> getlista(){
		return facade.listarProduto();
	}


}
