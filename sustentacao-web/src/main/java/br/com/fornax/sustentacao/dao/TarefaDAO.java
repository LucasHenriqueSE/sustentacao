package br.com.fornax.sustentacao.dao;

import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.model.TipoTarefa;

public interface TarefaDAO {
	public void inserir(Tarefa tarefa);

	public void editar(Tarefa tarefa);

	public void excluir(Tarefa tarefa);

	public void listarTarefas(Tarefa tarefa);

	public void buscarTarefa(Tarefa tarefa, long id);

	public void buscarTarefaPorTipo(TipoTarefa tipo, long id);
}