package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Tipo_Contato;
import br.edu.facear.entity.Tipo_Ligacao;

public class TipoLigacaoDAO implements InterfaceDAO <Tipo_Ligacao>{

	@Override
	public void salvar(Tipo_Ligacao tipoligacao) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(tipoligacao);
		em.getTransaction().commit();
	}

	@Override
	public List<Tipo_Ligacao> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Tipo_Ligacao a ");
		return q.getResultList();
	}

	@Override
	public void editar(Tipo_Ligacao tipoligacao) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(tipoligacao);
		em.getTransaction().commit();
	}

	@Override
	public Tipo_Ligacao getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Tipo_Ligacao.class, id);
	}

	@Override
	public void excluir(Tipo_Ligacao tipoligacao) {
		EntityManager em= Conexao.getEntityManager();
		tipoligacao = em.find(Tipo_Ligacao.class, tipoligacao.getId_tipoligacao());//excluir pelo id
		em.getTransaction().begin();
		em.remove(tipoligacao);
		em.getTransaction().commit();
	}

}
