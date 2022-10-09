package br.edu.facear.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import br.edu.facear.dao.ContatoDAO;
import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.dao.TipoContatoDAO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Contato;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.facade.Facade;
import junit.framework.Assert;

public class TestTipoEmpresa {

		@SuppressWarnings("deprecation")
		@Test
		public void testCadastroEmpresa() {
			
			Empresa a = new Empresa();
			a.setCnpj("1111");
			
			Facade f = new Facade();
			f.cadastrarEmpresa(a);
			
			Assert.assertEquals(true, a.getId_empresa() != null);
			
		}
		
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
			Collection<Empresa> empresas = new ArrayList<Empresa>();
			Facade f = new Facade();
			
			empresas = f.listarEmpresa();
			
			Assert.assertEquals(true,empresas.size() > 0);
			
		}
		
	

}
