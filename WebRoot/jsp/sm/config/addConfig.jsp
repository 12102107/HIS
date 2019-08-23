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
<title>添加系统及参数配置列表</title>

<script type="text/javascript">
//验证系统及参数配置名称
	function checkName(){
		var name=$("#name").val().trim();
		var re = true;
		if(name==""){
			$("#namediv").html("该名称不能为空");
	        $("#button1").attr("disabled", true);
	        re=false;
		}
		
		$.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/config/checkConfigName.action",
	      data:{
	      	name:name,
	      },
	      async:false,
	      success:function(data){	
	      	if(data=='1'){
        			$("#namediv").html("该名称已经存在");
                    $("#button1").attr("disabled", true);
                   flag= false;
        		}else{
                    $("#namediv").html("");
                    $("#button1").attr("disabled",false);
                 }
	      }            
	    });
		return re;
	}
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
			<font class="pull-left">添加系统及参数配置</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
      	<form name="form" action="${pageContext.request.contextPath}/config/addConfig.action" method="post" id="form">
      	<input type="hidden" name="functionid" value="${functionid }">
			<table class="table table-bordered table-striped header-spcing">
				<tr>
					<th>代码:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="code" name="config.code">
					<div id="codediv" class="div1"></div>
					</td>
					<th>分类:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="category" name="config.category">
					<div id="categorydiv" class="div1"></div>
					</td>
					<th>名称:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="name" onchange="checkName()"
					 name="config.name">
					<div id="namediv" class="div1"></div>
					</td>
					<th>值:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="value"
					 name="config.value">
					<div id="valuediv" class="div1"></div>
					</td>
					<th>是否有效:</th>
					<td bgcolor="#fff" style="vertical-align: middle;">
					<select  name="config.enable" >
					<option value="0">有效</option>
					<option value="1">无效</option>
					</select>
					</td> 
				</tr>
			</table>
			<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check1()">添加</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href = 'configList.action?functionid=${functionid}'">取消</button>
			</div>	

		</form>
</div></div></div>
</body>
</html>