<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="" action="" method="get">
		<table class="" id="tblApontamentos">
			<tr>
				<td>Data de Cadastro</td>
				<td>Tarefa</td>
				<td>Descrição</td>
				<td>Data Apontamento</td>
				<td>Hora Início</td>
				<td>Hora Término</td>
			</tr>
			<c:forEach var="listaApontamento" items="${apontamentos}">
				<tr>
					<td><fmt:formatDate	value="${listaApontamento.dataCadastro.time}" pattern="dd/MM/yyyy" type="date" /></td>
					<td>${listaApontamento.tarefa.id}</td>
					<td>${listaApontamento.descricao}</td>
					<td><fmt:formatDate	value="${listaApontamento.dataApontamento.time}" pattern="dd/MM/yyyy" type="date" /></td>
					<td><fmt:formatDate	value="${listaApontamento.horaInicio.time}" pattern="HH:mm" type="time"/></td>
					<td><fmt:formatDate value="${listaApontamento.horaTermino.time}" pattern="HH:mm" type="time"/></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a class="" href="/sustentacao/painel" type="submit">Voltar</a>
	</form>
</body>
</html>