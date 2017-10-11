<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="no.hib.dat104.DBKom" %>
<%@ page import="no.hib.dat104.Varer" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: preben
  Date: 11-Sep-17
  Time: 02:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
 <%--   <c:if test="${innloggetBruker == null}">
        <%response.sendRedirect("/Login");%>
    </c:if>--%>
<html>
    <head>
        <title>HandleListe</title>
    </head>
    <body>
        <h1>Min Handleliste</h1>
        <form action="Handle" method="post">
            <input type="text" name="vare" autofocus>
            <input type="submit" value="Legg Til">
        </form>
            <c:forEach var="vr" items="${vareliste}">
                <form action="Handle" method="post">
                <input type="submit" value="Slett"> ${vr}<br>
                <input type="hidden" name="slett" value=${vr.varenavn}>
                </form>
            </c:forEach>
</body>
</html>