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
    <title>Kasserer login</title>
</head>
<body>
<h2>Kasserer login</h2>
<form action="Kasserer" method="post">
    <fieldset>
    <legend>Kasserer login</legend>
    <p>Passord: <input type="password" name="pass" autofocus/>${perr}</p>
    <input type="submit" value="Logg inn"/>
    </fieldset>
</form>
<form action="Logout" method="post">
    <input type="submit" value="Tilbake">
</form>

</body>
</html>