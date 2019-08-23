<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- ZTree树形插件 -->

<link rel="stylesheet"
	href="../js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="../js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="../js/zTree_v3/js/jquery.ztree.all-3.5.min.js"></script>

<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
<link href="../css/List.css" rel="stylesheet" type="text/css">

<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.min.css"
	type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap/bootstrap.css"
	type="text/css"></link>
<script src="../js/bootstrap.min.js"></script>
<style>
.text-overflow input {
	width: 180px;
	overflow: hidden;
	white-space: nowrap;
	-o-text-overflow: ellipsis;
	text-overflow: ellipsis;
	-moz-binding: url('ellipsis.xml#ellipsis');
}
</style>
<title>知识库目录</title>
</head>

<script type="text/javascript">
	    var zTree;
	var setting = {
		view : {
			selectedMulti : false
		},
		//edit : {
			//enable : true,
			//editNameSelectAll : true,
			//removeTitle : "删除",
			//renameTitle : "重命名"
		//},
		data : {
			keep : {
				parent : true,
				leaf : true
			},
			simpleData : {
				enable : true
			}
		},
		callback : {
		beforeRemove : beforeRemove,//点击删除时触发，用来提示用户是否确定删除
			//beforeEditName : beforeEditName,//点击编辑时触发，用来判断该节点是否能编辑
			beforeRename : beforeRename,//编辑结束时触发，用来验证输入的数据是否符合要求
			onRemove : onRemove,//删除节点后触发，用户后台操作
			onRename : onRename,//编辑后触发，用于操作后台
			beforeDrag : beforeDrag,//用户禁止拖动节点
			onClick : clickNode, //点击节点触发的事件

		}
	};
	var treeNodes;

	//初始化加载菜单
	$(document).ready(function() {
		
		$.ajax({  
			        async : false,  
			         cache:false,  
			         type: 'POST',  
			        dataType : "json",  
			        url:"<%=request.getContextPath()%>/zsk/zskList.action",//请求的action路径  
			        error: function () {//请求失败处理函数  
			            alert('请求失败');  
			         },  
			        success:function(data){ //请求成功后处理函数。    
			          //alert(data);  
			             treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
			         }  
			      });  
		 
		zTree = $.fn.zTree.init($("#tree"), setting, treeNodes);
		
	});
	
	function beforeRemove(e, treeId, treeNode) {
		return confirm("你确定要删除吗？");
	}
	function onRemove(e, treeId, treeNode) {

		if (treeNode.isParent) {
			var childNodes = zTree.removeChildNodes(treeNode);
			var paramsArray = new Array();
			for ( var i = 0; i < childNodes.length; i++) {
				//paramsArray.push(childNodes[i].id);
			}
             alert("删除父节点的id为：" + treeNode.id + "\r\n他的孩子节点有："
					+ paramsArray.join(","));
			return ;
		}
		
		alert("你点击要删除的节点的名称为：" + treeNode.name + "\r\n" + "节点id为："
				+ treeNode.id);
	}
	function beforeEditName(treeId, treeNode) {
		if (treeNode.isParent) {
			alert("不准编辑非叶子节点！");
			return false;
		}
		return true;
	}
	function beforeRename(treeId, treeNode, newName, isCancel) {
		if (newName.length < 3) {
			alert("名称不能少于3个字符！");
			return false;
		}
		return true;
	}
	function onRename(e, treeId, treeNode, isCancel) {
		alert("修改节点的id为：" + treeNode.id + "\n修改后的名称为：" + treeNode.name);
	}
	function clickNode(e, treeId, treeNode) {
		$("#yc").val(treeNode.id);
		$("#fuJieDianOrNot").val(treeNode.isParent);
		var knowId = treeNode.id;
			$.ajax({
			      type:"post",
			      url:"<%=request.getContextPath()%>/zsk/queryZskSummaryById.action",
			      data:{
			    	  knowId:knowId,
			      },
			      async:false,
			      success:function(data){
			    	  if (data!="1") {
							$("#summary").html(data);
						}if (data=="1") {
			    		  $("#summary").empty();
			    		  
					} 
			    	  	}
			           
			    });
	}
	
	
	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	/**
	 * 文件上传不为空
	 */
	function checkFile() {
		if ($("#upload").val() != null) {
			$('#submit').attr("disabled", false);
		}
	}
	/**
	 * 名称不为空
	 */
	function checkCat() {
		if ($("#cat").val().trim() !=null) {
			$('#submitCat').attr("disabled", false);
		}
	}
	/**
	 * 模态框遮罩解决方法
	 */
	function qieHuan() {
		document.getElementById("myModal2").style.zIndex = 9999;
	}
	/**
	 * 文档下载
	 */
