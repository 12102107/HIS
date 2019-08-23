<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计</title>
<style type="text/css">
ul,li {
	margin: 0;
	padding: 0;
	font: 12px normal "宋体", Arial, Helvetica, sans-serif;
	list-style: none;
}

a {
	text-decoration: none;
	color: #000;
	font-size: 12px;
}

#tabbox {
	width: auto;
	overflow: hidden;
	margin: 0 auto;
}

.tab_conbox {
	border: 1px solid #999;
	border-top: none;
	margin-left: 10px;
	margin-right: 10px;
}

.tab_con {
	display: none;
	height: 100%
}

.tabs {
	height: 32px;
	border-bottom: 1px solid #999;
	border-left: 1px solid #999;
	margin-left: 10px;
	margin-right: 10px;
}

.tabs li {
	height: 31px;
	line-height: 31px;
	float: left;
	border: 1px solid #999;
	border-left: none;
	margin-bottom: -1px;
	background: #F9F9F9;
	overflow: hidden;
	position: relative;
}

.tabs li a {
text-decoration: none;
	display: block;
	padding: 0 20px;
	border: 1px solid #fff;
	outline: none;
}

.tabs li a:hover {
	background: #ccc;
}

.tabs .thistab,.tabs .thistab a:hover {
	background:#1CAAD1;
	border-bottom: 1px solid #fff;
}

.tab_con {
	padding: 12px;
	font-size: 14px;
	line-height: 175%;
}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagejs/jqPaginator.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
<link
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/js/validate/jquery.validate.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/validate/messages_cn.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap/bootstrap.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>

<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {
		
		jQuery.jqtab = function(tabtit, tabcon) {
			$(tabcon).hide();
			$(tabtit + " li:first").addClass("thistab").show();
			$(tabcon + ":first").show();
			$(tabtit + " li").click(function() {
				$(tabtit + " li").removeClass("thistab");
				$(this).addClass("thistab");
				$(tabcon).hide();
				var activeTab = $(this).find("a").attr("tab");
				$("#" + activeTab).fadeIn();
				return false;
			});
		};
		/*调用方法如下：*/
		$.jqtab("#tabs", ".tab_con");
		/*初始化进入麻醉例数统计*/
		$("#iframemzls").attr("src","<%=request.getContextPath()%>/mzls/mzlsList.action");
	});
	/*点击进入ASA统计*/
	function iframeasa() {
		$("#iframeasa").attr("src","<%=request.getContextPath()%>/asa/asaList.action");
	}
	/*点击进入术前术后诊断差异统计*/
	function iframesqsh() {
		$("#iframesqsh").attr("src","<%=request.getContextPath()%>/sqsh/sqshList.action");
	}
	/*点击进入工作时长统计*/
	function iframesc() {
		$("#iframesc").attr("src","<%=request.getContextPath()%>/statistics/workingTime.action");
	}
	/*点击进入手术等级统计*/
	function iframessdj() {
		$("#iframessdj").attr("src","<%=request.getContextPath()%>/statistics/levelStatistics.action");
	}
	/*点击进入镇痛治疗例数统计*/
	function iframesqZt() {
		$("#iframesqZt").attr("src","<%=request.getContextPath()%>/statistics/analgesiaStatistics.action");
	}
	/*点击进入心肺复苏治疗例数统计*/
	function iframesqXf() {
		$("#iframesqXf").attr("src","<%=request.getContextPath()%>/statistics/cprStatistics.action");
	}
	/*点击进入麻醉复苏管理例数统计*/
	function iframesqFs() {
		$("#iframesqFs").attr("src","<%=request.getContextPath()%>/statistics/recoveryStatistics.action");
	}
	/*点击进入NISS例数统计*/
	function iframesqNiss() {
		$("#iframesqNiss").attr("src","<%=request.getContextPath()%>/statistics/nissStatistics.action");
	}
	/*点击进入麻醉方法统计*/
	function iframesqMethod() {
		$("#iframesqMethod").attr("src","<%=request.getContextPath()%>/statistics/methodStatistics.action");
	}
