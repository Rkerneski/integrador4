package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.SituacaoDAO;
import br.edu.facear.entity.Situacao;

public class SituacaoBO {

	public void salvar(Situacao s)throws Exception {
		if(s.getNome()==null){
			throw new Exception("Situacao não preechido");
		}
		SituacaoDAO dao = new SituacaoDAO();
		dao.salvar(s);
		
	}

	public void editar(Situacao s)throws Exception {
		SituacaoDAO dao = new SituacaoDAO();
		dao.editar(s);
	}

	public void excluir(Situacao s)throws Exception {
		SituacaoDAO dao = new SituacaoDAO();
		dao.excluir(s);
	}

	public Collection<Situacao> listar() {
		SituacaoDAO dao = new SituacaoDAO();
		return dao.listar();
	}

}
