<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>术后随访</title>


	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/validate/jquery.validate.js"></script>
<link rel="stylesheet" href="../js/validate/jquery.validate.css" />
<script type="text/javascript" src="../js/validate/jquery.metadata.js"></script>
<script type="text/javascript" src="../js/validate/messages_cn.js"></script>	
	
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">
function saveTemplateTo() {

	var w = screen.width;

	var h = screen.height;

	var arg = new Object();
	arg.win = window;
	window.showModalDialog("templateTo.action",arg,'help:no;dialogWidth=405px;dialogHeight=248px;dialogLeft='+w/3+';dialogTop='+h/2+';');

}

function saveTemplate(type,name) {
	$("#templateType").val(type);
	$("#templateName").val(name);
	
	$.post("saveShsfTemplate.action",$("#form").serialize(),function(){
		alert('保存成功！');
	});
}

function choseTemplate() {
	var w = screen.width;

	var h = screen.height;

	var arg = new Object();
	arg.win = window;
	window.showModalDialog("choseTemplateTo.action",arg,'help:no;dialogWidth=565px;dialogHeight=365px;dialogLeft='+w*1/5+';dialogTop='+h*1/3+';');
}

function setTemplateVal(id) {
	
	$.post("getTemplateVal.action",{templateId:id},function(data){
		$("#bloodPressure").val(data[0].bloodPressure);
		$("#pulse").val(data[0].pulse);
		
		$("#time1").val(data[0].observetime);
		if(data[0].awarenessOperation==0) {
			$("#awarenessOperation0").attr('checked',true);
		} else {
			$("#awarenessOperation1").attr('checked',true);
		}
		if(data[0].muscularSoreness==0) {
			$("#muscularSoreness0").attr('checked',true);
		} else {
			$("#muscularSoreness1").attr('checked',true);
		}
		if(data[0].allsick==0) {
			$("#allsick0").attr('checked',true);
		} else {
			$("#allsick1").attr('checked',true);
		}
		if(data[0].allvomit==0) {
			$("#allvomit0").attr('checked',true);
		} else {
			$("#allvomit1").attr('checked',true);
		}
		if(data[0].faucesache==0) {
			$("#faucesache0").attr('checked',true);
		} else {
			$("#faucesache1").attr('checked',true);
		}
		if(data[0].soundhoarseness==0) {
			$("#soundhoarseness0").attr('checked',true);
		} else {
			$("#soundhoarseness1").attr('checked',true);
		}
		$('#sf1').val(data[0].observepeople);
		$('#nerveBlockedRemark').val(data[0].nerveBlockedRemark);
		$('#time2').val(data[0].nerveBlockedObservetime);	
		if(data[0].lumbago==0) {
			$("#lumbago0").attr('checked',true);
		} else {
			$("#lumbago1").attr('checked',true);
		}
		if(data[0].neuralsick==0) {
			$("#neuralsick0").attr('checked',true);
		} else {
			$("#neuralsick1").attr('checked',true);
		}
		if(data[0].neuralvomit==0) {
			$("#neuralvomit0").attr('checked',true);
		} else {
			$("#neuralvomit1").attr('checked',true);
		}
		if(data[0].legParesthesia==0) {
			$("#legParesthesia0").attr('checked',true);
		} else if(data[0].legParesthesia==1) {
			$("#legParesthesia1").attr('checked',true);
		} else if(data[0].legParesthesia==2) {
			$("#legParesthesia2").attr('checked',true);
		} else {
			$("#legParesthesia3").attr('checked',true);
		} 
		if(data[0].legMovement==0) {
			$("#legMovement0").attr('checked',true);
		} else if(data[0].legParesthesia==1) {
			$("#legMovement1").attr('checked',true);
		} else if(data[0].legParesthesia==2) {
			$("#legMovement2").attr('checked',true);
		} else {
			$("#legMovement3").attr('checked',true);
		}
		$('#sf4').val(data[0].neuralObservepeople);
		$('#neuralRemark').val(data[0].neuralRemark);
		$('#remark').val(data[0].remark);
		if(data[0].analgesiaplan==0) {
			$("#analgesiaplan0").attr('checked',true);
		} else if(data.analgesiaplan==1) {
			$("#analgesiaplan1").attr('checked',true);
		} else {
			$("#analgesiaplan2").attr('checked',true);
		}
		$('#time3').val(data[0].observeaftertime);
		$('#quietvas').val(data[0].quietvas);
		$('#exercisevas').val(data[0].exercisevas);
		if(data[0].naupathia==0) {
			$("#naupathia0").attr('checked',true);
		} else {
			$("#naupathia1").attr('checked',true);
		}
		if(data[0].vomit==0) {
			$("#vomit0").attr('checked',true);
		} else {
			$("#vomit1").attr('checked',true);
		}
		if(data[0].pruritus==0) {
			$("#pruritus0").attr('checked',true);
		} else {
			$("#pruritus1").attr('checked',true);
		}
		$("#sf7").val(data[0].observepeopleafter);
		$("#remarkafter").val(data[0].remarkafter);
	},'json');
}



