package br.com.fornax.sustentacao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericDAO {

	@PersistenceContext
	private EntityManager em;

	public void inserir(Object entity) {
		em.persist(entity);
	}

	public void editar(Object entity) {
		em.merge(entity);
	}

	public void excluir(Object entity) {
		em.remove(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Object> listarTudo(String query) {
		Query q = em.createQuery(query);
		return q.getResultList();
	}

	public Object buscarPorId(Object entity, long id) {
		return em.find(entity.getClass(), id);
	}
}