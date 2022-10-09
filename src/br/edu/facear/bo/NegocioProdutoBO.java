package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.NegocioProdutoDAO;
import br.edu.facear.entity.NegocioProduto;

public class NegocioProdutoBO {
	
	NegocioProdutoDAO dao = new NegocioProdutoDAO();

	public void salvar(NegocioProduto npro) {
		
		dao.salvar(npro);
		
	}

	public void editar(NegocioProduto npro) {
		dao.editar(npro);
		
	}

	public void excluir(NegocioProduto npro) {
		dao.excluir(npro);
		
	}

	public Collection<NegocioProduto> listar() {
		
		return dao.listar();
	}

}
