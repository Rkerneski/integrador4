package br.edu.facear.bo;

import java.util.Collection;

import br.edu.facear.dao.AtividadeTarefaDAO;
import br.edu.facear.entity.Atividade_Tarefa;

public class TarefaBO {

	public void salvar(Atividade_Tarefa ta)throws Exception {
		if((ta.getData()==null)||(ta.getSituacao()==null)){
			throw new Exception("Dados não preechidos");
		}
		AtividadeTarefaDAO dao = new AtividadeTarefaDAO();
		dao.salvar(ta);
		
	}

	public void editar(Atividade_Tarefa ta)throws Exception {
		AtividadeTarefaDAO dao = new AtividadeTarefaDAO();
		dao.editar(ta);
		
	}

	public void excluir(Atividade_Tarefa ta) throws Exception{
		
		AtividadeTarefaDAO dao = new AtividadeTarefaDAO();
		dao.excluir(ta);
	}

	public Collection<Atividade_Tarefa> listar() {
		AtividadeTarefaDAO dao = new AtividadeTarefaDAO();
		return dao.listar();
	}

}
