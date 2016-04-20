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
import br.com.fornax.sustentacao.dao.entity.PerfilEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PerfilDAOImpl extends GenericDAO implements PerfilDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void inserir(PerfilEntity perfil) {
		em.persist(perfil);
	}

	@Override
	public void editar(PerfilEntity perfil) {
		em.merge(perfil);
	}

	@Override
	public void excluir(PerfilEntity perfil) {
		em.remove(perfil);
	}

	@Override
	public PerfilEntity buscarPorId(long idPerfil) {
		Query query = em.createQuery("select p from PerfilEntity p where p.id = :idPerfil");
		query.setParameter("idPerfil", idPerfil);

		return (PerfilEntity) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PerfilEntity> listarTudo() {
		Query query = em.createQuery("select p from PerfilEntity p");
		return query.getResultList();
	}

}
