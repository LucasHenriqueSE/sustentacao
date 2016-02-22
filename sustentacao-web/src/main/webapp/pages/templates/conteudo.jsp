<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset=UTF-8>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/jquery.dataTables.min.css"></c:url>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/style.css"></c:url>' />
</head>
<body>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-2.2.0.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery.dataTables.min.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery.maskedinput.js"></c:url>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
	
	<tiles:insertAttribute name="cabecalho" />

	<tiles:insertAttribute name="conteudo" />

	<tiles:insertAttribute name="rodape" />
	
</body>
</html>