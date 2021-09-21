<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Account"%>
<%
List<Account> account = (List<Account>) application.getAttribute("AllData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理一覧</title>
</head>
<body>
	<%
	for (Account accountAll : account) {
	%>
	<p>
		<%=accountAll.getEmployeeId()%>
		<%=accountAll.getName()%>
		<%=accountAll.getAge()%>
		<%=accountAll.getSex()%>
		<%=accountAll.getAddress()%>
		<%=accountAll.getDepartment()%><br>
	</p>
	<%
	}
	%>
</body>
</html>