</script>
</head>
<body class="page-header-fixed">

	<div id="tabbox">

		<ul class="tabs" id="tabs">
			<li><a style="padding-right: 9px;padding-left: 9px;" tab="tab1">麻醉例数统计</a>
			</li>
			<!-- <li><a style="padding-right: 9px;padding-left: 9px;" tab="tab2">科室-麻醉方法例数统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" tab="tab3">麻醉医师-麻醉方法例数统计</a>
			</li> -->
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframeasa()" tab="tab4">ASA统计</a></li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframessdj()" tab="tab5">手术等级统计</a>
			</li>
			<!-- <li><a style="padding-right: 9px;padding-left: 9px;" tab="tab6">修改痕迹统计</a>
			</li> -->
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesc()" tab="tab8">工作时长统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesqsh()" tab="tab9">术前术后诊断差异统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesqZt()" tab="tab10">镇痛治疗例数统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesqXf()" tab="tab11">心肺复苏治疗例数统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesqFs()" tab="tab12">麻醉复苏管理例数统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesqNiss()" tab="tab13">NISS统计</a>
			</li>
			<li><a style="padding-right: 9px;padding-left: 9px;" onclick="iframesqMethod()" tab="tab14">麻醉方法统计</a>
			</li>
			
		</ul>
		<ul class="tab_conbox">
			<li id="tab1" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframemzls" name="iframemzls"
					onload="iFrameMzlsHeight()"></iframe> <script
					type="text/javascript" language="javascript">
						function iFrameMzlsHeight() {

							var ifm = document.getElementById("iframemzls");

							var subWeb = document.frames ? document.frames["iframemzls"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script>
			</li>



<!-- 
			<li id="tab2" class="tab_con">科室-麻醉方法例数统计</li>





			<li id="tab3" class="tab_con">麻醉医师-麻醉方法例数统计</li> -->









			<li id="tab4" class="tab_con">
			<iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframeasa" name="iframeasa"
					onload="iFrameAsaHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iFrameAsaHeight() {

							var ifm = document.getElementById("iframeasa");

							var subWeb = document.frames ? document.frames["iframeasa"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>
			<li id="tab5" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframessdj" name="iframessdj"
					onload="iFrameSsdjHeight()"></iframe> 
					<script type="text/javascript" language="javascript">
						function iFrameSsdjHeight() {

							var ifm = document.getElementById("iframessdj");

							var subWeb = document.frames ? document.frames["iframessdj"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>


		<!-- 	<li id="tab6" class="tab_con">修改痕迹统计</li> -->



			


			<li id="tab8" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesc" name="iframesc"
					onload="iFrameScHeight()"></iframe> 
					<script type="text/javascript" language="javascript">
						function iFrameScHeight() {

							var ifm = document.getElementById("iframesc");

							var subWeb = document.frames ? document.frames["iframesc"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>
			
			
			<li id="tab9" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesqsh" name="iframesqsh"
					onload="iFrameSqshHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iFrameSqshHeight() {

							var ifm = document.getElementById("iframesqsh");

							var subWeb = document.frames ? document.frames["iframesqsh"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>
					
			<li id="tab10" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesqZt" name="iframesqZt"
					onload="iframesqZtHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iframesqZtHeight() {

							var ifm = document.getElementById("iframesqZt");

							var subWeb = document.frames ? document.frames["iframesqZt"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>
			<li id="tab11" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesqXf" name="iframesqXf"
					onload="iframesqXfHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iframesqXfHeight() {

							var ifm = document.getElementById("iframesqXf");

							var subWeb = document.frames ? document.frames["iframesqXf"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>
			<li id="tab12" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesqFs" name="iframesqFs"
					onload="iframesqFsHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iframesqFsHeight() {

							var ifm = document.getElementById("iframesqFs");

							var subWeb = document.frames ? document.frames["iframesqFs"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>
			<li id="tab13" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesqNiss" name="iframesqNiss"
					onload="iframesqNissHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iframesqNissHeight() {

							var ifm = document.getElementById("iframesqNiss");

							var subWeb = document.frames ? document.frames["iframesqNiss"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>		
			<li id="tab14" class="tab_con"><iframe marginheight="0"
					marginwidth="0" frameborder="0" scrolling="no" width=100%
					height=100% id="iframesqMethod" name="iframesqMethod"
					onload="iframesqMethodHeight()"></iframe> <script type="text/javascript"
					language="javascript">
						function iframesqMethodHeight() {

							var ifm = document.getElementById("iframesqMethod");

							var subWeb = document.frames ? document.frames["iframesqMethod"].document
									: ifm.contentDocument;

							if (ifm != null && subWeb != null) {

								ifm.height = subWeb.documentElement.scrollHeight;

							}

						}
					</script></li>						
		</ul>
</div>

</body>
</html>