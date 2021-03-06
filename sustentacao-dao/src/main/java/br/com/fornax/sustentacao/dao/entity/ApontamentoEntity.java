package br.com.fornax.sustentacao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "APONTAMENTO")
public class ApontamentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_APONTAMENTO")
	private long id;

	@ManyToOne
	@JoinColumn(name = "USUARIO", referencedColumnName = "ID")
	private UsuarioEntity usuario;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataCadastro;

	@Column(name = "DATA_EDICAO")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataEdicao;

	@NotNull
	@Column(name = "HORA_INICIO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	private Calendar horaInicio;

	@NotNull
	@Column(name = "HORA_TERMINO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm")
	private Calendar horaTermino;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "CODIGO_TAREFA", referencedColumnName = "CODIGO_TAREFA")
	private TarefaEntity tarefa;

	@NotEmpty(message = "Informe uma descricao")
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@NotNull
	@Column(name = "DATA_APONTAMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataApontamento;

	@Column(name="ENVIADO_APROVACAO")
	private Boolean enviadoParaAprovacao;

	// public String formataHora(Calendar hora) {
	// Date date = hora.getTime();
	// String stringFormat = "HH:mm";
	// SimpleDateFormat formata = new SimpleDateFormat(stringFormat);
	//
	// return formata.format(date);
	// }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
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

	public TarefaEntity getTarefa() {
		return tarefa;
	}

	public void setTarefa(TarefaEntity tarefa) {
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