<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Editar Tarefa</title>
<form class="" action="/sustentacao/painel/tarefas/editar" method="post">
	<div>
		<br> <br> <input name="tarefa.id" value="${tarefa.id}">
		<div class="input-group">
			<label for="tipoTarefa">Tipo de Tarefa </label> <select
				class="form-control" id="tipoTarefa" name="tarefa.tipo.nome">
				<c:forEach var="tipos" items="${tipo}">
					<option value="${tipos.id}" label="${tipos.nome}" ></option>
				</c:forEach>
			</select>
		</div>
		<div class="input-group">
			<label for="numeroChamado">Número do Chamado</label> <input
				class="form-control" id="numeroChamado" name="numeroChamado"
				value="${tarefa.numeroChamado}" />
		</div>
		<div class="input-group">
			<label for="descricao">Descrição</label> <input class="form-control"
				id="descricao" name="descricao" value="${tarefa.descricao}" />
		</div>
		<c:if test="${tarefa.tipo.id == 3 || tarefa.tipo.id == 4}">
			<div class="input-group">
				<label for="qtdHorasDisponiveis">Horas Disponíveis</label> <input
					class="form-control" id="qtdHorasDisponiveis"
					name="qtdHorasDisponiveis" value="${tarefa.qtdHorasDisponiveis}" />
			</div>
		</c:if>
		<div class="input-group">
			<label for="statusChamado">Status</label> <select
				class="form-control" id="statusChamado" name="status.id" >
				<c:forEach var="listaStatus" items="${status}">
					<option value="${listaStatus.id}">${listaStatus.nome}</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Salvar</button>
	<a class="btn btn-default" href="/sustentacao/painel/tarefas"
		type="button">Cancelar</a>
</form>