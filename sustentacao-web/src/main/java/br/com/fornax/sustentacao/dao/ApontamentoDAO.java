package br.com.fornax.sustentacao.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fornax.sustentacao.model.Apontamento;

public interface ApontamentoDAO {
	void inserir(Object entity);

	void editar(Object entity);

	void excluir(Object entity);

	List<Object> listarTudo();

	Object buscarPorId(Object entity, long id);

	List<Apontamento> listarApontamentoDoDia(Calendar dataDeApontamento, Calendar horaInicio, Calendar horaTermino);
}