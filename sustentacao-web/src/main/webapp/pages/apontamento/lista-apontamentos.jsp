<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Lista de Apontamentos</title>
<script type="text/javascript">
	$(function() {
		$("#menu-apontamentos").attr('class', 'active');
		$('#apontamentos').DataTable({
			"iDisplayLength" : 5,
			"bPaginate" : true,
			"bLengthChange" : false,
			"bFilter" : true,
			"bInfo" : false,
			"bAutoWidth" : true,
			"language" : {
				"emptyTable" : "Nenhuma informação cadastrada",
				"search" : "Pesquisar:",
				"paginate" : {
					"first" : "Primeira",
					"last" : "Última",
					"next" : "Próximo",
					"previous" : "Anterior"
				}
			}
		});
	});
</script>
<style type="text/css">
.dataTables_wrapper .dataTables_paginate .paginate_button.current,
	.dataTables_wrapper .dataTables_paginate .paginate_button.current:hover
	{
	color: #fff;
}
</style>
<form class="container" method="GET">
	<div class="table-responsive text-center">
		<br /> <br />
		<table id="apontamentos" class="table table-responsive">
			<thead>
				<tr>
					<td class="text-center"><span style="font-weight: bold;">Tarefa</span></td>
					<td class="text-center"><span style="font-weight: bold;">Data
							Apontamento</span></td>
					<td class="text-center hidden-xs hidden-sm"><span
						style="font-weight: bold;">Hora Início</span></td>
					<td class="text-center hidden-xs hidden-sm"><span
						style="font-weight: bold;">Hora Término</span></td>
					<td class="text-center hidden-xs hidden-sm"><span
						style="font-weight: bold;">Editar</span></td>
					<td class="text-center hidden-xs hidden-sm"><span
						style="font-weight: bold;">Enviar Apontamento</span></td>
					<!-- 					<td class="text-center hidden-xs hidden-sm"><span -->
					<!-- 						style="font-weight: bold;">Visualizar</span></td> -->
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty apontamentos}">
						<c:forEach items="${apontamentos}" var="apontamento">
							<tr>
								<td class="text-center">${apontamento.tarefa.numeroChamado}</td>
								<td class="text-center"><fmt:formatDate
										value="${apontamento.dataApontamento.time}"
										pattern="dd/MM/yyyy" /></td>
								<td class="text-center hidden-xs hidden-sm"><fmt:formatDate
										value="${apontamento.horaInicio.time}" pattern="HH:mm" /></td>
								<td class="text-center hidden-xs hidden-sm"><fmt:formatDate
										value="${apontamento.horaTermino.time}" pattern="HH:mm" /></td>
								<c:choose>
									<c:when test="${apontamento.enviadoParaAprovacao}">
										<td class="text-center">Indisponível</td>
										<td class="text-center">Enviado</td>
									</c:when>
									<c:otherwise>
										<td class="text-center"><a
											href="/sustentacao/painel/apontamento/${apontamento.id}/editar-apontamento"><span
												class="glyphicon glyphicon-pencil"></span></a></td>
										<td class="text-center"><a
											href='<c:url value="/painel/apontamento/${apontamento.id}/enviarApontamento"></c:url>'><span
												class="glyphicon glyphicon-play-circle"></span></a>
									</c:otherwise>
								</c:choose>
								<!-- 								<td class="text-center"><a -->
								<%-- 									href="painel/apontamento/${apontamento.id}/visualizar-apontamento"><span --%>
								<!-- 										class="glyphicon glyphicon-eye-open"></span></a></td> -->
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">Não há apontamentos a serem exibidos</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</form>