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
<title>添加药品库列表</title>

<script type="text/javascript">
//验证药品库列表名称
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
	      url:"<%=request.getContextPath()%>/med/checkMedName.action",
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
<body>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">添加药品信息</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area"> 
      	<form name="form" action="${pageContext.request.contextPath}/med/addMed.action" method="post" id="form">
			<input type="hidden" name="functionid" value="${functionid }">
			<table class="table table-bordered table-striped header-spcing">
				<tr>
					<th>名称:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input style="width: 120px;" type="text" id="name" onchange="checkName()"  validate="{required:true,maxlength:20,messages:{required:'请填写名称'}}"
					 name="med.name">
					<div id="namediv" class="div1"></div>
					</td>
					<th>简称:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input style="width: 120px;" type="text" id="briefName" 
					 name="med.briefName">
					<div id="briefNamediv" class="div1"></div>
					</td>
					<th>药品分类:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input style="width: 120px;" type="text" id="roughType" 
					 name="med.roughType">
					<div id="roughTypediv" class="div1"></div>
					</td>
					<th>类型:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input style="width: 120px;" type="text" id="type"
					 name="med.type">
					<div id="typediv" class="div1"></div>
					</td>
					<td></td><td></td>
				</tr>
				<tr>
					<th>拼音码:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" style="width: 120px;" id="pinyin"
					 name="med.pinyin">
					<div id="pinyindiv" class="div1"></div>
					</td>
					<th>HIS中药品代码:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" style="width: 120px;" id="hismedicineCode"
					 name="med.hismedicineCode">
					<div id="hismedicineCodediv" class="div1"></div>
					</td>
					<th>每最小包装单位中所含有的总剂量:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" style="width: 120px;" id="packageDosageAmount"
					 name="med.packageDosageAmount">
					<div id="packageDosageAmountdiv" class="div1"></div>
					</td>
					<th>剂量单位:</th>
					<td bgcolor="#fff" style="vertical-align: middle;"><input type="text" style="width: 120px;" id="dosageUnit"
					 name="med.dosageUnit">
					<div id="dosageUnitdiv" class="div1"></div>
					</td>
					<th>是否有效:</th>
					<td bgcolor="#fff" style="vertical-align: middle;width: 100px;">
					<select  name="med.enable" >
					<option value="0">有效</option>
					<option value="1">无效</option>
					</select>
					</td> 
				</tr>
			</table>
			<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="check1()">添加</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="javascript:window.location.href = 'medList.action?functionid=${functionid}'">取消</button>
			</div>	
		</form>
</div></div></div>
</body>
</html>