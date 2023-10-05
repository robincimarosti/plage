<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réservation</title>
<jsp:include page="include/header.jsp"/>
</head>
<body>
<jsp:include page="include/entete.jsp"></jsp:include>
<h1><spring:message code="reservation"/></h1>
<!-- Avec la méthode post, on envoie les informations dans le corps de la requête HTTP -->
<form:form method="post" modelAttribute="reservation" action="reservation">
<form:label path="client" class="col-sm-1 control-label">Client</form:label>
<form:label path="client">${reservation.client.nom}</form:label>
<br>
<form:label path="dateDebut" class="col-sm-1 control-label">Date de début</form:label>
<form:input path="dateDebut" type="date"/>
<form:errors path="dateDebut" cssClass="erreur"/>
<br>
<form:label path="dateFin" class="col-sm-1 control-label">Date de fin</form:label>
<form:input path="dateFin" type="date"/>
<form:errors path="dateFin" cssClass="erreur"/>
<br>
<c:forEach items="${reservation.parasols}" var="parasol" varStatus="status">
<form:label path="parasols[${status.index}]" class="col-sm-1 control-label">File</form:label>
<form:select path="parasols[${status.index}]" multiple="false">
<form:option value="0">Merci de choisir une file</form:option>
<form:options items="${parasols}" itemValue="id" itemLabel="numeroDeLaFile"/>
</form:select><form:errors cssClass="erreur" path="parasols[${status.index}]"/>
<br>
</c:forEach>
<form:label path="remarques" class="col-sm-1 control-label">Remarques</form:label>
<form:textarea path="remarques"/>
<br>
<form:button>Enregistrer</form:button>
</form:form>
<jsp:include page="include/piedDePage.jsp"></jsp:include>
</body>
</html>