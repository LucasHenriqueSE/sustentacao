<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Lista de Apontamentos</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#apontamentos').DataTable({
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
		$("#menu-apontamentos").attr('class', 'active');
	});
</script>
<form class="container" method="GET">
	<div class="table-responsive text-center">
		<br />
		<br />
		<table class="table table-hover table-bordered" id="apontamentos">
			<thead>
				<tr>
					<td>Data de Cadastro</td>
					<td>Tarefa</td>
					<td>Descri��o</td>
					<td>Data Apontamento</td>
					<td>Hora In�cio</td>
					<td>Hora T�rmino</td>
					<td>Data de Edi��o</td>
					<td>Editar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listaApontamento" items="${apontamentos}">
					<tr>
						<td><fmt:formatDate
								value="${listaApontamento.dataCadastro.time}" /></td>
						<td>${listaApontamento.tarefa.descricao}</td>
						<td>${listaApontamento.descricao}</td>
						<td><fmt:formatDate
								value="${listaApontamento.dataApontamento.time}" /></td>
						<td><fmt:formatDate
								value="${listaApontamento.horaInicio.time}" pattern="HH:mm" /></td>
						<td><fmt:formatDate
								value="${listaApontamento.horaTermino.time}" pattern="HH:mm" /></td>
						<td><fmt:formatDate
								value="${listaApontamento.dataEdicao.time}" /></td>
						<td><a class="glyphicon glyphicon-edit" title="Editar"
							href="/sustentacao/painel/apontamento/${listaApontamento.id}/editar-apontamento"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</form>