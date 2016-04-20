package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.TipoTarefaEntity;

public interface TipoTarefaDAO {
	public void inserir(TipoTarefaEntity tipoTarefa);

	public void editar(TipoTarefaEntity tipoTarefa);

	public void excluir(TipoTarefaEntity tipoTarefa);

	public List<TipoTarefaEntity> listarTudo();

	public TipoTarefaEntity buscarPorId(long idTipoTarefa);
}