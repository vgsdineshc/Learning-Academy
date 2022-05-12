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
<form action="TeacherclassAction" method="post">
<table border="1" bgcolor = "lightgreen">
<%ArrayList<Teacher> teacherclasseslist = (ArrayList)session.getAttribute("teacherclasseslist");%>
<%if(teacherclasseslist.size() > 0)
{%>
	<tr>
<td>Teacher Name 	:</td><td> <input type="text" name="tname" value="<%=teacherclasseslist.get(0).getTname()%>"></td></tr><tr>
<td>First Name 		:</td><td> <input type="text" name="tufsname" value="<%=teacherclasseslist.get(0).getTfirstname()%>"></td></tr><tr>
<td>Last Name 		:</td><td> <input type="text" name="tulsname" value="<%=teacherclasseslist.get(0).getTlastname()%>"></td></tr><tr>
<td>Phone No 		: </td><td><input type="text" name="phno" value="<%=teacherclasseslist.get(0).getPhonenumber()%>"></td></tr><tr>
<td>DOB 			: </td><td><input type="date" name="dob" value="<%=teacherclasseslist.get(0).getDob().toString()%>" placeholder="dd-mm-yyyy"></td></tr><tr>
<td>Joining Date 	: </td><td><input type="date" name="jod" value="<%=teacherclasseslist.get(0).getJoineddate().toString()%>" placeholder="dd-mm-yyyy"></td></tr><tr>
<td>Address	: </td><td><input type="text" name="address" value="<%=teacherclasseslist.get(0).getAddress()%>"></td></tr><tr>
<td>Designation	: </td><td><input type="text" name="designation" value="<%=teacherclasseslist.get(0).getDesignation()%>"></td></tr><tr>
<td><input type="hidden" name="tid" value="<%=teacherclasseslist.get(0).getTid()%>"></td></tr><tr>
</tr>
<%} else { %>
<tr>
<td>Teacher Name 	:</td><td> <input type="text" name="tname"></td></tr><tr>
<td>First Name 		:</td><td> <input type="text" name="tufsname"></td></tr><tr>
<td>Last Name 		:</td><td> <input type="text" name="tulsname"></td></tr><tr>
<td>Phone No 		: </td><td><input type="text" name="phno"></td></tr><tr>
<td>DOB 			: </td><td><input type="date" name="dob" value=""></td></tr><tr>
<td>Joining Date 	: </td><td><input type="date" name="jod" value=""></td></tr><tr>
<td>Address	: </td><td><input type="text" name="address"></td></tr><tr>
<td>Designation	: </td><td><input type="text" name="designation" value=""></td></tr><tr>
<td><input type="hidden" name="tid" value="0"></td></tr><tr>
<%} %>
</table>
<table>
<tr><td> <input type="submit" value="Save OR Update"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>