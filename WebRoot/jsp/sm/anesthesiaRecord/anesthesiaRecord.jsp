<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>麻醉记录</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
    
	<link href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.min.css" type="text/css"></link>
	
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/anesthesiaRecord.js"></script>
<!-- 打印使用的JS文件  2个 -->
	<script type="text/javascript" src="../js/GRUtility.js"></script>
    <script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">

 CreateReport("Report");
function printt() {
	Report.LoadFromURL("../jsp/sm/anesthesiaRecord/anesthesiaRecord.grf");
	AjaxSyncLoadReportData(Report,"loadAnesthesiaRecordPrint.action?id="+$("#ylwsId").val());
	Report.PrintPreview(true);
}
/**
 * @Title: medicinePY 
 * @Description: 查询麻醉用药
 * @author 崔连瑞
 * @date 2016-06-02 上午10:58:41
 * @param 
 * @return void
 */	
var medicinePY = function(mpy){
    $.ajax({type:"post",
    	    url:realPath+"/anesthesiaRecord/queryMedicineNameByPY.action",
	        data:"mpyCode="+mpy.value,
	        async:false,
	        success:function(msg){
		                $("#medicineNameSelectID").html(msg);
		            }           
	    });
};

</script>

</head> 
<body class="page-header-fixed">
              <%  String userId = (String)request.getSession().getAttribute("userid"); %>
              <input type="hidden" id="userId"  value="<%=userId%>">
