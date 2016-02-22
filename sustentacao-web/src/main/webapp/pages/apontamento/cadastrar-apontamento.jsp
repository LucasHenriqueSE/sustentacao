<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="<c:url value="/resources/js/jquery.maskedinput.js"></c:url>"></script>
<script type="text/javascript" id="mascaraDataHora">
	$(document).ready(function() {
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
<title>Cadastrar Apontamento</title>
<div class="alert alert-danger alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>
<form class="" id="cadastroApontamento"
	action="/sustentacao/painel/tarefa/cadastrar-apontamento" method="POST"
	onsubmit="compararHora();">
	<div>
		<div>
			<input id="idTarefa" name="tarefa.id" value="${idTarefa}"
				type="hidden" />
		</div>
		<div class="input-group">
			<label for="descricao">Descrição</label> <input class="form-control"
				id="descricao" name="descricao" placeholder="Descrição" />
		</div>
		<div class="input-group">
			<label for="dataApontamento">Data Apontamento</label> <input
				class="form-control" id="dataApontamento" name="dataApontamento"
				placeholder="Data Apontamento" />
		</div>
		<div class="input-group">
			<label for="horaInicio">Hora Início</label> <input
				class="form-control" name="horaInicio" id="horaInicio"
				placeholder="Hora de Inicio" />
		</div>
		<div class="input-group">
			<label for="horaTermino">Hora Término</label> <input
				class="form-control" name="horaTermino" id="horaTermino"
				placeholder="Hora de Término" onblur="validar();" />
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Cadastrar</button>
	<a class="btn btn-default" href="/sustentacao/painel/tarefas"
		type="button">Cancelar</a>
</form>