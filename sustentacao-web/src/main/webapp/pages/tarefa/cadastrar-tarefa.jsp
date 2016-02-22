<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastrar Tarefa</title>
<form action="/sustentacao/painel/tarefa/cadastrar" method="POST">
	<div>
		<br> <br>
		<div class="input-group">
			<label for="tipoTarefa">Tipo de Tarefa</label> <select
				class="form-control" id="tipoTarefa" name="tipo.id">
				<option label="Selecione" selected="selected" value="" />
				<c:forEach var="listaTipo" items="${tipo}">
					<option value="${listaTipo.id}">${listaTipo.nome}</option>
				</c:forEach>
			</select>
		</div>
		<div class="input-group">
			<label for="numeroChamado">Número do Chamado</label> <input
				class="form-control" id="numeroChamado" name="numeroChamado"
				placeholder="Número do Chamado" />
		</div>
		<div class="input-group">
			<label for="descricao">Descrição</label> <input class="form-control"
				id="descricao" name="descricao" value="" placeholder="Descrição" />
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Salvar</button>
	<a class="btn btn-default" href="/sustentacao/painel/tarefas"
		type="button">Cancelar</a>
</form>