<input id="functionid" type="hidden" value="${functionid }">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉记录</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
		

						<form id="record">
						<input id="ylwsId" type="hidden" value="${sro.id }">
						<input type="hidden" id="operationId"  value="${sro.hid }">
						<input type="hidden" id="hospitalcode" value="${sessionScope.hospitalcode }">
						<input type="hidden" id="roomCode" name="sro.room" value="${sro.room }">
						<input type="hidden" id="state" name="sro.state" value="${sro.state }">
						
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="9" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								基本信息
								</td>
							</tr>
						</thead>	
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;">
									姓名：<input type="text"  value="${sro.name }" disabled="disabled" >
									
								</td>
								<td style="text-align: left;padding-left: 10px;">
									姓别： <input type="radio" style="vertical-align: baseline;" disabled="disabled" <c:if test="${sro.sex eq 0 }">checked</c:if>>男 
										 <input type="radio" style="vertical-align: baseline;" disabled="disabled" <c:if test="${sro.sex eq 1 }">checked</c:if>>女
								</td>
								<td style="text-align: left;padding-left: 10px;">
									年龄：<input type="text" value="${sro.age }" disabled="disabled" style="width: 40px;">&nbsp;岁&nbsp;<input type="text" value="${sro.ageMon }" disabled="disabled" style="width: 40px;">&nbsp;月
								</td>
								<td style="text-align: left;padding-left: 10px;">
									身高：<input type="text"  id="regOptHeightId" value="${sro.height }" style="width: 40px;">&nbsp;cm
								</td>
								<td style="text-align: left;padding-left: 10px;">
									体重：<input type="text"  id="regOptWeightId" value="${sro.weight }" style="width: 40px;">&nbsp;kg
								</td>
								<td style="text-align: left;padding-left: 10px;">
									病区：<input type="text"  value="${sro.region }" disabled="disabled" style="width: 100px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									床号：<input type="text"  value="${sro.bed }" disabled="disabled" style="width: 60px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									住院号：<input type="text" value="${sro.hid }" disabled="disabled" style="width: 120px;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									<input type="radio" style="vertical-align: baseline;" disabled="disabled" <c:if test="${sro.sex eq 0 }">checked</c:if>>急诊
								    <input type="radio" style="vertical-align: baseline;" disabled="disabled" <c:if test="${sro.sex eq 1 }">checked</c:if>>非急诊
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									诊断名称：<input type="text"  value="${sro.diagnosisName }" disabled="disabled" style="width: 70%;">
								</td>
								<td colspan="4" style="text-align: left;padding-left: 10px;">
									手术名称：<input type="text"  value="${sro.designedOptName }" disabled="disabled" style="width: 70%;">
								</td>
								<td  style="text-align: left;padding-left: 10px;">
									血型：<select name="sro.bloodType" id="regOptBloodTypeId" style="width: 100px;">
									         <c:forEach items="${smbtiList}" var="blood" varStatus="status">
										         <option value="${blood.bloodCode}" <c:if test="${sro.bloodType==blood.bloodCode}">selected</c:if>>${blood.bloodValue}</option>
									         </c:forEach>
							             </select>
								</td>
								<td  colspan="2"  style="text-align: left;padding-left: 10px;">
									  ASA：<select name="asa" id="regOptAsa01Id" style="width: 70%;">
                                             <option value="01" >Ⅰ</option>
                                             <option value="02" >Ⅱ</option>
                                             <option value="03"  >Ⅲ</option>
                                             <option value="04" >Ⅳ</option>
                                             <option value="05" >Ⅴ</option>
                                          </select>
								</td>
							</tr>
							<tr class="No">
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									麻醉方法：<input type="text"  value="${sro.designedAnaesMethodName }" disabled="disabled" style="width: 70%;">
								</td>
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									特殊情况：<input type="text"  value="${sro.designedAnaesMethodName }"  style="width: 70%;">
								</td>
								<td colspan="4" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									   手术体位：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" class="smBodyPositionClass01" name="operativePosition" value="01">&nbsp;仰卧位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               <input type="checkbox" class="smBodyPositionClass02" name="operativePosition" value="02">&nbsp;俯卧位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               <input type="checkbox" class="smBodyPositionClass03" name="operativePosition" value="03">&nbsp;左侧位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               <input type="checkbox" class="smBodyPositionClass04" name="operativePosition" value="04">&nbsp;右侧位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               <input type="checkbox" class="smBodyPositionClass05" name="operativePosition" value="05">&nbsp;结石位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                               <input type="checkbox" class="smBodyPositionClass06" name="operativePosition" value="06">&nbsp;坐位&nbsp;&nbsp;
								</td>
							</tr>
							<tr class="No">
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									镇痛：
									<input type="radio" style="vertical-align: baseline;" name="analgesia"  value="01" <c:if test='${smard.analgesia eq "01"}'>checked</c:if>>是
								    <input type="radio" style="vertical-align: baseline;" name="analgesia"  value="02" <c:if test='${smard.analgesia eq "02"}'>checked</c:if>>否
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									心肺复苏：
									<input type="radio" style="vertical-align: baseline;" name="cpr"  value="01" <c:if test='${smard.cpr eq "01"}'>checked</c:if>>是
								    <input type="radio" style="vertical-align: baseline;" name="cpr"  value="02" <c:if test='${smard.cpr eq "02"}'>checked</c:if>>否
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									手术清洁度：
									<select name="incisionCleanliness" id="incisionCleanliness" style="width: 70%;">
								
                                             <option value="01" <c:if test='${smard.incisionCleanliness eq "01"}'>selected</c:if>>Ⅰ</option>
                                             <option value="02" <c:if test='${smard.incisionCleanliness eq "02"}'>selected</c:if>>Ⅱ</option>
                                             <option value="03" <c:if test='${smard.incisionCleanliness eq "03"}'>selected</c:if>>Ⅲ</option>
                                             <option value="04" <c:if test='${smard.incisionCleanliness eq "04"}'>selected</c:if>>Ⅳ</option>
                                    </select>
								</td>
								<td colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									  
								</td>
							</tr>
							<tr class="No">
								<td colspan="2" style="text-align: left;padding-left: 10px;"> 
									麻醉医生：<input type="text" id="anesthesiaDoctor" value="${sro.anesthetist } ${sro.circuanesthetist } ${sro.anaesAssistant }" readonly="readonly" style="width: 70%;">
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									手术医生：<input type="text"  id="operationDoctor" value="${sro.operatorName}" readonly="readonly" style="width: 70%;">
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									巡回护士：<input type="text"  id="tourNurse" value="${sro.instrnurse1 }  ${sro.instrnurse2 }" readonly="readonly" style="width: 70%;">
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									器械护士：<input type="text"  id="instrumentNurse" value="${sro.circunurse1 }  ${sro.circunurse2 }" readonly="readonly" style="width: 70%;">
								</td>
								<td style="text-align: left;padding-left: 10px;">
								</td>
							</tr>
						</table>
						</form>
					</div>
			        <div class="scrollable-area">
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="9" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								麻醉记录
								</td>
							</tr>
						<tr class="No">
								<td style="text-align: center;padding-left: 10px;">
						           <button type="button" class="button_blue_74_33" id="start" style="border: medium none;margin-left: 30px;">开始</button>
						           <button type="button" class="button_blue_74_33" id="startRecord"  style="border: medium none;margin-left: 30px;" onclick="startRecord()">开始记录</button>
						           <button type="button" class="button_blue_74_33" id="stopRecord" style="border: medium none;margin-left: 30px;" onclick="stopRecord()">结束记录</button>
						           <button type="button" class="button_blue_74_33" id="end" style="border: medium none;margin-left: 30px;">结束</button>
						           <button type="button" class="button_blue_74_33" id="save" style="border: medium none;margin-left: 30px;" onclick="saveRegOpt()">保存</button>
						           <button type="button" class="button_blue_74_33" id="print" style="border: medium none;margin-left: 30px;" onclick="printt();">打印</button>
						           <!-- <button type="button" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="back()">返回</button> -->
						           <button type="button" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="saveMedEvent()">返回</button>
								</td>
						</tr>
						</thead>	
						</table>
					</div>
					<div style="width: 1300px;height: 960px;border:0px solid #000000;margin-left: 10px;">
					   <div style="width: 170px;height: 950px;border:1px solid #000000;float: left;">
					   <div  style="text-align: center;line-height:20px; width: 170px;height: 30px;border: 1px solid #000000;margin-left: -1px;margin-top: -1px;line-height: 27px;">开始时间</div>
					   <div style="width: 170px;height: 360px;border: 0px solid #000000;margin-top: -1px;">
					      <div style="position: absolute;width: 20px;height: 360px;border:1px solid #000000;margin-left: -1px;">
					      <div style="position: absolute;height: 239px;width: 20px;border: 1px solid #000000;text-align: left;font-size: 15px;line-height: 13px; top: 0px">
					     <br><br><br><br> 麻<br><br><br>醉<br><br><br>用<br><br><br>药<br>
					      </div>
					      <div style="position: absolute;height: 60px;width: 20px;border: 1px solid #000000;text-align: left;font-size: 15px;line-height: 13px; top: 239px">
					     <br> 入<br><br>量<br>
					      </div>
					      <div style="position: absolute;height: 60px;width: 20px;border: 1px solid #000000;text-align: left;font-size: 15px;line-height: 13px; top: 299px">
					     <br> 出<br><br>量<br>
					      </div>
					      </div>
					      <div style="position: absolute;width: 148px;height: 360px;border:1px solid #000000;margin-left: 20px;">
					<div id="anestheticMedicine0" class="anestheticAgents" style="position: absolute;height: 15px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 0px"></div>
                    <div id="anestheticMedicine1" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 15px"></div>
                    <div id="anestheticMedicine2" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 30px"></div>
                    <div id="anestheticMedicine3" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 45px"></div>
                    <div id="anestheticMedicine4" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 60px"></div>
                    <div id="anestheticMedicine5" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 75px"></div>
                    <div id="anestheticMedicine6" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 90px"></div>
                    <div id="anestheticMedicine7" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 105px"></div>
                    <div id="anestheticMedicine8" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 120px"></div>
                    <div id="anestheticMedicine9" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 135px"></div>
                    <div id="anestheticMedicine10" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 150px"></div>
                    <div id="anestheticMedicine11" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 165px"></div>
                    <div id="anestheticMedicine12" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 180px"></div>
                    <div id="anestheticMedicine13" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 195px"></div>
                    <div id="anestheticMedicine14" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 210px"></div>
                    <div id="anestheticMedicine15" class="anestheticAgents" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 225px"></div>
                    <div id="liquidsInDivId0" class="inputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 240px"></div>
                    <div id="liquidsInDivId1" class="inputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 255px"></div>
                    <div id="liquidsInDivId2" class="inputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 270px"></div>
                    <div id="liquidsInDivId3" class="inputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 285px"></div>
                    <div id="liquidsOutDivId0" class="outputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 300px"></div>
                    <div id="liquidsOutDivId1" class="outputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 315px"></div>
                    <div id="liquidsOutDivId2" class="outputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 330px"></div>
                    <div id="liquidsOutDivId3" class="outputLiquid" style="position: absolute;height: 14px;width: 148px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 345px"></div>
					      </div>
					       <div class="" style="position: absolute;text-align: center;width: 170px;height: 30px;border: 1px solid #000000;margin-left: -1px;margin-top: 360px;line-height: 27px;">开始时间</div>
					    <div class="" style="position: absolute;text-align: center;width: 170px;height: 451px;border: 1px solid #000000;margin-left: -1px;margin-top: 390px;line-height: 27px;">
					     <table border="0" cellspacing="0" style="width: 170px;margin-left: -1px;margin-right: 0px;margin-top: -15px;">
                              <tr style="width: 170px;height: 45px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><br>1000&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;40&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;280</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">800&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;38&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;260</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">600&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;36&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;240</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">400&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;34&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;220</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">200&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;32&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;200</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">VT&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;30&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;180</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">32&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;28&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;160</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">28&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;26&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;140</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">24&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;24&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;120</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">20&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;22&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;100</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">16&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;20&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;80</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">12&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;18&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;60</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">8&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;40</td></tr>
                              <tr style="width: 170px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;20</td></tr>
                              <tr style="width: 170px;height: 15px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;">CVP&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;℃ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;P.R.BP</td></tr>

                        </table>
					    </div>
					    <div class='anesEvent' style="position: absolute;text-align: center;width: 170px;height: 30px;border: 1px solid #000000;margin-left: -1px;margin-top: 841px;line-height: 27px;">麻醉事件</div>
					    
					    
					    </div>
					   </div>
					   <div style="width: 1000px;height: 950px;border:1px solid #000000;float: left;overflow :auto;margin-left: -1px;">
					      <canvas id="canvasTimeTop"  height="30" width="10000" style="border:0px solid #000000;"></canvas>
                          <canvas id="canvasMedication" height="240" width="10000" style="border:0px solid #000000;margin-top: -5px;"></canvas>
                          <canvas id="canvasInPut"  height="60" width="10000" style="border:0px solid #000000;margin-top: -5px;"></canvas>
                          <canvas id="canvasOutPut"  height="60" width="10000" style="border:0px solid #000000;margin-top: -5px;"></canvas>
                          <canvas id="canvasTimeCenter"  height="30" width="10000" style="border:0px solid #000000;margin-top: -5px;"></canvas>
                          <canvas id="canvasCollect"  height="450" width="10000" style="border:0px solid #000000;margin-top: -5px;"></canvas>
                          <canvas id="canvasOperationEvent"  height="30" width="10000" style="border:1px solid #000000;margin-top: -5px;"></canvas>
					   </div>
					<div style="width: 120px;height: 950px;border:1px solid #000000;float: left;">
					 <div  style="text-align: center;width: 120px;height: 30px;border: 1px solid #000000;margin-top: -1px;line-height: 27px;">总量</div>
					 <div style="position: absolute;width: 120px;height: 360px;border:0px solid #000000;margin-left: 0px;">
					<div id="anestheticMedicineTotal0" class="anestheticAgentsTotal" style="position: absolute;height: 15px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 0px"></div>
                    <div id="anestheticMedicineTotal1" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 15px"></div>
                    <div id="anestheticMedicineTotal2" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 30px"></div>
                    <div id="anestheticMedicineTotal3" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 45px"></div>
                    <div id="anestheticMedicineTotal4" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 60px"></div>
                    <div id="anestheticMedicineTotal5" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 75px"></div>
                    <div id="anestheticMedicineTotal6" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 90px"></div>
                    <div id="anestheticMedicineTotal7" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 105px"></div>
                    <div id="anestheticMedicineTotal8" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 120px"></div>
                    <div id="anestheticMedicineTotal9" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 135px"></div>
                    <div id="anestheticMedicineTotal10" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 150px"></div>
                    <div id="anestheticMedicineTotal11" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 165px"></div>
                    <div id="anestheticMedicineTotal12" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 180px"></div>
                    <div id="anestheticMedicineTotal13" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 195px"></div>
                    <div id="anestheticMedicineTotal14" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 210px"></div>
                    <div id="anestheticMedicineTotal15" class="anestheticAgentsTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 225px"></div>
                    <div id="liquidsInDivIdTotal0" class="inputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 240px"></div>
                    <div id="liquidsInDivIdTotal1" class="inputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 255px"></div>
                    <div id="liquidsInDivIdTotal2" class="inputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 270px"></div>
                    <div id="liquidsInDivIdTotal3" class="inputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px; top: 285px"></div>
                    <div id="liquidsOutDivIdTotal0" class="outputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 300px"></div>
                    <div id="liquidsOutDivIdTotal1" class="outputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 315px"></div>
                    <div id="liquidsOutDivIdTotal2" class="outputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 330px"></div>
                    <div id="liquidsOutDivIdTotal3" class="outputLiquidTotal" style="position: absolute;height: 14px;width: 120px;border: 1px solid #000000;text-align: left;font-size: 12px;line-height: 13px;top: 345px"></div>
					      </div>
					 <div class="" style="position: absolute;text-align: center;width: 120px;height: 30px;border: 1px solid #000000;margin-left: -1px;margin-top: 360px;line-height: 27px;">开始时间</div>
					<div class="" style="position: absolute;text-align: center;width: 120px;height: 451px;border: 1px solid #000000;margin-left: -1px;margin-top: 390px;line-height: 27px;">
					     <table border="0" cellspacing="0" style="width: 170px;margin-left: -1px;margin-right: 0px;margin-top: -15px;">
                              <tr style="width: 120px;height: 45px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><br><span style="color:#000000;">▲</span>温度</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:blue;">●</span>脉搏</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:blue;">○</span>呼吸</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:blue;">∨</span>收缩压</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:blue;">∧</span>舒张压</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:#000000;">▼</span>潮气量</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:red;">★</span>麻醉深度</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"><span style="color:#000000;">¤</span>中心静脉压</td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                              <tr style="width: 120px;height: 30px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                              <tr style="width: 120px;height: 15px;"><td style="border: 0px solid #000000;padding: 0px;margin: 0px;text-align: center;"></td></tr>
                        </table>
					    </div>
					
					


					</div>
					  
                     </div>
			        <div class="scrollable-area">
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="9" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								事件记录
								</td>
							</tr>
						</thead>
						    <tr class="No">
								<td colspan="2" class='anesEvent' style="text-align: center;">麻醉事件</td>
								<td colspan="2" style="text-align: center;">检验事件</td>
							    <td colspan="2" class="operationEventTitleClass" style="text-align: center;">手术事件</td>
								<td colspan="2" class="breathEventTitleClass" style="text-align: center;">呼吸事件</td>
							</tr>	
						    <tr class="No">
								<td class='anesEvent' colspan="2" style="text-align: center;height: 200px;">
									<div style="width: 100%;height: 210px; overflow:auto;">
										<table id="anesEventItem" style="width: 100%;">
										<tbody id="anesEventItemTableTbody"></tbody>
										</table>
									</div>
								</td>
								<td colspan="2" style="text-align: center;height: 200px;">
									
								</td>
								<td class="operationEventTitleClass" colspan="2" style="text-align: center;height: 200px;">
									<div style="width: 100%;height: 210px; overflow:auto;">
										<table id="operationEventItem" style="width: 100%;">
										<c:forEach items="${opEvent }" var="e">
											<tr lang="${e.id }">
											<td><a href="javascript:void(0)" class="eventTitle">${e.title }</a></td>
											<td><fmt:formatDate value="${e.time }" pattern="HH:mm"></fmt:formatDate></td>
											<td><a href="javascript:void(0)" class="modTitle">修改</a>&nbsp;&nbsp;
												<a href="javascript:void(0)" class="delTitle">删除</a>
												</td>
											</tr> 
										</c:forEach>
										</table>
									</div>
								</td>
								<td class="breathEventTitleClass" colspan="2" style="text-align: center;height: 200px;">
									<table id="breathEventItem" style="width: 100%;">
										<c:forEach items="${breathEvent }" var="e">
											<tr lang="${e.id }">
											<td>
												<c:if test="${e.flag eq '01' }">自主呼吸</c:if>
												<c:if test="${e.flag eq '02' }">辅助呼吸</c:if>
												<c:if test="${e.flag eq '03' }">控制呼吸</c:if>
											</td>
											<td><fmt:formatDate value="${e.starttime }" pattern="HH:mm"></fmt:formatDate></td>
											<td><a href="javascript:void(0)" class="delBreath">删除</a></td>
											</tr> 
										</c:forEach> 
									</table>
								</td>
							</tr>	
						</table>
					</div>
			        <div class="scrollable-area">
			           <form id="outRoomStatusFormId">
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="9" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								出室情况
								</td>
							</tr>
						</thead>
						<tr class="No">
								<td colspan="1" style="text-align: left;padding-left: 10px;">术后镇痛</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									         &nbsp;&nbsp;&nbsp;
									          <input id="sorsOperationId" type="hidden"   name="sors.operationId"  value="${sro.id}">
									         <input type="radio" id="easePainManner01Id" name="sors.easePainManner" value="01">&nbsp;无&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="easePainManner02Id" name="sors.easePainManner" value="02">&nbsp;PCIA&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="easePainManner03Id" name="sors.easePainManner" value="03">&nbsp;PCEA&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="1" style="text-align: left;padding-left: 10px;">意识</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									      &nbsp;&nbsp;&nbsp;
									      <input type="radio" id="mentalState01Id" name="sors.mentalState" value="01">&nbsp;清醒&nbsp;&nbsp;&nbsp;&nbsp;
		                                  <input type="radio" id="mentalState02Id" name="sors.mentalState" value="02">&nbsp;嗜睡&nbsp;&nbsp;&nbsp;&nbsp;
		                                  <input type="radio" id="mentalState03Id" name="sors.mentalState" value="03">&nbsp;瞻妄&nbsp;&nbsp;&nbsp;&nbsp;
		                                  <input type="radio" id="mentalState04Id" name="sors.mentalState" value="04">&nbsp;昏迷&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="1" style="text-align: left;padding-left: 10px;">咳嗽(吞咽)反射</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									      &nbsp;&nbsp;&nbsp;
									      <input type="radio" id="coughReflact01Id" name="sors.coughReflact" value="01">&nbsp;好&nbsp;&nbsp;&nbsp;&nbsp;
		                                  <input type="radio" id="coughReflact02Id" name="sors.coughReflact" value="02">&nbsp;差&nbsp;&nbsp;&nbsp;&nbsp;
		                                  <input type="radio" id="coughReflact03Id" name="sors.coughReflact" value="03">&nbsp;无&nbsp;&nbsp;&nbsp;&nbsp;	 
								</td>
							</tr>	
						<tr class="No">
								<td colspan="1" style="text-align: left;padding-left: 10px;">定向力</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									        &nbsp;&nbsp;&nbsp;
									        <input type="radio" id="direPower01Id" name="sors.direPower" value="01">&nbsp;好&nbsp;&nbsp;&nbsp;&nbsp;   
		                                    <input type="radio" id="direPower02Id" name="sors.direPower" value="02">&nbsp;差&nbsp;&nbsp;&nbsp;&nbsp;
		                                    <input type="radio" id="direPower03Id" name="sors.direPower" value="03">&nbsp;无&nbsp;&nbsp;&nbsp;&nbsp; 
								</td>
								<td colspan="1" style="text-align: left;padding-left: 10px;">肌松恢复</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
								             &nbsp;&nbsp;&nbsp;
								             <input type="radio" id="muscleRecover01Id"  name="sors.muscleRecover" value="01">&nbsp;好&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="muscleRecover02Id"  name="sors.muscleRecover" value="02">&nbsp;差 &nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td colspan="1" style="text-align: left;padding-left: 10px;">病人送往</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;">
								             &nbsp;&nbsp;&nbsp;
								             <input type="radio" id="leaveTo01Id" name="sors.leaveTo" value="01">&nbsp;PACU&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="leaveTo02Id" name="sors.leaveTo" value="02">&nbsp;ICU&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="leaveTo03Id" name="sors.leaveTo" value="03">&nbsp;回病房&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="leaveTo04Id" name="sors.leaveTo" value="04">&nbsp;出院&nbsp;&nbsp;&nbsp;&nbsp;
		                                     <input type="radio" id="leaveTo05Id" name="sors.leaveTo" value="05">&nbsp;死亡&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>	
						</table>
						</form>
					</div>
			        <div class="scrollable-area">
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="9" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								麻醉小结
								</td>
							</tr>
						</thead>
					<tr class="No">
						<td colspan="1" style="text-align: left;padding-left: 10px;">
							手术时间</td>

						<td colspan="2" style="text-align: left;padding-left: 10px;">
							开始&nbsp;&nbsp; <input type="text" id="operationStartTimeTextId"
							disabled="disabled" class="Wdate"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							style="width: 50%;" value="${smard.optStartTime }"></td>
						<td colspan="2" style="text-align: left;padding-left: 10px;">
							结束&nbsp;&nbsp; <input type="text" id="operationEndTimeTextId"
							disabled="disabled" class="Wdate"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							style="width: 50%;" value="${smard.optEndTime }"></td>
						<td colspan="2" style="text-align: left;padding-left: 10px;">
							总时间&nbsp;&nbsp;<input type="text" disabled="disabled"
							id="operationUseTimeTextid" name="operationUseTimeTextName"
							value="" style="width: 50%"></td>
					</tr>
					<tr class="No">
						<td colspan="1" style="text-align: left;padding-left: 10px;">
							麻醉时间</td>
						<td colspan="2" style="text-align: left;padding-left: 10px;">
							开始&nbsp;&nbsp; <input type="text" id="anaesthesiaStartTimeTextId"
							disabled="disabled" class="Wdate"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							style="width: 50%;" value="${smard.anaesStartTime }"></td>
						<td colspan="2" style="text-align: left;padding-left: 10px;">
							结束&nbsp;&nbsp; <input type="text" id="anaesthesiaEndTimeTextId"
							disabled="disabled" class="Wdate"
							onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
							style="width: 50%;" value="${smard.anaesEndTime }"></td>
						<td colspan="2" style="text-align: left;padding-left: 10px;">
							总时间&nbsp;&nbsp;<input type="text" disabled="disabled"
							id="anaesthesiaUseTimeTextId" name="anaesthesiaUseTimeTextName"
							value="" style="width: 50%;"></td>
					</tr>
				</table>
					</div>
			        <div class="scrollable-area">
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="12" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								出入量汇总
								</td>
							</tr>
						</thead>
							<tr class="No">
								<td  colspan="2" style="text-align: left;padding-left: 10px;">
									入量
								</td>
								<td  style="text-align: right;padding-left: 10px;">胶体量</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">晶体量</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">输血量</td>
								<td  colspan="5" style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 13.6%">&nbsp;ml
								</td>
							</tr>
							<tr class="No">
								<td  colspan="2" style="text-align: left;padding-left: 10px;">
									出量
								</td>
								<td  style="text-align: right;padding-left: 10px;">尿量</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%;">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">血量</td>
								<td  style="text-align: left;padding-left: 10px;">
								   &nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%;">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">胸水</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%;">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">腹水</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%;">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">其它</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%;">&nbsp;ml
								</td>
							</tr>
							<tr class="No">
								<td  colspan="2" style="text-align: left;padding-left: 10px;">
									出入总量
								</td>
								<td  style="text-align: right;padding-left: 10px;">液体出量</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">液体入量</td>
								<td  style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 50%">&nbsp;ml
								</td>
								<td  style="text-align: right;padding-left: 10px;">出入量差</td>
								<td  colspan="5" style="text-align: left;padding-left: 10px;">
									&nbsp;&nbsp;<input type="text" disabled="disabled"  value="" style="width: 13.6%">&nbsp;ml
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
<!-- 开始弹出框 -->
	<div id="startPopup" class="scrollable-area" title="开始采集">
	     <table class="table table-bordered table-striped header-spcing">
	        <thead>	
				<tr class="bj"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">开始信息</td></tr>
			</thead>
			   <tr class="No">
			   		<td  style="text-align: right;padding-left: 10px;">
					采集间隔：
                    </td>
				   <td  style="text-align: left;padding-left: 10px;">
						 <select name="collectInterval" id="collectInterval" style="width: 210px;">
                                        <option value="1" >   1分钟 </option>
                                        <option value="3" >   3分钟 </option>
                                        <option value="5" >   5分钟 </option>
                                        <option value="10" >  10分钟 </option>
                                  </select>
				  </td>
			  </tr>
			  <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					开始时间：
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					<input id="operationStarttime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 26px;border-radius: 3px;"/>
                  </td>
              </tr>
			  <tr class="No">
			      <td  colspan="2" style="text-align: center;">
					<button type="button" class="button_blue_74_33" id="startPopupStartButton" style="border: medium none;margin-left: 30px;">开始</button>
					<button type="button" class="button_blue_74_33" id="startPopupCloseButton"  style="border: medium none;margin-left: 30px;">返回</button>
                  </td>
              </tr>
	     </table>
    </div>

