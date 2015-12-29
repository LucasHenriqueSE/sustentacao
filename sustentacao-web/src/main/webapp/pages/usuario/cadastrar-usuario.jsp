<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="" action="/painel/listar-usuarios/cadastrar" method="post">
		<br>
		<input id="id" value="" type="hidden">
		Nome <input class="" id="nome" name="nome"/><br>
		Email <input class="" id="email" name="email"/><br>
		Login <input class="" id="login" name="login"/><br>
		Senha <input class="" id="senha" name="senha" type="password" /><br>
		<c:forEach var="perfil" items="tipoPerfil">
			<select ></select>
			<select class="" id="perfil" name="perfil" ></select><br><br>
		</c:forEach>
		
		<button class="" value="" type="submit">Cadastrar Novo</button>
		<button class="" value="" type="submit">Editar</button>
	</form>
</body>
</html>