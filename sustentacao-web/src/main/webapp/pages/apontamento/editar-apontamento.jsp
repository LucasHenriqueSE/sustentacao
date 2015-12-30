<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<!-- <script id="mascaras" type="text/javascript"> -->
<!-- // $("#dataApontamento").mask("99/99/9999"); -->
<!-- </script> -->
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js"></c:url>"></script>
<!-- <script src="jquery.maskedinput.js" type="text/javascript"></script> -->
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
		action="/sustentacao/painel/apontamento/editar"
		method="post" onsubmit="compararHora();">
		<div>
			<div>
				<input class="" id="idTarefa" name="tarefa.id" value="${idTarefa}"
					type="hidden" required />
			</div>
			<div>
				Descrição<input class="" name="descricao" value="${descricao}"
					required />
			</div>
			<div>
				Data Apontamento<input class="" id="dataApontamento"
					name="dataApontamento" required value="${dataApontamento}"
					type="datetime" />
			</div>
			<div>
				Hora Início<input class="" name="horaInicio" id="horaInicio"
					value="${horaInicio}" required type="time"
					pattern="[0-9]{2}:[0-9]{2} [0-9]{2}$" />
			</div>
			<div>
				Hora Término<input class="" name="horaTermino" id="horaTermino"
					value="${horaTermino}" required onblur="validar();"
					type="time" pattern="[0-9]{2}:[0-9]{2} [0-9]{2}$" />
			</div>
		</div>
		<br>
		<button class="" type="submit">Cadastrar</button>
		<a class="" href="/sustentacao/painel/apontamentos" type="button">Cancelar</a>
	</form>
</body>
</html>