package br.edu.facear.TestBO;

import java.util.Collection;
import java.util.List;

import br.edu.facear.bo.EmpresaBO;
import br.edu.facear.bo.TipoEmpresaBO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Empresa;

public class EmpresaTesteBO {
	
	public static void main(String[] args) {
		testeInsert();
	}

	private static void testeInsert() {
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
		
		EmpresaBO eBO = new EmpresaBO();
		try{
			eBO.salvar(empresa);
			System.out.println("salvo com sucesso!");
			
		}catch(Exception e){
			System.err.println("Erro ao inserir -->"+e.getMessage());
		}
		TipoEmpresaBO bo = new TipoEmpresaBO();
		Collection<Tipo_Empresa> tipoempresas = bo.listar();
		for (Tipo_Empresa tipoempres : tipoempresas) {
			System.out.println("     Tipo de empresa = "+tipoempres.getNome());
		
		}
		
	}

}
