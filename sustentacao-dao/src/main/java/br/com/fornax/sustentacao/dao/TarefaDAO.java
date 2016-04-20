package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.TarefaEntity;

public interface TarefaDAO {
	public void inserir(TarefaEntity tarefa);

	public void editar(TarefaEntity tarefa);

	public void excluir(TarefaEntity tarefa);

	public List<TarefaEntity> listarTudo();

	public TarefaEntity buscarPorId(long idTarefa);

//	public List<TarefaEntity> buscarTarefaPorTipo(long idTipoTarefa);
}