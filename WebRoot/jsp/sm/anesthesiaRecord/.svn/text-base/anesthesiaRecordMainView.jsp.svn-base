<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/addYpForm.css" type="text/css"></link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/anesthesiaRecord.css" type="text/css"></link>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.min.css" type="text/css"></link>
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/medicines-pop-up.css"></link>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/anesthesiaMain.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/collection_view.css" type="text/css"></link>
	<!-- 打印使用的JS文件  2个 -->
	<script type="text/javascript" src="../js/GRUtility.js"></script>
    <script type="text/javascript" src="../js/CreateControl.js"></script>
<title>麻醉记录</title>
<script type="text/javascript">
CreateReport("Report");
function printt() {
	Report.LoadFromURL("../jsp/sm/anesthesiaRecord/AnesthesRecord.grf");
	AjaxSyncLoadReportData(Report,"loadAnesthesiaRecordPrint.action?id="+$("#id").val());
	Report.PrintPreview(true);
}

        $(function() {
            $( "#dialog" ).dialog({
                autoOpen: false,
                modal: true,
                buttons: {
                    确定: function() {
                        $( this ).dialog( "close" );
                          var collectInterval = $("#collectInterval  option:selected").val();
                          var operationId = document.getElementById("id").value;
                          var operationStarttime = document.getElementById("operationStarttime").value;
                          console.log(operationStarttime);
                          var userId = document.getElementById("userId").value;
                          document.getElementById("collectMainView").contentWindow.startCollect(collectInterval,operationId,userId,operationStarttime);
                                              
                    },
                    取消:function(){
                        $( this ).dialog( "close" );
                    }
                }
            });
            $( "#start" ).click(function() {
                $( "#dialog" ).dialog( "open" );
            });
           
        });
     
        
</script>

</head>


