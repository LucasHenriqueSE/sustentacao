package br.com.fornax.sustentacao.dao;

import java.util.List;

public interface TarefaDAO {
	void inserir(Object entity);

	void editar(Object entity);

	void excluir(Object entity);

	List<Object> listarTudo(String query);

	Object buscarPorId(Object entity, long idTarefa);

	List<Object> buscarTarefaPorTipo(long idTipoTarefa);
}