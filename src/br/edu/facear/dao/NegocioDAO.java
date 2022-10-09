package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Comunicador_Empresa;
import br.edu.facear.entity.Negocio;

public class NegocioDAO implements InterfaceDAO <Negocio>{

	@Override
	public void salvar(Negocio negocio) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(negocio);
		em.getTransaction().commit();
	}

	@Override
	public List<Negocio> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Negocio a ");
		return q.getResultList();
	}

	@Override
	public void editar(Negocio negocio) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(negocio);
		em.getTransaction().commit();
	}

	@Override
	public Negocio getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Negocio.class, id);
	}

	@Override
	public void excluir(Negocio negocio) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		negocio = em.find(Negocio.class, negocio.getId_negocio());//excluir pelo id
		em.getTransaction().begin();
		em.remove(negocio);
		em.getTransaction().commit();
	}

}
