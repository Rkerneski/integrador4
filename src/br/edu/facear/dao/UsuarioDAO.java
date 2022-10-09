package br.edu.facear.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.edu.facear.entity.Usuario;

public class UsuarioDAO {

	public void cadastrar(Usuario usuario) {
		// TODO Auto-generated method stub
		EntityManager em= Conexao.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	public Usuario getUsuario(String nomeUsuario, String senha) {
		EntityManager em= Conexao.getEntityManager();
      try {
    	    Usuario usuario = (Usuario) em
                         .createQuery(
                                     "SELECT u from Usuario u where u.nome = :nome and u.senha = :senha")
                         .setParameter("nome", nomeUsuario)
                         .setParameter("senha", senha).getSingleResult();
    	  		//Usuario usuario = new Usuario();
    	  		//usuario.setNome("rafael");
    	  		//usuario.setSenha("12");
              return usuario;
        } catch (NoResultException e) {
              return null;
        }
  }


}
