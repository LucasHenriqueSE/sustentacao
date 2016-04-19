package br.com.fornax.sustentacao.dao;

import java.util.List;

public interface PerfilDAO {
	void inserir(Object entity);

	void editar(Object entity);

	void excluir(Object entity);

	List<Object> listarTudo();

	Object buscarPorId(Object entity, long id);
}