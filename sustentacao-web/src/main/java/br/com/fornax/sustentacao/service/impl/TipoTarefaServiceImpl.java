package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TipoTarefaDAO;
import br.com.fornax.sustentacao.model.TipoTarefa;
import br.com.fornax.sustentacao.service.TipoTarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoTarefaServiceImpl implements TipoTarefaService {

	@Inject
	private TipoTarefaDAO dao;

	@Override
	public boolean cadastrarTipoTarefa(TipoTarefa tipoTarefa) {
		dao.inserir(tipoTarefa);
		return false;
	}

	@Override
	public boolean editarTipoTarefa(TipoTarefa tipoTarefa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarTipoTarefa(TipoTarefa tipoTarefa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> listarTipoTarefa() {
		return dao.listarTudo();
	}

}
