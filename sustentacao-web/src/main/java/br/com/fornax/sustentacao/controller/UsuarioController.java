package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("painel/usuarios")
	public ModelAndView listar(){
		mav = new ModelAndView("lista-usuarios");
		this.mav.addObject("usuarios", usuarioService.listarUsuarios());
		
		return mav;
	}
	
	
	@RequestMapping("painel/usuario/cadastrar-usuario")
	public ModelAndView viewCadastrar() {
		mav = new ModelAndView("usuario");
		this.mav.addObject("usuarios", usuarioService.listarUsuarios());
		this.mav.addObject("perfil", perfilService.listarPerfis());
		
		return mav;
	}
	
	@RequestMapping("painel/usuario/cadastrar")
	public String cadastrar(Usuario usuario){
		usuarioService.cadastrar(usuario);
		return "redirect:/painel/usuarios";
	}
	
	@RequestMapping("painel/usuario/{idUsuario}/editar-usuario")
	public ModelAndView viewEditar(Usuario usuario, @PathVariable("idUsuario") long idUsuario){
		mav = new ModelAndView("editar-usuario");
		this.mav.addObject("usuario", usuarioService.listarUsuarios());
		this.mav.addObject("perfil", perfilService.listarPerfis());
		
		return mav;
	}
	
	@RequestMapping("painel/usuario/editar")
	public String editar(Usuario usuario){
		usuarioService.editar(usuario);
		return "redirect:/painel/usuarios";
	}
}