function download() {
   if ($("#yc").val()!=""&&$("#fuJieDianOrNot").val()=="false") {
   location.href="<%=request.getContextPath()%>/zsk/fileDownload.action?knowId="+ $("#yc").val();
		}
	}
	/**
	 * 删除选中节点
	 */
	function shanchuNodes() {

		if ($("#fuJieDianOrNot").val() == "true") {
			alert("不准删除非空目录！");
			return;
		}
		if ($("#fuJieDianOrNot").val() == "false") {

			location.href = "zskDel.action?knowId=" + $("#yc").val();

		}	
	}
</script>
<body class="page-header-fixed">
	<div class="page-container">
		<div>
			<div style="float:left;width:25%;">
				<div class="Bread_crumbs">
					<font class="pull-left">知识库目录</font>
				</div>
				<ul id="tree" class="ztree" style="width: 400px; overflow:hidden;"></ul>
			</div>
			<div class="Bread_crumbs" style="margin-left: 30%;margin-right: 5%;">
				<font class="pull-left">内容简介 </font> <input type="hidden" id="yc" />
				<input type="hidden" id="fuJieDianOrNot" />
			</div>
			<div id="summary"
				style="margin-left: 30%;margin-right: 5%;height: 400px;"></div>
			<div style="margin-left: 35%;margin-top:5%;">
				<input value="新建目录" type="button" class="btn btn-primary"
					data-toggle="modal" type="button" data-target="#myModal">
				&nbsp;&nbsp; <input data-toggle="modal" data-target="#myModal2"
					type="button" value="导入文档" class="btn btn-primary"
					onclick="qieHuan()"> &nbsp;&nbsp; <input
					class="btn btn-primary" value="打开文档" type="button"
					onclick="download()"> &nbsp;&nbsp;
				<button class="btn btn-primary" onclick="shanchuNodes()">删除文档</button>
			</div>
		</div>
	</div>
	<!-- 导入文档模态框 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		style="width:550px;height: 500px;" aria-labelledby="myModalLabel2"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel2">导入文档</h4>
				</div>
				<div class="modal-footer">
					<form action="<%=request.getContextPath()%>/zsk/fileUpload.action"
						method="post" ENCTYPE="multipart/form-data">
                        <table class="table table-bordered table-striped header-spcing">
							<tr>
								<td>文件：</td>
								<td class="text-overflow"><input type="file" name="upload"
									id="upload" onchange="checkFile()" />
								</td>
							</tr>
							<tr>
								<td>所属类别</td>
								<td><select name="ms.pid">
										<c:forEach items="${msList}" var="ms">
											<option value="${ms.id}">${ms.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>简介：</td>
								<td><textarea name="ms.summary" id="summary" required
										placeholder="必填项，最多可输入300字" maxlength="300"
										style="height: 200px;width: 350px" class="form-control"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" style="text-align: right;"><input
									class="btn btn-primary" value="确定" type="submit" id="submit"
									disabled="disabled" />
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 新建类别模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		style="width: 500px;height: 250px;" aria-labelledby="myModalLabel1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel1">新建类别</h4>
				</div>
				<div class="modal-footer">
					<form action="<%=request.getContextPath()%>/zsk/addCatalog.action"
						method="post">
						<table class="table table-bordered table-striped header-spcing">
							<tr>
								<th>类别名称:</th>
								<td><input type="text" name="ms.name" required
									placeholder="必填项"></td>
							</tr>
						</table>
						<div class="modal-footer">
							<input class="btn btn-primary" value="确定" type="submit" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>