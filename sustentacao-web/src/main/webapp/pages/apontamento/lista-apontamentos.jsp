<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Lista de Apontamentos</title>
<c:import url="menu.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('#apontamentos').DataTable();
	});
</script>
<form class="container-fluid" action="" method="GET">
	<div class="table-responsive text-center">
		<table class="table table-hover table-bordered" id="apontamentos">
			<thead>
				<tr>
					<td>Data de Cadastro</td>
					<td>Tarefa</td>
					<td>Descrição</td>
					<td>Data Apontamento</td>
					<td>Hora Início</td>
					<td>Hora Término</td>
					<td>Data de Edição</td>
					<td>Editar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listaApontamento" items="${apontamentos}">
					<tr>
						<td><fmt:formatDate
								value="${listaApontamento.dataCadastro.time}" /></td>
						<td>${listaApontamento.tarefa.id}</td>
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