<body>
	<div class="anesthesiaMain">
		<div class="anesthesiaFdiv">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉记录</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
			<div>
			   <div id="">
			   <div  class="right-button" style="border: 0px solid red;width: 100px;height: 30px;top: 100px;left:1500px;text-align: center;">
                <ul style="list-style-type:none;">
                <li><button id="start"  class="right-buttons">开&nbsp;始</button></li>
                <li><button id="startRecord" class="right-buttons" onclick="startRecord();">开始记录</button></li>
                <li><button id="stopButton" class="right-buttons" onclick="stopOPT();">结&nbsp;束</button></li>
                <li><button id="stopRecord" class="right-buttons" onclick="stopRecord();">结束记录</button></li>
                <li><button id="opener4" class="right-buttons" onclick="save();">保&nbsp;存</button></li>
                <li><button id="opener5" class="right-buttons"   onclick="testSave();">保存测试</button></li><!-- 另存模板 -->
                <li><button id="opener6" class="right-buttons" >停止手术</button></li>
                <li><button id="printAnesthesiaRecord" class="right-buttons" onclick="printt();">打印</button></li>
                </ul>



              </div>
              <input id="id" type="hidden" name="id"  value="${sro.id}">
               <input id="state" type="hidden"  value="${sro.state}">
               <input id="operdate" type="hidden"  value="${sro.operdate}">
               <input id="operStartTime" type="hidden"  value="${sro.starttime}">
               <input id="operEndTime" type="hidden"  value="${sro.endtime}">
               <input id="remarkInterval" type="hidden"  value="${smard.remarkInterval}">
              <%  String userId = (String)request.getSession().getAttribute("userid"); %>
               <input type="hidden" id="userId"  value="<%=userId%>">
              <br>
			    <div class="top-left-time">
			    <table border="0" cellspacing="0">
                 <tr style="height: 35px;width: 1531px;background-color: #F9F9F9;">
		            <td style="width: 851px;border: 0px solid #DCDCDC;text-align: left;">日期：<fmt:formatDate  value="${sro.operdate}" pattern="yyyy-MM-dd" /></td>
		            <td style="width: 690px;border: 0px solid #DCDCDC;text-align: right;">病区： ${sro.region}</td>
		         </tr>
			    </table>
			     </div>	
			    <div style="height: 41px;width: 1539px;border: 0px solid #000000; background-color: #1CAAD1;top: -1px;left:-1px;font-size: 20px;line-height: 35px">&nbsp;&nbsp;基本信息</div>
			    <div class="patient-information">
			    
			     <form id="form" action="loadAnesthesiaRecord.action" name="form" method="post">
			     <table border="0" cellspacing="0">
			        <tr style="height: 37px;width: 1531px;background-color: #F9F9F9;">
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                      姓名：<input type="text" disabled="disabled" size="10" name="sro.name"  value="${sro.name}" style="height: 20px;border-radius:3px;">
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                      性别：<input type="radio" disabled="disabled" name="sro.sex" value="" <c:if test='${sro.sex eq "1"}'>checked</c:if> >男
                              <input type="radio" disabled="disabled" name="sro.sex" value="" <c:if test='${sro.sex eq "0"}'>checked</c:if> >女
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                       年龄：<input type="text" disabled="disabled" size="1" name="sro.age" value="${sro.age}" style="height: 20px;border-radius:3px;text-align: right;">
		                                                       岁<input type="text" disabled="disabled" size="1" value="${sro.ageMon}" style="height: 20px;border-radius:3px;text-align: right;">月
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                       身高：<input type="text" size="1" id="regOptHeightId" name="sro.height" value="${sro.height}" style="height: 20px;border-radius:3px;text-align: right;">cm
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                       体重：<input type="text" size="1" id="regOptWeightId" name="sro.weight" value="${sro.weight}" style="height: 20px;border-radius:3px;text-align: right;">kg
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                       床号：<input type="text" disabled="disabled" size="3" name="sro.bed" value="${sro.bed}" style="height: 20px;border-radius:3px;text-align: right;">
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                                                      病历号：<input type="text" disabled="disabled" size="7" name="sro.room" value="${sro.room}" style="height: 20px;border-radius:3px;text-align: right;">
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                   <input type="radio" disabled="disabled" name="sro.emergency" value="" <c:if test='${sro.emergency eq "1"}'>checked</c:if> >急诊
                           <input type="radio" disabled="disabled" name="sro.emergency" value="" <c:if test='${sro.emergency eq "0"}'>checked</c:if> >非急诊
		               </td>
			        </tr>
			        </table> 
			        <table border="0" cellspacing="0">	
			        <tr style="height: 37px;width: 1531px;">
		               <td style="width: 650px;border: 1px solid #DCDCDC;text-align: center;">
		                                                      临床诊断：<input type="text" size="80" disabled="disabled" value="${sro.diagnosisName}" style="height: 20px;border-radius:3px;">
		               </td>
		               <td style="width: 650px;border: 1px solid #DCDCDC;text-align: center;">
		                                                       术中诊断：<input type="text" size="80" disabled="disabled" value="${sro.diagnosisName}" style="height: 20px;border-radius:3px;">
		               </td>
		               <td style="width: 231px;border: 1px solid #DCDCDC;text-align: left;" style="height: 20px;border-radius:3px;">
                               血型：<select name="sro.bloodType" id="regOptBloodTypeId">
									<c:forEach items="${smbtiList}" var="blood" varStatus="status">
										<option value="${blood.bloodCode}"
											<c:if test="${sro.bloodType==blood.bloodCode}">selected</c:if>>${blood.bloodValue}</option>
									</c:forEach>
							</select>
		               </td>
			        </tr>
			        </table>
			        <table border="0" cellspacing="0">
			        <tr style="height: 37px;width: 1531px;background-color: #F9F9F9;">
		               <td style="width: 650px;border: 1px solid #DCDCDC;text-align: center;">
		                                                     拟施手术：<input type="text" size="80" disabled="disabled" value="${sro.designedOptName}" style="height: 20px;border-radius:3px;">
		               </td>
		               <td style="width: 650px;border: 1px solid #DCDCDC;text-align: center;" >
		                                                      已施手术：<input type="text" size="80" disabled="disabled" style="height: 20px;border-radius:3px;">
		               </td>
		               <td style="width: 231px;border: 1px solid #DCDCDC;text-align: left;">
                          ASA：<select name="asa" id="regOptAsa01Id" style="width: 100px;height: 26px;border-radius:3px;">
                                <option value="01">Ⅰ</option>
                                <option value="02">Ⅱ</option>
                                <option value="03">Ⅲ</option>
                                <option value="04">Ⅳ</option>
                                <option value="05">Ⅴ</option>
                              </select>
                             <!--  <input type="radio" id="regOptAsa02Id" name="asa" value="06">E -->
		               </td>
			        </tr>
			        </table>
			        <table border="0" cellspacing="0">
			        <tr style="height: 37px;width: 1531px;">
		               <td style="width: 769px;border: 1px solid #DCDCDC;text-align: center;">
		                                                   麻醉前用药：<input type="text" size="100" style="height: 20px;border-radius:3px;">
		               </td>
		               <td style="width: 769px;border: 1px solid #DCDCDC;text-align: center;">
		                                                     麻醉方法：<input type="text" size="100" disabled="disabled" value="${sro.designedAnaesMethodName}" style="height: 20px;border-radius:3px;">      
		               </td>
			        </tr>
			        </table>
			        <table border="0" cellspacing="0">
			        <tr style="height: 37px;width: 1531px;background-color: #F9F9F9;">
		               <td style="width: 1538px;border: 1px solid #DCDCDC;text-align: center;">
		                                                 特殊情况：<input type="text" size="225" disabled="disabled" value="${sro.preSpecialCase}" style="height: 20px;border-radius:3px;">    
		               </td>
			        </tr>
			          </table>
			        <table border="0" cellspacing="0">
			        <tr style="height: 37px;width: 1531px;">
		               <td style="width: 650px;border: 1px solid #DCDCDC;text-align: left;">
		               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                                                   手术体位：     <input type="checkbox" class="smBodyPositionClass01" name="operativePosition" value="01">仰卧位
                                  <input type="checkbox" class="smBodyPositionClass02" name="operativePosition" value="02">俯卧位
                                  <input type="checkbox" class="smBodyPositionClass03" name="operativePosition" value="03">左侧位
                                  <input type="checkbox" class="smBodyPositionClass04" name="operativePosition" value="04">右侧位
                                  <input type="checkbox" class="smBodyPositionClass05" name="operativePosition" value="05">结石位
                                  <input type="checkbox" class="smBodyPositionClass06" name="operativePosition" value="06">坐位
		               </td>
		               		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                   镇痛:    <input type="radio"  name="analgesia"  value="01" <c:if test='${smard.analgesia eq "01"}'>checked</c:if> >是
                           <input type="radio" name="analgesia" value="02" <c:if test='${smard.analgesia eq "02"}'>checked</c:if> >否
		               </td>
		               <td style="width: 200px;border: 1px solid #DCDCDC;text-align: center;">
		                   心肺复苏: <input type="radio" name="cpr"  value="01" <c:if test='${smard.cpr eq "01"}'>checked</c:if> >是
                           <input type="radio" name="cpr" value="02" <c:if test='${smard.cpr eq "02"}'>checked</c:if> >否
		               </td>
		               <td style="width: 481px;border: 1px solid #DCDCDC;text-align: center;">
		                   手术切口清洁度:  <select name="incisionCleanliness" id="incisionCleanliness" style="width: 100px;height: 26px;border-radius:3px;">
		                        <option value=""></option>
                                <option value="01" <c:if test='${smard.incisionCleanliness eq "01"}'>selected</c:if>>Ⅰ</option>
                                <option value="02" <c:if test='${smard.incisionCleanliness eq "02"}'>selected</c:if>>Ⅱ</option>
                                <option value="03" <c:if test='${smard.incisionCleanliness eq "03"}'>selected</c:if>>Ⅲ</option>
                                <option value="04" <c:if test='${smard.incisionCleanliness eq "04"}'>selected</c:if>>Ⅳ</option>
                              </select>
		               </td>
			        </tr>
			     </table> 	

			    </form>
			    </div>	  
			   </div>
			 
			   <div>
        <div style="position: absolute;height: 852px;width: 100px;border: 1px solid #000000;top: 389px">
            <div style="position: absolute;height: 21px;width: 110px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: center;font-size: 12px;line-height: 20px">开&nbsp;始&nbsp;时&nbsp;间</div>
            <div style="position: absolute;height: 225px;width: 100px;border: 0px solid #000000;background-color: lightgoldenrodyellow;top: 21px">
                <div style="position: absolute;height: 225px;width: 20px;border: 1px solid #000000;">
                    <div style="position: absolute;height: 164px;width: 20px;border:1px solid #000000;text-align: center;font-size: 13px;left:-1px;top: -1px;">
<br>麻<br><br>醉<br><br>用<br><br>药
                    </div>
                    <div style="position: absolute;height: 29px;line-height: 14px;width: 20px;border: 1px solid #000000;top: 164px;left:-1px;text-align: center;font-size:13px;padding: 0;margin:0 0 0 0;">
                        入<br>量
                    </div>
                    <div style="position: absolute;height: 31px;line-height: 14px;width: 20px;border: 1px solid #000000;top: 194px;left:-1px;text-align: center;font-size:13px">
                        出<br>量
                    </div>
                </div>
                <div style="position: absolute;height: 225px;width: 80px;border: 0px solid #000000;left: 20px">
                    <div id="anestheticMedicine0" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 0px"></div>
                    <div id="anestheticMedicine1" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 15px"></div>
                    <div id="anestheticMedicine2" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 30px"></div>
                    <div id="anestheticMedicine3" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 45px"></div>
                    <div id="anestheticMedicine4" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 60px"></div>
                    <div id="anestheticMedicine5" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 75px"></div>
                    <div id="anestheticMedicine6" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 90px"></div>
                    <div id="anestheticMedicine7" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 105px"></div>
                    <div id="anestheticMedicine8" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 120px"></div>
                    <div id="anestheticMedicine9" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 135px"></div>
                    <div id="anestheticMedicine10" class="theme-login" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 150px"></div>
                    <div id="liquidsInDivId0" class="liquidsInDivClass" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;;text-align: left;font-size: 12px;line-height: 13px;top: 165px"></div>
                    <div id="liquidsInDivId1" class="liquidsInDivClass" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;;text-align: left;font-size: 12px;line-height: 13px;top: 180px"></div>
                    <div id="liquidsOutDivId0" class="liquidsOutDivClass" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;;text-align: left;font-size: 12px;line-height: 13px;top: 195px"></div>
                    <div id="liquidsOutDivId1" class="liquidsOutDivClass" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;;text-align: left;font-size: 12px;line-height: 13px;top: 210px"></div>
                </div>
            </div>
            <div style="position: absolute;height: 24px;width: 110px;border: 1px solid #000000;background-color: lightgoldenrodyellow;top: 246px;text-align: center;font-size: 12px;line-height: 20px">时&nbsp;&nbsp;&nbsp;间</div>
            <div style="position: absolute;height: 460px;width: 90px;border: 0px solid red;top: 260px;line-height:30px;margin-top:0px;">
