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
    <title>ASA分级</title>
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

$(function(){
	$(":radio").click(function(){
		$("#a").val($(this).val());
	});
});

function choosea() {
	arg.win.setAsa($("#a").val());
	window.close();
}
function cancela() {
	window.close();
}
</script>
  </head>
   <body>

<table class="table table-bordered table-striped header-spcing" id='t' >
<tbody>
	<tr class="ys" style="font-weight: bolder;">
		<td>ASA分级
		 <input type="text" id="a" size="5" disabled="disabled" style="background-color: white;"></td>
	</tr>
	<tr class="bk" >
		<td style="text-align: left;padding-left: 25px;">
			<input type="radio" name="s" value="1级"> 1级：正常健康。
		</td> 
	</tr>
	<tr class="bk">
		<td style="text-align: left;padding-left: 25px;">
			<input type="radio" name="s" value="2级"> 2级：轻度系统性疾病，无功能受限。
		</td> 
	</tr>
	<tr class="bk">
		<td style="text-align: left;padding-left: 25px;">
			<input type="radio" name="s" value="3级"> 3级：严重系统性疾病，功能部分受限。
		</td> 
	</tr>
	<tr class="bk">
		<td style="text-align: left;padding-left: 25px;">
			<input type="radio" name="s" value="4级"> 4级：重度系统性疾病，随时存在生命危险（丧失生活能力）。
		</td> 
	</tr>
	<tr class="bk">
		<td style="text-align: left;padding-left: 25px;">
			<input type="radio" name="s" value="5级"> 5级：无论手术与否，都会在24h内死亡。
		</td> 
	</tr>
	<tr class="bk">
		<td style="text-align: left;padding-left: 25px;">
			<input type="radio" name="s" value="6级"> 6级：脑死亡患者，正在接受供体器官摘除手术。
		</td> 
	</tr>
	<tr class="bk">
		<td >
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="choosea()">确定</button>
		<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="cancela()">取消</button>
		</td> 
	</tr>
</tbody>
</table>

</body>
</html>
