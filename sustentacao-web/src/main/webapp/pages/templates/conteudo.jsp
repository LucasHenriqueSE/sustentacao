<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset=UTF-8>
<style type="text/css">
	<%@include file="/resources/static/css/bootstrap.min.css" %>
	<%@include file="/resources/static/css/style.css" %>
</style>
</head>
<body>
	<tiles:insertAttribute name="cabecalho" />

	<tiles:insertAttribute name="conteudo" />

	<tiles:insertAttribute name="rodape" />
</body>
</html>