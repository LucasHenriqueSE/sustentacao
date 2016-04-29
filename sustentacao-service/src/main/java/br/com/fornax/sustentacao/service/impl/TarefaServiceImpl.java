package br.com.fornax.sustentacao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TarefaDAO;
import br.com.fornax.sustentacao.dao.TipoTarefaDAO;
import br.com.fornax.sustentacao.dao.entity.TarefaEntity;
import br.com.fornax.sustentacao.model.Status;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.model.TipoTarefa;
import br.com.fornax.sustentacao.service.ParseService;
import br.com.fornax.sustentacao.service.TarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TarefaServiceImpl implements TarefaService {

	@Inject
	private TarefaDAO tarefaDao;
	
	@Inject
	private TipoTarefaDAO tipoTarefaDao;

	@Inject
	private ParseService parse;

	private static final long CODIGO_STATUS_TAREFA_ABERTO = 1;

	@Override
	public boolean cadastrarTarefa(Tarefa tarefa) {
		tarefa.setStatus(new Status(CODIGO_STATUS_TAREFA_ABERTO));
		TipoTarefa tipo =  parse.parseToModel(tipoTarefaDao.buscarPorId(tarefa.getTipo().getId()));
		tarefa.setQtdHorasDisponiveis(tipo.getQtdHoras());
		tarefaDao.inserir(parse.parseToEntity(tarefa));

		return true;
	}

	@Override
	public boolean editarTarefa(Tarefa tarefa) {
//		TipoTarefa tipo = parse.parseToModel(tipoTarefaDao.buscarPorId(tarefa.getTipo().getId()));
//		tarefa.setQtdHorasDisponiveis(tipo.getQtdHoras());
		tarefa.setDataEdicao(Calendar.getInstance());
		tarefaDao.editar(parse.parseToEntity(tarefa));
		return true;
	}

	@Override
	public boolean excluirTarefa(Tarefa tarefa) {
		tarefaDao.excluir(parse.parseToEntity(tarefa));
		return true;
	}

	@Override
	public List<Tarefa> listarTarefas() {
		List<TarefaEntity> lista = tarefaDao.listarTudo();
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		for (TarefaEntity tarefa : lista) {
			tarefas.add(parse.parseToModel(tarefa));
		}
		return tarefas;
	}

	@Override
	public Tarefa buscarTarefaPorId(long idTarefa) {
		return (Tarefa) parse.parseToModel(tarefaDao.buscarPorId(idTarefa));
	}

	@Override
	public List<Tarefa> listarTarefasDoUsuario(String username) {
		List<TarefaEntity> lista = tarefaDao.listarTarefasDoUsuario(username);
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		for(TarefaEntity tarefa : lista){
			tarefas.add(parse.parseToModel(tarefa));
		}
		return tarefas;
	}

//	@Override
//	public List<Tarefa> buscarTarefaPorTipo(long idTipoTarefa) {
//		List<TarefaEntity> lista = tarefaDao.buscarTarefaPorTipo(idTipoTarefa);
//		List<Tarefa> tarefas = new ArrayList<Tarefa>();
//		for (TarefaEntity tarefa : lista) {
//			tarefas.add(parse.parseToModel(tarefa));
//		}
//		return tarefas;
//	}
}