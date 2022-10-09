package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.AtividadeLigacaoDAO;
import br.edu.facear.entity.Atividade_Ligacao;

public class LigacaoBO {
	public void salvar(Atividade_Ligacao li)throws Exception{
		if(li.getAssunto().equals(null)){
			throw new Exception("Todos os campos deve ser preechidos");
		}
		AtividadeLigacaoDAO dao = new AtividadeLigacaoDAO();
		dao.salvar(li);
	}
	
	public Collection<Atividade_Ligacao> listar() {
		AtividadeLigacaoDAO dao = new AtividadeLigacaoDAO();
		return dao.listar();
	}

	public void editar(Atividade_Ligacao li)throws Exception {
		if(li.getAssunto().equals(null)){
			throw new Exception("Todos os campos deve ser preechidos");
		}
		AtividadeLigacaoDAO dao = new AtividadeLigacaoDAO();
		dao.editar(li);
	}

	public void excluir(Atividade_Ligacao li) {
		AtividadeLigacaoDAO dao = new AtividadeLigacaoDAO();
		dao.excluir(li);
	}
}
