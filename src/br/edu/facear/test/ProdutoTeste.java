package br.edu.facear.test;

import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.dao.ProdutoDAO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Produto;

public class ProdutoTeste {
	public static void main(String[] args) {
		
		Empresa em = new Empresa();
		em.setNome("Facear");
		EmpresaDAO emdao = new EmpresaDAO();
		emdao.salvar(em);
		
		Produto pro = new Produto();
		pro.setNome("aula");
		pro.setValor("120.0");
		ProdutoDAO prodao = new ProdutoDAO();
		prodao.salvar(pro);
		
	}
}
