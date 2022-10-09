package br.edu.facear.bo;

import java.util.Collection;
import java.util.List;

import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.entity.Tipo_Empresa;



public class TipoEmpresaBO {
	public void salvar(Tipo_Empresa tipoem) throws Exception{
		if(tipoem.getNome()==null){
			throw new Exception("Campo nome não preechido");
		}
		TipoEmpresaDAO dao = new TipoEmpresaDAO();
		dao.salvar(tipoem);
	}
	public Collection<Tipo_Empresa> listar(){		
		TipoEmpresaDAO dao = new TipoEmpresaDAO();	
		return dao.listar();
	}

}
