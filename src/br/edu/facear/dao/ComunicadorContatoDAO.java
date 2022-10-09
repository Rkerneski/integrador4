package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Atividade_Tarefa;
import br.edu.facear.entity.Comunicador_Contato;

public class ComunicadorContatoDAO implements InterfaceDAO <Comunicador_Contato> {

	@Override
	public void salvar(Comunicador_Contato comunicadorc) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(comunicadorc);
		em.getTransaction().commit();
	}

	@Override
	public List<Comunicador_Contato> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Comunicador_Contato a ");
		return q.getResultList();
	}

	@Override
	public void editar(Comunicador_Contato comunicadorc) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(comunicadorc);
		em.getTransaction().commit();
	}

	@Override
	public Comunicador_Contato getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Comunicador_Contato.class, id);
	}

	@Override
	public void excluir(Comunicador_Contato comunicadorc) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		comunicadorc = em.find(Comunicador_Contato.class, comunicadorc.getId_comunicadorc());//excluir pelo id
		em.getTransaction().begin();
		em.remove(comunicadorc);
		em.getTransaction().commit();
	}

}
