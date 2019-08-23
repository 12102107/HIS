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
<title>排班打印</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">
CreateReport("Report");
function printt() {
	Report.LoadFromURL("../jsp/sm/arrange/yysd.grf");
	AjaxSyncLoadReportData(Report,"loadPrint.action");
	Report.PrintPreview(true);
}

function searchAll() {
	var dateFrom = $("#asaDateFrom").val();
	var dateTo = $("#asaDateTo").val();
	if (dateFrom.length == "" || dateTo.length == "") {
		alert("所有日期必须选择！");
		return;
	}
 window.location.href="../arrange/arrangePrintTo.action?dateFrom="+dateFrom+"&dateTo="+dateTo+"&functionid="+$('#functionid').val();
}

function searchDay(){
/* 	var time = new Date(); //获得当前时间
		var year = time.getFullYear();//获得年、月、日
		var month = time.getMonth() + 1;
		var date = time.getDate();
		if (month < 10) //如果月份只有1位，补0显示
			month = "0" + month;
		if (date < 10) //如果月份只有1位，补0显示
			date = "0" + date;
		riqi = year + "-" + month + "-" + date; */
		 window.location.href="../arrange/arrangePrintTo.action?functionid="+$('#functionid').val();

	}
</script>

</head>
<body class="page-header-fixed" onload="paging_init()">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">排班打印</font> <img
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

	手术日期：<input id="asaDateFrom" name="asaDateFrom" style="width: 120px;"
				class="Wdate" value="${dateFrom}"
				onFocus="var asaDateTo=$dp.$('asaDateTo');WdatePicker({onpicked:function(){asaDateTo.focus();},maxDate:'#F{$dp.$D(\'asaDateTo\')}'})" />
			-<input name="asaDateTo" id="asaDateTo" style="width: 120px;" class="Wdate"
				value="${dateTo}"
				onFocus="WdatePicker({minDate:'#F{$dp.$D(\'asaDateFrom\')}'})" />

			<c:if test="${selectRole eq true }">
				<button type="button" class="button_blue_74_33"
								onclick="searchAll()">查询</button>
			</c:if>								
					<c:if test="${selectTodayRole eq true }">				
							<button type="button" class="button_blue_74_33"
								onclick="searchDay()">今日查询</button>
					</c:if>								
	</div>
	</div>
						<!-- 下面显示列表内容 -->
						<table class="table table-bordered table-striped header-spcing">

							<thead>
								<tr class="bj">
									<td>手术日期</td>
									<td>手术室</td>
									<td>姓名</td>
									<td>性别</td>
									<td>年龄</td>
									<td>住院号</td>
									<td>病区</td>
									<td>床号</td>
									<td>拟施手术</td>
									<td>建议麻醉方法</td>
									<td>手术医师</td>
									<td>手术麻醉医师</td>
									<td>巡台麻醉医师</td>
									<td>灌注医师</td>
									<td>器械护士</td>
									<td>巡回护士</td>
								</tr>
							</thead>	
						<tbody>
								<c:forEach items="${list }" var='r'>
									<c:forEach items="${r.sro }" var='sro'>
										<tr class="bk">
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>><fmt:formatDate value="${sro.operdate }" pattern="yyyy-MM-dd"/> </td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.room }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.name }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>
												<c:if test="${sro.sex==0 }">男
												</c:if>
												<c:if test="${sro.sex==1 }">女
												</c:if>
											</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.age }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.hid }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.region }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.bed }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.designedOptName }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.designedAnaesMethodName }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.operatorName }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.anesthetist }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.circuanesthetist }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.anaesAssistant }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.circunurse }</td>
											<td <c:if test="${sro.type==0 }">style="background-color: #FF99FF;"</c:if>>${sro.instrnurse }</td>
										</tr>
									</c:forEach>
								</c:forEach>
							</tbody>
						</table>
					<c:if test="${printRole eq true }">
					<div style="text-align: center; margin-top: 2%;margin-bottom: 20px;">
						<button type="button" class="button_blue_74_33" style="border: medium;" onclick="printt()">打印</button>
					</div>
					</c:if>	
					</div>
				</div>
			</div>
</body>
</html>
