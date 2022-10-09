package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.dao.ProdutoDAO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Produto;


public class ProdutoBO {
	public void salvar(Produto pro) throws Exception{
		if((pro.getNome()==null)||(pro.getValor()==null)){
			throw new Exception("Dados não preechidos");
		}
		ProdutoDAO prodao = new ProdutoDAO();
		prodao.salvar(pro);
	}
	public Collection<Produto> listar(){
		ProdutoDAO pdao = new ProdutoDAO();
		return pdao.listar();
	}
	public void editar(Produto pro) throws Exception{
		if((pro.getNome()==null)||(pro.getValor()==null)){
			throw new Exception("Dados não preechidos");
		}
		ProdutoDAO prodao = new ProdutoDAO();
		prodao.editar(pro);
	}
	
	public void excluir(Produto pro) throws Exception{
		
		ProdutoDAO prodao = new ProdutoDAO();
		prodao.excluir(pro);
	}
}
