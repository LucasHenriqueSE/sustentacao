package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Usuario;
import br.com.fornax.sustentacao.service.UsuarioService;

@Controller
@RequestMapping("/painel/listar-usuarios")
public class UsuarioController {
	private ModelAndView mav;
	
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping("/cadastrar-usuario")
	public ModelAndView viewCadastrarUsuario() {
		mav = new ModelAndView("usuario");
		return mav;
	}
	
	@RequestMapping("/cadastrar")
	public String cadastrar(Usuario usuario){
		usuarioService.cadastrar(usuario);
		return "redirect: ";
	}
}