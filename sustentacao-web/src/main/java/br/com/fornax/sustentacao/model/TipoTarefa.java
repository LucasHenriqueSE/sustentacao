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
	@Column(name = "CODIGO_TIPO_TAREFA")
	private long id;

	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;

	@Column(name = "QTD_HORAS", nullable = false)
	private String qtdHoras;

	@Column(name = "QTD_HORAS_ALERTA", nullable = false)
	private String qtdHorasParaAviso;

	@OneToMany(mappedBy = "tipo", fetch = FetchType.EAGER)
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