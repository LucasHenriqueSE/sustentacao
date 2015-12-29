package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Usuario;
import br.com.fornax.sustentacao.service.UsuarioService;

@Controller
public class UsuarioController {
	private ModelAndView mav;
	
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping("/painel/listar-usuarios/cadastrar-usuario")
	public ModelAndView viewCadastrarUsuario() {
		mav = new ModelAndView();
		this.mav.setViewName("usuario");

		return mav;
	}
	
	@RequestMapping("/painel/listar-usuarios/cadastrar")
	public String cadastrar(Usuario usuario){
		usuarioService.cadastrar(usuario);
		return "usuario";
	}
}