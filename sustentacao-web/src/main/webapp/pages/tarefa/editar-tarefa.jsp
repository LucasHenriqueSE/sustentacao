<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="" action="/sustentacao/painel/tarefas/cadastrar-tarefa"
		method="post">
		<div>
			<br> <br>
			<div>
				Tipo de Tarefa <select required name="tipo.id">
					<option label="Selecione" selected="selected" value="" />
					<c:forEach var="listaTipo" items="${tipo}">
						<option value="${listaTipo.id}">${listaTipo.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				N�mero do Chamado<input class="" name="numeroChamado"
					value="${numeroChamado}" placeholder="N�mero do Chamado" required />
			</div>
			<div>
				Descri��o<input class="" name="descricao" value="${descricao}"
					placeholder="Descri��o" required />
			</div>
			<div>
				Horas Dispon�veis<input class="" name="qtdHorasDisponiveis"
					value="${qtdHorasDisponiveis}" placeholder="Horas Dispon�veis"
					required />
			</div>
			<div>
				<select required name="status.id">
					<c:forEach var="listaStatus" items="${status}">
						<option label="${listaStatus.nome}" value="" />
					</c:forEach>
				</select>
			</div>
		</div>
		<br>
		<button class="" type="submit">Salvar</button>
		<a class="" href="/sustentacao/painel/tarefas" type="button">Cancelar</a>
	</form>
</body>
</html>