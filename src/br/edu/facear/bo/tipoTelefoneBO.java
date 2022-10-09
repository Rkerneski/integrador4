package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.TipoTelefoneDAO;
import br.edu.facear.entity.Tipo_Telefone;

public class tipoTelefoneBO {
	
	public void salvar(Tipo_Telefone fone)throws Exception{
		if(fone.getNome()==null){
			throw new Exception("tipo telefone não preechido");
		}
		TipoTelefoneDAO dao = new TipoTelefoneDAO();
		dao.salvar(fone);
	}
	public Collection<Tipo_Telefone>listar(){
		TipoTelefoneDAO dao = new TipoTelefoneDAO();
		return dao.listar();
	}
}
