<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<title>欢迎使用光网科技智能医院意见箱系统</title>
<style>
body {
	overflow-x: hidden;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script>
	function check() {
		if ($('input:radio[name="roleid"]:checked').val() == null) {
			alert("请选择其中某个角色！");
			return false;
		}

		document.form.submit();
	}
</script>
</head>
<body>
	<center>
		您有多个角色，请选择其中一个登录。<br />
		<form name="form" action="loginRole" method="post">
			<s:iterator value="#request.rl" var="w">
				<input type="radio" name="roleid" value="${w.id }">${w.name }&nbsp;
 </s:iterator>
			<br /> <input type="button" value="登录" onclick="check()">
		</form>
	</center>
	<iframe src="${pageContext.request.contextPath}/jsp/shua.jsp" style="width: 0px;" frameborder="0"></iframe>
</body>
</html>
