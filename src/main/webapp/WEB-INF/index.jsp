<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion à Plage</title>
<jsp:include page="include/header.jsp"/>
</head>
<body>
<h1>Connexion à Plage</h1>
<c:if test="${param.notification ne null}"><h2>${param.notification}</h2></c:if>
<form action="connexion" method="post">
	<input type="email" name="EMAIL" placeHolder="Email" required><br>
	<input type="password" name="MOT_DE_PASSE" placeHolder="Mot de Passe" required><br>
	<input type="submit" value="Connexion">
</form>
<a href="client">Inscrivez-vous ici</a>
<jsp:include page="include/piedDePage.jsp"></jsp:include>
</body>
</html>