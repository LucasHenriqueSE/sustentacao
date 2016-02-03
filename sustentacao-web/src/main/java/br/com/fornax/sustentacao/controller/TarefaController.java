package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.StatusService;
import br.com.fornax.sustentacao.service.TarefaService;
import br.com.fornax.sustentacao.service.TipoTarefaService;

@Controller
public class TarefaController {
	private ModelAndView mav;

	@Inject
	private TarefaService tarefaService;

	@Inject
	private TipoTarefaService tipoTarefaService;

	@Inject
	private StatusService statusService;
	
	@RequestMapping
	public ModelAndView listar() {
		mav = new ModelAndView();
		this.mav.setViewName("listar-tarefas");
		this.mav.addObject("tarefas", tarefaService.listarTarefa());

		return mav;
	}

	@RequestMapping("/painel/tarefas/cadastrar-tarefa")
	public ModelAndView viewCadastrarTarefa() {
		mav = new ModelAndView();

		this.mav.setViewName("cadastrar-tarefa");
		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}

	@RequestMapping("/painel/tarefas/cadastrar")
	public String cadastrar(Tarefa tarefa) {
		tarefaService.cadastrarTarefa(tarefa);
		return "listar-tarefas";
	}

	@RequestMapping("/painel/tarefa/{idTarefa}/editar-tarefa")
	public ModelAndView viewEditarTarefa(@PathVariable("idTarefa") long idTarefa, Tarefa tarefa) {
		mav = new ModelAndView();

		this.mav.setViewName("editar-tarefa");
		this.mav.addObject("tarefa", tarefaService.buscarTarefaPorId(tarefa, idTarefa));
		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}

	@RequestMapping("/painel/tarefas/editar")
	public String editar(Tarefa tarefa) {
		tarefaService.editarTarefa(tarefa);
		return "listar-tarefas";
	}
}