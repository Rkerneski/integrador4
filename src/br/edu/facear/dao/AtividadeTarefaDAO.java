package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.edu.facear.entity.Atividade_Tarefa;

public class AtividadeTarefaDAO implements InterfaceDAO <Atividade_Tarefa> {

	@Override
	public void salvar(Atividade_Tarefa atividadet) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(atividadet);
		em.getTransaction().commit();
	}

	@Override
	public List<Atividade_Tarefa> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Atividade_Tarefa a ");
		return q.getResultList();
	}

	@Override
	public void editar(Atividade_Tarefa atividadet) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(atividadet);
		em.getTransaction().commit();
	}

	@Override
	public Atividade_Tarefa getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Atividade_Tarefa.class, id);
	}

	@Override
	public void excluir(Atividade_Tarefa atividadet) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		atividadet = em.find(Atividade_Tarefa.class, atividadet.getId_tarefa());//excluir pelo id
		em.getTransaction().begin();
		em.remove(atividadet);
		em.getTransaction().commit();
	}

}