<pre>
1000 40 280
800  38 260
600  36 240
400  34 220
200  32 200
VT   30 180
32   28 160
28   26 140
24   24 120
20   22 100
16   20 80
12   18 60
8    16 40
4    12 20
CVP℃P.R.BP
</pre>
            </div>
            <div class="anesthesiaEventTextDivClass" style="position: absolute;height: 23px;width: 100px;margin: 0px;border: 1px solid #000000;top: 720px;text-align: center;font-size: 13px;line-height: 20px">麻&nbsp;醉&nbsp;事&nbsp;件</div>
            <div style="position: absolute;height: 20px;width: 100px;margin: 0px;border: 1px solid #000000;top: 744px;text-align: center;font-size: 13px;line-height: 20px">检&nbsp;验&nbsp;事&nbsp;件</div>
            <div style="position: absolute;height: 22px;width: 100px;margin: 0px;border: 1px solid #000000;top: 765px;text-align: center;font-size: 13px;line-height: 20px">手&nbsp;术&nbsp;事&nbsp;件</div>
            <div style="position: absolute;height: 22px;width: 100px;margin: 0px;border: 1px solid #000000;top: 788px;text-align: center;font-size: 13px;line-height: 20px">辅&nbsp;助&nbsp;呼&nbsp;吸</div>
        </div>
        <div id="collectMainViewContainer" style="position: absolute;height: 810px;width: 1350px;border: 0px solid #000000;top: 390px;left: 100px" >

            <iframe id="collectMainView" name="collectMainView"  style="margin-top:-9px;border: none;padding: 0 0 0 0" src ="${pageContext.request.contextPath}/jsp/sm/anesthesiaRecord/view.jsp" width="1350" height="850" frameborder="0" scrolling="auto"  >
            </iframe>
        </div>
        <div style="position: absolute;height: 850px;width: 90px;border: 1px solid #000000;top: 389px;left: 1450px">
            <div id="anestheticMedicineTotal" style="position: absolute;height: 21px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: center;font-size: 12px;line-height: 20px">总&nbsp;&nbsp;&nbsp;量</div>
            <div id="anestheticMedicineTotal0" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 21px"></div>
            <div id="anestheticMedicineTotal1" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 36px"></div>
            <div id="anestheticMedicineTotal2" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 51px"></div>
            <div id="anestheticMedicineTotal3" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 66px"></div>
            <div id="anestheticMedicineTotal4" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 81px"></div>
            <div id="anestheticMedicineTotal5" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 96px"></div>
            <div id="anestheticMedicineTotal6" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 111px"></div>
            <div id="anestheticMedicineTotal7" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 126px"></div>
            <div id="anestheticMedicineTotal8" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 141px"></div>
            <div id="anestheticMedicineTotal9" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 156px"></div>
            <div id="anestheticMedicineTotal10" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px; top: 171px"></div>
            <div id="liquidsInDivTotal0" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px;top: 186px"></div>
            <div id="liquidsInDivTotal1" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px;top: 201px"></div>
            <div id="liquidsOutDivTotal0" style="position: absolute;height: 15px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px;top: 216px"></div>
            <div id="liquidsOutDivTotal1" style="position: absolute;height: 16px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;text-align: left;font-size: 12px;line-height: 13px;top: 231px"></div>
            <div id="nowDate" style="position: absolute;height: 23px;width: 89px;border: 1px solid #000000;background-color: lightgoldenrodyellow;top: 247px;text-align: center;font-size: 12px;line-height: 20px"></div>
            <div style="position: absolute;height: 580px;width: 89px;border: 1px solid #000000;top: 270px;text-align: left;font-size: 6px;line-height: 20px;margin:0px 0px 0px 0px;pa">
<pre style="text-align: left;font-size: 14px;">
<span style="color:#000000;">▲</span>温度

<span style="color:blue;">●</span>脉搏

<span style="color:blue;">○</span>呼吸

<span style="color:blue;">∨</span>收缩压

<span style="color:blue;">∧</span>舒张压

<span style="color:#000000;">▼</span>潮气量

<span style="color:red;">★</span>麻醉深度

