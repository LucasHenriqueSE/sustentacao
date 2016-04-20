package br.com.fornax.sustentacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.StatusDAO;
import br.com.fornax.sustentacao.dao.entity.StatusEntity;
import br.com.fornax.sustentacao.model.Status;
import br.com.fornax.sustentacao.service.ParseService;
import br.com.fornax.sustentacao.service.StatusService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StatusServiceImpl implements StatusService{

	@Inject
	private StatusDAO dao;
	
	@Inject
	private ParseService parse;
	
	@Override
	public List<Status> listarStatus() {
		List<StatusEntity> lista = dao.listarTudo();
		List<Status> status = new ArrayList<Status>();
		for(StatusEntity s : lista){
			status.add(parse.parseToModel(s));
		}
		return status;
	}
}