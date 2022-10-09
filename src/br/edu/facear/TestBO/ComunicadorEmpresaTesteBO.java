package br.edu.facear.TestBO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.entity.Comunicador_Empresa;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Comunicador;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.facade.Facade;
import junit.framework.Assert;

public class ComunicadorEmpresaTesteBO {
	
	Facade f = new Facade();
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCadastroEmpresa() {
		
		Comunicador_Empresa a = new Comunicador_Empresa();
		
		
		
	
		a.setNome("@bol.com.br");
		
		
		f.cadastrarComunicadorEmpresa(a);
		
		//Assert.assertEquals(true, a.getNome() != null);
		
	}
	/*
	@Test
	public void testAlterarEmpresa() {
		
		Facade f = new Facade();
		Empresa a = f.buscarEmpresaPorId(1l);
		
		a.setCnpj("222");
		
		f.alterarEmpresa(a);
		
		a = f.buscarEmpresaPorId(1l);
		
		Assert.assertEquals(true, a.getCnpj().equals("222"));
	}
	
	@Test
	public void testListarEmpresa() {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Facade f = new Facade();
		
		empresas = f.listarEmpresa();
		
		Assert.assertEquals(true,empresas.size() > 0);
		
	} */

}
