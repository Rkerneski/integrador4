package br.edu.facear.controle;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.tipoTelefoneBO;
import br.edu.facear.entity.Tipo_Comunicador;
import br.edu.facear.entity.Tipo_Telefone;
import br.edu.facear.facade.Facade;

@ManagedBean
@RequestScoped
public class TipoComunicadorControle {
	
	Tipo_Comunicador tipo;
	Facade facade = new Facade();
	
	public TipoComunicadorControle(){
		tipo = new Tipo_Comunicador();
	}
	
	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//bo = new TipoEmpresaBO();
			//bo.salvar(tipoem);
			
			facade.cadastrarTipocomunicador(tipo);
			//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("tipoem", this);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Tipo comunicador salvo com sucesso","salvo"));
		return "";
	}

	public Tipo_Comunicador getTipo() {
		return tipo;
	}

	public void setTipo(Tipo_Comunicador tipo) {
		this.tipo = tipo;
	}
	
	public Collection<Tipo_Comunicador> getLista(){
		//return new tipoTelefoneBO().listar();
		return facade.ListarTipoComunicador();
	}

}
