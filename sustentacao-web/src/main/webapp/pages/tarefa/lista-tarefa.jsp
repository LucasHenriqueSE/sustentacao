<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Lista de Tarefas</title>
<c:import url="menu.jsp"></c:import>
<form class="" action="" method="GET">
	<div class="table-responsive">
		<table class="table table-hover table-bordered">
			<thead>
				<tr class="text-center">
					<td>Tipo de Tarefa</td>
					<td>Descrição</td>
					<td>Número do Chamado</td>
					<td>Status</td>
					<td>Horas Disponíveis</td>
					<td>Apontar</td>
					<td>Editar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listaTarefas" items="${tarefas}">
					<tr class="text-center">
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
						<td><a class="glyphicon glyphicon-edit" title="Editar"
							href="/sustentacao/painel/tarefa/${listaTarefas.id}/editar-tarefa"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="text-right">
		<br> <a class="btn btn-lg" href="tarefas/cadastrar-tarefa"
			type="button">Cadastrar Tarefa</a> <a class="btn btn-lg"
			href="/sustentacao/painel" type="submit">Voltar</a>
	</div>
</form>