<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script charset="utf-8"
	src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/validate/jquery.validate.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<title>编辑工作站列表</title>

<script type="text/javascript">
//验证工作站ID
	function checkId(){
		var gzzId=$("#gzzId").val().trim();
		var re = true;
		if(gzzId==""){
			$("#gzzIddiv").html("工作站ID不能为空");
	        re=false;
		}
		$.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/gzz/checkId.action",
			data : {
				gzzId : gzzId,
			},
			async : false,
			success : function(data) {
				if(data=='1'){
        			$("#gzzIddiv").html("该名称已经存在");
        		}else{
                    $("#gzzIddiv").html("");
             
                 }
			}
		});
		return re;
	}
	
	 function check(){
			document.form.submit();
    }

//初始化时根据手术室类型查询手术室
	$(function(){
         var type=$(".room:selected").val();
          $.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/gzz/getRoom.action",
			data : {
				type : type,
			},
			async : false,
			success : function(data) {
				$("#room").html(data);
			}
		});
	});
	//根据手术室类型查询手术室
	   $(".room").live("click",function(){ 
         var type=$(".room:selected").val();
          $.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/gzz/getRoom.action",
			data : {
				type : type,
			},
			async : false,
			success : function(data) {
				$("#room").html(data);
			}
		});

	}); 
</script>
</head>
<body class="page-header-fixed">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">编辑工作站</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		<div class="responsive-table">
			<div class="scrollable-area">
				<form name="form"
					action="${pageContext.request.contextPath}/gzz/addStation.action"
					method="post" id="form">
					<input type="hidden" name="functionid" value="${functionid }">
					<input type="hidden" name="id" value="${ws.id}">
					<input type="hidden" name="ws.portId"  value="${port.id}">${port.id}
					<table class="table table-bordered table-striped header-spcing">
						<tr>
							<td bgcolor="#fff" style="vertical-align: middle;">工作站ID:<input
								type="text" id="gzzId" onkeyup="checkId()" name="ws.id"
							  value="${ws.id}" placeholder="必填项，保存后不可更改！">
								<div id="gzzIddiv" class="div1"></div></td>
						</tr>
						<tr>
							<td bgcolor="#fff">手术室类型:<select name="ws.type"
								style="vertical-align: middle;">
									<option value="0" class="room"
										>手术室</option>
									<option value="1" class="room"
										>恢复室</option>
							</select></td>
						</tr>
						<tr>
							<td bgcolor="#fff">手术室:<select id="room" name="ws.room"
								style="vertical-align: middle;">
									<option class="room"></option>
							</select></td>
						</tr>
						<tr>
							<td bgcolor="#fff">采集服务器IP:<input type="text" name="ws.ip"
								></td>
						</tr>
						<tr>
							<td bgcolor="#fff">采集服务器端口:<input type="text" name="ws.port"
								></td>
						</tr>
						<tr>
							<td bgcolor="#fff">监控服务器IP:<input type="text"
								name="ws.controlIp"></td>
						</tr>
						<tr>
							<td bgcolor="#fff">监控服务器端口:<input type="text"
								name="ws.controlPort"></td>
						</tr>
						<tr>
							<td bgcolor="#fff">是否有效:<select name="ws.enable"
								style="vertical-align: middle;">
									<option value="0"
										>有效</option>
									<option value="1"
										>无效</option>
							</select></td>
						</tr>
						<tr>
			
							
							<td bgcolor="#fff">NET 端口:<input type="text" readonly="readonly"
								name="ws.netPort" value="${port.model}"> <a href="${pageContext.request.contextPath}/gzz/portList.action">配置</a>
							</td>
						
						</tr>


					</table>
					<div style="text-align: center; margin-top: 2%;">
						<button type="button" class="button_blue_74_33"
							style="border: medium none;" onclick="check()">确定</button>
						<button type="button" class="button_blue_74_33"
							style="border: medium none;"
							onclick="javascript:window.location.href = 'wsList.action?functionid=${functionid}'">取消</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>