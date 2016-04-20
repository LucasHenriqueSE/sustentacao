<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Lista de Tarefas</title>
<c:import url="menu.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('#tarefas').DataTable();
	});
</script>
<form class="container" action="" method="GET">
	<div class="table-responsive text-center">
		<table class="table table-hover table-bordered" id="tarefas">
			<thead>
				<tr>
					<td>Tipo de Tarefa</td>
					<td>Descrição</td>
					<td>Número do Chamado</td>
					<td>Status</td>
					<td>Horas Disponíveis</td>
					<td>Apontar</td>
					<td>Data de Edição</td>
					<td>Editar</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${tarefas != '' }">
						<c:forEach var="listaTarefas" items="${tarefas}">
							<tr>
								<td>${listaTarefas.tipo.nome}</td>
								<td>${listaTarefas.descricao}</td>
								<td>${listaTarefas.numeroChamado}</td>
								<td>${listaTarefas.status.nome}</td>
								<td>${listaTarefas.qtdHorasDisponiveis}</td>
								<c:choose>
									<c:when test="${listaTarefas.qtdHorasDisponiveis > '00:00'}">
										<td><a class="glyphicon glyphicon-pencil" title="Apontar"
											href="/sustentacao/painel/tarefa/${listaTarefas.id}/apontar"></a></td>
									</c:when>
									<c:otherwise>
										<td>Horas não disponiveis</td>
									</c:otherwise>
								</c:choose>
								<td><fmt:formatDate value="${listaTarefas.dataEdicao.time}" /></td>
								<td><a class="glyphicon glyphicon-edit" title="Editar"
									href="/sustentacao/painel/tarefa/${listaTarefas.id}/editar-tarefa"></a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">Nenhuma tarefa cadastrada.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<div class="text-center btn-cadastrar">
		<br> <a class="btn btn-default btn-lg"
			href="tarefa/cadastrar-tarefa" type="button">Cadastrar Tarefa</a>
	</div>
</form>