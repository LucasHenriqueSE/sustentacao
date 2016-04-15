<title>Insert title here</title>
<form class="form-login" action="/sustentacao/autenticar" method="POST" role="form">
	<div class="input-group">
		<label for="usuario">Usuário</label><input class="form-control"
			id="usuario" name="login" value="" />
	</div>
	<div class="input-group">
		<label for="senha">Senha</label><input class="form-control" id="senha"
			name="senha" value="" type="password"/>
	</div>
	<br> <input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<button class="btn" value="" type="submit">Entrar</button>
</form>