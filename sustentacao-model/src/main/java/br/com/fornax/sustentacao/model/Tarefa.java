package br.com.fornax.sustentacao.model;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	private long id;
	private TipoTarefa tipo;
	private long numeroChamado;
	private String descricao;
	private Status status;
	private String qtdHorasDisponiveis;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataEdicao;

	private List<Apontamento> apontamentos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoTarefa getTipo() {
		return tipo;
	}

	public void setTipo(TipoTarefa tipo) {
		this.tipo = tipo;
	}

	public long getNumeroChamado() {
		return numeroChamado;
	}

	public void setNumeroChamado(long numeroChamado) {
		this.numeroChamado = numeroChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getQtdHorasDisponiveis() {
		return qtdHorasDisponiveis;
	}

	public void setQtdHorasDisponiveis(String qtdHorasDisponiveis) {
		this.qtdHorasDisponiveis = qtdHorasDisponiveis;
	}

	public Calendar getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Calendar dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public List<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}
	
	
}