<!-- 麻醉医师弹出框 -->
<div id="anesthesiaDoctorPopup" class="scrollable-area" title="麻醉医生">
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 340px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">麻醉人员信息</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">麻醉医师</td>
			       <td  id="anesthetist" style="text-align: center;padding-left: 10px;width:50%;">${sro.anesthetist }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">巡台麻醉师</td>
			       <td  id="circuanesthetist" style="text-align: center;padding-left: 10px;width:50%;">${sro.circuanesthetist }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">麻醉助理</td>
			       <td  id="anaesAssistant" style="text-align: center;padding-left: 10px;width:50%;">${sro.anaesAssistant }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			    </tr>
	     </table>
      
      </div>
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 340px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td  colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">选择麻醉人员</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;"><td  colspan="2"  style="text-align: center;"><input type="text"  ></td></tr>
			    <tr class="No" style="height: 40px;">
			        <td  style="text-align: center;">
			            <select  id="anesthesiaDoctorType" style="width: 120px;">
                             <option  value="anesthetist">麻醉医师</option>
                             <option  value="circuanesthetist">巡台麻醉师</option>
                             <option  value="anaesAssistant">麻醉助理</option>
                        </select>
			        </td>
			        <td  style="text-align: center;">
			            <select  id="anesthesiaDoctorNameList" style="width: 100px;">
                             <!--<option></option>
                              <option>富士山</option>
                             <option>白洞虚</option>
                              <option>崔连瑞</option> -->
                        </select>
			        </td>
			    </tr>
			    <tr class="No" style="height: 160px;">
			        <td  colspan="2" style="text-align: center;">
			           <button type="button" class="button_blue_74_33" id="anesthesiaDoctorPopupAddButton" style="border: medium none;margin-top: 40px;">保存</button>
					   <button type="button" class="button_blue_74_33" id="anesthesiaDoctorPopupReturnButton" style="border: medium none;margin-top: 40px;margin-left: 50px;">返回</button>
			        </td>
			    </tr>
	     </table>
      </div>
    </div>
