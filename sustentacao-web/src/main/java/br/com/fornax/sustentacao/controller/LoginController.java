package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.ApontamentoService;
import br.com.fornax.sustentacao.service.StatusService;
import br.com.fornax.sustentacao.service.TarefaService;
import br.com.fornax.sustentacao.service.TipoTarefaService;

@Controller
public class LoginController {
	private ModelAndView mav;

	@Inject
	private TarefaService tarefaService;

	@Inject
	private TipoTarefaService tipoTarefaService;

	@Inject
	private StatusService statusService;

	@Inject
	private ApontamentoService apontamentoService;

	@RequestMapping("/acesso")
	public ModelAndView login(HttpServletRequest request) {
		mav.setViewName("acesso");

		return mav;
	}

	@RequestMapping("/painel")
	public ModelAndView painel() {
		mav = new ModelAndView();

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
		mav = new ModelAndView();
		this.mav.setViewName("listar-tarefas");
		this.mav.addObject("tarefas", tarefaService.listarTarefa());

		return mav;
	}

	@RequestMapping("/painel/tarefas/cadastrar")
	public ModelAndView ViewCadastroTarefa() {
		mav = new ModelAndView();

		this.mav.setViewName("cadastrar");
		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}

	@RequestMapping("/painel/tarefas/cadastrar-tarefa")
	public String cadastrarTarefa(Tarefa tarefa) {
		tarefaService.cadastrarTarefa(tarefa);
		return "cadastrar";
	}

	@RequestMapping("/painel/apontamentos")
	public ModelAndView listarApontamentos() {
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
}