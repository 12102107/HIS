<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/validate/jquery.validate.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<script type="text/javascript">
	$(function(){
			$.post( "${pageContext.request.contextPath}/noc/getOpterName.action", {userId:$('#userId').val()},     
                  function(data){
                   var json = data;  
                   dd = eval('(' + json + ')'); 
                   $('#userName').val(dd.UserName);
                });	
	});





		//返回
		function back(){
		window.location.href = "nocList.action?functionid="+$('#functionid').val();
		}
		
		function check(){
			
			document.form.submit();
		}
	</script>
<title>公告信息</title>
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">修改公告</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
			<form name="form" action="modNoticeList.action" method="post" enctype="multipart/form-data" class="basic-grey">
				<input type="hidden" name="functionid" value="${functionid }" id="functionid">
				  <input type="hidden" id="userId"  value="${userid}" >
				  <input id="userName" name="notice.author" value="" type="hidden">
				<input type="hidden" name="id" id="id"
					value="${requestScope.notice.id}">
					
				<table class="table table-bordered table-striped header-spcing">
					<tr>
						<td style="width: 30%">公告标题:</td>
						<td style="width: 70%;vertical-align: middle;"><input id="title" style="width: 500px;" maxlength='100' name="notice.title" value="${notice.title}"/>
						</td>
					 </tr>
					 <tr>
						<td style="width: 30%">公告内容:</td>
						<td  style="width: 70%;"> <textarea style="width: 1080px;height: 400px;resize:none;" maxlength='1000' name="notice.content" rows="10" cols="80">${notice.content}</textarea> 
						</td>
					 </tr>
					
					
				</table>
				<div style="text-align: center; margin-top: 2%;margin-bottom: 20px;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check()">修改</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
				</div>	
			</form>
		</div>
</body>
</html>