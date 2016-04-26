<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Painel de Navegação</title>
</head>
<body>
	<div class="section">
		<div class="container">
				<c:if test="${usuario.perfil.id == 2}">
					<h4 class="title-screen">Painel - Usuário</h4>
					<hr />
					<h5 style="color: #004592;">Seja Bem-vindo ${usuario.nome} ao Sistema Sustentação</h5>
				</c:if>
		</div>
	</div>
</body>
</html>