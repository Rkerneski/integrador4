package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.ComunicadorEmpresaDAO;
import br.edu.facear.entity.Comunicador_Empresa;


public class comunicadorEmpresaBo {
	
	ComunicadorEmpresaDAO emdao = new ComunicadorEmpresaDAO();
	
	public void salvar (Comunicador_Empresa e)throws Exception{
		if(e.getNome()==null){
			throw new Exception("Todos os campos devem ser preechidos");
		}/*else if((e.getTipoempresa()==null)){
			throw new Exception("Tipo empresa não selecionado");
		}*/
			
			emdao.salvar(e);
	}
	
	public Collection<Comunicador_Empresa> listar() {
		
		return emdao.listar();
	}
	
	public void editar(Comunicador_Empresa e)throws Exception{
		
			
			emdao.editar(e);
	}

}
