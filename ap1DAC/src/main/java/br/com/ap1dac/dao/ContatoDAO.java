package br.com.ap1dac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.ap1.util.JpaUtil;
import br.com.ap1dac.domain.Contato;

public class ContatoDAO {
	
	public static void salvar(Contato c) {
		EntityManager em = JpaUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Contato c) {
		EntityManager em = JpaUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Contato c) {
		EntityManager em = JpaUtil.criarEntityManager();
		em.getTransaction().begin();
		c = em.find(Contato.class, c.getId());
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Contato> listar(){
		EntityManager em = JpaUtil.criarEntityManager();
		Query q = em.createQuery("select c from Contato c");
		@SuppressWarnings("unchecked")
		List<Contato> lista = q.getResultList();
		em.close();
		return lista;
	}

}
