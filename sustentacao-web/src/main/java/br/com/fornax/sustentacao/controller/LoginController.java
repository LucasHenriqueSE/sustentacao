package br.com.fornax.sustentacao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String login(HttpServletRequest request) {

		/**
		 * VERIFICA SE EXISTE SESSAO PARA O USUARIO, CASO EXISTA REDIRECIONA
		 * PARA O PAINEL, SENAO VAI PARA TELA DE LOGIN
		 */
		if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
			return "redirect:/painel";
		}else{
			request.getSession().invalidate();
			request.getSession().removeAttribute("usuario");
		}
		return "acesso";
	}
}