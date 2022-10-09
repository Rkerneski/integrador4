package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.TipoContatoDAO;
import br.edu.facear.entity.Tipo_Contato;

public class TipoContatoBO {
	public void salvar(Tipo_Contato tipo) throws Exception{
		if(tipo.getNome()==null){
			throw new Exception("Campo nome não preechido");
		}
		TipoContatoDAO dao = new TipoContatoDAO();
		dao.salvar(tipo);
	}
	public Collection<Tipo_Contato> listar(){		
		TipoContatoDAO dao = new TipoContatoDAO();	
		return dao.listar();
	}

}
