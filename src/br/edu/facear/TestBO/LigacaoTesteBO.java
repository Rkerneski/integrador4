package br.edu.facear.TestBO;

import java.util.Calendar;

import br.edu.facear.bo.LigacaoBO;
import br.edu.facear.dao.ContatoDAO;
import br.edu.facear.dao.EmpresaDAO;
import br.edu.facear.dao.OrigemContatoDAO;
import br.edu.facear.dao.TipoContatoDAO;
import br.edu.facear.dao.TipoEmpresaDAO;
import br.edu.facear.dao.TipoLigacaoDAO;
import br.edu.facear.entity.Atividade_Ligacao;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Origem_Contato;
import br.edu.facear.entity.Tipo_Contato;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.entity.Tipo_Ligacao;

public class LigacaoTesteBO {
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
		EmpresaDAO edao = new EmpresaDAO();
		edao.salvar(empresa);
		
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
		ContatoDAO cdao = new ContatoDAO();
		cdao.salvar(contato);
		
		Tipo_Ligacao t = new Tipo_Ligacao();
		t.setNome("entrada");
		TipoLigacaoDAO tda = new TipoLigacaoDAO();
		tda.salvar(t);
		
		
		
		Atividade_Ligacao li = new Atividade_Ligacao();
		//li.setData(c);
		li.setAssunto("assunto");
		li.setEmpresa(empresa);
		li.setContato(contato);
		li.setTipoligacao(t);
		
		LigacaoBO bo = new LigacaoBO();
		try{
			bo.salvar(li);
			System.out.println("salvo com sucesso!");
		}catch(Exception a){
			System.err.println("Erro ao inserir -> "+a.getMessage());
		}
	
	}
}
