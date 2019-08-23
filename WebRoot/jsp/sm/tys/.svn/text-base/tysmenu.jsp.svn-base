<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>麻醉同意书</title>
<style type="text/css">
ul,li {
	margin: 0;
	padding: 0;
	font: 12px normal "宋体", Arial, Helvetica, sans-serif;
	list-style: none;
}

a {
	text-decoration: none;
	color: #000;
	font-size: 12px;
}

#tabbox {
	width: auto;
	overflow: hidden;
	margin: 0 auto;
}

.tab_conbox {
	border: 1px solid #999;
	border-top: none;
	margin-top: 0;
	margin-left: 10px;
}

.tab_con {
	display: none;
}

.tabs {
	height: 32px;
	border-bottom: 1px solid #999;
	border-left: 1px solid #999;
	width: 100%;
	margin-left: 10px;
	margin-bottom: 0;
	margin-right: 10px;
}

.tabs li {
	height: 31px;
	line-height: 31px;
	float: left;
	border: 1px solid #999;
	border-left: none;
	margin-bottom: -1px;
	background:  #F9F9F9;
	overflow: hidden;
	position: relative;
}

.tabs li a {
text-decoration: none;
	display: block;
	padding: 0 20px;
	border: 1px solid #fff;
	outline: none;
}

.tabs li a:hover {
	background: #ccc;
}

.tabs .thistab,.tabs .thistab a:hover {
	background: #1CAAD1;
	border-bottom: 1px solid #fff;
}

.tab_con {
	padding: 12px;
	font-size: 14px;
	line-height: 175%;
}
</style>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/addYpForm.css" type="text/css"></link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/validate/jquery.validate.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">
	CreateReport("Report");
	function printMz() {
		Report.LoadFromURL("../jsp/sm/tys/mzzq.grf");
		AjaxSyncLoadReportData(Report,"loadPrintMz.action?id="+$("#ylwsid").val());
		Report.PrintPreview(true);
	}	
	function printMz2() {
		Report.LoadFromURL("../jsp/sm/tys/ztsx.grf");
		AjaxSyncLoadReportData(Report,"loadPrintMz.action?id="+$("#ylwsid").val());

		Report.PrintPreview(true);
	}	
	function printMz3() {
		Report.LoadFromURL("../jsp/sm/tys/qiguan.grf");
		AjaxSyncLoadReportData(Report,"loadPrintMz.action?id="+$("#ylwsid").val());

		Report.PrintPreview(true);
	}	
	function printMz4() {
		Report.LoadFromURL("../jsp/sm/tys/zxjm.grf");
		AjaxSyncLoadReportData(Report,"loadPrintMz.action?id="+$("#ylwsid").val());

		Report.PrintPreview(true);
	}	
	function printMz5() {
		Report.LoadFromURL("../jsp/sm/tys/gzwp.grf");
		AjaxSyncLoadReportData(Report,"loadPrintMz.action?id="+$("#ylwsid").val());

		Report.PrintPreview(true);
	}	
	$(document).ready(function() {

		jQuery.jqtab = function(tabtit, tabcon) {
			$(tabcon).hide();
			$(tabtit + " li:first").addClass("thistab").show();
			$(tabcon + ":first").show();

			$(tabtit + " li").click(function() {
				$(tabtit + " li").removeClass("thistab");
				$(this).addClass("thistab");
				$(tabcon).hide();
				var activeTab = $(this).find("a").attr("tab");
				$("#" + activeTab).fadeIn();
				return false;
			});

		};
		/*调用方法如下：*/
		$.jqtab("#tabs", ".tab_con");

	});

	//返回
	function back() {
		window.location.href = "${pageContext.request.contextPath}/ylws/ylwsList.action?functionid="+$('#functionid').val();
	}

	function check1() {

		document.forms["form1"].submit();

	}
	function check2() {
		if ($("#form2").valid()){
		document.forms["form2"].submit();}
	else {
		return;
	}
	}
	function check3() {
		if ($("#form3").valid()){
			document.forms["form3"].submit();}
		else {
			return;
		}
	}
	function check4() {
		if ($("#form4").valid()){
			document.forms["form4"].submit();}
		else {
			return;
		}
	}
	var err = "<%=info%>";

	if (err.length > 0) {
		alert(err);

	}
