<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-2.2.0.min.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
<link rel="stylesheet"
	href='<c:url value="/resources/css/acesso.css"></c:url>' />
	
<title>Apontamento de Horas</title>

<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<link href="/sustentacao/bootstrap/css/index.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<!-- Tela de Login - INICIO -->
	<div class="section">
		<div class="container">
			<div class="row">
				<div style="margin-top:95px" class="hidden-xs hidden-sm">
					<img src="/sustentacao/img/sustentacao_logo6.png"
						class="center-block img-responsive img-rounded" height="120px"
						width="120px" style="margin-top: -8px;">
				</div>
				<div style="margin-top:20px" class="hidden-md hidden-lg">
					<img src="/sustentacao/img/sustentacao_logo6.png"
						class="center-block img-responsive img-rounded" height="120px"
						width="120px" style="margin-top: -8px;">
				</div>
			</div>
			<form action="/sustentacao/autenticar" method="POST" role="form">
				<div class="row" style="padding-top: 20px">
					
						<div class="form-group col-md-4 col-md-offset-4 col-xs-8 col-xs-offset-2">
							<label for="inputEmail">Usu�rio</label> <input
								type="email" id="inputEmail" class="form-control" name="email"
								placeholder="Digite seu E-mail" required autofocus>
						</div>
						<div class="form-group col-md-4 col-md-offset-4 col-xs-8 col-xs-offset-2">
							<label for="inputPassword">Senha</label> <input type="password"
								id="inputPassword" name="senha" class="form-control"
								placeholder="Senha" required>
						</div>
				</div>
				<div class="row">
					<div class="text-center">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-default" style="background-color: #004592; color: #fff; border-color: #004592">Acessar o
							sistema</button>
						<br />
						<br >
						<a href="esqueceu-senha">Esqueci minha senha</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Tela de Login - FIM -->
	<!-- Footer -->
	<footer>
		<div class="navbar navbar-default navbar-static-top hidden-xs hidden-sm"
			style="background-color: #004592; color: #fff; padding: 20px; margin-top: 68px">
			<div class="text-center" style="margin-top: 10px">
				<p>
					Apontamento de Horas | Desenvolvido por <b><a
						target="_blank" style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
		<div class="navbar navbar-default navbar-static-top hidden-md hidden-lg"
			style="background-color: #004592; color: #fff; padding: 20px;margin-top:32px">
			<div class="text-center" style="margin-top: 10px">
				<p>
					Apontamento de Horas | Desenvolvido por <b><a
						target="_blank" style="color: #fff; text-decoration: none"
						href="http://www.fornax.com.br">FORNAX TECNOLOGIA</a></b> | 2016
				</p>
			</div>
		</div>
	</footer>
</body>
</html>