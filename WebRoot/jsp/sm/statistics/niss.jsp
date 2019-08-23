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
<title>手术等级统计</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">
/* CreateReport("Report");
function printN() {
	Report.LoadFromURL("../jsp/sm/optNurse/optNurse.grf");
	AjaxSyncLoadReportData(Report,"loadPrint.action?ylwsid="+$("#ylws").val());
	Report.PrintPreview(true);
} */

$(function(){


	$('#month').click(function(){
 		if($(this).attr('checked')) {		
 			$('#start').val(getMonthStartDate().Format("yyyy-MM-dd"));
 			$('#end').val(getMonthEndDate().Format("yyyy-MM-dd"));
 		} else {
 			$('#start').val("");
 			$('#end').val("");
 		}
	});
	
	var now = new Date();
	var nowMonth = now.getMonth(); 
	var nowYear = now.getFullYear();
	//日期+天
 	function AddDays(d, n) {
    	var t = new Date(d);//复制并操作新对象，避免改动原对象
    	t.setDate(t.getDate() + n);
    	return t;
 	}
 	//日期+月。日对日，若目标月份不存在该日期，则置为最后一日
 	function AddMonths(d, n) {
    	var t = new Date(d);
    	t.setMonth(t.getMonth() + n);
    	if (t.getDate() != d.getDate()) { t.setDate(0); }
    	return t;
	}
	//月初
	function getMonthStartDate() {
		return new Date(nowYear, nowMonth, 1);
	}
	//月末。下月初-1天
	function getMonthEndDate() {
		return AddDays(AddMonths(getMonthStartDate(), 1), -1);
	}
	// 对Date的扩展，将 Date 转化为指定格式的String   
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
	// 例子：   
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
	Date.prototype.Format = function(fmt) { //author: meizz   
  		var o = {   
    		"M+" : this.getMonth()+1,                 //月份   
    		"d+" : this.getDate(),                    //日   
    		"h+" : this.getHours(),                   //小时   
    		"m+" : this.getMinutes(),                 //分   
    		"s+" : this.getSeconds(),                 //秒   
    		"q+" : Math.floor((this.getMonth()+3)/3), //季度   
    		"S"  : this.getMilliseconds()             //毫秒   
  		};   
  		if(/(y+)/.test(fmt))   
    		fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  		for(var k in o)   
    		if(new RegExp("("+ k +")").test(fmt))   
  			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  		return fmt;   
	};
	
	
	var m = "${month}";
	
	if(m==1) {
		$('#start').val(getMonthStartDate().Format("yyyy-MM-dd"));
 		$('#end').val(getMonthEndDate().Format("yyyy-MM-dd"));
 		$('#d').empty().html(getMonthStartDate().Format("yyyy-MM-dd")+"~"+getMonthEndDate().Format("yyyy-MM-dd"));
	}
	
});

function getStatistics() {
	if($('#start').val()==""||$('#end').val()=="") {
		alert('请输入起止时间！');
	} else {
		$('form').submit();
	}
}

</script>
<style type="text/css">

</style>
</head>
<body >
<table class="table table-bordered table-striped header-spcing" ><tr><td style="text-align: left;vertical-align: middle;">	
							<form action="nissStatistics.action" method="post">
								开始日期： <input id="start" class="Wdate" name="start" value="${start }"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end\')}'})" style="width: 110px;border: 1px solid #ccc;line-height: 30px;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								结束日期： <input id="end" class="Wdate" name="end" value="${end }"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'start\')}'})" style="width: 110px;border: 1px solid #ccc;line-height: 30px;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" name="month" value="1" id="month" style="vertical-align: baseline;" <c:if test="${month eq 1 }">checked</c:if>> 当月统计
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="button_blue_74_33" style="border: medium none; margin-left: 10px;"
										onclick="getStatistics()">查询</button>
								</form>
							</td>
							</tr>
						</table>
					
						<table class="table table-bordered table-striped header-spcing" id="table">	
							<thead>
							<tr class="bj">
								<td style="width: 20%">
								日期
								</td>
								<td style="width: 20%">
								0级
								</td>
								<td style="width: 20%">
								1级
								</td>
								<td style="width: 20%">
								2级
								</td>
								<td style="width: 20%">
								3级
								</td>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td id="d">
								${start }~${end }
								</td>
								<td >
								<c:if test="${empty result}">
								0例
								</c:if>
								<c:if test="${not empty result}">
									<c:if test="${empty result[0]}">
									0例
									</c:if>
									<c:if test="${ not empty result[0]}">
									${result[0][1] }例
									</c:if>
								</c:if>
								</td>
								<td >
								<c:if test="${empty result}">
								0例
								</c:if>
								<c:if test="${not empty result}">
									<c:if test="${empty result[1]}">
									0例
									</c:if>
									<c:if test="${ not empty result[1]}">
									${result[1][1] }例
									</c:if>
								</c:if>
								</td>
								<td >
								<c:if test="${empty result}">
								0例
								</c:if>
								<c:if test="${not empty result}">
									<c:if test="${empty result[2]}">
									0例
									</c:if>
									<c:if test="${ not empty result[2]}">
									${result[2][1] }例
									</c:if>
								</c:if>
								</td>
								<td >
								<c:if test="${empty result}">
								0例
								</c:if>
								<c:if test="${not empty result}">
									<c:if test="${empty result[3]}">
									0例
									</c:if>
									<c:if test="${ not empty result[3]}">
									${result[3][1] }例
									</c:if>
								</c:if>
								</td>
							</tr>	
							</tbody>
						</table>
</body>
</html>
