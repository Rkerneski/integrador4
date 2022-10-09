package br.edu.facear.bo;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.dao.InterfaceDAO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Empresa;

public class EmpresaBO {
	 
	public void salvar (Empresa e)throws Exception{
		if((e.getNome()==null) || (e.getCnpj()==null)||(e.getResponsavel()==null) || (e.getEndereco()== null)|| 
				(e.getNumero()==null)||(e.getCidade()==null)){
			throw new Exception("Todos os campos devem ser preechidos");
		}/*else if((e.getTipoempresa()==null)){
			throw new Exception("Tipo empresa não selecionado");
		}*/
			EmpresaDAO emdao = new EmpresaDAO();
			emdao.salvar(e);
	}
	
	public Collection<Empresa> listar() {
		EmpresaDAO emdao = new EmpresaDAO();
		return emdao.listar();
	}
	
	public void editar(Empresa em)throws Exception{
		if((em.getNome()==null) || (em.getCnpj()==null)||(em.getResponsavel()==null) || (em.getEndereco()== null)|| 
				(em.getNumero()==null)||(em.getCidade()==null)){
			throw new Exception("Todos os campos devem ser preechidos");
		}/*else if((e.getTipoempresa()==null)){
			throw new Exception("Tipo empresa não selecionado");
		}*/
			EmpresaDAO emdao = new EmpresaDAO();
			emdao.editar(em);
	}
	
	public void excluir(Empresa em)throws Exception{
		
			EmpresaDAO emdao = new EmpresaDAO();
			emdao.excluir(em);
	}
}
