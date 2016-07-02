
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>客户列表</h1>
	<hr>
	<table border="1" width="100%">
		<tr>
			<th>客户姓名</th>
			<th>客户性别</th>
			<th>出生日期</th>
			<th>手机号码</th>
			<th>电子邮箱</th>
			<th>客户爱好</th>
			<th>客户类型</th>
			<th>描述信息</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="cust">
			<tr>
				<td>${cust.name}</td>
				<td>${cust.gender}</td>
				<td>${cust.birthday}</td>
				<td>${cust.cellphone}</td>
				<td>${cust.email}</td>
				<td>${cust.preference}</td>
				<td>${cust.type}</td>
				<td>${cust.description}</td>

			</tr>

		</c:forEach>
	</table>
</body>
</html>