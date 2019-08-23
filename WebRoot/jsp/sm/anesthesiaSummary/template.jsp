<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%
String info = "";
if(request.getAttribute("info")!=null){
	info = (String)request.getAttribute("info");
}	
%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>存为模板</title>
    <!--引入本页面整体样式文件 -->
   	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<style>
body{
min-width: 400px;
width: expression_r( document.body.clientWidth < 400 ? "450px" : "auto" );
font-size: 14px;
font-family: "微软雅黑";
color: #141414;
}
body html{ width:80%; height:100%;}
</style>
<script type="text/javascript" >
var arg = window.dialogArguments;

function choosea() {
	arg.win.saveTemplate($("input:checked").val(),$('#tname').val());
	window.close();
}
function cancela() {
	window.close();
}
</script>
  </head>
   <body>
 <div class="zhong_right">
<table class="table table-bordered table-striped header-spcing" id='t' style="margin-top: 0;">
<thead>
	<tr class="bj" style="font-weight: bolder;">
		<td >输入模板信息
		</td>
	</tr>
	</thead>
<tbody>	
	<tr class="No" >
		<td style="text-align: left;padding-left: 50px;">
		选择模板类别：
			<input type="radio" name="type" style="vertical-align: baseline;" value="0" checked="checked">公共模板 &nbsp; &nbsp; &nbsp;
			<input type="radio" name="type" style="vertical-align: baseline;" value="1">个人模板
		</td> 
	</tr>
	<tr class="No">
		<td style="text-align: left;padding-left: 50px;">
		输入模板名称：
			<input type="text" id="tname" size="22" maxlength="50">
		</td> 
	</tr>
	<tr class="No">
		<td >
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choosea()">确定</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="cancela()">取消</button>		
		</td> 
	</tr>
</tbody>
</table>
</div>
</body>
</html>
