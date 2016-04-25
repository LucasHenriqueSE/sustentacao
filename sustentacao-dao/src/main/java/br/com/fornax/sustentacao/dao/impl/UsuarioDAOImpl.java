package br.com.fornax.sustentacao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.UsuarioDAO;
import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listarTudo() {
		Query query = em.createQuery("select u from UsuarioEntity u");
		if (!query.getResultList().isEmpty()) {
			return query.getResultList();
		}
		return null;
	}

	@Override
	public UsuarioEntity buscarUsuarioPorLogin(String username) {
		Query query = em.createQuery("select u from UsuarioEntity u where u.email = :username");
		query.setParameter("username", username);
		if (!query.getResultList().isEmpty()) {
			return (UsuarioEntity) query.getSingleResult();
		}
		return null;
	}

	@Override
	public void inserir(UsuarioEntity usuario) {
		em.persist(usuario);
	}

	@Override
	public void editar(UsuarioEntity usuario) {
		em.merge(usuario);
	}

	@Override
	public void excluir(UsuarioEntity usuario) {
		em.remove(usuario);
	}

	@Override
	public UsuarioEntity buscarPorId(long idUsuario) {
		Query query = em.createQuery("select u from UsuarioEntity u where u.id = :idUsuario");
		query.setParameter("idUsuario", idUsuario);
		if (!query.getResultList().isEmpty()) {
			return (UsuarioEntity) query.getSingleResult();
		}
		return null;
	}
}