<!-- 手术医生弹出框 -->
<div id="operationDoctorPopup" class="scrollable-area" title="手术医生">
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 260px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">手术人员信息</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">主刀</td>
			       <td  id="operationDoctorMain" style="text-align: left;padding-left: 10px;width:50%;"></td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">一助</td>
			       <td   id="operationDoctorOne" style="text-align: left;padding-left: 10px;width:50%;"></td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">二助</td>
			       <td   id="operationDoctorTwo" style="text-align: left;padding-left: 10px;width:50%;"></td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			       <td  style="text-align: left;padding-left: 10px;width:50%;"></td>
			    </tr>
	     </table>
      
      </div>
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 260px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td  colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">选择手术医生</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;"><td  colspan="2"  style="text-align: center;"><input type="text"  ></td></tr>
			    <tr class="No" style="height: 40px;">
			     <td  style="text-align: center;">
			            <select  id="operationDoctorType" style="width: 100px;">
                             <option value="doctorMain">主刀</option>
                             <option value="doctorOne">一助</option>
                             <option value="doctorTwo">二助</option>
                        </select>
			        </td>
			        <td  style="text-align: center;">
			            <select  id="operationDoctorList"  style="width: 100px;"></select>
			        </td>
			    </tr>
			    <tr class="No" style="height: 79px;">
			        <td  colspan="2" style="text-align: center;">
			           <button type="button" class="button_blue_74_33" id="operationDoctorPopupSaveButton" style="border: medium none;margin-top: 40px;">保存</button>
					   <button type="button" class="button_blue_74_33" id="operationDoctorPopupReturnButton" style="border: medium none;margin-top: 40px;margin-left: 50px;">返回</button>
			        </td>
			    </tr>
	     </table>
      </div>
    </div>
