package br.com.ap1.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatoPu");
	
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}

}
