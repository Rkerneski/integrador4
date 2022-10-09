package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Situacao;
import br.edu.facear.entity.Tipo_Telefone;

public class SituacaoDAO  implements InterfaceDAO <Situacao>{

	@Override
	public void salvar(Situacao situacao) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(situacao);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Situacao> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Situacao a ");
		return q.getResultList();
	}

	@Override
	public void editar(Situacao situacao) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(situacao);
		em.getTransaction().commit();
		
	}

	@Override
	public Situacao getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Situacao.class, id);
	}

	@Override
	public void excluir(Situacao situacao) {
		EntityManager em= Conexao.getEntityManager();
		situacao = em.find(Situacao.class, situacao.getId_situacao());//excluir pelo id
		em.getTransaction().begin();
		em.remove(situacao);
		em.getTransaction().commit();
		
	}

}
