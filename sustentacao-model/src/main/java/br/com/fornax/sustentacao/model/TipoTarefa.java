package br.com.fornax.sustentacao.model;

import java.util.List;

public class TipoTarefa {
	private long id;
	private String nome;
	private String qtdHoras;
	private String qtdHorasParaAviso;
	private List<Tarefa> tarefas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQtdHoras() {
		return qtdHoras;
	}
	public void setQtdHoras(String qtdHoras) {
		this.qtdHoras = qtdHoras;
	}
	public String getQtdHorasParaAviso() {
		return qtdHorasParaAviso;
	}
	public void setQtdHorasParaAviso(String qtdHorasParaAviso) {
		this.qtdHorasParaAviso = qtdHorasParaAviso;
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	
}
