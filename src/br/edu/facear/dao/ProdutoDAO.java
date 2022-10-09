package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Origem_Contato;
import br.edu.facear.entity.Produto;

public class ProdutoDAO implements InterfaceDAO <Produto>{

	@Override
	public void salvar(Produto produto) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

	@Override
	public List<Produto> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Produto a ");
		return q.getResultList();
	}

	@Override
	public void editar(Produto produto) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		
	}

	@Override
	public Produto getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Produto.class, id);
	}

	@Override
	public void excluir(Produto produto) {
		EntityManager em= Conexao.getEntityManager();
		produto = em.find(Produto.class, produto.getId_produto());//excluir pelo id
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		
	}

}
