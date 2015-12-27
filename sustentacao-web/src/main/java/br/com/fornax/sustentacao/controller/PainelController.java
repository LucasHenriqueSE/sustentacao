package br.com.fornax.sustentacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PainelController {
	private ModelAndView mav;

	@RequestMapping("/painel")
	public ModelAndView painel() {
		mav = new ModelAndView();
		this.mav.setViewName("painel");

		return mav;
	}
}