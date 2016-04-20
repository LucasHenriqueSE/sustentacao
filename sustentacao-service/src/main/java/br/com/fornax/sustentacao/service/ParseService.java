package br.com.fornax.sustentacao.service;

import br.com.fornax.sustentacao.dao.entity.PerfilEntity;
import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;
import br.com.fornax.sustentacao.model.Perfil;
import br.com.fornax.sustentacao.model.Usuario;

public interface ParseService {
	public UsuarioEntity parseToEntity(Usuario model);

	public Usuario parseToModel(UsuarioEntity entity);

	public PerfilEntity parseToEntity(Perfil model);

	public Perfil parseToModel(PerfilEntity entity);
}