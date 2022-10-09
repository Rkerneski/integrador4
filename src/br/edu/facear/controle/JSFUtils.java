package br.edu.facear.controle;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class JSFUtils {
	public static Flash flashScope(){
		return (FacesContext.getCurrentInstance().getExternalContext().getFlash());
	}

}
