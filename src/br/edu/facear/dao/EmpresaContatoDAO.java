package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.facear.entity.EmpresaContato;

public class EmpresaContatoDAO implements InterfaceDAO <EmpresaContato>{

	@Override
	public void salvar(EmpresaContato empresacontato) {
		EntityManager em= Conexao.getEntityManager();
		System.out.println(empresacontato);
		em.getTransaction().begin();
		em.persist(empresacontato);
		em.getTransaction().commit();
		
	}

	@Override
	public List<EmpresaContato> listar() {
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from EmpresaContato a ");
		return q.getResultList();
	}

	@Override
	public void editar(EmpresaContato empresacontato) {
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(empresacontato);
		em.getTransaction().commit();
	}

	@Override
	public EmpresaContato getObjectTById(Long id) {
		EntityManager em= Conexao.getEntityManager();
		return em.find(EmpresaContato.class, id);
	}

	@Override
	public void excluir(EmpresaContato empresacontato) {
		EntityManager em= Conexao.getEntityManager();
		empresacontato = em.find(EmpresaContato.class, empresacontato.getId_empresacontato());//excluir pelo id
		em.getTransaction().begin();
		em.remove(empresacontato);
		em.getTransaction().commit();
		
	}

}
