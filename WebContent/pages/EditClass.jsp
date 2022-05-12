<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<%@include file="/pages/top.jsp" %>
<br>
<form action="LoadActionClasses" method="post">
<table border="1">
<tr>
<td>Class Name : <input type="text" name = "cName" ></td>
<td><input type="submit" value="SAVE OR UPDATE"></td>
</tr>
</table>
</form>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>