<!-- 巡回护士弹出框 -->
<div id="tourNursePopup" class="scrollable-area" title="巡回护士">
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 220px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">巡回护士信息</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">第一巡回护士</td>
			       <td id="tourNurseOne" style="text-align: left;padding-left: 10px;width:50%;">${sro.instrnurse1 }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">第二巡回护士</td>
			       <td id="tourNurseTwo" style="text-align: left;padding-left: 10px;width:50%;">${sro.instrnurse2 }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			       <td  style="text-align: left;padding-left: 10px;width:50%;"></td>
			    </tr>
	     </table>
      
      </div>
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 220px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td  colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">选择巡回护士</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;"><td  colspan="2"  style="text-align: center;"><input type="text"  ></td></tr>
			    <tr class="No" style="height: 40px;">
			        <td  style="text-align: center;">
			            <select id="tourNurseType" style="width: 140px;">
                             <option value="tourNurseO">第一巡回护士</option>
                             <option value="tourNurseT">第二巡回护士</option>
                        </select>
			        </td>
			        <td  style="text-align: center;">
			            <select id="tourNurseList" style="width: 140px;"></select>
			        </td>
			        
			    </tr>
			    <tr class="No" style="height: 40px;">
			        <td  colspan="2" style="text-align: center;">
			           <button type="button" class="button_blue_74_33" id="tourNursePopupAddButton" style="border: medium none;">保存</button>
					   <button type="button" class="button_blue_74_33" id="tourNursePopupReturnButton" style="border: medium none;margin-left: 50px;">返回</button>
			        </td>
			    </tr>
	     </table>
      </div>
    </div>
