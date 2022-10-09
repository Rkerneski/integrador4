package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Tipo_Ligacao;
import br.edu.facear.entity.Tipo_Telefone;

public class TipoTelefoneDAO implements InterfaceDAO <Tipo_Telefone>{

	@Override
	public void salvar(Tipo_Telefone tipotelefone) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(tipotelefone);
		em.getTransaction().commit();
	}

	@Override
	public List<Tipo_Telefone> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Tipo_Telefone a ");
		return q.getResultList();
	}

	@Override
	public void editar(Tipo_Telefone tipotelefone) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(tipotelefone);
		em.getTransaction().commit();
	}

	@Override
	public Tipo_Telefone getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Tipo_Telefone.class, id);
	}

	@Override
	public void excluir(Tipo_Telefone tipotelefone) {
		EntityManager em= Conexao.getEntityManager();
		tipotelefone = em.find(Tipo_Telefone.class, tipotelefone.getId_tipotelefone());//excluir pelo id
		em.getTransaction().begin();
		em.remove(tipotelefone);
		em.getTransaction().commit();
	}

}
