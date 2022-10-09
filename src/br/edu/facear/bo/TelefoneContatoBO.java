package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.TelefoneContatoDAO;
import br.edu.facear.entity.Telefone_Contato;

public class TelefoneContatoBO {
	public void salvar(Telefone_Contato te)throws Exception{
		if(te.getNumero()==null){
			throw new Exception("Todos os campos devem ser preechidos");
		}
		TelefoneContatoDAO dao = new TelefoneContatoDAO();
		dao.salvar(te);
	}
	
	public Collection<Telefone_Contato> listar(){
		TelefoneContatoDAO dao = new TelefoneContatoDAO();
		return dao.listar();
	}

	public void editar(Telefone_Contato tele) {
		TelefoneContatoDAO dao = new TelefoneContatoDAO();
		dao.editar(tele);
	}

}
