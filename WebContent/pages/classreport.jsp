<%@page import="java.sql.ResultSet"%>
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
<fieldset>
<%ResultSet classListCR = (ResultSet)session.getAttribute("ClassListCR1"); 
ResultSet subjectListCR = (ResultSet)session.getAttribute("SubjectListCR1"); 
%>
<%while(classListCR.next()){ %>
<legend>Class Name : <%=classListCR.getString(2)%></legend><%}%>
<h>Subject List</h>
<table border="1">
<%if (subjectListCR.next() == true)
{
	subjectListCR.beforeFirst();
%>
<tr bgcolor = "navyblue">
<td>Class Name</td>
<td>Subject Name</td>
</tr>
<%while(subjectListCR.next())
{
%>
<tr>
<td><%=subjectListCR.getString(1)%></td>
<td><%= subjectListCR.getString(2)%></td>
</tr>
<%} %>
<%}else{ %>
<tr><td> No Subject List Found </td></tr>
<%} %>
</table>
<br>
<h>Student List</h>
<table border="1">
<%
ResultSet studentListCR = (ResultSet)session.getAttribute("StudentListCR1"); 
if (studentListCR.next() == true)
{
	studentListCR.beforeFirst();
%>
<tr bgcolor = "navyblue">
<td>Student ID</td>
<td>Student Name</td>
<td>Student First Name</td>
<td>Student Last Name</td>
<td>Student DOB</td>
<td>Student Joined Date</td>
<td>Student Phone Number</td>
<td>Class Name</td>
</tr>
<%while(studentListCR.next())
{
%>
<tr>
<td><%=studentListCR.getInt(1)%></td>
<td><%= studentListCR.getString(2)%></td>
<td><%= studentListCR.getString(3)%></td>
<td><%= studentListCR.getString(4)%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(studentListCR.getDate(5))%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(studentListCR.getDate(6))%></td>
<td><%=studentListCR.getInt(7)%></td>
<td><%= studentListCR.getString(9)%></td>
</tr>
<%} %>
<%}else{ %>
<tr><td> No Student List Found </td></tr>
<%} %>
</table>
<br>
<h>Teacher List</h>
<table border="1">
<%ResultSet teacherListCR = (ResultSet)session.getAttribute("TeacherListCR1"); 
if (teacherListCR.next() == true)
{
	teacherListCR.beforeFirst();
%>
<tr bgcolor = "navyblue">
<td>Subject Name</td>
<td>Class Name</td>
<td>Teacher Name</td>
<td>Teacher First Name</td>
<td>Teacher Last Name</td>
<td>Teacher DOB</td>
<td>Teacher Phone Number</td>
<td>Designation</td>
<td>Address</td>
</tr>
<%while(teacherListCR.next())
{
%>
<tr>
<td><%= teacherListCR.getString(1)%></td>
<td><%= teacherListCR.getString(2)%></td>
<td><%=teacherListCR.getString(3)%></td>
<td><%= teacherListCR.getString(4)%></td>
<td><%= teacherListCR.getString(5)%></td>
<td><%=new SimpleDateFormat("dd-MM-yyyy").format(teacherListCR.getDate(6))%></td>
<td><%= teacherListCR.getInt(7)%></td>
<td><%= teacherListCR.getString(8)%></td>
<td><%= teacherListCR.getString(9)%></td>
</tr>
<%} %>
<%}else{ %>
<tr><td> No Teacher List Found </td></tr>
<%} %>
</table>
</fieldset>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>