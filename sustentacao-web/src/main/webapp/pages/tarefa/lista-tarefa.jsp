<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Lista de Tarefas</title>
<c:import url="menu.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('#tarefas').DataTable();
	});
</script>
<form class="container" method="GET">
	<div class="table-responsive text-center">
		<table id="tarefas" class="table table-responsive">
				<thead>
					<tr>
						<td class="text-center"><span style="font-weight: bold;">#</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Tipo de Tarefa</span></td>
						<td class="text-center"><span style="font-weight: bold;">Descrição</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Número do Chamado</span></td>
							<td class="text-center"><span style="font-weight: bold;">Status</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Horas Disponíveis</span></td>
						<td class="text-center"><span style="font-weight: bold;">Apontar</span></td>
						<td class="text-center hidden-xs hidden-sm"><span
							style="font-weight: bold;">Editar</span></td>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty tarefas}">
							<c:forEach items="${tarefas}" var="tarefa">
								<tr>
									<td class="text-center">${tarefa.id}</td>
									<td class="text-center hidden-xs hidden-sm">${tarefa.tipo.nome}</td>
									<td class="text-center">${tarefa.descricao}</td>
									<td class="text-center hidden-xs hidden-sm">${tarefa.numeroChamado}</td>
									<td class="text-center">${tarefa.status.nome}</td>
									<td class="text-center hidden-xs hidden-sm">${tarefa.qtdHorasDisponiveis}</td>
									<c:choose>
									<c:when test="${tarefa.qtdHorasDisponiveis > '00:00'}">
										<td><a class="glyphicon glyphicon-pencil" title="Apontar"
											href="/sustentacao/painel/tarefa/${tarefa.id}/apontar"></a></td>
									</c:when>
									<c:otherwise>
										<td><a class="glyphicon glyphicon-remove" title="Apontar"
											href="/sustentacao/painel/tarefas"></a></td>
									</c:otherwise>
								</c:choose>
								<td><a class="glyphicon glyphicon-edit" title="Editar"
									href="/sustentacao/painel/tarefa/${tarefa.id}/editar-tarefa"></a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6">Não há dados a serem exibidos</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		<div class="text-center btn-cadastrar">
			<br> <a class="btn btn-default btn-md" style="background-color: #004592; color: #fff; border-color: #004592" href="tarefa/cadastrar-tarefa"
				type="button">Cadastrar Tarefa</a>
		</div>
	</div>
</form>