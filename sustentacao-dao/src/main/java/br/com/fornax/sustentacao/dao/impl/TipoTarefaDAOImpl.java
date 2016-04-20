package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.TipoTarefaDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TipoTarefaDAOImpl extends GenericDAO implements TipoTarefaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> listarTudo() {
		Query lista = em.createQuery("select tipo from TipoTarefaEntity tipo");
		return lista.getResultList();
	}
}