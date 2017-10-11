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
<meta charset="iso-8859-1">
<title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p>Det er kun registrerte deltagere som får se deltagerlisten.
Logg inn ved å gi mobil-nummeret ditt.</p>
<form action="Login" method="post">
  <fieldset>
    <%--<legend>Logg inn</legend>--%>
    <p>Mobil: <input type="password" name="mob" value="${mob}"/>${merrr}</p>
    <p><input type="submit" value="Logg inn" /></p>
  </fieldset>
</form>
<p>Om du ikke har registrert deg, kan du gjøre det her:</p>
<form action="Paamelding" method="get">
  <p><input type="submit" value="Meld på"></p>
</form>
<form action="Kasserer">
    <fieldset>
        <legend>Kasserer login</legend>
        <input type="submit" value="Kasserer login">
    </fieldset>
</form>

</body>
</html>