<!-- 器械护士弹出框 -->
<div id="instrumentNursePopup" class="scrollable-area" title="器械护士">
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 220px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">器械护士信息</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">第一器械护士</td>
			       <td  id="instrumentNurseOne" style="text-align: left;padding-left: 10px;width:50%;">${sro.circunurse1 }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;">第二器械护士</td>
			       <td  id="instrumentNurseTwo" style="text-align: left;padding-left: 10px;width:50%;">${sro.circunurse2 }</td>
			    </tr>
			    <tr class="No" style="height: 40px;">
			       <td  style="text-align: center;padding-left: 10px;width:50%;"></td>
			       <td  style="text-align: left;padding-left: 10px;width:50%;"></td>
			    </tr>
	     </table>
      
      </div>
      <div style="float:left;width:50%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 220px;">
	        <thead>	
				<tr class="bj" style="height: 50px;"><td  colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">选择器械护士</td></tr>
			</thead>
			    <tr class="No" style="height: 40px;"><td  colspan="2"  style="text-align: center;"><input type="text"  ></td></tr>
			    <tr class="No" style="height: 40px;">
			        <td  style="text-align: center;">
			            <select id="instrumentNurseType" style="width: 140px;">
                             <option value="instrumentNurseO">第一器械护士</option>
                             <option value="instrumentNurseT">第二器械护士</option>
                        </select>
			        </td>
			        <td  style="text-align: center;">
			            <select  id="instrumentNurseList"  style="width: 140px;"> </select>
			        </td>
			        
			    </tr>
			    <tr class="No" style="height: 40px;">
			        <td  colspan="2" style="text-align: center;">
			           <button type="button" class="button_blue_74_33" id="instrumentNursePopupAddButton" style="border: medium none;">保存</button>
					   <button type="button" class="button_blue_74_33" id="instrumentNursePopupReturnButton" style="border: medium none;margin-left: 50px;">返回</button>
			        </td>
			    </tr>
	     </table>
      </div>
    </div>
<!-- 麻醉用药弹出框 -->
<div id="anestheticAgentsPopup" class="scrollable-area" title="麻醉用药">
      <div style="float:left;width:30%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 100px;">
	        <thead>	
				<tr class="bj" style="height: 40px;"><td colspan="3" style="text-align: left;padding-left: 10px;vertical-align: middle;">麻醉用药</td></tr>
			</thead>
			    <tr class="No" style="height: 30px;">
			       <td  colspan="3"  style="text-align: center;padding-left: 10px;">拼音输入查询 :  <input type="text"  style="width: 100px;" onkeyup="medicinePY(this);"></td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  colspan="3" style="text-align: center;padding-left: 10px;"><strong>药品名称（拼音码）</strong></td>
			      
			    </tr>
			    <tr class="No" style="height: 345px;">
			       <td style="text-align: center;">
			          <select id="medicineNameSelectID" size="16" style="width: 280px;font-size: 13px;">
			              <c:forEach items="${smdList}" var="smd" varStatus="status">
								<option class="medicineNameClass" id="${smd.id}" value="${smd.id}" >${smd.name}[${smd.pinyin}]</option>
						  </c:forEach>
			          </select>
			       </td>
			    </tr>
	     </table>
      
      </div>
      <div style="float:left;width:69%;margin-left: 1%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 500px;">
	        <thead>	
				<tr class="bj" style="height: 40px;"><td  colspan="4" style="text-align: left;padding-left: 10px;vertical-align: middle;">给药方案</td></tr>
			</thead>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">药品名称</td>
			       <td  style="text-align: left;width: 35%;">
			       <input type="text" id="medicineName"  readonly="readonly" style="width: 170px;">
			       <input type="hidden" id="medicineID">
			       </td>
			       <td  style="text-align: right;width: 15%;">规格</td>
			       <td  style="text-align: left;width: 35%;"><input type="text" id="medicineSpec"  readonly="readonly" style="width: 170px;"></td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">给药途径</td>
			       <td  style="text-align: left;width: 35%;">
			         	<select  id="medicalTakeWay" style="width: 130px;">
                             <c:forEach items="${smtwList}" var="smtwList">
                                 <option value="${smtwList.code}">${smtwList.name}</option>
				             </c:forEach>
                        </select>
			         <input type="checkbox" id="medicalIsContinued" value="1">&nbsp;持续用药
			       </td>
			       <td  style="text-align: right;width: 15%;">厂家</td>
			       <td  style="text-align: left;width: 35%;"><input type="text" id="medicineFirm"  readonly="readonly" style="width: 170px;"></td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">剂量</td>
			       <td  style="text-align: left;width: 35%;">
			          <input type="text" id="medicineDosage" style="width: 60px;">&nbsp;
			          <input type="text" id="medicineDosageUnit"  readonly="readonly" style="width: 60px;">&nbsp;
			          
			       </td>
			       <td  style="text-align: right;width: 15%;">计价用量</td>
			       <td  style="text-align: left;width: 35%;">
			          <input type="text" id="medicineAmount" disabled style="width: 60px;">&nbsp;&nbsp;
			          计费&nbsp;&nbsp;
			          <select id="medicineIsCharge" disabled  style="width: 75px;">
                       <option value="01" >是</option>
                       <option value="02" selected>否</option>
                   </select>
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">浓度</td>
			       <td  style="text-align: left;width: 35%;">
			          <input type="text" id="medicineThickness" disabled="disabled"  style="width: 60px;">&nbsp;
			          <select id="medicineThicknessUnit" disabled="disabled"  style="width: 75px;">
                        <option value="ml" selected>ml</option>
                        <option value="l" >L</option>
                     </select>
			          <!-- <input type="radio" id="show01">&nbsp;显示 -->
			       </td>
			       <td  style="text-align: right;width: 15%;">开始时间</td>
			       <td  style="text-align: left;width: 35%;">
			          <input type="text" id="medicineStartTime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 170px;">
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">流速</td>
			       <td  colspan="3" style="text-align: left;width: 35%;">
			          <input type="text" id="medicineSpeed" disabled="disabled" style="width: 60px;">&nbsp;
			          <select id="medicineSpeedUnit" disabled="disabled" style="width: 75px;">
                       <option value=""></option>
                       <option value="ml" selected>ml</option>
                       <option value="l" >l</option>
                   </select>
			          <!-- <input type="radio" id="show02">&nbsp;显示 -->
			       </td>
			      
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">选择用药理由</td>
			       <td  colspan="3" style="text-align: left;width: 35%;">
			          <select id="medicineReasonSelect" style="width: 520px;">
                             <option value=""></option>
                             <option value="01">常规用药</option>
                            <option value="02" >特殊用药</option>
                            <option value="03" >血压偏高</option>
                            <option value="04" >心率缓慢</option>
                        </select>
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 15%;">给药理由</td>
			       <td  colspan="3" style="text-align: left;width: 35%;">
			         <input type="text"  id="medicineReason" style="width: 505px;">
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td  colspan="4" style="text-align: center;">
			        <button  type="button" id="anestheticAgentsPopupAddButton" class="button_blue_74_33" style="border: medium none;" onclick="addMedEvent()">使用药品</button>
			        <button type="button" id="anestheticAgentsPopupSaveButton" class="button_blue_74_33" style="border: medium none;">保存</button>
			        <button type="button" id="anestheticAgentsPopupCloseButton" class="button_blue_74_33" style="border: medium none;">关闭</button>
			       </td>
			       
			    </tr>
			    
	     </table>
      </div>
    </div>

