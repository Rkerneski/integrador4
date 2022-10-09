package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Usuario;


public class EmpresaDAO implements InterfaceDAO <Empresa>{

	@Override
	public void salvar(Empresa empresa) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		System.out.println(empresa);
		em.getTransaction().begin();
		em.persist(empresa);
		em.getTransaction().commit();
	}

	@Override
	public List<Empresa> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Empresa a ");
		return q.getResultList();
		//select empresa from Empresa empresa
		//List <Empresa> empresas = q.getResultList();
	}

	@Override
	public void editar(Empresa empresa) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(empresa);
		em.getTransaction().commit();
	}

	@Override
	public Empresa getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Empresa.class, id);
	}

	@Override
	public void excluir(Empresa empresa) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		empresa = em.find(Empresa.class, empresa.getId_empresa());//excluir pelo id
		em.getTransaction().begin();
		em.remove(empresa);
		em.getTransaction().commit();
	}
	
}
