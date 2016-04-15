<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Editar Usuário</title>
<c:import url="menu.jsp"></c:import>
<div class="container form-usuario">
	<form class="container" action="/sustentacao/painel/usuario/editar"
		method="POST">
		<br> <input id="id" name="id" value="${idUsuario}" type="hidden">
		<div class="input-group">
			<label for="nome">Nome</label><input class="form-control" id="nome"
				name="nome" value="${usuario.nome}" /><br>
		</div>
		<div class="input-group">
			<label for="email">Email</label><input class="form-control"
				id="email" name="email" value="${usuario.email}" /><br>
		</div>
		<div class="input-group">
			<label for="login">Login</label><input class="form-control"
				id="login" name="login" value="${usuario.login}" /><br>
		</div>
		<div class="input-group">
			<label for="perfil">Perfil</label><select class="form-control"
				id="perfil" name="perfil.codigo" required>
				<c:forEach var="perfilUsuario" items="${perfil}">
					<c:choose>
						<c:when test="${usuario.perfil.codigo == perfilUsuario.codigo}">
							<option value="${perfilUsuario.codigo}"
								label="${perfilUsuario.descricao}" selected />
						</c:when>
						<c:otherwise>
							<option value="${perfilUsuario.codigo}"
								label="${perfilUsuario.descricao}" />
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<br>
		<button class="btn btn-default" type="submit">Salvar</button>
		<a class="btn btn-default" href="/sustentacao/painel/usuarios"
			type="button">Cancelar</a>
	</form>
</div>