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
	<form class="" action="" method="post">
		<div>
			<br> <br>
				<div>
					Tipo de Tarefa <select required="required">
						<option label="Selecione" selected="selected" value=""/>
						<c:forEach var="listaTipo" items="${tipo}">
							<option value="${listaTipo.id}">${listaTipo.nome}</option>
						</c:forEach>
					</select>
				</div>
			<div>
				Descrição<input class="" name="descricao" placeholder="Descrição"
					required="required" />
			</div>
			<div>
				Número do Chamado<input class="" name="numeroChamado"
					placeholder="Número do Chamado" required="required" />
			</div>
			<div>
				Status <select required="required">
					<option label="Selecione" selected="selected" value="" />
					<c:forEach var="listaStatus" items="lista">
						<option value="${listaStatus.id}">${listaStatus.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				Horas Disponíveis<input class="" name="qtdHorasDisponiveis"
					placeholder="Horas Disponíveis" required="required" />
			</div>
		</div>
		<br>
		<button class="" value="cadastrarTarefa()" type="submit">Cadastrar</button>
		<button class="" value="" type="button">Cancelar</button>
	</form>
</body>
</html>