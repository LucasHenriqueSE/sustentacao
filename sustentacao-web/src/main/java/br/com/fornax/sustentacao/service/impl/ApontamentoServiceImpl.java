package br.com.fornax.sustentacao.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.ApontamentoDAO;
import br.com.fornax.sustentacao.dao.TarefaDAO;
import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.ApontamentoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoDAO apontamentoDAO;

	@Inject
	private TarefaDAO tarefaDAO;

	@Override
	public boolean cadastrarApontamento(Apontamento apontamento) {
		List<Apontamento> lista = apontamentoDAO.listarApontamentoDoDia(apontamento.getDataApontamento(),
				apontamento.getHoraInicio(), apontamento.getHoraTermino());

		if (lista.isEmpty()) {
			Tarefa tarefa = (Tarefa) tarefaDAO.buscarPorId(apontamento.getTarefa(), apontamento.getTarefa().getId());
			int horasTrabalhadas = calcularHorasTrabalhadas(apontamento.getHoraTermino(), apontamento.getHoraInicio());
			if (tarefa.getQtdHorasDisponiveis() - horasTrabalhadas >= 0) {
				tarefa.setQtdHorasDisponiveis(tarefa.getQtdHorasDisponiveis() - horasTrabalhadas);
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

	public int calcularHorasTrabalhadas(Calendar hora1, Calendar hora2) {
		int horasTrabalhadas = (hora1.get(Calendar.HOUR_OF_DAY) - hora2.get(Calendar.HOUR_OF_DAY));
		return horasTrabalhadas;
	}
}