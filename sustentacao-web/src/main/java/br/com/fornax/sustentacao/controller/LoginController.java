package br.com.fornax.sustentacao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private ModelAndView mav = new ModelAndView();

	@RequestMapping("/acesso")
	public ModelAndView Longin(HttpServletRequest request) {
		mav.setViewName("acesso");

		return mav;
	}

	@RequestMapping("/painel")
	public ModelAndView Painel() {
		mav.setViewName("painel");

		return mav;
	}

	@RequestMapping("/painel/exibir-perfil")
	public ModelAndView Usuario() {
		mav.setViewName("usuario");

		return mav;
	}

	@RequestMapping("/painel/tarefas")
	public ModelAndView Tarefa() {
		mav.setViewName("tarefa");

		return mav;
	}

	@RequestMapping("/painel/apontamentos")
	public ModelAndView Apontamento() {
		mav.setViewName("apontamento");

		return mav;
	}
}