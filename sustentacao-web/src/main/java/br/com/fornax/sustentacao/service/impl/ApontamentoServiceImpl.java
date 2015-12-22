package br.com.fornax.sustentacao.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.ApontamentoDAO;
import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.service.ApontamentoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ApontamentoServiceImpl implements ApontamentoService {

	@Inject
	private ApontamentoDAO dao;

	@Override
	public boolean cadastrarApontamento(Apontamento apontamento) {
		List<Apontamento> lista = dao.listarApontamentoDoDia(apontamento.getDataApontamento(),
				apontamento.getHoraInicio(), apontamento.getHoraTermino());

		if (lista.isEmpty()) {
			apontamento.setDataCadastro(Calendar.getInstance());
			dao.inserir(apontamento);
			return true;
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
		return dao.listarTudo();
	}

	@Override
	public Object buscarApontamentoPorId(Apontamento apontamento, long idApontamento) {
		// TODO Auto-generated method stub
		return null;
	}
}