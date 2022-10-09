package br.edu.facear.TestBO;

import br.edu.facear.bo.TelefoneEmpresaBO;
import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.dao.TipoTelefoneDAO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Telefone_Empresa;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.entity.Tipo_Telefone;

public class TelefoneEmpresaTesteBO {
	public static void main(String[] args) {
		testeInsert();
	}
	public static void testeInsert(){
		
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
		
		EmpresaDAO em = new EmpresaDAO();
		em.salvar(empresa);
		
		Tipo_Telefone tipo = new Tipo_Telefone();
		tipo.setNome("Celular");
		TipoTelefoneDAO dao = new TipoTelefoneDAO();
		dao.salvar(tipo);
		
		Telefone_Empresa te = new Telefone_Empresa();
		te.setNumero("41 9999-9999");
		te.setTipotelefone(tipo);
		te.setEmpresa(empresa);
		TelefoneEmpresaBO bo = new TelefoneEmpresaBO();
		try {
			bo.salvar(te);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
