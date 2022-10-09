package br.edu.facear.bo;

import java.util.Collection;

import javax.annotation.PostConstruct;

import br.edu.facear.dao.TelefoneEmpresaDAO;
import br.edu.facear.entity.Telefone_Empresa;

public class TelefoneEmpresaBO {
	@PostConstruct
	public void salvar(Telefone_Empresa te)throws Exception{
		if(te.getNumero()==null){
			throw new Exception("Todos os campos devem ser preechidos");
		}
		TelefoneEmpresaDAO dao = new TelefoneEmpresaDAO();
		dao.salvar(te);
	}
	public Collection<Telefone_Empresa> listar(){
		TelefoneEmpresaDAO dao = new TelefoneEmpresaDAO();
		return dao.listar();
	}
	public void editar(Telefone_Empresa te) {
		TelefoneEmpresaDAO dao = new TelefoneEmpresaDAO();
		dao.editar(te);
		
	}
}
