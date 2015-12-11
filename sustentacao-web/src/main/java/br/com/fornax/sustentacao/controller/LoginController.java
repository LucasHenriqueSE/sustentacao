package br.com.fornax.sustentacao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private ModelAndView mav = new ModelAndView();

	@RequestMapping("/acesso")
	public ModelAndView login(HttpServletRequest request) {
		mav.setViewName("acesso");

		return mav;
	}

	@RequestMapping("/painel")
	public ModelAndView painel() {
		mav.setViewName("painel");

		return mav;
	}

	@RequestMapping("/painel/exibir-perfil")
	public ModelAndView usuario() {
		mav.setViewName("usuario");

		return mav;
	}

	@RequestMapping("/painel/tarefas")
	public ModelAndView listarTarefas() {
		mav.setViewName("listar-tarefas");

		return mav;
	}
	
	@RequestMapping("/painel/tarefas/cadastrar-tarefas")
	public ModelAndView cadastrarTarefa(){
		mav.setViewName("cadastrar-tarefas");
		
		return mav;
	}

	@RequestMapping("/painel/apontamentos")
	public ModelAndView apontamento() {
		mav.setViewName("apontamento");

		return mav;
	}
	
	@RequestMapping("/painel/apontamentos/cadastrar-apontamento")
	public ModelAndView cadastrarApontamento(){
		mav.setViewName("cadastrar-apontamentos");
		
		return mav;
	}
}