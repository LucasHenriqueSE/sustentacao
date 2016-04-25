<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu-tarefas").attr('class', 'active');
	});
</script>
<title>Cadastrar Tarefa</title>
</head>
<body>
	<div class="section">
		<div class="container">
			<h4 class="title-screen">Cadastro de Tarefas</h4>
			<hr />
			<div id="alertas"></div>
			<form action="/sustentacao/painel/tarefa/cadastrar" method="POST"
				role="form">
				<div class="row">
					<div class="form-group col-md-2 col-md-offset-3">
						<label for="tipoTarefa">Tipo de Tarefa</label> <select
							class="form-control" id="tipoTarefa" name="tipo.id">
							<option label="Selecione" selected="selected" value="" />
							<c:forEach var="listaTipo" items="${tipo}">
								<option value="${listaTipo.id}">${listaTipo.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="numeroChamado">Número do Chamado</label> <input
							class="form-control" id="numeroChamado" name="numeroChamado"
							placeholder="Número do Chamado" />
					</div>
					<div class="row col-md-6 col-md-offset-3">
						<div class="form-group">
							<label for="descricao">Descrição</label>
							<textarea class="form-control" id="descricao" name="descricao"
								placeholder="Descrição" rows="7"></textarea>
						</div>
					</div>
					<div style="clear: both;">
						<button class="btn btn-default"
							style="float: right; background-color: #004592; color: #fff; border-color: #004592;"
							type="submit">Salvar</button>
						<a class="btn btn-default"
							style="float: left; background-color: #004592; color: #fff; border-color: #004592;"
							href="/sustentacao/painel/tarefas" type="button">Cancelar</a>
					</div>
			</form>
		</div>
	</div>
</body>
</html>