<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户登录</title>
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
	<script>
	var err = "${requestScope.info}";
	if(err.length>0){
		alert(err);
	}
	//登录
	function tijiao(){
		$("#dlname").val($.trim($("#dlname").val()));
		$("#dlpwd").val($.trim($("#dlpwd").val()));
		$("#dlform").submit();
	}
	</script>
	<link href="<%=path%>/css/login.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
   <div id="contaier">
   <div class="kuan">
    <div class="logo"><img src="<%=path%>/images/login/deglu_03.png" width="334" height="77" alt=""/></div>
      <div class="dlk">
        <div class="biaoge">
       		<form action="<%=path%>/user/login" method="post" id="dlform">
       			<table border="0" cellspacing="0" cellpadding="0">
				  <tbody>
				    <tr>
				      <td>用户名：</td>
				      <td><input id="dlname" type="text" name="userid"></td>
				      <td rowspan="2"><input type="button"  value="登陆" class="dl" onclick="tijiao()"> </td>
				    </tr>
				    <tr>
				      <td>密&nbsp;&nbsp;&nbsp;码：</td>
				      <td><input id="dlpwd" type="password" name="pwd"></td>
				    </tr>
				  </tbody>
				</table>
       		</form>
         </div>
         
      </div>
      <div class="wenzi">
           <p class="bah">Copyright   ********************* 黑ICP备00000000号</p>
           <p> 地址：哈尔滨市南岗区宣化街363号地宝大厦19层  邮编：150008  联系电话：0451-86331111</p>
         </div>
   </div>
</div>
  </body>
</html>
