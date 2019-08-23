<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%>
<link href="${pageContext.request.contextPath}/css/preopDetail.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/addYpForm.css" type="text/css"></link> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/commn.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/js/My97DatePicker/skin/WdatePicker.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/comet4j.js"></script>
<script type="text/javascript" >
	function trim(){
		return str.replace(/(^\s*)|(\s*$)/g, "");
	}
	function ltrim(){
		return str.replace(/(^\s*)/g,"");
	}
	function rtrim(){
		 return str.replace(/(\s*$)/g,"");
	}
</script>
<%
	String userId = (String)request.getSession().getAttribute("userid");
	if(userId==null){
		//response.sendRedirect(pathUrl);
		%>
		<script type="text/javascript">
		if (window != top) 
			top.location.href = '${pageContext.request.contextPath}/index.jsp'; 
		</script>
		<%
	}
%>
