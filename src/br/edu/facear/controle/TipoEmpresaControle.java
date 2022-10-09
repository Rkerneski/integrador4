package br.edu.facear.controle;


import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceContext;

import br.edu.facear.bo.TipoEmpresaBO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.dao.TipoTelefoneDAO;
import br.edu.facear.entity.Produto;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class TipoEmpresaControle {
	@PersistenceContext
	Tipo_Empresa tipoem;
	
	public TipoEmpresaControle(){
	
		tipoem = new Tipo_Empresa();
	}
	
	public String salvar(){
		TipoEmpresaBO bo;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
		
			Facade facade = new Facade();
			facade.cadastrarTipoEmpresa(tipoem);
			//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tipoem", this);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tipo empresa salvo com sucesso","salvo"));
		return "";
	}
	//lista o tipo empresa
	public Collection<Tipo_Empresa> getlista(){
		//TipoEmpresaBO bo = new TipoEmpresaBO();
		//return  bo.listar();
		return new TipoEmpresaBO().listar();
	}
	
	public Tipo_Empresa  getId(){
		TipoEmpresaDAO dao = new TipoEmpresaDAO();
		//tipoem = dao.getObjectTById(tipoem.getId_tipoEmpresa());
		return dao.id(tipoem);
	}


	public Tipo_Empresa getTipoem() {
		return tipoem;
	}

	public void setTipoem(Tipo_Empresa tipoem) {
		this.tipoem = tipoem;
	}
	
	
	/*public List<Tipo_Empresa> getTipoems() {
		tipoems = dao.listar();
		return tipoems;
	}

	public void setTipoems(List<Tipo_Empresa> tipoems) {
		this.tipoems = tipoems;
	}*/
	
}
