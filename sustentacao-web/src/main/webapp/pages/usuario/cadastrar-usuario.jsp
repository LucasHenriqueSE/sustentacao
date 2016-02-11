<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastro de Usu�rio</title>
<c:import url="menu.jsp"></c:import>
<div class="container form-usuario">
	<form class="" action="/painel/listar-usuarios/cadastrar"
		method="post">
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
				id="perfil" name="perfil">
				<c:forEach var="perfilUsuario" items="${perfil}">
					<option>${perfilUsuario.descricao}</option>
				</c:forEach>
			</select>
		</div>
		<br>
		<button class="btn" type="submit">Cadastrar Novo</button>
		<button class="btn" type="submit">Editar</button>
	</form>
</div>