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

<title>麻醉计划</title>
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
$(function() {
	$.metadata.setType("attr", "validate");
	$("#form").validate();
});

	CreateReport("Report");
	function printMzjh() {
		Report.LoadFromURL("../jsp/sm/mzjh/mzjh.grf");
		AjaxSyncLoadReportData(Report,"loadPrintMzjh.action?id="+$("#ylwsid").val());

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
</script>
</head>

<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉计划</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
	<form id="form" name="form" action="modMzjhList.action" method="post">
<input type="hidden" value="${functionid }" name="functionid" id="functionid">
		<table class="table table-bordered table-striped header-spcing" id="table">

			<c:forEach items="${mzjhList}" var="ylws">
				<input type="hidden" name="mzjh.operationId" id="ylwsid" value="${ylws.id}">
				<input type="hidden" name="mzjh.docId" id="docId" value="${ylws.id}">
				<tr>

					<td>病人姓名：</td>
					<td>${ylws.name}</td>
					<td>性别：</td>
					<td><c:if test="${ylws.sex eq '0'}">男</c:if>
						<c:if test="${ylws.sex eq '1'}">女</c:if>
					</td>

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
					<td colspan="2">${ylws.diagnosisName}</td>
					<td>拟行手术：</td>
					<td colspan="2">${ylws.designedOptName}</td>

				</tr>
				</c:forEach>
				<tr>
					<td>麻醉前用药：</td>
					<td colspan="5" style="text-align: left;padding-left:20px;"><input type="checkbox"
						name="mzjh.abUserMedicine" value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.abUserMedicine.contains('0')}">checked</c:if>>卡因&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.abUserMedicine" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.abUserMedicine.contains('1')}">checked</c:if>>比卡因&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.abUserMedicine" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.abUserMedicine.contains('2')}">checked</c:if>>布比卡因&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.abUserMedicine" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.abUserMedicine.contains('3')}">checked</c:if>>娜卡因</td>
				</tr>
				<tr valign="middle">
					<td style="vertical-align: middle;" rowspan="12" align="center">麻醉选择：</td>
				</tr>
				<tr>
					<td style="text-align: left;padding-left:80px;" colspan="5"><input type="checkbox" style="vertical-align: baseline;"
						name="mzjh.anaesMethod" value="1"
						<c:if test="${mzjh.anaesMethod.contains('1')}">checked</c:if>>全身麻醉</td>
				</tr>
				<tr valign="middle">
					<td style="vertical-align: middle;" rowspan="8" align="center">诱导：</td>
				</tr>
				<tr>
					<td>诱导：</td>
					<td style="text-align: left;" colspan="3">（<input type="radio" name="mzjh.abduction" value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.abduction.contains('0')}">checked</c:if> />快诱导&nbsp;&nbsp;<input
						type="radio" name="mzjh.abduction" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.abduction.contains('1')}">checked</c:if> />慢诱导&nbsp;&nbsp;<input
						type="radio" name="mzjh.abduction" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.abduction.contains('2')}">checked</c:if> />吸入诱导&nbsp;&nbsp;<input
						type="radio" name="mzjh.abduction" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.abduction.contains('3')}">checked</c:if> />清醒插管）</td>
				</tr>
				<tr>
					<td>用药：</td>

					<td  style="text-align: left;" colspan="5"><input type="checkbox" name="mzjh.ganaesUserMedicine"
						value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.ganaesUserMedicine.contains('0')}">checked</c:if>>利多卡因&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.ganaesUserMedicine" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.ganaesUserMedicine.contains('1')}">checked</c:if>>布比卡因&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.ganaesUserMedicine" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.ganaesUserMedicine.contains('2')}">checked</c:if>>左布比卡因&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.ganaesUserMedicine" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.ganaesUserMedicine.contains('3')}">checked</c:if>>罗娜卡因</td>
				</tr>
				<tr>
					<td rowspan="5" style="vertical-align: middle;">插管：</td>
				<tr>
					<td  style="text-align: left;" colspan="3"><input type="checkbox" name="mzjh.intubattonApproach"
						value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonApproach.contains('0')}">checked</c:if>>经口&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.intubattonApproach" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonApproach.contains('1')}">checked</c:if>>经鼻(<input
						type="checkbox" name="mzjh.direction" value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.direction.contains('0')}">checked</c:if>>左&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.direction" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.direction.contains('1')}">checked</c:if>>右)&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.intubattonApproach" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonApproach.contains('2')}">checked</c:if>>单管&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.intubattonApproach" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonApproach.contains('3')}">checked</c:if>>双腔(<input
						type="checkbox" name="mzjh.direction" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.direction.contains('2')}">checked</c:if>>左&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.direction" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.direction.contains('3')}">checked</c:if>>右)</td>
				</tr>
				<tr>
					<td  style="text-align: left;" colspan="3"><input type="radio" name="mzjh.intubattonTypeone"
						value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonTypeone.contains('0')}">checked</c:if>>喉管<input style="width: 50px;"
						name="mzjh.intubattonTypeAppendone" 
						value="${mzjh.intubattonTypeAppendone}">号&nbsp;&nbsp;<input
						type="radio" name="mzjh.intubattonTypetwo" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonTypetwo.contains('1')}">checked</c:if>>咽喉导管<input style="width: 50px;"
						value="${mzjh.intubattonTypeAppendtwo}"
						name="mzjh.intubattonTypeAppendtwo">号</td>
				</tr>

				<tr>
					<td  style="text-align: left;" colspan="3"><input type="checkbox" name="mzjh.intubattonWay" value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonWay.contains('0')}">checked</c:if>>气管张开&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.intubattonWay" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.intubattonWay.contains('1')}">checked</c:if>>纤维支气管镜辅助</td>
				</tr>
				<tr>
					<td  style="text-align: left;" colspan="3">导管准备：①ID<select name="mzjh.canalPrepareone" style="width: 100px;">
							<option value="0"
								<c:if test="${mzjh.canalPrepareone.contains('0')}">selected</c:if>></option>
							<option value="1"
								<c:if test="${mzjh.canalPrepareone.contains('1')}">selected</c:if>>大导管</option>
							<option value="2"
								<c:if test="${mzjh.canalPrepareone.contains('2')}">selected</c:if>>中导管</option>
							<option value="3"
								<c:if test="${mzjh.canalPrepareone.contains('3')}">selected</c:if>>小导管</option>
					</select>②ID<select name="mzjh.canalPreparetwo" style="width: 100px;">
							<option value="0"
								<c:if test="${mzjh.canalPreparetwo.contains('0')}">selected</c:if>></option>
							<option value="1"
								<c:if test="${mzjh.canalPreparetwo.contains('1')}">selected</c:if>>最大导管</option>
							<option value="2"
								<c:if test="${mzjh.canalPreparetwo.contains('2')}">selected</c:if>>最中导管</option>
							<option value="3"
								<c:if test="${mzjh.canalPreparetwo.contains('3')}">selected</c:if>>最小导管</option>
					</select>③ID<select name="mzjh.canalPreparethree" style="width: 100px;">
							<option value="0"
								<c:if test="${mzjh.canalPreparethree.contains('0')}">selected</c:if>></option>
							<option value="1"
								<c:if test="${mzjh.canalPreparethree.contains('1')}">selected</c:if>>超大导管</option>
							<option value="2"
								<c:if test="${mzjh.canalPreparethree.contains('2')}">selected</c:if>>超中导管</option>
							<option value="3"
								<c:if test="${mzjh.canalPreparethree.contains('3')}">selected</c:if>>超小导管</option>
					</select></td>
				</tr>

				<tr>
					<td style="text-align: left; padding-left:80px; " colspan="5"><input type="checkbox"
						name="mzjh.anaesMethod" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMethod.contains('2')}">checked</c:if>>椎管麻醉</td>
				</tr>
				<tr>
					<td  style="text-align: left;padding-left:80px;" colspan="5"><input type="checkbox"
						name="mzjh.anaesMethod" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMethod.contains('3')}">checked</c:if>>神经阻滞</td>
				</tr>

				<tr>
					<td colspan="6"  style="text-align: left;">特殊技术：</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;padding-left:80px;"><input type="checkbox"
						name="mzjh.specialTechnology" style="vertical-align: baseline;"
						<c:if test="${mzjh.specialTechnology.contains('0')}">checked</c:if>
						value="0">控制性降压&nbsp;&nbsp;<input type="checkbox"
						name="mzjh.specialTechnology" style="vertical-align: baseline;"
						<c:if test="${mzjh.specialTechnology.contains('1')}">checked</c:if>
						value="1">低温麻醉&nbsp;&nbsp;<input type="checkbox"
						name="mzjh.specialTechnology" style="vertical-align: baseline;"
						<c:if test="${mzjh.specialTechnology.contains('2')}">checked</c:if>
						value="2">体外循环</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">监测方案：</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;padding-left:80px;" ><input type="checkbox" name="mzjh.inspect"
						value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.inspect.contains('0')}">checked</c:if>>ECG&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.inspect" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.inspect.contains('1')}">checked</c:if>>SpO2&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.inspect" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.inspect.contains('2')}">checked</c:if>>NIEP&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.inspect" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.inspect.contains('3')}">checked</c:if>>ETCO2&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.inspect" value="4" style="vertical-align: baseline;"
						<c:if test="${mzjh.inspect.contains('4')}">checked</c:if>>T&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.inspect" value="5" style="vertical-align: baseline;"
						<c:if test="${mzjh.inspect.contains('5')}">checked</c:if>>R</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">有创监测：&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.hurtInspect" value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.hurtInspect.contains('0')}">checked</c:if>>动脉测压&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.hurtInspect" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.hurtInspect.contains('1')}">checked</c:if>>中心静脉压</td>

				</tr>
				<tr>
					<td colspan="6"  style="text-align: left;">液体治疗：</td>
				</tr>
				<tr>
					<td colspan="6"  style="text-align: left;padding-left:80px;"><input type="checkbox" name="mzjh.liquorCure"
						value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.liquorCure.contains('0')}">checked</c:if>>晶体液&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.liquorCure" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.liquorCure.contains('1')}">checked</c:if>>胶体液&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.liquorCure" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.liquorCure.contains('2')}">checked</c:if>>血液&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.liquorCure" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.liquorCure.contains('3')}">checked</c:if>>血液回收&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.liquorCure" value="4" style="vertical-align: baseline;"
						<c:if test="${mzjh.liquorCure.contains('4')}">checked</c:if>>白蛋白&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.liquorCure" value="5" style="vertical-align: baseline;"
						<c:if test="${mzjh.liquorCure.contains('5')}">checked</c:if>>血浆</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">术后镇痛：</td>
				</tr>
				<tr>

					<td colspan="6" style="text-align: left;padding-left:80px;">药物配比：&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.anaesMatch" value="0" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMatch.contains('0')}">checked</c:if>>地佐辛&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.anaesMatch" value="1" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMatch.contains('1')}">checked</c:if>>芬太尼&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.anaesMatch" value="2" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMatch.contains('2')}">checked</c:if>>舒芬太尼&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.anaesMatch" value="3" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMatch.contains('3')}">checked</c:if>>沙革&nbsp;&nbsp;<input
						type="checkbox" name="mzjh.anaesMatch" value="4" style="vertical-align: baseline;"
						<c:if test="${mzjh.anaesMatch.contains('4')}">checked</c:if>>氯氨酸</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">需要上级医师解决的问题：</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;padding-left:80px;"><textarea class="form-control" style="width: 800px;resize: none;" 
							name="mzjh.doctorSopite">${mzjh.doctorSopite}</textarea>
					</td>

				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">预计可能发生的问题：</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;padding-left:80px;"><textarea class="form-control" style="width: 800px;resize: none;" 
							name="mzjh.possibiHappen">${mzjh.possibiHappen}</textarea>
					</td>

				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">科内讨论意见：</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;padding-left:80px;"><textarea class="form-control" style="width: 800px;resize: none;" 
							name="mzjh.discuss">${mzjh.discuss}</textarea>
					</td>

				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">麻醉再评估</td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: left;">血压：<input name="mzjh.bloodPreH" style="width: 50px;"
						value="${mzjh.bloodPreH}">/<input style="width: 50px;"
						name="mzjh.bloodPreL" value="${mzjh.bloodPreL}">mmHg&nbsp;&nbsp;&nbsp;&nbsp;
						心率：<input style="width: 50px;" name="mzjh.heartRhythm"
						value="${mzjh.heartRhythm}">次/分&nbsp;&nbsp;&nbsp;&nbsp;
						呼吸：<input style="width: 50px;" name="mzjh.breathFre" value="${mzjh.breathFre}">次/分
					SpO2：<input style="width: 50px;" name="mzjh.spo2"
						value="${mzjh.spo2}">%&nbsp;&nbsp;&nbsp;&nbsp; 术前禁食时间：<input
						style="width: 50px;" name="mzjh.prefastingtime" value="${mzjh.prefastingtime}">小时&nbsp;&nbsp;&nbsp;&nbsp;
						仪器设备检查完毕：<input type="checkbox" name="mzjh.equipmentInspection" style="vertical-align: baseline;"
						value="0"
						<c:if test="${mzjh.equipmentInspection.contains('0')}">checked</c:if>>
					</td>
				</tr>
			<tr>
				<td colspan="6" style="text-align: left;">结论：<input type="radio" name="mzjh.conclusion" style="vertical-align: baseline;"
					value="1"
					<c:if test="${mzjh.conclusion.contains('1')}">checked</c:if> />按原计划执行&nbsp;&nbsp;<input
					type="radio" name="mzjh.conclusion" value="2" style="vertical-align: baseline;"
					<c:if test="${mzjh.conclusion.contains('2')}">checked</c:if> />改变麻醉方法&nbsp;&nbsp;<input
					type="radio" name="mzjh.conclusion" value="3" style="vertical-align: baseline;"
					<c:if test="${mzjh.conclusion.contains('3')}">checked</c:if> />暂停手术</td>
			</tr>
			<tr>
				<td>麻醉科医师：</td>
				<td colspan="2" style="text-align: left;vertical-align: middle;"><select name="mzjh.aneasdoctor">
						<c:forEach items="${opList}" var="sop" varStatus="status">
							<option value="${sop.name}"
								<c:if test="${mzjh.aneasdoctor eq sop.name}">selected</c:if>>${sop.name}</option>
						</c:forEach>
				</select></td>
				<%
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String date = format.format(new Date());
				%>
				<td>签字日期：</td>
				<td colspan="2" style="text-align: left;vertical-align: middle;"><input
					class="Wdate" name="mzjh.visitDate" value="${mzjh.visitDate}"
					onFocus="WdatePicker({lang:'zh-cn'})" />
				</td>

			</tr>

		<tr><td colspan="6">
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check()">保存</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="printMzjh()">打印</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
		</td></tr>
		</table>
	</form>
</div>
</div>
</div>
</body>
</html>