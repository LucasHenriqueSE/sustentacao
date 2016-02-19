<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Editar Tarefa</title>
<script type="text/javascript" id="mascaraDataHora">
	$(document).ready(function() {
		//$('#qtdHorasDisponiveis').mask('99?9:99');
	});

	function reformatarHorasDisponiveis() {
		var qtd = $('#qtdHorasDisponiveis').val().replace('_', '');
		qtd = $('#qtdHorasDisponiveis').val().replace(':00', '');
		$('#qtdHorasDisponiveis').val(qtd + ':00');
	}

	function removemascara() {
		var qtd = $('#qtdHorasDisponiveis').val().replace('_', '');
		$('#qtdHorasDisponiveis').unmask();
		$('#qtdHorasDisponiveis').val(qtd);
	}
</script>
<form class="container" action="/sustentacao/painel/tarefa/editar"
	method="POST">
	<!-- <div class="alert alert-danger alert-dismissible" role="alert"> -->
	<!--   <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
	<!-- </div> -->
	<div>
		<br> <br>
		<div>
			<input name="id" value="${idTarefa}" type="hidden">
		</div>
		<div>
			<input id="dataEdicao" name="dataEdicao" value="${tarefa.dataEdicao}"
				type="hidden">
		</div>
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
					onfocus="removemascara();" onblur="reformatarHorasDisponiveis();"
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