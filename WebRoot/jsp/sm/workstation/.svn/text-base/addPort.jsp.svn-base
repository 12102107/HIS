<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	int xh = (Integer) request.getAttribute("xh");
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/validate/jquery.validate.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<title>添加手术设备配置列表</title>

<script type="text/javascript">
		var info="<%=info%>";
	if (info.length > 0) {
		alert(info);
	}

       $(function()
        {
           $("#checkAll").click(function() {
                $('input[name="port.choice"]').attr("checked",this.checked); 
            });
            var $subBox = $("input[name='port.choice']");
            $subBox.click(function(){
                $("#checkAll").attr("checked",$subBox.length == $("input[name='port.choice']:checked").length ? true : false);
            });
        });

</script>
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">添加手术设备配置</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
				<form name="form" action="${pageContext.request.contextPath}/gzz/addPortConfig.action" method="post" id="form">
					<input type="hidden" name="id" value="${port.id}">
					<input type="hidden" id="functionid" name="functionid" value="${functionid }">

					<table class="table table-bordered table-striped header-spcing">
					
						<tr>
						
							<td bgcolor="#fff">设备型号:<select name="port.model"
								style="vertical-align: middle;">
									<option value="CREATIVE_UP_8000C" <c:if test="${port.model eq 'CREATIVE_UP_8000C'}">selected</c:if>>CREATIVE_UP_8000C</option>
									<option value="CREATIVE_UP_8001B" <c:if test="${port.model eq 'CREATIVE_UP_8001B'}">selected</c:if>>CREATIVE_UP_8001B</option>
							</select>
							</td>
						</tr>
						<tr>
							<td bgcolor="#fff">版本标记:<select name="port.edition"
								style="vertical-align: middle;">
									<option value="0000" <c:if test="${port.edition eq '0000'}">selected</c:if>>0000</option>
									<option value="0001" <c:if test="${port.edition eq '0001'}">selected</c:if>>0001</option>
							</select>
							</td>
						</tr>
						<tr>
							<td bgcolor="#fff">波特率:<select name="port.baudrate"
								style="vertical-align: middle;">
									<option value="19200" <c:if test="${port.baudrate eq '19200'}">selected</c:if>>19200</option>
									<option value="19201" <c:if test="${port.baudrate eq '19201'}">selected</c:if>>19201</option>
							</select>
							</td>
						</tr>
						<tr>
							<td bgcolor="#fff">串口参数:<select name="port.serial"
								style="vertical-align: middle;">
									<option value="COMM_8N1" <c:if test="${port.serial eq 'COMM_8N1'}">selected</c:if>>COMM_8N1</option>
									<option value="COMM_9N2" <c:if test="${port.serial eq 'COMM_9N2'}">selected</c:if>>COMM_9N2</option>
							</select>
							</td>
						</tr>
						<tr>
							<th>选择（<input type="checkbox"
								id="checkAll" >全选）
							    数据监控名称</th>
						</tr>
						<tr>
							<td><input type="checkbox"
								name="port.choice" value="1" <c:if test="${fn:contains(port.choice,'1')}">checked</c:if>>
							    心率</td>
						</tr>
						<tr>
							<td><input type="checkbox"
								name="port.choice" value="2" <c:if test="${fn:contains(port.choice,'2')}">checked</c:if>>
							   脉搏</td>
						</tr>
						<tr>
							<td><input type="checkbox"
								name="port.choice" value="3" <c:if test="${fn:contains(port.choice,'3')}">checked</c:if>>
							    血氧脉搏</td>
						</tr>
						<tr>
							<td><input type="checkbox"
								name="port.choice" value="4" <c:if test="${fn:contains(port.choice,'4')}">checked</c:if>>
							   无创血压脉搏</td>
						</tr>
						<tr>
							<td><input type="checkbox"
								name="port.choice" value="5" <c:if test="${fn:contains(port.choice,'5')}">checked</c:if>>
							    血氧饱和度</td>
						</tr>
					</table>
					<div style="text-align: center; margin-top: 2%;">
						<button type="submit" class="button_blue_74_33"
							style="border: medium none;">确定</button>
						<button type="button" class="button_blue_74_33"
							style="border: medium none;" onclick="location.href='portList.action?functionid=${functionid}'">取消</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>