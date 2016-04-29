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
import br.com.fornax.sustentacao.dao.entity.ApontamentoEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ApontamentoDAOImpl implements ApontamentoDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<ApontamentoEntity> listarTudo() {
		Query query = em.createQuery("select a from ApontamentoEntity a");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ApontamentoEntity> listarApontamentoDoDia(Calendar dataApontamento, Calendar horaInicio,
			Calendar horaTermino) {
		Query apontamentos = em
				.createQuery("select a from ApontamentoEntity a where a.dataApontamento = :dataApontamento "
						+ "and (a.horaInicio between :horaInicio and :horaTermino "
						+ "or a.horaTermino between :horaInicio and :horaTermino)");
		apontamentos.setParameter("dataApontamento", dataApontamento);
		apontamentos.setParameter("horaInicio", horaInicio);
		apontamentos.setParameter("horaTermino", horaTermino);
		return apontamentos.getResultList();

	}

	@Override
	public void inserir(ApontamentoEntity apontamento) {
		em.persist(apontamento);
	}

	@Override
	public void editar(ApontamentoEntity apontamento) {
		em.merge(apontamento);
	}

	@Override
	public void excluir(ApontamentoEntity apontamento) {
		em.remove(apontamento);
	}

	@Override
	public ApontamentoEntity buscarPorId(long idApontamento) {
		Query query = em.createQuery("select a from ApontamentoEntity a where a.id = :idApontamento");
		query.setParameter("idApontamento", idApontamento);
		return (ApontamentoEntity) query.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApontamentoEntity> listarApontamentosDoUsuario(String username) {
		Query query = em.createQuery("select a from ApontamentoEntity a where a.usuario.email = :username");
		query.setParameter("username", username);
		return query.getResultList();
	}
}