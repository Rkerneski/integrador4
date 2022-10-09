package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Contato;
import br.edu.facear.entity.Empresa;

public class ContatoDAO implements InterfaceDAO <Contato> {

	@Override
	public void salvar(Contato contato) {
		// TODO Auto-generated method stub
EntityManager em= Conexao.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(contato);
		em.getTransaction().commit();
	}

	@Override
	public List<Contato> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Contato a ");
		return q.getResultList();
		
	}

	@Override
	public void editar(Contato contato) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
	}

	@Override
	public Contato getObjectTById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Contato contato) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		contato = em.find(Contato.class, contato.getId_contato());//excluir pelo id
		em.getTransaction().begin();
		em.remove(contato);
		em.getTransaction().commit();
	}

}
