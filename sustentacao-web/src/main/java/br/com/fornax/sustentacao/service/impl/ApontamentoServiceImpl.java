package br.com.fornax.sustentacao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.ApontamentoDAO;
import br.com.fornax.sustentacao.service.ApontamentoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ApontamentoServiceImpl implements ApontamentoService{

	@Inject
	private ApontamentoDAO dao;
	
	@Override
	public boolean cadastrarApontamento(Object entity) {
		dao.inserir(entity);
		return true;
	}

	@Override
	public boolean editarApontamento(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirApontamento(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> listarApontamentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object buscarApontamentoPorId(Object entity, long idApontamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
