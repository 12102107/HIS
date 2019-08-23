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
<title>麻醉恢复室记录</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
	<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.min.css" type="text/css"></link>
<style type="text/css">
    .td1{
        border: solid 1px #1CAAD1 ;
        font-size:18px;
        width:150px;
    }
    .td2{
        border: solid 1px #1CAAD1 ;
        width:50px;
        text-align: center;
    }
    .td3{
        border: solid 1px #1CAAD1 ;
        width:50px;
    }
    .input1{
        width: 50px;
        height: 25px;
        display: true;
    }
</style>
<script type="text/javascript">
CreateReport("Report");
function printN() {
	Report.LoadFromURL("../jsp/sm/recovery/recovery.grf");
	AjaxSyncLoadReportData(Report,"recoveryPrint.action?id="+$("#ylws").val());
	Report.PrintPreview(true);
}
function printRecord() {
	alert('打印');
}

function back() {
		window.location.href="../ylws/ylwsList.action?functionid="+$('#functionid').val();
}

$(function(){
	$("#score").val(""+(parseInt($(".sober").val().replace(/[^0-9]+/g, ''))+parseInt($(".breathing").val().replace(/[^0-9]+/g, ''))+parseInt($(".physical").val().replace(/[^0-9]+/g, '')))+"分");
	
	$(".sober,.breathing,.physical").change(function(){
		$("#score").val(""+(parseInt($(".sober").val().replace(/[^0-9]+/g, ''))+parseInt($(".breathing").val().replace(/[^0-9]+/g, ''))+parseInt($(".physical").val().replace(/[^0-9]+/g, '')))+"分");
	});
	
});
 
</script>

</head>
<body class="page-header-fixed">
              <%  String userId = (String)request.getSession().getAttribute("userid"); %>
              <input type="hidden" id="userId"  value="<%=userId%>">
<input id="functionid" type="hidden" value="${functionid }">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉恢复室记录</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
		

						<form id="record">
						<input id="ylws" type="hidden" name="record.operationId" value="${ylwsid }">
						<input type="hidden" name="record.id" value="${record.id }">
						
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="6" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								基本信息
								</td>
							</tr>
						</thead>	
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;">
									姓名：<input type="text"  value="${sro.name }" disabled="disabled" >
									<input type="hidden" id="roomCode" name="sro.room" value="${sro.room }">
								</td>
								<td style="text-align: left;padding-left: 10px;">
									姓别： <input type="radio" style="vertical-align: baseline;" disabled="disabled" <c:if test="${sro.sex eq 0 }">checked</c:if>>男 
										 <input type="radio" style="vertical-align: baseline;" disabled="disabled" <c:if test="${sro.sex eq 1 }">checked</c:if>>女
								</td>
								<td style="text-align: left;padding-left: 10px;">
									年龄：<input type="text" value="${sro.age }岁" disabled="disabled" >
								</td>
								<td style="text-align: left;padding-left: 10px;">
									病区：<input type="text"  value="${sro.region }" disabled="disabled" >
								</td>
								<td >
									床号：<input type="text"  value="${sro.bed }" disabled="disabled" >
								</td>
								<td style="text-align: left;padding-left: 10px;">
									住院号：<input type="text" value="${sro.hid }" disabled="disabled" >
								</td>
							</tr>
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									诊断名称：<input type="text"  value="${sro.diagnosisName }" disabled="disabled" style="width: 500px;">
								</td>
								<td colspan="3" style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									手术名称：<input type="text"  value="${sro.designedOptName }" disabled="disabled" style="width: 500px;">
								</td>
							</tr>
							<tr class="No">
								<td colspan="2" style="text-align: left;padding-left: 10px;">
									麻醉医生：<input type="text"  value="${sro.anesthetist }" disabled="disabled" >
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									麻醉方法：<input type="text"  value="${sro.designedAnaesMethodName }" disabled="disabled" >
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									巡回护士：<input type="text"  value="${sro.instrnurse1 }  ${sro.instrnurse1 }" disabled="disabled" >
								</td>
							</tr>
						</table>
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="6" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								恢复记录
								</td>
							</tr>
						</thead>	
						
						<tr class="No">
								<td style="text-align: center;padding-left: 10px;">
						           <button  type="button" id="startId" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;">开始</button>
						           <button  type="button" id="startRecordId" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="startRecord()">开始记录</button>
						           <button  type="button" id="stopCollectDateId" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="stopCollectDate()">结束记录</button>
						           <button  type="button" id="endId" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;"> 结束</button>
						           <button type="button"  id="saveId" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="saveRecord()">保存</button>
						           <button type="button"  id="printId" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="printN()">打印</button>
						           <button type="button" class="button_blue_74_33"  style="border: medium none;margin-left: 30px;" onclick="back()">返回</button>
								</td>
						</tr>
						</table>
	<div style=" width: 100%;height: 350px;border: solid 3px #1CAAD1; ">
    <div style="z-index:2;position: absolute; width: 9.6%;height: 350px; border: solid 0px #1CAAD1; ">
        <table cellspacing="0" style="width: 100%;border: solid 1px #1CAAD1;">
            <tr style="height: 50px"><td id ="nowDate1" style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">时间</td></tr>
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1; ">血压 (mmHg)</td></tr>
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">心率 (bmp)</td></tr>
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">呼吸 (bmp)</td></tr>
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">血氧 (%)</td></tr>
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">备注</td></tr>
        <!--     <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">其他</td></tr>
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;color:#1CAAD1;">
            <button type="button" onclick="bbb111();">←</button>
            </td></tr>
            <tr style="height: 50px;border: solid  1px #1CAAD1;"><td style="border: solid  1px #1CAAD1;font-size:20px;text-align: center;">
            <button type="button" onclick="aaa111();">→</button>
            </td></tr> -->
            <tr style="height: 50px"><td style="border: solid  1px #1CAAD1; font-size:20px;text-align: center;"></td></tr>
        </table>

    </div>
    <div  id="div1" style="z-index:1;position: absolute; width: 90%;height: 350px;left:10.2%; border: solid 0px #1CAAD1;  overflow:auto; ">
        <table border="1" cellspacing="0" style="width: 100%">
            <tbody id="tbodyId"></tbody>
        </table>


    </div>

