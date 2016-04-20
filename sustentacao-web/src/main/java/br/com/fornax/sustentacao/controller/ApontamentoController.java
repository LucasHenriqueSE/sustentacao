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
	public ModelAndView listar() {
		mav = new ModelAndView("listar-apontamentos");
		this.mav.addObject("apontamentos", apontamentoService.listarApontamentos());

		return mav;
	}

	@RequestMapping("painel/tarefa/{idTarefa}/apontar")
	public ModelAndView viewCadastrar(@PathVariable("idTarefa") long idTarefa) {
		mav = new ModelAndView("cadastrar-apontamento");
		return mav;
	}

	@RequestMapping("/painel/tarefa/cadastrar-apontamento")
	public String cadastrar(Apontamento apontamento) {
		apontamentoService.cadastrarApontamento(apontamento);
		return "redirect:/painel/apontamentos";
	}

	@RequestMapping("/painel/apontamento/{idApontamento}/editar-apontamento")
	public ModelAndView viewEditar(@PathVariable("idApontamento") long idApontamento, Apontamento apontamento) {
		apontamento = apontamentoService.buscarApontamentoPorId(idApontamento);
		mav = new ModelAndView("editar-apontamento");

		this.mav.addObject("apontamento", apontamento);
		return mav;
	}

	@RequestMapping("/painel/apontamento/editar")
	public String editar(Apontamento apontamento) {
		apontamentoService.editarApontamento(apontamento);
		
		return "redirect:/painel/apontamentos";
	}

	@ResponseBody
	@RequestMapping("validarHoraInicioFim")
	public boolean validarHoraInicioFim(String horaInicio, String horaTermino, long idTarefa) {
		return apontamentoService.validarHoraInicioFim(horaInicio, horaTermino, idTarefa);
	}
}