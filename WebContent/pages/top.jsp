<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.pojo.*"%>
<%@page import="com.actions.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1"
           bgcolor="lightgreen"> 
<tr>
<td><a href="TopMenuActions?actionMenu=CL"> Classes List</a></td>
<td><a href="TopMenuActions?actionMenu=SL"> Student List</a></td>
<td><a href="TopMenuActions?actionMenu=SUL"> Subject List</a></td>
<td><a href="TopMenuActions?actionMenu=TL"> Teacher List</a></td>
<td><a href="logout"> Logout</a></td>
<%session.setAttribute(LoginCred.uName, session.getAttribute(LoginCred.uName));%>
<td>UserName : <b><%=session.getAttribute(LoginCred.uName)%></b></td>
</tr>
    </table>
</body>
</html>