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
	<form class="" action="/sustentacao/painel/tarefas/editar"
		method="post">
		<div>
			<br> <br>
			<div>
				Tipo de Tarefa <select required name="tipo.id">
					<c:forEach var="listaTipo" items="${tipo}">
						<option value="${listaTipo.id}" selected label="${listaTipo.nome}" />
					</c:forEach>
				</select>
			</div>
			<div>
				Número do Chamado<input class="" name="numeroChamado"
					value="${numeroChamado}" required />
			</div>
			<div>
				Descrição<input class="" name="descricao" value="${descricao}"
					required />
			</div>
			<%-- 			<c:forEach var="listaTipo" items="${tipo}"> --%>
			<c:if test="${id == 3 || id == 4}">
				<div>
					Horas Disponíveis<input class="" name="qtdHorasDisponiveis"
						value="${qtdHorasDisponiveis}" required />
				</div>
			</c:if>
			<%-- 			</c:forEach> --%>
			<div>
				<select required name="status.id">
					<c:forEach var="listaStatus" items="${status}">
						Status<option selected label="${listaStatus.nome}"
							value="${listaStatus.nome}" />
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