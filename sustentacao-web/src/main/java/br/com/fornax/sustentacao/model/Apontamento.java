package br.com.fornax.sustentacao.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APONTAMENTO")
public class Apontamento {

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_APONTAMENTO")
	private long id;

	@ManyToOne
	@JoinColumn(name = "CODIGO_USUARIO")
	private Usuario usuario;

	@Column(name = "DATA_CADASTRO")
	private Calendar dataCadastro;

	@Column(name = "HORA_INICIO")
	private Calendar horaInicio;

	@Column(name = "HORA_TERMINO")
	private Calendar horaTermino;

	@ManyToOne
	@JoinColumn(name = "CODIGO_TAREFA")
	private Tarefa tarefa;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "DATA_APONTAMENTO")
	private Calendar dataApontamento;

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
}