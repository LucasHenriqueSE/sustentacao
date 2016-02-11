package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Usuario;
import br.com.fornax.sustentacao.service.PerfilService;
import br.com.fornax.sustentacao.service.UsuarioService;

@Controller
public class UsuarioController {
	private ModelAndView mav;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private PerfilService perfilService;
	
	
	@RequestMapping("painel/cadastrar-usuario")
	public ModelAndView viewCadastrarUsuario() {
		mav = new ModelAndView("usuario");
		mav.addObject("perfil", perfilService.listarPerfis());
		return mav;
	}
	
	@RequestMapping("painel/cadastrar")
	public String cadastrar(Usuario usuario){
		usuarioService.cadastrar(usuario);
		return "";
	}
}