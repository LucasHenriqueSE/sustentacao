package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.UsuarioDAO;
import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UsuarioDAOImpl extends GenericDAO implements UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarTudo() {
		Query lista = em.createQuery("select u from Usuario u");
		return lista.getResultList();
	}

	@Override
	public UsuarioEntity buscarUsuarioPorLogin(String username) {
		Query query = em.createQuery("select u from Usuario u where u.login = :username");
		query.setParameter("username",username);
		return (UsuarioEntity) query.getSingleResult();
	}
}