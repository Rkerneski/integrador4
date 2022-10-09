package br.edu.facear.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.entity.Empresa;
import br.edu.facear.entity.Tipo_Contato;
import br.edu.facear.entity.Tipo_Empresa;

public class TipoEmpresaDAO implements InterfaceDAO <Tipo_Empresa>{

	@Override
	public void salvar(Tipo_Empresa tipoempresa) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(tipoempresa);
		em.getTransaction().commit();
	}

	@Override
	public List<Tipo_Empresa> listar() {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select a from Tipo_Empresa a ");
		return q.getResultList();
		//return em.createQuery("FROM "+Tipo_Empresa.class.getName()).getResultList();
	}
	
	public Tipo_Empresa id(Tipo_Empresa tipoempresa){
		EntityManager em= Conexao.getEntityManager();
		Query q = em.createQuery("select id_tipoEmpresa from Tipo_Empresa  ");
		
		return  (Tipo_Empresa) q.getSingleResult();
	}

	@Override
	public void editar(Tipo_Empresa tipoempresa) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(tipoempresa);
		em.getTransaction().commit();
	}

	@Override
	public Tipo_Empresa getObjectTById(Long id) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		return em.find(Tipo_Empresa.class, id);
	}

	@Override
	public void excluir(Tipo_Empresa tipoempresa) {
		EntityManager em= Conexao.getEntityManager();
		tipoempresa = em.find(Tipo_Empresa.class, tipoempresa.getId_tipoEmpresa());//excluir pelo id
		em.getTransaction().begin();
		em.remove(tipoempresa);
		em.getTransaction().commit();
	}

}
