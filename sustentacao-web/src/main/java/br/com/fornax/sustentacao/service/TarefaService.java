package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.Tarefa;

public interface TarefaService {
	boolean cadastrarTarefa(Tarefa tarefa);

	boolean editarTarefa(Tarefa tarefa);

	boolean excluirTarefa(Tarefa tarefa);

	List<Object> listarTarefa(String query);

	Tarefa buscarTarefaPorId(Tarefa tarefa, long idTarefa);

	List<Object> buscarTarefaPorTipo(long idTipoTarefa);
}