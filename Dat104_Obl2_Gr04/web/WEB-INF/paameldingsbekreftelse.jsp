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
<title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp;${fname}<br/>
&nbsp;&nbsp;&nbsp;${lname}<br/>
&nbsp;&nbsp;&nbsp;${mob}<br/>
&nbsp;&nbsp;&nbsp;${kjoen}</p>
<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href="Oversikt">Gå til deltagerlisten</a>
</body>
</html>