</div>
						<table class="table table-bordered table-striped header-spcing">
						<thead>	
							<tr class="bj">
								<td colspan="6" style="text-align: left;padding-left: 10px;vertical-align: middle;">
								恢复小结
								</td>
							</tr>
						</thead>	
							<tr class="No">
								<td colspan="2" style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									入PACU时间：
									<input id="getin" size="22" class="Wdate" disabled="disabled" value='<fmt:formatDate value="${record.enterTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="record.enterTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'getout\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									出PACU时间：
									<input id="getout" size="22" class="Wdate" disabled="disabled" value='<fmt:formatDate value="${record.exitTime }" pattern="yyyy-MM-dd HH:mm:ss"/>' name="record.exitTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'getin\')}'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">	
								    <input type="hidden" name="record.wsid" value="${sro.room }">
								    <input type="hidden" id="stateId" name="state" value="${record.state }">
								    <input type="hidden" id="remarkIntervalId" name="remarkInterval" value="${record.remarkInterval }">
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									出恢复室Steward评分：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									清醒程度：
									<select name="record.soberScore" class="sober">
										<option value="完全苏醒 2分" <c:if test="${record.soberScore eq '完全苏醒 2分'}">selected</c:if>>完全苏醒 2分</option>
										<option value="对刺激有反应 1分" <c:if test="${record.soberScore eq '对刺激有反应 1分'}">selected</c:if>>对刺激有反应 1分</option>
										<option value="对刺激无反应 0分" <c:if test="${record.soberScore eq '对刺激无反应 0分'}">selected</c:if>>对刺激无反应 0分</option>
									</select>&nbsp;&nbsp;&nbsp;
									呼吸道畅通程度：
									<select name="record.breathingScore" class="breathing">
										<option value="可按医师吩咐咳嗽 2分" <c:if test="${record.breathingScore eq '可按医师吩咐咳嗽 2分'}">selected</c:if>>可按医师吩咐咳嗽 2分</option>
										<option value="不用支持可以维持呼吸道通畅 1分" <c:if test="${record.breathingScore eq '不用支持可以维持呼吸道通畅 1分'}">selected</c:if>>不用支持可以维持呼吸道通畅 1分</option>
										<option value="呼吸道需要予以支持 0分" <c:if test="${record.breathingScore eq '呼吸道需要予以支持 0分'}">selected</c:if>>呼吸道需要予以支持 0分</option>
									</select>&nbsp;&nbsp;&nbsp;
									肢体活动度：
									<select name="record.physicalActivityScore" class="physical">
										<option value="肢体能作有意识的活动 2分" <c:if test="${record.physicalActivityScore eq '肢体能作有意识的活动 2分'}">selected</c:if>>肢体能作有意识的活动 2分</option>
										<option value="肢体无意识活动 1分" <c:if test="${record.physicalActivityScore eq '肢体无意识活动 1分'}">selected</c:if>>肢体无意识活动 1分</option>
										<option value="肢体无活动 0分" <c:if test="${record.physicalActivityScore eq '肢体无活动 0分'}">selected</c:if>>肢体无活动 0分</option>
									</select>
								</td>
								<td>
									总评分：<input id="score" type="text" name="record.totalScore" value="${record.totalScore }" readonly="readonly" >
								</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									随身管道：&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="输液管道" <c:if test="${fn:contains(record.portablePipe,'输液管道')}">checked</c:if> style="vertical-align: baseline;">
									输液管道&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="胃管" <c:if test="${fn:contains(record.portablePipe,'胃管')}">checked</c:if> style="vertical-align: baseline;">
									胃管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="尿管" <c:if test="${fn:contains(record.portablePipe,'尿管')}">checked</c:if> style="vertical-align: baseline;">
									尿管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="胸腔闭式引流管" <c:if test="${fn:contains(record.portablePipe,'胸腔闭式引流管')}">checked</c:if> style="vertical-align: baseline;">
									胸腔闭式引流管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="腹腔引流管" <c:if test="${fn:contains(record.portablePipe,'腹腔引流管')}">checked</c:if> style="vertical-align: baseline;">
									腹腔引流管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="创腔引流管" <c:if test="${fn:contains(record.portablePipe,'创腔引流管')}">checked</c:if> style="vertical-align: baseline;">
									创腔引流管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="口咽管" <c:if test="${fn:contains(record.portablePipe,'口咽管')}">checked</c:if> style="vertical-align: baseline;">
									口咽管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="鼻咽管" <c:if test="${fn:contains(record.portablePipe,'鼻咽管')}">checked</c:if> style="vertical-align: baseline;">
									鼻咽管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="气管插管" <c:if test="${fn:contains(record.portablePipe,'气管插管')}">checked</c:if> style="vertical-align: baseline;">
									气管插管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="气管切开" <c:if test="${fn:contains(record.portablePipe,'气管切开')}">checked</c:if> style="vertical-align: baseline;">
									气管切开&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="record.portablePipe" value="镇痛泵" <c:if test="${fn:contains(record.portablePipe,'镇痛泵')}">checked</c:if> style="vertical-align: baseline;">
									镇痛泵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									其他：<input type="text" name="record.portablePipeOther" value="${record.portablePipeOther }"  >
								</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: left;padding-left: 10px;"style="text-align: left;padding-left: 10px;">
									出室后去向：&nbsp;&nbsp;&nbsp;
									<input type="radio" name="record.destination" value="原病房" <c:if test="${record.destination eq '原病房'  }">checked</c:if> style="vertical-align: baseline;">
									原病房&nbsp;&nbsp;&nbsp;
									<input type="radio" name="record.destination" value="重症监护室" <c:if test="${record.destination eq '重症监护室' }">checked</c:if> style="vertical-align: baseline;">
									重症监护室&nbsp;&nbsp;&nbsp;
									<input type="radio" name="record.destination" value="中心ICU" <c:if test="${record.destination eq '中心ICU' }">checked</c:if> style="vertical-align: baseline;">
									中心ICU &nbsp;&nbsp;&nbsp;
									<input type="radio" name="record.destination" value="离院" <c:if test="${record.destination eq '离院' }">checked</c:if> style="vertical-align: baseline;">
									离院&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						</table>
						</form>
