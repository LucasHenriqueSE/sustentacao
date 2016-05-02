<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Editar Tarefa</title>
<script type="text/javascript" id="mascaraDataHora">
	$(document).ready(function() {
		//$('#qtdHorasDisponiveis').mask('99?9:99');
		$("#menu-tarefas").attr('class', 'active');
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
<div class="section">
	<div class="container">
		<h4 class="title-screen">Editar Tarefa</h4>
		<hr>
		<form action="/sustentacao/painel/tarefa/editar" method="POST">
			<div>
				<input name="id" value="${idTarefa}" type="hidden">
			</div>
			<div>
				<input name="usuario.id" value="${tarefa.usuario.id}" type="hidden">
			</div>
			<div>
				<input name="dataEdicao"
					value='<fmt:formatDate value="${tarefa.dataEdicao.time}"/>'
					type="hidden">
			</div>
			<div class="col-md-offset-3">
				<div class="row">
					<div class="form-group col-md-2">
						<label for="tipoTarefa">Tipo de Tarefa </label> <select
							class="form-control" id="tipoTarefa" name="tipo.id" required
							autofocus>
							<c:forEach var="tipos" items="${tipo}">
								<c:choose>
									<c:when test="${tarefa.tipo.id == tipos.id}">
										<option value="${tipos.id}" label="${tipos.nome}" selected />
									</c:when>
									<c:otherwise>
										<option value="${tipos.id}" label="${tipos.nome}" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-3">
						<label for="statusChamado">Status</label> <select
							class="form-control" id="statusChamado" name="status.id" required>
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
					<c:choose>
						<c:when test="${tarefa.tipo.id == 3 || tarefa.tipo.id == 4}">
							<div class="form-group col-md-2">
								<label for="qtdHorasDisponiveis">Horas Disponíveis</label> <input
									class="form-control" id="qtdHorasDisponiveis"
									onfocus="removemascara();"
									onblur="reformatarHorasDisponiveis();"
									name="qtdHorasDisponiveis"
									value="${tarefa.qtdHorasDisponiveis}" />
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<input class="form-control" id="qtdHorasDisponiveis"
									onfocus="removemascara();"
									onblur="reformatarHorasDisponiveis();"
									name="qtdHorasDisponiveis"
									value="${tarefa.qtdHorasDisponiveis}" type="hidden" />
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="row">
					<div class="form-group col-md-7">
						<label for="numeroChamado">Número do Chamado</label> <input
							class="form-control" id="numeroChamado" name="numeroChamado"
							value="${tarefa.numeroChamado}" required />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-7">
						<label for="descricao">Descrição</label>
						<textarea class="form-control" id="descricao" name="descricao"
							rows="2" required>${tarefa.descricao}</textarea>
					</div>
				</div>
			</div>
			<hr>
			<button class="btn btn-add" type="submit">Salvar Tarefa</button>
			<a class="btn btn-return" href="/sustentacao/painel/tarefas"
				type="button">Cancelar</a>
		</form>
	</div>
</div>