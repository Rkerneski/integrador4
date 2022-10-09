package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Atividade_Ligacao;


public class AtividadeLigacaoDAO implements InterfaceDAO <Atividade_Ligacao> {

	@Override
	public void salvar(Atividade_Ligacao atividadel) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(atividadel);
		em.getTransaction().commit();
	}

	@Override
	public List<Atividade_Ligacao> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Atividade_Ligacao a ");
		return q.getResultList();
	}

	@Override
	public void editar(Atividade_Ligacao atividadel) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(atividadel);
		em.getTransaction().commit();
	}

	@Override
	public Atividade_Ligacao getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Atividade_Ligacao.class, id);
	}

	@Override
	public void excluir(Atividade_Ligacao atividadel) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		atividadel = em.find(Atividade_Ligacao.class, atividadel.getId_ligacao());//excluir pelo id
		em.getTransaction().begin();
		em.remove(atividadel);
		em.getTransaction().commit();
	}

}
