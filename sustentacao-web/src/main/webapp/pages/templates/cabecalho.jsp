<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" />
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
				<li><a class="" href="/sustentacao/painel/apontamentos">Apontamento
						de Horas</a></li>
				<li><a class="" href="/sustentacao/painel/tarefas">Tarefas</a></li>
				<li><a class="" href="/sustentacao/painel/cadastrar-usuario">Usuários</a></li>
			</ul>
			<ul class="nav navbar-right">
				<li><a class="btn btn-link btn-primary btn-logout"
					href="acesso">Logout</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>