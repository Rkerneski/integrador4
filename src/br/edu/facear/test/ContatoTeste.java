package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.facear.dao.ContatoDAO;
import br.edu.facear.dao.OrigemContatoDAO;
import br.edu.facear.dao.TipoContatoDAO;

import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Origem_Contato;
import br.edu.facear.entity.Tipo_Contato;




public class ContatoTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		
		Tipo_Contato tipocontato = new Tipo_Contato();
		tipocontato.setNome("Cliente");
		TipoContatoDAO TCdao = new TipoContatoDAO();
		TCdao.salvar(tipocontato);
		
		Origem_Contato origem = new Origem_Contato();
		origem.setNome("E-mail");
		OrigemContatoDAO origemdao = new OrigemContatoDAO();
		origemdao.salvar(origem);
		
		contato.setNome("Heleno");
		contato.setCpf("12345");
		//contato.setAniversario("10/10");
		contato.setEndereco("Rua");
		contato.setCidade("Araucaria");
		contato.setResponsavel("Heleno");
		contato.setTipocontato(tipocontato);
		contato.setOrigemcontato(origem);
		
		ContatoDAO contatodao = new ContatoDAO();
		
		contatodao.salvar(contato);
		
		
		List<Contato> contatoo = contatodao.listar();
		for (Contato cont : contatoo) {
			System.out.println("     "+cont.getNome());
			System.out.println("     "+cont.getCpf());
			System.out.println("     "+cont.getEndereco());
			System.out.println("     "+cont.getCidade());
			System.out.println("     "+cont.getResponsavel());
			System.out.println("     "+cont.getAniversario());
			System.out.println("     "+cont.getTipocontato());
			System.out.println("------------------");
		}
		List <Tipo_Contato> tipocont = TCdao.listar();
		for(Tipo_Contato tipo : tipocont ){
			System.out.println("     "+tipo.getNome());
		}
		List <Origem_Contato> origemm = origemdao.listar();
		for(Origem_Contato o : origemm){
			System.out.println("     "+o.getNome());
		}
	}

}
