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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@NotEmpty(message="Informe o nome completo!")
	@Column(name = "NOME", nullable = false)
	private String nome;

	@NotEmpty(message = "Informe um login!")
	@Column(name = "LOGIN", nullable = false, unique = true)
	private String login;

	@NotEmpty(message = "Informe uma senha!")
	@Column(name = "SENHA", nullable = false)
	private String senha;

	@NotEmpty
	@Email(message = "Informe um email v�lido!")
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column(name = "ATIVO", nullable = false)
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "PERFIL", referencedColumnName = "ID")
	private Perfil perfil;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Apontamento> apontamentos;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Apontamento> getApontamentos() {
		return apontamentos;
	}

	public void setApontamentos(List<Apontamento> apontamentos) {
		this.apontamentos = apontamentos;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}