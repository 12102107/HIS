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
		window.location.href = "meduList.action";
		}
		
		function check(){
			
			document.form.submit();
		}
	</script>
<title>药物单位信息</title>
</head>
<body>

	<div class="main">
		<div class="fdiv">
			<h1>
				<img style="margin-right: 1%;"
					src="${pageContext.request.contextPath}/images/rubiao_40.png">修改药物单位信息
			</h1>
			<form name="form" action="modMeduList.action" method="post" enctype="multipart/form-data" class="basic-grey">
				<input type="hidden" name="id" id="id"
					value="${requestScope.medu.id}">
				<table class="table1">
					<tr>
						<td>代码:</td>
						<td><input type="hidden" id="code" name="medu.code" value="${medu.code}"/>
						${medu.code}
						</td>
					</tr>
					
					<tr>
						<td>单位:</td>
						<td background="#fff"><input type="text" id="unit"
							maxlength="10" name="medu.unit" value="${medu.unit}">
						</td>
					</tr>
					
						<tr>
						<td>药品代码:</td>
						<td background="#fff"><input type="text" id="medicineCode"
							maxlength="10" name="medu.medicineCode" value="${medu.medicineCode}">
						</td>
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