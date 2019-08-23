<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>手术室外大屏幕</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
function myrefresh(){
window.location.reload();
}
setTimeout('myrefresh()',60000); //指定1秒刷新一次
</script>
<style type="text/css">
.table th, .table td  {
	font-size: 50px;
	line-height: 75px;
}
</style>
</head>
<body >
<div class="zhong_right">
<table class="table table-bordered table-striped header-spcing" style="margin-top: 0;">
<tbody>
<thead>
	<tr class="bj">
		<td>科室</td>
		<td>床号</td>
		<td>住院号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>状态</td>
		<td>去向</td>
	</tr>
</thead>	
<c:forEach items="${r }" var="s">
	<tr class="bk">
		<td>${s.dept }</td>
		<td>${s.bed }</td>
		<td>${s.hid }</td>
		<td>${s.name }</td>
		<td>
			<c:if test="${s.sex eq 0 }">男</c:if>
			<c:if test="${s.sex eq 1 }">女</c:if>
		</td>
		<td>
			<c:if test="${s.state eq '03' }">未开始</c:if>
			<c:if test="${s.state eq '04' }">手术中</c:if>
			<c:if test="${s.state eq '05' }">已结束</c:if>
		</td>
		<td>${s.oper_after_goto }</td>
	</tr>
</c:forEach>

</tbody>
</table>
</div>

</body>
</html>
