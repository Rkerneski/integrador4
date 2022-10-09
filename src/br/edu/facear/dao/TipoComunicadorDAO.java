package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Telefone_Empresa;
import br.edu.facear.entity.Tipo_Comunicador;

public class TipoComunicadorDAO implements InterfaceDAO <Tipo_Comunicador>{

	@Override
	public void salvar(Tipo_Comunicador tipocomunicador) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(tipocomunicador);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Tipo_Comunicador> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Tipo_Comunicador a ");
		return q.getResultList();
	}

	@Override
	public void editar(Tipo_Comunicador tipocomunicador) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(tipocomunicador);
		em.getTransaction().commit();
		
	}

	@Override
	public Tipo_Comunicador getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Tipo_Comunicador.class, id);
	}

	@Override
	public void excluir(Tipo_Comunicador tipocomunicador) {
		EntityManager em= Conexao.getEntityManager();
		tipocomunicador = em.find(Tipo_Comunicador.class, tipocomunicador.getId_tipocomunicador());//excluir pelo id
		em.getTransaction().begin();
		em.remove(tipocomunicador);
		em.getTransaction().commit();
		
	}

}
