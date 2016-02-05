<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				alert('Horas dispon�veis insuficientes');
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
<title>Editar Apontamento</title>
<form id="formApt" action="/sustentacao/painel/apontamento/${idApontamento}/editar"
	method="POST" onsubmit="compararHora();">
	<div>
		<div>
			<input id="idTarefa" name="apontamento.tarefa.id"
				value="${apontamento.tarefa.id}" type="hidden" />
				
			<input id="idApontamento" name="apontamento.id"
				value="${{idApontamento}}" type="hidden" />
		</div>
		<div class="input-group">
			<label for="descricao">Descri��o</label> <input class="form-control"
				id="descricao" name="descricao" value="${apontamento.descricao}" />
		</div>
		<div class="input-group">
			<label for="dataApontamento">Data Apontamento</label> <input
				class="form-control" id="dataApontamento" name="dataApontamento"
				value='<fmt:formatDate value="${apontamento.dataApontamento.time}"/>' />
		</div>
		<div class="input-group">
			<label for="horaInicio">Hora In�cio</label> <input
				class="form-control" name="horaInicio" id="horaInicio"
				value="${horaInicio}" />
		</div>
		<div class="input-group">
			<label for="horaTermino">Hora T�rmino</label> <input
				class="form-control" name="horaTermino" id="horaTermino"
				value="${horaTermino}" onblur="validar();" />
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Cadastrar</button>
	<a class="btn btn-default" href="/sustentacao/painel/apontamentos"
		type="button">Cancelar</a>
</form>