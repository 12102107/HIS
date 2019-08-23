<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%>
<!doctype html>
<html>
<head>
<title>menu</title>

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet" type="text/css" />

<link href="${pageContext.request.contextPath}/css/default.css"
	rel="stylesheet" type="text/css" id="style_color" />

<link href="${pageContext.request.contextPath}/css/Two_navigation.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"
	type="text/javascript"></script>
<!-- 左侧菜单-->
<script type="text/javascript">
      	
			$(function(){  
				$('.nav_1j >ul,.nav_2j > li >ul').show();
			});
			
			function sl(dom){			
				$('.nav_2j').slideUp("fast");
			
				if($(dom).siblings("ul").css("display")!="block"){
						$(dom).siblings("ul").slideToggle('fast');	
				}
				
			}
			function changeMenu(){
				$(".page-sidebar1").hide();
				$(".page-button").show();
				window.parent.document.getElementsByTagName("frameset")[1].cols="30,*"; 
				//$(".page-button").append("<img src='../images/menu_botton.png' onClick='visMenu();' />");
			//if($(".page-container").hasClass("left-side-collapsed")){
			//	$(".page-container").removeClass("left-side-collapsed");
			//}else{
			//	$(".page-container").addClass("left-side-collapsed");
			//}		
			
		}
			function visMenu(){
				window.parent.document.getElementsByTagName("frameset")[1].cols="270,*"; 
				$(".page-button").hide();
				$(".page-sidebar1").show();
			}
       </script>
<style type="text/css">
.hide {
	display: none;
}

.show {
	display: block;
}
</style>

</head>
<body class="page-header-fixed" style="overflow-x:hidden">
	<div class="page-container">
		<div class="page-button" style="display: none ">
			<img src='../images/menu_botton.png' onClick='visMenu();' />
		</div>
		<div class="page-sidebar1 ">
			<!-- BEGIN SIDEBAR MENU -->

			<ul class="page-sidebar-menu">

				<li  style="position:fixed;top:0px;">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="menu_title">
						<div class="text">${requestScope.sysname }</div>
						<a href="javascript:void(0)" class="buttons1" onClick="changeMenu()"><img
							src="../images/menu-toggler.png" alt="" /> </a>
					</div> 
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<div class="clear"></div>
				<c:forEach items="${menus}" var="menu" varStatus="status">
					<li class="nav_menu_1 nav_1j dh_1j_${ status.index + 1}"
					<c:if test="${status.index == 0}">style="margin-top: 40px;"</c:if>  >
						<c:if test="${!empty menu['menu2list']}">
						   <!-- 存在二级菜单 -->
							<div onClick="sl(this)">
								<font class="pull-left">${menu['name']}</font> <img
									src="../images/left/left_nav_1_title_icon.png"
									class="pull-right">
								<div class="clear"></div>
							</div>
							<ul class="nav nav-list nav_2j dh_2j_${ status.index + 1}">
								<c:forEach items="${menu['menu2list']}" var="menu2"
									varStatus="status2">
									<li>
										<c:if test="${!empty menu2['menu3list']}">
										   <!-- 存在三级菜单 -->
											<img src="../images/left/Cashier_icon.png"
											<c:if test="${(status2.index + 1)==1 }">class="pull-left spacing"</c:if>
											<c:if test="${(status2.index + 1)!=1 }">class="pull-left"</c:if>>
													<a href="menuframe.action?functionid=${menu2['id2'] }"
													target="mainFrame">${menu2['name2']}</a>
											<span class="badge_rectangle_default pull-right"></span>
										</c:if>
										<c:if test="${empty menu2['menu3list']}">
          		 	 					   <!-- 不存在三级菜单 -->
          		 	 					   <img src="../images/left/Cashier_icon.png"
											<c:if test="${(status2.index + 1)==1 }">class="pull-left spacing"</c:if>
											<c:if test="${(status2.index + 1)!=1 }">class="pull-left"</c:if>>
												<c:if test="${!empty menu2['url'] && !fn:startsWith(menu2['url'],'#') }">
													<a href="../${menu2.url}"
													target="mainFrame">${menu2['name2']}</a>
												</c:if> 
												<c:if test="${empty menu2['url'] || fn:startsWith(menu2['url'],'#')}">
													<a href="javascript:void(0)"
													target="mainFrame">${menu2['name2']}</a>
												</c:if> 
											<span class="badge_rectangle_default pull-right"></span>
          		 	 					</c:if>
									</li>
								</c:forEach>
							</ul>
						</c:if>
						<c:if test="${empty menu['menu2list']}">
						  <!--不存在二级菜单 -->
							<c:if test="${!empty menu['url'] && !fn:startsWith(menu['url'],'#') }">
								<div >
									<a href="../${menu.url}"
										target="mainFrame"><font class="pull-left">${menu['name']}</font></a> <img
										src="../images/left/left_nav_1_title_icon.png"
										class="pull-right">
								<div class="clear"></div>
							</div>
							</c:if>
							<c:if test="${empty menu['url'] || fn:startsWith(menu['url'],'#') }">
								<div>
									<font class="pull-left">${menu['name']}</font> <img
										src="../images/left/left_nav_1_title_icon.png"
										class="pull-right">
									<div class="clear"></div>
								</div>
							</c:if>
						</c:if>
					</li>
				</c:forEach>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
</body>
</html>




