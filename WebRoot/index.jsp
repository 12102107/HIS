<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>用户登录</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/validval/jquery.validVal.js"></script>
	<script type="text/javascript" src="<%=path%>/js/validval/jquery.validVal-customValidations.js"></script>
	<script type="text/javascript" src="<%=path%>/js/validval/jquery.validVal-debugger.js"></script>
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=path%>/css/landing-index.css" rel="stylesheet" type="text/css">
	<link href="<%=path%>/css/validval.css" rel="stylesheet" type="text/css">
	<link id="artDialog-skin" href="<%=path%>/js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="<%=path%>/js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
	<script type="text/javascript">
	var err = "${requestScope.info}";
	
	$(function() {
		if(err.length>0){
			art.dialog({
				title : '提示',
				content : err,
				ok:function(){
				}
			});
		}
		$('form[name="dlform"]').validVal();
		$.ajax({
			type : "post",
			url : "<%=path%>/hospital/getHospitalForLogin",
			async : false,
			error : function(request) {
				art.dialog({
					title : '提示',
					content : '获取医院信息失败，请刷新重试！',
					time : 1000,
					zIndex : 9100
				});
			},
			//成功执行
			success : function(data) {
				var hospitalJson=jQuery.parseJSON(data);
				if(hospitalJson&&hospitalJson.length>0){
					if(hospitalJson.length==1){
						$("#hospitalId").append("<option value=\""+hospitalJson[0].CODE+"\">"+hospitalJson[0].NAME+"</option>"); 
					}else{
						for(var i=0;i<hospitalJson.length;i++){
							$("#hospitalId").append("<option value=\""+hospitalJson[i].CODE+"\">"+hospitalJson[i].NAME+"</option>");
							$("#hospitalId").css("display","inline");
						}
					}
				}
			}
		});
	});
	
	//登录
	function tijiao(){
		$("#dlname").val($.trim($("#dlname").val()));
		$("#dlpwd").val($.trim($("#dlpwd").val()));
		$("#dlform").submit();
	}
	</script>
	
  </head>
  
  <body class="page-header-fixed">
	<div class="logo"><a href="#"><img src="<%=path%>/images/logo_03.png"></a></div>
    <div class="page-container">
    <form action="<%=path%>/system/login" method="post" id="dlform" name="dlform">
    	<div style=" width:700px; margin:0 auto">
            <div class="ren pull-left"><img src="<%=path%>/images/ren_03.png"></div>
            <div class="xian pull-left"><img src="<%=path%>/images/xian_06.png"></div>
            <div class="text pull-left"><img src="<%=path%>/images/text_06.png"></div>
            <div class="input"><input id="dlname" type="text" name="userid" class="required" placeholder="用户名"></div>
            <div class="input"><input id="dlpwd" type="password" name="pwd" class="required" placeholder="密码">
            	<select id="hospitalId" name="hospitalcode" style="display:none">
            	</select></div>
            <div class="button">
            	<input type="button" onclick="tijiao()">
                <a href="#"><img src="<%=path%>/images/text_33.png"></a>
            </div>
        </div>
        </form>
    </div>
    <div class="footer"><p>版权所有：伍连德顺迈医院 <span>服务热线：0451-88888888  13636363636</span>  </p></div>

</body><%--


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
--%></html>
