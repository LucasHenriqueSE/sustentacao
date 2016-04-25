package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.service.UsuarioService;

@Controller
@SessionAttributes(value = { "usuario" })
public class PainelController {
	private ModelAndView mav = new ModelAndView();

	@Inject
	private UsuarioService usuarioService;

	@RequestMapping("/painel")
	public ModelAndView painel(HttpServletRequest req, Model model) {
		this.mav.clear();
		mav.setViewName("403");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/** VERIFICA PERFIL DO USUARIO LOGADO */
		for (GrantedAuthority g : user.getAuthorities()) {
			boolean valido = verificaPerfil(g.getAuthority(), mav);
			if (valido) {
				break;
			}else{
				req.getSession().invalidate();
			}
		}
		/** SETA DADOS DO USUARIO NA SESSAO */
		if (!model.containsAttribute("usuario")) {
			model.addAttribute("usuario", usuarioService.buscarUsuarioPorLogin(user.getUsername()));
		}
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/";
	}

	private boolean verificaPerfil(String perfil, ModelAndView mav) {
		boolean valido = false;
		if (perfil.equals("Administrador") || perfil.equals("Usuario")) {
			this.mav.setViewName("painel");
			valido = true;
		}
		return valido;
	}
}