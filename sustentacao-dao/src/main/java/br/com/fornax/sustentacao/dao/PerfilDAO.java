package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.PerfilEntity;

public interface PerfilDAO {
	public void inserir(PerfilEntity perfil);

	public void editar(PerfilEntity perfil);

	public void excluir(PerfilEntity perfil);

	public PerfilEntity buscarPorId(long idPerfil);

	public List<PerfilEntity> listarTudo();
}