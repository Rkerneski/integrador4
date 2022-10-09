package br.edu.facear.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador4");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();

	}
}
