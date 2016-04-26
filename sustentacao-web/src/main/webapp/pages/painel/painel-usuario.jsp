<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Painel de Navega��o</title>
</head>
<body>
	<div class="section">
		<div class="container">
				<c:if test="${usuario.perfil.id == 2}">
					<h4 class="title-screen">Painel - Usu�rio</h4>
					<hr />
					<h5 style="color: #004592;">Seja Bem-vindo ${usuario.nome} ao Sistema Sustenta��o</h5>
				</c:if>
		</div>
	</div>
</body>
</html>