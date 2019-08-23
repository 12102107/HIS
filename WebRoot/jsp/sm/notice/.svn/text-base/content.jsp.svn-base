<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>/css/List.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<title>1</title>

</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">公告内容</font> <img
				src="<%=basePath%>/images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
			<div class="table_input ">
				<div class="form-group pull-left"style="margin-bottom: 10px;">
				<%     String functionid = request.getParameter("functionid"); %>
					<button type="button" class="button_blue_74_33" onclick="javascript:window.location.href = '${pageContext.request.contextPath}/noc/nocList.action?functionid=<%=functionid%>'">返回</button>
				</div>
			</div>
			<form id="form" action="" name="form" method="post">
				<table class="table table-bordered table-striped header-spcing" id="table">
			<% 
                request.setCharacterEncoding("UTF-8"); //防止乱码问题
                String content = request.getParameter("content");
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                 String updateTime = request.getParameter("updateTime");
                updateTime= updateTime.substring(0, 16);
            %>
						<tr>
							<th colspan="2" style="text-align: left;">标题</th></tr>
						<tr>
							<th colspan="2"><center><%=title%></center> </th></tr>
						<tr> <th colspan="2" style="text-align: left;">内容</th></tr>
					    <tr> <td colspan="2" style="white-space:normal;padding-left: 100px;padding-right: 100px;"><%=content%></td></tr>
					    <tr> <td style="text-align: right;padding-right: 50px;" > 发布人：<%=author%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=updateTime%></td> </tr>
						
       
				</table>
			</form>
		</div>
	</div>
</div>	
</body>
</html>