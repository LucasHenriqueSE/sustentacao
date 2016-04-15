package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.UsuarioDAO;
import br.com.fornax.sustentacao.model.Usuario;
import br.com.fornax.sustentacao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioServiceImpl implements UsuarioService{

	@Inject
	private UsuarioDAO usuarioDao;
	
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean cadastrar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioDao.inserir(usuario);
		return true;
	}

	@Override
	public boolean editar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioDao.editar(usuario);
		return true;
	}

	@Override
	public boolean excluir(Usuario usuario) {
		usuarioDao.excluir(usuario);
		return true;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.listarTudo();
	}

	@Override
	public Object buscarUsuarioPorId(Usuario usuario, long idUsuario) {
		return usuarioDao.buscarPorId(usuario, idUsuario);
	}

	@Override
	public Object buscarUsuarioPorLogin(String username) {
		return usuarioDao.buscarUsuarioPorLogin(username);
	}
}