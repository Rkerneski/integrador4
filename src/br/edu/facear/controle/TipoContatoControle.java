package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.TipoContatoBO;
import br.edu.facear.entity.Tipo_Contato;

@ManagedBean
@RequestScoped
public class TipoContatoControle {
	Tipo_Contato con;
	
	public TipoContatoControle(){
		con = new Tipo_Contato();
	}
	public String salvar(){
		TipoContatoBO bo;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			bo = new TipoContatoBO();
			bo.salvar(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tipo contato salvo com sucesso","salvo"));
		return "";
	}
	//lista o tipo empresa
	public Collection<Tipo_Contato> getlista(){
		//TipoEmpresaBO bo = new TipoEmpresaBO();
		//return  bo.listar();
		return new TipoContatoBO().listar();
	}
	public Tipo_Contato getCon() {
		return con;
	}
	public void setCon(Tipo_Contato con) {
		this.con = con;
	}
	
}
