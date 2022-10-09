package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Tipo_Comunicador;
import br.edu.facear.entity.Tipo_Contato;

public class TipoContatoDAO implements InterfaceDAO <Tipo_Contato>{

	@Override
	public void salvar(Tipo_Contato tipocontato) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(tipocontato);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Tipo_Contato> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Tipo_Contato a ");
		return q.getResultList();
	}

	@Override
	public void editar(Tipo_Contato tipocontato) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(tipocontato);
		em.getTransaction().commit();
		
	}

	@Override
	public Tipo_Contato getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Tipo_Contato.class, id);
	}

	@Override
	public void excluir(Tipo_Contato tipocontato) {
		EntityManager em= Conexao.getEntityManager();
		tipocontato = em.find(Tipo_Contato.class, tipocontato.getId_tipocontato());//excluir pelo id
		em.getTransaction().begin();
		em.remove(tipocontato);
		em.getTransaction().commit();
		
	}

}
