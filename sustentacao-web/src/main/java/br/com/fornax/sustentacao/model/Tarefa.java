package br.com.fornax.sustentacao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAREFA")
public class Tarefa {

	@Id
	@GeneratedValue
	@Column(name = "ID_TAREFA")
	private long id;

	@ManyToOne
	@Column(name = "TIPO_TAREFA")
	@JoinColumn(name = "ID_TIPO_TAREFA")
	private TipoTarefa tipo;

	@Column(name = "NUMERO_CHAMADO_TAREFA")
	private long numeroChamado;

	@Column(name = "DESCRICAO_TAREFA")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "ID_STATUS")
	@Column(name = "STATUS_TAREFA")
	private Status status;

	@Column(name = "QTD_HORAS_DISPONIVEIS_TAREFA")
	private long qtdHorasDisponiveis;

	@OneToMany(mappedBy = "TAREFA_APONTAMENTO", fetch = FetchType.EAGER)
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

	public long getQtdHorasDisponiveis() {
		return qtdHorasDisponiveis;
	}

	public void setQtdHorasDisponiveis(long qtdHorasDisponiveis) {
		this.qtdHorasDisponiveis = qtdHorasDisponiveis;
	}

	public List<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}
}