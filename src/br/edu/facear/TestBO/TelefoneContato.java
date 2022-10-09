package br.edu.facear.TestBO;

import org.junit.Test;

import br.edu.facear.dao.OrigemContatoDAO;
import br.edu.facear.dao.TipoContatoDAO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Origem_Contato;
import br.edu.facear.entity.Telefone_Contato;
import br.edu.facear.entity.Tipo_Contato;
import br.edu.facear.entity.Tipo_Telefone;
import br.edu.facear.facade.Facade;
import junit.framework.Assert;

public class TelefoneContato {
	Facade f = new Facade();
	
	@SuppressWarnings("deprecation")
	@Test
	public void testTelefoneContato() {
		
		Tipo_Telefone ti = new Tipo_Telefone();
		ti.setNome("Celular");
		f.cadastrarTipoTelefone(ti);
		
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
		
		f.cadastrarContato(contato);
		
		
		Telefone_Contato te = new Telefone_Contato();
		te.setNumero("555-555");
		te.setTipotelefone(ti);
		te.setContato(contato);
		
		
		f.cadastrarTelefoneContato(te);
		
		Assert.assertEquals(true, te.getId_telefonec() != null);
		
	}

}