<span style="color:#000000;">¤</span>中心静脉压
</pre>
            </div>

        </div>
    </div>
			  
			</div>
		</div>
		
		<div id="monitorAllDivId" style="position: absolute;height: 823px;width: 1531px;border: 1px solid #000000;top: 1241px;">
		  <div id="monitorDivId1" style="position: absolute;height: 200px;width: 1531px;border: 1px solid #000000;left:-1px;top:-1px;">
		   <div id="reserveAnesthesiaPersonnelsDivId" style="position: absolute;height: 200px;width: 35px;border: 1px solid #000000;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 21px">
		  <br/> 监 <br/><br/><br/><br/><br/><br/>
		   测
		   </div>
		   <div id="reserveAnesthesiaPersonnelsDivId" style="position: absolute;height: 200px;width: 90px;border: 1px solid #000000;left:1440px;top: -1px;">
		   <div id="anesthetistersTitleDivId" style="position: absolute;height: 35px;width: 90px;border: 1px solid #000000;background-color: #1CAAD1;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 35px">麻醉人员</div>
		   <div id="anesthetistersDivId" style="position: absolute;height: 175px;width: 90px;border: 0px solid #000000;left:-1px;top: 35px;font-size: 14px;line-height: 15px">
		   <table id="anesthetistersListDivTableId">
		   <tbody id="anesthetistersDivTableTbodyId">
		   </tbody>
		   </table>
		   </div>
		   </div>
		  </div>
		  <div id="monitorDivId2" style="position: absolute;height: 250px;width: 1531px;border: 1px solid #000000; top: 200px;left:-1px;">
		    <div id="anesthesiaEventDiv2AllId" style="position: absolute;height: 250px;width: 360px;border: 1px solid #000000;left:-1px;top: -1px;">
		       <div id="anesthesiaEvent2DivId" style="position: absolute;height: 35px;width: 360px;border: 1px solid #000000;background-color: #1CAAD1;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 35px">麻醉事件</div>
		    </div>
		    <div id="reserveAnesthesiaEventDivId" style="position: absolute;height: 250px;width: 360px;border: 1px solid #000000;left:360px;top: -1px;">
		       <div id="reserveOperatersDivId" style="position: absolute;height: 35px;width: 360px;border: 1px solid #000000;background-color: #1CAAD1;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 35px">检验事件</div>
		    </div>
		    <div id="operationEventDivALlId" style="position: absolute;height: 250px;width: 360px;border: 1px solid #000000;left:721px;top: -1px;">
		        <div id="operationEventDivId" style="position: absolute;height: 35px;width: 360px;border: 1px solid #000000;background-color: #1CAAD1;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 35px">手术事件</div>
		        <div id="operationEventTableDivId" style="position: absolute;height: 225px;width: 360px;border: 0px solid #000000;left:-1px;top: 35px;font-size: 15px;line-height: 22px">
		         <table id="operationEventListDivTableId">
		          <tbody id="operationEventDivTableTbodyId">
		         </tbody>
		      </table>
		   </div>
		    </div>
		    <div id="respiratoryEventDivALlId" style="position: absolute;height: 250px;width: 357px;border: 1px solid #000000;left:1082px;top: -1px;">
		        <div id="respiratoryEventDivId" style="position: absolute;height: 35px;width: 357px;border: 1px solid #000000;background-color: #1CAAD1;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 35px">呼吸事件</div>
		    	<div id="respiratoryEventTableDivId"  style="position: absolute;height: 225px;width: 357px;border: 0px solid #000000;left:-1px;top: 35px;font-size: 15px;line-height: 22px">
		         <table id="respiratoryEventListDivTableId">
		          <tbody id="breathEventDivTableTbodyId"></tbody>
		         </table>
		        </div>
		    </div>

		    <div id="operatersDivAllId" style="position: absolute;height: 250px;width: 90px;border: 1px solid #000000;left:1440px;top: -1px;">
		    <div id="operatersTitleDivId" style="position: absolute;height: 35px;width: 90px;border: 1px solid #000000;background-color: #1CAAD1;left:-1px;top: -1px;text-align: center;font-size: 15px;line-height: 35px">手术人员</div>
		    <div id="operatersDivId" style="position: absolute;height: 175px;width: 90px;border: 0px solid #000000;left:-1px;top: 35px;font-size: 14px;line-height: 15px">
		       <table id="operatersListDivTableId" >
		          <tbody id="operatersDivTableTbodyId">

		         </tbody>
		      </table>
		   </div>
		    </div>
		  </div>
		  <div id="monitorDivId3" style="position: absolute;height: 111px;width: 1531px;border: 0px solid #000000; top: 451px;left:-1px;">
		  <div style="height: 41px;width: 1532px;border: 0px solid #000000; background-color: #1CAAD1;top: -1px;left:-1px;font-size: 20px;line-height: 35px">&nbsp;&nbsp;出室情况</div>
		  <form id="outRoomStatusFormId" action="" method="post">
		  <table border="0" cellspacing="0">
		     <tr style="height: 36px;width: 1531px;background-color: #F9F9F9;">
		         <td style="width: 150px;border: 1px solid #DCDCDC;text-align: right;">术后镇痛：</td>
		         <td style="width: 400px;border: 1px solid #DCDCDC;">
		                <input id="sorsOperationId" type="hidden"   name="sors.operationId"  value="${sro.id}">
		                <input type="radio" id="easePainManner01Id" name="sors.easePainManner" value="01">无
		                <input type="radio" id="easePainManner02Id" name="sors.easePainManner" value="02">PCIA
		                <input type="radio" id="easePainManner03Id" name="sors.easePainManner" value="03">PCEA
		        </td>
		        <td style="width: 150px;border: 1px solid #DCDCDC;text-align: right;">意识：</td>
		        <td style="width: 400px;border: 1px solid #DCDCDC;">
		              <input type="radio" id="mentalState01Id" name="sors.mentalState" value="01">清醒
		              <input type="radio" id="mentalState02Id" name="sors.mentalState" value="02">嗜睡
		              <input type="radio" id="mentalState03Id" name="sors.mentalState" value="03">瞻妄
		              <input type="radio" id="mentalState04Id" name="sors.mentalState" value="04">昏迷
		        </td>
		        <td style="width: 150px;border: 1px solid #DCDCDC;text-align: right;">咳嗽(吞咽)反射：</td>
		        <td style="width: 400px;border: 1px solid #DCDCDC;">
		              <input type="radio" id="coughReflact01Id" name="sors.coughReflact" value="01">好
		              <input type="radio" id="coughReflact02Id" name="sors.coughReflact" value="02">差
		              <input type="radio" id="coughReflact03Id" name="sors.coughReflact" value="03">无	  
		         </td>
		      </tr>
		      <tr style="height: 36px;width: 1531px;">
		      <td style="width: 150px;border: 1px solid #DCDCDC;text-align: right;"> 定向力：</td>
		         <td style="width: 400px;border: 1px solid #DCDCDC;">
		                <input type="radio" id="direPower01Id" name="sors.direPower" value="01">好   
		               <input type="radio" id="direPower02Id" name="sors.direPower" value="02">差
		               <input type="radio" id="direPower03Id" name="sors.direPower" value="03">无 
		         </td>
		         <td style="width: 150px;border: 1px solid #DCDCDC;text-align: right;"> 肌松恢复： </td>
		         <td style="width: 400px;border: 1px solid #DCDCDC;">
		  	             <input type="radio" id="muscleRecover01Id"  name="sors.muscleRecover" value="01">好  
		                 <input type="radio" id="muscleRecover02Id"  name="sors.muscleRecover" value="02">差 
		         </td>
		         <td style="width: 150px;border: 1px solid #DCDCDC;text-align: right;"> 病人送往：</td>
		          <td style="width: 400px;border: 1px solid #DCDCDC;">
		                <input type="radio" id="leaveTo01Id" name="sors.leaveTo" value="01">PACU
		                <input type="radio" id="leaveTo02Id" name="sors.leaveTo" value="02">ICU
		                <input type="radio" id="leaveTo03Id" name="sors.leaveTo" value="03">回病房
		                <input type="radio" id="leaveTo04Id" name="sors.leaveTo" value="04">出院
		                <input type="radio" id="leaveTo05Id" name="sors.leaveTo" value="05">死亡
		          </td>
		      </tr>
		  </table>
          </form>
		  </div>
		  <div id="monitorDivId4" style="position: absolute;height: 260px;width: 1531px;border: 0px solid #000000; top: 564px;left:-1px;">
		  <div style="height: 40px;width: 1532px;border: 0px solid #000000; background-color: #1CAAD1;top: -1px;left:-1px;font-size: 20px;line-height: 35px">&nbsp;&nbsp;麻醉小结</div>
		   <table border="0" cellspacing="0">
		      <tr style="height: 35px;width: 1531px;background-color: #F9F9F9;">
		         <td style="width: 330px;border: 1px solid #DCDCDC;text-align: center;">&nbsp;手术时间：</td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">开始&nbsp;&nbsp;</td>
		         <td style="width: 300px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" id="operationStartTimeTextId" name="operationStartTimeTextName" value="" style="width: 200px;height: 20px;border-radius:3px;">
		         </td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">结束&nbsp;&nbsp;</td>
		         <td style="width: 300px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" id="operationEndTimeTextId" name="operationEndTimeTextName" value="" style="width: 200px;height: 20px;border-radius:3px;">
		         </td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">总时间&nbsp;&nbsp;</td>
		         <td style="width: 300px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" id="operationUseTimeTextid" name="operationUseTimeTextName" value="" style="width: 200px;height: 20px;border-radius:3px;">
		         </td>
		      </tr>
		      <tr style="height: 35px;width: 1531px;">
		         <td style="width: 330px;border: 1px solid #DCDCDC;text-align: center;">&nbsp;麻醉时间：</td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">开始&nbsp;&nbsp;</td>
		         <td style="width: 300px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" id="anaesthesiaStartTimeTextId" name="anaesthesiaStartTimeTextName" value="" style="width: 200px;height: 20px;border-radius:3px;">
		         </td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">结束&nbsp;&nbsp;</td>
		         <td style="width: 300px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" id="anaesthesiaEndTimeTextId" name="anaesthesiaEndTimeTextName" value="" style="width: 200px;height: 20px;border-radius:3px;">
		         </td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">总时间&nbsp;&nbsp;</td>
		         <td style="width: 300px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" id="anaesthesiaUseTimeTextId" name="anaesthesiaUseTimeTextName" value="" style="width: 200px;height: 20px;border-radius:3px;">
		         </td>
		      </tr>
		   </table>
		   <div style="height: 40px;width: 1532px;border: 0px solid #000000; background-color: #1CAAD1;top: -1px;left:-1px;font-size: 20px;line-height: 35px">&nbsp;&nbsp;出入量汇总</div>
		   <table border="0" cellspacing="0">
		      <tr style="height: 35px;width: 1531px;background-color: #F9F9F9;">
		         <td style="width: 180px;border: 1px solid #DCDCDC;text-align: center;">&nbsp;术中入量：</td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;"> 胶体量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="colloidAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">晶体量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="crystalAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">输血量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="bloodTransfusionAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		      </tr>
		      <tr style="height: 35px;width: 1531px;">
		         <td style="width: 180px;border: 1px solid #DCDCDC;text-align: center;">&nbsp; 术中出量：</td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">尿量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="urineAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">血量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="bloodAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">胸水&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="pleuralEffusionAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">腹水&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="ascitesAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">其它&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="otherAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		      </tr>
		      <tr style="height: 35px;width: 1531px;background-color: #F9F9F9;">
		         <td style="width: 180px;border: 1px solid #DCDCDC;text-align: center;">&nbsp;出入总量：</td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">液体出量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="outAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">液体入量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="inAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		         
		         <td style="width: 100px;border: 1px solid #DCDCDC;text-align: right;">出入差量&nbsp;</td>
		         <td style="width: 170px;border: 1px solid #DCDCDC;">
		            &nbsp;<input type="text" disabled="disabled" name="outAndIndifferenceAmountTextName" value="0.0" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">ml
		         </td>
		      </tr>
		   </table>
		  </div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	<div id="dialog" title="开始采集">
    采集间隔：
    <select name="collectInterval" id="collectInterval" style="width:100px;height: 25px">
        <option value="1" >   1分钟 </option>
        <option value="3" >   3分钟 </option>
        <option value="5" >   5分钟 </option>
        <option value="10" >  10分钟 </option>
    </select>
    <hr style="color: white;">
    开始时间：
    <input id="operationStarttime" readonly="readonly" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:170px;height: 20px"/>

