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
<form action="StudentclassAction" method="post">
<table border="1" bgcolor = "lightgreen">
<%ArrayList<Studentclass> studentclasseslist = (ArrayList)session.getAttribute("studentclasseslist");%>
<%if(studentclasseslist.size() > 0)
{%>
	<tr>
<td>Student Name 	:</td><td> <input type="text" name="suname" value="<%=studentclasseslist.get(0).getSuname()%>"></td></tr><tr>
<td>First Name 		:</td><td> <input type="text" name="sufsname" value="<%=studentclasseslist.get(0).getSufirstname()%>"></td></tr><tr>
<td>Last Name 		:</td><td> <input type="text" name="sulsname" value="<%=studentclasseslist.get(0).getSulastname()%>"></td></tr><tr>
<td>Phone No 		: </td><td><input type="text" name="phno" value="<%=studentclasseslist.get(0).getPhonenumber()%>"></td></tr><tr>
<td>DOB 			: </td><td><input type="date" name="dob" value="<%=studentclasseslist.get(0).getDob().toString()%>" placeholder="dd-mm-yyyy"></td></tr><tr>
<td>Joining Date 	: </td><td><input type="date" name="jod" value="<%=studentclasseslist.get(0).getJoineddate().toString()%>" placeholder="dd-mm-yyyy"></td></tr><tr>
<td>Address	: </td><td><input type="text" name="address" value="<%=studentclasseslist.get(0).getAddress()%>"></td></tr><tr>
<td><input type="hidden" name="suid" value="<%=studentclasseslist.get(0).getSuid()%>"></td></tr><tr>
<td> Classes 		: </td><td><select name = "cid" >
<%ArrayList<Classes> classList = (ArrayList)session.getAttribute("classList"); 
for(int i = 0; i<classList.size();i++)
{%>
<option value="<%=classList.get(i).getCid()%>" selected="selected"> <%=classList.get(i).getCname()%></option>
<%} %>
</select></td>
</tr>
<%} else { %>
<tr>
<td>Student Name 	:</td><td> <input type="text" name="suname"></td></tr><tr>
<td>First Name 		:</td><td> <input type="text" name="sufsname"></td></tr><tr>
<td>Last Name 		:</td><td> <input type="text" name="sulsname"></td></tr><tr>
<td>Phone No 		: </td><td><input type="text" name="phno"></td></tr><tr>
<td>DOB 			: </td><td><input type="date" name="dob" value=""></td></tr><tr>
<td>Joining Date 	: </td><td><input type="date" name="jod" value=""></td></tr><tr>
<td>Address	: </td><td><input type="text" name="address"></td></tr><tr>
<td><input type="hidden" name="suid" value="0"></td></tr><tr>
<td> Classes 		: </td><td><select name = "cid">
<%ArrayList<Classes> classList = (ArrayList)session.getAttribute("classList"); 
for(int i = 0; i<classList.size();i++)
{%>
<option value="<%=classList.get(i).getCid()%>"> <%=classList.get(i).getCname()%></option>
<%} %>
</select></td>
</tr>
<%} %>
</table>
<table>
<tr><td> <input type="submit" value="Save OR Update"></td></tr>
</table>
</form>
</fieldset>
</body>
</html>