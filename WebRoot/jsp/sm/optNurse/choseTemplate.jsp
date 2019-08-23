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
    <title>选择模板</title>
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
	arg.win.setTemplateVal($('input:radio:checked').val());
	window.close();
}
function dele() {
	$.post("delTemplate.action",{templateId:$('input:radio:checked').val()},function(){
		alert('删除成功！');
		location.reload(true);
	});
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
		<td style="text-align: left;padding-left: 25px;">公共模板
		</td>
	</tr>
</thead>
<tbody>	
	<tr class="No" >
		<td style="text-align: left;padding-left: 25px;">
		&nbsp;
			<c:forEach items="${publicT }" var="p">
			<input type="radio" value="${p.id}" name="t" style="vertical-align: baseline;">${p.name } &nbsp;
			</c:forEach>
		</td> 
	</tr>
</tbody>
</table>	
<table class="table table-bordered table-striped header-spcing" id='t' >
<thead>
	<tr class="bj" style="font-weight: bolder;">
		<td style="text-align: left;padding-left: 25px;">个人模板
		</td>
	</tr>
</thead>	
	<tr class="No">
		<td style="text-align: left;padding-left: 25px;">
		&nbsp;
			<c:forEach items="${personal }" var="p">
			<input type="radio" value="${p.id}" name="t" style="vertical-align: baseline;">${p.name } &nbsp;
			</c:forEach>
		</td> 
	</tr>
</table>
<table class="table table-bordered table-striped header-spcing" id='t' >	
	<tr class="bk">
		<td style="text-align: center;">
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="dele()">删除</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choosea()">确定</button>		
		</td> 
	</tr>
</table>
</div>
</body>
</html>
