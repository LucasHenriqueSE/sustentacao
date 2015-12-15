package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Tarefa;
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

	@RequestMapping("/acesso")
	public ModelAndView login(HttpServletRequest request) {
		mav.setViewName("acesso");

		return mav;
	}

	@RequestMapping("/painel")
	public ModelAndView painel() {
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
//		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
//		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}

	@RequestMapping("/painel/tarefas/cadastrar-tarefas")
	public ModelAndView ViewCadastroTarefa() {
		mav = new ModelAndView();

		this.mav.setViewName("cadastrar-tarefas");
		this.mav.addObject("tipo", tipoTarefaService.listarTipoTarefa());
		this.mav.addObject("status", statusService.listarStatus());

		return mav;
	}
	
	public String cadastrarTarefa(Tarefa tarefa){
		tarefaService.cadastrarTarefa(tarefa);
		return "/painel/tarefas";
	}

	@RequestMapping("/painel/apontamentos")
	public ModelAndView apontamento() {
		mav.setViewName("apontamento");

		return mav;
	}

	@RequestMapping("/painel/apontamentos/cadastrar-apontamento")
	public ModelAndView cadastrarApontamento() {
		mav.setViewName("cadastrar-apontamentos");

		return mav;
	}
}