package br.com.fornax.sustentacao.dao;

import java.util.List;

public interface StatusDAO {
	void inserir(Object entity);

	void editar(Object entity);

	void excluir(Object entity);

	List<Object> listarTudo();
}