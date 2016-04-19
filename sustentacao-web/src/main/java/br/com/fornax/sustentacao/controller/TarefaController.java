package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.StatusService;
import br.com.fornax.sustentacao.service.TarefaService;
import br.com.fornax.sustentacao.service.TipoTarefaService;

@Controller
public class TarefaController {
	private static final String LISTA_TAREFAS = "/painel/tarefas";
	
	private ModelAndView mav;

	@Inject
	private TarefaService tarefaService;

	@Inject
	private TipoTarefaService tipoTarefaService;

	@Inject
	private StatusService statusService;
	
	@RequestMapping(LISTA_TAREFAS)
	public ModelAndView listar() {
		mav = new ModelAndView("listar-tarefas");
		this.mav.addObject("tarefas", tarefaService.listarTarefa());
		return mav;
	}

	@RequestMapping("/painel/tarefa/cadastrar-tarefa")
	public ModelAndView viewCadastrarTarefa() {
		mav = new ModelAndView("cadastrar-tarefa");
		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}

	@RequestMapping("/painel/tarefa/cadastrar")
	public String cadastrar(@Validated Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:" + this;
		}
		tarefaService.cadastrarTarefa(tarefa);
		return "redirect:" + LISTA_TAREFAS;
	}

	@RequestMapping("/painel/tarefa/{idTarefa}/editar-tarefa")
	public ModelAndView viewEditarTarefa(@PathVariable("idTarefa") long idTarefa, Tarefa tarefa) {
		mav = new ModelAndView("editar-tarefa");
		this.mav.addObject("tarefa", tarefaService.buscarTarefaPorId(tarefa, idTarefa));
		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}

	@RequestMapping("/painel/tarefa/editar")
	public String editar(@Validated Tarefa tarefa) {
		tarefaService.editarTarefa(tarefa);
		return "redirect:" + LISTA_TAREFAS;
	}
}