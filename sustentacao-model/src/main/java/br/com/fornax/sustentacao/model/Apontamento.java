package br.com.fornax.sustentacao.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Apontamento {
	private long id;

	private Usuario usuario;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataCadastro;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataEdicao;

	@DateTimeFormat(pattern = "HH:mm")
	private Calendar horaInicio;

	@DateTimeFormat(pattern = "HH:mm")
	private Calendar horaTermino;

	private Tarefa tarefa;

	private String descricao;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataApontamento;

	private Boolean enviadoParaAprovacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Calendar dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public Calendar getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Calendar getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Calendar horaTermino) {
		this.horaTermino = horaTermino;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataApontamento() {
		return dataApontamento;
	}

	public void setDataApontamento(Calendar dataApontamento) {
		this.dataApontamento = dataApontamento;
	}

	public Boolean getEnviadoParaAprovacao() {
		return enviadoParaAprovacao;
	}

	public void setEnviadoParaAprovacao(Boolean enviadoParaAprovacao) {
		this.enviadoParaAprovacao = enviadoParaAprovacao;
	}
}