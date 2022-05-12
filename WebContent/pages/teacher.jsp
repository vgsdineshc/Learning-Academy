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
<a href="TeacherclassAction?actionname=ADDNEWTEACHER_0">
<input type="button" value="Add New Teacher">
</a>
</form>
<%ArrayList<Teacher> teacherclasseslist = (ArrayList)session.getAttribute("teacherclasseslist");
if(teacherclasseslist.size()>0)
{%>
<table  border="1" bgcolor = "lightblue">
<tr bgcolor = "navyblue">
<td>Sl.No</td>
<td>Teacher Name</td>
<td>First Name</td>
<td>Last Name</td>
<td>Date Of Birth</td>
<td>Joined Date</td>
<td>Designation</td>
<td>Address</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%
int j=1;
for(int i = 0; i<teacherclasseslist.size();i++)
{%>
<tr>
<td><%=j++%></td>
<td><%=teacherclasseslist.get(i).getTname()%></td>
<td><%=teacherclasseslist.get(i).getTfirstname()%></td>
<td><%=teacherclasseslist.get(i).getTlastname()%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(teacherclasseslist.get(i).getDob())%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(teacherclasseslist.get(i).getJoineddate())%></td>
<td><%=teacherclasseslist.get(i).getDesignation()%></td>
<td><%=teacherclasseslist.get(i).getAddress()%></td>
<td><a href="TeacherclassAction?actionname=EDIT_<%=teacherclasseslist.get(i).getTid()%>"><input type="button" value="EDIT"></a></td>
<td><a href="TeacherclassAction?actionname=DELETE_<%=teacherclasseslist.get(i).getTid()%>"><input type="button" value="DELETE"></a></td>
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