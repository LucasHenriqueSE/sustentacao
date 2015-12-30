<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js"></c:url>"></script>
<script
	src="<c:url value="/resources/js/jquery.maskedinput.js"></c:url>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"></c:url>"></script>
<script type="text/javascript">
	jQuery(function() {
// 		$("#dataApontamento").mask("99/99/9999");
		$("#horaInicio").mask("99:99");
		$("#horaTermino").mask("99:99");
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
<title>Insert title here</title>
</head>
<body>
	<form class="" id="formApt"
		action="/sustentacao/painel/apontamento/editar" method="post"
		onsubmit="compararHora();">
		<div>
			<div>
				<input class="" id="idTarefa" name="apontamento.tarefa.id"
					value="${idTarefa}" type="hidden" required />
			</div>
			<div>
				Descrição<input class="" id="descricao" name="descricao"
					value="${apontamento.descricao}" required />
			</div>
			<div>
				Data Apontamento<input class="" id="dataApontamento"
					name="dataApontamento" required
					value="${apontamento.dataApontamento.time}" />
			</div>
			<div>
				Hora Início<input class="" name="horaInicio" id="horaInicio"
					value="${apontamento.horaInicio.time}" required />
			</div>
			<div>
				Hora Término<input class="" name="horaTermino" id="horaTermino"
					value="${apontamento.horaTermino.time}" required
					onblur="validar();" />
			</div>
		</div>
		<br>
		<button class="" type="submit">Cadastrar</button>
		<a class="" href="/sustentacao/painel/apontamentos" type="button">Cancelar</a>
	</form>
</body>
</html>