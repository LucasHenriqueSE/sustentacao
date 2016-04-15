<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Cadastrar Tarefa</title>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<form action="/sustentacao/painel/tarefa/cadastrar" method="POST">
					<div class="row">
						<br> <br>
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
					</div>
					<div class="row col-md-6 col-md-offset-3" >
						<div class="form-group">
							<label for="descricao">Descrição</label>
							<textarea class="form-control" id="descricao" name="descricao"
								placeholder="Descrição" rows="7"></textarea>
						</div>
					</div>
					<br>
					<div style="clear: both;">
					<button class="btn btn-default" style="float: right;" type="submit">Salvar</button>
					<a class="btn btn-default" style="float: left;"
						href="/sustentacao/painel/tarefas" type="button">Cancelar</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>