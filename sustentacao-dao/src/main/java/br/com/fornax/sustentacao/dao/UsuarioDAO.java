package br.com.fornax.sustentacao.dao;

import java.util.List;

import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;

public interface UsuarioDAO {
	public void inserir(UsuarioEntity usuario);

	public void editar(UsuarioEntity usuario);

	public void excluir(UsuarioEntity usuario);

	public List<UsuarioEntity> listarTudo();

	public UsuarioEntity buscarPorId(long idUsuario);

	public UsuarioEntity buscarUsuarioPorLogin(String username);
}