package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.Perfil;

public interface PerfilService {
	List<Object> listarPerfis();

	Perfil buscarPerfilPorId(Perfil perfil, long id);
}