<!-- 						<div style="text-align: center; margin-top: 2%;margin-bottom: 20px;">

						</div> -->
					</div>
				</div>
			</div>
<div id="dialog" title="开始采集">
    采集间隔：
    <select name="collectInterval" id="collectInterval" style="width:170px;height: 30px;">
        <option value="1" style="height: 25px;">1分钟 </option>
        <option value="5" style="height: 25px;">5分钟 </option>
        <option value="10" style="height: 25px;">10分钟 </option>
        <option value="15" style="height: 25px;">15分钟 </option>
    </select>
    <hr style="color: white;">
    入室时间：
    <input id="recoveryStarttime" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:170px;height: 25px"/>
   </div>
<div id="dialog1" title="结束设置">
    出室时间：
    <input id="recoveryEndtime" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:170px;height: 25px"/>
   </div>	
<script type="text/javascript">
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var realPath=localhostPaht+projectName;
 $(function() {
            $( "#dialog" ).dialog({
                autoOpen: false,
                modal: true,
                buttons: {
                    确定: function() {
                       
                          var collectInterval = $("#collectInterval  option:selected").val();
                          var operationId = document.getElementById("ylws").value;
                          var recoveryStarttime = document.getElementById("recoveryStarttime").value;  
                          if(!recoveryStarttime){
                          alert('请填写时间');
                          }else{
                           $( this ).dialog( "close" );
                           document.getElementById("getin").value=recoveryStarttime; 
                          startButtonNotUse(true,'LightSteelBlue');
                          startRecordButtonNotUse(false,'#1CAAD1');  
                          saveButtonNotUse(false,'#1CAAD1');  
                          startZheng(collectInterval,operationId,recoveryStarttime); 
                          createRecovery(recoveryStarttime,collectInterval); 
                          } 
                    
                    },
                    取消:function(){
                        $( this ).dialog( "close" );
                    }
                }
            });
            $( "#startId" ).click(function() {
                $( "#dialog" ).dialog( "open" );
            });
            
          $( "#dialog1" ).dialog({
                autoOpen: false,
                modal: true,
                buttons: {
                    确定: function() {
                    var recoveryEndtime = document.getElementById("recoveryEndtime").value; 
                    var getin = document.getElementById("getin").value; 
                    var end =  recoveryEndtime.replace(/-/g,"/");
                    var start =  getin.replace(/-/g,"/");
                    var startTimes = new Date(start);
                    var endTimes = new Date(end);
                    if(!recoveryEndtime){
                    alert('请填写时间!');
                    }else{
                       if(endTimes<startTimes){
                       alert('结束时间应大于开始时间！');
                       }else{
                           $( this ).dialog( "close" );
                           document.getElementById("getout").value=recoveryEndtime;   
                           stop(recoveryEndtime);
                        }

                    }
                        
                                             
                    },
                    取消:function(){
                        $( this ).dialog( "close" );
                    }
                }
            });
            $( "#endId" ).click(function() {
                $( "#dialog1" ).dialog( "open" );
            });
            
            
           
        });
			//出量动态创建表格
			var row = 6;
			var cos = 120;
    window.onload=function(){
        for(var j = 0; j < row; j++) {
            var trName = "tr"+j;
            trName = document.createElement("tr");
            trName.style.width = "1200px";
            trName.style.height = "50px";
            document.getElementById("tbodyId").appendChild(trName);
            for(var i = 0; i < cos; i++){
                var idName = "tr"+j+"td"+i;
                if(j==0){

                    var tdName = "td"+i;
                    tdName = document.createElement("td");
                    tdName.className="td1";
                    tdName.id=idName;
                    tdName.colSpan = "3";
                    trName.appendChild(tdName);
                    if(i==39){
                        break;
                    }
                }
                if(j>0&&j<5){
                    var tdName = "td"+i;
                    tdName = document.createElement("td");
                    tdName.className="td2";
                    tdName.id=idName;
                    //tdName.innerText = idName;
                    trName.appendChild(tdName);
                }
                if(j>4){
                    var tdName = "td"+i;
                    tdName = document.createElement("td");
                    tdName.className="td3";
                    tdName.id=idName;
                    trName.appendChild(tdName);
                    var inputName = "input"+i;
                    inputName = document.createElement("input");
                    inputName.type="text";
                    inputName.className="input1";
                    inputName.disabled="disabled";
                    tdName.appendChild(inputName);
                }

            }

        }
        var state = document.getElementById("stateId").value;
        if(state){
           if(state=='02'){
              startButtonNotUse(true,'LightSteelBlue');
              startRecordButtonNotUse(true,'LightSteelBlue');
              stopCollectDateButtonNotUse(true,'LightSteelBlue');
              endButtonNotUse(true,'LightSteelBlue');
              var operationId = document.getElementById("ylws").value;
              var remarkInterval = document.getElementById("remarkIntervalId").value;
              var getin = document.getElementById("getin").value;
              loadRecoveryData();
              startZheng1(remarkInterval,operationId,getin);
           }
        }else{
        startRecordButtonNotUse(true,'LightSteelBlue');
        stopCollectDateButtonNotUse(true,'LightSteelBlue');
        endButtonNotUse(true,'LightSteelBlue');
        saveButtonNotUse(true,'LightSteelBlue');
        printButtonNotUse(true,'LightSteelBlue');
        }
        

    };
    var a=100;
    function aaa111(){
        document.getElementById('div1').scrollLeft=a;
        a+=100;
    }
    var b=100;
    function bbb111(){
        document.getElementById('div1').scrollLeft=b;

        if(b<0){
            b=0;
        }else{
            b-=100;
        }
    }

