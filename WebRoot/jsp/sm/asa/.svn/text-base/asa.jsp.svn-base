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

<title>ASA统计</title>
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
	$(function(){
	
	$(".total").each(function(){
		var lv1 = Number($(this).parent().find(".lv1").html());
		var lv2 = Number($(this).parent().find(".lv2").html());
		var lv3 = Number($(this).parent().find(".lv3").html());
		var lv4 = Number($(this).parent().find(".lv4").html());
		var lv5 = Number($(this).parent().find(".lv5").html());
		var lv6 = Number($(this).parent().find(".lv6").html());
		$(this).html(lv1+lv2+lv3+lv4+lv5+lv6);
	});
	
	
	
	if($('.dept').attr('checked')) {
		$('#dept').attr('disabled',false);
	} else {
		$('#dept').attr('disabled',true);
	}
	
	
	if($('.sop').attr('checked')) {
		$('#sop').attr('disabled',false);
	} else {
		$('#sop').attr('disabled',true);
	}
	
	if($('.nurse').attr('checked')) {
		$('#nurse').attr('disabled',false);
	} else {
		$('#nurse').attr('disabled',true);
	}
	
	$('.dept').click(function(){
		$('#dept').attr('disabled',false);
		$('#sop').attr('disabled',true);
		$('#nurse').attr('disabled',true);
	});
	$('.sop').click(function(){
		$('#dept').attr('disabled',true);
		$('#sop').attr('disabled',false);
		$('#nurse').attr('disabled',true);
	});
	$('.nurse').click(function(){
		$('#dept').attr('disabled',true);
		$('#sop').attr('disabled',true);
		$('#nurse').attr('disabled',false);
	});


	$('#month').click(function(){
 		if($(this).attr('checked')) {		
 			$('#asaDateFrom').val(getMonthStartDate().Format("yyyy-MM-dd"));
 			$('#asaDateTo').val(getMonthEndDate().Format("yyyy-MM-dd"));
 		} else {
 			$('#asaDateFrom').val("");
 			$('#asaDateTo').val("");
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
	
function searchAsa() {
	var asaDateFrom = $("#asaDateFrom").val();
	var asaDateTo = $("#asaDateTo").val();
	if (asaDateFrom.length == "" || asaDateTo.length == "") {
		alert("请输入起止时间！");
		return;
	}else if(!$('.dept').attr('checked')&&!$('.sop').attr('checked')&&!$('.nurse').attr('checked')) {
		alert('请选择统计条件！');
	}else{
	$("#asaCheckbox").attr("checked", false);
	document.forms["asaform"].submit();}
}
</script>
</head>
<body>

	<form id="asaform" name="asaform" action="asaList.action" method="post">
<table class="table table-bordered table-striped header-spcing" ><tr><td style="text-align: left;vertical-align: middle;">
			开始日期：<input id="asaDateFrom" name="asaDateFrom" style="width: 110px;border: 1px solid #ccc;line-height: 30px;"
			class="Wdate" value="${asaDateFrom}"
			onFocus="var asaDateTo=$dp.$('asaDateTo');WdatePicker({onpicked:function(){asaDateTo.focus();},maxDate:'#F{$dp.$D(\'asaDateTo\')}'})" />
		&nbsp;&nbsp; 结束日期：<input name="asaDateTo" id="asaDateTo" style="width: 110px;border: 1px solid #ccc;line-height: 30px;"
			class="Wdate" value="${asaDateTo}"
			onFocus="WdatePicker({minDate:'#F{$dp.$D(\'asaDateFrom\')}'})" />
		&nbsp;&nbsp; <input id="month" type="checkbox"
			name="asaCheckbox" value="1" style="vertical-align: baseline;"
			<c:if test="${asaCheckbox eq '1'}">checked</c:if>>当月统计&nbsp;&nbsp;&nbsp;&nbsp;

		按科室统计：<input type="radio" class="dept" name="xuanze" value="1" style="vertical-align: baseline;" <c:if test="${xuanze eq '1'}">checked</c:if>/> <select id="dept"
			name="asake" style="width: 100px;"> 
			<option></option>
			<c:forEach items="${deptList}" var="ke" varStatus="status">
				<option value="${ke.name}"
					<c:if test="${asake eq ke.name}">selected</c:if>>${ke.name}</option>
			</c:forEach>
		</select>&nbsp;&nbsp; 按麻醉医师统计：<input type="radio" class="sop"  name="xuanze" value="2" style="vertical-align: baseline;" <c:if test="${xuanze eq '2'}">checked</c:if>/> <select id="sop" 
			name="asayi" style="width: 100px;">
			<option></option>
			<c:forEach items="${opList}" var="sop" varStatus="status">
				<option value="${sop.name}"
					<c:if test="${asayi eq sop.name}">selected</c:if>>${sop.name}</option>
			</c:forEach>
		</select>&nbsp;&nbsp; 按护士统计：<input type="radio" class="nurse"  name="xuanze" value="3" style="vertical-align: baseline;" <c:if test="${xuanze eq '3'}">checked</c:if>/> <select id="nurse" 
			name="asahu" style="width: 100px;">
			<option></option>
			<c:forEach items="${nurseList}" var="hu" varStatus="status">
				<option value="${hu.name}"
					<c:if test="${asahu eq hu.name}">selected</c:if>>${hu.name}</option>
			</c:forEach>
		</select>&nbsp;&nbsp; 
		<button type="button" class="button_blue_74_33" style="border: medium none; margin-left: 10px;"
							onclick="searchAsa()">查询</button>
</td></tr></table>	
		
		<table class="table table-bordered table-striped header-spcing" id="table">
		<thead>
				<tr class="bj">
				<td colspan="8">
				<c:if test="${asaCheckbox eq '1'}">
				当月ASA统计(${fn:substring(asaDateFrom, 0, 4)}年${fn:substring(asaDateFrom, 6,7)}月)</c:if>
				<c:if test="${asaDateFrom eq null}">全部ASA统计</c:if>
				<c:if test="${xuanze eq '1'}">科室-ASA统计(${asaDateFrom}-${asaDateTo})</c:if>
				<c:if test="${xuanze eq '2'}">麻醉师-ASA统计(${asaDateFrom}-${asaDateTo})</c:if>
				<c:if test="${xuanze eq '3'}">护士-ASA统计(${asaDateFrom}-${asaDateTo})</c:if>
				</td>
			</tr>
			</thead>
			<tr class="No">
				<th width="20%"></th>
				<th>Ⅰ</th>
				<th>Ⅱ</th>
				<th>Ⅲ</th>
				<th>Ⅳ</th>
				<th>Ⅴ</th>
				<th>Ⅵ</th>
				<th>总计</th>
			</tr>
			<c:forEach items="${asaJiList}" var="asa">
				<tr class="No">
					<td>${asa.name}</td>
					<td class="lv1">${asa.level1}</td>
					<td class="lv2">${asa.level2}</td>
					<td class="lv3">${asa.level3}</td>
					<td class="lv4">${asa.level4}</td>
					<td class="lv5">${asa.level5}</td>
					<td class="lv6">${asa.level6}</td>
					<td class="total"></td>
				</tr>
			</c:forEach>


		</table>
	</form>
</body>
</html>