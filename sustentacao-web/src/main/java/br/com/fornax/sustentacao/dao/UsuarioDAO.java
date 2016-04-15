package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.model.Usuario;

public interface UsuarioDAO {
	void inserir(Object usuario);

	void editar(Object usuario);

	void excluir(Object usuario);

	List<Usuario> listarTudo();

	Object buscarPorId(Object Usuario, long idUsuario);

	Object buscarUsuarioPorLogin(String username);
}