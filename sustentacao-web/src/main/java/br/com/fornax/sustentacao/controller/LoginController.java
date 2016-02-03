package br.com.fornax.sustentacao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/acesso")
public class LoginController {
	private ModelAndView mav;

	@RequestMapping
	public ModelAndView login(HttpServletRequest request) {
		mav.setViewName("acesso");

		return mav;
	}
}