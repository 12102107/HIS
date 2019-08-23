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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'MyJsp001.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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

  </head>
   <script type="text/javascript">
   var curWwwPath=window.document.location.href;
   var pathName=window.document.location.pathname;
   var pos=curWwwPath.indexOf(pathName);  
   var localhostPaht=curWwwPath.substring(0,pos);
   var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
   var realPath=localhostPaht+projectName;
   
   function caiJi(){
   setInterval(aaa,1000);
   }
   
   function aaa(){
    $.post(
    realPath+"/anesthesiaRecord/getCeshi01.action",
    {operationId:''},
    function(data){
    });
   }
   </script>
  <body>
  
<div>
    <table style="width: 1000px;" cellspacing="0">
        <thead >
        <tr style="width:1000px;height:50px;">
            <td colspan="3" style="width: 1000px;text-align: left;border: 0px solid #dddddd;border-radius: 5px;background-color:#1CAAD1;">
                采集数据
            </td>
        </tr>
        </thead>
        <tr style="width:1000px;height:50px;">
            <td><button type="button" style="width: 100px;height: 30px;" onclick="caiJi()">开始采集</button></td>

        </tr>
    </table>
</div>
  
  
  
  
  </body>
</html>
