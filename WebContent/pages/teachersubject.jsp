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
<form action="SavesubjectTeacherMap" method="post">
<%
ArrayList<SubjectClass> subjectList = (ArrayList)session.getAttribute("getSuList"); 
ArrayList<Teacher> teacherclasseslist = (ArrayList)session.getAttribute("teacherclasseslist");
%>
<table bgcolor = "lightgreen" border="1">
<tr><td>Subject Name :</td>
<td><select name = "suid">
<%for(int i = 0;i<subjectList.size();i++){ %>
<option value="<%=subjectList.get(i).getSid()%>"><%=subjectList.get(i).getSname()%></option>
<%} %>
</select></td></tr>
<tr><td>Teacher Name :</td>
<td><select name = "tid">
<%for(int i = 0;i<teacherclasseslist.size();i++){ %>
<option value="<%=teacherclasseslist.get(i).getTid()%>"><%=teacherclasseslist.get(i).getTname()%> -- <%=teacherclasseslist.get(i).getDesignation() %></option>
<%} %>
</select></td></tr>
<tr><td><input type="submit" value="SAVE"></td></tr>
<input type = "hidden" name = "cid" value ="<%=session.getAttribute("cid")%>" >
</table>
</form>
<br>
<%@include file="/pages/bottom.jsp" %>
</fieldset>
</body>
</html>