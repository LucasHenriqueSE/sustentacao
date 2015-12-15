package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TarefaDAO;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.service.TarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TarefaServiceImpl implements TarefaService {

	@Inject
	private TarefaDAO dao;

	@Override
	public boolean cadastrarTarefa(Tarefa tarefa) {
		dao.inserir(tarefa);
		return true;
	}

	@Override
	public boolean editarTarefa(Tarefa tarefa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirTarefa(Tarefa tarefa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> listarTarefa(String query) {
		dao.listarTudo("select tarefa from Tarefa tarefa where tarefa.tipo.id = :idTipoTarefa");
		return null;
	}

	@Override
	public Tarefa buscarTarefaPorId(Tarefa tarefa, long idTarefa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> buscarTarefaPorTipo(long idTipoTarefa) {
		// TODO Auto-generated method stub
		return null;
	}

}
