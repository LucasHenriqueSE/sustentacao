<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="" action="/sustentacao/painel/tarefas/editar"
		method="post">
		<div>
			<br> <br>
			<div class="input-group">
				<label for="tipoTarefa">Tipo de Tarefa </label>
				<select class="form-control" id="tipoTarefa" name="tipo.id">
					<c:forEach var="listaTipo" items="${tipo}">
						<option value="${listaTipo.id}" selected>${listaTipo.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="input-group">
				<label for="numeroChamado">Número do Chamado</label>
				<input class="form-control" id="numeroChamado" name="numeroChamado"
					value="${tarefa.numeroChamado}"  />
			</div>
			<div class="input-group">
				<label for="descricao">Descrição</label>
				<input class="form-control" id="descricao" name="descricao" value="${tarefa.descricao}"
					 />
			</div>
			<%-- 			<c:forEach var="listaTipo" items="${tipo}"> --%>
			<c:if test="${id == 3 || id == 4}">
				<div class="input-group">
					<label for="qtdHorasDisponiveis">Horas Disponíveis</label>
					<input class="form-control" id="qtdHorasDisponiveis" name="qtdHorasDisponiveis"
						value="${tarefa.qtdHorasDisponiveis}" />
				</div>
			</c:if>
			<%-- 			</c:forEach> --%>
			<div class="input-group">
				<label for="statusChamado">Status</label>
				<select class="form-control" id="statusChamado" name="status.id">
					<c:forEach var="listaStatus" items="${status}">
						<option selected
							value="${listaStatus.nome}" >${listaStatus.nome}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<br>
		<button class="btn btn-default" type="submit">Salvar</button>
		<a class="btn btn-default" href="/sustentacao/painel/tarefas" type="button">Cancelar</a>
	</form>
</body>
</html>