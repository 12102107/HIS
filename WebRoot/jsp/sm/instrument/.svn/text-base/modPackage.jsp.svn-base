<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css"></link>
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/icon.css"></link>
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
<title>添加手术包</title>

<script type="text/javascript">
var sel;
$(function(){
	sel = $(".iname").clone();
	
	$(".inum").live("keyup",function(){
		$(this).val($(this).val().replace(/\D/gi,''));
	});
	
});
 function check() {

 	if($("#n").val().trim()=="") {
 		alert("请输入手术包名称！"); return;
 	}
 	 
 	if($(".instrument").size()==0) {
 		alert("请添加手术器械！"); return;
 	}
 	
 	var able = 0;
 	
 	$(".inum").each(function(){
 		if($(this).val()=="") {
 			alert("存在未输入数量的手术器械！"); able++;
 		}
 	});
 	
 	$(".iname").each(function(){
 		var val = $(this).val();
 		var obj = $(this).parent().parent(); 
 		$(obj).nextAll().each(function(){
 			if($(this).find("select").val()==val) {
 				alert("存在相同的手术器械！"); able++;
 			}
 		});
 	});
 	
 	$(".inum").each(function(i){
 		$(this).attr('name',"inum["+i+"]");
 	});
 	$(".iname").each(function(i){
 		$(this).attr('name',"iid["+i+"]");
 	});
 	
 	if(able==0) {
 		$('#form').submit();
 	}
 	
 }
 
 function addI() {
 	$("#i tbody").append(
 		"<tr class=\"instrument\">" +
			"<td>名称:</td>" +
			"<td bgcolor=\"#fff\" style=\"vertical-align: middle;\">" +
			"</td>" +
			"<td>数量:</td>" +
			"<td bgcolor=\"#fff\" style=\"vertical-align: middle;\">" +
				"<input type=\"text\" class=\"inum\" maxlength=\"2\">" +
			"</td>" +
			"<td>" +
				"<a href=\"javascript:void(0)\" onclick=\"delI(this)\">删除</a>" +
			"</td>" +
		"</tr>"
 	);
 	$(".instrument").last().find("td").eq(1).append($(sel).clone());
 }
 
 function delI(obj) {
 	$(obj).parent().parent().remove();
 }
</script>
</head>
<body>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">修改手术包</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">  
      	<form name="form" action="modInstrumentPackage.action" method="post" id="form">
      		<input type="hidden" name="functionid" value="${functionid }">
      		<input type="hidden" name="p.id" value="${p.id }">
			<table class="table table-bordered table-striped header-spcing">
				<thead>
				<tr class="bj">
					<td colspan="4" style="text-align: left;padding-left: 30px;">基本信息:</td>
				</tr>
				</thead>
				<tr>
					<td>名称:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<input type="text" id="n" name="p.name" value="${p.name }">
					</td>	
					<td>是否常用:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<select name="p.common" >
					<option value="0" <c:if test="${p.common eq '0' }">selected</c:if>>是</option>
					<option value="1" <c:if test="${p.common eq '1' }">selected</c:if>>否</option>
					</select>
					</td>
				</tr>
			</table>
			<table id="i" class="table table-bordered table-striped header-spcing">
				<thead>	
				<tr class="bj">
					<td colspan="5" style="text-align: left;padding-left: 30px;">器械清单:</td>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${item }" var="t">
				<tr class="instrument">
					<td>名称:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<select class="iname" >
					<c:forEach items="${ilist }" var="i">
					<option value="${i.id }" <c:if test="${i.id eq t.instrumentId.id }">selected</c:if> >${i.name}</option>
					</c:forEach>
					</select>
					</td>	
					<td>数量:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<input type="text" class="inum" maxlength="2" value="${t.num }" >
					</td>
					<td>
						<a href="javascript:void(0)" onclick="delI(this)">删除</a>
					</td>
				</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				<tr>
					<td colspan="5" >
						<a href="javascript:void(0)" onclick="addI()">添加</a>
					</td>
				</tr>
				</tfoot>
			</table>
			<div style="text-align: center; margin-top: 2%;">
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check()">确定</button>
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href='getInstrumentPackageList.action?functionid=${functionid}'">取消</button>
			</div>		
		</form>
</div></div></div>
</body>
</html>