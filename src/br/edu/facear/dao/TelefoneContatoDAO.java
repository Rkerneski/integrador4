package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Produto;
import br.edu.facear.entity.Telefone_Contato;

public class TelefoneContatoDAO implements InterfaceDAO <Telefone_Contato>{

	@Override
	public void salvar(Telefone_Contato telefonec) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(telefonec);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Telefone_Contato> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Telefone_Contato a ");
		return q.getResultList();
	}

	@Override
	public void editar(Telefone_Contato telefonec) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(telefonec);
		em.getTransaction().commit();
		
	}

	@Override
	public Telefone_Contato getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Telefone_Contato.class, id);
	}

	@Override
	public void excluir(Telefone_Contato telefonec) {
		EntityManager em= Conexao.getEntityManager();
		telefonec = em.find(Telefone_Contato.class, telefonec.getId_telefonec());//excluir pelo id
		em.getTransaction().begin();
		em.remove(telefonec);
		em.getTransaction().commit();
		
	}

}
