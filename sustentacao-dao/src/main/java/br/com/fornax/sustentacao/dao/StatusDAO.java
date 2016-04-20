package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.StatusEntity;

public interface StatusDAO {
	public void inserir(StatusEntity entity);

	public void editar(StatusEntity entity);

	public void excluir(StatusEntity entity);

	public List<StatusEntity> listarTudo();
}