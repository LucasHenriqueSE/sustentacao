package br.com.fornax.sustentacao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS")
public class Status {

	public Status() {
		super();
	}
	
	public Status(long codigoStatus){
		this.id = codigoStatus;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "CODIGO_STATUS")
	private long id;

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@OneToMany(mappedBy = "status", fetch = FetchType.EAGER)
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