</div>

<!--麻醉用药弹出窗口-->

<div class="theme-popover">
    <div class="head">
              麻醉用药
    </div>
    <div class="medicines">
         <table border="0" cellspacing="0">	
	      <tr style="height: 30px;width: 250px;">
	         <td colspan=""  style="width: 250px;border: 0px solid #DCDCDC;font-size:20px;text-align: left;">&nbsp;&nbsp;药品拼音查找</td>
	      </tr>
	      <tr style="height: 30px;width: 250px;">
	         <td colspan=""  style="width: 250px;border: 0px solid #DCDCDC;font-size:20px;">
                 <input id="medicalPinyin" type="text" style="width:220px;text-align: left;height: 20px;border-radius:3px;"/>
              </td>
	      </tr>
	      </table>
        <div class="medicineList">
        <form action="">
            <table >
            <thead>
                <tr>
                    <th style="width: 185px;font-size:12px;text-align:center;border:solid 0px #000000;">药品名称</th>
                    <th style="width: 60px;font-size:12px;text-align:center;border:solid 0px #000000;">拼音码</th>
                </tr>
                </thead>
              </table>
              <table id="medicineTable">
                <c:forEach items="${smdList}" var="smdlist">
                     <tbody id="medicineTableTbody">
						<tr style="border:1px;">
						  
							<td class="smdName" >${smdlist.name}-
							   <input type="hidden" class="spec" value="${smdlist.spec}">
							   <input type="hidden" class="medicineCode" value="${smdlist.medicineCode}">
							   <input type="hidden" class="firm" value="${smdlist.firm}">
							   <input type="hidden" class="dosageUnit" value="${smdlist.dosageUnit}">
							</td>
							<td class="smdPinyin" style="width: 60px;font-size:12px;text-align:left;">${smdlist.pinyin}-</td>
					    </tr>
					 </tbody>
				</c:forEach>
            </table>
            </form>
        </div>
    </div>
    <div class="aMedicineList">
        <form>
          <input id="medicineId" name="sme.operationId" class="medicineId" type="hidden">
          <input id="medicineCodeId" name="sme.medicineCode" class="medicineCode1" type="hidden">
          <table border="0" cellspacing="0">	
	      <tr style="height: 40px;width: 550px;">
	      	 <td colspan="2"  style="width: 550px;border: 1px solid #DCDCDC;font-size:20px;">&nbsp;&nbsp;药品信息</td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td style="width: 270px;border: 1px solid #DCDCDC;">
           		  &nbsp;药名：<input id="medicineName" name="sme.name" class="medicineName" type="text" disabled="disabled" style="width:180px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	      	 <td style="width: 280px;border: 1px solid #DCDCDC;">
           		&nbsp;规格：<input id="medicineSpec" name="sme.spec" class="medicineSpec" type="text" disabled="disabled" style="width:180px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  &nbsp;给药途径：<select name="sme.takewayCode" id="medicalTakeWay" class="medicalTakeWay" style="width: 120px;text-align: left;height: 25px;border-radius:3px;">
                           <c:forEach items="${smtwList}" var="smtwList">
                             <option value="${smtwList.code}">${smtwList.name}</option>
				           </c:forEach>
                        </select>
                        <input type="checkbox" id="durabled" name="sme.durable" value="1">持续用药<!--选中"1",未选中"0"-->
		     </td>
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		 &nbsp;厂家：<input id="medicineFirm" name="sme.firm" class="medicineFirm" type="text" disabled="disabled" style="width:180px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  &nbsp;剂量：<input id="medicineDose" name="sme.dosage" class="medicineDose" type="text" style="width:80px;text-align: right;height: 20px;border-radius:3px;">
                            <input id="medicineDoseUnit" name="sme.dosageUnit" class="medicineDoseUnit" type="text" disabled="disabled" style="width:60px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		 &nbsp; 计价用量：<input id="medicineDiluentQuant" type="text" name="sme.diluentQuant"  disabled="disabled"  style="width:80px;text-align: left;height: 20px;border-radius:3px;">
           		       <input type="radio" id="medicineCharge01Id"  name="sme.charge" value="01"  checked="checked">否
           		       <input type="radio" id="medicineCharge02Id"  name="sme.charge" value="02" >是
		     </td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  &nbsp;浓度：<input id="medicineConcentration" name="sme.thickness" class="medicineConcentration" type="text" style="width:80px;text-align: right;height: 20px;border-radius:3px;">
                     <select id="medicineConcentrationUnit" name="sme.thicknessUnit" style="width: 65px;height: 25px;border-radius:3px;">
                        <option value="ml">ml</option>
                        <option value="mg" selected>mg</option>
                     </select>
                     <input type="radio" name="sex" value="female">显示
		     </td>
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  &nbsp;时间：<input id="medicineStarttime" readonly="readonly" class="Wdate" name="sme.starttime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:180px;text-align: left;height: 20px;border-radius:3px;"/>
		     </td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		&nbsp;流速：<input id="medicineSpeed" name="sme.flow" class="medicineSpeed" type="text" style="width:80px;text-align: right;height: 20px;border-radius:3px;">
                    <select id="medicineSpeedUnit" name="sme.flowUnit" style="width: 65px;height: 25px;border-radius:3px;">
                       <option value=""></option>
                       <option value="ml">ml</option>
                       <option value="l" selected>l</option>
                   </select>
            <input type="radio" name="display" >显示
		     </td>
	      	 <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  &nbsp;规格：<input id="medicineSpec" name="sme.spec" class="medicineSpec" type="text" disabled="disabled" style="width:180px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td colspan="2"  style="width: 400px;border: 1px solid #DCDCDC;">
           		  &nbsp;选择用药理由：<select id="medicineReasonSelect" name="sme.reason" style="width: 407px;height: 25px;border-radius:3px;">
                            <option value="ml">ml</option>
                            <option value="mg" selected>mg</option>
                          </select>
		     </td>
	      </tr>
	      <tr style="height: 40px;width: 550px;">
	      	 <td colspan="2" style="width: 400px;border: 1px solid #DCDCDC;">
           		 &nbsp; 用药理由：<input id="medicineReason" name="sme.reason" class="medicineReason" type="text" style="width:419px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	      </tr>
	      </table>
        </form>
    </div>
    <div class="buttons">
        <ul >
            <li> <button onclick="startUsedMedicine();">使用药品</button></li>
            <li> <button>保存</button></li>
            <li> <button class="close1">关闭</button></li>
        </ul>
    </div>
