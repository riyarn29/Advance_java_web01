<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setAttribute("msg1", "A.jsp msg!!!");
	%>
	<jsp:forward page="B.jsp"></jsp:forward>
</body>
</html>