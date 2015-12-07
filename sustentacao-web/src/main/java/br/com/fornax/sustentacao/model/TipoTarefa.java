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
@Table(name = "TIPO_TAREFA")
public class TipoTarefa {

	@Id
	@GeneratedValue
	@Column(name = "ID_TIPO_TAREFA")
	private long id;

	@Column(name = "NOME_TIPO_TAREFA")
	private String nome;

	@Column(name = "QTD_HORAS_TIPO_TAREFA")
	private long qtdHoras;

	@Column(name = "QTD_HORAS_PARA_AVISO_TIPO_TAREFA")
	private long qtdHorasParaAviso;

	@OneToMany(mappedBy = "TIPO_TAREFA", fetch = FetchType.EAGER)
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

	public long getQtdHoras() {
		return qtdHoras;
	}

	public void setQtdHoras(long qtdHoras) {
		this.qtdHoras = qtdHoras;
	}

	public long getQtdHorasParaAviso() {
		return qtdHorasParaAviso;
	}

	public void setQtdHorasParaAviso(long qtdHorasParaAviso) {
		this.qtdHorasParaAviso = qtdHorasParaAviso;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}