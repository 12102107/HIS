<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
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
<title>我的排班</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>

      <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="../js/jquery.messager.js"></script></head>
  <script type="text/javascript">
$(function () {   
 $.messager.lays(200, 200);    
 $.messager.anim('fade', 1000); 
    $.messager.show("公告", "<a  href='<%=request.getContextPath()%>/noc/nocList.action' style='font-size:16px;color:red'>请查看最新公告</a>",5000);
    }
    
    );
    
function searchAll() {
	var dateFrom = $("#asaDateFrom").val();
	var dateTo = $("#asaDateTo").val();
	if (dateFrom.length == "" || dateTo.length == "") {
		alert("所有日期必须选择！");
		return;
	}
 window.location.href="../arrange/myArrangeList.action?dateFrom="+dateFrom+"&dateTo="+dateTo+"&functionid="+$('#functionid').val();
}

function searchWeek(){
		/* 	var time = new Date(); //获得当前时间
		var year = time.getFullYear();//获得年、月、日
		var month = time.getMonth() + 1;
		var date = time.getDate();
		if (month < 10) //如果月份只有1位，补0显示
			month = "0" + month;
		if (date < 10) //如果月份只有1位，补0显示
			date = "0" + date;
		riqi = year + "-" + month + "-" + date; */
		window.location.href="../arrange/myArrangeList.action?functionid="+$('#functionid').val();
}    
    </script> 
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">我的排班</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
			<div class="table_input ">
				<div class="form-group pull-left" style="margin-bottom: 10px;">
				<input type="hidden" name="functionid" value="${functionid }" id="functionid">
				<input style="border:0;background-color: #FF99FF;height:20px; width: 50px;"disabled="disabled">
				<input style="border:0;background-color: white;" value="为急诊手术" disabled="disabled">
				
				
			日期：<input id="asaDateFrom" name="asaDateFrom" style="width: 120px;"
				class="Wdate" value="${dateFrom}"
				onFocus="var asaDateTo=$dp.$('asaDateTo');WdatePicker({onpicked:function(){asaDateTo.focus();},maxDate:'#F{$dp.$D(\'asaDateTo\')}'})" />
			-<input name="asaDateTo" id="asaDateTo" style="width: 120px;" class="Wdate"
				value="${dateTo}"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'asaDateFrom\')}'})" />

			<%-- <c:if test="${selectRole eq true }"> --%>
				<button type="button" class="button_blue_74_33"
								onclick="searchAll()">查询</button>
			<%-- </c:if> --%>								
					<%-- <c:if test="${selectTodayRole eq true }">	 --%>			
							<button type="button" class="button_blue_74_33"
								onclick="searchWeek()">未来一周</button>
					<%-- </c:if>	 --%>
				
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
									<td>手术开始时间</td>
									<td>手术室</td>
									<td>角色</td>
									<td>术前诊断</td>
									<td>拟施手术</td>
									<td>建议麻醉方法</td>
									<td>手术医师</td>
								</tr>
								</thead>
								<tbody>
								<c:forEach items="${list }" var='r'>
									<tr >
										<td colspan="13" style="text-align: left; padding-left: 10px;">${r.day
											}</td>
									</tr>
									<c:forEach items="${r.sro }" var='sro'>
										<tr class="bk">
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.name }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>><c:if test="${sro.sex==0 }">男
												</c:if> <c:if test="${sro.sex==1 }">女
												</c:if></td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.age }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.hid }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.region }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.bed }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.starttime }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.room }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.role }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.diagnosisName }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.designedOptName }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.designedAnaesMethodName }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.operatorName }</td>
										</tr>
									</c:forEach>
									<tr class="bk">
										<td colspan="13" >&nbsp;</td>
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
