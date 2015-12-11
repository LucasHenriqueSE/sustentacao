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
		<br>
		<input class="" name="dataCadastro" type="hidden"/>
		<div>
			<div>
				Tarefa
				<select required="required">
					<option label="" selected="selected" value="" />
				</select>			
			</div>
			<div>
				Descrição<input class="" name="descricao" placeholder="Descrição" required="required"/>
			</div>
			<div>
				Data Apontamento<input class="" name="dataApontamento" placeholder="Data Apontamento" required="required"/>
			</div>
			<div>
				Hora Início<input class="" name="horaInicio" placeholder="Hora de Início" required="required" />
			</div>
			<div>
				Hora Término<input class="" name="horaTermino" placeholder="Hora de Término" required="required" />
			</div>
		</div>
		<br>
		<button class="" value="" type="submit">Cadastrar</button>
		<button class="" value="" type="button">Cancelar</button>
	</form>
</body>
</html>