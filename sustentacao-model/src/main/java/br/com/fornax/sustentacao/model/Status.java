package br.com.fornax.sustentacao.model;

import java.util.List;

public class Status {
	public Status() {
		super();
	}
	
	public Status(long codigoStatus){
		this.id = codigoStatus;
	}
	
	private long id;
	private String nome;
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

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	
}