</script>
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
</head>
<body>		
<input type="hidden" value="${functionid }" id="functionid">
	<div class="responsive-table">
				<div class="scrollable-area">
	<div id="tabbox">

		<ul class="tabs" id="tabs">
			<li><a style="padding-right: 9px;padding-left: 9px;color: black;" tab="tab1">麻醉知情同意书</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;color: black;" tab="tab2">自体输血治疗知情同意书</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;color: black;" tab="tab3">气管插管术知情同意书</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;color: black;" tab="tab4">中心静脉穿刺告知书</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;color: black;" tab="tab5">使用贵重或自费药品（物品）知情同意书</a>
			</li>
		</ul>
		<ul class="tab_conbox">
			<li id="tab1" class="tab_con">
	
				<form id="form1" name="form1" action="modMztysList.action"
					method="post">
					<input type="hidden" value="${functionid }" name="functionid">
					<table style="margin-top: 0;"  class="table table-bordered table-striped header-spcing" id="table">

						<c:forEach items="${tysList}" var="ylws">
							<input type="hidden" name="ylwsid" id="ylwsid" value="${ylws.id}">
							<input type="hidden" name="tys.docId" id="docId"
								value="${ylws.id}">
							<tr>

								<td>病人姓名：</td>
								<td>${ylws.name}</td>
								<td>性别：</td>
								<td><c:if test="${ylws.sex eq '0'}">男</c:if> <c:if
										test="${ylws.sex eq '1'}">女</c:if></td>
								<td>年龄：</td>
								<td>${ylws.age}</td>
							</tr>
							<tr>
								<td>住院号：</td>
								<td>${ylws.hid}</td>
								<td>病区：</td>
								<td>${ylws.region}</td>
								<td>床号：</td>
								<td>${ylws.bed}</td>
							</tr>
							<tr>
								<td>术前诊断：</td>
								<td>${ylws.diagnosisName}</td>
								<td>拟行手术：</td>
								<td>${ylws.designedOptName}</td>
								<td>麻醉方法：</td>
								<td>${ylws.designedAnaesMethodName}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6"><font color="red" >*</font>根据手术治疗和诊断检查的需要，患者需进行麻醉。麻醉和麻醉操作一般是安全的，但由于个体差异，虽然在麻醉前已经采取力所能及的预防措施，也有可能发生麻醉意外和并发症。现告知如下，包括但不限于：</td>
						</tr>
						<tr>
							<td width="12%" align="center"><input type="checkbox" style="margin-top: 15px;"
								name="tys.notice" value="1"
								<c:if test="${tys.notice.contains('1')}">checked</c:if>>
							</td>
							<td width="13%">全麻可能发生的意外和并发症</td>

							<td colspan="2" style="text-align: left;">(1)血压被动，心律失常。<br> (2)呼吸控制。 <br>
								(3)呼吸到梗阻：舌后坠落、痰或血阻塞气道。 <br> (4)反流、误吸或吸入性肺炎。 <br></td>

							<td colspan="2" style="text-align: left;">(5)脑血管意外。<br> (6)牙齿脱落或口腔软组织损伤。 <br>
								(7)经鼻插管可能导致出血。 <br> (8)咽喉炎、喉水肿，环骨关节脱落。 <br></td>
						</tr>
						<tr>
							<td width="12%" align="center"><input type="checkbox" style="margin-top: 15px;"
								name="tys.notice" value="2"
								<c:if test="${tys.notice.contains('2')}">checked</c:if>>
							</td>
							<td width="13%">椎管内麻醉可能发生的意外和并发症</td>

							<td colspan="2" style="text-align: left;">(1)患者因素与椎管内麻醉风险。<br> (2)麻醉风险。 <br>
								(3)麻醉风险痰或血阻塞气道。 <br> (4手术因素与椎管内麻醉风险。 <br></td>

							<td colspan="2" style="text-align: left;">(5)脑血管意外脱落。<br> (6)椎管内麻醉相关并发症。 <br>
								(7)咽喉炎、喉水肿，环骨关节脱落。 <br> (8)椎管脑血管意外。 <br></td>
						</tr>
						<tr>
							<td width="12%" align="center"><input type="checkbox" style="margin-top: 15px;"
								name="tys.notice" value="3"
								<c:if test="${tys.notice.contains('3')}">checked</c:if>>
							</td>
							<td width="13%">神经阻滞可能发生的意外和并发症</td>

							<td colspan="2" style="text-align: left;">(1)血压被动，心律失常。<br> (2)呼吸控制。 <br>
								(3)呼吸到梗阻：舌后坠落、痰或血阻塞气道。 <br> (4)反流、误吸或吸入性肺炎。 <br></td>

							<td colspan="2" style="text-align: left;">(5)脑血管意外。<br> (6)牙齿脱落或口腔软组织损伤。 <br>
								(7)经鼻插管可能导致出血。<br></td>
						</tr>
						<tr>
							<td width="12%" align="center"><input type="checkbox" style="margin-top: 15px;"
								name="tys.notice" value="4"
								<c:if test="${tys.notice.contains('4')}">checked</c:if>>
							</td>
							<td width="13%">深静脉、动脉穿刺可能发生的并发症</td>

							<td colspan="2" style="text-align: left;">(1)血压被动，心律失常。<br> (2)呼吸控制。 <br>
							</td>

							<td colspan="2" style="text-align: left;">(3)脑血管意外。<br> (4)牙齿脱落或口腔软组织损伤。 <br>
							</td>
						</tr>
						<tr>
							<td width="12%" align="center"><input type="checkbox" style="margin-top: 15px;"
								name="tys.notice" value="5"
								<c:if test="${tys.notice.contains('5')}">checked</c:if>>
							</td>
							<td width="13%">其他麻醉危险</td>

							<td colspan="4" style="text-align: left;">(1)分别介绍麻醉的风险及管理；椎管内麻醉学的解剖学、生理学、药理学基础；椎管内麻醉及椎管内镇痛治疗的各种并发症和意外事件的防范和处理。<br>
								(2)围术期相关并发症和意外事件的处理。同时还收集了颇具代表性的病例。 <br>
							</td>
						</tr>
						<tr>
							<td>是否要求术后镇痛：</td>
							<td colspan="5" style="text-align: left;"><input type="radio" name="tys.choosePain" value="0" style="vertical-align: baseline;"
								<c:if test="${tys.choosePain.contains('0')}">checked</c:if> />是
								<input type="radio" name="tys.choosePain" value="1" style="vertical-align: baseline;"
								<c:if test="${tys.choosePain.contains('1')}">checked</c:if> />否</td>
						</tr>
						<tr>
							<td>麻醉科医师：</td>
							<td colspan="2" style="text-align: left;vertical-align: middle;"><select name="tys.operationId">
									<c:forEach items="${opList}" var="sop" varStatus="status">
										<option value="${sop.code}"
											<c:if test="${tys.operationId==sop.code}">selected</c:if>>${sop.name}</option>
									</c:forEach>
							</select>
							</td><td class="text-left">签字日期：</td>
							<td colspan="2" style="text-align: left;vertical-align: middle;"><input class="Wdate" name="tys.visitDate"
								value="${tys.visitDate}" onFocus="WdatePicker({lang:'zh-cn'})" />
							</td>
						</tr>

					</table>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="check1()">保存</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="printMz()">打印</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="back()">返回</button>

				</form></li>




			<li id="tab2" class="tab_con">
				<form id="form2" name="form2" action="modMztysList2.action"
					method="post">
					<input type="hidden" value="${functionid }" name="functionid">
					<table style="margin-top: 0;" class="table table-bordered table-striped header-spcing" id="table">

						<c:forEach items="${tysList}" var="ylws">
							<input type="hidden" name="ylwsid" id="ylwsid" value="${ylws.id}">
							<input type="hidden" name="tys.docId" id="docId"
								value="${ylws.id}">
							<tr>

								<td>病人姓名：</td>
								<td>${ylws.name}</td>
								<td>性别：</td>
								<td><c:if test="${ylws.sex eq '0'}">男</c:if> <c:if
										test="${ylws.sex eq '1'}">女</c:if></td>
								<td>年龄：</td>
								<td>${ylws.age}</td>
							</tr>
							<tr>
								<td>住院号：</td>
								<td>${ylws.hid}</td>
								<td>病区：</td>
								<td>${ylws.region}</td>
								<td>床号：</td>
								<td>${ylws.bed}</td>
							</tr>
							<tr>
								<td>术前诊断：</td>
								<td>${ylws.diagnosisName}</td>
								<td>拟行手术：</td>
								<td>${ylws.designedOptName}</td>
								<td>麻醉方法：</td>
								<td>${ylws.designedAnaesMethodName}</td>
							</tr>
						</c:forEach>
						<tr>
							<td width="12%" align="center">输血治疗简介</td>
							<td colspan="5" style="text-align: left; padding-left: 10px;">常采用自体输血装置，抗凝和过滤后再回输给病人。可分为外伤时回收式自体输血、术中回收式自体输血和术后回收式自体输血，有以下优点：</td>
						</tr>
						<tr>
							<td width="12%" align="center">1、</td>
							<td colspan="5" style="text-align: left; padding-left: 10px;">需检测血型和交叉配合试验，可避免同种异体输血产生的抗体抗原免疫反应所致的溶血、发热和过敏反应。</td>
						</tr>
						<tr>
							<td width="12%" align="center">2、</td>
							<td colspan="5" style="text-align: left; padding-left: 10px;">可避免同种异体输血引起的差错事故。</td>
						</tr>
						<tr>
							<td width="12%" align="center">3、</td>
							<td colspan="5" style="text-align: left; padding-left: 10px;">反复放血，可刺激红细胞再生，使病人术后造血速度比术前加快。</td>
						</tr>
						<tr>
							<td width="12%" align="center">4、</td>
							<td colspan="5" style="text-align: left; padding-left: 10px;">自体输血可以缓解血源紧张的矛盾。</td>
						</tr> 
						<tr>
							<td width="12%" align="center">5、</td>
							<td colspan="5" style="text-align: left; vertical-align: middle;"><input style="width: 385px;" type="text"
								value="${tys.transfusionMerit}"
								placeholder="请输入其他优点,如无其他优点请填写“无”。" name="tys.transfusionMerit" />
							</td>
						</tr>
						<tr>
							<td>自体输血治疗：</td>
							<td colspan="5" style="text-align: left; padding-left: 10px;"><input type="radio" style="vertical-align: baseline;" name="tys.transfusionYn" value="0"
								<c:if test="${tys.transfusionYn.contains('0')}">checked</c:if>
								checked="checked" />等容量血液稀释 <input type="radio" style="vertical-align: baseline;"
								<c:if test="${tys.transfusionYn.contains('1')}">checked</c:if>
								name="tys.transfusionYn" value="1" />自体血回收 <input type="radio" style="vertical-align: baseline;"
								<c:if test="${tys.transfusionYn.contains('2')}">checked</c:if>
								name="tys.transfusionYn" value="2" />两者结合</td>
						</tr>
						<tr>
							<td>麻醉科医师：</td>
							<td colspan="2" style="text-align: left;vertical-align: middle;"><select name="tys.operationId">
									<c:forEach items="${opList}" var="sop" varStatus="status">
										<option value="${sop.code}"
											<c:if test="${tys.operationId==sop.code}">selected</c:if>>${sop.name}</option>
									</c:forEach>
							</select>
							</td>

							<td class="text-left">签字日期：</td>
							<td colspan="2" style="text-align: left;vertical-align: middle;"><input class="Wdate" name="tys.visitDate"
								value="${tys.visitDate}" onFocus="WdatePicker({lang:'zh-cn'})" />
							</td>
						</tr>
					</table>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="check2()">保存</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="printMz2()">打印</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="back()">返回</button>
				</form></li>





			<li id="tab3" class="tab_con">
				<form id="form3" name="form3" action="modMztysList3.action"
					method="post">
					<input type="hidden" value="${functionid }" name="functionid">
					<table style="margin-top: 0;" class="table table-bordered table-striped header-spcing" id="table">
						<c:forEach items="${tysList}" var="ylws">
							<input type="hidden" name="ylwsid" id="ylwsid" value="${ylws.id}">
							<input type="hidden" name="tys.docId" id="docId"
								value="${ylws.id}">
							<tr>

								<td>病人姓名：</td>
								<td>${ylws.name}</td>
								<td>性别：</td>
								<td><c:if test="${ylws.sex eq '0'}">男</c:if> <c:if
										test="${ylws.sex eq '1'}">女</c:if></td>
								<td>年龄：</td>
								<td>${ylws.age}</td>
							</tr>
							<tr>
								<td>住院号：</td>
								<td>${ylws.hid}</td>
								<td>病区：</td>
								<td>${ylws.region}</td>
								<td>床号：</td>
								<td>${ylws.bed}</td>
							</tr>
							<tr>
								<td>术前诊断：</td>
								<td>${ylws.diagnosisName}</td>
								<td>拟行手术：</td>
								<td>${ylws.designedOptName}</td>
								<td>麻醉方法：</td>
								<td>${ylws.designedAnaesMethodName}</td>
							</tr>
						</c:forEach>
						<tr>
							<td width="12%" align="center">气管插管术的作用</td>
							<td colspan="5" style="text-align: left;">气管内插管术是指将特制的气管导管，通过口腔或鼻腔插入病人气管内。是一种气管内麻醉和抢救病人的技术，也是保持上呼吸道通畅的最可靠手段。气管或支气管内插管是实施麻醉一项安全措施。</td>
						</tr>
						<tr>
							<td width="12%" align="center">1、</td>
							<td colspan="5" style="text-align: left;">保持呼吸道通畅，便于清除气管支气管内分泌物。</td>
						</tr>
						<tr>
							<td width="12%" align="center">2、</td>
							<td colspan="5" style="text-align: left;">便于实施辅助呼吸和人工呼吸。</td>
						</tr>
						<tr>
							<td width="12%" align="center">3、</td>
							<td colspan="5" style="text-align: left;">麻醉医生可以远离手术区，尤其适用于颅脑、颌面、五官和颈部手术。</td>
						</tr>
						<tr>
							<td width="12%" align="center">4、</td>
							<td colspan="5" style="text-align: left;">可以减少呼吸衰竭的病人呼吸道无效腔，便于给氧吸入和辅助呼吸 。</td>
						</tr>
						<tr>
							<td width="12%" align="center">5、</td>
							<td colspan="5" style="text-align: left;">选择合适的气管导管。</td>
						</tr>
						<tr>
							<td width="12%" align="center">6、</td>
							<td colspan="5"  style="vertical-align: middle;text-align: left;"><input size="100" type="text"
								value="${tys.accidentConcurrency}"
								placeholder="请输入其他作用,如无其他作用请填写“无”。"
								name="tys.accidentConcurrency"></td>
						</tr>
						<tr>
							<td>气管插管术：</td>
							<td colspan="31" style="text-align: left;"><input type="radio"
								name="tys.chooseAirtube" style="vertical-align: baseline;"
								<c:if test="${tys.chooseAirtube.contains('0')}">checked</c:if>
								value="0" checked="checked" />经口明视气管插管 <input type="radio"
								name="tys.chooseAirtube" style="vertical-align: baseline;"
								<c:if test="${tys.chooseAirtube.contains('1')}">checked</c:if>
								value="1" />经鼻盲探气管插管 <input type="radio"
								name="tys.chooseAirtube" style="vertical-align: baseline;"
								<c:if test="${tys.chooseAirtube.contains('2')}">checked</c:if>
								value="2" />经支镜辅助气管插管</td>
						</tr>
						<tr>
							<td>麻醉科医师：</td>
							<td colspan="2" style="vertical-align: middle;text-align: left;"><select name="tys.operationId">
									<c:forEach items="${opList}" var="sop" varStatus="status">
										<option value="${sop.code}"
											<c:if test="${tys.operationId==sop.code}">selected</c:if>>${sop.name}</option>
									</c:forEach>
							</select>
							</td>

							<td class="text-left">签字日期：</td>
							<td colspan="2" style="vertical-align: middle;text-align: left;"><input class="Wdate" name="tys.visitDate"
								value="${tys.visitDate}" onFocus="WdatePicker({lang:'zh-cn'})" />
							</td>
						</tr>
					</table>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="check3()">保存</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="printMz3()">打印</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="back()">返回</button>
				</form></li>





			<li id="tab4" class="tab_con">
				<form id="form4" name="form4" action="modMztysList4.action"
					method="post">
					<input type="hidden" value="${functionid }" name="functionid">
					<table style="margin-top: 0;" class="table table-bordered table-striped header-spcing" id="table">

						<c:forEach items="${tysList}" var="ylws">
							<input type="hidden" name="ylwsid" id="ylwsid" value="${ylws.id}">
							<input type="hidden" name="tys.docId" id="docId"
								value="${ylws.id}">
							<tr>

								<td>病人姓名：</td>
								<td>${ylws.name}</td>
								<td>性别：</td>
								<td><c:if test="${ylws.sex eq '0'}">男</c:if> <c:if
										test="${ylws.sex eq '1'}">女</c:if></td>
								<td>年龄：</td>
								<td>${ylws.age}</td>
							</tr>
							<tr>
								<td>住院号：</td>
								<td>${ylws.hid}</td>
								<td>病区：</td>
								<td>${ylws.region}</td>
								<td>床号：</td>
								<td>${ylws.bed}</td>
							</tr>
							<tr>
								<td>术前诊断：</td>
								<td>${ylws.diagnosisName}</td>
								<td>拟行手术：</td>
								<td>${ylws.designedOptName}</td>
								<td>麻醉方法：</td>
								<td>${ylws.designedAnaesMethodName}</td>
							</tr>
						</c:forEach>
						<tr>
							<td width="12%" align="center">穿刺用途</td>
							<td colspan="5" style="text-align: left;">穿刺是将穿刺针刺入体腔抽取分泌物做化验，向体腔注入气体或造影剂做造影检查，或向体腔内注入药物的一种诊疗技术。目的是抽血化验，输血、输液及置入导管做血管造影。常见的并发症有：</td>
						</tr>
						<tr>
							<td width="12%" align="center">1、</td>
							<td colspan="5" style="text-align: left;">但恶性淋巴肿瘤和深在淋巴结不应穿刺检查。</td>
						</tr>
						<tr>
							<td width="12%" align="center">2、</td>
							<td colspan="5" style="text-align: left;">有出血倾向者禁止做骨髓穿刺。</td>
						</tr>
						<tr>
							<td width="12%" align="center">3、</td>
							<td colspan="5" style="text-align: left;">穿刺后可抽液化验，也可注入空气造影和注入药物治疗。关节腔穿刺要求严格无菌，严防感染。</td>
						</tr>
						<tr>
							<td width="12%" align="center">4、</td>
							<td colspan="5" style="text-align: left;">毛细血管期和静脉期脑血管影像，来诊断幕上下肿瘤和血管病变。</td>
						</tr>
						<tr>
							<td width="12%" align="center">5、</td>
							<td colspan="5" style="text-align: left;">闭塞性脊髓血管病等。</td>
						</tr>
						<tr>
							<td width="12%" align="center">6、</td>
							<td colspan="5" colspan="2" style="vertical-align: middle;text-align: left;"><input size="100" type="text"
								name="tys.otherPuncture" placeholder="请输入其他用途,如无其他用途请填写“无”。"
								value="${tys.otherPuncture}"></td>
						</tr>
						<tr>
							<td>麻醉科医师：</td>
							<td colspan="2" style="vertical-align: middle;text-align: left;"><select name="tys.operationId">
									<c:forEach items="${opList}" var="sop" varStatus="status">
										<option value="${sop.code}"
											<c:if test="${tys.operationId==sop.code}">selected</c:if>>${sop.name}</option>
									</c:forEach>
							</select>
							</td>

							<td class="text-left">签字日期：</td>
							<td colspan="2" style="vertical-align: middle;text-align: left;"><input class="Wdate" name="tys.visitDate"
								value="${tys.visitDate}" onFocus="WdatePicker({lang:'zh-cn'})" />
							</td>
						</tr>
					</table>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="check4()">保存</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="printMz4()">打印</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="back()">返回</button>
				</form></li>





			<li id="tab5" class="tab_con">
				<form id="form5" name="form5" method="post">
				<input type="hidden" value="${functionid }" name="functionid">
					<table style="margin-top: 0;" class="table table-bordered table-striped header-spcing" id="table">

						<c:forEach items="${tysList}" var="ylws">
							<input type="hidden" name="ylwsid" id="ylwsid" value="${ylws.id}">
							<tr>

								<td>病人姓名：</td>
								<td>${ylws.name}</td>
								<td>性别：</td>
								<td><c:if test="${ylws.sex eq '0'}">男</c:if> <c:if
										test="${ylws.sex eq '1'}">女</c:if></td>
								<td>年龄：</td>
								<td>${ylws.age}</td>
							</tr>
							<tr>
								<td>住院号：</td>
								<td>${ylws.hid}</td>
								<td>病区：</td>
								<td>${ylws.region}</td>
								<td>床号：</td>
								<td>${ylws.bed}</td>
							</tr>
							<tr>
								<td>术前诊断：</td>
								<td>${ylws.diagnosisName}</td>
								<td>拟行手术：</td>
								<td>${ylws.designedOptName}</td>
								<td>麻醉方法：</td>
								<td>${ylws.designedAnaesMethodName}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6">贵重物品</td>
						</tr>
						<tr>
							<td>名称</td>
							<td>价格（元）</td>
							<td colspan="2">名称</td>
							<td colspan="2">价格（元）</td>
						</tr>
						<tr>
							<td>双腔气管导管</td>
							<td>724.15</td>
							<td colspan="2">加强型气管导管</td>
							<td colspan="2">253.82</td>
						</tr>
						<tr>
							<td>中心静脉导管</td>
							<td>24.00</td>
							<td colspan="2">中心动脉导管</td>
							<td colspan="2">57.83</td>
						</tr>
						<tr>
							<td>注射器</td>
							<td>20.00</td>
							<td colspan="2">全身动脉输气管</td>
							<td colspan="2">98</td>
						</tr>
						<tr>
							<td colspan="6">自费物品</td>
						</tr>
						<tr>
							<td>名称</td>
							<td>价格（元）</td>
							<td colspan="2">名称</td>
							<td colspan="2">价格（元）</td>
						</tr>
						<tr>
							<td>防护装置（机械）</td>
							<td>220.00</td>
							<td colspan="2">口罩</td>
							<td colspan="2">8</td>
						</tr>
						<tr>
							<td colspan="6">贵重药品</td>
						</tr>
						<tr>
							<td>名称</td>
							<td>价格（元）</td>
							<td colspan="2">名称</td>
							<td colspan="2">价格（元）</td>
						</tr>
						<tr>
							<td>酒精（150ml）</td>
							<td>60.5</td>
							<td colspan="2">盐水（100ml）</td>
							<td colspan="2">5</td>
						</tr>
						<tr>
							<td>冰块（500ml）</td>
							<td>10</td>
							<td colspan="2">硫磺酸（25ml)</td>
							<td colspan="2">88</td>
						</tr>
						<tr>
							<td>丙丁（100ml）</td>
							<td>59</td>
							<td colspan="2">口服液</td>
							<td colspan="2">64</td>
						</tr>
						<tr>
							<td>尼古丁</td>
							<td>78</td>
							<td colspan="2">红糖</td>
							<td colspan="2">9</td>
						</tr>
						<tr>
							<td>丙希纳（100ml）</td>
							<td>77</td>
							<td colspan="2">乙醇</td>
							<td colspan="2">414</td>
						</tr>
						<tr>
							<td colspan="6">自费药品</td>
						</tr>
						<tr>
							<td>名称</td>
							<td>价格（元）</td>
							<td colspan="2">名称</td>
							<td colspan="2">价格（元）</td>
						</tr>
						<tr>
							<td>黄酒精（150ml）</td>
							<td>345</td>
							<td colspan="2">浓盐水（100ml）</td>
							<td colspan="2">43</td>
						</tr>
						<tr>
							<td>大冰水（500ml）</td>
							<td>2</td>
							<td colspan="2">硫磺尿酸（25ml)</td>
							<td colspan="2">234</td>
						</tr>
						<tr>
							<td>甲丁（100ml）</td>
							<td>49</td>
							<td colspan="2">三精口服液</td>
							<td colspan="2">454</td>
						</tr>
						<tr>
							<td>大丁（100ml）</td>
							<td>45</td>
							<td colspan="2">冰糖</td>
							<td colspan="2">7</td>
						</tr>
						<tr>
							<td>胡椒盐</td>
							<td>4</td>
							<td colspan="2">冷酸灵</td>
							<td colspan="2">8</td>
						</tr>
					</table>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="printMz5()">打印</button>
					<button type="button" class="button_blue_74_33" style="border: medium none; margin-top: 10px;" onclick="back()">返回</button>
				</form></li>
		</ul>

	</div>
	</div>
	</div>
</body>
</html>