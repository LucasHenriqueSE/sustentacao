<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<title>Lista de Apontamentos</title>
<c:import url="menu.jsp"></c:import>
<form class="" action="" method="get">
	<div class="table-responsive">
		<table class="table table-hover table-bordered" id="tblApontamentos">
			<thead>
				<tr class="text-center">
					<td>Data de Cadastro</td>
					<td>Tarefa</td>
					<td>Descrição</td>
					<td>Data Apontamento</td>
					<td>Hora Início</td>
					<td>Hora Término</td>
					<td>Editar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listaApontamento" items="${apontamentos}">
					<tr class="text-center">
						<td><fmt:formatDate
								value="${listaApontamento.dataCadastro.time}"
								pattern="dd/MM/yyyy" type="date" /></td>
						<td>${listaApontamento.tarefa.id}</td>
						<td>${listaApontamento.descricao}</td>
						<td><fmt:formatDate
								value="${listaApontamento.dataApontamento.time}"
								pattern="dd/MM/yyyy" type="date" /></td>
						<td><fmt:formatDate
								value="${listaApontamento.horaInicio.time}" pattern="HH:mm"
								type="time" /></td>
						<td><fmt:formatDate
								value="${listaApontamento.horaTermino.time}" pattern="HH:mm"
								type="time" /></td>
						<td><a class="glyphicon glyphicon-edit" title="Editar"
							href="/sustentacao/painel/apontamento/${listaApontamento.id}/editar-apontamento"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br> <a class="btn btn-lg" href="/sustentacao/painel"
		type="submit">Voltar</a>
</form>