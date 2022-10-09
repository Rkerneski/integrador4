package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Negocio;
import br.edu.facear.entity.Origem_Contato;

public class OrigemContatoDAO implements InterfaceDAO <Origem_Contato>{

	@Override
	public void salvar(Origem_Contato origem) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(origem);
		em.getTransaction().commit();
	}

	@Override
	public List<Origem_Contato> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Origem_Contato a ");
		return q.getResultList();
	}

	@Override
	public void editar(Origem_Contato origem) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(origem);
		em.getTransaction().commit();
	}

	@Override
	public Origem_Contato getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Origem_Contato.class, id);
	}

	@Override
	public void excluir(Origem_Contato origem) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		origem = em.find(Origem_Contato.class, origem.getId_origemcontato());//excluir pelo id
		em.getTransaction().begin();
		em.remove(origem);
		em.getTransaction().commit();
	}

}
