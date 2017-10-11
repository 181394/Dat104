<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: prebe
Date: 28-Sep-17
Time: 11:13 AM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table border="1">
<tr bgcolor="#cccccc"><th>Kjønn</th><th align="left">Navn</th></tr>
    <c:forEach var="d" items="${deltakere}">
        <c:choose>
            <c:when test="${d.mob == mobil && d.betalt}">
                <c:set value="#aaffaa" var="farge"/>
        </c:when>
            <c:when test="${d.mob == mobil && !d.betalt}">
                <c:set value="#ffaaaa" var="farge"/>
            </c:when>
            <c:otherwise>
                <c:set value="#ffffff" var="farge"/>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${d.kjoen == \"mann\"}">
                <c:set value="&#9794;" var="kjonn"/>
            </c:when>
            <c:otherwise>
                <c:set value="&#9792;" var="kjonn"/>
            </c:otherwise>
        </c:choose>
<tr bgcolor="${farge}"><td align="center">${kjonn}</td><td>${d.fname} ${d.lname}</td></tr>
    </c:forEach>
<%--<tr bgcolor="#ffaaaa"><td align="center">&#9794;</td><td>Arne Arnesen</td></tr>--%>
<!-- <tr bgcolor="#aaffaa"><td align="center">&#9794;</td><td>Arne Arnesen</td></tr> -->
<%--<tr><td align="center">&#9792;</td><td>Berit Beritsen</td></tr>--%>
</table>
<form action="Logout" method="post">
    <input type="submit" value="Logg ut">
</form>
</body>
</html>