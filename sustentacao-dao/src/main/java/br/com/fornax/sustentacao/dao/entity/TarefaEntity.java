package br.com.fornax.sustentacao.dao.entity;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TAREFA")
public class TarefaEntity {

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_TAREFA")
	private long id;

	@ManyToOne
//	@NotEmpty(message = "Selecione um tipo de tarefa válido!")
	@JoinColumn(name = "CODIGO_TIPO_TAREFA", referencedColumnName = "CODIGO_TIPO_TAREFA")
	private TipoTarefaEntity tipo;

	@NotNull
	@Column(name = "NUMERO_CHAMADO", unique = true)
	private long numeroChamado;

	@NotEmpty(message = "Preencha o campo descrição!")
	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "CODIGO_STATUS", referencedColumnName = "CODIGO_STATUS")
	private StatusEntity status;

	@Column(name = "QTD_HORAS_DISPONIVEIS")
	private String qtdHorasDisponiveis;

	@Column(name = "DATA_EDICAO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataEdicao;

	@OneToMany(mappedBy = "tarefa", fetch = FetchType.EAGER)
	private List<ApontamentoEntity> apontamentos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoTarefaEntity getTipo() {
		return tipo;
	}

	public void setTipo(TipoTarefaEntity tipo) {
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

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
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

	public List<ApontamentoEntity> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<ApontamentoEntity> apontamentos) {
		this.apontamentos = apontamentos;
	}
}