<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>手术查询</title>
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

<script type="text/javascript">
function cancelSro(sroid,obj) {
	var value = prompt('取消原因：', '');  
	if(value == null){  
	   	return;
	}else if(value == ''){  
		alert('原因为空，请重新输入！');
		cancelSro(sroid,obj);  
	}else{
		var td = $(obj).parent();
		$.post("cancelSro.action",{sroid:sroid,reason:value},function(){
			alert("取消成功！");
			$(td).empty().append("<a href='javascript:void(0)' onclick='activateSro("+sroid+",this)'>激活</a>");
		});   
	} 
}

function activateSro(sroid,obj) {
	var td = $(obj).parent();
	$.post("activateSro.action",{sroid:sroid},function(){
		alert("激活成功！");
		$(td).empty().append("<a href='javascript:void(0)' onclick='changeSro("+sroid+")'>手术变更</a>&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='cancelSro("+sroid+",this)'>取消</a>");
	});
}

function changeSro(sroid) { 
	location.href="changeSroTo.action?functionid="+$('#functionid').val()+"&sroid="+sroid;
}
</script>

</head>
<body class="page-header-fixed">
<input type="hidden" value="${functionid }" id="functionid">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">手术查询</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->

		<div class="responsive-table">
			<div class="scrollable-area">
	<div class="form-group pull-left">
	<input style="border:0;background-color: #FF99FF;height:20px; width: 50px;"disabled="disabled">
	<input style="border:0;background-color: white;" value="为急诊手术" disabled="disabled">
	</div>

						<!-- 下面显示列表内容 -->
			<table class="table table-bordered table-striped header-spcing"
					id="table">
					<tbody>
						<thead>
							<tr class="bj" >
									<td>姓名</td>
									<td>性别</td>
									<td>年龄</td>
									<td>住院号</td>
									<td>病区</td>
									<td>床号</td>
									<td>术前诊断</td>
									<td>拟施手术</td>
									<td>建议麻醉方法</td>
									<td>手术医师</td>
									<td>预约单号</td>
									<td>手术变更</td>
								</tr>
						 	</thead>		
								<c:forEach items="${list }" var='r'>
									<tr >
										<td colspan="12" style="text-align: left; padding-left: 10px;">${r.day }</td>
									</tr>
									<c:forEach items="${r.sro }" var='sro'>
										<tr  style="<c:if test="${sro.type==0 }">background-color: #FF99FF;</c:if>">
											<td>${sro.name }</td>
											<td>
												<c:if test="${sro.sex==0 }">男
												</c:if>
												<c:if test="${sro.sex==1 }">女
												</c:if>
											</td>
											<td>${sro.age }</td>
											<td>${sro.hid }</td>
											<td>${sro.region }</td>
											<td>${sro.bed }</td>
											<td>${sro.diagnosisName }</td>
											<td>${sro.designedOptName }</td>
											<td>${sro.designedAnaesMethodName }</td>
											<td>${sro.operatorName }</td>
											<td>${sro.preengagementnumber }</td>
											<td>
												<c:choose>
												<c:when test="${sro.state eq 0 }">
													<c:if test="${activateRole eq true }">
													<a href="javascript:void(0)" onclick="activateSro('${sro.id }',this)">激活</a>
													</c:if>
												</c:when>
												<c:otherwise>
												<c:if test="${updateRole eq true }">
													<a href="javascript:void(0)" onclick="changeSro('${sro.id }')">手术变更</a>&nbsp;&nbsp;&nbsp;
												</c:if>
												<c:if test="${removeRole eq true }">	
													<a href="javascript:void(0)" onclick="cancelSro('${sro.id }',this)">取消</a>
												</c:if>	
												</c:otherwise>
												</c:choose>
											</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="12"> &nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
			</div>
		</div>
	</div>
</body>
</html>
