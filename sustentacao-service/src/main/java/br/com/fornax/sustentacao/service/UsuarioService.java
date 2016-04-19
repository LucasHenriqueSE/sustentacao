package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;
import br.com.fornax.sustentacao.model.Usuario;

public interface UsuarioService {
	public boolean cadastrar(Usuario usuario);

	public boolean editar(Usuario usuario);

	public boolean excluir(Usuario usuario);

	public List<UsuarioEntity> listarUsuarios();

	public Usuario buscarUsuarioPorId(long idUsuario);

	public Usuario buscarUsuarioPorLogin(String username);
}