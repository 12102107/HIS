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
<title>药品价格列表</title>
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
					src="${pageContext.request.contextPath}/images/rubiao_40.png">药品价格列表
			</h1>
			<a href="addPriceGo.action" class="btn btn-primary" >新&nbsp;增</a>
			<form id="form" action="priceList.action" name="form" method="post">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" />
                                      药品代码：<input
					name="ypcode" size="8"  value="${ypcode}"/>&nbsp;&nbsp; 
					厂家：<input name="cj"
					size="8" value="${cj}"/>&nbsp;&nbsp; 
					药房代码：<input name="yfcode"
					size="8" value="${yfcode}"/>&nbsp;&nbsp; 
				      单位：<select name="dw">
					<option></option>
					<c:forEach items="${dwList}" var="dw1" varStatus="status">
						<option value="${dw1}" <c:if test="${dw eq dw1}">selected</c:if>>${dw1}</option>
					</c:forEach>
				    </select>&nbsp;&nbsp; 
				      有效标志：<select name="yx">
					<option></option>
					<option value="0" <c:if test="${yx eq '0'}">selected</c:if> >有效</option>
					<option value="1" <c:if test="${yx eq '1'}">selected</c:if>>无效</option>
				</select>&nbsp;&nbsp; <input class="button1" type="submit" value="查询">
				<hr>
				<table class="table table-hover" id="table">
					<tr>
						<th>序号</th>
						<th>药品代码</th>
						<th>HIS中药品代码</th>
						<th>规格</th>
						<th>厂家</th>
						<th>批次</th>
						<th>最小计价 (包装)单位</th>
						<th>最小计价单位对应价格</th>
						<th>药房代码</th>
						<th>药房名称</th>
						<th>有效标志</th>
						<th colspan="4" style="text-align:center">管理</th>
					</tr>
					<c:forEach items="${priceList}" var="price">
						<tr>
							<td><input name="ids" type="hidden" value="${price.id}" /><%=xh++%></td>
							<td>${price.code}</td>
							<td>${price.hismedicineCode}</td>
							<td>${price.spec}</td>
							<td>${price.firm}</td>
							<td>${price.batch}</td>
							<td>${price.minPackageUnit}</td>
							<td>${price.priceMinPackage}</td>
							<td>${price.pharmaciesCode}</td>
							<td>${price.pharmaciesName}</td>
							<td><c:if test="${price.enable eq '0'}">有效</c:if> 
					    	 <c:if test="${price.enable eq '1'}">无效</c:if></td>
							<td style="text-align:center;"><a
								href="modPriceListTo.action?id=${price.id}">修&nbsp;改</a>
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