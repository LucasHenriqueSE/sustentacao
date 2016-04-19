package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.UsuarioDAO;
import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;
import br.com.fornax.sustentacao.model.Usuario;
import br.com.fornax.sustentacao.service.ParseService;
import br.com.fornax.sustentacao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioDAO usuarioDao;

	@Inject
	private PasswordEncoder passwordEncoder;

	@Inject
	private ParseService parse;

	@Override
	public boolean cadastrar(Usuario usuario) {
		try {
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			usuarioDao.inserir(parse.parseToEntity(usuario));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean editar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioDao.editar(parse.parseToEntity(usuario));
		return true;
	}

	@Override
	public boolean excluir(Usuario usuario) {
		usuarioDao.excluir(parse.parseToEntity(usuario));
		return true;
	}

	@Override
	public List<UsuarioEntity> listarUsuarios() {
		return usuarioDao.listarTudo();
	}

	@Override
	public Usuario buscarUsuarioPorId(long idUsuario) {
		return parse.parseToModel(usuarioDao.buscarPorId(idUsuario));
	}

	@Override
	public Usuario buscarUsuarioPorLogin(String username) {
		return parse.parseToModel(usuarioDao.buscarUsuarioPorLogin(username));
	}
}