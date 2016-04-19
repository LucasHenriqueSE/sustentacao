package br.com.fornax.sustentacao.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL")
public class PerfilEntity {

	@Id
	@Column(name = "ID")
	private String codigo;

	@Column(name = "DESCRICAO", nullable = false, unique = true)
	private String descricao;

	@OneToMany(mappedBy = "perfil", fetch = FetchType.EAGER)
	private List<UsuarioEntity> usuarios;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
}