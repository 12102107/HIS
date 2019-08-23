<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/validate/jquery.validate.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<title>添加公告</title>

<script type="text/javascript">

	$(function(){
			$.metadata.setType("attr", "validate");
			$("#form").validate();
			$.post( "${pageContext.request.contextPath}/noc/getOpterName.action", {userId:$('#userId').val()},     
                  function(data){
                   var json = data;  
                   dd = eval('(' + json + ')'); 
                   $('#userName').val(dd.UserName);
                });	
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
			<font class="pull-left">添加公告</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
      	<form name="form" action="${pageContext.request.contextPath}/noc/addNotice.action" method="post" id="form">
      <input type="hidden" name="functionid" value="${functionid }" id="functionid">
      <input type="hidden" id="userId"  value="${userid}" >
      	<input id="userName" name="notice.author" value="${name}" type="hidden">
			<table class="table table-bordered table-striped header-spcing">
				<tr>
					<td style="width: 30%">公告标题:</td>
						<td style="width: 70%;vertical-align: middle;"><input id="title" style="width: 500px;" size="82" maxlength='100' name="notice.title"/>
						</td>
					 </tr>
					 <tr>
						<td style="width: 30%">公告内容:</td>
						<td  style="width: 70%;"> <textarea style="width: 1080px;height: 400px;resize:none;" maxlength='1000' sname="notice.content" ></textarea> 
						</td>
					 </tr>
			</table>
			<div style="text-align: center; margin-top: 2%;margin-bottom: 20px;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check1()">添加</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href = 'nocList.action?functionid=${functionid}'">取消</button>
			</div>
			
		</form>
</div></div>
</div>

</body>
</html>