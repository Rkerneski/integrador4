package br.edu.facear.controle;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Telefone_Contato;
import br.edu.facear.facade.Facade;

@ManagedBean
@SessionScoped
public class TelefoneContatoControle {

	Telefone_Contato te;
	Contato contato;
	Facade facade = new Facade();

	public TelefoneContatoControle(){
		te = new Telefone_Contato();
		contato = new Contato();
	}

	@PostConstruct
	public void init(){
		contato =(Contato)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id_contato");
		System.out.println("***********"+contato);
	}

	public String salvar(){

		try{
			te.setContato(contato);
			facade.cadastrarTelefoneContato(te);
			System.out.println("#########################"+contato);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_contato", contato);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "cadastrarcomunicadorC?faces-redirect=true";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public String mais(){
		try{
			te.setContato(contato);
			facade.cadastrarTelefoneContato(te);
			System.out.println("##########MAIS###############"+contato);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id_contato", contato);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "cadastrarFoneContato.xhtml?faces-redirect=true";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public Collection<Telefone_Contato> getlista(){
		return facade.listarTelefoneContato();
	}

	public String voltar(){
		facade.listarTelefoneContato();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "contato.xhtml";

	}

	public String editar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			facade.alterarTelefoneContato(te);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Telefone editado com sucesso","salvo"));
			return "";
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
		}

		return "";
	}

	public String salvar1(){
		FacesContext context = FacesContext.getCurrentInstance();
		try{

			facade.cadastrarTelefoneContato(te);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Telefone adicionado com sucesso","salvo"));
			return "";
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public Telefone_Contato getTe() {
		return te;
	}

	public void setTe(Telefone_Contato te) {
		this.te = te;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}



}
