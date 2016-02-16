<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastro de Usuário</title>
<c:import url="menu.jsp"></c:import>
<div class="container form-usuario">
	<form class="" action="/sustentacao/painel/usuario/cadastrar" method="post">
		<br> <input id="id" value="" type="hidden">
		<div class="input-group">
			<label for="nome">Nome</label><input class="form-control" id="nome"
				name="nome" /><br>
		</div>
		<div class="input-group">
			<label for="email">Email</label><input class="form-control"
				id="email" name="email" /><br>
		</div>
		<div class="input-group">
			<label for="login">Login</label><input class="form-control"
				id="login" name="login" /><br>
		</div>
		<div class="input-group">
			<label for="senha">Senha</label><input class="form-control"
				id="senha" name="senha" type="password" /><br>
		</div>
		<div class="input-group">
			<label for="perfil">Perfil</label><select class="form-control"
				id="perfil" name="perfil.id">
				<c:forEach var="perfilUsuario" items="${perfil}">
					<option value="perfilUsuario.id">${perfilUsuario.descricao}</option>
				</c:forEach>
			</select>
		</div>
		<br>
		<button class="btn" type="submit">Salvar</button>
		<button class="btn" type="submit">Cancelar</button>
	</form>
</div>