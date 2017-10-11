<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

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
<title>Betalingsoversikt</title>
</head>
<body>
<h2>Betalingsoversikt</h2>

<table border="1">
<tr bgcolor="#cccccc"><th align="left">Navn</th><th>Mobil</th><th>Betalingsstatus</th></tr>
<c:forEach var="deltaker" items="${dliste}">
    <c:choose>
        <c:when test="${deltaker.betalt}">
            <c:set value="<td align=\"center\">Betaling mottatt</td>" var="status"/>
        </c:when>
        <c:otherwise>
            <c:set value="<td><input type=\"submit\" name=\"${deltaker.mob}\" value=\"Registrer betaling\" /></td>" var="status"/>
        </c:otherwise>
    </c:choose>
    <c:set var ="mob" value="${deltaker.mob}"/>
    <c:set var="mob1" value="${fn:substring(mob,0,3)}"/>
    <c:set var="mob2" value="${fn:substring(mob, 3,5)}"/>
    <c:set var="mob3" value="${fn:substring(mob, 5, 8)}"/>
    <form action="Betaling" method="post">
    <tr><td>${deltaker.fname} ${deltaker.lname}</td><td>${mob1} ${mob2} ${mob3}</td>${status}</tr>
    <input type="hidden" value="${deltaker.mob}" name="mob"/>
    </form>
</c:forEach>
</table>

<form action="Logout" method="post">
    <input type="submit" value="Logg ut">
</form>
</body>
</html>