$(function() {
	$.metadata.setType("attr", "validate");
	$("#form").validate();
});

	CreateReport("Report");
	function printSf() {
		Report.LoadFromURL("../jsp/sm/shsf/sf.grf");
		AjaxSyncLoadReportData(Report,"loadPrintSf.action?id="+$("#ylwsid").val());

		Report.PrintPreview(true);
	}	

	//返回
	function back() {
		window.location.href = "${pageContext.request.contextPath}/ylws/ylwsList.action?functionid="+$('#functionid').val();
	}

	
	function check() {
		if ($("#form").valid()){
		document.forms["form"].submit();}
	else {
		return;
	}
	}

	var err = "<%=info%>";
	if (err.length > 0) {
		alert(err);

	}

	//获取当前时间
	function disptime() {
		var time = new Date(); //获得当前时间
		var year = time.getFullYear();//获得年、月、日
		var month = time.getMonth() + 1;
		var date = time.getDate();
		var hour = time.getHours(); //获得小时、分钟、秒
		var minute = time.getMinutes();
		if (hour > 24) //按24小时制显示
		{
			hour = hour - 24;
		}
		if (minute < 10) //如果分钟只有1位，补0显示
			minute = "0" + minute;
		if (month < 10) //如果月份只有1位，补0显示
			month = "0" + month;
		/*设置文本框的内容为当前时间*/
		riqi = year + "-" + month + "-" + date + " " + hour + ":" + minute;
		/*设置定时器每隔1秒（1000毫秒），调用函数disptime()执行，刷新时钟显示*/
		var myTime = setTimeout("disptime()", 1000);

	}
	function Riqi1() {
		document.getElementById("time1").value = riqi;
	}
	function Riqi2() {
		document.getElementById("time2").value = riqi;
	}
	function Riqi3() {
		document.getElementById("time3").value = riqi;
	}

	//获取随访人
	function sfr1() {
		var doctor = $(".doctor:selected").val();

		document.getElementById("sf1").value = doctor;
	}

	function sfr4() {
		var doctor = $(".doctor:selected").val();

		document.getElementById("sf4").value = doctor;
	}

	function sfr7() {
		var doctor = $(".doctor:selected").val();

		document.getElementById("sf7").value = doctor;
	}

	//清空一条数据
	function cl() {
		$(".qmbtn").attr("checked", false);
		document.getElementById('time1').value = "";
		document.getElementById('sf1').value = "";
	}

	function cl4() {
		$(".zgmbtn").attr("checked", false);
		document.getElementById('time2').value = "";
		document.getElementById('sf4').value = "";
	}

	function cl7() {
		$(".ztbtn").attr("checked", false);
		document.getElementById('time3').value = "";
		document.getElementById('sf7').value = "";
		$(".gj").val("");
	}
