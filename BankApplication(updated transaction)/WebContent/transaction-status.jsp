<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Status</title>
</head>
<body>
	<%
		String transStatus = (String) request.getSession().getAttribute("transStatus");
	%>
	<%
		if (transStatus.equals("success"))
			out.println("<h3 style='color:green'>Transaction successful...</h3>");
		else if (transStatus.equals("failure"))
			out.println("<h3 style='color:red'>Transaction failed...</h3>");
	%>
</body>
</html>