</div>
<div class="theme-popover-mask"></div>
<!--液体入量弹出窗口-->
<div class="liquidsIn">
    <div class="liquidsInTitle">液体入量</div>
    <div class="liquidsInNames">
        <div class="liquidsInNamesParent">
            <table>
                <tr><td id="bloodParentId" class="inNameParentClass">全血<input type="hidden" id="bloodParentClass" class="inNameParentHiddenClass" value="BLOOD"></td></tr>
                <tr><td id="componentBloodParentId" class="inNameParentClass">成分输血<input type="hidden" id="componentBloodParentClass" class="inNameParentHiddenClass" value="COMPONENTBLOOD"></td></tr>
                <tr><td id="colloidParentId" class="inNameParentClass">代血浆<input type="hidden" id="colloidParentClass" class="inNameParentHiddenClass" value="COLLOID"></td></tr>
                <tr><td id="crystalParentId" class="inNameParentClass">晶体液<input type="hidden" id="crystalParentClass" class="inNameParentHiddenClass" value="CRYSTAL"></td></tr>
                <tr><td id="otherParentId" class="inNameParentClass">其它<input type="hidden" id="otherParentClass" class="inNameParentHiddenClass" value="OTHER"></td></tr>
            </table>
        </div>
        <div class="liquidsInNamesChild">
            <table id="liquidsInNamesChildTableId" class="liquidsInNamesChildTableCLass">
            <tbody id="liquidsInNamesChildTableToboy" class="liquidsInNamesChildTableToboy">
            </tbody>
            </table>
        </div>
    </div>
    <div class="liquidsInList">
        <table id="liquidsInListTableId">
            <thead>
            <tr style="background-color: #ededed">
                <th class="liquidsInIdTh" style="width: 30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <th class="liquidsInNameTh" style="width: 250px;">液体名称</th>
                <th class="liquidsInSpecTh" style="width: 40px">规格</th>
                <th class="liquidsInFirmTh" style="width: 140px">厂家</th>
                <th class="liquidsInDosageTh" style="width: 40px">容量</th>
                <th class="liquidsInDosageUnitTh" style="width: 40px">单位</th>
                <th class="liquidsInAmountTh" style="width: 100px">计价用量</th>
                <th class="liquidsInChargeTh" style="width: 40px">计费</th>
                <th class="liquidsInEndTh" style="width: 40px">结束</th>
            </tr>

            </thead>

            <tbody id="liquidsInListTableTbody">
            </tbody>
        </table>
    </div>
    <div class="liquidsInInput">
    <form  id="liquidsInInputFormId" action="" method="post">
     
     <input type="hidden" id="liquidsInInputItemId" name="smie.itemId" >
     <input type="hidden" id="liquidsInInputOperationId" name="smie.operationId" value="${sro.id}">
     <input type="hidden" id="liquidsInInputType" name="smie.type" value="1">
       <table border="0" cellspacing="0">	
	      <tr style="height: 48px;width: 1000px;">
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  名称：<input id="liquidsInInputName" type="text" name="smie.name" disabled="disabled" style="width:120px;text-align: left;height: 20px;border-radius:3px;"/>
		     </td>
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		 容量：<input type="text" id="liquidsInInputDosage" name="smie.dosage" style="width:70px;text-align: right;height: 20px;border-radius:3px;" >
                    <input type="text" id="liquidsInInputDosageUnit" name="smie.dosageUnit" disabled="disabled" style="width:40px;text-align: left;height: 20px;border-radius:3px;" >
		     </td>
	         <td colspan="2" style="width: 400px;border: 1px solid #DCDCDC;">
           		  时间：<input  id="liquidsInInputStartTime" readonly="readonly" class="Wdate" name="smie.starttime"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:200px;text-align: left;height: 20px;border-radius:3px;" />
		     </td>
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		   通道：<select id="liquidsInInputPassageway" name="smie.dosageunit" style="width:120px;text-align: left;height: 25px;border-radius:3px;">
                       <option value="01" style="width:90px;text-align: left;height: 25px;border-radius:3px;">外周静脉通道</option>
                       <option value="02" style="width:90px;text-align: left;height: 25px;border-radius:3px;">外周动脉通道</option>
                     </select>
		     </td>
	      </tr>
	      <tr style="height: 48px;width: 1000px;">
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  厂家：<input id="liquidsInInputFirm" type="text" name="smie.firm" disabled="disabled" style="width:120px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		 规格： <input id="liquidsInInputSpec" type="text" name="smie.spec" disabled="disabled" style="width:120px;text-align: left;height: 20px;border-radius:3px;" >
		     </td>
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		  计价用量：<input id="liquidsInInputAmount" type="text" name="smie.amount"  disabled="disabled"  style="width:50px;text-align: right;height: 20px;border-radius:3px;">
                       <input id="liquidsInInputMinPackageUnit" type="text" name="smie.minPackageUnit" disabled="disabled" style="width:30px;text-align: left;height: 20px;border-radius:3px;">
		     </td>
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
           		 单价：<input id="liquidsInInputPrice" name="smie.price" type="text" disabled="disabled"  style="width:120px;text-align: right;height: 20px;border-radius:3px;">
		     </td>
	         <td style="width: 200px;border: 1px solid #DCDCDC;">
		                         计费：<input type="radio" id="charging01Id"  name="smie.charge" value="01"  checked="checked">否
           		    <input type="radio" id="charging02Id"  name="smie.charge" value="02" >是
		     </td>
	      </tr>
	   </table>
        </form>
    </div>
    <div class="liquidsInButtons">

        <button class="liquidsInStart">开始输液</button><br><br>
        <button class="liquidsInStop">结束输液</button><br><br>
        <button class="liquidsInDelete" onclick="liquidsInDelete();">删除输液</button><br><br>
        <button class="liquidsInSave">保存</button><br><br>
        <button class="liquidsInClose" style="height: 22%">关闭</button>
    </div>
