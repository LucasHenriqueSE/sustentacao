package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.Tarefa;

public interface TarefaService {
	public boolean cadastrarTarefa(Tarefa tarefa);

	public boolean editarTarefa(Tarefa tarefa);

	public boolean excluirTarefa(Tarefa tarefa);

	public List<Tarefa> listarTarefas();

	public Tarefa buscarTarefaPorId(long idTarefa);

	public List<Tarefa> listarTarefasDoUsuario(String username);

//	public List<Tarefa> buscarTarefaPorTipo(long idTipoTarefa);
}