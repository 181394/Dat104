<%--
  Created by IntelliJ IDEA.
  User: prebe
  Date: 14-Sep-17
  Time: 06:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p style="color:red">Feil Passord</p>
<form action="Login" method="post">
    <fieldset>
        <legend>Please enter password.</legend>
        <input type="password" name="pass" autofocus>
        <input type="submit" value="Login">
    </fieldset>
</form>

</body>
</html>
