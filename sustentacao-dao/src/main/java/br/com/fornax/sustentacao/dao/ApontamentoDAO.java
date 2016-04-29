package br.com.fornax.sustentacao.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fornax.sustentacao.dao.entity.ApontamentoEntity;

public interface ApontamentoDAO {
	public void inserir(ApontamentoEntity apontamento);

	public void editar(ApontamentoEntity apontamento);

	public void excluir(ApontamentoEntity apontamento);

	public List<ApontamentoEntity> listarTudo();

	public ApontamentoEntity buscarPorId(long idApontamento);

	public List<ApontamentoEntity> listarApontamentoDoDia(Calendar dataDeApontamento, Calendar horaInicio,
			Calendar horaTermino);

	public List<ApontamentoEntity> listarApontamentosDoUsuario(String username);
}