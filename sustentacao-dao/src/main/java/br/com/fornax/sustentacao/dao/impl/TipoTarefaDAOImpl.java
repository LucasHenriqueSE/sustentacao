package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TipoTarefaDAO;
import br.com.fornax.sustentacao.dao.entity.TipoTarefaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TipoTarefaDAOImpl implements TipoTarefaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(TipoTarefaEntity tipoTarefa) {
		em.persist(tipoTarefa);
	}

	@Override
	public void editar(TipoTarefaEntity tipoTarefa) {
		em.merge(tipoTarefa);
	}

	@Override
	public void excluir(TipoTarefaEntity tipoTarefa) {
		em.remove(tipoTarefa);
	}

	@Override
	public TipoTarefaEntity buscarPorId(long idTipoTarefa) {
		Query query = em.createQuery("select t from TipoTarefaEntity t where t.id = :idTipoTarefa");
		query.setParameter("idTipoTarefa", idTipoTarefa);
		return (TipoTarefaEntity) query.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoTarefaEntity> listarTudo() {
		Query lista = em.createQuery("select tipo from TipoTarefaEntity tipo");
		return lista.getResultList();
	}
}