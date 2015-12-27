package br.com.fornax.sustentacao.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.ApontamentoDAO;
import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.ApontamentoService;
import br.com.fornax.sustentacao.service.TarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoDAO apontamentoDAO;

	@Inject
	private TarefaService tarefaService;

	@Override
	public boolean cadastrarApontamento(Apontamento apontamento) {
		List<Apontamento> lista = apontamentoDAO.listarApontamentoDoDia(apontamento.getDataApontamento(),
				apontamento.getHoraInicio(), apontamento.getHoraTermino());

		if (lista.isEmpty()) {
			Tarefa tarefa = (Tarefa) tarefaService.buscarTarefaPorId(apontamento.getTarefa(), apontamento.getTarefa().getId());
			double horasTrabalhadas = calcularHorasTrabalhadas(apontamento.getHoraTermino(), apontamento.getHoraInicio());
			if (tarefa.getQtdHorasDisponiveis() - horasTrabalhadas >= 0) {
				tarefa.setQtdHorasDisponiveis((long) (tarefa.getQtdHorasDisponiveis() - horasTrabalhadas));
				apontamento.setDataCadastro(Calendar.getInstance());
				apontamentoDAO.inserir(apontamento);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean editarApontamento(Apontamento apontamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirApontamento(Apontamento apontamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> listarApontamentos() {
		return apontamentoDAO.listarTudo();
	}

	@Override
	public Object buscarApontamentoPorId(Apontamento apontamento, long idApontamento) {
		// TODO Auto-generated method stub
		return null;
	}

	private double calcularHorasTrabalhadas(Calendar horaTermino, Calendar horaInicio) {
		double minutos = 0;
		double total = 0;
		long horasTrabalhadas = (horaTermino.getTimeInMillis() - horaInicio.getTimeInMillis());
		double qtdHoras = (horasTrabalhadas / 3600000);
		double qtdMinutos = (horasTrabalhadas % 3600000);
		if (qtdMinutos > 0) {
			minutos = (qtdMinutos / 60000);
			total = minutos / 100;
		}
		return qtdHoras + total;
	}

	@Override
	public boolean validarHoraInicioFim(String horaInicio, String horaFim, long idTarefa) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			Date date1 = sdf.parse(horaInicio);
			Date date2 = sdf.parse(horaFim);
			
			Calendar h1 = Calendar.getInstance();
			Calendar h2 = Calendar.getInstance();
			h1.setTime(date1);
			h2.setTime(date2);
			
			double horasTrabalhadas = calcularHorasTrabalhadas(h2, h1);
			Tarefa tarefa = (Tarefa) tarefaService.buscarTarefaPorId(new Tarefa(), idTarefa);
			if(tarefa.getQtdHorasDisponiveis() < horasTrabalhadas){
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
}