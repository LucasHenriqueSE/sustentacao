package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TarefaDAO;
import br.com.fornax.sustentacao.dao.entity.TarefaEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TarefaDAOImpl implements TarefaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void inserir(TarefaEntity tarefa) {
		em.persist(tarefa);
	}

	@Override
	public void editar(TarefaEntity tarefa) {
		em.merge(tarefa);
	}

	@Override
	public void excluir(TarefaEntity tarefa) {
		em.remove(tarefa);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TarefaEntity> listarTudo() {
		Query query = em.createQuery("select t from TarefaEntity t");
		return query.getResultList();
	}

	@Override
	public TarefaEntity buscarPorId(long idTarefa) {
		Query query = em.createQuery("select t from TarefaEntity t where t.id = :idTarefa");
		query.setParameter("idTarefa", idTarefa);
		return (TarefaEntity) query.getSingleResult();
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<TarefaEntity> buscarTarefaPorTipo(long idTipoTarefa) {
//		Query query = em.createQuery("select t from TarefaEntity t where t.tipo.id = :idTipoTarefa");
//		query.setParameter("idTipoTarefa", idTipoTarefa);
//		return query.getResultList();
//	}
}