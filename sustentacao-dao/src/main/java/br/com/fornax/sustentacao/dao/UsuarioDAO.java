package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;

public interface UsuarioDAO {
	void inserir(Object usuario);

	void editar(Object usuario);

	void excluir(Object usuario);

	List<UsuarioEntity> listarTudo();

	Object buscarPorId(Object Usuario, long idUsuario);

	Object buscarUsuarioPorLogin(String username);
}