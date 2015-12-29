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
	@Column(name = "CODIGO_TAREFA")
	private long id;

	@ManyToOne
	@JoinColumn(name = "CODIGO_TIPO_TAREFA", referencedColumnName = "CODIGO_TIPO_TAREFA")
	private TipoTarefa tipo;

	@Column(name = "NUMERO_CHAMADO", nullable = false, unique = true)
	private long numeroChamado;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "CODIGO_STATUS", referencedColumnName = "CODIGO_STATUS")
	private Status status;

	@Column(name = "QTD_HORAS_DISPONIVEIS", nullable = false)
	private String qtdHorasDisponiveis;

	@OneToMany(mappedBy = "tarefa", fetch = FetchType.EAGER)
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

	public List<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}
}