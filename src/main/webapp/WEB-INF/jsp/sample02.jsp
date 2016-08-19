<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.sample.bean.DbSample02Bean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
<font color="red"><b><%= bean.getMessage() %></b></font>
<h2>従業員情報</h2><br>
<table border="1" cellpadding="2" cellspacing="0">
<tr><th bgcolor="aquamarine">従業員番号</th><td><%= bean.getEntity().getEmpNo() %></td></tr>
<tr><th bgcolor="aquamarine">姓</th><td><%= bean.getEntity().getLastName() %></td></tr>
<tr><th bgcolor="aquamarine">ミドル</th><td><%= bean.getEntity().getMidInit() %></td></tr>
<tr><th bgcolor="aquamarine">名</th><td><%= bean.getEntity().getFirstNme() %></td></tr>
<tr><th bgcolor="aquamarine">所属</th><td><%= bean.getEntity().getWorkDept() %></td></tr>
<tr><th bgcolor="aquamarine">電話</th><td><%= bean.getEntity().getPhoneNo() %></td></tr>
<tr><th bgcolor="aquamarine">入社日</th><td><%= bean.getEntity().getHireDate() %></td></tr>
<tr><th bgcolor="aquamarine">職種</th><td><%= bean.getEntity().getJob() %></td></tr>
<tr><th bgcolor="aquamarine">スキルレベル</th><td><%= bean.getEntity().getEdLevel() %></td></tr>
<tr><th bgcolor="aquamarine">性別</th><td><%= bean.getEntity().getSex() %></td></tr>
<tr><th bgcolor="aquamarine">生年月日</th><td><%= bean.getEntity().getBirthDate() %></td></tr>
<tr><th bgcolor="aquamarine">給与</th><td><%= bean.getEntity().getSalary() %></td></tr>
<tr><th bgcolor="aquamarine">賞与</th><td><%= bean.getEntity().getBonus() %></td></tr>
<tr><th bgcolor="aquamarine">COMM</th><td><%= bean.getEntity().getComm() %></td></tr>
<tr><th>イメージ</th><td><img alt="<%= bean.getEntity().getFirstNme() %>" src="getPhoto?empNo=<%= bean.getEntity().getEmpNo() %>"></td></tr>
</table>
<br><br>
<a href="sample01?empNo=<%= bean.getEmpNo() %>">検索一覧に戻る</a>&nbsp;&nbsp;&nbsp;<a href="index.jsp">トップに戻る</a>
</body>
</html>