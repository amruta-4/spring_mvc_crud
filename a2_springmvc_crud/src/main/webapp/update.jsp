<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
enter id:<input type="number" name="sid" value="<%=request.getParameter("id")%>" readonly="readonly">
enter name:<input type="text" name="sname" value="<%=request.getParameter("name")%>">
<button>submit</button>
</form>

</body>
</html>