</div>
<!--液体出量弹出窗口-->
<div class="liquidsOut">
    <div class="liquidsOutTitle">液体出量</div>
    <div class="liquidsOutNames">
        <table border="0" cellspacing="0" style="width: 100%;">
            <c:forEach items="${liquidsOutList}" var="liquidsOutList">
						<tr style="height: 20px;width: 100%;"><td class="liquidsOutName" >${liquidsOutList.name}
						<input type="hidden" class="liquidsOutId" value="${liquidsOutList.id}"/>
						</td></tr>
						
		    </c:forEach>
        </table>
    </div>
    <div class="liquidsOutsList">
     <form>
            <table>
            <thead>
            <tr style="background-color: darkgrey;">
            <th class="liquidsOutIdTh" style="width: 30px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th class="liquidsOutNameTh" style="width: 280px;">液体名称</th>
            <th class="liquidsOutDosageTh" style="width: 80px">容量</th>
            <th class="liquidsOutDosageUnitTh" style="width: 80px">单位</th>
            <th class="liquidsOutStartDateTh" style="width: 200px;">开始时间</th>
           
            </tr>
            </thead>
            </table>
            
            <table id="liquidsOutsListTable">
            <tbody id="liquidsOutsListTableTbody">
            </tbody>
            </table>
            </form>
    </div>
    <div class="liquidsOutInput">
     <form id="liquidsOutInputFormId" name="liquidsOutInputFormName" method="post">
     <input type="hidden" id="liquidsOutId" name="smie.itemId" value="">
     <input type="hidden" id="liquidsOutOperationId" name="smie.operationId" value="${sro.id}">
     <input type="hidden" id="liquidsOutType" name="smie.type" value="0">
     <input type="hidden" id="liquidsOutDivTop">
     <table border="0" cellspacing="0">	
	   <tr style="height: 60px;width: 900px;">
           		 <td style="width: 300px;border: 1px solid #DCDCDC;">
           		   药品名称：<input id="liquidsOutName" name="smie.name" disabled="disabled" type="text" style="width:150px;text-align: left;height: 20px;border-radius:3px;">
		         </td>
           		 <td style="width: 300px;border: 1px solid #DCDCDC;">
           		   容量：<input id="liquidsOutSpeed"  name="smie.dosage" type="text" style="width: 100px;text-align: right;height: 20px;border-radius:3px;">
           		           <select id="liquidsOutSpeedUnit" name="smie.dosageUnit" style="width: 50px;text-align: right;height: 25px;border-radius:3px;">
                             <option value="ml"selected style="width: 50px;text-align: left;height: 25px;border-radius:3px;">ml </option>
                             <option value="l" style="width: 50px;text-align: left;height: 25px;border-radius:3px;">L </option>
                           </select>
		         </td>                              
           		 <td style="width: 300px;border: 1px solid #DCDCDC;">
           		   开始时间：<input id="liquidsOutDate" readonly="readonly" class="Wdate" name="smie.starttime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:200px;text-align: left;height: 20px;border-radius:3px;"/>
		         </td>
       </tr>
     </table>
     </form>
    </div>
    <div class="liquidsOutButtons">
        <br>
        <button class="liquidsOutAdd" >添加出量</button><br><br>
        <button class="liquidsOutDelete" onclick="liquidsOutDelete();">删除出量</button><br><br>
        <button class="liquidsOutSave">保存</button><br><br>
        <button class="liquidsOutClose" style="height: 60px;">关闭</button>
    </div>
</div>

<!-- 麻醉事件 -->
<div class="anesthesiaEventDivClass">
    <div class="anesthesiaEventTitleClass">
        &nbsp;麻醉事件
        <div class="anesthesiaEventDivClose">×</div>
    </div>
    <div class="anesthesiaEventNamesClass">
        <table id="anesthesiaEventNamesTableId">
            <tbody id="anesthesiaEventNamesTableTbodyId">
            </tbody>
        </table>
    </div>
    <div class="anesthesiaEventInputClass">
    <form id="anesthesiaEventFormId" name="anesthesiaEventFormName" method="post">
        时&nbsp;间：<input id="anesthesiaEventInputDate" readonly="readonly" class="Wdate" name="sae.occurtime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
        <input type="hidden" id="anaesEventItemsId" name="sae.eventItemsId">
        <input type="hidden" id="liquidsOutOperationId" name="sae.operationId" value="${sro.id}">
        <input type="hidden" id="anaesEventItemsName">
        <input type="hidden" id="anaesEventItemsCode" name="sae.code">
        <input type="hidden" id="anaesEventItemsGraphElements">
        <input type="hidden" id="anaesEventItemsGraphCode">
     
        <input type="hidden" id="anaesEventCreateuser" name="sae.createuser" value="<%=userId%>">
        </form>
    </div>
    <div class="anesthesiaEventButtonsClass">
        <button class="anesthesiaEventButtonAdd" onclick="addAnesthEventParent();">添加</button>
        <button class="anesthesiaEventButtonClose">关闭</button>
    </div>
</div>
<!-- 手术事件 -->
<div class="operationEventPopupDivClass" id="operationEventPopupDivId">
    <div class="operationEventPopupDivTitleClass" id="operationEventPopupDivTitleId">
        <div style="width: 50%;font-size: 1.7em;font-family: '楷书';color:#FFFFFF;" >&nbsp;手术事件</div>
        <div  class="operationEventPopupDivCloseClass" id="optEventDivTitleCloseId">×</div>
    </div >
    <div class="operationEventPopupDivInputClass" id="optEventDivInputId">
         <form id="operationEventFormId" name="operationEventFormName" method="post">
          <input id="operationEventOperationId" type="hidden" name="operationEvent.operationId"  value="${sro.id}">
          <input id="operationEventId" type="hidden" name="operationEvent.id"  value="">
        &nbsp;&nbsp;标题&nbsp;<input type="text" id="operationEventPopupDivTitleInputId" class="operationEventPopupDivTitleInputClass"  name="operationEvent.title" style="width: 200px;background-color: #FFFFFF;"><br>
        &nbsp;&nbsp;内容&nbsp;<br/>
        &nbsp; <textarea id="operationEventPopupDivTextareaId" class="operationEventPopupDivTextareaClass" name="operationEvent.content"  rows="12" cols="30" style="background-color: #FFFFFF;"></textarea><br>
        &nbsp;&nbsp;时间&nbsp;<input type="text" id="operationEventPopupTimeId" readonly="readonly" class="Wdate" name="operationEvent.time"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:200px;"><br/><br/>
        </form>
        <button class="operationEventPopupDivButton1Class">确定</button>
        <button class="operationEventPopupDivButton2Class">取消</button>
    </div>
