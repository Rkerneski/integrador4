package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.ComunicadorContatoDAO;
import br.edu.facear.entity.Comunicador_Contato;

public class comunicadorContatoBO {
	
	ComunicadorContatoDAO emdao = new ComunicadorContatoDAO();
	
	public void salvar (Comunicador_Contato e)throws Exception{
		if(e.getNome()==null){
			throw new Exception("Todos os campos devem ser preechidos");
		}/*else if((e.getTipoempresa()==null)){
			throw new Exception("Tipo empresa não selecionado");
		}*/
			
			emdao.salvar(e);
	}
	
	public Collection<Comunicador_Contato> listar() {
		
		return emdao.listar();
	}
	
	public void editar(Comunicador_Contato e)throws Exception{
		
			
			emdao.editar(e);
	}

}
