<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
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
<title>Editar Apontamento</title>
<form id="formApt" action="/sustentacao/painel/apontamento/editar"
	method="POST" onsubmit="compararHora();">
	<div>
		<div>
			<input id="idApontamento" name="id" value="${idApontamento}"
				type="hidden" />
		</div>
		<div>
			<input id="idTarefa" name="tarefa.id"
				value="${apontamento.tarefa.id}" type="hidden">
		</div>
		<div>
			<input id="dataEdicao" name="dataEdicao"
				value='<fmt:formatDate value="${apontamento.dataEdicao.time}"/>'
				type="hidden" />
		</div>
		<div>
			<input id="dataCadastro" name="dataCadastro"
				value='<fmt:formatDate value="${apontamento.dataCadastro.time}"/>'
				type="hidden" />
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
				value='<fmt:formatDate value="${apontamento.horaInicio.time}" pattern="HH:mm"/>' />
		</div>
		<div class="input-group">
			<label for="horaTermino">Hora Término</label> <input
				class="form-control" name="horaTermino" id="horaTermino"
				value='<fmt:formatDate value="${apontamento.horaTermino.time}" pattern="HH:mm"/>'
				onblur="validar();" />
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Cadastrar</button>
	<a class="btn btn-default" href="/sustentacao/painel/apontamentos"
		type="button">Cancelar</a>
</form>