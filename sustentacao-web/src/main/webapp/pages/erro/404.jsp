<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- JS -->
<script type="text/javascript"
	src="/sustentacao/bootstrap/jquery.min.js"></script>
<script type="text/javascript"
	src="/sustentacao/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src='<c:url value="/bootstrap/js/jquery.mask.min.js" />'></script>
<script type="text/javascript"
	src="/sustentacao/bootstrap/js/jquery-ui.min.js"></script>

<script type="text/javascript"
	src="/sustentacao/bootstrap/js/jquery.dataTables.min.js"></script>

<script type="text/javascript"
	src="/sustentacao/bootstrap/js/jquery.isloading.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="/sustentacao/bootstrap/css/jquery-ui.min.css" />
<link href="/sustentacao/bootstrap/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/sustentacao/bootstrap/font-awesome.css" rel="stylesheet"
	type="text/css">
<link href="/sustentacao/bootstrap/css/index.css" rel="stylesheet"
	type="text/css">
<link href="/sustentacao/bootstrap/css/style.css" rel="stylesheet"
	type="text/css">

<link href="/sustentacao/bootstrap/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
#menu li a {
	color: #fff;
}

.dataTables_wrapper .dataTables_paginate .paginate_button.current,
	.dataTables_wrapper .dataTables_paginate .paginate_button.current:hover
	{
	color: #fff;
}

#menu>.active>a {
	color: #000;
	background-color: #fff;
}

.paginate_button.current:hover {
	background: #004592 !important;
	color: #fff;
}

.paginate_button.current {
	background: #004592 !important;
	color: #fff;
}

.dataTables_wrapper .dataTables_paginate .paginate_button:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fff),
		color-stop(100%, #dcdcdc));
	color: #fff !important;
}

.dropdown-menu {
	background-color: #004592 !important;
	color: #fff;
}

.dropdown-menu>.active>a {
	color: #000 !important;
	background-color: #fff;
}

.dropdown-menu>li>a:hover, .dropdown-menu>li>a:focus {
	background-color: #004592 !important;
	color: #fff;
}

.data {
	
}
</style>
<title>Sistema - Sustenta��o</title>
</head>
<body>
	<!-- 	<nav class="navbar-inverse navbar-static-top"> -->
	<!-- 		<div class="panel-heading fx-titulo-painel"> -->
	<!-- 			<a id="logout" href="/sustentacao/logout/">Logout</a> -->
	<!-- 			<h1 class="panel-title">APONTAMENTO DE HORAS</h1> -->
	<!-- 		</div> -->
	<!-- 	</nav> -->
	<nav class="navbar navbar-default navbar-static-top"
		style="background-color: #004592; color: #fff;">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/sustentacao/painel/"
					style="color: #fff; text-align: center;">Apontamento de Horas</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<!-- MENU - INICIO -->
				<ul id="menu" class="nav navbar-nav navbar-left">
					<li id="menu-apontamentos"><a
						href='<c:url value="/painel/apontamentos" />'>Apontamentos</a></li>
					<li id="menu-tarefas"><a
						href='<c:url value="/painel/tarefas" />'>Tarefas</a></li>
					<c:if test="${usuario.perfil.descricao == 'Administrador' }">
						<li id="menu-usuarios"><a
							href='<c:url value="/painel/usuarios" />'>Usu�rios</a></li>
					</c:if>
				</ul>
				<!-- MENU - FIM -->
				<div class="hidden-xs hidden-sm"
					style="float: right; margin-left: 150px; margin-top: 10px;">
					<c:out value="${usuario.nome}" />
					<a style="background-color: #fff; color: #004592;"
						href='<c:url value="/logout/"></c:url>' class="btn btn-default">Logout</a>
				</div>
				<div class="hidden-md hidden-lg" style="margin-top: 10px;">
					<c:out value="${usuario.nome}" />
					<a style="background-color: #fff; color: #004592;"
						href='<c:url value="/logout/"></c:url>' class="btn btn-default">Logout</a>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="text-center text-success">Erro 404</h1>
					<h2 class="text-center">A p�gina solicitada n�o foi
						encontrada.</h2>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div
			class="navbar navbar-default navbar-fixed-bottom hidden-xs hidden-sm"
			style="background-color: #004592; color: #fff; padding: 5px; z-index: 999;">
			<div class="container text-center" style="margin-top: 10px">
				<p>
					Sistema Sustenta��o | Desenvolvido por <b><a target="_blank"
						style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
		<div
			class="navbar navbar-default navbar-fixed-bottom hidden-md hidden-lg"
			style="background-color: #004592; color: #fff; padding: 5px; z-index: 999;">
			<div class="container text-center" style="margin-top: 10px">
				<p>
					Sistema Sustenta��o | Desenvolvido por <b><a target="_blank"
						style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
	</footer>
</body>
</html>