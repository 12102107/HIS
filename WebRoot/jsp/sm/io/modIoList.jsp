<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">
		//返回
		function back(){
		window.location.href = "ioList.action?functionid="+$('#functionid').val();
		}
		
		function check(){
			
			document.form.submit();
		}
	</script>
<title>出入量信息</title>
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">修改出入量信息</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<div class="responsive-table">
			<div class="scrollable-area">
			<form name="form" action="modIoList.action" method="post" enctype="multipart/form-data" class="basic-grey">
			<input type="hidden" name="functionid" id="functionid" value="${functionid}">
				<input type="hidden" name="id" id="id"
					value="${requestScope.sio.id}">
				<table class="table table-bordered table-striped header-spcing">
					<tr>
						<td>名称:</td>
						<td><input type="hidden" id="name" name="sio.name" value="${sio.name}"/>
						${sio.name}
						</td>
						<td>简称:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="briefName"
							maxlength="10" name="sio.briefName" value="${sio.briefName}">
						</td>
					</tr>
					<tr>
						<td>拼音码:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="pinyin"
							maxlength="10" name="sio.pinyin" value="${sio.pinyin}">
						</td>

						<td>类型:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="type"
							maxlength="10" name="sio.type" value="${sio.type}">
						</td>
					</tr>
					<tr>
						<td>子类型:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="subType"
							maxlength="10" name="sio.subType" value="${sio.subType}">
						</td>
						<td>每最小包装单位中所含有的总剂量:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="packageDosageAmount"
							maxlength="10" name="sio.packageDosageAmount" value="${sio.packageDosageAmount}">
						</td>
					</tr>
					<tr>
						<td>剂量单位:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="dosageUnit"
							maxlength="10" name="sio.dosageUnit" value="${sio.dosageUnit}">
						</td>
					<td>是否有效:</td>
						<td style="vertical-align: middle;"><select id="enable" name="sio.enable">
					    	<option value="0" <c:if test="${sio.enable eq '0'}">selected</c:if>> 有效</option>
					    	<option value="1"  <c:if test="${sio.enable eq '1'}">selected</c:if>>无效</option>
					    </select></td>
					</tr>
						
				</table>
				<div style="text-align: center; margin-top: 2%;margin-bottom: 20px;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check()">修改</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
				</div>
			</form>
		</div>
	</div>
</div>

</body>
</html>