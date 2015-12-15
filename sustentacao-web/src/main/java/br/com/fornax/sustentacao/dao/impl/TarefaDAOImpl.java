package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.TarefaDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TarefaDAOImpl extends GenericDAO implements TarefaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> buscarTarefaPorTipo(long idTipoTarefa) {
		Query lista = em.createQuery("select tarefa from Tarefa tarefa where tarefa.tipo.id = :idTipoTarefa");
		return lista.getResultList();
	}

//	@Override
//	public List<Object> listarTudo(String query) {
//		Query query
//		return super.listarTudo(query);
//	}
}