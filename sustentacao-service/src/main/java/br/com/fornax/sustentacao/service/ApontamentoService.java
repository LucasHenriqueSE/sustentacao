package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.model.Apontamento;

public interface ApontamentoService {
	// boolean cadastrarApontamento(Apontamento apontamento);

	public boolean editarApontamento(Apontamento apontamento);

	public boolean excluirApontamento(Apontamento apontamento);

	public List<Apontamento> listarApontamentos();

	public Apontamento buscarApontamentoPorId(long idApontamento);

	public boolean validarHoraInicioFim(String horaInicio, String horaFim, long idTarefa);

	public void cadastrarApontamento(Apontamento apontamento);
}