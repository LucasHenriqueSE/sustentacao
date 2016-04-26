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

<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-2.2.0.min.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />

<style type="text/css">
#menu li a {
	color: #fff;
}

#menu>.active>a {
	color: #000;
	background-color: #fff;
}
</style>

<title>Sistema Gestão de Projetos</title>
</head>
<body>
	<div class="navbar navbar-default navbar-static-top"
		style="background-color: #4DC1FF; color: #fff;">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand hidden-md hidden-lg" style="color: #fff;"
					href='<c:url value="/"></c:url>'><span>Apontamento de
						Horas</span></a> <a class="navbar-brand hidden-xs hidden-sm"
					style="color: #ffffff; height: 80px;"
					href="<c:url value="/"></c:url>"> <img
					src="/gestao-projetos/img/logo.jpg"
					class="center-block img-responsive img-rounded" height="120px"
					width="120px" style="margin-top: -8px;"></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse"
				style="margin-top: 10px"></div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="text-center text-success">Erro 403 - Você não tem
						permissão para acessar esse conteúdo!</h1>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<div
			class="navbar navbar-default navbar-static-top hidden-xs hidden-sm"
			style="background-color: #4DC1FF; color: #fff; padding: 5px; margin-top: 175px">
			<div class="text-center" style="margin-top: 10px">
				<p>
					Apontamento de Horas | Desenvolvido por <b><a target="_blank"
						style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
		<div
			class="navbar navbar-default navbar-static-top hidden-md hidden-lg"
			style="background-color: #4DC1FF; color: #fff; padding: 5px;">
			<div class="text-center" style="margin-top: 10px">
				<p>
					Apontamento de Horas | Desenvolvido por <b><a target="_blank"
						style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
	</footer>

</body>
</html>