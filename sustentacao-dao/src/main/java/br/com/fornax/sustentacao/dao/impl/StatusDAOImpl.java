package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.StatusDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class StatusDAOImpl extends GenericDAO implements StatusDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> listarTudo() {
		Query lista = em.createQuery("select s from Status s");
		return lista.getResultList();
	}
}