package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Telefone_Contato;
import br.edu.facear.entity.Telefone_Empresa;

public class TelefoneEmpresaDAO implements InterfaceDAO <Telefone_Empresa> {

	@Override
	public void salvar(Telefone_Empresa telefonee) {
		EntityManager em= Conexao.getEntityManager();
		System.out.println(telefonee);
		em.getTransaction().begin();
		em.persist(telefonee);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Telefone_Empresa> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Telefone_Empresa a ");
		return q.getResultList();
	}

	@Override
	public void editar(Telefone_Empresa telefonee) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(telefonee);
		em.getTransaction().commit();
		
	}

	@Override
	public Telefone_Empresa getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(Telefone_Empresa.class, id);
	}

	@Override
	public void excluir(Telefone_Empresa telefonee) {
		EntityManager em= Conexao.getEntityManager();
		telefonee = em.find(Telefone_Empresa.class, telefonee.getId_telefonee());//excluir pelo id
		em.getTransaction().begin();
		em.remove(telefonee);
		em.getTransaction().commit();
		
	}

}
