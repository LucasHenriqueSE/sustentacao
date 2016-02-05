package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
	public String cadastrar(@Validated Apontamento apontamento) {
		apontamentoService.cadastrarApontamento(apontamento);
		return "redirect: listar-apontamentos";
	}

	@RequestMapping("/painel/apontamento/{idApontamento}/editar-apontamento")
	public ModelAndView viewEditar(@PathVariable("idApontamento") long idApontamento, Apontamento apontamento) {
		apontamento = apontamentoService.buscarApontamentoPorId(new Apontamento(), idApontamento);
		mav = new ModelAndView("editar-apontamento");

		this.mav.addObject("data", apontamento.getDataApontamento());
		this.mav.addObject("apontamento", apontamento);
		this.mav.addObject("horaInicio", apontamento.formataHora(apontamento.getHoraInicio()));
		this.mav.addObject("horaTermino", apontamento.formataHora(apontamento.getHoraTermino()));
		
		return mav;
	}

	@RequestMapping("/painel/apontamento/{idApontamento}/editar")
	public String editar(@PathVariable("idApontamento") long idApontamento, @Validated Apontamento apontamento) {
		apontamento = apontamentoService.buscarApontamentoPorId(new Apontamento(), idApontamento);
		apontamentoService.editarApontamento(apontamento);
		
		return "listar-apontamentos";
	}

	@ResponseBody
	@RequestMapping("validarHoraInicioFim")
	public boolean validarHoraInicioFim(String horaInicio, String horaTermino, long idTarefa) {
		return apontamentoService.validarHoraInicioFim(horaInicio, horaTermino, idTarefa);
	}
}