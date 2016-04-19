package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.StatusDAO;
import br.com.fornax.sustentacao.service.StatusService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StatusServiceImpl implements StatusService{

	@Inject
	private StatusDAO dao;
	
	@Override
	public List<Object> listarStatus() {
		return dao.listarTudo();
	}
}