package br.edu.facear.bo;

import java.util.Collection;
import java.util.List;

import br.edu.facear.dao.TipoComunicadorDAO;
import br.edu.facear.entity.Tipo_Comunicador;

public class TipoComunicadorBO {
	
	TipoComunicadorDAO dao = new TipoComunicadorDAO();
	
	public void salvar(Tipo_Comunicador tipoco) throws Exception{
		if(tipoco.getNome()==null){
			throw new Exception("Campo nome não preechido");
		}
		
		dao.salvar(tipoco);
	}
	public List<Tipo_Comunicador> listar(){		
			
		return dao.listar();
	}

}
