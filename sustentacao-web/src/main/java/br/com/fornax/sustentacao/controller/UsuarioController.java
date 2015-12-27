package br.com.fornax.sustentacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
	private ModelAndView mav;
	
	@RequestMapping("/painel/exibir-perfil")
	public ModelAndView usuario() {
		mav = new ModelAndView();
		this.mav.setViewName("usuario");

		return mav;
	}
}
