package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.EmpresaContatoDAO;
import br.edu.facear.entity.EmpresaContato;

public class EmpresaContatoBO {
	
	public void salvar(EmpresaContato e)throws Exception{
		
		EmpresaContatoDAO dao = new EmpresaContatoDAO();
		dao.salvar(e);
	}
	
	public Collection<EmpresaContato> listar() {
		EmpresaContatoDAO dao = new EmpresaContatoDAO();
		return dao.listar();
	}

	public void editar(EmpresaContato e) {
		EmpresaContatoDAO dao = new EmpresaContatoDAO();
		dao.editar(e);
	}

}
