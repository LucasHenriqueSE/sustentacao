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
import br.com.fornax.sustentacao.dao.entity.StatusEntity;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class StatusDAOImpl extends GenericDAO implements StatusDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(StatusEntity status) {
		em.persist(status);

	}

	@Override
	public void editar(StatusEntity status) {
		em.merge(status);

	}

	@Override
	public void excluir(StatusEntity status) {
		em.remove(status);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StatusEntity> listarTudo() {
		Query lista = em.createQuery("select s from StatusEntity s");
		return lista.getResultList();
	}
}