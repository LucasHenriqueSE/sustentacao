package br.com.fornax.sustentacao.dao;

import java.util.List;

public interface UsuarioDAO {
	void inserir(Object usuario);

	void editar(Object usuario);

	void excluir(Object usuario);

	List<Object> listarTudo();

	Object buscarPorId(Object Usuario, long idUsuario);
}