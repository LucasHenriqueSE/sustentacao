package br.com.fornax.sustentacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.TipoTarefaDAO;
import br.com.fornax.sustentacao.dao.entity.TipoTarefaEntity;
import br.com.fornax.sustentacao.model.TipoTarefa;
import br.com.fornax.sustentacao.service.ParseService;
import br.com.fornax.sustentacao.service.TipoTarefaService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TipoTarefaServiceImpl implements TipoTarefaService {

	@Inject
	private TipoTarefaDAO tipoTarefaDao;

	@Inject
	private ParseService parse;

	@Override
	public List<TipoTarefa> listarTipoTarefa() {
		List<TipoTarefaEntity> lista = tipoTarefaDao.listarTudo();
		List<TipoTarefa> tiposTarefa = new ArrayList<TipoTarefa>();
		for (TipoTarefaEntity tipo : lista) {
			tiposTarefa.add(parse.parseToModel(tipo));
		}
		return tiposTarefa;
	}
}
