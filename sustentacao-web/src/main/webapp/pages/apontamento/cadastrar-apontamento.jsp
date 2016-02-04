<!-- <script -->
<%-- 	src="<c:url value="/resources/js/jquery.maskedinput.js"></c:url>"></script> --%>
<script type="text/javascript">
// 	$(document).ready(function() {
// 		$("#dataApontamento").mask("99/99/9999");
// 		$("#horaInicio").mask("99:99");
// 		$("#horaTermino").mask("99:99");
// 	});
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
<title>Cadastrar Apontamento</title>
<form class="" id="formApt"
	action="/sustentacao/painel/tarefa/cadastrar-apontamento" method="post"
	onsubmit="compararHora();">
	<div>
		<div>
			<input id="idTarefa" name="tarefa.id" value="${idTarefa}"
				type="hidden" required />
		</div>
		<div class="input-group">
			<label for="descricao">Descri��o</label> <input class="form-control"
				id="descricao" name="descricao" placeholder="Descri��o" />
		</div>
		<div class="input-group">
			<label for="dataApontamento">Data Apontamento</label> <input
				class="form-control" id="dataApontamento" name="dataApontamento"
				placeholder="Data Apontamento" type="datetime" />
		</div>
		<div class="input-group">
			<label for="horaInicio">Hora In�cio</label> <input
				class="form-control" name="horaTermino" id="horaInicio"
				placeholder="Hora de Inicio" />
		</div>
		<div class="input-group">
			<label for="horaTermino">Hora T�rmino</label> <input
				class="form-control" name="horaTermino" id="horaTermino"
				placeholder="Hora de T�rmino" onblur="validar();" />
		</div>
	</div>
	<br>
	<button class="btn btn-default" type="submit">Cadastrar</button>
	<a class="btn btn-default" href="/sustentacao/painel/tarefas"
		type="button">Cancelar</a>
</form>