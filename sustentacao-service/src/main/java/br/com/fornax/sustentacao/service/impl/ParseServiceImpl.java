package br.com.fornax.sustentacao.service.impl;

import org.springframework.stereotype.Service;

import br.com.fornax.sustentacao.dao.entity.PerfilEntity;
import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;
import br.com.fornax.sustentacao.model.Perfil;
import br.com.fornax.sustentacao.model.Usuario;
import br.com.fornax.sustentacao.service.ParseService;

@Service
public class ParseServiceImpl implements ParseService {

	@Override
	public UsuarioEntity parseToEntity(Usuario model) {
		UsuarioEntity entity = null;
		if (model != null) {
			entity = new UsuarioEntity();
			entity.setId(model.getId());
			entity.setNome(model.getNome());
			entity.setEmail(model.getEmail());
			entity.setSenha(model.getSenha());
			entity.setPerfil(parseToEntity(model.getPerfil()));
			entity.setLogin(model.getLogin());
			entity.setAtivo(model.getAtivo());
		}
		return entity;
	}

	@Override
	public Usuario parseToModel(UsuarioEntity entity) {
		Usuario model = null;
		if (entity != null) {
			model = new Usuario();
			model.setId(entity.getId());
			model.setNome(entity.getNome());
			model.setEmail(entity.getEmail());
			model.setSenha(entity.getSenha());
			model.setPerfil(parseToModel(entity.getPerfil()));
			model.setLogin(entity.getLogin());
			model.setAtivo(entity.getAtivo());
		}
		return model;
	}

	@Override
	public PerfilEntity parseToEntity(Perfil model) {
		PerfilEntity entity = null;
		if (model != null) {
			entity = new PerfilEntity();
			entity.setId(model.getId());
			entity.setDescricao(model.getDescricao());
		}
		return entity;
	}

	@Override
	public Perfil parseToModel(PerfilEntity entity) {
		Perfil model = null;
		if (entity != null) {
			model = new Perfil();
			model.setId(entity.getId());
			model.setDescricao(entity.getDescricao());
		}
		return model;
	}
}