<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>科研查询</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>

      <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="../js/jquery.messager.js"></script></head>
  <script type="text/javascript">    
function searchAll() {
	var dateFrom = $("#asaDateFrom").val();
	var dateTo = $("#asaDateTo").val();
	if (dateFrom.length == "" || dateTo.length == "") {
		alert("所有日期必须选择！");
		return;
	}
 window.location.href="../arrange/myArrangeList.action?dateFrom="+dateFrom+"&dateTo="+dateTo+"&functionid="+$('#functionid').val();
}  
    </script> 
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">科研查询</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
			<div class="table_input ">
				<div class="form-group pull-left" style="margin-bottom: 10px;">
				<form action="scientificQuery.action" method="post">
			日期：<input id="dateFrom" name="dateFrom" style="width: 120px;"
				class="Wdate" value="${dateFrom}"
				onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'dateTo\')}'})" />
			-<input id="dateTo" name=dateTo style="width: 120px;" class="Wdate"
				value="${dateTo}"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'dateFrom\')}'})" />

			&nbsp;&nbsp;&nbsp;&nbsp;
			性别： <select name="sex" style="width: 70px;">
					<option value=""></option>
					<option value="0" <c:if test="${sex eq '0' }">selected</c:if>>男</option>
					<option value="1" <c:if test="${sex eq '1' }">selected</c:if>>女</option>
				</select>
			&nbsp;&nbsp;&nbsp;&nbsp;
			年龄层： <select name="age" style="width: 100px;">
					<option value=""></option>
					<option value="0" <c:if test="${age eq '0' }">selected</c:if>>0-10岁</option>
					<option value="1" <c:if test="${age eq '1' }">selected</c:if>>11-20岁</option>
					<option value="2" <c:if test="${age eq '2' }">selected</c:if>>21-30岁</option>
					<option value="3" <c:if test="${age eq '3' }">selected</c:if>>31-40岁</option>
					<option value="4" <c:if test="${age eq '4' }">selected</c:if>>41-50岁</option>
					<option value="5" <c:if test="${age eq '5' }">selected</c:if>>51-60岁</option>
					<option value="6" <c:if test="${age eq '6' }">selected</c:if>>61-70岁</option>
					<option value="7" <c:if test="${age eq '7' }">selected</c:if>>71-80岁</option>
					<option value="8" <c:if test="${age eq '8' }">selected</c:if>>81-90岁</option>
					<option value="9" <c:if test="${age eq '9' }">selected</c:if>>大于90岁</option>
				</select>
			&nbsp;&nbsp;&nbsp;&nbsp;
			诊断名称：<input name="zd" style="width: 120px;" value="${zd}">	
			&nbsp;&nbsp;&nbsp;&nbsp;
			手术名称：<input name="ss" style="width: 120px;" value="${ss}">	
			&nbsp;&nbsp;&nbsp;&nbsp;
			麻醉方法：<input name="mz" style="width: 120px;" value="${mz}">	
			<%-- <c:if test="${selectRole eq true }"> --%>
				<button type="button" class="button_blue_74_33"
								onclick="submit()">查询</button>
			<%-- </c:if> --%>
				</form>
				</div>
				</div>
						<table class="table table-bordered table-striped header-spcing">
							<thead>
								<tr class="bj">
									<td>姓名</td>
									<td>性别</td>
									<td>年龄</td>
									<td>住院号</td>
									<td>病区</td>
									<td>床号</td>
									<td>手术日期</td>
									<td>手术室</td>
									<td>术前诊断</td>
									<td>拟施手术</td>
									<td>建议麻醉方法</td>
									<td>手术医师</td>
								</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var='sro'>
										<tr class="bk">
											<td ><a href="javascript:void(0)">${sro.name }</a></td>
											<td >
												<c:if test="${sro.sex==0 }">男</c:if> 
												<c:if test="${sro.sex==1 }">女</c:if>
											</td>
											<td >${sro.age }</td>
											<td >${sro.hid }</td>
											<td >${sro.region }</td>
											<td >${sro.bed }</td>
											<td ><fmt:formatDate value="${sro.operdate }" pattern="yyyy-MM-dd"/></td>
											<td >${sro.room }</td>
											<td >${sro.diagnosis_name }</td>
											<td >${sro.designed_opt_name }</td>
											<td >${sro.designed_anaes_method_name }</td>
											<td >${sro.operator_name }</td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
