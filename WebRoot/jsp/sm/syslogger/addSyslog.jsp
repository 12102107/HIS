<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
<title>添加系统日志列表</title>

<script type="text/javascript">
	$(function(){
			$.metadata.setType("attr", "validate");
			$("#form").validate();
	});
	
	 function check1(){
       
        if($("#form").valid()){
			document.form.submit();
		}else{
			return;
		}
    }
</script>
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">添加系统日志</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">  
      	<form name="form" action="${pageContext.request.contextPath}/syslog/addSyslog.action" method="post" id="form">
			<input type="hidden" name="functionid" value="${functionid }">
			<table class="table table-bordered table-striped header-spcing">
				<tr>
					<th>用户ID:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="userid" 
					 name="syslog.userid">
					<div id="useriddiv" class="div1"></div>
					</td>
					<th>权限码:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="permissionkey"
					 name="syslog.permissionkey">
					<div id="permissionkeydiv" class="div1"></div>
					</td>
					<th>操作结果:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="result"
					 name="syslog.result">
					<div id="resultdiv" class="div1"></div>
					</td>
					<th>内容:</th>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<textarea id="content" name="syslog.content" rows="2" cols="17"></textarea>
					</td>
                    
				</tr>
			</table>
			<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check1()">添加</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href = 'syslogList.action?functionid=${functionid}'">取消</button>
			</div>	

		</form>
</div></div></div>
</body>
</html>