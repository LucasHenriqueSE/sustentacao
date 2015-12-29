package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

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
	
	@Override
	public boolean cadastrar(Usuario usuario) {
		usuarioDao.inserir(usuario);
		return true;
	}

	@Override
	public boolean editar(Usuario usuario) {
		usuarioDao.editar(usuario);
		return true;
	}

	@Override
	public boolean excluir(Usuario usuario) {
		usuarioDao.excluir(usuario);
		return true;
	}

	@Override
	public List<Object> listarUsuarios() {
		return usuarioDao.listarTudo();
	}

	@Override
	public Object buscarUsuarioPorId(Usuario usuario, long idUsuario) {
		return usuarioDao.buscarPorId(usuario, idUsuario);
	}

}
