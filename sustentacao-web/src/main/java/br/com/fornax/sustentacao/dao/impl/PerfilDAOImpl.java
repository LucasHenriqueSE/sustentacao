package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.PerfilDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PerfilDAOImpl extends GenericDAO implements PerfilDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listarTudo() {
		Query query = em.createQuery("select p from Perfil p");
		return query.getResultList();
	}

}
