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
		window.location.href = "mzffList.action?functionid="+$('#functionid').val();
		}
		
		function check(){
			
			document.form.submit();
		}
	</script>
<title>麻醉方法信息</title>
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">修改麻醉方法信息</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<div class="responsive-table">
			<div class="scrollable-area">
			<form name="form" action="modMzffList.action" method="post" enctype="multipart/form-data" class="basic-grey">
			<input type="hidden" name="functionid" id="functionid" value="${functionid}">
				<input type="hidden" name="id" id="id"
					value="${requestScope.sa.code}">
				<table class="table table-bordered table-striped header-spcing">
					<tr>
						<td>代码:</td>
						<td>${sa.code}</td>
					</tr>
					<tr>
						<td>名称:</td>
						<td><input type="hidden" id="name" name="sa.name" value="${sa.name}"/>
						${sa.name}
						</td>
					</tr>
					
					<tr>
						<td>一级分类:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="cate1"
							maxlength="10" name="sa.cate1" value="${sa.cate1}">
						</td>
					</tr>
					<tr>
						<td>二级分类:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="cate2"
							maxlength="10" name="sa.cate2" value="${sa.cate2}">
						</td>
					</tr>
					<tr>
						<td>三级分类:</td>
						<td background="#fff" style="vertical-align: middle;"><input type="text" id="cate3"
							maxlength="10" name="sa.cate3" value="${sa.cate3}">
						</td>
					</tr>
					<tr>
					<td>是否有效:</td>
						<td style="vertical-align: middle;"><select id="isValid" name="sa.isValid">
					    	<option value="0" <c:if test="${sa.isValid eq '0'}">selected</c:if>> 有效</option>
					    	<option value="1"  <c:if test="${sa.isValid eq '1'}">selected</c:if>>无效</option>
					    </select></td>
					</tr>
					<tr>
					<td>是否常用:</td>
						<td style="vertical-align: middle;"><select id="isUsually" name="sa.isUsually">
					    	<option value="0" <c:if test="${sa.isUsually eq '0'}">selected</c:if>> 常用</option>
					    	<option value="1"  <c:if test="${sa.isUsually eq '1'}">selected</c:if>>不常用</option>
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


</body>
</html>