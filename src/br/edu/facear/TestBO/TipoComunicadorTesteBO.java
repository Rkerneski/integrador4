package br.edu.facear.TestBO;

import org.junit.Test;

import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Comunicador;
import br.edu.facear.facade.Facade;
import junit.framework.Assert;

public class TipoComunicadorTesteBO {
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCadastroEmpresa() {
		
		Tipo_Comunicador tipo = new Tipo_Comunicador();
		tipo.setNome("Email");
		
		Facade f = new Facade();
		f.cadastrarTipocomunicador(tipo);
		
		Assert.assertEquals(true, tipo.getNome() != null);
		
	}

}