var startTime=null;    //开始时间
var interval = null;   //采集间隔
    
/** 	 
 * @功能描述:保存
 * @参数: 
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function saveRecord() {
    printButtonNotUse(false,'#1CAAD1');
	$.post("saveRecovery.action",$("#record").serialize(),function(){
		alert('保存成功！');
	});
}

/** 	 
 * @功能描述:开始
 * @参数: collectInterval,operationId,recoveryStarttime
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startZheng(collectInterval,operationId,recoveryStarttime){
	startTime =  recoveryStarttime.replace(/-/g,"/");
	interval=collectInterval;
    var recoveryStartTimes = new Date(startTime);
    var  nowYear = recoveryStartTimes.getFullYear();
    var  nowMonth = recoveryStartTimes.getMonth()+1;
    var  nowDay = recoveryStartTimes.getDate();
    document.getElementById("nowDate1").innerHTML = nowYear+"-"+nowMonth+"-"+nowDay;
      for(var i=0;i<40;i++){
         var tdId = "tr0td"+i;
          document.getElementById(tdId).innerHTML = recoveryStartTimes.getHours()+":"+recoveryStartTimes.getMinutes();
          recoveryStartTimes.setMinutes(recoveryStartTimes.getMinutes() + collectInterval*3, recoveryStartTimes.getSeconds(), 0);
      }
      generateData();
      setInterval(generateData,60000);
}

/** 	 
 * @功能描述:加载时间
 * @参数: collectInterval,operationId,recoveryStarttime
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startZheng1(collectInterval,operationId,recoveryStarttime){
	startTime =  recoveryStarttime.replace(/-/g,"/");
	interval=collectInterval;
    var recoveryStartTimes = new Date(startTime);
    var  nowYear = recoveryStartTimes.getFullYear();
    var  nowMonth = recoveryStartTimes.getMonth()+1;
    var  nowDay = recoveryStartTimes.getDate();
    document.getElementById("nowDate1").innerHTML = nowYear+"-"+nowMonth+"-"+nowDay;
      for(var i=0;i<40;i++){
         var tdId = "tr0td"+i;
          document.getElementById(tdId).innerHTML = recoveryStartTimes.getHours()+":"+recoveryStartTimes.getMinutes();
          recoveryStartTimes.setMinutes(recoveryStartTimes.getMinutes() + collectInterval*3, recoveryStartTimes.getSeconds(), 0);
      }
}

/** 	 
 * @功能描述:开始记录
 * @参数: 
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startRecord(){
   var interval1= interval*60*1000;
   addStartCollectTime();
   loadCollectDate();
   startRecordTimer = setInterval(loadCollectDate,interval1);
   startRecordButtonNotUse(true,'LightSteelBlue');
   stopCollectDateButtonNotUse(false,'#1CAAD1');
   endButtonNotUse(false,'#1CAAD1');
}

/** 	 
 * @功能描述:获取采集数据
 * @参数: 
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
var times = -1;
function loadCollectDate(){
    var operationId = document.getElementById("ylws").value;
    var roomCode = document.getElementById("roomCode").value;
    var params ={roomCode:roomCode,operationId:operationId};
    $.post(
    realPath+"/recovery/getCollectDate.action",
    params,
    function generate(data){  
            json = data;  
            collectData = eval('(' + json + ')');   
            var bptdId = "tr1td"+collectData.POINT;
            document.getElementById(bptdId).innerHTML = collectData.BP_SYS+' / '+collectData.BP_DIAS;
            var hrtdId = "tr2td"+collectData.POINT;
            document.getElementById(hrtdId).innerHTML = collectData.HEARTRATE;
            var rrtdId = "tr3td"+collectData.POINT;
            document.getElementById(rrtdId).innerHTML = collectData.RESPRATE;
            var rr = Number(collectData.RR);
            if(rr<15){
                $("#"+rrtdId).attr('style','color:red');
            }
            var spo2tdId = "tr4td"+collectData.POINT;
            document.getElementById(spo2tdId).innerHTML = collectData.SPO2;
            
    });
    times++;

}

/** 	 
 * @功能描述:开始按钮是否可用   不可用COLOR:LightSteelBlue  可用COLOR:#1CAAD1
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("startId").disabled=trueOrfalse;
     document.getElementById("startId").style.background=buttonColor;        
}

/** 	 
 * @功能描述:开始记录按钮是否可用
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function startRecordButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("startRecordId").disabled=trueOrfalse;
     document.getElementById("startRecordId").style.background=buttonColor;
}

/** 	 
 * @功能描述:结束记录按钮是否可用
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function stopCollectDateButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("stopCollectDateId").disabled=trueOrfalse;
     document.getElementById("stopCollectDateId").style.background=buttonColor;
}

/** 	 
 * @功能描述:结束按钮是否可用
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function endButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("endId").disabled=trueOrfalse;
     document.getElementById("endId").style.background=buttonColor;
}

/** 	 
 * @功能描述:保存按钮是否可用
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function saveButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("saveId").disabled=trueOrfalse;
     document.getElementById("saveId").style.background=buttonColor;
}

/** 	 
 * @功能描述:打印按钮是否可用
 * @参数: trueOrfalse,buttonColor
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function printButtonNotUse(trueOrfalse,buttonColor){
     document.getElementById("printId").disabled=trueOrfalse;
     document.getElementById("printId").style.background=buttonColor;
}

/** 	 
 * @功能描述:动态生成生命体征信息 
 * @参数:
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function generateData(){
    var roomCode = document.getElementById("roomCode").value;
    var params ={roomCode:roomCode};
    $.post(
    realPath+"/recovery/generateData.action",
    params,
    function generate(data){   
                    
    });
}

/** 	 
 * @功能描述:创建恢复室记录单
 * @参数: startTime,collectInterval
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */ 
function createRecovery(startTime,collectInterval){
   var operationId = document.getElementById("ylws").value;
   var userId = document.getElementById("userId").value;
   var params ={operationId:operationId,startTime:startTime,collectInterval:collectInterval,userId:userId};
    $.post(
    realPath+"/recovery/createRecovery.action",
    params,
    function generate(data){   
                    
    });
}

