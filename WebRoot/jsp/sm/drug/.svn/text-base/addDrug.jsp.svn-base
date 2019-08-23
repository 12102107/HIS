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
<title>添加使用贵重或自费药品(物品)列表</title>

<script type="text/javascript">
//验证使用贵重或自费药品(物品)名称
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
	      url:"<%=request.getContextPath()%>/drug/checkDrugName.action",
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
//验证使用贵重或自费药品(物品)代码
	function checkCode(){
		var code=$("#code").val().trim();
		var re = true;
		if(code==""){
			$("#codediv").html("该代码不能为空");
	        $("#button1").attr("disabled", true);
	        re=false;
		}
		
		$.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/drug/checkDrugCode.action",
	      data:{
	      	code:code,
	      },
	      async:false,
	      success:function(data){	
	      	if(data=='1'){
        			$("#codediv").html("该代码已经存在");
                    $("#button1").attr("disabled", true);
                   flag= false;
        		}else{
                    $("#codediv").html("");
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
			<font class="pull-left">添加使用贵重或自费药品(物品)信息</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">  
      
      	<form name="form" action="${pageContext.request.contextPath}/drug/addDrug.action" method="post" id="form">
      	<input type="hidden" name="functionid" value="${functionid }">
			<table class="table table-bordered table-striped header-spcing">
				<tr>
				    <th>代码:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="code" onchange="checkCode()" validate="{required:true,maxlength:20,messages:{required:'请填写代码'}}"
					 name="sdg.code">
					<div id="codediv" class="div1"></div>
					</td>
					<th>名称:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="name" onchange="checkName()" validate="{required:true,maxlength:20,messages:{required:'请填写名称'}}"
					 name="sdg.name">
					<div id="namediv" class="div1"></div>
					</td>
					<th>单价:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="price" 
					 name="sdg.price" >
					<div id="pricediv" class="div1"></div>
					</td>
					<th>类型:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" id="type" 
					 name="sdg.type">
					<div id="typediv" class="div1"></div>
					</td>
					<th>是否有效:</th>
					<td bgcolor="#fff"  style="vertical-align: middle;">
					<select  name="sdg.enable">
					<option value="0">有效</option>
					<option value="1">无效</option>
					</select>
					</td>
			</tr>
                    
			
			</table>
			<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check1()">添加</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href = 'drugList.action?functionid=${functionid}'">取消</button>
			</div>	

		</form>
</div></div></div>
</body>
</html>