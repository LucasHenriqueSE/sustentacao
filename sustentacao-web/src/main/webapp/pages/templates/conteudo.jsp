<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<body>
	<tiles:insertAttribute name="cabecalho" />

	<tiles:insertAttribute name="conteudo" />

	<tiles:insertAttribute name="rodape" />
</body>