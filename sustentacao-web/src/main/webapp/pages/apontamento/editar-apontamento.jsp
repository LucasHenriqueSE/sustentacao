<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js"></c:url>"></script>
<script
	src="<c:url value="/resources/js/jquery.maskedinput.js"></c:url>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"></c:url>"></script>
<script type="text/javascript">
	jQuery(function() {
		// 		$("#dataApontamento").mask("99/99/9999");
		//	$("#horaInicio").mask("99:99");
		//$("#horaTermino").mask("99:99");
	});
</script>
<script type="text/javascript">
	function validar() {
		var hora1 = $("#horaInicio").val();
		var hora2 = $("#horaTermino").val();
		var id = $("#idTarefa").val();

		$.post('/sustentacao/validarHoraInicioFim?horaInicio=' + hora1
				+ '&horaTermino=' + hora2 + '&idTarefa=' + id, function(
				resultado) {
			if (resultado) {
				return true;
			} else {
				alert('Horas disponíveis insuficientes');
			}
		});
	}

	function compararHora() {
		var hora1 = horaInicio.value
		var hora2 = horaTermino.value
		if (hora1 < hora2) {
			return true;
		} else {
			alert('Hora Inicial maior que Hora Final');
			event.preventDefault();
		}
	};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Apontamento</title>
</head>
<body>
	<form id="formApt" action="/sustentacao/painel/apontamento/editar"
		method="post" onsubmit="compararHora();">
		<div>
			<div>
				<input id="idTarefa" name="apontamento.tarefa.id"
					value="${idTarefa}" type="hidden" />
			</div>
			<div class="input-group">
				<label for="descricao">Descrição</label> <input class="form-control"
					id="descricao" name="descricao" value="${apontamento.descricao}" />
			</div>
			<div class="input-group">
				<label for="dataApontamento">Data Apontamento</label> <input
					class="form-control" id="dataApontamento" name="dataApontamento"
					value='<fmt:formatDate value="${apontamento.dataApontamento.time}"/>' />
			</div>
			<div class="input-group">
				<label for="horaInicio">Hora Início</label> <input
					class="form-control" name="horaInicio" id="horaInicio"
					value="${apontamento.horaInicio.time}" pattern="dd/MM/yyyy" />
			</div>
			<div class="input-group">
				<label for="horaTermino">Hora Término</label> <input
					class="form-control" name="horaTermino" id="horaTermino"
					value="${apontamento.horaTermino.time}" onblur="validar();" />
			</div>
		</div>
		<br>
		<button class="btn btn-default" type="submit">Cadastrar</button>
		<a class="btn btn-default"
			href="/sustentacao/painel/apontamentos" type="button">Cancelar</a>
	</form>
</body>
</html>