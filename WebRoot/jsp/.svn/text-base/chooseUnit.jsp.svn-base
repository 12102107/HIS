<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
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
.hvr-shutter-out-vertical {
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
  -moz-osx-font-smoothing: grayscale;
  position: relative;
  background: #FFF;
  border: solid 1px #c2c2c2;
  padding: 1em;
margin:3%;
  -webkit-transition-property: color;
  transition-property: color;
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
  text-decoration: none;
color:#000;
font-size:15px;
font-weight:550;
min-width:66px;
text-align: center;
-moz-box-shadow:2px 2px 5px #4A4A4A;
     -webkit-box-shadow:2px 2px 5px #4A4A4A;
     box-shadow:2px 2px 5px #4A4A4A;
}
.hvr-shutter-out-vertical:before {
  content: "";
  position: absolute;
  z-index: -1;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: #2098d1;
  -webkit-transform: scaleY(0);
  transform: scaleY(0);
  -webkit-transform-origin: 50%;
  transform-origin: 50%;
  -webkit-transition-property: transform;
  transition-property: transform;
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-timing-function: ease-out;
  transition-timing-function: ease-out;
     
}
.hvr-shutter-out-vertical:hover, .hvr-shutter-out-vertical:focus, .hvr-shutter-out-vertical:active {
  color: white;
}
.hvr-shutter-out-vertical:hover:before, .hvr-shutter-out-vertical:focus:before, .hvr-shutter-out-vertical:active:before {
  -webkit-transform: scaleY(1);
  transform: scaleY(1);
}
</style>
<link rel="stylesheet" href="../css/main.css" type="text/css" />
</head>
<body>
	<div class="zhong_right">
		<div class="bingrenguanhli">
		<h3>您有多个科室，请选择其中一个登录。</h3>
<hr>
         <c:if test="${not empty requestScope.units&&requestScope.units.size()>0}">
            <input id="selUnitSize" type="hidden" value="${requestScope.units.size() }"></input>
            <c:if test="${requestScope.units.size()==1}">
            <input id="unitOneId" type="hidden" value="${requestScope.units[0].TID }"></input>
            </c:if>
 			<c:forEach items="${requestScope.units }" var="unit">
 				<a href="${requestScope.MoreUnitUrl}&selUnitid=${unit.TID}"
					class="hvr-shutter-out-vertical">${unit.TNAME }</a>
 			</c:forEach>
 		 </c:if>
		</div>
	</div>
</body>
</html>
