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
	<form class=""
		action="/sustentacao/painel/apontamentos/cadastrar-apontamento"
		method="post">
		<div>
			<div>
				<select name="${tarefa.id}" hidden="hidden">
					<c:forEach var="apt" items="${apontamento}">
						<option value="${apt.tarefa.id}" />
					</c:forEach>
				</select>
			</div>
			<div>
				Descri��o<input class="" name="descricao" placeholder="Descri��o"
					required="required" />
			</div>
			<div>

				Data Apontamento<input class="" id="dataApontamento"
					name="dataApontamento" placeholder="Data Apontamento"
					required="required"
					value="<fmt:formatDate value="dataApontamento" pattern="dd-mm-yyyy"/>" />
			</div>
			<div>
				Hora In�cio<input class="" name="horaInicio"
					placeholder="Hora de In�cio" required="required" />
			</div>
			<div>
				Hora T�rmino<input class="" name="horaTermino"
					placeholder="Hora de T�rmino" required="required" />
			</div>
		</div>
		<br>
		<button class="" type="submit">Cadastrar</button>
		<button class="" value="" type="button">Cancelar</button>
	</form>
</body>
</html>