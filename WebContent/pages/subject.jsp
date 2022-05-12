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
<form action="#">
<a href="LoadActionSubject?actionname=ADDNEWSUB_0">
<input type="button" value="Add New Subject">
</a>
</form>
<table  border="1" bgcolor = "lightblue">

<%ArrayList<SubjectClass> subjectList = (ArrayList)session.getAttribute("getSuList"); 
int j =1;
if(subjectList.size()>0)
{%>
<tr bgcolor = "navyblue">
<td>Sl.No</td>
<td>Subject Name</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%for(int i = 0; i<subjectList.size();i++)
{%>
<tr>
<td><%=j++%></td>
<td><%=subjectList.get(i).getSname()%></td>
<td><a href="LoadActionSubject?actionname=EDIT_<%=subjectList.get(i).getSid()%>"><input type="button" value="EDIT"></a></td>
<td><a href="LoadActionSubject?actionname=DELETE_<%=subjectList.get(i).getSid()%>"><input type="button" value="DELETE"></a></td>
</tr>
<%}}else{ %>
<b>No records Found Please add New Subject </b>
<%} %>

</table>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>