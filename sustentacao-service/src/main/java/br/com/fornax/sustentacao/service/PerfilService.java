package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.Perfil;

public interface PerfilService {
	public List<Perfil> listarPerfis();

	public Perfil buscarPerfilPorId(long id);

}