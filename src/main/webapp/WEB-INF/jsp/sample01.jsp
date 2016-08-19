<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.sample.bean.DbSample01Bean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>社員一覧検索</title>
</head>
<body>
<font color="red"><b><%= bean.getMessage()!=null ? bean.getMessage() : "" %></b></font>
<form action="sample01" method="post">
検索条件を入力してください。(ワイルドカード'*'が使用できます。)<br><br>
従業員番号: <input type="text" name="empNo" value="<%= bean.getEmpNo() %>"><br><br>
<input type="submit">
</form>
<br><br>
<% if(bean.getList() != null && bean.getList().size()>0) { %>
<table border="1" cellpadding="2" cellspacing="0">
<tr bgcolor="aquamarine"><th>従業員番号</th><th>姓</th><th>名</th><th>入社日</th></tr>
<% 
	int cnt = 0;
	for(com.ibm.jp.sample.entity.Employee employee : bean.getList()) { %>
<tr><td><a href="sample02?empNo=<%= employee.getEmpNo() %>&searchEmpNo=<%= bean.getEmpNo() %>"><%= employee.getEmpNo() %></a></td><td><%= employee.getLastName() %></td><td><%= employee.getFirstNme() %></td><td><%= employee.getHireDate() %></td></tr>
<% 
		cnt++;
		if(cnt>=20) {
			break;
		}
	}
%>
</table>
<% } %>
<br><br>
<hr>
<a href="index.jsp">トップに戻る</a>
</body>
</html>
