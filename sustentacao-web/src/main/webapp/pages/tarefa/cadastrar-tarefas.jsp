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
	<form class="" action="/sustentacao/painel/tarefas/cadastrar" method="post">
		<div>
			<br> <br>
				<div>
					Tipo de Tarefa <select required="required">
						<option label="Selecione" selected="selected" value=""/>
						<c:forEach var="listaTipo" items="${tipo}">
							<option label="${listaTipo.nome}" value="${listaTipo.id}" />
						</c:forEach>
					</select>
				</div>
			<div>
				Descrição<input class="" name="descricao" value="" placeholder="Descrição"
					required="required" />
			</div>
			<div>
				Número do Chamado<input class="" name="numeroChamado"
					placeholder="Número do Chamado" required="required" />
			</div>
			<div>
				Status <select required="required">
					<option label="Selecione" selected="selected" value="" />
					<c:forEach var="listaStatus" items="${status}">
						<option label="${listaStatus.nome}" value="${listaStatus.id}" />
					</c:forEach>
				</select>
			</div>
			<div>
				Horas Disponíveis<input class="" name="qtdHorasDisponiveis"
					placeholder="Horas Disponíveis" required="required" />
			</div>
		</div>
		<br>
		<a class="" href="/sustentacao/painel/tarefas/cadastrar-tarefas" type="button">Cadastrar</a>
		<button class="" value="" type="button">Cancelar</button>
	</form>
</body>
</html>