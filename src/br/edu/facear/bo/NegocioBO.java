package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.NegocioDAO;
import br.edu.facear.entity.Negocio;

public class NegocioBO {

	public void salvar(Negocio ne)throws Exception {
		//if(ne.getData()==null){
		//	throw new Exception("Dados não preechidos");
		//}
		NegocioDAO dao = new NegocioDAO();
		dao.salvar(ne);
	}

	public void editar(Negocio ne) {
		NegocioDAO dao = new NegocioDAO();
		dao.editar(ne);
		
	}

	public void excluir(Negocio ne) {
		NegocioDAO dao = new NegocioDAO();
		dao.excluir(ne);
		
	}

	public Collection<Negocio> listar() {
		NegocioDAO dao = new NegocioDAO();
		return dao.listar();
	}

}
