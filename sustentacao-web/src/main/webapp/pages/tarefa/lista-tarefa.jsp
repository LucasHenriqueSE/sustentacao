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
		<table>
			<tr>
				<td>Tipo de Tarefa</td>
				<td>Descrição</td>
				<td>Número do Chamado</td>
				<td>Status</td>
				<td>Horas Disponíveis</td>
				<td>Apontar</td>
			</tr>
			<c:forEach var="listaTarefas" items="${tarefas}">
				<tr>
					<td>${listaTarefas.tipo.nome}</td>
					<td>${listaTarefas.descricao}</td>
					<td>${listaTarefas.numeroChamado}</td>
					<td>${listaTarefas.status.nome}</td>
					<td>${listaTarefas.qtdHorasDisponiveis}</td>
					<td><a id="apontar" href="/sustentacao/painel/tarefa/${listaTarefas.id}/apontar">Apontar</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <a class="" href="tarefas/cadastrar" type="button">Cadastrar
			Tarefa</a>
	</form>
</body>
</html>