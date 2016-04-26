package br.com.fornax.sustentacao.service.impl;

import org.springframework.stereotype.Service;

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
import br.com.fornax.sustentacao.service.ParseService;

@Service
public class ParseServiceImpl implements ParseService {

	@Override
	public UsuarioEntity parseToEntity(Usuario model) {
		UsuarioEntity entity = null;
		if (model != null) {
			entity = new UsuarioEntity();
			entity.setId(model.getId());
			entity.setNome(model.getNome());
			entity.setEmail(model.getEmail());
			entity.setSenha(model.getSenha());
			entity.setPerfil(parseToEntity(model.getPerfil()));
			entity.setAtivo(model.getAtivo());
		}
		return entity;
	}

	@Override
	public Usuario parseToModel(UsuarioEntity entity) {
		Usuario model = null;
		if (entity != null) {
			model = new Usuario();
			model.setId(entity.getId());
			model.setNome(entity.getNome());
			model.setEmail(entity.getEmail());
			model.setSenha(entity.getSenha());
			model.setPerfil(parseToModel(entity.getPerfil()));
			model.setAtivo(entity.getAtivo());
		}
		return model;
	}

	@Override
	public PerfilEntity parseToEntity(Perfil model) {
		PerfilEntity entity = null;
		if (model != null) {
			entity = new PerfilEntity();
			entity.setId(model.getId());
			entity.setDescricao(model.getDescricao());
		}
		return entity;
	}

	@Override
	public Perfil parseToModel(PerfilEntity entity) {
		Perfil model = null;
		if (entity != null) {
			model = new Perfil();
			model.setId(entity.getId());
			model.setDescricao(entity.getDescricao());
		}
		return model;
	}

	@Override
	public TarefaEntity parseToEntity(Tarefa model) {
		TarefaEntity entity = null;
		if (model != null) {
			entity = new TarefaEntity();
			entity.setId(model.getId());
			entity.setNumeroChamado(model.getNumeroChamado());
			entity.setTipo(parseToEntity(model.getTipo()));
			entity.setDescricao(model.getDescricao());
			entity.setStatus(parseToEntity(model.getStatus()));
			entity.setQtdHorasDisponiveis(model.getQtdHorasDisponiveis());
			entity.setDataEdicao(model.getDataEdicao());
			entity.setUsuario(parseToEntity(model.getUsuario()));
		}
		return entity;
	}

	@Override
	public Tarefa parseToModel(TarefaEntity entity) {
		Tarefa model = null;
		if (entity != null) {
			model = new Tarefa();
			model.setId(entity.getId());
			model.setNumeroChamado(entity.getNumeroChamado());
			model.setTipo(parseToModel(entity.getTipo()));
			model.setDescricao(entity.getDescricao());
			model.setStatus(parseToModel(entity.getStatus()));
			model.setQtdHorasDisponiveis(entity.getQtdHorasDisponiveis());
			model.setDataEdicao(entity.getDataEdicao());
			model.setUsuario(parseToModel(entity.getUsuario()));
		}
		return model;
	}

	public TipoTarefaEntity parseToEntity(TipoTarefa model) {
		TipoTarefaEntity entity = null;
		if (model != null) {
			entity = new TipoTarefaEntity();
			entity.setId(model.getId());
			entity.setNome(model.getNome());
			entity.setQtdHoras(model.getQtdHoras());
			entity.setQtdHorasParaAviso(model.getQtdHorasParaAviso());
		}
		return entity;
	}

	public TipoTarefa parseToModel(TipoTarefaEntity entity) {
		TipoTarefa model = null;
		if (entity != null) {
			model = new TipoTarefa();
			model.setId(entity.getId());
			model.setNome(entity.getNome());
			model.setQtdHoras(entity.getQtdHoras());
			model.setQtdHorasParaAviso(entity.getQtdHorasParaAviso());
		}
		return model;
	}

	public StatusEntity parseToEntity(Status model) {
		StatusEntity entity = null;
		if (model != null) {
			entity = new StatusEntity();
			entity.setId(model.getId());
			entity.setNome(model.getNome());
		}
		return entity;
	}

	public Status parseToModel(StatusEntity entity) {
		Status model = null;
		if (entity != null) {
			model = new Status();
			model.setId(entity.getId());
			model.setNome(entity.getNome());
		}
		return model;
	}

	@Override
	public ApontamentoEntity parseToEntity(Apontamento model) {
		ApontamentoEntity entity = null;
		if (model != null) {
			entity = new ApontamentoEntity();
			entity.setId(model.getId());
			entity.setTarefa(parseToEntity(model.getTarefa()));
			entity.setUsuario(parseToEntity(model.getUsuario()));
			entity.setDataApontamento(model.getDataApontamento());
			entity.setDescricao(model.getDescricao());
			entity.setHoraInicio(model.getHoraInicio());
			entity.setHoraTermino(model.getHoraTermino());
			entity.setDataCadastro(model.getDataCadastro());
			entity.setDataEdicao(model.getDataEdicao());
		}
		return entity;
	}

	@Override
	public Apontamento parseToModel(ApontamentoEntity entity) {
		Apontamento model = null;
		if (entity != null) {
			model = new Apontamento();
			model.setId(entity.getId());
			model.setTarefa(parseToModel(entity.getTarefa()));
			model.setUsuario(parseToModel(entity.getUsuario()));
			model.setDataApontamento(entity.getDataApontamento());
			model.setDescricao(entity.getDescricao());
			model.setHoraInicio(entity.getHoraInicio());
			model.setHoraTermino(entity.getHoraTermino());
			model.setDataCadastro(entity.getDataCadastro());
			model.setDataEdicao(entity.getDataEdicao());
		}
		return model;
	}
}