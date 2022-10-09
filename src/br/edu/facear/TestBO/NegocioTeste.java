package br.edu.facear.TestBO;

import org.junit.Test;

import br.edu.facear.dao.OrigemContatoDAO;
import br.edu.facear.dao.TipoContatoDAO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Negocio;
import br.edu.facear.entity.Origem_Contato;
import br.edu.facear.entity.Tipo_Contato;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.facade.Facade;
import junit.framework.Assert;

public class NegocioTeste {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCadastroNegocio() {
		Facade facade = new Facade();
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
		facade.cadastrarContato(contato);
		
		Tipo_Empresa tipoempresa = new Tipo_Empresa();
		TipoEmpresaDAO tipoempresadao = new TipoEmpresaDAO();
		tipoempresa.setNome("Faculdade");
		tipoempresadao.salvar(tipoempresa);
		
		Empresa empresa = new Empresa();
		
		empresa.setNome("Facear");
		empresa.setCnpj("1234");
		empresa.setResponsavel("Ana");
		empresa.setEndereco("Av Araucarias");
		empresa.setNumero("547");
		empresa.setCidade("Araucaria");
		empresa.setTipoempresa(tipoempresa);
		facade.cadastrarEmpresa(empresa);
		
		
		Negocio negocio = new Negocio();
		negocio.setData(null);
		negocio.setContato(contato);
		negocio.setEmpresa(empresa);
		facade.cadastrarNegocio(negocio);
		
		
		
	}

}
