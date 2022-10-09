package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.OrigemContatoDAO;
import br.edu.facear.entity.Origem_Contato;



public class OrigemContatoBO {
	public void salvar(Origem_Contato origem) throws Exception{
		if(origem.getNome()==null){
			throw new Exception("Campo nome não preechido");
		}
		OrigemContatoDAO dao = new OrigemContatoDAO();
		dao.salvar(origem);
	}
	public Collection<Origem_Contato> listar(){		
		OrigemContatoDAO dao = new OrigemContatoDAO();
		return dao.listar();
	}

}
