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
<title>术前访视</title>
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
function printP() {
	Report.LoadFromURL("../jsp/sm/preVisit/preVisit.grf");
	AjaxSyncLoadReportData(Report,"loadPrint.action?ylwsid="+$("#ylws").val());
	Report.PrintPreview(true);
}

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
	$.post("savePreVisitTemplate.action",$("#visit").serialize(),function(){
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
	$("#visit :checkbox").attr('checked',false);

	$.post("getTemplateVal.action",{templateId:id},function(data){
		$('#height').val(data[0].height);
		$('#weight').val(data[0].weight);
		$('#complaint').val(data[0].complaint);
		
		$('#BP1').val(data[0].BP1);
		$('#BP2').val(data[0].BP2);
		$('#R').val(data[0].R);
		$('#P').val(data[0].P);
		$('#T').val(data[0].T);
		$('#elze').val(data[0].elze);
		
		$('#heartbool').val(data[0].heartbool);
		$('#heartboolDetail').val(data[0].heartboolDetail);
		$('#heartboolOther').val(data[0].heartboolOther);
		$('#lungbreath').val(data[0].lungbreath);
		$('#lungbreathDetail').val(data[0].lungbreathDetail);
		$('#lungbreathOther').val(data[0].lungbreathOther);
		$('#urologyprocreate').val(data[0].urologyprocreate);
		$('#urologyprocreateDetail').val(data[0].urologyprocreateDetail);
		$('#urologyprocreateOther').val(data[0].urologyprocreateOther);
		$('#digest').val(data[0].digest);
		$('#digestDetail').val(data[0].digestDetail);
		$('#digestOther').val(data[0].digestOther);
		$('#nevemuscle').val(data[0].nevemuscle);
		$('#nevemuscleDetail').val(data[0].nevemuscleDetail);
		$('#nevemuscleOther').val(data[0].nevemuscleOther);
		$('#boold').val(data[0].boold);
		$('#booldDetail').val(data[0].booldDetail);
		$('#booldOther').val(data[0].booldOther);
		$('#incretion').val(data[0].incretion);
		$('#incretionDetail').val(data[0].incretionDetail);
		$('#incretionOther').val(data[0].incretionOther);
		$('#spirit').val(data[0].spirit);
		$('#spiritDetail').val(data[0].spiritDetail);
		$('#spiritOther').val(data[0].spiritOther);
		$('#obstetrical').val(data[0].obstetrical);
		$('#obstetricalDetail').val(data[0].obstetricalDetail);
		$('#obstetricalOther').val(data[0].obstetricalOther);
		$('#smokecase').val(data[0].smokecase);
		$('#smokecaseDetail').val(data[0].smokecaseDetail);
		$('#smokecaseOther').val(data[0].smokecaseOther);
		$('#allergic').val(data[0].allergic);
		$('#allergicDetail').val(data[0].allergicDetail);
		$('#allergicOther').val(data[0].allergicOther);
		$('#hereditycase').val(data[0].hereditycase);
		$('#hereditycaseDetail').val(data[0].hereditycaseDetail);
		$('#hereditycaseOther').val(data[0].hereditycaseOther);
		$('#specialmedica').val(data[0].specialmedica);
		$('#specialmedicaDetail').val(data[0].specialmedicaDetail);
		$('#specialmedicaOther').val(data[0].specialmedicaOther);
		$('#mainCase').val(data[0].mainCase);
		$('#mainCaseDetail').val(data[0].mainCaseDetail);
		$('#mainCaseOther').val(data[0].mainCaseOther);
		
		$('#asa').val(data[0].ASA);
		$('#stomach').val(data[0].fullStomach);
		$('#disposal').val(data[0].disposal);
		
		setPreVal();
	},'json');
}

function saveP() {
	if(check()) {
		saveTest();
		$.post("savePreVisit.action",$("#visit").serialize(),function(){
			alert('保存成功！');
		});
	}
}
function commitP() {
	if(check()) {
		$.post("commitPreVisit.action",$("#visit").serialize(),function(){
			alert('确认成功！');
			$(":input").attr("disabled",true);
			$("#backb").attr("disabled",false);
			$("#printp").attr("disabled",false);
		});
	}
}
function back() {
	window.location.href="../ylws/ylwsList.action?functionid="+$('#functionid').val();
}

function setPreVal() {
	if($("#heartbool").val()=="有") {
		$("#heartbool").parent().parent().find('.you').click();
		$("#heartbool").parent().parent().find('textArea').val($("#heartboolOther").val());
		var s = $("#heartboolDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#heartbool").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#lungbreath").val()=="有") {
		$("#lungbreath").parent().parent().find('.you').click();
		$("#lungbreath").parent().parent().find('textArea').val($("#lungbreathOther").val());
		var s = $("#lungbreathDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#lungbreath").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#urologyprocreate").val()=="有") {
		$("#urologyprocreate").parent().parent().find('.you').click();
		$("#urologyprocreate").parent().parent().find('textArea').val($("#urologyprocreateOther").val());
		var s = $("#urologyprocreateDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#urologyprocreate").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#digest").val()=="有") {
		$("#digest").parent().parent().find('.you').click();
		$("#digest").parent().parent().find('textArea').val($("#digestOther").val());
		var s = $("#digestDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#digest").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#nevemuscle").val()=="有") {
		$("#nevemuscle").parent().parent().find('.you').click();
		$("#nevemuscle").parent().parent().find('textArea').val($("#nevemuscleOther").val());
		var s = $("#nevemuscleDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#nevemuscle").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#boold").val()=="有") {
		$("#boold").parent().parent().find('.you').click();
		$("#boold").parent().parent().find('textArea').val($("#booldOther").val());
		$("#boold").parent().parent().find(':text').val($("#booldDetail").val());
	}
	
	if($("#incretion").val()=="有") {
		$("#incretion").parent().parent().find('.you').click();
		$("#incretion").parent().parent().find('textArea').val($("#incretionOther").val());
		var s = $("#incretionDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#incretion").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#spirit").val()=="有") {
		$("#spirit").parent().parent().find('.you').click();
		$("#spirit").parent().parent().find('textArea').val($("#spiritOther").val());
		var s = $("#spiritDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#spirit").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#obstetrical").val()=="有") {
		$("#obstetrical").parent().parent().find('.you').click();
		$("#obstetrical").parent().parent().find('textArea').val($("#obstetricalOther").val());
		$("#obstetrical").parent().parent().find(':text').val($("#obstetricalDetail").val());
	}
	
	if($("#smokecase").val()=="有") {
		$("#smokecase").parent().parent().find('.you').click();
		$("#smokecase").parent().parent().find('textArea').val($("#smokecaseOther").val());
		var s = $("#smokecaseDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#smokecase").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#allergic").val()=="有") {
		$("#allergic").parent().parent().find('.you').click();
		$("#allergic").parent().parent().find('textArea').val($("#allergicOther").val());
		var s = $("#allergicDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#allergic").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#hereditycase").val()=="有") {
		$("#hereditycase").parent().parent().find('.you').click();
		$("#hereditycase").parent().parent().find('textArea').val($("#hereditycaseOther").val());
		var s = $("#hereditycaseDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#hereditycase").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#specialmedica").val()=="有") {
		$("#specialmedica").parent().parent().find('.you').click();
		$("#specialmedica").parent().parent().find('textArea').val($("#specialmedicaOther").val());
		$("#specialmedica").parent().parent().find(':text').val($("#specialmedicaDetail").val());
	}
	
	if($("#mainCase").val()=="有") {
		$("#mainCase").parent().parent().find('.you').click();
		$("#mainCase").parent().parent().find('textArea').val($("#mainCaseOther").val());
		var s = $("#mainCaseDetail").val().split(", ");
		for(var i=0;i<s.length;i++) {
			var v = s[i];
			$("#mainCase").parent().parent().find(':checkbox').each(function(){
				if($(this).val()==v) 
					$(this).attr("checked", true);
			});
		}
	}
	
	if($("#stomach").val()=="是") {
		$("#yesf").attr('checked',true);
	}
	if($("#stomach").val()=="否") {
		$("#nof").attr('checked',true);
	}

	
	if($("#status").val()=="1") {
		$(":input").attr("disabled",true);
		$("#backb").attr("disabled",false);
		$("#printp").attr("disabled",false);
	}
}

$(function(){
	alert("请注意术前诊断，拟施手术名称是否正确！");

	if($("#stomach").val()=="是") {
		$("#yesf").attr('checked',true);
	}
	if($("#stomach").val()=="否") {
		$("#nof").attr('checked',true);
	}

	$(":radio.wu").attr("checked", true);
	
	$("#history").find(":checkbox").attr("disabled",true);
	$("#history").find("textArea").attr("disabled",true);
	$("#history").find(":text").attr("disabled",true);
	
	$(".you").click(function(){
		$(this).parent().parent().find("textArea").attr("disabled",false);
		$(this).parent().parent().find(":checkbox").attr("disabled",false);
		$(this).parent().parent().find(":text").attr("disabled",false);
	});
	
	$(".wu").click(function(){
		$(this).parent().parent().find("textArea").val("").attr("disabled",true);
		$(this).parent().parent().find(":checkbox").attr("disabled",true);
		$(this).parent().parent().find(":text").val("").attr("disabled",true);
		$(this).parent().parent().find(':checkbox').each(function(){
			$(this).attr("checked", false);
		});
	});
	
	setPreVal();
	
	var now = new Date();
	var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日
    var date = year + "-";
	if(month < 10)
		date += "0";
    date += month + "-";
    if(day < 10)
        date += "0";    
    date += day;

	var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分
    var ss = now.getSeconds();
	var time = "";
	if(hh < 10)
		time += "0";  
    time += hh + ":";
    if (mm < 10)
    	time += '0'; 
    time += mm + ":";
    if (ss < 10)
    	time += '0'; 
    time += ss;
			
	$('#visitDate').val(date+" "+time);

});

function chooseASA() {
var w = screen.width;

var h = screen.height;

	var arg = new Object();
	arg.win = window;
	window.showModalDialog("chooseAsaTo.action",arg,'help:no;dialogWidth=690px;dialogHeight=500px;dialogLeft='+w/3+';dialogTop='+h/2+';');
}

function setAsa(str) {
	$("#asa").val(str);
}

function check() {

	var reg = /^[1-2]\d{2}$/;
	if(!reg.test($("#height").val())) {
		if($("#height").val()=="") {
			alert('请输入身高！');
			return false;
		} else {
			alert('请输入正确身高！');
			return false;
		}
	}
	
	var reg1 = /^\d{2}(\.\d){0,2}$|^\d{3}(\.\d){0,2}$/;
	if(!reg1.test($("#weight").val())) {
		if($("#weight").val()=="") {
			alert('请输入体重！');
			return false;
		} else {
			alert('请输入正确体重！');
			return false;
		}
	}

	var reg2 = /^[1-9]\d{0,2}$/;
	if($("#BP1").val()!=""&&$("#BP2").val()!="") {
		if(!reg2.test($("#BP1").val())) {
			alert('请输入正确血压值！');
			return false;
		}
		if(!reg2.test($("#BP2").val())) {
			alert('请输入正确血压值！');
			return false;
		}
	} else if($("#BP1").val()==""&&$("#BP2").val()=="") {
		
	} else {
		alert('请补全血压值！');
	}
	
	if($("#R").val()!="") {
		if(!reg2.test($("#R").val())) {
			alert('请输入正确心率值！');
			return false;
		}
	}
	
	if($("#P").val()!="") {
		if(!reg2.test($("#P").val())) {
			alert('请输入正确呼吸值！');
			return false;
		}
	}
	
	var reg3 = /^\d{2}(\.\d){0,2}$/;
	if($("#T").val()!="") {
		if(!reg3.test($("#T").val())) {
			alert('请输入正确体温！');
			return false;
		}
		if(parseFloat($("#T").val())<33||parseFloat($("#T").val())>45) {
			alert('请输入正确体温！');
			return false;
		}
	}
	
	if($("#asa").val()=="") {
		alert('请选择ASA分级！');
		return false;
	}
	
	if(!$("#yesf").attr('checked')&&!$("#nof").attr('checked')) {
		alert('请选择是否饱胃！');
		return false;
	}
	
	return true;
}
//加载检验检查项
function loadP(){
       $.post( "${pageContext.request.contextPath}/preVisit/loadTest.action", {hid:$('#ylws').val()},     
               function(data){
                   var json = data;  
                   testData = eval('(' + json + ')');
                   $('#hbId').val(testData.Hb);
                   $('#hctId').val(testData.HCT);
                   $('#wbcId').val(testData.WBC);
                   $('#pltId').val(testData.PLT);
                   $('#kJiaId').val(testData.K);
                   $('#naJiaId').val(testData.Na);
                   $('#clJianId').val(testData.Cl);
                   $('#gluId').val(testData.GLU);
                   $('#sgptId').val(testData.SGPT);
                   $('#bunId').val(testData.BUN);
                   $('#crId').val(testData.Cr);
                   $('#ptId').val(testData.PT);
                   $('#apttId').val(testData.APTT);
                   $('#paO2Id').val(testData.PaO2);
                });
}

//保存检验检查
function saveTest(){
       var params={operationId:$('#ylws').val(),hb:$('#hbId').val(),hct:$('#hctId').val(),
                   wbc:$('#wbcId').val(),plt:$('#pltId').val(),KPlus:$('#kJiaId').val(),
                   naPlus:$('#naJiaId').val(),clReduce:$('#clJianId').val(),glu:$('#gluId').val(),
                   sgpt:$('#sgptId').val(),bun:$('#bunId').val(),cr:$('#crId').val(),pt:$('#ptId').val(),aptt:$('#apttId').val(),pao2:$('#paO2Id').val()};
       $.post( "${pageContext.request.contextPath}/preVisit/saveTest.action", 
       params,     
       function(data){
          });
}


















</script>
<style type="text/css">
.bottom {
 border-left: 0;
 border-right: 0;
 border-top: 0;
 border-bottom: 1px solid #000000;
 text-align: center;
 background-color: white;
}
.noboder {
 border-left: 0;
 border-right: 0;
 border-top: 0;
 border-bottom: 0;
 background-color: white;
}
textarea {
	width: 400px;
}
input[type="checkbox"] {
vertical-align: baseline;
}
input[type="radio"] {
vertical-align: baseline;
}
</style>
</head>
<body class="page-header-fixed">
<input id="functionid" type="hidden" value="${functionid }">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">术前访视</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choseTemplate()">读取模板</button>
						<form id="visit">
						<input id="status" type="hidden" value="${preVisit.state }">
						<input id="ylws" type="hidden" name="preVisit.operationId" value="${ylwsid}">
						<input id="hid" type="hidden" value="${sro.hid}">
						<input type="hidden" name="preVisit.id" value="${preVisit.id }">
						<input type="hidden" name="spVmh.id" value="${spVmh.id }">
						
						<input type="hidden" name="templateType" id="templateType">
						<input type="hidden" name="templateName" id="templateName">
						
						<table class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								基本信息
								</td>
							</tr>
							</thead>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									姓名：<input type="text" name="name" value="${sro.name }" disabled="disabled" class="noboder" style="width: 70px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									年龄：<input type="text" name="age" value="${sro.age }岁" disabled="disabled" class="noboder" style="width: 70px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									姓别： <input type="radio" name="sex" disabled="disabled" <c:if test="${sro.sex eq 0 }">checked</c:if>>男 
										<input type="radio" name="sex" disabled="disabled" <c:if test="${sro.sex eq 1 }">checked</c:if>>女
								</td>
								<td style="text-align: left;padding-left: 10px;">
									身高：<input id="height" type="text" name="preVisit.height" value="${preVisit.height }" class="bottom" style="width: 45px;">cm
								</td>
								<td style="text-align: left;padding-left: 10px;">
									体重：<input id="weight" type="text" name="preVisit.weight" value="${preVisit.weight }" class="bottom" style="width: 45px;">kg
								</td>
								<td style="text-align: left;padding-left: 10px;">
									病床号：<input type="text" name="bed" value="${sro.bed }" disabled="disabled" class="noboder" style="width: 85px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									住院号：<input type="text" name="hid" value="${sro.hid }" disabled="disabled" class="noboder" style="width: 85px;">
								</td>
							</tr>
							<tr class="bk">
								<td colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									术前诊断：<input type="text" name="diagnosisName" value="${sro.diagnosisName }" class="noboder" disabled="disabled" style="width: 285px;">
								</td>
								<td colspan="4" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									拟施手术：<input type="text" name="designedOptName" value="${sro.designedOptName }" class="noboder" disabled="disabled" style="width: 385px;">
								</td>
							</tr>
							<tr class="bk">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									主诉：<input id="complaint" type="text" name="preVisit.complaint"  value="${preVisit.complaint }" class="bottom" style="text-align: left;width: 485px;">
								</td>
							</tr>
							<tr class="bk">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									血压：<input id="BP1" type="text" name="BP1" value="${BP1 }" class="bottom" style="width: 20px;">/<input id="BP2" type="text" name="BP2" value="${BP2 }" class="bottom" style="width: 20px;">mmHg
				  &nbsp;&nbsp;&nbsp;心率：<input id="R" type="text" name="R" value="${R }" class="bottom" style="width: 20px;">次/分
				  &nbsp;&nbsp;&nbsp;呼吸：<input id="P" type="text" name="P" value="${P }" class="bottom" style="width: 20px;">次/分
				  &nbsp;&nbsp;&nbsp;温度：<input id="T" type="text" name="T" value="${T }" class="bottom" style="width: 20px;">℃
				  &nbsp;&nbsp;&nbsp;其他：<input id="elze" type="text" name="elze" value="${preVisit.spacialMonitoringOther }" class="bottom" size="5">
								</td>
							</tr>
						</table>	
						<table class="table table-bordered table-striped header-spcing" id="history">	
							<thead>
							<tr class="bj">
								<td colspan="2">
									系统情况
								</td>
								<td colspan="3">
									现在情况
								</td>
								<td colspan="2">
									过去或其他情况
								</td>
							</tr>
							</thead>
							<tr class="bk">
								<td>
									心血管：
									<input id="heartbool" type="hidden" value="${spVmh.heartbool }">
									<input id="heartboolDetail" type="hidden" value="${spVmh.heartboolDetail }">
									<input id="heartboolOther" type="hidden" value="${spVmh.heartboolOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.heartbool" value="无">无 <input type="radio" class="you" name="spVmh.heartbool" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.heartboolDetail" value="胸痛">&nbsp;胸痛&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.heartboolDetail" value="心悸">&nbsp;心悸&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.heartboolDetail" value="瓣膜病变">&nbsp;瓣膜病变&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.heartboolDetail" value="杂音">&nbsp;杂音&nbsp;&nbsp;&nbsp;&nbsp;
									<br/>
									<input type="checkbox" name="spVmh.heartboolDetail" value="高血压">&nbsp;高血压&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.heartboolDetail" value="心梗">&nbsp;心梗&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.heartboolDetail" value="易疲劳">&nbsp;易疲劳&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.heartboolDetail" value="气急">&nbsp;气急&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2">
									<textarea name="spVmh.heartboolOther" rows="4" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									肺和呼吸：
									<input id="lungbreath" type="hidden" value="${spVmh.lungbreath }">
									<input id="lungbreathDetail" type="hidden" value="${spVmh.lungbreathDetail }">
									<input id="lungbreathOther" type="hidden" value="${spVmh.lungbreathOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.lungbreath" value="无">无 <input type="radio" class="you" name="spVmh.lungbreath" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.lungbreathDetail" value="COPD">&nbsp;COPD&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.lungbreathDetail" value="肺炎">&nbsp;肺炎&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.lungbreathDetail" value="咳嗽">&nbsp;咳嗽&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.lungbreathDetail" value="咳痰">&nbsp;咳痰&nbsp;&nbsp;&nbsp;&nbsp;
									<br/>
									<input type="checkbox" name="spVmh.lungbreathDetail" value="气管炎">&nbsp;气管炎&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.lungbreathDetail" value="哮喘">&nbsp;哮喘&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.lungbreathDetail" value="皮质激素">&nbsp;皮质激素&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.lungbreathDetail" value="TB">&nbsp;TB&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2">
									<textarea name="spVmh.lungbreathOther" rows="4" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									泌尿生殖：
									<input id="urologyprocreate" type="hidden" value="${spVmh.urologyprocreate }">
									<input id="urologyprocreateDetail" type="hidden" value="${spVmh.urologyprocreateDetail }">
									<input id="urologyprocreateOther" type="hidden" value="${spVmh.urologyprocreateOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.urologyprocreate" value="无">无 <input type="radio" class="you" name="spVmh.urologyprocreate" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.urologyprocreateDetail" value="尿毒症">&nbsp;尿毒症&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.urologyprocreateDetail" value="血尿">&nbsp;血尿&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.urologyprocreateDetail" value="肾功不全">&nbsp;肾功不全&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.urologyprocreateDetail" value="月经">&nbsp;月经&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.urologyprocreateOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									消化：
									<input id="digest" type="hidden" value="${spVmh.digest }">
									<input id="digestDetail" type="hidden" value="${spVmh.digestDetail }">
									<input id="digestOther" type="hidden" value="${spVmh.digestOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.digest" value="无">无 <input type="radio" class="you" name="spVmh.digest" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.digestDetail" value="肝病">&nbsp;肝病&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.digestDetail" value="反流">&nbsp;反流&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.digestDetail" value="胃潴留">&nbsp;胃潴留&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.digestDetail" value="溃疡">&nbsp;溃疡&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.digestOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									神经肌肉：
									<input id="nevemuscle" type="hidden" value="${spVmh.nevemuscle }">
									<input id="nevemuscleDetail" type="hidden" value="${spVmh.nevemuscleDetail }">
									<input id="nevemuscleOther" type="hidden" value="${spVmh.nevemuscleOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.nevemuscle" value="无">无 <input type="radio" class="you" name="spVmh.nevemuscle" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.nevemuscleDetail" value="中风">&nbsp;中风&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.nevemuscleDetail" value="抽搐">&nbsp;抽搐&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.nevemuscleDetail" value="重症肌无力">&nbsp;重症肌无力&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.nevemuscleDetail" value="瘫痪">&nbsp;瘫痪&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.nevemuscleOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									血液：
									<input id="boold" type="hidden" value="${spVmh.boold }">
									<input id="booldDetail" type="hidden" value="${spVmh.booldDetail }">
									<input id="booldOther" type="hidden" value="${spVmh.booldOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.boold" value="无">无 <input type="radio" class="you" name="spVmh.boold" value="有">有
								</td>
								<td colspan="3">
									现在情况：<input type="text" name="spVmh.booldDetail" size="38">
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.booldOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									内分泌代谢：
									<input id="incretion" type="hidden" value="${spVmh.incretion }">
									<input id="incretionDetail" type="hidden" value="${spVmh.incretionDetail }">
									<input id="incretionOther" type="hidden" value="${spVmh.incretionOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.incretion" value="无">无 <input type="radio" class="you" name="spVmh.incretion" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.incretionDetail" value="糖尿病">&nbsp;糖尿病&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.incretionDetail" value="甲亢/低能">&nbsp;甲亢/低能&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.incretionDetail" value="胰岛素">&nbsp;胰岛素&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.incretionDetail" value="皮质">&nbsp;皮质&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.incretionOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									精神：
									<input id="spirit" type="hidden" value="${spVmh.spirit }">
									<input id="spiritDetail" type="hidden" value="${spVmh.spiritDetail }">
									<input id="spiritOther" type="hidden" value="${spVmh.spiritOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.spirit" value="无">无 <input type="radio" class="you" name="spVmh.spirit" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.spiritDetail" value="精神分裂症">&nbsp;精神分裂症&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.spiritDetail" value="抑郁症">&nbsp;抑郁症&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.spiritOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									产科：
									<input id="obstetrical" type="hidden" value="${spVmh.obstetrical }">
									<input id="obstetricalDetail" type="hidden" value="${spVmh.obstetricalDetail }">
									<input id="obstetricalOther" type="hidden" value="${spVmh.obstetricalOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.obstetrical" value="无">无 <input type="radio" class="you" name="spVmh.obstetrical" value="有">有
								</td>
								<td colspan="3">
									现在情况：<input type="text" name="spVmh.obstetricalDetail" size="38">
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.obstetricalOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									吸烟、嗜酒、药物依赖：
									<input id="smokecase" type="hidden" value="${spVmh.smokecase }">
									<input id="smokecaseDetail" type="hidden" value="${spVmh.smokecaseDetail }">
									<input id="smokecaseOther" type="hidden" value="${spVmh.smokecaseOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.smokecase" value="无">无 <input type="radio" class="you" name="spVmh.smokecase" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.smokecaseDetail" value="吸烟">&nbsp;吸烟&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.smokecaseDetail" value="戒烟">&nbsp;戒烟&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.smokecaseDetail" value="嗜酒">&nbsp;嗜酒&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.smokecaseDetail" value="药物依赖">&nbsp;药物依赖&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.smokecaseOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									过敏史、手术史：
									<input id="allergic" type="hidden" value="${spVmh.allergic }">
									<input id="allergicDetail" type="hidden" value="${spVmh.allergicDetail }">
									<input id="allergicOther" type="hidden" value="${spVmh.allergicOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.allergic" value="无">无 <input type="radio" class="you" name="spVmh.allergic" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.allergicDetail" value="药物过敏">&nbsp;药物过敏&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.allergicDetail" value="食物过敏">&nbsp;食物过敏&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.allergicDetail" value="手术">&nbsp;手术&nbsp;&nbsp;&nbsp;&nbsp;								
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.allergicOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									家族史、遗传疾病：
									<input id="hereditycase" type="hidden" value="${spVmh.hereditycase }">
									<input id="hereditycaseDetail" type="hidden" value="${spVmh.hereditycaseDetail }">
									<input id="hereditycaseOther" type="hidden" value="${spVmh.hereditycaseOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.hereditycase" value="无">无 <input type="radio" class="you" name="spVmh.hereditycase" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.hereditycaseDetail" value="麻醉药过敏">&nbsp;麻醉药过敏&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="spVmh.hereditycaseDetail" value="恶性高热">&nbsp;恶性高热&nbsp;&nbsp;&nbsp;&nbsp;								
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.hereditycaseOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									目前特殊药物：
									<input id="specialmedica" type="hidden" value="${spVmh.specialmedica }">
									<input id="specialmedicaDetail" type="hidden" value="${spVmh.specialmedicaDetail }">
									<input id="specialmedicaOther" type="hidden" value="${spVmh.specialmedicaOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.specialmedica" value="无">无 <input type="radio" class="you" name="spVmh.specialmedica" value="有">有
								</td>
								<td colspan="3">
									<input name="spVmh.specialmedicaDetail" type="text" size="40">
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.specialmedicaOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							<tr class="bk">
								<td>
									既往麻醉史：
									<input id="mainCase" type="hidden" value="${spVmh.mainCase }">
									<input id="mainCaseDetail" type="hidden" value="${spVmh.mainCaseDetail }">
									<input id="mainCaseOther" type="hidden" value="${spVmh.mainCaseOther }">
								</td>
								<td>
									<input type="radio" class="wu" name="spVmh.mainCase" value="无">无 <input type="radio" class="you" name="spVmh.mainCase" value="有">有
								</td>
								<td colspan="3" style="vertical-align: middle;">
									<input type="checkbox" name="spVmh.mainCaseDetail" value="插管困难">&nbsp;插管困难&nbsp;&nbsp;&nbsp;&nbsp;		
									<input type="checkbox" name="spVmh.mainCaseDetail" value="麻醉药过敏">&nbsp;麻醉药过敏&nbsp;&nbsp;&nbsp;&nbsp;						
								</td>
								<td colspan="2" style="vertical-align: middle;">
									<textarea name="spVmh.mainCaseOther" rows="1" cols="50" style="resize: none;"></textarea>
								</td>
							</tr>
							</tbody>
						</table>
						<table class="table table-bordered table-striped header-spcing">
							<tbody>
							<tr class="No">
							    <td>项 目</td>	
								<td>Hb / HCT</td>	
								<td>WBC</td>						
								<td>PLT</td>	
								<td>K+</td>
								<td>Na+</td>
								<td>Cl-</td>
								<td>GLU</td>
								<td>SGPT</td>
								<td>BUN</td>
								<td>Cr</td>
								<td>PT</td>
								<td>APTT</td>
								<td>PaO2</td>
							</tr>
							<tr class="No">
								<td><button type="button" id="loadPId" class="button_blue_74_33"  style="border: medium none;" onclick="loadP()">加载</button></td>	
								<td><input type="text" id="hbId"     disabled="disabled" value="${sprd.hb}" style="width: 30px;text-align: center;">/<input type="text" id="hctId"  disabled="disabled" value="${sprd.hct}" style="width: 30px;text-align: center;"></td>	
								<td><input type="text" id="wbcId"    disabled="disabled" value="${sprd.wbc}" style="width: 40px;text-align: center;"></td>							
								<td><input type="text" id="pltId"    disabled="disabled" value="${sprd.plt}" style="width: 40px;text-align: center;"></td>		
								<td><input type="text" id="kJiaId"   disabled="disabled" value="${sprd.KPlus}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="naJiaId"  disabled="disabled" value="${sprd.naPlus}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="clJianId" disabled="disabled" value="${sprd.clReduce}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="gluId"    disabled="disabled" value="${sprd.glu}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="sgptId"   disabled="disabled" value="${sprd.sgpt}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="bunId"    disabled="disabled" value="${sprd.bun}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="crId"     disabled="disabled" value="${sprd.cr}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="ptId"     disabled="disabled" value="${sprd.pt}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="apttId"   disabled="disabled" value="${sprd.aptt}" style="width: 40px;text-align: center;"></td>	
								<td><input type="text" id="paO2Id"   disabled="disabled" value="${sprd.pao2}" style="width: 40px;text-align: center;"></td>	
							</tr>
							<tr class="No">
								<td>单 位</td>	
								<td>g / L</td>	
								<td>10＾9/L</td>						
								<td>10＾9/L</td>	
								<td>mmol/L</td>
								<td>mmol/L</td>
								<td>mmol/L</td>
								<td>mmol/L</td>
								<td>lU/dl</td>
								<td>mmol/L</td>
								<td>umol/L</td>
								<td>s</td>
								<td>s</td>
								<td>mmHg</td>
							</tr>
							</tbody>
						</table>
						<table class="table table-bordered table-striped header-spcing">	
							<thead>
							<tr class="bj">
								<td colspan="7" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								总体评估
								</td>
							</tr>
							</thead>
							<tr class="bk">
								<td style="text-align: left;padding-left: 10px;vertical-align: middle;">
								ASA分级：<input id="asa" name="preVisit.ASA" value="${preVisit.ASA }" style="background-color: white;width: 50px;" readonly="readonly" type="text"> <a href="javascript:void(0);" onclick="chooseASA()">分级</a></td>
								<td style="text-align: left;padding-left: 10px;vertical-align: middle;">
								<input type="hidden" value="${preVisit.fullStomach }" id="stomach">
								是否饱胃：<input id="yesf" type="radio" name="preVisit.fullStomach" value="是">是 <input id="nof" type="radio" name="preVisit.fullStomach" value="否">否</td>
								
							</tr>
							<tr class="bk">
								<td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								可能存在的问题和建议：<input id="disposal" type="text" name="preVisit.disposal" value="${preVisit.disposal }" class="bottom" style="text-align: left;width: 385px;"></td>
							</tr>
							<tr class="bk">
								<td style="text-align: left;padding-left: 10px;vertical-align: middle;">
								上次操作人：<input type="text" size="10" readonly="readonly" value="${preVisit.aneasdoctor }"></td>
								<td style="text-align: left;padding-left: 10px;vertical-align: middle;">
								上次操作时间：<input type="text" size="10" readonly="readonly" value="${preVisit.visitdate }"></td>
							</tr>
							<tr class="bk">
								<td style="text-align: left;padding-left: 10px;vertical-align: middle;">
								术前评估麻醉医师：<select name="preVisit.aneasdoctor">
												<option value="${op.name }">${op.name }</option>
											</select> 
								</td>
								<td style="text-align: left;padding-left: 10px;vertical-align: middle;">
								评估日期：
								<input id="visitDate" size="22" class="Wdate" readonly="readonly" name="visitDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
							</tr>
							</tbody>
						</table>
						</form>
						<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveTemplateTo()">存为模板</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveP()">保存</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="commitP()">确定</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="printP()">打印</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
							</div>
					</div>
				</div>
			</div>
<br><br>
</body>
</html>
