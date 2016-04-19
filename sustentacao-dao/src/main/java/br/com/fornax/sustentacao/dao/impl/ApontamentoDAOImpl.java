package br.com.fornax.sustentacao.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.ApontamentoDAO;
import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.entity.ApontamentoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ApontamentoDAOImpl extends GenericDAO implements ApontamentoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> listarTudo() {
		Query query = em.createQuery("select a from Apontamento a");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ApontamentoEntity> listarApontamentoDoDia(Calendar dataApontamento, Calendar horaInicio,
			Calendar horaTermino) {
		Query apontamentos = em.createQuery(
				"select a from Apontamento a where a.dataApontamento = :dataApontamento "
				+ "and (a.horaInicio between :horaInicio and :horaTermino "
				+ "or a.horaTermino between :horaInicio and :horaTermino)");
		apontamentos.setParameter("dataApontamento", dataApontamento);
		apontamentos.setParameter("horaInicio", horaInicio);
		apontamentos.setParameter("horaTermino", horaTermino);
		return apontamentos.getResultList();

	}
}
