<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery-2.2.0.min.js"></c:url>'></script>
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
<link rel="stylesheet"
	href='<c:url value="/resources/css/acesso.css"></c:url>' />
<title>Insert title here</title>

</head>
<body>
	<div class="section">
		<div class="container">
			<form action="/sustentacao/autenticar" method="POST" role="form">
				<div class="form">
					<div class="col-md-3 col-md-offset-4 campos">
						<div class="form-group">
							<label for="usuario">Usuário</label><input class="form-control"
								id="usuario" name="login" value="" />
						</div>
						<div class="form-group">
							<label for="senha">Senha</label><input class="form-control"
								id="senha" name="senha" value="" type="password" />
						</div>
					</div>
					<div class="col-md-offset-5" style="clear: both;">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button class="btn btn-default btn-entrar col-md-2" type="submit">Entrar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>