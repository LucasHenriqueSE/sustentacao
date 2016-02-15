<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Editar Tarefa</title>
<form action="/sustentacao/painel/tarefa/${idTarefa}/editar"
	method="POST">
	<div>
		<br> <br> <input name="tarefa.id" value="${idTarefa}"
			type="hidden">
		<div class="input-group">
			<label for="tipoTarefa">Tipo de Tarefa </label> <select
				class="form-control" id="tipoTarefa" name="tipo.id">
				<c:forEach var="tipos" items="${tipo}">
					<c:choose>
						<c:when test="${tarefa.tipo.id == tipos.id}">
							<option value="${tipos.id}" label="${tipos.nome}" selected></option>
						</c:when>
						<c:otherwise>
							<option value="${tipos.id}" label="${tipos.nome}"></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</select>
		</div>
		<div class="input-group">
			<label for="numeroChamado">N�mero do Chamado</label> <input
				class="form-control" id="numeroChamado" name="numeroChamado"
				value="${tarefa.numeroChamado}" />
		</div>
		<div class="input-group">
			<label for="descricao">Descri��o</label> <input class="form-control"
				id="descricao" name="descricao" value="${tarefa.descricao}" />
		</div>
		<c:if test="${tarefa.tipo.id == 3 || tarefa.tipo.id == 4}">
			<div class="input-group">
				<label for="qtdHorasDisponiveis">Horas Dispon�veis</label> <input
					class="form-control" id="qtdHorasDisponiveis"
					name="qtdHorasDisponiveis" value="${tarefa.qtdHorasDisponiveis}" />
			</div>
		</c:if>
		<div class="input-group">
			<label for="statusChamado">Status</label> <select
				class="form-control" id="statusChamado" name="status.id">
				<c:forEach var="listaStatus" items="${status}">
					<c:choose>
						<c:when test="${tarefa.status.id == listaStatus.id}">
							<option value="${listaStatus.id}" label="${listaStatus.nome}"
								selected></option>
						</c:when>
						<c:otherwise>
							<option value="${listaStatus.id}" label="${listaStatus.nome}"></option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Salvar</button>
	<a class="btn btn-default" href="/sustentacao/painel/tarefas"
		type="button">Cancelar</a>
</form>