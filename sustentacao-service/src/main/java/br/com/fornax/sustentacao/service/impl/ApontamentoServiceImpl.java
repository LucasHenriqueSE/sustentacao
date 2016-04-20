package br.com.fornax.sustentacao.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.ApontamentoDAO;
import br.com.fornax.sustentacao.dao.entity.ApontamentoEntity;
import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.ApontamentoService;
import br.com.fornax.sustentacao.service.ParseService;
import br.com.fornax.sustentacao.service.TarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoDAO apontamentoDAO;

	@Inject
	private TarefaService tarefaService;

	@Inject
	ParseService parse;

	@Override
	public void cadastrarApontamento(Apontamento apontamento) {
		List<Apontamento> lista = apontamentosDoDia(apontamento);

		if (lista.isEmpty()) {
			String horasTrabalhadas = calcularHorasTrabalhadas(apontamento.getHoraTermino(),
					apontamento.getHoraInicio());
			Tarefa tarefa = tarefaService.buscarTarefaPorId(apontamento.getTarefa().getId());
			tarefa.setQtdHorasDisponiveis(calcularHoras(tarefa.getQtdHorasDisponiveis(), horasTrabalhadas));
			apontamento.setDataCadastro(Calendar.getInstance());
			tarefaService.editarTarefa(tarefa);
			apontamentoDAO.inserir(parse.parseToEntity(apontamento));
			
		}
	}

	@Override
	public boolean editarApontamento(Apontamento apontamento) {
		List<Apontamento> lista = apontamentosDoDia(apontamento);
		apontamento.setDataEdicao(Calendar.getInstance());
		if (!lista.isEmpty() && lista.size() == 1) {
			if (lista.get(0).getId() == apontamento.getId()) {
				apontamentoDAO.editar(parse.parseToEntity(apontamento));
			}
		} else if (lista.isEmpty()) {
			apontamentoDAO.editar(parse.parseToEntity(apontamento));
		}
		return false;
	}

	@Override
	public boolean excluirApontamento(Apontamento apontamento) {
		apontamentoDAO.excluir(parse.parseToEntity(apontamento));
		return true;
	}

	@Override
	public List<Apontamento> listarApontamentos() {
		List<ApontamentoEntity> lista = apontamentoDAO.listarTudo();
		List<Apontamento> apontamentos = new ArrayList<Apontamento>();
		for (ApontamentoEntity apontamento : lista) {
			apontamentos.add(parse.parseToModel(apontamento));
		}
		return apontamentos;
	}

	@Override
	public Apontamento buscarApontamentoPorId(long idApontamento) {
		return parse.parseToModel(apontamentoDAO.buscarPorId(idApontamento));
	}

	private String calcularHorasTrabalhadas(Calendar horaTermino, Calendar horaInicio) {
		double minutos = 0;
		double total = 0;
		String retorno;
		long horasTrabalhadas = (horaTermino.getTimeInMillis() - horaInicio.getTimeInMillis());
		double qtdHoras = (horasTrabalhadas / 3600000);
		double qtdMinutos = (horasTrabalhadas % 3600000);
		if (qtdMinutos > 0) {
			minutos = (qtdMinutos / 60000);
			total = minutos / 100;
		}
		if (qtdHoras < 10) {
			retorno = "0" + Double.valueOf(qtdHoras).intValue();
		} else {
			retorno = Integer.valueOf(Double.valueOf(qtdHoras).intValue()).toString();
		}
		if (total == 0) {
			return retorno + ":" + Double.valueOf(total).toString().substring(2) + "0";
		}

		return retorno + ":" + Double.valueOf(total).toString().substring(2);
	}

	@Override
	public boolean validarHoraInicioFim(String horaInicio, String horaFim, long idTarefa) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Tarefa tarefa = (Tarefa) tarefaService.buscarTarefaPorId(idTarefa);
		try {
			Date date1 = sdf.parse(horaInicio);
			Date date2 = sdf.parse(horaFim);

			Calendar h1 = Calendar.getInstance();
			Calendar h2 = Calendar.getInstance();
			h1.setTime(date1);
			h2.setTime(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String qtdHorasDisponiveis = tarefa.getQtdHorasDisponiveis();
		String horasTrabalhadas = calcularHoras(horaFim, horaInicio);

		int segundosDisponiveis = 0;
		int segundosTrabalhados = 0;
		if (qtdHorasDisponiveis.substring(3, 4).equals(":")) {
			segundosDisponiveis = (Integer.parseInt(qtdHorasDisponiveis.substring(0, 3)) * 3600)
					+ (Integer.parseInt(qtdHorasDisponiveis.substring(4, 6)) * 60);
		} else if (qtdHorasDisponiveis.substring(2, 3).equals(":")) {
			segundosDisponiveis = (Integer.parseInt(qtdHorasDisponiveis.substring(0, 2)) * 3600)
					+ (Integer.parseInt(qtdHorasDisponiveis.substring(3, 5)) * 60);
		}
		if (horasTrabalhadas.substring(3, 4).equals(":")) {
			segundosTrabalhados = (Integer.parseInt(horasTrabalhadas.substring(0, 3)) * 3600)
					+ (Integer.parseInt(horasTrabalhadas.substring(4, 6)) * 60);
		} else if (horasTrabalhadas.substring(2, 3).equals(":")) {
			segundosTrabalhados = (Integer.parseInt(horasTrabalhadas.substring(0, 2)) * 3600)
					+ (Integer.parseInt(horasTrabalhadas.substring(3, 5)) * 60);
		}

		if (segundosTrabalhados > segundosDisponiveis) {
			return false;
		} else {
			return true;
		}
	}

	private String calcularHoras(String hora1, String hora2) {
		int segundos1 = 0;
		int segundos2 = 0;
		if (hora1.substring(3, 4).equals(":")) {
			segundos1 = (Integer.parseInt(hora1.substring(0, 3)) * 3600)
					+ (Integer.parseInt(hora1.substring(4, 6)) * 60);
		} else if (hora1.substring(2, 3).equals(":")) {
			segundos1 = (Integer.parseInt(hora1.substring(0, 2)) * 3600)
					+ (Integer.parseInt(hora1.substring(3, 5)) * 60);
		}
		if (hora2.substring(3, 4).equals(":")) {
			segundos2 = (Integer.parseInt(hora2.substring(0, 3)) * 3600)
					+ (Integer.parseInt(hora2.substring(4, 6)) * 60);
		} else if (hora2.substring(2, 3).equals(":")) {
			segundos2 = (Integer.parseInt(hora2.substring(0, 2)) * 3600)
					+ (Integer.parseInt(hora2.substring(3, 5)) * 60);
		}
		int sub = 0;
		int subHoras = 0;
		int subMinutos = 0;

		String horas = "00";
		String minutos = "00";

		if (segundos1 > segundos2) {
			sub = segundos1 - segundos2;
		} else if (segundos2 > segundos1) {
			sub = segundos2 - segundos1;
		} else {
			sub = 0;
		}

		if (sub >= 3600) {
			subHoras = (sub - (sub % 3600)) / 3600;
			sub = sub - (subHoras * 3600);
			if (subHoras < 10) {
				horas = "0" + Integer.toString(subHoras);
			} else {
				horas = Integer.toString(subHoras);
			}
		}
		if (sub >= 60) {
			subMinutos = (sub - (sub % 60)) / 60;
			sub = sub - (subMinutos * 60);
			if (subMinutos < 10) {
				minutos = "0" + Integer.toString(subMinutos);
			} else {
				minutos = Integer.toString(subMinutos);
			}
		}
		return horas + ":" + minutos;
	}

	private List<Apontamento> apontamentosDoDia(Apontamento apontamento) {
		List<ApontamentoEntity> lista = apontamentoDAO.listarApontamentoDoDia(apontamento.getDataApontamento(),
				apontamento.getHoraInicio(), apontamento.getHoraTermino());
		List<Apontamento> apontamentos = new ArrayList<Apontamento>();
		for (ApontamentoEntity a : lista) {
			apontamentos.add(parse.parseToModel(a));
		}
		return apontamentos;
	}
}