<!-- 结束弹出框 -->
	<div id="endPopup" class="scrollable-area" title="结束">
	     <table class="table table-bordered table-striped header-spcing">
	        <thead>	
				<tr class="bj"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">结束信息</td></tr>
			</thead>
			  <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					结束时间：
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					<input id="operationEndtime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 26px;border-radius: 3px;"/>
                  </td>
              </tr>
			  <tr class="No">
			      <td  colspan="2" style="text-align: center;">
					<button type="button" class="button_blue_74_33" id="endPopupConfirmButton" style="border: medium none;margin-left: 30px;">确定</button>
					<button type="button" class="button_blue_74_33" id="endPopupCloseButton"  style="border: medium none;margin-left: 30px;">返回</button>
                  </td>
              </tr>
	     </table>
    </div>


<!-- 手术事件弹出框 -->
	<div id="operationEventPopup" class="scrollable-area" title="手术事件">
	     <table class="table table-bordered table-striped header-spcing">
	        <thead>	
				<tr class="bj"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">手术事件信息</td></tr>
			</thead>
			   <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					标题：
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					<input id="operationEventTitle" maxlength="100" style="width: 307px;"/>
                  </td>
              </tr>
              <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					内容：
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					<textarea id="operationEventContent" maxlength="500" style="resize: none;width: 300px;height: 240px;"></textarea>
                  </td>
              </tr>
			  <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					时间：
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					<input id="operationEventtime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 26px;border-radius: 3px;"/>
                  </td>
              </tr>
			  <tr class="No">
			      <td  colspan="2" style="text-align: center;">
					<button type="button" class="button_blue_74_33" id="operationEventPopupConfirmButton" style="border: medium none;margin-left: 30px;">确定</button>
					<button type="button" class="button_blue_74_33" id="operationEventPopupCloseButton"  style="border: medium none;margin-left: 30px;">返回</button>
                  </td>
              </tr>
	     </table>
    </div>



<!-- 呼吸事件弹出框 -->
	<div id="breathEventPopup" class="scrollable-area" title="呼吸事件">
	     <table class="table table-bordered table-striped header-spcing">
	        <thead>	
				<tr class="bj"><td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">呼吸事件信息</td></tr>
			</thead>
			   <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					<input class="breathFlag" type="radio" name="breathEvent.flag" value="01"/>
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
				        自主呼吸
                  </td>
              </tr>
              <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					<input class="breathFlag" type="radio" name="breathEvent.flag" value="02"/>
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					辅助呼吸
                  </td>
              </tr>
              <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					<input class="breathFlag" type="radio" name="breathEvent.flag" value="03"/>
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					控制呼吸
                  </td>
              </tr>
			  <tr class="No">
			      <td  style="text-align: right;padding-left: 10px;">
					时间：
                  </td>
			      <td  style="text-align: left;padding-left: 10px;">
					<input id="breathEventtime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 26px;border-radius: 3px;"/>
                  </td>
              </tr>
			  <tr class="No">
			      <td  colspan="2" style="text-align: center;">
					<button type="button" class="button_blue_74_33" id="breathEventPopupConfirmButton" style="border: medium none;margin-left: 30px;">确定</button>
					<button type="button" class="button_blue_74_33" id="breathEventPopupCloseButton"  style="border: medium none;margin-left: 30px;">返回</button>
                  </td>
              </tr>
	     </table>
    </div>			


<!-- 麻醉事件弹出框 -->
<div id="anesthesiaEventPopup" class="scrollable-area" title="麻醉事件">
      <div style="float:left;width:100%;">
	     <table id="anesEventList" class="table table-bordered table-striped header-spcing" style="height: 300px;">
	     <tbody>
	     	<tr class="No" style="height: 100px;">
			       <td style="text-align: center;padding-left: 10px;">
			          <select id="anesthesiaEventSelect" size="10" style="width: 250px;heigth: 30px;font-size: 20px;">
			          </select>
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td style="text-align: center;padding-left: 10px;">
			          <input id="anesthesiaEventTime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 26px;border-radius: 3px;"/>
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td style="text-align: center;padding-left: 10px;">
			         <button  type="button" id="anesEventPopupConfirmButton" class="button_blue_74_33" style="border: medium none;" onclick="addAnesthEvent()">确定</button>
			        <button type="button" id="anesEventPopupCloseButton" class="button_blue_74_33" style="border: medium none;">关闭</button>
			       </td>
			    </tr>
	     </tbody>
	     </table>
      </div>
    </div>	 
    
<!-- 液体出量弹出框 -->
<div id="outputLiquidPopup" class="scrollable-area" title="出量">
      <div style="float:left;width:30%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 40px;">
	        <thead>	
				<tr class="bj" style="height:40px;"><td colspan="3" style="height:40px; text-align: left;padding-left: 10px;vertical-align: middle;">液体出量</td></tr>
			</thead>
				<tr class="No" style="height: 100px;">
			       <td style="text-align: center;padding-left: 10px;">
			          <select id="outLiquid" size="10" style="width: 250px;heigth: 30px;font-size: 20px;"></select>
			       </td>
			    </tr>
	     </table>

      
      </div>
      <div style="float:left;width:69%;margin-left: 1%;">
	     <table id="outputList" class="table table-bordered table-striped header-spcing" style="height: 100px;">
	        <thead>	
				<tr class="bj" style="height: 40px;">
				<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;"></td>
				<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 45%;">液体名称</td>
				<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 10%;">容量</td>
				<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 10%;">单位</td>
				<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 30%;">开始时间</td>
				</tr>
			</thead>
			<tbody id="outputListTableTbody"></tbody>
	     </table>

      </div>
       <div style="margin-top:5%;">
       	     <table class="table table-bordered table-striped header-spcing" style="height: 80px;">
	          <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 10%;">液体名称</td>
			       <td  style="text-align: left;width: 30%;">
			            <input type="text" id="outputLiquidName" readonly="readonly">
			            <input type="hidden" id="outputLiquidID">
			       </td>
			       <td  style="text-align: right;width: 10%;">容量</td>
			       <td  style="text-align: left;width: 20%;">
			          <input id="outPutDosage"  name="smie.dosage" type="text" style="width: 50px;text-align: right;">
           		           <select id="outPutDosageUnit" name="smie.dosageUnit" style="width: 70px;text-align: right;">
                             <option value="ml" selected="selected" >ml </option>
                             <option value="l">L </option>
                           </select>
			       </td>

			       <td  style="text-align: right;width: 10%;">时间</td>
			       <td  style="text-align: left;width: 20%;">
			          <input id="outPutTime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="height: 26px;border-radius: 3px;"/>

			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td colspan="6"  style="text-align: center;">
			        <button  type="button" id="outputLiquidPopupConfirmButton" class="button_blue_74_33" style="border: medium none;" onclick="addOutPutEvent()">添加出量</button>
			        <button  type="button" id="outputLiquidPopupDeleteButton" class="button_blue_74_33" style="border: medium none;" onclick="deleteOutPutEvent()">删除出量</button>
			        <button type="button" id="outputLiquidPopupSaveButton" class="button_blue_74_33" style="border: medium none;">保存</button>
			        <button type="button" id="outputLiquidPopupCloseButton" class="button_blue_74_33" style="border: medium none;">关闭</button>
			       </td>
			    </tr>
	     </table>
       </div>
    </div>