</script>
<style>
input[type="radio"] {
vertical-align: baseline;
}
</style>
</head>
<body class="page-header-fixed" onload="disptime();">

	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">术后随访</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choseTemplate()">读取模板</button>
					
	<form id="form" name="form" action="modShsfList.action" method="post">
		<input type="hidden" name="templateType" id="templateType">
		<input type="hidden" name="templateName" id="templateName">
		<input type="hidden" name="functionid" id="functionid" value="${functionid }">
		<table class="table table-bordered table-striped header-spcing" id="table">

			<c:forEach items="${shsfList}" var="ylws">
				<input type="hidden" name="ylwsid" id="ylwsid" value="${ylws.id}">
				<input type="hidden" name="shsf.docId" id="docId" value="${ylws.id}">
				<tr>

					<th width="20%">病人姓名：&nbsp;&nbsp;&nbsp;&nbsp;${ylws.name}</th>
					<th width="10%" align="right">性别：&nbsp;&nbsp;&nbsp;&nbsp;<c:if
							test="${ylws.sex eq '0'}">男</c:if> <c:if
							test="${ylws.sex eq '1'}">女</c:if></th>

					<th width="10%">年龄：&nbsp;&nbsp;&nbsp;&nbsp;${ylws.age}</th>
					<th colspan="2">住院号：&nbsp;&nbsp;&nbsp;&nbsp;${ylws.hid}</th>

					<th colspan="2">病区：&nbsp;&nbsp;&nbsp;&nbsp;${ylws.region}</th>

					<th colspan="2" width="10%">床号：&nbsp;&nbsp;&nbsp;&nbsp;${ylws.bed}</th>

				</tr>

				<tr>
					<th colspan="2">手术时间：&nbsp;&nbsp;&nbsp;&nbsp;${fn:substring(ylws.operdate,
						0, 10)}</th>

					<th colspan="7" style="text-align: left;">拟行手术：&nbsp;&nbsp;&nbsp;&nbsp;${ylws.designedOptName}</th>

				</tr>
			</c:forEach>
			<tr>
				<th colspan="9" style="text-align: left;">患者一般情况</th>
			</tr>
			<tr>
				<td colspan="9" style="text-align: left;padding-left: 20px;">血压（mmHg）：<input name="shsf.bloodPressure" id="bloodPressure"
					style="width: 90px;" value="${shsf.bloodPressure}" />
				</td>
			</tr>
			<tr>
				<td colspan="9" style="text-align: left;padding-left: 20px;">脉搏（次/分）：<input name="shsf.pulse" size="5" id="pulse"
					style="width: 50px;" value="${shsf.pulse}" /></td>
			</tr>
			<tr>
				<th colspan="9" style="text-align: left;">全麻</th>
			</tr>
			<tr>
				<td align="center" style="width: 10%;">观察时间
				<td align="center"  style="width: 10%;">术中知晓
				<td align="center"  style="width: 10%;">肌肉酸痛</td>
				<td align="center"  style="width: 10%;">恶心
				<td align="center" style="width: 10%;">呕吐
				<td align="center"  style="width: 10%;">咽喉痛</td>
				<td align="center"  style="width: 10%;">声音嘶哑
				<td align="center" style="width: 10%;">随访人</td>
				<td align="center"  style="width: 10%;">操作</td>
			</tr>
			<tr>
				<td style="vertical-align: middle;"><input id="time1" style="width: 110px;" onclick="Riqi1()"
					name="shsf.observetime" value="${shsf.observetime}"></td>
				<td align="center">
				<input name="shsf.awarenessOperation" class="qmbtn" type="radio" value="0" id="awarenessOperation0"
					<c:if test="${shsf.awarenessOperation eq '0'}">checked</c:if> />有&nbsp;&nbsp;
				<input name="shsf.awarenessOperation" class="qmbtn" type="radio" value="1" id="awarenessOperation1"
					<c:if test="${shsf.awarenessOperation eq '1'}">checked</c:if> />无




				
				<td align="center"><input name="shsf.muscularSoreness" id="muscularSoreness0"
					class="qmbtn" type="radio" value="0"
					<c:if test="${shsf.muscularSoreness eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.muscularSoreness" class="qmbtn" type="radio" value="1" id="muscularSoreness1"
					<c:if test="${shsf.muscularSoreness eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.allsick" class="qmbtn" id="allsick0"
					type="radio" value="0"
					<c:if test="${shsf.allsick eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.allsick" class="qmbtn" type="radio" value="1" id="allsick1"
					<c:if test="${shsf.allsick eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.allvomit" class="qmbtn" id="allvomit0"
					type="radio" value="0"
					<c:if test="${shsf.allvomit eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.allvomit" class="qmbtn" type="radio" value="1" id="allvomit1"
					<c:if test="${shsf.allvomit eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.faucesache" class="qmbtn" id="faucesache0"
					type="radio" value="0"
					<c:if test="${shsf.faucesache eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.faucesache" class="qmbtn" type="radio" value="1" id="faucesache1"
					<c:if test="${shsf.faucesache eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.soundhoarseness"
					class="qmbtn" type="radio" value="0" id="soundhoarseness0"
					<c:if test="${shsf.soundhoarseness eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.soundhoarseness" class="qmbtn" type="radio" value="1" id="soundhoarseness1"
					<c:if test="${shsf.soundhoarseness eq '1'}">checked</c:if> />无
				<td align="center" style="vertical-align: middle;"><input size="5" id="sf1" onclick="sfr1()" style="width: 110px;"
					name="shsf.observepeople" value="${shsf.observepeople}">
				<td align="center"><a onclick="cl()"
					style="text-decoration: underline;cursor: pointer;">清空</a>
				</td>
			</tr>


			<tr>
				<td style="vertical-align: middle;">其他特殊情况及处理：</td>
				<td colspan="8"><textarea cols="80" rows="1" id="nerveBlockedRemark"
						name="shsf.nerveBlockedRemark">${shsf.nerveBlockedRemark}</textarea>
				</td>
			</tr>
			<tr>
				<th colspan="9" style="text-align: left;">椎管内麻醉</th>
			</tr>
			<tr>
				<td align="center">观察时间
				<td align="center">腰痛
				<td align="center">恶心
				<td align="center">呕吐
				<td align="center">下肢感觉异常</td>
				<td align="center" >下肢运动异常
				<td align="center">随访人</td>
				<td align="center" colspan="2">操作</td>
			</tr>
			<tr>
				<td style="vertical-align: middle;"><input id="time2" size="14" onclick="Riqi2()"
					name="shsf.nerveBlockedObservetime" style="width: 110px;"
					value="${shsf.nerveBlockedObservetime}"></td>
				<td align="center"><input name="shsf.lumbago" class="zgmbtn"
					type="radio" value="0" id="lumbago0"
					<c:if test="${shsf.lumbago eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.lumbago" class="zgmbtn" type="radio" value="1" id="lumbago1"
					<c:if test="${shsf.lumbago eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.neuralsick" class="zgmbtn"
					type="radio" value="0" id="neuralsick0"
					<c:if test="${shsf.neuralsick eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.neuralsick" class="zgmbtn" type="radio" value="1" id="neuralsick1"
					<c:if test="${shsf.neuralsick eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.neuralvomit"
					class="zgmbtn" type="radio" value="0" id="neuralvomit0"
					<c:if test="${shsf.neuralvomit eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.neuralvomit" class="zgmbtn" type="radio" value="1" id="neuralvomit1"
					<c:if test="${shsf.neuralvomit eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.legParesthesia"
					class="zgmbtn" type="radio" value="0" id="legParesthesia0"
					<c:if test="${shsf.legParesthesia eq '0'}">checked</c:if> />有&nbsp;<input
					name="shsf.legParesthesia" class="zgmbtn" type="radio" value="1" id="legParesthesia1"
					<c:if test="${shsf.legParesthesia eq '1'}">checked</c:if> />无 <input
					name="shsf.legParesthesia" class="zgmbtn" type="radio" value="2" id="legParesthesia2"
					<c:if test="${shsf.legParesthesia eq '2'}">checked</c:if> />&nbsp;左侧&nbsp;<input
					name="shsf.legParesthesia" class="zgmbtn" type="radio" value="3" id="legParesthesia3"
					<c:if test="${shsf.legParesthesia eq '3'}">checked</c:if> />右侧
				<td align="center" ><input name="shsf.legMovement"
					class="zgmbtn" type="radio" value="0" id="legMovement0"
					<c:if test="${shsf.legMovement eq '0'}">checked</c:if> />有&nbsp;<input
					name="shsf.legMovement" class="zgmbtn" type="radio" value="1" id="legMovement1"
					<c:if test="${shsf.legMovement eq '1'}">checked</c:if> />无&nbsp;<input
					name="shsf.legMovement" class="zgmbtn" type="radio" value="2" id="legMovement2"
					<c:if test="${shsf.legMovement eq '2'}">checked</c:if> />左侧&nbsp;<input
					name="shsf.legMovement" class="zgmbtn" type="radio" value="3" id="legMovement3"
					<c:if test="${shsf.legMovement eq '3'}">checked</c:if> />右侧
				<td style="vertical-align: middle;"><input size="5" id="sf4" onclick="sfr4()" id="neuralObservepeople"
					style="width: 110px;" name="shsf.neuralObservepeople" value="${shsf.neuralObservepeople}">
				<td align="center" colspan="2"><a onclick="cl4()"
					style="text-decoration: underline;cursor: pointer;">清空</a>
				</td>
			</tr>


			<tr>
				<td style="vertical-align: middle;">其他特殊情况及处理：</td>
				<td colspan="8"><textarea cols="80" rows="1" id="neuralRemark"
						name="shsf.neuralRemark">${shsf.neuralRemark}</textarea>
				</td>
			</tr>

			<tr>
				<th colspan="9" style="text-align: left;">（臂丛 颈丛 坐骨）麻醉</th>
			<tr>
				<td style="vertical-align: middle;">并发情况及处理：</td>
				<td colspan="8"><textarea id="remark" cols="80" rows="1" name="shsf.remark">${shsf.remark}</textarea>
				</td>
			</tr>

			<tr>
				<th colspan="9" style="text-align: left;">麻醉术后镇痛观察记录【<font color="red">*</font>痛觉评分（VAS）标准：0分
					有痛；10分 强烈疼痛；1-3分 轻度疼痛；4-6分 中度疼痛；7-10分 重度疼痛。】</th>
			</tr>
			<tr>
				<td colspan="9">镇痛方案：&nbsp;&nbsp;&nbsp;&nbsp;<input
					name="shsf.analgesiaplan" id="analgesiaplan0"
					<c:if test="${shsf.analgesiaplan eq '0'}">checked</c:if>
					class="ztbtn" type="radio" value="0" />PCIA&nbsp;&nbsp;<input
					name="shsf.analgesiaplan" class="ztbtn" type="radio" id="analgesiaplan1"
					<c:if test="${shsf.analgesiaplan eq '1'}">checked</c:if> value="1" />PCEA&nbsp;&nbsp;<input
					name="shsf.analgesiaplan" class="ztbtn" type="radio" id="analgesiaplan2"
					<c:if test="${shsf.analgesiaplan eq '2'}">checked</c:if> value="2" />其他</td>

			</tr>
			<tr>
				<td align="center" width="10%" rowspan="2"
					style="vertical-align: middle;">观察时间
				<td align="center" width="10%" colspan="2">感觉评分（VAS）
				<td align="center" width="10%" rowspan="2"
					style="vertical-align: middle;">恶心
				<td align="center" width="10%" rowspan="2"
					style="vertical-align: middle;">呕吐
				<td align="center" width="22%" rowspan="2"
					style="vertical-align: middle;">皮肤瘙痒
				<td align="center" rowspan="2" style="vertical-align: middle;">随访人</td>
				<td align="center" width="5%" colspan="2" rowspan="2"
					style="vertical-align: middle;">操作</td>
			</tr>
			<tr>
				<td align="center" width="10%">安静时
				<td align="center" width="10%">活动时
			</tr>
			<tr>
				<td style="vertical-align: middle;"><input id="time3" size="14" onclick="Riqi3()" style="width: 110px;"
					name="shsf.observeaftertime" value="${shsf.observeaftertime}">
				</td>
				<td style="vertical-align: middle;"><input name="shsf.quietvas" class="gj" id="quietvas" style="width: 110px;"
					value="${shsf.quietvas}" /></td>
				<td style="vertical-align: middle;"><input name="shsf.exercisevas" class="gj" id="exercisevas" style="width: 110px;"
					value="${shsf.exercisevas}" /></td>
				<td align="center"><input name="shsf.naupathia" class="ztbtn" id="naupathia0"
					type="radio" value="0"
					<c:if test="${shsf.naupathia eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.naupathia" class="ztbtn" type="radio" value="1" id="naupathia1"
					<c:if test="${shsf.naupathia eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.vomit" class="ztbtn"
					type="radio" value="0" id="vomit0"
					<c:if test="${shsf.vomit eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.vomit" class="ztbtn" type="radio" value="1" id="vomit1"
					<c:if test="${shsf.vomit eq '1'}">checked</c:if> />无
				<td align="center"><input name="shsf.pruritus" class="ztbtn"
					type="radio" value="0" id="pruritus0"
					<c:if test="${shsf.pruritus eq '0'}">checked</c:if> />有&nbsp;&nbsp;<input
					name="shsf.pruritus" class="ztbtn" type="radio" value="1" id="pruritus1"
					<c:if test="${shsf.pruritus eq '1'}">checked</c:if> />无
				<td style="vertical-align: middle;"><input size="5" id="sf7" onclick="sfr7()"  style="width: 110px;"
					name="shsf.observepeopleafter" value="${shsf.observepeopleafter}">
				<td align="center" colspan="2"><a onclick="cl7()"
					style="text-decoration: underline;cursor: pointer;">清空</a>
				</td>
			</tr>
			<tr>
				<td style="vertical-align: middle;">其他特殊情况及处理：</td>
				<td colspan="8"><textarea cols="80" rows="1" id="remarkafter"
						name="shsf.remarkafter">${shsf.remarkafter}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="9" style="text-align: right;vertical-align: middle;">麻醉医师：<select>
						<c:forEach items="${opList}" var="sop" varStatus="status">
							<option class="doctor" value="${sop.name}">${sop.name}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
		</table>
		<div style="text-align: center; margin-top: 2%;">
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveTemplateTo()">存为模板</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check()">保存</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="printSf()">打印</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
		</div>
	</form>
</div>
</div>
</div>
</body>
</html>