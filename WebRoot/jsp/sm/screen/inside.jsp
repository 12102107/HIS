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
<title>手术室内大屏幕</title>
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
.table th, .table td {
	font-size: 20px;
	line-height: 45px;
}
</style>
</head>
<body >
<div class="zhong_right">
<table class="table table-bordered table-striped header-spcing" style="margin-top: 0;">
<tbody>
<thead>
	<tr class="bj">
		<td>手术间</td>
		<td>科室</td>
		<td>姓名</td>
		<td>手术名称</td>
		<td>麻醉方法</td>
		<td>麻醉医师</td>
		<td>手术医师</td>
		<td>护士</td>
	</tr>
	</thead>
<c:forEach items="${r }" var="s">
	<tr class="bk">
		<td>${s.room }</td>
		<td>${s.dept }</td>
		<td>${s.name }</td>
		<td>${s.optname }</td>
		<td>${s.anaes }</td>
		<td>${s.anesthetist }&nbsp;&nbsp;${s.circuanesthetist }&nbsp;&nbsp;${s.anaes_assistant }</td>
		<td>${s.operator_name }</td>
		<td>${s.instrnurse1 }&nbsp;&nbsp;${s.instrnurse2 }&nbsp;&nbsp;${s.circunurse1 }&nbsp;&nbsp;${s.circunurse2 }</td>
	</tr>
</c:forEach>

</tbody>
</table>
</div>

</body>
</html>