<!-- 液体入量弹出框 -->
<div id="inputLiquidPopup" class="scrollable-area" title="入量">
      <div style="float:left;width:30%;">
	     <table class="table table-bordered table-striped header-spcing" style="height: 40px;">
	        <thead>	
				<tr class="bj" style="height:40px;"><td colspan="3" style="height:40px; text-align: left;padding-left: 10px;vertical-align: middle;">液体入量</td></tr>
			</thead>
				<tr class="No" style="height: 50px;">
			       <td style="text-align: center;padding-left: 10px;">
			          <select  style="width: 250px;heigth: 30px;font-size: 15px;">
			              <option class="inputP" value="BLOOD">全血</option>
                          <option class="inputP" value="COMPONENTBLOOD">成分输血</option>
                          <option class="inputP" value="COLLOID">代血浆</option>
                          <option class="inputP" value="CRYSTAL">晶体液</option>
                          <option class="inputP" value="OTHER">其它</option>
			          </select>
			       </td>
			    </tr>
				<tr class="No" style="height: 100px;">
			       <td style="text-align: left;padding-left: 10px;">
			          <select id="inLiquid" size="10" style="width: 260px;heigth: 30px;font-size: 15px;">
			          </select>
			       </td>
			    </tr>
	     </table>

      
      </div>
      <div style="float:left;width:69%;margin-left: 1%;overflow :auto;">
			<div style="width:1000px; height:380px;overflow :auto;">
				<table id="inputList" class="table table-bordered table-striped header-spcing"
					style="height: 30px;">
					<thead>
						<tr class="bj" style="height: 30px;">
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;"></td>
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 35%;">液体名称</td>
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;">规格</td>
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 20%;">厂家</td>
							<!-- <td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 10%;">液体类型</td> -->
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;">结束</td>
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;">容量</td>
							<!-- <td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 10%;">计价用量</td> -->
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;">单位</td>
							<!-- <td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 5%;">收费</td> -->
							<td style="text-align: center;padding-left: 10px;vertical-align: middle;width: 20%;">时间</td>
						</tr>
					</thead>
					<tbody id="inputListTableTbody"></tbody>
				</table>
			</div>


		</div>
       <div style="margin-top:5%;">
       	     <table class="table table-bordered table-striped header-spcing" style="height: 80px;">
	          <tr class="No" style="height: 30px;">
			       <td  style="text-align: right;width: 8%;">名称</td>
			       <td  style="text-align: left;width: 20%;">
			            <input type="text" id="inPutName" readonly="readonly" style="width: 150px;">
			            <input type="hidden" id="inPutID">
			       </td>
			       <td  style="text-align: right;width: 8%;">容量</td>
			       <td  style="text-align: left;width: 17%;">
			          <input id="inPutDosage"  type="text" style="width: 50px;text-align: right;">
           		           <select id="inPutDosageUnit" style="width: 70px;text-align: right;">
                             <option value="ml" selected="selected" >ml </option>
                             <option value="l">L </option>
                           </select>
			       </td>
			       <td  style="text-align: right;width: 10%;">开始时间</td>
			       <td  style="text-align: left;width: 20%;">
			          <input id="inPutTime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 150px;border-radius: 3px;"/>
			       </td>
			       <td  style="text-align: right;width: 8%;">单价</td>
			       <td  style="text-align: left;width: 10%;">
			          <!-- <input type="text" style="width: 80px;"/> -->
			       </td>
			    </tr>
	          <tr class="No" style="height: 30px;"> 
			       <td  style="text-align: right;width: 8%;">规格</td>
			       <td  style="text-align: left;width: 20%;">
			            <input type="text" id="inPutSpec"  style="width: 150px;">
			       </td>
			       <td  style="text-align: right;width: 8%;">厂家</td>
			       <td  style="text-align: left;width: 17%;">
           		          <input type="text" id="inPutFirm"  style="width: 150px;">
			       </td>
			       <td  style="text-align: right;width: 10%;">计价用量</td>
			       <td  style="text-align: left;width: 20%;">
			         <!-- <input type="text" style="width: 140px;"/> -->
			       </td>
			       <td  style="text-align: right;width: 8%;">计费</td>
			       <td  style="text-align: left;width: 10%;">
			         <!--  <select id=""  style="width: 90px;text-align: right;" >
                             <option value="00"></option>
                             <option value="01">是</option>
                             <option value="02">否</option>
                      </select> -->
			       </td>
			    </tr>
			    <tr class="No" style="height: 30px;">
			       <td colspan="8"  style="text-align: center;">
			        <button  type="button" id="inPutPopupConfirmButton" class="button_blue_74_33" style="border: medium none;" onclick="addInPutEvent()">添加出量</button>
			        <button  type="button" id="inPutPopupDeleteButton" class="button_blue_74_33" style="border: medium none;" onclick="deleteInPutEvent()">删除出量</button>
			        <!-- <button type="button" id="inPutPopupSaveButton" class="button_blue_74_33" style="border: medium none;">保存</button> -->
			        <button type="button" id="inPutPopupCloseButton" class="button_blue_74_33" style="border: medium none;">关闭</button>
			       </td>
			    </tr>
	     </table>
       </div>
    </div>








	<!-- 麻醉用药右键弹出框 -->
	<div id="medRightPopup" class="scrollable-area" title="麻醉用药操作">
		<table class="table table-bordered table-striped header-spcing">
			<tr class="No">
				<td style="text-align: center;">
					<button type="button" class="button_blue_74_33"
						id="medPopupStopButton"
						style="border: medium none;">停止</button></td>
			</tr>
			<tr class="No">
				<td style="text-align: center;">
					<button type="button" class="button_blue_74_33"
						id="medPopupDeleteButton"
						style="border: medium none;">删除</button></td>
			</tr>
		</table>
	</div>



	<!-- 麻醉事件右键弹出框 -->
	<div id="anasRightPopup" class="scrollable-area" title="麻醉事件操作">
		<table class="table table-bordered table-striped header-spcing">
			<tr class="No">
				<td style="text-align: center;">
					<button type="button" class="button_blue_74_33"
						id="anasPopupDeleteButton"
						style="border: medium none;">删除</button></td>
			</tr>
		</table>
	</div>


















</body>
</html>
