<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>术前术后诊断差异统计</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
/*当月统计*/
function month(obj){
	
	var dateFrom = $("#dateFrom").val();
	if (dateFrom.length == "") {
		alert("开始日期必须选择！");
		$("#checkbox").attr("checked",false);
		return;
	}else if (obj.checked == true) {
	
		 window.location.href="<%=request.getContextPath()%>/sqsh/sqshList.action?dateFrom="+ dateFrom+"&checkbox="+ $("#checkbox").val();
		
	}else{
	
		 window.location.href="<%=request.getContextPath()%>/sqsh/sqshList.action";

		}
	}
	
function search() {
	
	var dateFrom = $("#dateFrom").val();
	var dateTo = $("#dateTo").val();
	if (dateFrom.length == "" || dateTo.length == "") {
		alert("请输入起止时间！");
		return;
	}
	$("#checkbox").attr("checked", false);
	document.forms["form"].submit();
}
</script>
</head>
<body>

	<form id="form" name="form" action="sqshList.action" method="post">
<table class="table table-bordered table-striped header-spcing" ><tr><td style="text-align: left;vertical-align: middle;">	
		开始日期：<input id="dateFrom" name="dateFrom" style="width: 110px;border: 1px solid #ccc;line-height: 30px;"
			class="Wdate" value="${dateFrom}"
			onFocus="var dateTo=$dp.$('dateTo');WdatePicker({onpicked:function(){dateTo.focus();},maxDate:'#F{$dp.$D(\'dateTo\')}'})" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 结束日期：<input name="dateTo" id="dateTo" size="12"
			class="Wdate" value="${dateTo}" style="width: 110px;border: 1px solid #ccc;line-height: 30px;"
			onFocus="WdatePicker({minDate:'#F{$dp.$D(\'dateFrom\')}'})" />
		&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input id="checkbox" type="checkbox"
			name="checkbox" value="1" onclick="month(this)" style="vertical-align: baseline;"
			<c:if test="${checkbox eq '1'}">checked</c:if>>当月统计&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input id="xuanze" type="checkbox"
			name="xuanze" value="1" style="vertical-align: baseline;"
			<c:if test="${xuanze eq '1'}">checked</c:if>>术前诊断和术后诊断信息不一致&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           	<button type="button" class="button_blue_74_33" style="border: medium none; margin-left: 10px;"
							onclick="search()">查询</button>
			
</td></tr></table>				
		<table class="table table-bordered table-striped header-spcing" id="table">
			<thead>
				<tr >
				<td colspan="8">
				<c:if test="${checkbox eq '1'}">
				当月术前术后诊断统计(${fn:substring(dateFrom, 0, 4)}年${fn:substring(dateFrom, 6,7)}月)</c:if>
				<c:if test="${dateFrom eq null}">全部术前术后诊断统计</c:if>
				<c:if test="${xuanze eq '1'}">术前诊断和术后诊断信息不一致(${dateFrom}-${dateTo})</c:if>
				<c:if test="${xuanze!='1'&&dateFrom!=null&&checkbox!='1'}">术前术后诊断统计(${dateFrom}-${dateTo})</c:if>
				
				</td>
			</tr>

			<tr class="bj">
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>科室</th>
			<th>住院号</th>
			<th>床号</th>
			<th>术前诊断</th>
			<th>术后诊断</th>
			</tr>
			</thead>
			
			<c:forEach items="${sqshList}" var="sqsh">
				<tr >
					<td>${sqsh[0]}</td>
					<td>${sqsh[1]}</td>
					<td><c:if test="${sqsh[2]=='0'}">男</c:if><c:if test="${sqsh[2]=='1'}">女</c:if></td>
					<td>${sqsh[3]}</td>
					<td>${sqsh[4]}</td>
					<td>${sqsh[5]}</td>
					<td>${sqsh[6]}</td>
					<td>${sqsh[7]}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>