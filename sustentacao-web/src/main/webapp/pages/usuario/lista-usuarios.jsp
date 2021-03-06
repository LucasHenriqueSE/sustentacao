<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Lista de Usu�rios</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu-usuarios").attr('class', 'active');
		$('#usuarios').DataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : true,
			"bInfo" : false,
			"bAutoWidth" : true,
			"language" : {
				"emptyTable" : "Nenhuma informa��o cadastrada",
				"search" : "Pesquisar:",
				"paginate" : {
					"first" : "Primeira",
					"last" : "�ltima",
					"next" : "Pr�ximo",
					"previous" : "Anterior"
				}
			}
		});
	});
</script>
<style type="text/css">
<!--
-->
.dataTables_wrapper .dataTables_paginate .paginate_button.current,
	.dataTables_wrapper .dataTables_paginate .paginate_button.current:hover
	{
	color: #fff;
}

<
style type ="text/css"><!---->.dataTables_wrapper .dataTables_paginate .paginate_button.current,
	.dataTables_wrapper .dataTables_paginate .paginate_button.current:hover
	{
	color: #fff;
}
</style>
<form class="container" method="GET">
	<div class="table-responsive text-center">
		<br />
		<br />
		<table id="usuarios" class="table table-responsive">
			<thead>
				<tr>
					<td class="text-center"><span style="font-weight: bold;">#</span></td>
					<td class="text-center"><span style="font-weight: bold;">Usu�rio</span></td>
					<td class="text-center hidden-xs hidden-sm"><span
						style="font-weight: bold;">E-mail</span></td>
					<td class="text-center hidden-xs hidden-sm"><span
						style="font-weight: bold;">Perfil</span></td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty usuarios}">
						<c:forEach items="${usuarios}" var="usuario">
							<tr>
								<td class="text-center">${usuario.id}</td>
								<td class="text-center"><a
									href="/sustentacao/painel/usuario/${usuario.id}/editar-usuario">${usuario.nome}</a></td>
								<td class="text-center hidden-xs hidden-sm">${usuario.email}</td>
								<td class="text-center hidden-xs hidden-sm">${usuario.perfil.descricao}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">N�o h� dados a serem exibidos</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<br />
		<br />
		<div class="text-center btn-cadastrar">
			<br> <a class="btn btn-default btn-md"
				style="background-color: #004592; color: #fff; border-color: #004592"
				href="usuario/cadastrar-usuario" type="button">Cadastrar Usu�rio</a>
		</div>
	</div>
</form>