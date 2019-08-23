<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%
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
<title>科室列表</title>
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
function addDept() {
	location.href="addInstrumentTo.action?functionid="+$('#functionid').val();
}
function submit() {
	$('#form').submit();
}
function delI(id) {
	if(confirm("确认删除？")) {
		$.post("delInstrument.action",{id:id},function(){
			alert("删除成功！");
			$('#form').submit();
		});
	}
}	
</script>
<!-- 分页代码 结束 -->
<body class="page-header-fixed" onload="paging_init()">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">器械列表</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">

			<form id="form" action="getInstrumentList.action" name="form" method="post">
			<input type="hidden" id="functionid" name="functionid" value="${functionid }">
			<div class="table_input " >
				<div class="form-group pull-left" style="margin-bottom: 10px;">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" /> 
				名称：
				<input style="width: 120px;" name="name" size="8" value="${name}" />&nbsp;&nbsp; 
				常用：<select style="width: 100px;" name="common">
					<option></option>
					<option value="0" <c:if test="${common eq '0'}">selected</c:if>>是</option>
					<option value="1" <c:if test="${common eq '1'}">selected</c:if>>否</option>
				</select>
				<%-- <c:if test="${selectRole eq true }"> --%>	
					<button type="button" class="button_blue_74_33" onclick="submit()">查询</button>
				<%-- </c:if>
				<c:if test="${addRole eq true }">	 --%>
					<button type="button" class="button_blue_74_33" onclick="addDept()">新增</button>
				<%-- </c:if>	 --%>
				</div>
			</div>

				<table class="table table-bordered table-striped header-spcing" id="table">
					<thead>
					<tr class="bj">
						<td>序号</td>
						<td>名称</td>
						<td>规格</td>
						<td>单位</td>
						<td>是否常用</td>
						<%-- <c:if test="${updateRole eq true }"> --%>
						<td colspan="4" style="text-align:center">管理</td>
						<%-- </c:if> --%>
					</tr>
					</thead>
					<c:forEach items="${list}" var="i" varStatus="s">
						<tr>
							<td><input name="ids" type="hidden" value="${i.id}" />${s.index+1 }</td>
							<td>${i.name}</td>
							<td>${i.specifications}</td>
							<td>${i.unit}</td>
							<td><c:if test="${i.common eq '0'}">是</c:if> <c:if
									test="${i.common eq '1'}">否</c:if>
							</td>
							<%-- <c:if test="${updateRole eq true }"> --%>
							<td style="text-align:center;">
							<a href="modInstrumentTo.action?id=${i.id}&functionid=${functionid}">修改</a>
							&nbsp;&nbsp;
							<a href="javascript:void(0)" onclick="delI('${i.id}')">删除</a>
						<%-- 	</c:if>	 --%>

						</tr>
					</c:forEach>
				</table>
				<!-----------分页文件引入----->
				<c:if test="${not empty list }">
				<%@include file="/common/page.jsp"%>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>