/** 	 
 * @功能描述:添加开始记录时间
 * @参数: 
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function addStartCollectTime(){
 var operationId = document.getElementById("ylws").value;
 var params ={operationId:operationId};
 $.post( realPath+"/recovery/addMonitorStartTime.action",params);
}

/** 	 
 * @功能描述:结束采集
 * @参数: 
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function stopCollectDate(){
    clearInterval(startRecordTimer);
    stopCollectDateButtonNotUse(true,'LightSteelBlue');
    var operationId = document.getElementById("ylws").value;
    var params ={operationId:operationId};
      $.post(realPath+"/recovery/addMonitorEndTime.action",params);
}

/** 	 
 * @功能描述:结束
 * @参数: recoveryEndtime
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function stop(recoveryEndtime){
 endButtonNotUse(true,'LightSteelBlue');
 var operationId = document.getElementById("ylws").value;
 var params ={operationId:operationId,recoveryEndtime:recoveryEndtime};
 $.post( realPath+"/recovery/endRecovery.action",params);
}

/** 	 
 * @功能描述:加载已结束恢复室体征信息
 * @参数: 
 * @日期:2016年5月24日 上午9:36:04
 * @作者:崔连瑞
 */
function loadRecoveryData(){
 var operationId = document.getElementById("ylws").value;
 var params ={operationId:operationId};
    $.post(
    realPath+"/recovery/loadRecoveryData.action",
    params,
    function recoveryData(data){   
         var json = data;  
             srrData = eval('(' + json + ')'); 
             for(var i =0;i<srrData.length;i++){
                 var bptdId = "tr1td"+srrData[i].POINT;
                     document.getElementById(bptdId).innerHTML = srrData[i].BP_SYS+' / '+srrData[i].BP_DIAS;
                 var hrtdId = "tr2td"+srrData[i].POINT;
                     document.getElementById(hrtdId).innerHTML = srrData[i].HEARTRATE;
                 var rrtdId = "tr3td"+srrData[i].POINT;
                     document.getElementById(rrtdId).innerHTML = srrData[i].RESPRATE;
                 var rr = Number(srrData[i].RR);
                 if(rr<15){
                     $("#"+rrtdId).attr('style','color:red');
                 }
                 var spo2tdId = "tr4td"+srrData[i].POINT;
                     document.getElementById(spo2tdId).innerHTML = srrData[i].SPO2;
             }      
    });
}
</script>
</body>
</html>
