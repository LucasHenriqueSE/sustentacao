package br.com.fornax.sustentacao.service;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;
import br.com.fornax.sustentacao.model.Usuario;

public interface UsuarioService {
	boolean cadastrar(Usuario usuario);

	boolean editar(Usuario usuario);

	boolean excluir(Usuario usuario);

	List<UsuarioEntity> listarUsuarios();

	Object buscarUsuarioPorId(Usuario usuario, long idUsuario);

	Object buscarUsuarioPorLogin(String username);
}