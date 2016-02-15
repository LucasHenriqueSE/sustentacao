package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.Apontamento;

public interface ApontamentoService {
	boolean cadastrarApontamento(Apontamento apontamento);

	boolean editarApontamento(Apontamento apontamento, long idApontamento);

	boolean excluirApontamento(Apontamento apontamento);

	List<Object> listarApontamentos();

	Apontamento buscarApontamentoPorId(Apontamento apontamento, long idApontamento);
	
	boolean validarHoraInicioFim(String horaInicio, String horaFim, long idTarefa);
}