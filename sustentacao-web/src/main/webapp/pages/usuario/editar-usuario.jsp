<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Editar Usuário</title>
<c:import url="menu.jsp"></c:import>
<div class="container form-usuario">
	<form class="container" action="/sustentacao/painel/usuario/editar"
		method="POST">
		<br> <input id="id" name="id" value="${idUsuario}" type="hidden">
		<div class="row col-md-offset-1">
			<div class="form-group col-md-4">
				<label for="nome">Nome</label><input class="form-control" id="nome"
					name="nome" value="${usuario.nome}" required autofocus />
			</div>
			<div class="form-group col-md-3">
				<label for="login">Login</label><input class="form-control"
					id="login" name="login" value="${usuario.login}" required />
			</div>
			<div class="form-group col-md-3">
				<label for="senha">Senha</label><input class="form-control"
					id="senha" name="senha" type="password" value="${usuario.senha}"
					required />
			</div>
		</div>
		<div class="row col-md-offset-1">
			<div class="form-group col-md-4">
				<label for="email">Email</label><input class="form-control"
					id="email" name="email" value="${usuario.email}" required />
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
			<div class="form-group col-md-offset-8">
				<label>Usuário Ativo?</label><br />
				<c:choose>
					<c:when test="${usuario.ativo}">
						<label for="sim"><input id="sim" name="ativo"
							value="${usuario.ativo}" type="radio" required checked /> Sim</label>
						<label for="nao"><input id="nao" name="ativo"
							value="${usuario.ativo}" type="radio" required /> Não</label>
					</c:when>
					<c:otherwise>
						<label for="sim"><input id="sim" name="ativo"
							value="${usuario.ativo}" type="radio" required /> Sim</label>
						<label for="nao"><input id="nao" name="ativo"
							value="${usuario.ativo}" type="radio" required checked /> Não</label>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<br>
		<button class="btn btn-default" type="submit">Salvar</button>
		<a class="btn btn-default" href="/sustentacao/painel/usuarios"
			type="button">Cancelar</a>
	</form>
</div>