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
<title>修改手术器械</title>

<script type="text/javascript">
 function check() {
 	if($("#n").val().trim()=="") {
 		alert("请输入器械名称！"); return;
 	}
 	if($("#s").val().trim()=="") {
 		alert("请输入器械规格！"); return;
 	}
 	if($("#u").val().trim()=="") {
 		alert("请输入器械单位！"); return;
 	}
 	$.post("checkNameSpecifications.action",{name:$("#n").val().trim(),specifications:$("#s").val().trim()},function(data){
 		if(data) {
 			alert("已存在的器械！");
 		} else {
 			$('#form').submit();
 		}
 	},'json');
 	$('#form').submit();
 }
</script>
</head>
<body>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">修改手术器械</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">  
      	<form name="form" action="modInstrument.action" method="post" id="form">
      		<input type="hidden" name="functionid" value="${functionid }">
      		<input type="hidden" name="i.id" value="${i.id }">
			<table class="table table-bordered table-striped header-spcing">
				<tr>
					<td>名称:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<input type="text" id="n" name="i.name" value="${i.name }">
					</td>
				</tr>
				<tr>	
					<td>规格:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<input type="text" id="s" name="i.specifications" value="${i.specifications }">
					</td>
				</tr>
				<tr>	
					<td>单位:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<input type="text" id="u" name="i.unit" value="${i.unit }">
					</td>
				</tr>
				<tr>	
					<td>是否常用:</td>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<select name="i.common" >
					<option value="0" <c:if test="${i.common eq '0'}">selected</c:if>>是</option>
					<option value="1" <c:if test="${i.common eq '1'}">selected</c:if>>否</option>
					</select>
					</td>
				</tr>
			</table>
			<div style="text-align: center; margin-top: 2%;">
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check()">修改</button>
			<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href='getInstrumentList.action?functionid=${functionid}'">取消</button>
			</div>		
		</form>
</div></div></div>
</body>
</html>