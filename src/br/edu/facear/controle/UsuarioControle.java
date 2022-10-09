package br.edu.facear.controle;


import java.awt.event.ActionEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import org.primefaces.context.RequestContext;

import br.edu.facear.bo.UsuarioBO;
import br.edu.facear.dao.UsuarioDAO;
import br.edu.facear.entity.Usuario;

@ManagedBean(name="usuarioControle")
@RequestScoped

public class UsuarioControle {
	 Usuario usuario;
    UsuarioDAO usuarioDAO;
	
	public UsuarioControle(){
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
	}	
	
	
public String cadastrar() {
		
    	Usuario usuario2 = new Usuario();
        usuario2 = usuarioDAO.getUsuario(usuario.getNome(), usuario.getSenha());
        
        if (usuario2 == null) {
        	
			try {
				
				UsuarioBO bo = new UsuarioBO();
				bo.salvar(usuario);
				FacesContext.getCurrentInstance().addMessage(
	                    null,
	                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso",
	                                " "));
		
				return " ";
			} catch (Exception e) {
				
				FacesContext.getCurrentInstance().addMessage(
	                    null,
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem",
	                                " "));
			}
			
			return "";
        }else {
      
            FacesContext.getCurrentInstance().addMessage(
                       null,
                       new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Ja cadastrado",
                                   ""));
            usuario2 = new Usuario();
      	  System.out.println("else usuario ja cadastrado");
              return null;
             
        }

     
	}
	
	
	
	public String salvar(){
		try {
			UsuarioBO bo = new UsuarioBO();
			bo.salvar(usuario);
			return "";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem",
                                "Erro no Login!"));
		}
		return "null";
	
	}
		 

     
        
        public String logar() {
        	
              usuario = usuarioDAO.getUsuario(usuario.getNome(), usuario.getSenha());
              
              if (usuario == null) {
                    usuario = new Usuario();
                    FacesContext.getCurrentInstance().addMessage(
                               null,
                               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                           "Erro no Login!"));
                    return null;
              }else {
            	  System.out.println("aaaaaa");
                    return "index.xhtml";
                   
              }
              
              
        
	}
        public void teste(ActionEvent event) {
            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage message = null;
            boolean loggedIn = false;
        
             System.out.println("aaaaaaa");
            if(usuario.getNome() != null && usuario.getNome().equals("heleno") && usuario.getSenha() != null && usuario.getSenha().equals("123")) {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuario.getNome());
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }
             
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
        }  
    	public Usuario getUsuario() {
    		return usuario;
    	}

    	public void setUsuario(Usuario usuario) {
    		this.usuario = usuario;
    	}
        
}
