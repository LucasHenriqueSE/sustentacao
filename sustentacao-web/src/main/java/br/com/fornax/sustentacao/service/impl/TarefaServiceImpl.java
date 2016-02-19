package br.com.fornax.sustentacao.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TarefaDAO;
import br.com.fornax.sustentacao.model.Status;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.model.TipoTarefa;
import br.com.fornax.sustentacao.service.TarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TarefaServiceImpl implements TarefaService {
	
	@Inject
	private TarefaDAO tarefaDao;
	
	private static final long CODIGO_STATUS_TAREFA_ABERTO = 1;
	
	@Override
	public boolean cadastrarTarefa(Tarefa tarefa) {
			tarefa.setStatus(new Status(CODIGO_STATUS_TAREFA_ABERTO));
			TipoTarefa tipo = (TipoTarefa) tarefaDao.buscarPorId(new TipoTarefa(), tarefa.getTipo().getId());
			tarefa.setQtdHorasDisponiveis(tipo.getQtdHoras());
			tarefaDao.inserir(tarefa);
			
			return true;
	}

	@Override
	public boolean editarTarefa(Tarefa tarefa) {
		tarefa.setDataEdicao(Calendar.getInstance());
		tarefaDao.editar(tarefa);
		return true;
	}

	@Override
	public boolean excluirTarefa(Tarefa tarefa) {
		tarefaDao.excluir(tarefa);
		return true;
	}

	@Override
	public List<Object> listarTarefa() {
		return tarefaDao.listarTudo();
	}

	@Override
	public Tarefa buscarTarefaPorId(Tarefa tarefa, long idTarefa) {
		return (Tarefa) tarefaDao.buscarPorId(tarefa, idTarefa);
	}

	@Override
	public List<Object> buscarTarefaPorTipo(long idTipoTarefa) {
		return tarefaDao.buscarTarefaPorTipo(idTipoTarefa);
	}
}