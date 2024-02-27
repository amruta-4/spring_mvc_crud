<%@page import="a2_springmvc_crud.dto.StudentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<% List<StudentDto> l=(List<StudentDto>)request.getAttribute("message3");%>
<table border="">
<tr>
<th>id</th>
<th>name</th>
<th>delete</th>
<th>update</th>
</tr>
<%if(l==null){%>
<h1>no data found</h1>
<%} else{ %>
<%for(StudentDto l1:l){ %>
<tr>
<td><%=l1.getSid()%></td>
<td><%=l1.getSname()%></td>
<td>  <a href="deletebyid?primarykey=<%=l1.getSid()%>">remove</a> </td>
<td><a href="update.jsp?id=<%=l1.getSid()%>&&name=<%=l1.getSname()%>">edit</a> </td>

</tr>
<%} %>
<%} %>
</table>


</form>

</body>
</html>