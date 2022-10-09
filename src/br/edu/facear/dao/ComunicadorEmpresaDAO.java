package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Comunicador_Contato;
import br.edu.facear.entity.Comunicador_Empresa;

public class ComunicadorEmpresaDAO implements InterfaceDAO <Comunicador_Empresa>{

	@Override
	public void salvar(Comunicador_Empresa comunicadore) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(comunicadore);
		em.getTransaction().commit();
	}

	@Override
	public List<Comunicador_Empresa> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Comunicador_Empresa a ");
		return q.getResultList();
	}

	@Override
	public void editar(Comunicador_Empresa comunicadore) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(comunicadore);
		em.getTransaction().commit();
	}

	@Override
	public Comunicador_Empresa getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Comunicador_Empresa.class, id);
	}

	@Override
	public void excluir(Comunicador_Empresa comunicadore) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		comunicadore = em.find(Comunicador_Empresa.class, comunicadore.getId_comunicadore());//excluir pelo id
		em.getTransaction().begin();
		em.remove(comunicadore);
		em.getTransaction().commit();
	}

}
