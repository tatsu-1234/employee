<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理一覧</title>
</head>
<body>
	<form action="/employee/LoginServlet" method="post">
		社員ID：<input type="text" name="employeeId"><br> パスワード：<input
			type="password" name="pass"><br> <input type="submit"
			value="ログイン">
	</form>
</body>
</html>