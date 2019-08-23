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
<title>麻醉例数统计</title>
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
	function mzlsMonth(obj){
		  
		var dateFrom = $("#dateFrom").val();
		if (dateFrom.length == "") {
			alert("开始日期必须选择！");
			$("#mzlsCheckbox").attr("checked",false);
			return;
		}else if (obj.checked == true) {
			 window.location.href="<%=request.getContextPath()%>/mzls/mzlsList.action?dateFrom="+ dateFrom+"&mzlsCheckbox="+ $("#mzlsCheckbox").val();
			
		}else{
		
			window.location.href="<%=request.getContextPath()%>/mzls/mzlsList.action";
			
		}
	}

	function searchMzls() {
		var dateFrom = $("#dateFrom").val();
		var dateTo = $("#dateTo").val();
		if (dateFrom.length == "" || dateTo.length == "") {
			alert("请输入起止时间！");
			return;
		}
		$("#mzlsCheckbox").attr("checked", false);
		document.forms["mzlsform"].submit();
	}
</script>
</head>
<body>
				<form id="mzlsform" name="mzlsform" action="mzlsList.action"
					method="post">
					<table class="table table-bordered table-striped header-spcing" ><tr><td style="text-align: left;vertical-align: middle;">
						开始日期：
						<input id="dateFrom" name="dateFrom" class="Wdate" style="width: 110px;border: 1px solid #ccc;line-height: 30px;"
						value="${dateFrom}"
						onFocus="var dateTo=$dp.$('dateTo');WdatePicker({onpicked:function(){dateTo.focus();},maxDate:'#F{$dp.$D(\'dateTo\')}'})" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						结束日期：
						<input
						name="dateTo" id="dateTo" class="Wdate" style="width: 110px;border: 1px solid #ccc;line-height: 30px;"
						value="${dateTo}"
						onFocus="WdatePicker({minDate:'#F{$dp.$D(\'dateFrom\')}'})" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="mzlsCheckbox" type="checkbox" name="mzlsCheckbox" value="1" onclick="mzlsMonth(this)" style="vertical-align: baseline;"
						<c:if test="${mzlsCheckbox eq '1'}">checked</c:if>>当月统计
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						麻醉医师：
						<select name="yishi" style="width: 100px;">
						<option></option>
						<c:forEach items="${opList}" var="sop" varStatus="status">
							<option value="${sop.name}"
								<c:if test="${yishi eq sop.name}">selected</c:if>>${sop.name}</option>
						</c:forEach>
					</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
						<button type="button" class="button_blue_74_33" style="border: medium none; margin-left: 10px;"
							onclick="searchMzls()">查询</button>
				</td></tr></table>
				<table class="table table-bordered table-striped header-spcing" id="table">
						<thead>
						<tr class="bj">
							<td>时间</td>
							<td>复合麻醉</td>
							<td>局部麻醉</td>
							<td>全身麻醉</td>
						</tr>
						</thead>

						<c:forEach items="${regOptList}" var="reg">
							<tr class="No">
								<td>${fn:substring(reg[3], 0, 4)}年${fn:substring(reg[3],
									6,7)}月</td>
								<td>${reg[0]}例</td>
								<td>${reg[1]}例</td>
								<td>${reg[2]}例</td>
							</tr>

						</c:forEach>
						<c:forEach items="${regOptListAll}" var="regAll">
							<tr class="No">
								<td>总计</td>
								<td><c:if test="${regAll[0]==null}">0例</c:if> <c:if
										test="${regAll[0]!=null}">${regAll[0]}例</c:if>
								</td>
								<td><c:if test="${regAll[1]==null}">0例</c:if> <c:if
										test="${regAll[1]!=null}">${regAll[1]}例</c:if>
								</td>
								<td><c:if test="${regAll[2]==null}">0例</c:if> <c:if
										test="${regAll[2]!=null}">${regAll[0]}例</c:if>
								</td>
							</tr>

						</c:forEach>
					</table>
				</form>
</body>
</html>