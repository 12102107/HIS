<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>	
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<title>公告列表</title>
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

function addN() {
	location.href="addNoticeGo.action?functionid="+$('#functionid').val();
}

</script>
<!-- 分页代码 结束 -->
<body class="page-header-fixed" onload="paging_init()">

	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">公告管理</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
			<div class="table_input ">
				<div class="form-group pull-left" style="margin-bottom: 10px;">
				<c:if test="${addRole eq true }">
					<button type="button" class="button_blue_74_33" onclick="addN()">新增</button>
				</c:if>	
				</div>
			</div>
			
			<form id="form" action="nocList.action" name="form" method="post">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" />
			<input type="hidden" name="functionid" value="${functionid }" id="functionid">
				<table class="table table-bordered table-striped header-spcing" id="table">
					<thead>
						<tr class="bj">
						<td>序号</td>
						<td>发布时间</td>
						<td>标题</td>
						<td>发布人</td>
						<c:if test="${updateRole==true or delRole==true}">
						<td colspan="2" style="text-align:center">管理</td>
						</c:if>
						</tr>
					</thead>
					<c:forEach items="${nocList}" var="noc">
						<tr class="No">
							<td><input name="ids" type="hidden" value="${noc.id}" /><%=xh++%></td>
							<td>${fn:substring(noc.updateTime, 0,16)}</td>
	                        <td><a href="${pageContext.request.contextPath}/jsp/sm/notice/content.jsp?content=${noc.content}&&updateTime=${noc.updateTime}&&title=${noc.title}&&author=${noc.author}&&functionid=${functionid}">${noc.title}</a> </td>
							<td>${noc.author}</td>
							${name}
							<c:if test="${updateRole eq true }">
							<td style="text-align:center">
							<a href="modNoticeListTo.action?id=${noc.id}&functionid=${functionid}">修改</a>
							</td>
							</c:if>
							<c:if test="${delRole eq true }">
							<td style="text-align:center"><a
								href="delNotice.action?id=${noc.id}&functionid=${functionid}">删除</a>
							</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>

				<!-----------分页文件引入----->
				<c:if test="${not empty nocList }">
				<%@include file="/common/page.jsp"%>
				</c:if>
			</form>
		</div>
	</div>
</div>
</body>
</html>