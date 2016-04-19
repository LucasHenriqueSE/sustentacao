package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.PerfilDAO;
import br.com.fornax.sustentacao.model.Perfil;
import br.com.fornax.sustentacao.service.PerfilService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PerfilServiceImpl implements PerfilService {

	@Inject
	private PerfilDAO perfilDao;

	@Override
	public List<Object> listarPerfis() {
		return perfilDao.listarTudo();
	}

	@Override
	public Perfil buscarPerfilPorId(Perfil perfil, long id) {
		return (Perfil) perfilDao.buscarPorId(perfil, id);
	}

}
