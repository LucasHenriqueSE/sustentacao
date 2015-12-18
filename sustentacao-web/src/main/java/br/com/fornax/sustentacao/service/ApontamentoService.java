package br.com.fornax.sustentacao.service;

import java.util.List;

public interface ApontamentoService {
	boolean cadastrarApontamento(Object entity);

	boolean editarApontamento(Object entity);

	boolean excluirApontamento(Object entity);

	List<Object> listarApontamentos();

	Object buscarApontamentoPorId(Object entity, long idApontamento);
}
