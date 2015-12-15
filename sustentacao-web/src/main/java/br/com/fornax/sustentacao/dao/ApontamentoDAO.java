package br.com.fornax.sustentacao.dao;

public interface ApontamentoDAO {
	void inserir(Object entity);

	void editar(Object entity);

	void excluir(Object entity);

	void listarTarefas(Object entity);

	void buscarTarefa(Object entity, long id);
}