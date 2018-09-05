<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,cap.bean.*"%>
<%@page import="cap.util.PageBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的用户</title>
</head>
<body>
<%
PageBean pg=(PageBean)session.getAttribute("pg");
List<Test> testList=pg.getList();
%>
<%for(Test test:testList){ %>
<tr>
<td><%=test.getId() %></td>
<td><%=test.getUsername() %></td>
<td><%=test.getPassword() %></td>
<td><a href="test?action=delete&id=<%=test.getId() %>">删除</a></td>
<td><a href="test?action=edit&id=<%=test.getId() %>">编辑</a></td><br />
</tr>
<%} 
%>
<tr><td colspan="5">
      共&nbsp;<%=pg.getTotalPages() %>&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
      当前第&nbsp;<%=pg.getPageNo() %>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="test?action=pager&pageNo=<%=pg.getTopPageNo()%>">首页</a>
  <a href="test?action=pager&pageNo=<%=pg.getPreviousPageNo()%>">上一页</a>
  <a href="test?action=pager&pageNo=<%=pg.getNextPageNo()%>">下一页</a>
  <a href="test?action=pager&pageNo=<%=pg.getBottomPageNo()%>">尾页</a><br />

  </td></tr>
</table>
<a href="add_test.jsp">添加用户</a>
</body>
</html>