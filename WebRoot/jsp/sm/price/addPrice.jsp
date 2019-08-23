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
<title>添加药品价格列表</title>

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
      <h1><img style="margin-right: 1%;"src="${pageContext.request.contextPath}/images/rubiao_40.png">添加药品价格列表</h1>
      
      	<form name="form" action="${pageContext.request.contextPath}/price/addPrice.action" method="post" id="form">
			<table class="table2">
				<tr>
					<th>药品代码:</th>
					<td bgcolor="#fff"><input type="text" id="code" name="price.code">
					<div id="codediv" class="div1"></div>
					</td>
					<th>HIS中药品代码:</th>
					<td bgcolor="#fff"><input type="text" id="hismedicineCode" name="price.hismedicineCode">
					<div id="hismedicineCodediv" class="div1"></div>
					</td>
					<th>规格:</th>
					<td bgcolor="#fff"><input type="text" id="spec" 
					 name="price.spec">
					<div id="specdiv" class="div1"></div>
					</td>
					<th>厂家:</th>
					<td bgcolor="#fff"><input type="text" id="firm"
					 name="price.firm">
					<div id="firmdiv" class="div1"></div>
					</td>
					<th>批次:</th>
					<td bgcolor="#fff"><input type="text" id="batch"
					 name="price.batch">
					<div id="batchdiv" class="div1"></div>
					</td>
								</tr>
				<tr>
					<th>最小计价 (包装)单位:</th>
					<td bgcolor="#fff"><input type="text" id="minPackageUnit"
					 name="price.minPackageUnit">
					<div id="minPackageUnitdiv" class="div1"></div>
					</td>
					<th>最小计价单位对应价格:</th>
					<td bgcolor="#fff"><input type="text" id="priceMinPackage"
					 name="price.priceMinPackage">
					<div id="priceMinPackagediv" class="div1"></div>
					</td>
					<th>药房代码:</th>
					<td bgcolor="#fff"><input type="text" id="pharmaciesCode"
					 name="price.pharmaciesCode">
					<div id="pharmaciesCodediv" class="div1"></div>
					</td>
					<th>药房名称:</th>
					<td bgcolor="#fff"><input type="text" id="pharmaciesName"
					 name="price.pharmaciesName">
					<div id="pharmaciesNapriceiv" class="div1"></div>
					</td>
					<th>是否有效:</th>
					<td bgcolor="#fff">
					<select  name="price.enable" >
					<option value="0">有效</option>
					<option value="1">无效</option>
					</select>
					</td> 
				</tr>
			</table>
			
			<input type="button" id="button1" class="button1" style="margin-left: 25%;margin-right: 30%;" value="添加"
						onclick="check1()">

			<input type="button" onclick="javascript:window.location.href = 'priceList.action'" value="取消" class="button1">
			
		</form>
</div></div>
</body>
</html>