<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script type="text/javascript">
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
		action="/sustentacao/painel/apontamentos/cadastrar-apontamento"
		method="post" onsubmit="compararHora(horaInicio, horaTermino);">
		<div>
			<div>
				<input class="" name="tarefa.id" value="${idTarefa}" type="hidden"
					required="required" />
			</div>
			<div>
				Descrição<input class="" name="descricao" placeholder="Descrição"
					required="required" />
			</div>
			<div>
				Data Apontamento<input class="" id="dataApontamento"
					name="dataApontamento" placeholder="Data Apontamento"
					required="required" value="" />
			</div>
			<div>
				Hora Início<input class="" name="horaInicio" id="horaInicio"
					placeholder="Hora de Início" required="required" type="time" />
			</div>
			<div>
				Hora Término<input class="" name="horaTermino" id="horaTermino"
					placeholder="Hora de Término" required="required" type="time" />
			</div>
		</div>
		<br>
		<button class="" type="submit" >Cadastrar</button>
		<a class="" href="/sustentacao/painel/apontamentos" type="button">Cancelar</a>
	</form>
</body>
</html>