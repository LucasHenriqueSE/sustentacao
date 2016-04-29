<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu-usuarios").attr('class', 'active');
	});
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Cadastro de Usuario</h4>
			<hr />
			<div id="alertas"></div>
			<form action="/sustentacao/painel/usuario/cadastrar" method="POST"
				role="form">
				<div class="row">
					<div class="form-group col-md-offset-2 col-md-4">
						<label for="nome">Nome Completo:</label> <input type="text"
							class="form-control" id="nome" name="nome"
							placeholder="Digite o nome" required autofocus>
					</div>
					<div class="form-group col-md-4">
						<label>Usuario:</label> <input type="email" class="form-control"
							id="usuario" placeholder="Digite o nome do usuario" name="email"
							required>
					</div>
					<div class="form-group col-md-offset-2 col-md-4">
						<label>Senha:</label> <input type="password" class="form-control"
							id="senha" placeholder="Digite a senha" name="senha" required>
					</div>
					<div class="form-group col-md-4">
						<label for="perfil">Perfil:</label> <select id="perfil"
							class="form-control" name="perfil.id"
							onchange="verificaPerfil();" required>
							<option value="">Selecione ...</option>
							<c:forEach items="${perfil}" var="perfil">
								<option value="${perfil.id}">${perfil.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div style="clear: both;"
						class="form-group col-md-offset-2 col-md-4">
						<div class="radio">
							<label>Realiza login no sistema?</label> <label><input
								type="radio" name="ativo" value="true" required>Sim</label> <label><input
								type="radio" name="ativo" value="false" required>Não</label>
						</div>
					</div>
				</div>
				<hr />
				<div
					class="form-group col-xs-offset-0 hidden-md hidden-lg hidden-xl"
					style="margin-bottom: 70px;">
					<a href='<c:url value="/sustentacao/painel/usuarios"/>'
						style="background-color: #004592; color: #fff; border-color: #004592; margin-bottom: 70px;"
						class="btn btn-default btn-return">Cancelar</a>
					<button type="submit"
						style="background-color: #004592; color: #fff; border-color: #004592 margin-bottom: 70px;"
						class="btn btn-default btn-add">Salvar Usuário</button>
				</div>
				<br />
				<br />
				<div class="form-group col-xs-offset-0 hidden-xs hidden-sm"
					style="margin-bottom: 70px;">
					<a href='<c:url value="/sustentacao/painel/usuarios" />'
						style="float: left; background-color: #004592; color: #fff; border-color: #004592 margin-bottom: 70px;"
						class="btn btn-default">Cancelar</a>
					<button type="submit"
						style="float: right; background-color: #004592; color: #fff; border-color: #004592 margin-bottom: 70px;"
						class="btn btn-default">Salvar Usuário</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>