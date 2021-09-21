<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Login"%>
<%@ page import="model.Account"%>
<%
Login login = (Login) session.getAttribute("employeeId");
%>
<%
Account account = (Account) application.getAttribute("loginData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理一覧</title>
</head>
<body>
	<%
	if (login != null) {
	%>
	<p>
		ようこそ<%=login.getEmployeeId()%>さん
	</p>
	<%
	} else {
	%>
	<a href="/employee/LoginServlet"></a>
	<%
	}
	%>
	<p>
		<%=account.getEmployeeId()%>
		<%=account.getName()%>
		<%=account.getAge()%>
		<%=account.getSex()%>
		<%=account.getAddress()%>
		<%=account.getDepartment()%>
	</p>
<form method="post" action="/employee/MainServlet">
  <button>社員管理一覧へ</button>
</form>
</body>
</html>
