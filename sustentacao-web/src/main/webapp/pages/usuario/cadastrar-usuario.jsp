<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastro de Usuário</title>
<form class="" action="/painel/listar-usuarios/cadastrar" method="post">
	<br> <input id="id" value="" type="hidden"> Nome <input
		class="" id="nome" name="nome" /><br> Email <input class=""
		id="email" name="email" /><br> Login <input class="" id="login"
		name="login" /><br> Senha <input class="" id="senha" name="senha"
		type="password" /><br>
	<c:forEach var="perfil" items="tipoPerfil">
		<select></select>
		<select class="" id="perfil" name="perfil"></select>
		<br>
		<br>
	</c:forEach>

	<button class="" value="" type="submit">Cadastrar Novo</button>
	<button class="" value="" type="submit">Editar</button>
</form>