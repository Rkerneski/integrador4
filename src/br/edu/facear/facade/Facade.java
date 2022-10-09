package br.edu.facear.facade;


import java.util.Collection;
import java.util.List;

import br.edu.facear.bo.ContatoBO;
import br.edu.facear.bo.EmpresaBO;
import br.edu.facear.bo.EmpresaContatoBO;
import br.edu.facear.bo.LigacaoBO;
import br.edu.facear.bo.NegocioBO;
import br.edu.facear.bo.NegocioProdutoBO;
import br.edu.facear.bo.ProdutoBO;
import br.edu.facear.bo.SituacaoBO;
import br.edu.facear.bo.TarefaBO;
import br.edu.facear.bo.TelefoneContatoBO;
import br.edu.facear.bo.TelefoneEmpresaBO;
import br.edu.facear.bo.TipoComunicadorBO;
import br.edu.facear.bo.TipoEmpresaBO;
import br.edu.facear.bo.TipoLigacaoBO;
import br.edu.facear.bo.comunicadorContatoBO;
import br.edu.facear.bo.comunicadorEmpresaBo;
import br.edu.facear.bo.tipoTelefoneBO;
import br.edu.facear.controle.TelefoneEmpresaControle;
import br.edu.facear.dao.FactoryDao;
import br.edu.facear.dao.InterfaceDAO;
import br.edu.facear.entity.Atividade_Ligacao;
import br.edu.facear.entity.Atividade_Tarefa;
import br.edu.facear.entity.Comunicador_Contato;
import br.edu.facear.entity.Comunicador_Empresa;
import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.EmpresaContato;
import br.edu.facear.entity.Negocio;
import br.edu.facear.entity.NegocioProduto;
import br.edu.facear.entity.Produto;
import br.edu.facear.entity.Situacao;
import br.edu.facear.entity.Telefone_Contato;
import br.edu.facear.entity.Telefone_Empresa;
import br.edu.facear.entity.Tipo_Comunicador;
import br.edu.facear.entity.Tipo_Empresa;
import br.edu.facear.entity.Tipo_Ligacao;
import br.edu.facear.entity.Tipo_Telefone;

public class Facade {
	InterfaceDAO<Empresa> dao = FactoryDao.
			getEmpresaDao();

	EmpresaBO empresabo = new EmpresaBO();
	TipoEmpresaBO tipoempresabo = new TipoEmpresaBO();
	TelefoneEmpresaBO foneempresa = new TelefoneEmpresaBO();
	tipoTelefoneBO tipofone = new tipoTelefoneBO();
	comunicadorEmpresaBo comunicadore = new comunicadorEmpresaBo();
	TipoComunicadorBO tipocomunicadorbo = new TipoComunicadorBO();
	EmpresaContatoBO ecbo = new EmpresaContatoBO();

	ContatoBO contatobo = new ContatoBO();
	TelefoneContatoBO fonecontato = new TelefoneContatoBO();
	comunicadorContatoBO comunicadorc = new comunicadorContatoBO();

	ProdutoBO produto = new ProdutoBO();

	LigacaoBO ligaBO = new LigacaoBO();
	TipoLigacaoBO ligacao = new TipoLigacaoBO();

	TarefaBO tarefa = new TarefaBO();

	SituacaoBO situacao = new SituacaoBO();

	NegocioBO negociobo = new NegocioBO();

	NegocioProdutoBO nepro = new NegocioProdutoBO();


