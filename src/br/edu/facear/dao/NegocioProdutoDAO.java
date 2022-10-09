package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.EmpresaContato;
import br.edu.facear.entity.NegocioProduto;

public class NegocioProdutoDAO implements InterfaceDAO <NegocioProduto> {

	@Override
	public void salvar(NegocioProduto negocioproduto) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(negocioproduto);
		em.getTransaction().commit();
		
	}

	@Override
	public List<NegocioProduto> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from NegocioProduto a ");
		return q.getResultList();
	}

	@Override
	public void editar(NegocioProduto negocioproduto) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(negocioproduto);
		em.getTransaction().commit();
		
	}

	@Override
	public NegocioProduto getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(NegocioProduto.class, id);
	}

	@Override
	public void excluir(NegocioProduto negocioproduto) {
		EntityManager em= Conexao.getEntityManager();
		negocioproduto = em.find(NegocioProduto.class, negocioproduto.getId_negocioproduto());//excluir pelo id
		em.getTransaction().begin();
		em.remove(negocioproduto);
		em.getTransaction().commit();
		
	}

}
