<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cap.bean.Test" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
</head>
<body>
<% Test test=(Test)session.getAttribute("test"); %>
<form action="test?action=update" method="post">
<input type="hidden" name="id" value="<%=test.getId()%>"><br>
<input type="text" name="username" value="<%=test.getUsername()%>"><br>
<input type="text" name="password" value="<%=test.getPassword()%>"><br>
<input type="submit" value="更新">
</form>
</body>
</html>