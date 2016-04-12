<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Lista de Usuários</title>
<c:import url="menu.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('#usuarios').DataTable();
	});
</script>
<form class="container" method="GET">
	<div class="table-responsive text-center">
		<table class="table table-hover table-bordered" id="usuarios">
			<thead>
				<tr>
					<td>Usuário</td>
<!-- 					<td>Nome</td> -->
					<td>Email</td>
					<td hidden="hidden">Senha</td>
					<td>Perfil</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td><a
							href="/sustentacao/painel/usuario/${usuario.id}/editar-usuario">${usuario.login}</a></td>
<%-- 						<td>${usuario.nome}</td> --%>
						<td>${usuario.email}</td>
						<td hidden="hidden">${usuario.senha}</td>
						<td>${usuario.perfil.descricao}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center btn-cadastrar">
			<br> <a class="btn btn-default btn-lg" href="usuario/cadastrar-usuario"
				type="button">Cadastrar Usuário</a>
		</div>
	</div>
</form>