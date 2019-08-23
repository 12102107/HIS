<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	int xh = (Integer) request.getAttribute("xh");
	String workid = (String)request.getAttribute("workid");
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
<link rel="stylesheet" type="text/css"
	href="../js/easyui-1.4.1/themes/default/easyui.css" />
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>
<script type="text/javascript"
	src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css"
	rel="stylesheet" />
<script src="../js/artDialog5.0/source/artDialog.js"
	type="text/javascript"></script>
<title>端口配置列表</title>
</head>
<!-- 分页代码 开始 -->
<script type="text/javascript">
	var info="<%=info%>";
	if (info.length > 0) {
		alert(info);
	}

var workid="<%=workid%>";
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
	function addPort() {
		location.href = "addPortGo.action?functionid=" + $('#functionid').val();
	}
	function submit() {
		$('#form').submit();
	}
	function queding() {
		var v = $('input[name="portid"]:checked').val();
		if (v.length>0) {
			location.href = "modStationGo.action?functionid=" + $('#functionid').val()+"&portid="+v+"&workid="+workid;
		}
	}
</script>
<!-- 分页代码 结束 -->
<body class="page-header-fixed" onload="paging_init()">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">端口配置</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>


		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
				<form id="form" action="portList.action" name="form" method="post">
					<input type="hidden" id="functionid" name="functionid"
						value="${functionid}">
					<div class="table_input ">
						<div class="form-group pull-left" style="margin-bottom: 10px;">
							<input type="hidden" name="page" id="page" value="${page}" /> <input
								type="hidden" name="userid" id="id" value="${id}" />
							<button type="button" class="button_blue_74_33"
								onclick="addPort()">新增</button>

						</div>
					</div>
					<table class="table table-bordered table-striped header-spcing"
						id="table">
						<thead>
							<tr class="bj">
								<td>序号</td>
								<td>设备型号</td>
								<td>版本标记</td>
								<td>波特率</td>
								<td>串口参数</td>
								<td style="text-align:center">管理</td>
							</tr>
						</thead>
						<c:forEach items="${portList}" var="port">

							<tr>
								<td><input type="radio" name="portid" value="${port.id}" <c:if test="${port.id eq ws.portId}">checked</c:if>/>
								</td>
								<td>${port.model}</td>
								<td>${port.edition}</td>
								<td>${port.baudrate}</td>
								<td>${port.serial}</td>

								<td style="text-align:center;"><a
									href="modPListTo.action?id=${port.id}&functionid=${functionid}">修&nbsp;改</a>
								</td>

							</tr>
						</c:forEach>

					</table>
					<center>
						<input type="button" value="确定" style="margin-top: 10px;"
							class="btn btn-primary btn-sm" onclick="queding()">
					</center>
					<!-----------分页文件引入----->
					<c:if test="${not empty wsList }">
						<%@include file="/common/page.jsp"%>
					</c:if>
				</form>
			</div>
		</div>
	</div>
</body>


</html>