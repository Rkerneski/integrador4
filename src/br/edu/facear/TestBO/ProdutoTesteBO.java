package br.edu.facear.TestBO;

import br.edu.facear.bo.ProdutoBO;
import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Produto;

public class ProdutoTesteBO {
	public static void main(String[] args) {
		testeInsert();
	}
	public static void testeInsert(){
		
		
		Produto pro = new Produto();
		pro.setNome("Aula");
		pro.setValor("120.0");
		
		ProdutoBO pbo = new ProdutoBO();
		
		try{
			pbo.salvar(pro);
			System.out.println("salvo com sucesso!");
		}catch(Exception a){
			System.err.println("Erro ao inserir -> "+a.getMessage());
		}
	}
}
