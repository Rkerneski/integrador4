package br.edu.facear.controle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.bo.EmpresaContatoBO;
import br.edu.facear.bo.LigacaoBO;
import br.edu.facear.entity.Atividade_Ligacao;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.EmpresaContato;
import br.edu.facear.facade.Facade;
//import sun.text.resources.cldr.FormatData;

@ManagedBean
@RequestScoped
public class LigacaoControle {
	
		Atividade_Ligacao li;
		Empresa em;
		Contato c;
		Facade facade = new Facade();
		
		public LigacaoControle(){
			li = new Atividade_Ligacao();
			em = new Empresa();
			c = new Contato();
		}
		
		public String salvar(){
			
			try {
				facade.cadastrarLigacao(li);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "listaligacao.xhtml";
		
		}
		
		public String editar(){
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				facade.alterarligacao(li);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Ligação editada com sucesso","salvo"));
				return "";
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
			}
			
			return "";
		}
		
		public String excluir(){
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				facade.excluirLigacao(li);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Ligação excluida com sucesso","salvo"));
				return "";
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),""));
			}
			
			return "";
		}
		
		public Collection<Atividade_Ligacao> getlista(){
			
			return new LigacaoBO().listar();
		}

		public Atividade_Ligacao getLi() {
			return li;
		}

		public void setLi(Atividade_Ligacao li) {
			this.li = li;
		}

		public Empresa getEm() {
			return em;
		}

		public void setEm(Empresa em) {
			this.em = em;
		}

		public Contato getC() {
			return c;
		}

		public void setC(Contato c) {
			this.c = c;
		}
		
		
}
