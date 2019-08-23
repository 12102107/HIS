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
<title>手术护理</title>
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
function printN() {
	Report.LoadFromURL("../jsp/sm/optNurse/optNurse.grf");
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
	
	$(".xllZd").attr("selected", true);
	$(".xllSs").attr("selected", true);
	$(".xllSz").attr("selected", true);
	$(".xllZs").attr("selected", true);
	$(".xllTz").attr("selected", true);
	$(".xllMz").attr("selected", true);
	$(".xllXh").attr("selected", true);
	$(".xllQx").attr("selected", true);
	
	$.post("saveOptNurseTemplate.action",$("#nurse").serialize(),function(){
		alert('保存成功！');
		$(".xllZd").attr("selected", false);
		$(".xllSs").attr("selected", false);
		$(".xllSz").attr("selected", false);
		$(".xllZs").attr("selected", false);
		$(".xllTz").attr("selected", false);
		$(".xllMz").attr("selected", false);
		$(".xllXh").attr("selected", false);
		$(".xllQx").attr("selected", false);
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
	$('.mzfs').attr('checked',false);
	$('.tw').attr('checked',false);
	$(".xllZd").each(function(){
		$("#yuanshiZd").append("<option class=\"xlZd\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	$(".xllSs").each(function(){
		$("#yuanshiSs").append("<option class=\"xlSs\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	
	$(".xllSz").each(function(){
		$("#yuanshiSz").append("<option class=\"xlSz\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	$(".xllQx").each(function(){
		$("#yuanshiQx").append("<option class=\"xlQx\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	$(".xllMz").each(function(){
		$("#yuanshiMz").append("<option class=\"xlMz\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	$(".xllTz").each(function(){
		$("#yuanshiTz").append("<option class=\"xlTz\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	$(".xllZs").each(function(){
		$("#yuanshiZs").append("<option class=\"xlZs\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	$(".xllXh").each(function(){
		$("#yuanshiXh").append("<option class=\"xlXh\" value=\""+ $(this).val() + "\">"+ $(this).html() + "</option>");
		$(this).remove();
	});
	
	$.post("getTemplateVal.action",{templateId:id},function(data){
		$('#assayJerque').val(data[0].assayJerque);
		$('.woundSort').each(function(){
			if($(this).val()==data[0].woundSort) {
				$(this).click();
			}
		});
		$('#getin').val(data[0].insurgeryTime);
		$('#begin').val(data[0].startTime);
		$('#end').val(data[0].endTime);
		$('#getout').val(data[0].outroomTime);
		
		$("#latterDiag").val(data[0].latterDiag);
		$("#realOper").val(data[0].realOper);
		
		$("#anaesMode").val(data[0].anaesMode);
		
		$("#operator").val(data[0].operator);
		$("#assistor").val(data[0].assistor);
		$("#coach").val(data[0].coach);
		$("#anaesthetist").val(data[0].anaesthetist);
		$("#instrnurse").val(data[0].instrnurse);
		$("#circunurse").val(data[0].circunurse);
		
		$("#operBodyPos").val(data[0].operBodyPos);
		
		$('.beforeSkin').each(function(){
			if($(this).val()==data[0].beforeSkin) {
				$(this).click();
			}
		});
		$('.beforeSore').each(function(){
			if($(this).val()==data[0].beforeSore) {
				$(this).click();
			}
		});
		$('.afterSkin').each(function(){
			if($(this).val()==data[0].afterSkin) {
				$(this).click();
			}
		});
		$('.afterSore').each(function(){
			if($(this).val()==data[0].afterSore) {
				$(this).click();
			}
		});
		
		$("#burn").val(data[0].burn);
		$("#remark").val(data[0].remark);
		
		$('.disinfectMark').each(function(){
			if($(this).val()==data[0].disinfectMark) {
				$(this).click();
			}
		});
		
		$("#stopbleedingvalue").val(data[0].stopbleedingvalue);
		
		$("#bloodstart").val(data[0].stopbleedingBegintime);
		$("#bloodend").val(data[0].stopbleedingEndtime);
		
		$('.safetybelt').each(function(){
			if($(this).val()==data[0].safetybelt) {
				$(this).click();
			}
		});

		$('.implant').each(function(){
			if($(this).val()==data[0].implant) {
				$(this).click();
			}
		});
		
		$('.operAfterGoto').each(function(){
			if($(this).val()==data[0].operAfterGoto) {
				$(this).click();
			}
		});
		
		$('.shadow').each(function(){
			if($(this).val()==data[0].shadow) {
				$(this).click();
			}
		});
		
		$('#count').val(data[0].count);
		
		$('.casehistory').each(function(){
			if($(this).val()==data[0].casehistory) {
				$(this).click();
			}
		});
		
		$('#valuables').val(data[0].valuables);
		
		setNurseVal();
		
		$('#nurse .0 input').eq(0).val(data[1].anaes0TIME);
		$('#nurse .0 input').eq(1).val(data[1].anaes0DIASTOLIC_PRESSURE);
		$('#nurse .0 input').eq(2).val(data[1].anaes0SYSTOLIC_PRESSURE);
		$('#nurse .0 input').eq(3).val(data[1].anaes0R);
		$('#nurse .0 input').eq(4).val(data[1].anaes0P);
		$('#nurse .0 input').eq(5).val(data[1].anaes0SPO2);
		
		$('#nurse .1 input').eq(0).val(data[1].anaes1TIME);
		$('#nurse .1 input').eq(1).val(data[1].anaes1DIASTOLIC_PRESSURE);
		$('#nurse .1 input').eq(2).val(data[1].anaes1SYSTOLIC_PRESSURE);
		$('#nurse .1 input').eq(3).val(data[1].anaes1R);
		$('#nurse .1 input').eq(4).val(data[1].anaes1P);
		$('#nurse .1 input').eq(5).val(data[1].anaes1SPO2);
		
		$('#nurse .2 input').eq(0).val(data[1].anaes2TIME);
		$('#nurse .2 input').eq(1).val(data[1].anaes2DIASTOLIC_PRESSURE);
		$('#nurse .2 input').eq(2).val(data[1].anaes2SYSTOLIC_PRESSURE);
		$('#nurse .2 input').eq(3).val(data[1].anaes2R);
		$('#nurse .2 input').eq(4).val(data[1].anaes2P);
		$('#nurse .2 input').eq(5).val(data[1].anaes2SPO2);
	
		$('#nurse .3 input').eq(0).val(data[1].anaes3TIME);
		$('#nurse .3 input').eq(1).val(data[1].anaes3DIASTOLIC_PRESSURE);
		$('#nurse .3 input').eq(2).val(data[1].anaes3SYSTOLIC_PRESSURE);
		$('#nurse .3 input').eq(3).val(data[1].anaes3R);
		$('#nurse .3 input').eq(4).val(data[1].anaes3P);
		$('#nurse .3 input').eq(5).val(data[1].anaes3SPO2);
		
		$('#nurse .4 input').eq(0).val(data[1].anaes4TIME);
		$('#nurse .4 input').eq(1).val(data[1].anaes4DIASTOLIC_PRESSURE);
		$('#nurse .4 input').eq(2).val(data[1].anaes4SYSTOLIC_PRESSURE);
		$('#nurse .4 input').eq(3).val(data[1].anaes4R);
		$('#nurse .4 input').eq(4).val(data[1].anaes4P);
		$('#nurse .4 input').eq(5).val(data[1].anaes4SPO2);
		
	},'json');
}
	function addZd() {
		if ($(".xlZd:selected").val() != null) {
			$("#jieguoZd").append(
					"<option class=\"xllZd\" value=\"" + $(".xlZd:selected").val()
							+ "\">" + $(".xlZd:selected").html() + "</option>");
			$(".xlZd:selected").remove();
			
		}
		
	}
	function delZd() {
		if ($(".xllZd:selected").val() != null) {
			for ( var i = 0; i < $(".xllZd:selected").length; i++) {
				$("#yuanshiZd")
						.append(
								"<option class=\"xlZd\" value=\""
										+ $(".xllZd:selected")[i].value + "\">"
										+ $(".xllZd:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllZd:selected").remove();
			
		}
	}
	
	function addSs() {
		if ($(".xlSs:selected").val() != null) {
			$("#jieguoSs").append(
					"<option class=\"xllSs\" value=\"" + $(".xlSs:selected").val()
							+ "\">" + $(".xlSs:selected").html() + "</option>");
			$(".xlSs:selected").remove();
			
		}
		
	}
	function delSs() {
		if ($(".xllSs:selected").val() != null) {
			for ( var i = 0; i < $(".xllSs:selected").length; i++) {
				$("#yuanshiSs")
						.append(
								"<option class=\"xlSs\" value=\""
										+ $(".xllSs:selected")[i].value + "\">"
										+ $(".xllSs:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllSs:selected").remove();
			
		}
	}
	
	function addSz() {
		if ($(".xlSz:selected").val() != null) {
			$("#jieguoSz").append(
					"<option class=\"xllSz\" value=\"" + $(".xlSz:selected").val()
							+ "\">" + $(".xlSz:selected").html() + "</option>");
			$(".xlSz:selected").remove();
			
		}
		
	}
	function delSz() {
		if ($(".xllSz:selected").val() != null) {
			for ( var i = 0; i < $(".xllSz:selected").length; i++) {
				$("#yuanshiSz")
						.append(
								"<option class=\"xlSz\" value=\""
										+ $(".xllSz:selected")[i].value + "\">"
										+ $(".xllSz:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllSz:selected").remove();
			
		}
	}
	
	function addZs() {
		if ($(".xlZs:selected").val() != null) {
			$("#jieguoZs").append(
					"<option class=\"xllZs\" value=\"" + $(".xlZs:selected").val()
							+ "\">" + $(".xlZs:selected").html() + "</option>");
			$(".xlZs:selected").remove();
			
		}
		
	}
	function delZs() {
		if ($(".xllZs:selected").val() != null) {
			for ( var i = 0; i < $(".xllZs:selected").length; i++) {
				$("#yuanshiZs")
						.append(
								"<option class=\"xlZs\" value=\""
										+ $(".xllZs:selected")[i].value + "\">"
										+ $(".xllZs:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllZs:selected").remove();
			
		}
	}
	
	function addTz() {
		if ($(".xlTz:selected").val() != null) {
			$("#jieguoTz").append(
					"<option class=\"xllTz\" value=\"" + $(".xlTz:selected").val()
							+ "\">" + $(".xlTz:selected").html() + "</option>");
			$(".xlTz:selected").remove();
			
		}
		
	}
	function delTz() {
		if ($(".xllTz:selected").val() != null) {
			for ( var i = 0; i < $(".xllTz:selected").length; i++) {
				$("#yuanshiTz")
						.append(
								"<option class=\"xlTz\" value=\""
										+ $(".xllTz:selected")[i].value + "\">"
										+ $(".xllTz:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllTz:selected").remove();
			
		}
	}
	
	function addMz() {
		if ($(".xlMz:selected").val() != null) {
			$("#jieguoMz").append(
 					"<option class=\"xllMz\" value=\"" + $(".xlMz:selected").val()
							+ "\">" + $(".xlMz:selected").html() + "</option>");
			$(".xlMz:selected").remove();
			
		}
		
	}
	function delMz() {
		if ($(".xllMz:selected").val() != null) {
			for ( var i = 0; i < $(".xllMz:selected").length; i++) {
				$("#yuanshiMz")
						.append(
								"<option class=\"xlMz\" value=\""
										+ $(".xllMz:selected")[i].value + "\">"
 										+ $(".xllMz:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllMz:selected").remove();
			
		}
	}
	
	function addQx() {
		if ($(".xlQx:selected").val() != null) {
			$("#jieguoQx").append(
 					"<option class=\"xllQx\" value=\"" + $(".xlQx:selected").val()
							+ "\">" + $(".xlQx:selected").html() + "</option>");
			$(".xlQx:selected").remove();
			
		}
		
	}
	function delQx() {
		if ($(".xllQx:selected").val() != null) {
			for ( var i = 0; i < $(".xllQx:selected").length; i++) {
				$("#yuanshiQx")
						.append(
								"<option class=\"xlQx\" value=\""
										+ $(".xllQx:selected")[i].value + "\">"
 										+ $(".xllQx:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllQx:selected").remove();
			
		}
	}
	
	function addXh() {
		if ($(".xlXh:selected").val() != null) {
			$("#jieguoXh").append(
 					"<option class=\"xllXh\" value=\"" + $(".xlXh:selected").val()
							+ "\">" + $(".xlXh:selected").html() + "</option>");
			$(".xlXh:selected").remove();
			
		}
		
	}
	function delXh() {
		if ($(".xllXh:selected").val() != null) {
			for ( var i = 0; i < $(".xllXh:selected").length; i++) {
				$("#yuanshiXh")
						.append(
								"<option class=\"xlXh\" value=\""
										+ $(".xllXh:selected")[i].value + "\">"
 										+ $(".xllXh:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xllXh:selected").remove();
			
		}
	}
	
	function getSopVague(obj) {
		var s = $(obj).parent().next().find("select:first");
		$.post("getSopVague.action",{word:$(obj).val()},function(data){
			$(s).empty();
			var str = "";
			for(var i=0;i<data.length;i++) {
				str += "<option value='"+data[i].name+"'>"+data[i].name+"</option>";
			}
			$(s).append(str);
		},'json');
	}
	
	
	
	function saveNurse() {
		$(".xllZd").attr("selected", true);
		$(".xllSs").attr("selected", true);
		$(".xllSz").attr("selected", true);
		$(".xllZs").attr("selected", true);
		$(".xllTz").attr("selected", true);
		$(".xllMz").attr("selected", true);
		$(".xllXh").attr("selected", true);
		$(".xllQx").attr("selected", true);
		
		$.post("saveOptNurse.action",$("#nurse").serialize(),function(){
			alert('暂存成功！');
			$(".xllZd").attr("selected", false);
			$(".xllSs").attr("selected", false);
			$(".xllSz").attr("selected", false);
			$(".xllZs").attr("selected", false);
			$(".xllTz").attr("selected", false);
			$(".xllMz").attr("selected", false);
			$(".xllXh").attr("selected", false);
			$(".xllQx").attr("selected", false);
		});
		
	}
	
	function commitNurse() {
		$(".xllZd").attr("selected", true);
		$(".xllSs").attr("selected", true);
		$(".xllSz").attr("selected", true);
		$(".xllZs").attr("selected", true);
		$(".xllTz").attr("selected", true);
		$(".xllMz").attr("selected", true);
		$(".xllXh").attr("selected", true);
		$(".xllQx").attr("selected", true);
		
		$.post("commitOptNurse.action",$("#nurse").serialize(),function(){
			alert('提交成功！');
			$(".xllZd").attr("selected", false);
			$(".xllSs").attr("selected", false);
			$(".xllSz").attr("selected", false);
			$(".xllZs").attr("selected", false);
			$(".xllTz").attr("selected", false);
			$(".xllMz").attr("selected", false);
			$(".xllXh").attr("selected", false);
			$(".xllQx").attr("selected", false);
			$('input').attr('disabled',true);
			$('select').attr('disabled',true);
			$('#backn').attr('disabled',false);	
			$('#printn').attr('disabled',false);	
		});
	}
	
	function back() {
		window.location.href="../ylws/ylwsList.action?functionid="+$('#functionid').val();
	}
	
	$(function(){
		
		setNurseVal();
		
		if($('#status').val()=="1") {
			$('input').attr('disabled',true);
			$('select').attr('disabled',true);
			$('#backn').attr('disabled',false);	
			$('#printn').attr('disabled',false);
		}
	});

	function setNurseVal() {
	
		if($("#latterDiag").val()!="") {
			var latterDiag = $("#latterDiag").val().trim();
			var zd = latterDiag.split(', ');
			for(var i=0;i<zd.length;i++) {
				$(".xlZd[value='"+zd[i]+"']").remove();
				$("#jieguoZd").append("<option class=\"xllZd\" value=\"" + zd[i]
								+ "\">" + zd[i] + "</option>");
			}
		}
		
		if($("#realOper").val()!="") {
			var realOper = $("#realOper").val().trim();
			var ss = realOper.split(', ');
			for(var i=0;i<ss.length;i++) {
				$(".xlSs[value='"+ss[i]+"']").remove();
				$("#jieguoSs").append("<option class=\"xllSs\" value=\"" + ss[i]
								+ "\">" + ss[i] + "</option>");
			}
		}
		
		if($("#operator").val()!="") {
			var operator = $("#operator").val().trim();
			var sz = operator.split(', ');
			for(var i=0;i<sz.length;i++) {
				$(".xlSz[value='"+sz[i]+"']").remove();
				$("#jieguoSz").append("<option class=\"xllSz\" value=\"" + sz[i]
								+ "\">" + sz[i] + "</option>");
			}
		}
		
		if($("#assistor").val()!="") {
			var assistor = $("#assistor").val().trim();
			var zs = assistor.split(', ');
			for(var i=0;i<zs.length;i++) {
				$(".xlZs[value='"+zs[i]+"']").remove();
				$("#jieguoZs").append("<option class=\"xllZs\" value=\"" + zs[i]
								+ "\">" + zs[i] + "</option>");
			}
		}
		
		if($("#coach").val()!="") {
			var coach = $("#coach").val().trim();
			var tz = coach.split(', ');
			for(var i=0;i<tz.length;i++) {
				$(".xlTz[value='"+tz[i]+"']").remove();
				$("#jieguoTz").append("<option class=\"xllTz\" value=\"" + tz[i]
								+ "\">" + tz[i] + "</option>");
			}
		}
		
		if($("#anaesthetist").val()!="") {
			var anaesthetist = $("#anaesthetist").val().trim();
			var mz = anaesthetist.split(', ');
			for(var i=0;i<mz.length;i++) {
				$(".xlMz[value='"+mz[i]+"']").remove();
				$("#jieguoMz").append("<option class=\"xllMz\" value=\"" + mz[i]
							+ "\">" + mz[i] + "</option>");
			}
		}
		
		if($("#instrnurse").val()!="") {
			var instrnurse = $("#instrnurse").val().trim();
			var qx = instrnurse.split(', ');
			for(var i=0;i<qx.length;i++) {
				$(".xlQx[value='"+qx[i]+"']").remove();
				$("#jieguoQx").append("<option class=\"xllQx\" value=\"" + qx[i]
								+ "\">" + qx[i] + "</option>");
			}
		}
		
		if($("#circunurse").val()!="") {
			var circunurse = $("#circunurse").val().trim();
			var xh = circunurse.split(', ');
			for(var i=0;i<xh.length;i++) {
				$(".xlXh[value='"+xh[i]+"']").remove();
				$("#jieguoXh").append("<option class=\"xllXh\" value=\"" + xh[i]
								+ "\">" + xh[i] + "</option>");
			}
		}
		
		
		var operBodyPos = $("#operBodyPos").val().trim();
		var tw = operBodyPos.split(', ');
		for(var i=0;i<tw.length;i++) {
			$(".tw[value='"+tw[i]+"']").attr('checked',true);
		}
		
		var anaesMode = $("#anaesMode").val().trim();
		var mzfs = anaesMode.split(', ');
		for(var i=0;i<mzfs.length;i++) {
			$(".mzfs[value='"+mzfs[i]+"']").attr('checked',true);
		}
	}
 
	function chooselr(obj) {
		if($(obj).val()=="侧卧位左"||$(obj).val()=="侧卧位右") {
			if($(obj).attr('checked')) {
				$(".tw[value='侧卧位']").attr('checked',true);
			} else {
				$(".tw[value='侧卧位']").attr('checked',false);
			}
		}
		if($(obj).val()=="侧俯卧位左"||$(obj).val()=="侧俯卧位右") {
			if($(obj).attr('checked')) {
				$(".tw[value='侧俯卧位']").attr('checked',true);
			} else {
				$(".tw[value='侧俯卧位']").attr('checked',false);
			}
		}
	}
	function countIn() {
		$("#shadow").click();
	}
</script>
<style type="text/css">
/* .bottom {
 border-left: 0;
 border-right: 0;
 border-top: 0;
 border-bottom: 1px solid #000000;
 text-align: center;
 background-color: white;
}*/
.noboder {
 border-left: 0;
 border-right: 0;
 border-top: 0;
 border-bottom: 0;
 background-color: white;
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
			<font class="pull-left">手术护理</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choseTemplate()">读取模板</button>

						<!-- 下面显示列表内容 -->
						<input type="hidden" id="status" value="${nurse.status }">
						<form id="nurse">
						<input type="hidden" name="nurse.id" value="${nurse.id }">
						<input type="hidden" id="ylws" name="nurse.operationId" value="${ylwsid }">
						
						<input type="hidden" name="templateType" id="templateType">
						<input type="hidden" name="templateName" id="templateName">
						
						<table class="table table-bordered table-striped header-spcing">	
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								基本信息
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									姓名：<input type="text" name="name" value="${sro.name }" disabled="disabled" class="noboder" size="8">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									年龄：<input type="text" name="age" value="${sro.age }岁" disabled="disabled" class="noboder" size="8">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									姓别： <input type="radio" name="sex" disabled="disabled" <c:if test="${sro.sex eq 0 }">checked</c:if>>男 
										<input type="radio" name="sex" disabled="disabled" <c:if test="${sro.sex eq 1 }">checked</c:if>>女
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									科室：<input type="text" name="hid" value="${sro.dept }" disabled="disabled" class="noboder" size="8">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									手术室：<input type="text" name="hid" value="${sro.room }" disabled="disabled" class="noboder" size="10">
								</td>
							</tr>
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									手术类别：<c:if test="${sro.type eq 0 }">急诊手术</c:if>
											<c:if test="${sro.type eq 1 }">择期手术</c:if>
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									化验检查：<input id="assayJerque" type="text" name="nurse.assayJerque" size="20" value="${nurse.assayJerque }">
								</td>
							</tr>
							<tr class="No" >
								<td  colspan="3"  style="text-align: left;padding-left: 10px;vertical-align: middle;">
								伤口分类
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;">
									<input class="woundSort" type="radio" name="nurse.woundSort" value="清洁伤口" <c:if test="${nurse.woundSort eq '清洁伤口' }">checked</c:if>> 清洁伤口&nbsp;
									<input class="woundSort" type="radio" name="nurse.woundSort" value="可染伤口" <c:if test="${nurse.woundSort eq '可染伤口' }">checked</c:if>> 可染伤口&nbsp;
									<input class="woundSort" type="radio" name="nurse.woundSort" value="污染伤口" <c:if test="${nurse.woundSort eq '污染伤口' }">checked</c:if>> 污染伤口&nbsp;
									<input class="woundSort" type="radio" name="nurse.woundSort" value="开放伤口" <c:if test="${nurse.woundSort eq '开放伤口' }">checked</c:if>> 开放伤口&nbsp;
								</td>
							</tr>
							<tr class="No" >
								<td  colspan="3"  style="text-align: left;padding-left: 10px;vertical-align: middle;">
								时间
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									入室时间：
									<input id="getin" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${nurse.insurgeryTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="nurse.insurgeryTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'begin\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									手术开始时间：
									<input id="begin" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${nurse.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="nurse.startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'getin\')}',maxDate:'#F{$dp.$D(\'end\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									手术结束时间：
									<input id="end" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${nurse.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="nurse.endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'begin\')}',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
									送出手术室时间：
									<input id="getout" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${nurse.outroomTime }" pattern="yyyy-MM-dd HH:mm:ss"/>'  name="nurse.outroomTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'end\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">	
								
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								诊断
								</td>
							</tr>
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									术前诊断：${sro.diagnosisName}
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									术后诊断：
									<div>

									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshiZd" style="width: 50%;">
											<c:forEach items="${diagnosedefList }" var="sop" varStatus="status">
												<option class="xlZd" value="${sop.name }" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addZd()"><br><input
											   type="button" value="←" onclick="delZd()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoZd" name="nurse.latterDiag"
											multiple="multiple"></select>
										<input type="hidden" id="latterDiag" value="${nurse.latterDiag}"/>
									</div>
								</div>
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								手术
								</td>
							</tr>
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									拟施手术：${sro.designedOptName}
								</td>
								<td  colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									已施手术：
									<div style="float: left;">

									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshiSs" style="width: 50%;">
											<c:forEach items="${designedOptNameList}" var="sop" varStatus="status">
												<option class="xlSs" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addSs()"><br><input
											   type="button" value="←" onclick="delSs()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoSs" name="nurse.realOper"
											multiple="multiple"></select>
												<input type="hidden" id="realOper"  value="${nurse.realOper}"/>
									</div>
								</div>
								</td>
							</tr>
							
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								麻醉方式
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									<input class="mzfs" type="checkbox" name="nurse.anaesMode" value="全麻"> 全麻&nbsp;
									<input class="mzfs" type="checkbox" name="nurse.anaesMode" value="局麻"> 局麻&nbsp;
									<input class="mzfs" type="checkbox" name="nurse.anaesMode" value="神经阻断麻醉"> 神经阻断麻醉&nbsp;
									<input class="mzfs" type="checkbox" name="nurse.anaesMode" value="腰麻"> 腰麻&nbsp;
									<input class="mzfs" type="checkbox" name="nurse.anaesMode" value="硬膜外麻醉"> 硬膜外麻醉&nbsp;
									<input class="mzfs" type="checkbox" name="nurse.anaesMode" value="其他"> 其他&nbsp;
									<input type="hidden" id="anaesMode"  value="${nurse.anaesMode}"/>
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								手术成员
								</td>
							</tr>
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									术者：
									<div style="float: left;">
									<div  style="float:left;">
										<input style="width: 50px;" type="text" onkeyup="getSopVague(this)" >
									</div>
									<div style="float: left;width:250px;margin-left:0px">
										<select id="yuanshiSz" style="width: 50%;">
											<c:forEach items="${sopList}" var="sop" varStatus="status">
												<option class="xlSz" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-120px ">
										<input  type="button" value="→" onclick="addSz()"><br><input
											   type="button" value="←" onclick="delSz()">
											   
									</div>

									<div style="float: left;width:250px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoSz" name="nurse.operator"
											multiple="multiple"></select>
											<input type="hidden" id="operator"  value="${nurse.operator}"/>
									</div>
								</div>
								</td>
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									助手：
									<div >
									<div  style="float:left;">
										<input style="width: 50px;" type="text" onkeyup="getSopVague(this)" >
									</div>
									<div  style="float: left;width:250px;margin-left:0px">
										<select id="yuanshiZs" style="width: 50%;">
											<c:forEach items="${sopList}" var="sop" varStatus="status">
												<option class="xlZs" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-120px ">
										<input  type="button" value="→" onclick="addZs()"><br><input
											   type="button" value="←" onclick="delZs()">
											   
									</div>

									<div style="float: left;width:250px;margin-left:-83px; ">
										<select size="5" style="width: 50%;" id="jieguoZs" name="nurse.assistor"
											multiple="multiple"></select>
											<input type="hidden" id="assistor"  value="${nurse.assistor}"/>
									</div>
								</div>
								</td>
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									台下指导：
									<div >
									<div  style="float:left;">
										<input style="width: 50px;" type="text" onkeyup="getSopVague(this)" >
									</div>
									<div  style="float: left;width:250px;margin-left:0px">
										<select id="yuanshiTz" style="width: 50%;">
											<c:forEach items="${sopList}" var="sop" varStatus="status">
												<option class="xlTz" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-120px ">
										<input  type="button" value="→" onclick="addTz()"><br><input
											   type="button" value="←" onclick="delTz()">
											   
									</div>

									<div style="float: left;width:250px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoTz" name="nurse.coach" 
											multiple="multiple"></select>
											<input type="hidden" id="coach" value="${nurse.coach}"/>
									</div>
								</div>
								</td>
								</tr>
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									麻醉师：
									<div style="float: left;">

									<div  style="float: left;width:250px;margin-left:30px">
										<select id="yuanshiMz" style="width: 50%;">
											<c:forEach items="${mzList}" var="sop" varStatus="status">
												<option class="xlMz" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-120px ">
										<input  type="button" value="→" onclick="addMz()"><br><input
											   type="button" value="←" onclick="delMz()">
											   
									</div>

									<div style="float: left;width:250px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoMz" name="nurse.anaesthetist"
											multiple="multiple"></select>
											<input type="hidden" id="anaesthetist" value="${nurse.anaesthetist}"/>
									</div>
								</div>
								</td>
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									器械护士：
									<div >

									<div  style="float: left;width:250px;margin-left:30px">
										<select id="yuanshiQx" style="width: 50%;">
											<c:forEach items="${qxList}" var="sop" varStatus="status">
												<option class="xlQx" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-120px ">
										<input  type="button" value="→" onclick="addQx()"><br><input
											   type="button" value="←" onclick="delQx()">
											   
									</div>

									<div style="float: left;width:250px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoQx" name="nurse.instrnurse"
											multiple="multiple"></select>
											<input type="hidden" id="instrnurse"  value="${nurse.instrnurse}"/>
									</div>
								</div>
								</td>
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									巡回护士：
									<div style="float: left;">

									<div  style="float: left;width:250px;margin-left:30px">
										<select id="yuanshiXh" style="width: 50%;">
											<c:forEach items="${xhList}" var="sop" varStatus="status">
												<option class="xlXh" value="${sop.name}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-120px ">
										<input  type="button" value="→" onclick="addXh()"><br><input
											   type="button" value="←" onclick="delXh()">
											   
									</div>

									<div style="float: left;width:250px;margin-left:-80px; ">
										<select size="5" style="width: 50%;" id="jieguoXh" name="nurse.circunurse"
											multiple="multiple"></select>
											<input type="hidden" id="circunurse"  value="${nurse.circunurse}"/>
									</div>
								</div>
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								手术体位
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="仰卧"> 仰卧&nbsp;
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="侧卧位"> 侧卧位&nbsp;（<input class="tw" type="checkbox" name="nurse.operBodyPos" value="侧卧位左" onclick="chooselr(this)"> 左&nbsp;<input class="tw" type="checkbox" name="nurse.operBodyPos" value="侧卧位右" onclick="chooselr(this)"> 右&nbsp;）
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="截石位"> 截石位&nbsp;
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="垂头仰卧"> 垂头仰卧&nbsp;
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="坐式"> 坐式&nbsp;
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="侧俯卧位"> 侧俯卧位&nbsp;（<input class="tw" type="checkbox" name="nurse.operBodyPos" value="侧俯卧位左" onclick="chooselr(this)"> 左&nbsp;<input class="tw" type="checkbox" name="nurse.operBodyPos" value="侧俯卧位右" onclick="chooselr(this)"> 右&nbsp;）
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="俯卧位"> 俯卧位&nbsp;
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="半卧位"> 半卧位&nbsp;
									<input class="tw" type="checkbox" name="nurse.operBodyPos" value="其他"> 其他&nbsp;
									<input type="hidden" id="operBodyPos"  value="${nurse.operBodyPos}"/>
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								皮肤
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									术前病人皮肤：
									<input class="beforeSkin" type="radio" name="nurse.beforeSkin" value="洁" <c:if test="${nurse.beforeSkin eq '洁'}">checked</c:if>> 洁&nbsp;
									<input class="beforeSkin" type="radio" name="nurse.beforeSkin" value="不洁" <c:if test="${nurse.beforeSkin eq '不洁' }">checked</c:if>> 不洁&nbsp;
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									压疮：
									<input class="beforeSore" type="radio" name="nurse.beforeSore" value="无" <c:if test="${nurse.beforeSore eq '无' }">checked</c:if>> 无&nbsp;
									<input class="beforeSore" type="radio" name="nurse.beforeSore" value="有" <c:if test="${nurse.beforeSore eq '有' }">checked</c:if>> 有&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									术后病人皮肤（除手术切口外）：
									<input class="afterSkin" type="radio" name="nurse.afterSkin" value="洁" <c:if test="${nurse.afterSkin eq '洁'}">checked</c:if>> 洁&nbsp;
									<input class="afterSkin" type="radio" name="nurse.afterSkin" value="不洁" <c:if test="${nurse.afterSkin eq '不洁' }">checked</c:if>> 不洁&nbsp;
								</td>
								<td style="text-align: left;padding-left: 10px;">
									压疮：
									<input class="afterSore" type="radio" name="nurse.afterSore" value="无" <c:if test="${nurse.afterSore eq '无' }">checked</c:if>> 无&nbsp;
									<input class="afterSore" type="radio" name="nurse.afterSore" value="有" <c:if test="${nurse.afterSore eq '有' }">checked</c:if>> 有&nbsp;
								</td>
								<td style="text-align: left;padding-left: 10px;">
									灼伤：
									<input style="width: 50px;" id="burn" type="text" name="nurse.burn" value="${nurse.burn }"> 度&nbsp;
									其他：
									<input id="remark" type="text" name="nurse.remark" value="${nurse.remark }"> 
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								灭菌标识
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									包内化学指示物：
									<input class="disinfectMark" type="radio" name="nurse.disinfectMark" value="合格" <c:if test="${nurse.disinfectMark eq '合格' }">checked</c:if>> 合格&nbsp;
									<input class="disinfectMark" type="radio" name="nurse.disinfectMark" value="不合格" <c:if test="${nurse.disinfectMark eq '不合格' }">checked</c:if>> 不合格&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								物品使用
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									止血带：
									压力<input id="stopbleedingvalue" style="width: 50px;" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" size="5" type="text" name="nurse.stopbleedingvalue"  value="${nurse.stopbleedingvalue }"> mmHg
								</td>
								<td style="text-align: left;padding-left: 10px;">
									开始时间：
									<input id="bloodstart" size="22" class="Wdate" readonly="readonly" value="${nurse.stopbleedingBegintime }" name="nurse.stopbleedingBegintime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'getin\')}',maxDate:'#F{$dp.$D(\'bloodend\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									放松时间：
									<input id="bloodend" size="22" class="Wdate" readonly="readonly" value="${nurse.stopbleedingEndtime }" name="nurse.stopbleedingEndtime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'bloodstart\')}',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									安全带：
									<input class="safetybelt" type="radio" name="nurse.safetybelt" value="无" <c:if test="${nurse.safetybelt eq '无' }">checked</c:if>> 无&nbsp;
									<input class="safetybelt" type="radio" name="nurse.safetybelt" value="有" <c:if test="${nurse.safetybelt eq '有' }">checked</c:if>> 有&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								植入物
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									<input class="implant" type="radio" name="nurse.implant" value="无" <c:if test="${nurse.implant eq '无' }">checked</c:if>> 无&nbsp;
									<input class="implant" type="radio" name="nurse.implant" value="有" <c:if test="${nurse.implant eq '有' }">checked</c:if>> 有&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								术后转至
								</td>
							</tr>
							<tr class="bk">
								<td  colspan="3" style="text-align: left;padding-left: 10px;">
									<input class="operAfterGoto" type="radio" name="nurse.operAfterGoto" value="麻醉恢复室" <c:if test="${nurse.operAfterGoto eq '麻醉恢复室' }">checked</c:if>> 麻醉恢复室&nbsp;
									<input class="operAfterGoto" type="radio" name="nurse.operAfterGoto" value="ICU" <c:if test="${nurse.operAfterGoto eq 'ICU' }">checked</c:if>>  ICU&nbsp;
									<input class="operAfterGoto" type="radio" name="nurse.operAfterGoto" value="病房" <c:if test="${nurse.operAfterGoto eq '病房' }">checked</c:if>> 病房&nbsp;
									<input class="operAfterGoto" type="radio" name="nurse.operAfterGoto" value="其他" <c:if test="${nurse.operAfterGoto eq '其他' }">checked</c:if>> 其他&nbsp;
								</td>
							</tr>
							<tr class="ys" bgcolor="#f8f8f8">
								<td  colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								生命体征
								</td>
							</tr>
							</tbody>
							</table>
							<table  class="table table-bordered table-striped header-spcing">
							<tbody>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									进入手术室：
								</td>
								<td class="0"  style="text-align: left;padding-left: 10px;">
									时间：
									<input id="in" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${anaes0.time }" pattern="yyyy-MM-dd HH:mm:ss"/>'  name="anaes[0].time" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'getin\')}',maxDate:'#F{$dp.$D(\'out\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
									&nbsp;&nbsp;&nbsp;BP:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[0].diastolicPressure" value="${anaes0.diastolicPressure }">/
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[0].systolicPressure" value="${anaes0.systolicPressure }">mmHg&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;R:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[0].r" value="${anaes0.r }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;P:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[0].p" value="${anaes0.p }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;SpO2:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[0].spo2" value="${anaes0.spo2 }">%&nbsp;&nbsp;&nbsp;
									<input type="hidden" value="0" name="anaes[0].type">
									<input type="hidden" value="${anaes0.id }" name="anaes[0].id">
								</td>
								</tr>
							<tr class="No">
								<td rowspan="3" style="text-align: left;padding-left: 10px;">
									术中：
										
								</td>
								<td  class="1" style="text-align: left;padding-left: 10px;">
									时间：
									<input id="out" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${anaes1.time }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="anaes[1].time" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'in\')}',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
									&nbsp;&nbsp;&nbsp;BP:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[1].diastolicPressure" value="${anaes1.diastolicPressure }">/
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[1].systolicPressure"  value="${anaes1.systolicPressure }">mmHg&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;R:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[1].r"  value="${anaes1.r }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;P:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[1].p" value="${anaes1.p }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;SpO2:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[1].spo2" value="${anaes1.spo2 }">%&nbsp;&nbsp;&nbsp;
								<input type="hidden" value="1" name="anaes[1].type">
								<input type="hidden" value="${anaes1.id }" name="anaes[1].id">
								</td>
								</tr>
							<tr class="No">
								
								<td class="2"  style="text-align: left;padding-left: 10px;">
									时间：
									<input id="out" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${anaes2.time }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="anaes[2].time" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'in\')}',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">	
									&nbsp;&nbsp;&nbsp;BP:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[2].diastolicPressure" value="${anaes2.diastolicPressure }">/
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[2].systolicPressure" value="${anaes2.systolicPressure }">mmHg&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;R:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[2].r" value="${anaes2.r }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;P:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[2].p" value="${anaes2.p }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;SpO2:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[2].spo2" value="${anaes2.spo2 }">%&nbsp;&nbsp;&nbsp;
								<input type="hidden" value="1" name="anaes[2].type">
								<input type="hidden" value="${anaes2.id }" name="anaes[2].id">
								</td>
								</tr>
							<tr class="No">
								
								<td class="3" style="text-align: left;padding-left: 10px;">
									时间：
									<input id="out" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${anaes3.time }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="anaes[3].time" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'in\')}',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
									&nbsp;&nbsp;&nbsp;BP:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[3].diastolicPressure" value="${anaes3.diastolicPressure }">/
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[3].systolicPressure" value="${anaes3.systolicPressure }">mmHg&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;R:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[3].r" value="${anaes3.r }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;P:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[3].p" value="${anaes3.p }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;SpO2:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[3].spo2" value="${anaes3.spo2 }">%&nbsp;&nbsp;&nbsp;
								<input type="hidden" value="1" name="anaes[3].type">
								<input type="hidden" value="${anaes3.id }" name="anaes[3].id">
								</td>
								</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;">
									离开手术室：		
								</td>
								<td class="4" style="text-align: left;padding-left: 10px;">
									时间：
									<input id="out" size="22" class="Wdate" readonly="readonly" value='<fmt:formatDate value="${anaes4.time }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="anaes[4].time" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'in\')}',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
									&nbsp;&nbsp;&nbsp;BP:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[4].diastolicPressure" value="${anaes4.diastolicPressure }">/
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[4].systolicPressure" value="${anaes4.systolicPressure }">mmHg&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;R:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[4].r" value="${anaes4.r }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;P:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[4].p" value="${anaes4.p }">次/分&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;SpO2:
									<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="anaes[4].spo2" value="${anaes4.spo2 }">%&nbsp;&nbsp;&nbsp;
								<input type="hidden" value="2" name="anaes[4].type">
								<input type="hidden" value="${anaes4.id }" name="anaes[4].id">
								</td>
							</tr>
							</tbody>
							</table>
							<table class="table table-bordered table-striped header-spcing">
							<tbody>
							<tr class="No">
								<td  colspan="3"  style="text-align: left;padding-left: 10px;vertical-align: middle;">
								病人交接
								</td>
							</tr>
							<tr class="No">
								<td  colspan="3" style="text-align: left;padding-left: 10px;">
								影像资料：
									<input class="shadow" onclick="javascript:$('#count').val('')" type="radio" name="nurse.shadow" value="无" <c:if test="${nurse.shadow eq '无' }">checked</c:if>>无&nbsp;
									<input class="shadow" id="shadow" type="radio" name="nurse.shadow" value="有" <c:if test="${nurse.shadow eq '有' }">checked</c:if>>有（<input id="count" onkeyup="this.value=this.value.replace(/\D/g,'');countIn()" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" style="width: 50px;" type="text" name="nurse.count" value="${nurse.count }">张）&nbsp;
								病历：
									<input class="casehistory" type="radio" name="nurse.casehistory" value="无" <c:if test="${nurse.casehistory eq '无' }">checked</c:if>>无&nbsp;
									<input class="casehistory" type="radio" name="nurse.casehistory" value="有" <c:if test="${nurse.casehistory eq '有' }">checked</c:if>>有&nbsp;
								贵重物品 ：
								<input id="valuables" type="text" name="nurse.valuables" size="40">	
								</td>
							</tr>
							</tbody>
							</table>
						
						</form>
						<div style="text-align: center; margin-top: 2%;margin-bottom: 20px;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveTemplateTo()">存为模板</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="saveNurse()">保存</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="commitNurse()">确定</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="printN()">打印</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
						</div>
					</div>
				</div>
			</div>

	
<!-- <div style="border: 1px solid #95b8e7; width: 450px;height:270px;position: fixed;
			background-color:white;
			bottom: 400px;
            right: 40px;">
<ul style="margin-left: 2px;line-height: 40px;">
<li><h3 style="color: #178eb9;">手术间物品使用登记</h3></li>
<li><h4 style="font-weight: bolder; text-align: center;">设备使用登记</h4></li>
<li style="margin-left: 80px;">
<input class="biaodan" style="width: 50px;" type="text" size="8">
<select class="sel" style="height: 27px;width: 150px;">
</select>
<input type="button" value="登记" class="cx" onclick="">
</li>
<li><h4 style="font-weight: bolder; text-align: center;">消耗品使用登记</h4></li>
<li style="margin-left: 80px;">
<input class="biaodan" style="width: 50px;" type="text" size="8">
<select  class="sel" style="height: 27px;width: 150px;">
</select>
<input class="biaodan" style="width: 50px;" type="text" size="8">
<input type="button" value="登记" class="cx" onclick="">
</li>
<li style="text-align: center;">
<input type="button" id="s" value="手术开始" class="cx" onclick="">
<input type="button" id="e" value="结束手术" class="cx" onclick="">
</li>
</ul>

</div> -->	
</body>
</html>
