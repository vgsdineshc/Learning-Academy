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
<a href="StudentclassAction?actionname=ADDNEWSTUDENT_0">
<input type="button" value="Add New Student">
</a>
</form>

<%ArrayList<Studentclass> studentclasseslist = (ArrayList)session.getAttribute("studentclasseslist");
if(studentclasseslist.size()>0)
{%>
<table  border="1" bgcolor = "lightblue">
<tr bgcolor = "navyblue">
<td>Sl.No</td>
<td>Student Name</td>
<td>First Name</td>
<td>Last Name</td>
<td>Date Of Birth</td>
<td>Joined Date</td>
<td>Class Name</td>
<td>Address</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%
int j=1;
for(int i = 0; i<studentclasseslist.size();i++)
{%>
<tr>
<td><%=j++%></td>
<td><%=studentclasseslist.get(i).getSuname()%></td>
<td><%=studentclasseslist.get(i).getSufirstname()%></td>
<td><%=studentclasseslist.get(i).getSulastname()%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(studentclasseslist.get(i).getDob())%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(studentclasseslist.get(i).getJoineddate())%></td>
<td><%=studentclasseslist.get(i).getCname()%></td>
<td><%=studentclasseslist.get(i).getAddress()%></td>
<td><a href="StudentclassAction?actionname=EDIT_<%=studentclasseslist.get(i).getSuid()%>"><input type="button" value="EDIT"></a></td>
<td><a href="StudentclassAction?actionname=DELETE_<%=studentclasseslist.get(i).getSuid()%>"><input type="button" value="DELETE"></a></td>
</tr>
<%}
} else {
	%>
	<b> Please add new Student if no records found </b>
	
<%}%>


</table>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>