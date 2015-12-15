package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.TipoTarefa;

public interface TipoTarefaService {
	boolean cadastrarTipoTarefa(TipoTarefa tipoTarefa);

	boolean editarTipoTarefa(TipoTarefa tipoTarefa);

	boolean deletarTipoTarefa(TipoTarefa tipoTarefa);

	List<Object> listarTipoTarefa();
}