package br.com.fornax.sustentacao.controller;

import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.ApontamentoService;
import br.com.fornax.sustentacao.service.TarefaService;
import br.com.fornax.sustentacao.service.UsuarioService;

@Controller
public class ApontamentoController {
	private User user;

	private ModelAndView mav;

	@Inject
	private ApontamentoService apontamentoService;

	@Inject
	private UsuarioService usuarioService;

	@Inject
	private TarefaService tarefaService;

	@RequestMapping("/painel/apontamentos")
	public ModelAndView listar() {
		mav = new ModelAndView("listar-apontamentos");
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user.getAuthorities().toString().contains("Administrador")) {
			this.mav.addObject("apontamentos", apontamentoService.listarApontamentos());
		} else {
			this.mav.addObject("apontamentos", apontamentoService.listarApontamentosDoUsuario(user.getUsername()));
		}
		return mav;
	}

	@RequestMapping("painel/tarefa/{idTarefa}/apontar")
	public ModelAndView viewCadastrar(@PathVariable("idTarefa") long idTarefa) {
		Tarefa tarefa = tarefaService.buscarTarefaPorId(idTarefa);
		mav = new ModelAndView("403");
		if (user.getUsername().equals(tarefa.getUsuario().getEmail())
				|| user.getAuthorities().toString().contains("Administrador")) {
			this.mav.setViewName("cadastrar-apontamento");
		}
		return mav;
	}

	@RequestMapping("/painel/tarefa/cadastrar-apontamento")
	public String cadastrar(Apontamento apontamento) {
		apontamento.setUsuario(usuarioService.buscarUsuarioPorLogin(user.getUsername()));
		apontamentoService.cadastrarApontamento(apontamento);
		return "redirect:/painel/apontamentos";
	}

	@RequestMapping("/painel/apontamento/{idApontamento}/editar-apontamento")
	public ModelAndView viewEditar(@PathVariable("idApontamento") long idApontamento, Apontamento apontamento) {
		apontamento = apontamentoService.buscarApontamentoPorId(idApontamento);
		mav = new ModelAndView("403");
		if (user.getUsername().equals(apontamento.getUsuario().getEmail())
				|| user.getAuthorities().toString().contains("Administrador")) {
			if (!apontamento.getEnviadoParaAprovacao()) {
				this.mav.setViewName("editar-apontamento");
			}
		}
		this.mav.addObject("apontamento", apontamento);
		return mav;
	}

	@RequestMapping("/painel/apontamento/editar")
	public String editar(Apontamento apontamento) {
		apontamentoService.editarApontamento(apontamento);

		return "redirect:/painel/apontamentos";
	}

	@RequestMapping("/painel/apontamento/{idApontamento}/enviarApontamento")
	public String enviarApontamento(@PathVariable Long idApontamento) {
		apontamentoService.enviarApontamento(idApontamento);
		return "redirect:/painel/apontamentos";
	}

	@ResponseBody
	@RequestMapping("validarHoraInicioFim")
	public boolean validarHoraInicioFim(String horaInicio, String horaTermino, long idTarefa) {
		return apontamentoService.validarHoraInicioFim(horaInicio, horaTermino, idTarefa);
	}
}