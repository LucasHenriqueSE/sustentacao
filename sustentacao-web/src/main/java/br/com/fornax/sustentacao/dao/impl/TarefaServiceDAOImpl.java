package br.com.fornax.sustentacao.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fornax.sustentacao.dao.GenericDAO;
import br.com.fornax.sustentacao.dao.TarefaDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class TarefaServiceDAOImpl extends GenericDAO implements TarefaDAO{

	
	
}
