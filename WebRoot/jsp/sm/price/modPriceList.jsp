<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/addYpForm.css" type="text/css"></link>
<script type="text/javascript">
		//返回
		function back(){
		window.location.href = "priceList.action";
		}
		
		function check(){
			
			document.form.submit();
		}
	</script>
<title>药品价格信息</title>
</head>
<body>

	<div class="main">
		<div class="fdiv">
			<h1>
				<img style="margin-right: 1%;"
					src="${pageContext.request.contextPath}/images/rubiao_40.png">修改药品价格信息
			</h1>
			<form name="form" action="modPriceList.action" method="post" enctype="multipart/form-data" class="basic-grey">
				<input type="hidden" name="id" id="id"
					value="${requestScope.price.id}">
				<table class="table1">
					<tr>
						<td>药品代码:</td>
						<td><input type="hidden" id="code" name="price.code" value="${price.code}"/>
						${price.code}
						</td>
					</tr>
					
					<tr>
						<td>HIS中药品代码:</td>
						<td background="#fff"><input type="text" id="hismedicineCode"
							maxlength="10" name="price.hismedicineCode" value="${price.hismedicineCode}">
						</td>
					</tr>
					<tr>
						<td>规格:</td>
						<td background="#fff"><input type="text" id="spec"
							maxlength="10" name="price.spec" value="${price.spec}">
						</td>
					</tr>
					<tr>
						<td>厂家:</td>
						<td background="#fff"><input type="text" id="firm"
							maxlength="10" name="price.firm" value="${price.firm}">
						</td>
					</tr>
					<tr>
						<td>批次:</td>
						<td background="#fff"><input type="text" id="batch"
							maxlength="10" name="price.batch" value="${price.batch}">
						</td>
					</tr>
					<tr>
						<td>最小计价 (包装)单位:</td>
						<td background="#fff"><input type="text" id="minPackageUnit"
							maxlength="10" name="price.minPackageUnit" value="${price.minPackageUnit}">
						</td>
					</tr>
					<tr>
						<td>最小计价单位对应价格:</td>
						<td background="#fff"><input type="text" id="priceMinPackage"
							maxlength="10" name="price.priceMinPackage" value="${price.priceMinPackage}">
						</td>
					</tr>
					<tr>
						<td>药房代码:</td>
						<td background="#fff"><input type="text" id="pharmaciesCode"
							maxlength="10" name="price.pharmaciesCode" value="${price.pharmaciesCode}">
						</td>
					</tr>
					<tr>
						<td>药房名称:</td>
						<td background="#fff"><input type="text" id="pharmaciesName"
							maxlength="10" name="price.pharmaciesName" value="${price.pharmaciesName}">
						</td>
					</tr>
					<tr>
					<td>是否有效:</td>
						<td><select id="enable" name="price.enable">
					    	<option value="0" <c:if test="${price.enable eq '0'}">selected</c:if>> 有效</option>
					    	<option value="1"  <c:if test="${price.enable eq '1'}">selected</c:if>>无效</option>
					    </select></td>
					</tr>
						
				</table>
				 <input align="right" type="button" onclick="check()" value="修改"> <input align="right"
					type="button" onclick="back()" value="返回">
					
			</form>
		</div>
	</div>
	<div class="bdiv"></div>

</body>
</html>