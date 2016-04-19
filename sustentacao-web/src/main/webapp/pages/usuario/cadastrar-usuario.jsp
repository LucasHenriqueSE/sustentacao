<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastro de Usuário</title>
<c:import url="menu.jsp" />
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form class="" action="/sustentacao/painel/usuario/cadastrar"
					method="post">
					<div class="row col-md-offset-1">
						<div class="form-group col-md-4">
							<label for="nome">Nome</label><input class="form-control"
								id="nome" name="nome" placeholder="Digite o Nome Completo"
								required autofocus />
						</div>
						<div class="form-group col-md-3">
							<label for="login">Login</label><input class="form-control"
								id="login" name="login" placeholder="Digite o Login" required />
						</div>
						<div class="form-group col-md-3">
							<label for="senha">Senha</label><input class="form-control"
								id="senha" name="senha" type="password"
								placeholder="Digite a Senha" required />
						</div>
					</div>
					<div class="row col-md-offset-1">
						<div class="form-group col-md-4">
							<label for="email">Email</label><input class="form-control"
								id="email" name="email" placeholder="Digite um Email válido"
								required />
						</div>
						<div class="form-group col-md-3">
							<label for="perfil">Perfil</label><select class="form-control"
								id="perfil" name="perfil.codigo" required>
								<option value="">Selecione...</option>
								<c:forEach var="perfilUsuario" items="${perfil}">
									<option value="${perfilUsuario.codigo}">${perfilUsuario.descricao}</option>
								</c:forEach>
							</select>
						</div>
						<br />
						<div class="form-group col-md-offset-8">
							<label>Usuário Ativo?</label><br />
							<label for="sim"><input id="sim" name="ativo"
								value="true" type="radio" required /> Sim</label> <label for="nao"><input
								id="nao" name="ativo" value="false" type="radio" required /> Não</label>
						</div>
					</div>
					<br>
					<button style="float: right;" class="btn btn-default" type="submit">Salvar</button>
					<a class="btn btn-default" style="float: left"
						href="/sustentacao/painel/usuarios" type="button">Cancelar</a>
				</form>
			</div>
		</div>
	</div>
</div>