</div>
<!-- 呼吸事件 -->
<div class="respiratoryEventPopupDivClass" id="respiratoryEventPopupDivId">
    <div class="respiratoryEventPopupDivTitleClass" id="respiratoryEventPopupDivTitleId">
        <div style="width: 70%;font-size: 1.7em;font-family: '楷书';color:#FFFFFF;" >&nbsp;辅助呼吸</div>
        <div  class="respiratoryEventPopupDivCloseClass" id="respiratoryEventDivTitleCloseId">×</div>
    </div >
    <div class="respiratoryEventPopupDivInputClass" id="optEventDivInputId">
     <form id="respiratoryEventFormId" name="respiratoryEventFormName" method="post">
         <input id="operationId" type="hidden" name="breathEvent.operationId"  value="${sro.id}">
        <hr>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="respiratoryEventFlagId01" class="respiratoryEventFlagClass" name="breathEvent.flag" value="01" checked>自主呼吸
        <hr>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="respiratoryEventFlagId02" class="respiratoryEventFlagClass" name="breathEvent.flag" value="02">辅助呼吸
        <hr>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="respiratoryEventFlagId02" class="respiratoryEventFlagClass" name="breathEvent.flag" value="03">控制呼吸
        <hr>
        &nbsp;&nbsp;时间&nbsp;<input type="text" readonly="readonly" class="Wdate" id="respiratoryEventTimeId" class="respiratoryEventTimeClass" name="breathEvent.starttime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:150px;"><br/><br/>
        </form>
        <button class="respiratoryEventPopupDivButton1Class">确定</button>
        <button class="respiratoryEventPopupDivButton2Class">取消</button>
    </div>
</div>
 <!-- 麻醉人员弹出框 -->
 <div class="anesthetistersPopupDivClass" id="anesthetistersPopupDivId">
    <div class="anesthetistersPopupTiTle01">麻醉人员
    <div class="anesthetistersPopupClose">╳</div>
    </div>
    <div class="anesthetistersPopupLeftDivClass">
        <input type="hidden" value="" id="anesthetistersPopupHiddenId"/>
        <table id="anesthetistersPopupLeftDivTableId">
		    <tbody id="anesthetistersPopupLeftDivTableTbodyId"></tbody>
		</table>
    </div>
    <div class="anesthetistersPopupRightDivClass">
        <form>
             <table border="0" cellspacing="0">
              <tr style="height: 50px;width: 230px;">
                  <td colspan="2" style="width: 230px; text-align: center;">请选择麻醉人员</td>
              </tr>

              <tr style="height: 50px;width: 230px;">
                     <td colspan="2" style="width: 220px;border: solid 0px #000000;text-align: center;">
                         <input type="text" style="width: 150px;height: 20px;border-radius: 3px;" onkeyup="searchRy(this)">
                     </td>

              </tr>
                 <tr style="height: 50px;width: 230px;"></tr>
              <tr style="height: 50px;width: 230px;">
                     <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                         <select style="width: 100px;height: 30px;border-radius: 3px;"  >
                             <option class="yishi" id="empty"></option>
                             <option class="yishi" value="手术麻醉医师">手术麻醉医师</option>
                             <option class="yishi" value="巡台麻醉医师">巡台麻醉医师</option>
                             <option class="yishi" value="灌注医师">灌注医师</option>
                         </select>
                     </td>
                     <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <select id="yishiSelect" style="width: 100px;height: 30px;border-radius: 3px;">
                        </select>
                     </td>
              </tr>
                 <tr style="height: 50px;width: 230px;"></tr>
                 <tr style="height: 50px;width: 230px;">
                     <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                         <button type="button"  class="anesthetistersPopupButton1Class" >添加</button>
                     </td>
                     <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                         <button type="button" class="anesthetistersPopupButton2Class" >删除</button>
                     </td>
                 </tr>
             </table>
        </form>
    </div>
</div>
  <!-- 手术人员弹出框 -->
 <div class="operatersPopupDivClass" id="operatersPopupDivId">
    <div class="operatersPopupTitle01DivClass">手术人员
        <div  class="operatersPopupCloseDivClass">╳</div>
    </div>
    <div class="operatersPopupLeftTableDivClass">    
     <input type="hidden" value="" id="operatersListDivTableIdHidden1"/>
          <table id="anesthetistersPopupLeftDivTableId1" >
		          <tbody id="operatersDivTableTbodyId1">
		         </tbody>
		      </table>
		</div>
    <div class="operatersPopupRightTableDivClass">
        <form>
            <table border="0" cellspacing="0">
                <tr style="height: 40px;width: 230px;">
                    <td colspan="2" style="width: 230px; text-align: left;">请选择手术人员</td>
                </tr>

                <tr style="height: 40px;width: 230px;">
                    <td  style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <input type="text" style="width: 93px;height: 23px;border-radius: 3px;" onkeyup="searchYs(this)">
                    </td>
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <select id="yishiSelect3" style="width: 100px;height: 30px;border-radius: 3px;">
                        </select>
                    </td>

                </tr>
                <tr style="height: 40px;width: 230px;">
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <select style="width: 100px;height: 30px;border-radius: 3px;">
                            <option class="yishi3" id="empty3"></option>
                            <option class="yishi3" value="手术医师">手术医师</option>
                        </select>
                    </td>
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <button type="button" class="operatersPopupAddButton01DivClass">添加</button>
                    </td>
                </tr>
                <tr style="height: 40px;width: 230px;">
                    <td colspan="2" style="width: 230px; text-align: left;">请选择护士</td>
                </tr>

                <tr style="height: 40px;width: 230px;">
                    <td  style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <input type="text" style="width: 93px;height: 23px;border-radius: 3px;" onkeyup="searchHs(this)">
                    </td>
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <select id="yishiSelect2" style="width: 100px;height: 30px;border-radius: 3px;"> 
                         </select>
                    </td>

                </tr>
                <tr style="height: 40px;width: 230px;">
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <select style="width: 100px;height: 30px;border-radius: 3px;">
                            <option class="yishi2" id="empty2"></option>
                            <option class="yishi2" value="器械护士">器械护士</option>
                            <option class="yishi2" value="巡回护士">巡回护士</option>
                        </select>
                    </td>
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <button type="button" class="operatersPopupAddButton02DivClass">添加</button>
                    </td>
                </tr>
                <tr style="height: 65px;width: 230px;">
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <button type="button" class="operatersPopupDeleteButtonDivClass">删除</button>
                    </td>
                    <td style="width: 115px;border: solid 0px #000000;text-align: center;">
                        <button class="operatersPopupCloseButtonDivClass">关闭</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>