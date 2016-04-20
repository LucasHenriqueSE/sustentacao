package br.com.fornax.sustentacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.PerfilDAO;
import br.com.fornax.sustentacao.dao.entity.PerfilEntity;
import br.com.fornax.sustentacao.model.Perfil;
import br.com.fornax.sustentacao.service.ParseService;
import br.com.fornax.sustentacao.service.PerfilService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PerfilServiceImpl implements PerfilService {

	@Inject
	private PerfilDAO perfilDao;

	@Inject
	private ParseService parse;

	@Override
	public List<Perfil> listarPerfis() {
		List<PerfilEntity> lista = perfilDao.listarTudo();
		List<Perfil> perfis = new ArrayList<Perfil>();
		for (PerfilEntity perfil : lista) {
			perfis.add(parse.parseToModel(perfil));
		}
		return perfis;
	}

	@Override
	public Perfil buscarPerfilPorId(long idPerfil) {
		return (Perfil) parse.parseToModel(perfilDao.buscarPorId(idPerfil));
	}

}
