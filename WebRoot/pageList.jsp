<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
  		function changePage(obj){
  			if(isNaN(obj.value)){
  				alert("必须是数字!");
  				obj.value=${page.thispage}
  				return;
  			}else if(obj.value<=0||obj.value>="${page.countpage}"){
  				alert("页码必须在有效范围内!");
  				obj.value=${page.thispage}
  				return;
  			}else{
  				window.location.href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage="+obj.value;
  			}
  		}
  	</script>
</head>
<body>
<table border="1" width="100%">
<tr>
		    <th><input type="checkbox"/>全选</th>
			<th>客户姓名</th>
			<th>客户性别</th>
			<th>出生日期</th>
			<th>手机号码</th>
			<th>电子邮箱</th>
			<th>客户爱好</th>
			<th>客户类型</th>
			<th>描述信息</th>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${requestScope.page.list}" var="cust">
			<tr>
			 <td><input type="checkbox" name="delId" value="${cust.id}"/></td>
				<td>${cust.name}</td>
				<td>${cust.gender}</td>
				<td>${cust.birthday}</td>
				<td>${cust.cellphone}</td>
				<td>${cust.email}</td>
				<td>${cust.preference}</td>
				<td>${cust.type}</td>
				<td>${cust.description}</td>
				<td><a href="${pageContext.request.contextPath }/servlet/CustInfoServlet?id=${cust.id}">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/servlet/DelCustServlet?id=${cust.id}">删除</a></td>

			</tr>

		</c:forEach>
</table>
共${page.countrow}条记录
共${page.countpage}页
<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.firstpage}">首页</a>
<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.prepage}">上一页</a>
<!-- 分页逻辑开始 -->
  	<c:if test="${page.countpage<=5}">
  		<c:set var="begin" value="1" scope="page"></c:set>
  		<c:set var="end" value="${page.countpage}" scope="page"></c:set>
  	</c:if>
  	<c:if test="${page.countpage>5}">
		<c:choose>
			<c:when test="${page.thispage<=3}">
				<c:set var="begin" value="1" scope="page"></c:set>
  				<c:set var="end" value="5" scope="page"></c:set>
			</c:when>
			<c:when test="${page.thispage>=page.countpage-2}">
				<c:set var="begin" value="${page.countpage-4}" scope="page"></c:set>
  				<c:set var="end" value="${page.countpage}" scope="page"></c:set>
  			</c:when>
  			<c:otherwise>
  				<c:set var="begin" value="${page.thispage-2}" scope="page"></c:set>
  				<c:set var="end" value="${page.thispage+2}" scope="page"></c:set>
  			</c:otherwise>
		</c:choose>
  	</c:if>
  	
  	<c:forEach begin="${begin}" end="${end}" step="1" var="i">
  		<c:if test="${i == page.thispage}">
  			${i }
  		</c:if>
  		<c:if test="${i != page.thispage}">
  			<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${i}">${i }</a>
  		</c:if>
  	</c:forEach>
  	
  	<!-- 分页逻辑结束 -->
<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.nextpage}">下一页</a>
<a href="${pageContext.request.contextPath }/servlet/PageCustServlet?thispage=${page.lastpage}">尾页</a>
	跳到<input type="text" value="${page.thispage }" style="width: 40px" onchange="changePage(this)"/>页
	
</body>
</html>