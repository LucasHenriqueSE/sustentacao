package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.service.ApontamentoService;

@Controller
public class ApontamentoController {
	private ModelAndView mav;
	
	@Inject
	private ApontamentoService apontamentoService;

	@RequestMapping("/painel/apontamentos")
	public ModelAndView listarApontamentos() {
		mav = new ModelAndView();
		mav.setViewName("apontamento");
		this.mav.addObject("apontamentos", apontamentoService.listarApontamentos());

		return mav;
	}

	@RequestMapping("/painel/tarefa/{idTarefa}/apontar")
	public ModelAndView cadastrarApontamento(@PathVariable("idTarefa") long idTarefa) {
		mav = new ModelAndView();
		this.mav.setViewName("cadastrar-apontamentos");

		return mav;
	}

	@RequestMapping("/painel/apontamentos/cadastrar-apontamento")
	public String apontar(Apontamento apontamento) {
		apontamentoService.cadastrarApontamento(apontamento);
		return "cadastrar-apontamentos";
	}
	
	@ResponseBody
	@RequestMapping("validarHoraInicioFim")
	public boolean validarHoraInicioFim(String horaInicio, String horaTermino, long idTarefa){
		return apontamentoService.validarHoraInicioFim(horaInicio, horaTermino, idTarefa);
	}
}