	//  EMPRESA
	public void cadastrarEmpresa(Empresa a) {
		//dao.salvar(a);

		try {
			empresabo.salvar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Empresa buscarEmpresaPorId(long l) {
		return dao.getObjectTById(l);
	}

	public void alterarEmpresa(Empresa a) {
		//dao.editar(a);
		try {
			empresabo.editar(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Empresa> listarEmpresa() {
		//return dao.listar();
		return empresabo.listar();
	}
	public void excluirEmpresa(Empresa a) {
		//dao.editar(a);
		try {
			empresabo.excluir(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TIPO DE EMPRESA
	public void cadastrarTipoEmpresa(Tipo_Empresa tipoempresa) {
		//dao.salvar(a);
		try {
			tipoempresabo.salvar(tipoempresa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//TELEFONE EMPRESA
	public void cadastrarTelefoneEmpresa(Telefone_Empresa te){
		try {
			foneempresa.salvar(te);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Collection<Telefone_Empresa> ListarTelefoenEmpresa(){
		return foneempresa.listar();

	}
	
	public void alterarTelefoneEmpresa(Telefone_Empresa te) {
		//dao.editar(a);
		try {
			foneempresa.editar(te);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TIPO TELEFONE
	public void cadastrarTipoTelefone(Tipo_Telefone ti){
		try {
			tipofone.salvar(ti);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TIPO DE COMUNICADOR
	public void cadastrarTipocomunicador(Tipo_Comunicador tipo) {
		try {
			tipocomunicadorbo.salvar(tipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Tipo_Comunicador> ListarTipoComunicador(){
		return tipocomunicadorbo.listar();

	}

	// COMUNICADOR EMPRESA
	public void cadastrarComunicadorEmpresa(Comunicador_Empresa comue) {
		try {
			comunicadore.salvar(comue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Collection<Comunicador_Empresa> listarComunicadorE() {
		//return dao.listar();
		return comunicadore.listar();
	}
	
	public void alterarComunicadorE(Comunicador_Empresa comue) {
		//dao.editar(a);
		try {
			comunicadore.editar(comue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//EMPRESA CONTATO

	public void cadastrarEmpresaContato(EmpresaContato ec){

		try {
			ecbo.salvar(ec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarEmpresaContato(EmpresaContato ec) {
		//dao.editar(a);
		try {
			ecbo.editar(ec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<EmpresaContato> listarEmpresaContato() {
		//return dao.listar();
		return ecbo.listar();
	}

	//PRODUTO
	public void cadastrarProduto(Produto pro) {
		//dao.salvar(a);

		try {
			produto.salvar(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarProduto(Produto pro) {
		//dao.editar(a);
		try {
			produto.editar(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirProduto(Produto pro) {
		//dao.editar(a);
		try {
			produto.excluir(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Produto> listarProduto() {
		//return dao.listar();
		return produto.listar();
	}

	//CONTATO
	public void cadastrarContato(Contato con) {
		//dao.salvar(a);

		try {
			contatobo.salvar(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarContato(Contato con) {
		//dao.editar(a);
		try {
			contatobo.editar(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Contato> listarContato() {
		//return dao.listar();
		return contatobo.listar();
	}

	//TELEFONE CONTATO
	public void cadastrarTelefoneContato(Telefone_Contato tele){
		try {
			fonecontato.salvar(tele);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Telefone_Contato> listarTelefoneContato() {
		//return dao.listar();
		return fonecontato.listar();
	}
	
	public void alterarTelefoneContato(Telefone_Contato tele) {
		//dao.editar(a);
		try {
			fonecontato.editar(tele);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// COMUNICADOR CONTATO
	public void cadastrarComunicadorContato(Comunicador_Contato comue) {
		try {
			comunicadorc.salvar(comue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Collection<Comunicador_Contato> listarComunicadorC() {
		//return dao.listar();
		return comunicadorc.listar();
	}
	
	public void alterarComunicadorContato(Comunicador_Contato comue) {
		//dao.editar(a);
		try {
			comunicadorc.editar(comue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//  REGISTRO DE LIGACAO
	public void cadastrarTipoLigacao(Tipo_Ligacao tili) {
		//dao.salvar(a);

		try {
			ligacao.salvar(tili);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public Collection<Tipo_Ligacao> listarTipoLigacao() {
		//return dao.listar();
		return ligacao.listar();
	}

	//  LIGACAO
	public void cadastrarLigacao(Atividade_Ligacao ati) {

		try {
			ligaBO.salvar(ati);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarligacao(Atividade_Ligacao ati) {
		//dao.editar(a);
		try {
			ligaBO.editar(ati);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Atividade_Ligacao> listarLigacao() {
		//return dao.listar();
		return ligaBO.listar();
	}

	public void excluirLigacao(Atividade_Ligacao ati) {
		//dao.editar(a);
		try {
			ligaBO.excluir(ati);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//TEREFA
	public void cadastrarTarefa(Atividade_Tarefa ta) {
		//dao.salvar(a);

		try {
			tarefa.salvar(ta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarTarefa(Atividade_Tarefa ta) {
		//dao.editar(a);
		try {
			tarefa.editar(ta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirTarefa(Atividade_Tarefa ta) {
		//dao.editar(a);
		try {
			tarefa.excluir(ta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Atividade_Tarefa> listarTarefa() {
		//return dao.listar();
		return tarefa.listar();
	}

	//SITUACAO
	public void cadastrarSituacao(Situacao si) {
		//dao.salvar(a);

		try {
			situacao.salvar(si);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarSituacao(Situacao si) {
		//dao.editar(a);
		try {
			situacao.editar(si);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirSituacao(Situacao si) {
		//dao.editar(a);
		try {
			situacao.excluir(si);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Situacao> listarSituacao() {
		//return dao.listar();
		return situacao.listar();
	}

	//NEGOCIO
	public void cadastrarNegocio(Negocio ne) {
		//dao.salvar(a);

		try {
			negociobo.salvar(ne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterarNegocio(Negocio ne) {
		//dao.editar(a);
		try {
			negociobo.editar(ne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluirNegocio(Negocio ne) {
		//dao.editar(a);
		try {
			negociobo.excluir(ne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Negocio> listarNegocio() {
		//return dao.listar();
		return negociobo.listar();
	}

	//NEGOCIOPRODUTO
		public void cadastrarNegocioProduto(NegocioProduto npro) {
			//dao.salvar(a);
			
				try {
					nepro.salvar(npro);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		public void alterarNegocioProduto(NegocioProduto npro) {
			//dao.editar(a);
			try {
				nepro.editar(npro);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void excluirNegocioProduto(NegocioProduto npro) {
			//dao.editar(a);
			try {
				nepro.excluir(npro);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Collection<NegocioProduto> listarNegocioProduto() {
			//return dao.listar();
			return nepro.listar();
		}
}
