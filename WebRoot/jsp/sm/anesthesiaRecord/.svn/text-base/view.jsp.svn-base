<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'view.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/anesthesiaRecordMainView.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/js/anesthEvent.js"></script> --%>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.min.css" type="text/css"></link>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/collection_view.css" type="text/css"></link> --%>
<style type="text/css">
.anesthesiaEventDeleteDivClass  button{  width: 50px;height: 30px; background-color: dodgerblue; border-radius: 5px; text-align: center; }
.anesthesiaEventDeleteDivClass  button:hover{ background-color: darkgreen; }
.usedMedicineStopAndDeleted button{width: 50px;height: 30px; background-color: dodgerblue; border-radius: 5px; text-align: center; }
</style>
  </head>
  
  <body>
   <div class ="canvasMainViewDivClass" style="height: 810px;width: 5400px;border: 1px solid #000000;margin: 0px;">
    <div style="margin: 0px;height: 810px;width: 5400px;border: 1px solid  #000000;">
        <div id="timeTopDiv" style="position: absolute; height: 24px;width: 5400px;border: 1px solid  #000000; ">
            <canvas id="canvas_timeTopDiv" width="5400" height="24" style="background-color: lightgoldenrodyellow">您的浏览器不支持该操作。。。</canvas>
        </div>
        <div style="position: absolute;margin: 0px;height: 225px;width: 5400px;border: 1px solid  #000000;top: 30px;">
            <canvas id="canvas-medication" width="5400" height="225" style="background-color: lightgoldenrodyellow">您的浏览器不支持该操作。。。</canvas>
        </div>
        <div style="position: absolute; height: 22px;width: 5400px;border: 1px solid  #000000; top: 257px">
            <canvas id="canvas_timeCenterDiv" width="5400" height="22" style="background-color: lightgoldenrodyellow">您的浏览器不支持该操作。。。</canvas>
        </div>
        <div style="position: absolute;margin: 0px;height: 450px;width: 5400px;border: 1px solid  #000000;top: 279px;">
            <canvas id="canvas_collect" width="5400" height="450">您的浏览器不支持该操作。。。</canvas>
        </div>
        <div class="anesthesiaEventDiv" style="position: absolute;margin: 0px;height: 22px;width: 5400px;border: 1px solid  #000000;top: 730px;background-color: lightgoldenrodyellow">
            <canvas id="canvas_anesthesia_event" width="5400" height="22">您的浏览器不支持该操作。。。</canvas>
        </div>
        <div style="position: absolute;margin: 0px;height: 22px;width: 5400px;border: 1px solid  #000000;top: 753px;"></div>
        <div style="position: absolute;margin: 0px;height: 22px;width: 5400px;border: 1px solid  #000000;top: 774px;background-color: lightgoldenrodyellow"></div>
        <div style="position: absolute;margin: 0px;height: 21px;width: 5400px;border: 1px solid  #000000;top: 797px;"></div>
    </div>
</div>
<div id="usedMedicineStopAndDeleted" class="usedMedicineStopAndDeleted" style="z-index:9999;position:fixed; width:50px; height:60px;display:none;border-radius: 5px;">
    <button id="stopMedicine" onclick="stopMedicine();">停止</button>
    <button id="deletedMedicine" onclick="deletedMedicine();">删除</button>
</div>

<div id="anesthesiaEventDeleteDivId" class="anesthesiaEventDeleteDivClass" style="z-index:9999;position:fixed; width:50px; height:30px;display:none;border-radius: 5px;">
    <button id="anesthesiaEventDeleteButtonId" onclick="deleteAnesthesiaEvent();">删除</button>
</div>

  </body>
</html>
