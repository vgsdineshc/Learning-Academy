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
<form action="LoadActionSubject" method="post">
<table border="1">
<tr>
<%ArrayList<SubjectClass> subjectList = (ArrayList)session.getAttribute("getSuList"); 
int j =1;
System.out.println(subjectList.size());
if(subjectList.size()>0)
{%>
<td>Subject Name : <input type="text" name = "sname" value="<%=subjectList.get(0).getSname()%>"></td>
<%} else {
String clear = "";
%>
<td>Subject Name : <input type="text" name = "sname" value="<%=clear%>"></td>
<%} %>
<td><input type="submit" value="SAVE OR UPDATE"></td>
</tr>
</table>
</form>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>