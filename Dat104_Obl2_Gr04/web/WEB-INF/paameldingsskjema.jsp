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
    <title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form action="Paamelding" method="post">
    <fieldset>
        <legend>Personlige data</legend>
        <p>${berr}</p>
        <p>Fornavn: <input type="text" name="fname" value="${fname}" autofocus/>${ferr}</p>
        <p>Etternavn: <input type="text" name="lname" value="${lname}" autofocus/>${lerr}</p>
        <p>Mobil (8 siffer): <input type="text" name="mob" value="${mob}" autofocus/>${merr}</p>
        <p>Kjønn: <input type="radio" name="kjoen" value="mann" checked="checked"/>mann
            <input type="radio" name="kjoen" value="kvinne"/>kvinne</p>
        <p><input type="submit" value="Meld meg på"/></p>
    </fieldset>
</form>
<form action="Logout" method="post">
    <input type="submit" value="Tilbake">
</form>
</body>
</html>