<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/addYpForm.css" type="text/css"></link>
<title>药物单位列表</title>
</head>
<!-- 分页代码 开始 -->
<script type="text/javascript">
		var info="<%=info%>";
	if (info.length > 0) {
		alert(info);
	}

	//加载分页初始化信息
	function paging_init() {
		$.jqPaginator('#pageurl', {
			//总页数
			totalPages : Number("${totalP}"),
			//当前页码数量
			currentPage : Number($("#page").val()),
			//上一页和下一页中间显示的页码数量
			visiblePages : 5,
			//页码数发生改变调用查询方法重新加载数据
			onPageChange : function(num, type) {
				//表单提交请求
				if (type == 'change') {
					//查询form表单
					var queryForm = document.getElementById("form");
					document.getElementById("page").value = num;
					queryForm.submit();
				}
			}
		});
	}
	//跳转到相应页面
function gotopage(){
	  //查询form表单
	  var queryForm =document.getElementById("form");
	  document.getElementById("page").value=document.getElementById("gopage").value;
	  queryForm.submit();
}

</script>
<!-- 分页代码 结束 -->

<body onload="paging_init()">
	<div class="main">
		<div class="fdiv">
			<h1>
				<img style="margin-right: 1%;"
					src="${pageContext.request.contextPath}/images/rubiao_40.png">药物单位列表
			</h1>
			<a href="addMeduGo.action" class="btn btn-primary" >新&nbsp;增</a>
			<form id="form" action="meduList.action" name="form" method="post">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" />

				
				药品代码：<input name="ypcode"
					size="8" value="${ypcode}"/>&nbsp;&nbsp; 
				代码：<input name="code" size="8" value="${code}"/>&nbsp;&nbsp;
			        单位：<select name="dw">
					<option></option>
					<c:forEach items="${dwList}" var="dw1" varStatus="status">
						<option value="${dw1}" <c:if test="${dw eq dw1}">selected</c:if>>${dw1}</option>
					</c:forEach>
				</select>&nbsp;&nbsp; 
				<input class="button1" type="submit" value="查询"
					><hr>
				<table class="table table-hover" id="table">
					<tr>
						<th>序号</th>
						<th>代码</th>
						<th>单位</th>
						<th>药品代码</th>
						<th colspan="4" style="text-align:center">管理</th>
					</tr>
					<c:forEach items="${meduList}" var="medu">
						<tr>
							<td><input name="ids" type="hidden" value="${medu.id}" /><%=xh++%></td>
							<td>${medu.code}</td>
							<td>${medu.unit}</td>
							<td>${medu.medicineCode}</td>
							<td style="text-align:center;"><a
								href="modMeduListTo.action?id=${medu.id}">修&nbsp;改</a>
							</td>

						</tr>
					</c:forEach>
				</table>
				<!-----------分页文件引入----->
				<%@include file="/common/page.jsp"%>

			</form>
		</div>
	</div>
</body>
</html>