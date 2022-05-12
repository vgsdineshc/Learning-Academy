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
<a href="LoadActionClasses?actionname=ADDNEWCLASS_0">
<input type="button" value="Add New Class">
</a>
</form>
<table  border="1" bgcolor = "lightblue">

<%ArrayList<Classes> classList = (ArrayList)session.getAttribute("classList"); 
int j =1;
if(classList.size()>0)
{%>
<tr bgcolor = "navyblue">
<td>Sl.No</td>
<td>Class Name</td>
<td>Edit</td>
<td>Delete</td>
<td>Teachers and Subjects</td>
<td>class Report</td>
</tr>
<%for(int i = 0; i<classList.size();i++)
{%>
<tr>
<td><%=j++%></td>
<td><%=classList.get(i).getCname()%></td>
<td><a href="LoadActionClasses?actionname=EDIT_<%=classList.get(i).getCid()%>"><input type="button" value="EDIT"></a></td>
<td><a href="LoadActionClasses?actionname=DELETE_<%=classList.get(i).getCid()%>"><input type="button" value="DELETE"></a></td>
<td><a href="LoadActionClasses?actionname=TSACTION_<%=classList.get(i).getCid()%>"><input type="button" value="Teachers and Subjects"></a></td>
<td><a href="LoadActionClasses?actionname=CRACTION_<%=classList.get(i).getCid()%>"><input type="button" value="Class Report"></a></td>
</tr>
<%}}else{ %>
<b>No records Found Please add New classes </b>
<%} %>

</table>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>