<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	<%@include file="/resources/css/bootstrap.min.css" %>
	<%@include file="/resources/css/style.css" %>
</style>
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" /> --%>
</head>
<body>
	<nav class="navbar-inverse navbar-static-top">
		<div class="panel-heading fx-titulo-painel">
			<h1 class="panel-title">Apontamento de Horas</h1>
		</div>
	</nav>
	<nav class="menu-navegacao">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="/sustentacao/painel/apontamentos">Apontamento de Horas</a></li>
				<li><a href="/sustentacao/painel/tarefas">Tarefas</a></li>
				<li><a href="/sustentacao/painel/cadastrar-usuario">Usuários</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="acesso">Logout</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>