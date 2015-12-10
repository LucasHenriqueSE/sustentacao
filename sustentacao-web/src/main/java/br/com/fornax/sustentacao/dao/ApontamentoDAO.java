package br.com.fornax.sustentacao.dao;

import br.com.fornax.sustentacao.model.Apontamento;

public interface ApontamentoDAO {
	public void inserir(Apontamento apontamento);

	public void editar(Apontamento apontamento);

	public void excluir(Apontamento apontamento);

	public void listarTarefas(Apontamento apontamento);

	public void buscarTarefa(Apontamento apontamento, long id);
}