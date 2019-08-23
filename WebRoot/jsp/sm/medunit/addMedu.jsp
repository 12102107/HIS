<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/addYpForm.css" type="text/css"></link>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/jquery-1.9.1.min.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/validate/jquery.validate.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<title>添加药物单位列表</title>

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
<body>
<div class="main"><div class="fdiv">
      <h1><img style="margin-right: 1%;"src="${pageContext.request.contextPath}/images/rubiao_40.png">添加药物单位列表</h1>
      
      	<form name="form" action="${pageContext.request.contextPath}/medu/addMedu.action" method="post" id="form">
			<table class="table2">
				<tr>
					<th>代码:</th>
					<td bgcolor="#fff"><input type="text" id="code" validate="{required:true,maxlength:20,messages:{required:'请填写代码'}}"
					 name="medu.code">
					<div id="codediv" class="div1"></div>
					</td>
					<th>单位:</th>
					<td bgcolor="#fff"><input type="text" id="unit"
					 name="medu.unit">
					<div id="unitdiv" class="div1"></div>
					</td>
					<th>药品代码:</th>
					<td bgcolor="#fff"><input type="text" id="medicineCode"
					 name="medu.medicineCode">
					<div id="medicineCodediv" class="div1"></div>
					</td>
					
                    
				</tr>
			</table>
			
			<input type="button" id="button1" class="button1" style="margin-left: 25%;margin-right: 30%;" value="添加"
						onclick="check1()">

			<input type="button" onclick="javascript:window.location.href = 'meduList.action'" value="取消" class="button1">
			
		</form>
</div></div>
</body>
</html>