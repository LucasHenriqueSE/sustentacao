package br.com.fornax.sustentacao.service;

import br.com.fornax.sustentacao.dao.entity.ApontamentoEntity;
import br.com.fornax.sustentacao.dao.entity.PerfilEntity;
import br.com.fornax.sustentacao.dao.entity.StatusEntity;
import br.com.fornax.sustentacao.dao.entity.TarefaEntity;
import br.com.fornax.sustentacao.dao.entity.TipoTarefaEntity;
import br.com.fornax.sustentacao.dao.entity.UsuarioEntity;
import br.com.fornax.sustentacao.model.Apontamento;
import br.com.fornax.sustentacao.model.Perfil;
import br.com.fornax.sustentacao.model.Status;
import br.com.fornax.sustentacao.model.Tarefa;
import br.com.fornax.sustentacao.model.TipoTarefa;
import br.com.fornax.sustentacao.model.Usuario;

public interface ParseService {
	public UsuarioEntity parseToEntity(Usuario model);

	public Usuario parseToModel(UsuarioEntity entity);

	public PerfilEntity parseToEntity(Perfil model);

	public Perfil parseToModel(PerfilEntity entity);

	public TarefaEntity parseToEntity(Tarefa model);
	
	public Tarefa parseToModel(TarefaEntity entity);

	public TipoTarefa parseToModel(TipoTarefaEntity entity);

	public ApontamentoEntity parseToEntity(Apontamento model);
	
	public Apontamento parseToModel(ApontamentoEntity entity);

	public Status parseToModel(StatusEntity entity);
}