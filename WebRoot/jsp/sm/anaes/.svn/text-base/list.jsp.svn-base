<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<title>麻醉方法列表</title>
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
	function gotopage() {
		//查询form表单
		var queryForm = document.getElementById("form");
		document.getElementById("page").value = document
				.getElementById("gopage").value;
		queryForm.submit();
	}
function addMzff() {

	location.href="addMzffGo.action?functionid="+$('#functionid').val();
}

</script>
<!-- 分页代码 结束 -->
<body class="page-header-fixed" onload="paging_init()">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉方法列表</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>


		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
			<form id="form" action="mzffList.action" name="form" method="post">
			<input type="hidden" id="functionid" name="functionid" value="${functionid }">	
			<div class="table_input " >
				<div class="form-group pull-left" style="margin-bottom: 10px;">
				<input type="hidden" name="page" id="page" value="${page}" /> <input
					type="hidden" name="userid" id="id" value="${id}" /> 代码：<input style="width: 120px;"
					name="code" size="8" value="${code}" />&nbsp;&nbsp; 名称：<input style="width: 120px;"
					name="mname" size="8" value="${mname}" />&nbsp;&nbsp; 有效标志：<select style="width: 100px;"
					name="yx">
					<option></option>
					<option value="0" <c:if test="${yx eq '0'}">selected</c:if>>有效</option>
					<option value="1" <c:if test="${yx eq '1'}">selected</c:if>>无效</option>
				</select>&nbsp;&nbsp; 常用标志：<select name="cy" style="width: 100px;">
					<option></option>
					<option value="0" <c:if test="${cy eq '0'}">selected</c:if>>常用</option>
					<option value="1" <c:if test="${cy eq '1'}">selected</c:if>>不常用</option>
				</select>
				<c:if test="${selectRole eq true }">
					<button type="button" class="button_blue_74_33" onclick="submit()">查询</button>
				</c:if>
				<c:if test="${addRole eq true }">	
					<button type="button" class="button_blue_74_33" onclick="addMzff()">新增</button>
				</c:if>	
				</div>
			</div>
				<table class="table table-bordered table-striped header-spcing" id="table">
				<thead>
					<tr class="bj">
						<td>序号</td>
						<td>代码</td>
						<td>一级分类</td>
						<td>二级分类</td>
						<td>三级分类</td>
						<td>名称</td>
						<td>是否有效</td>
						<td>是否常用</td>
						<c:if test="${updateRole eq true }">
						<td style="text-align:center">管理</td>
						</c:if>
					</tr>
				</thead>	
					<c:forEach items="${mzffList}" var="mzff">

						<tr>
							<td><input name="ids" type="hidden" value="${mzff.code}" /><%=xh++%></td>
							<td>${mzff.code}</td>
							<td>${mzff.cate1}</td>
							<td>${mzff.cate2}</td>
							<td>${mzff.cate3}</td>
							<td>${mzff.name}</td>
							<td><c:if test="${mzff.isValid eq '0' }">有效</c:if> <c:if
									test="${mzff.isValid eq '1'}">无效</c:if></td>

							<td><c:if test="${mzff.isUsually eq '0'}">常用</c:if> <c:if
									test="${mzff.isUsually eq '1'}">不常用</c:if></td>
							<c:if test="${updateRole eq true }">
							<td style="text-align:center;"><a
								href="modMzffListTo.action?id=${mzff.code}&functionid=${functionid}">修&nbsp;改</a></td>
							</c:if>	
							
						</tr>

					</c:forEach>


				</table>
				<!-----------分页文件引入----->
				<c:if test="${not empty mzffList }">
				<%@include file="/common/page.jsp"%>
				</c:if>
			</form>
         <input type="button" onclick="readXml()">
		</div>
	</div>
</div>
</body>
 

</html>