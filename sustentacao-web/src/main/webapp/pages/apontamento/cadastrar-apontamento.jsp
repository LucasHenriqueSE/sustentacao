<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<script
	src="<c:url value="/resources/js/jquery.maskedinput.js"></c:url>"></script>
<script type="text/javascript" id="mascaraDataHora">
	$(document).ready(function() {
		$("#menu-apontamentos").attr('class', 'active');
		$('#dataApontamento').mask('99/99/9999');
		$('#horaInicio').mask('99:99');
		$('#horaTermino').mask('99:99');
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
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Apontar Horas</h4>
			<hr />
			<div id="alertas"></div>
			<form action="/sustentacao/painel/tarefa/cadastrar-apontamento"
				method="POST" role="form" id="cadastroApontamento">
				<div>
					<input id="idTarefa" name="tarefa.id" value="${idTarefa}"
						type="hidden" />
				</div>
				<div class="row">
					<div class="form-group col-md-6 col-md-offset-3">
						<label for="descricao">Descrição</label>
						<textarea class="form-control" id="descricao" name="descricao"
							placeholder="Descrição" rows="3" required autofocus></textarea>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-2 col-md-offset-3">
						<label>Data Apontamento:</label> <input type="text"
							class="form-control" id="dataApontamento" name="dataApontamento"
							required>
					</div>
					<div class="form-group col-md-2">
						<label>Hora Início:</label> <input type="text"
							class="form-control" id="horaInicio" name="horaInicio"
							pattern="([01][0-9]|2[0-3]):[0-5][0-9]" required />
					</div>
					<div class="form-group col-md-2">
						<label>Hora Término:</label> <input type="text"
							class="form-control" id="horaTermino" name="horaTermino"
							pattern="([01][0-9]|2[0-3]):[0-5][0-9]" required>
					</div>
				</div>
				<hr />
				<div
					class="form-group col-xs-offset-0 hidden-md hidden-lg hidden-xl"
					style="margin-bottom: 70px;">
					<a href='<c:url value="/painel/tarefas"/>' class="btn btn-return">Cancelar</a>
					<button type="submit" class="btn btn-add">Salvar
						Apontamento</button>
				</div>
				<div class="form-group col-xs-offset-0 hidden-xs hidden-sm"
					style="margin-bottom: 70px;">
					<a href='<c:url value="/painel/tarefas" />' class="btn btn-return">Cancelar</a>
					<button type="submit" class="btn btn-add">Salvar
						Apontamento</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>