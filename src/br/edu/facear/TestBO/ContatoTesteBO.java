package br.edu.facear.TestBO;

import br.edu.facear.bo.ContatoBO;
import br.edu.facear.dao.OrigemContatoDAO;
import br.edu.facear.dao.TipoContatoDAO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Origem_Contato;
import br.edu.facear.entity.Tipo_Contato;

public class ContatoTesteBO {
	public static void main(String[] args) {
		testeInsert();
	}
	public static void testeInsert() {
		
	Tipo_Contato tipocontato = new Tipo_Contato();
	TipoContatoDAO tdao = new TipoContatoDAO();
	tipocontato.setNome("Cliente");
	tdao.salvar(tipocontato);
	
	Origem_Contato origem = new Origem_Contato();
	OrigemContatoDAO odao = new OrigemContatoDAO();
	origem.setNome("E-mail");
	odao.salvar(origem);
	
	Contato contato = new Contato();
	contato.setNome("Rafael");
	contato.setCpf("1234");
	//contato.setAniversario("20/10/2000");
	contato.setEndereco("Rua");
	contato.setCidade("Curitiba");
	contato.setResponsavel("rafael");
	contato.setTipocontato(tipocontato);
	contato.setOrigemcontato(origem);
	
	ContatoBO cbo = new ContatoBO();
	try{
		cbo.salvar(contato);
		System.out.println("salvo com sucesso!");
	}catch(Exception a){
		System.err.println("Erro ao inserir -> "+a.getMessage());
	}
	
	
	
}
}