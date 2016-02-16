<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Lista de Usuários</title>
<c:import url="menu.jsp"></c:import>
<form class="container" method="GET">
	<div class="table-responsive text-center">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<td>Nome</td>
					<td>Email</td>
					<td>Login</td>
					<td>Senha</td>
					<td>Perfil</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>${usuario.login}</td>
						<td>${usuario.senha}</td>
						<td>${usuario.perfil}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>