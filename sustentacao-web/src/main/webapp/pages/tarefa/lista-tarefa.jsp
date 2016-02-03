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
	<form class="" action="" method="get">
		<div class="table-responsive">
			<table class="table table-hover table-bordered">
				<tr class="text-center">
					<td>Tipo de Tarefa</td>
					<td>Descrição</td>
					<td>Número do Chamado</td>
					<td>Status</td>
					<td>Horas Disponíveis</td>
					<td>Apontar</td>
					<td>Editar</td>
				</tr>
				<c:forEach var="listaTarefas" items="${tarefas}">
					<tr class="text-center">
						<td>${listaTarefas.tipo.nome}</td>
						<td>${listaTarefas.descricao}</td>
						<td>${listaTarefas.numeroChamado}</td>
						<td>${listaTarefas.status.nome}</td>
						<td>${listaTarefas.qtdHorasDisponiveis}</td>
						<c:choose>
							<c:when test="${listaTarefas.qtdHorasDisponiveis > '00:00'}">
								<td><a class="glyphicon glyphicon-pencil"
									href="/sustentacao/painel/tarefa/${listaTarefas.id}/apontar"></a></td>
							</c:when>
							<c:otherwise>
								<td>Horas não disponiveis</td>
							</c:otherwise>
						</c:choose>
						<td><a class="glyphicon glyphicon-edit"
							href="/sustentacao/painel/tarefa/${listaTarefas.id}/editar-tarefa"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="text-right">
			<br>
			<a class="btn btn-lg" href="tarefas/cadastrar-tarefa" type="button">Cadastrar Tarefa</a>
			<a class="btn btn-lg" href="/sustentacao/painel" type="submit">Voltar</a>
		</div>
	</form>
</body>
</html>