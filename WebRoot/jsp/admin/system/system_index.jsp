<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>用户平台</title>

<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link href="../css/platform-index.css" rel="stylesheet" type="text/css">
<link href="../css/platform-style.css" rel="stylesheet" type="text/css" />
<link href="../css/platform-style-responsive.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<script type="text/javascript">
/* 系统选择跳转
 * url:系统链接
 * moreunit:多科室标记
 * systemid：系统id
 */
function moreSytemSel(url,moreunit,systemid){
	 var loginUserId="${requestScope.loginUserId}";
	 var url=url.indexOf("?")>-1?url+"&systemid="+systemid+"&loginUserId="+loginUserId:url+"?systemid="+systemid+"&loginUserId="+loginUserId;
	//判断是否需要进行多科室选择
	//避免多次查询科室信息，先加载科室信息再判断
	if("9"!=moreunit){
		$("#chooseUnitwindow").load("../unit/selMoreUnitTo.action?moreunitflag="+moreunit+"&MoreUnitUrl="+encodeURIComponent(url),function(){
			if(document.getElementById("selUnitSize"))
			{	
				var selUnitSize=$("#selUnitSize").val();
				if(1==selUnitSize){
					//存在一个科室直接跳转
					var unitOneId=$("#unitOneId").val();
					window.location.href=url+"&selUnitid="+unitOneId;
				}else{
					//存在多个科室打开选择
					$("#chooseUnitwindow").window("open");
					$("#chooseUnitwindow").window("center");
				}
			//存在
			}else{
				//一个都没有
				window.location.href=url;
			} 
		});
	}else{
		window.location.href=url;
	}
}
$(function(){
	$('#loginout').click(function(){
	art.dialog({
		title:'提示',
		content:'是否退出系统?',
		zIndex:9100,
		ok:function(){
			window.location.href='../user/index?loginUserId=${requestScope.loginUserId}';
			},
		cancel: function () {}
	});
	});
});
</script>
</head>

<body class="page-header-fixed">
		<div class="kong"></div>
        <div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->
        
                <div class="container-fluid">
    
                    <!-- BEGIN LOGO -->
    
                    <a class="brand" href="#">
    
                    	<img src="../images/logo9_03_03.png" alt=""/> </a>
    
                    <!-- END LOGO -->       
    
                    <!-- BEGIN TOP NAVIGATION MENU -->              
    
                    <ul class="nav">
                    
                        <!-- BEGIN USER LOGIN DROPDOWN -->
    
                        <li class="dropdown user">
    
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
    
                            <img alt="" src="../images/top/top_photo.png" class="nav1 pull-left" />     
    
                            <i class="icon-angle-down"></i>
                            </a>
    <%--
                            <ul class="dropdown-menu">
    
                                <li><a href="extra_profile.html"><i class="icon-user"></i> My Profile</a></li>
    
                                <li><a href="page_calendar.html"><i class="icon-calendar"></i> My Calendar</a></li>
    
                                <li><a href="inbox.html"><i class="icon-envelope"></i> My Inbox(3)</a></li>
    
                                <li><a href="#"><i class="icon-tasks"></i> My Tasks</a></li>
    
                                <li class="divider"></li>
    
                                <li><a href="extra_lock.html"><i class="icon-lock"></i> Lock Screen</a></li>
    
                                <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
    
                            </ul>
     --%>
                        </li>
    
                        <!-- END USER LOGIN DROPDOWN -->
    
                        <!-- BEGIN NOTIFICATION DROPDOWN -->   
    
                        <li class="dropdown" id="header_notification_bar">
    
                            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" id="loginout" >
    
                            <img title="退出系统" src="../images/menu/yemian11_03.png" style="width:72px;height:56px;">
    
                            <span class="badge">退出系统</span>
    
                            </a>
    <%--
                            <ul class="dropdown-menu extended notification">
    
                                <li>
    
                                    <p>You have 14 new notifications</p>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="label label-success"><i class="icon-plus"></i></span>
    
                                    New user registered. 
    
                                    <span class="time">Just now</span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="label label-important"><i class="icon-bolt"></i></span>
    
                                    Server #12 overloaded. 
    
                                    <span class="time">15 mins</span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="label label-warning"><i class="icon-bell"></i></span>
    
                                    Server #2 not respoding.
    
                                    <span class="time">22 mins</span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="label label-info"><i class="icon-bullhorn"></i></span>
    
                                    Application error.
    
                                    <span class="time">40 mins</span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="label label-important"><i class="icon-bolt"></i></span>
    
                                    Database overloaded 68%. 
    
                                    <span class="time">2 hrs</span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="label label-important"><i class="icon-bolt"></i></span>
    
                                    2 user IP blocked.
    
                                    <span class="time">5 hrs</span>
    
                                    </a>
    
                                </li>
    
                                <li class="external">
    
                                    <a href="#">See all notifications <i class="m-icon-swapright"></i></a>
    
                                </li>
    
                            </ul><!--二级菜单导航-->
    --%>
                        </li>
    
                        <!-- END NOTIFICATION DROPDOWN -->
    
                        <!-- BEGIN INBOX DROPDOWN -->
     <%--
                        <li class="dropdown" id="header_inbox_bar">
    
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
    
                            <img src="../images/top/buttons_19.png">
    
                            <span class="badge">5</span>
    
                            </a>
    
                            <ul class="dropdown-menu extended inbox">
    
                                <li>
    
                                    <p>You have 12 new messages</p>
    
                                </li>
    
                                <li>
    
                                    <a href="inbox.html?a=view">
    
        
                                        <span class="subject">
        
                                            <span class="from">Lisa Wong</span>
            
                                            <span class="time">Just Now</span>
        
                                        </span>
        
                                        <span class="message">
        
                                            Vivamus sed auctor nibh congue nibh. auctor nibh
            
                                            auctor nibh...
        
                                        </span>  
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="inbox.html?a=view">
    
        
                                        <span class="subject">
        
                                            <span class="from">Richard Doe</span>
            
                                            <span class="time">16 mins</span>
            
                                        </span>
        
                                        <span class="message">
        
                                            Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh
            
                                            auctor nibh...
        
                                        </span>  
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="inbox.html?a=view">
    
        
                                        <span class="subject">
        
                                            <span class="from">Bob Nilson</span>
            
                                            <span class="time">2 hrs</span>
            
                                        </span>
        
                                        <span class="message">
        
                                            Vivamus sed nibh auctor nibh congue nibh. auctor nibh
            
                                            auctor nibh...
            
                                        </span>  
    
                                    </a>
    
                                </li>
    
                                <li class="external">
    
                                    <a href="inbox.html">See all messages <i class="m-icon-swapright"></i></a>
    
                                </li>
    
                            </ul><!--二级菜单导航-->
    
                        </li>
    
                        <!-- END INBOX DROPDOWN -->
    
                        <!-- BEGIN TODO DROPDOWN -->
    
                        <li class="dropdown" id="header_task_bar">
    
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
    
                                <img src="../images/top/buttons_21.png">
        
                                <span class="badge">5</span>
        
                            </a>
    
                            <ul class="dropdown-menu extended tasks">
    
                                <li>
    
                                    <p>You have 12 pending tasks</p>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="task">
    
                                    <span class="desc">New release v1.2</span>
    
                                    <span class="percent">30%</span>
    
                                    </span>
    
                                    <span class="progress progress-success ">
    
                                    <span style="width: 30%;" class="bar"></span>
    
                                    </span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="task">
    
                                    <span class="desc">Application deployment</span>
    
                                    <span class="percent">65%</span>
    
                                    </span>
    
                                    <span class="progress progress-danger progress-striped active">
    
                                    <span style="width: 65%;" class="bar"></span>
    
                                    </span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="task">
    
                                    <span class="desc">Mobile app release</span>
    
                                    <span class="percent">98%</span>
    
                                    </span>
    
                                    <span class="progress progress-success">
    
                                    <span style="width: 98%;" class="bar"></span>
    
                                    </span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="task">
    
                                    <span class="desc">Database migration</span>
    
                                    <span class="percent">10%</span>
    
                                    </span>
    
                                    <span class="progress progress-warning progress-striped">
    
                                    <span style="width: 10%;" class="bar"></span>
    
                                    </span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="task">
    
                                    <span class="desc">Web server upgrade</span>
    
                                    <span class="percent">58%</span>
    
                                    </span>
    
                                    <span class="progress progress-info">
    
                                    <span style="width: 58%;" class="bar"></span>
    
                                    </span>
    
                                    </a>
    
                                </li>
    
                                <li>
    
                                    <a href="#">
    
                                    <span class="task">
    
                                    <span class="desc">Mobile development</span>
    
                                    <span class="percent">85%</span>
    
                                    </span>
    
                                    <span class="progress progress-success">
    
                                    <span style="width: 85%;" class="bar"></span>
    
                                    </span>
    
                                    </a>
    
                                </li>
    
                                <li class="external">
    
                                    <a href="#">See all tasks <i class="m-icon-swapright"></i></a>
    
                                </li>
    
                            </ul><!--二级菜单导航-->
    
                        </li>
    
                        <!-- END TODO DROPDOWN -->
    --%>
                    </ul>
                    <!-- END TOP NAVIGATION MENU --> 
    
                </div>
    
		<!-- END TOP NAVIGATION BAR -->

	</div>
    <!-- END HEADER -->

	<!-- BEGIN CONTAINER -->
	<div class="page-container">

		<!-- BEGIN CONTAINER-fluid-->
		<div class="container-fluid">

			<div class="row-fluid">
				<!-- BEGIN 左侧系统-->
				<div class="span5">
				<c:if test="${not empty list1}">
					<div class="portlet box">

						<div class="portlet-title custom-blue">
							<div class="caption-system">
								<i class="his-icon"></i>HIS系统
							</div>
							<img src="../images/title-icon.png" alt=""  class="fr icon1"/>
						</div>

						<div class="portlet-body his-system">
							<c:forEach items="${list1}" var="list" varStatus="sta">
								<c:if test="${list['TYPE'] eq '0'}">
									<a href="javascript:void(0);" onclick="moreSytemSel('${list['URL']}','${list['MOREUNIT']}','${list['ID']}');">
									<i><img src="../${list['IMG_PATH']}" alt="" /></i>
									<p>${list['NAME']}</p>
									</a>
								</c:if>
							</c:forEach>
							<div class="clear"></div>
						</div>
					</div>
					</c:if>
					<c:if test="${not empty list2}">
					<div class="portlet box">

						<div class="portlet-title custom-blue">
							<div class="caption-system">
								<i class="his-icon"></i>医技系统
							</div>
							<img src="../images/title-icon.png" alt=""  class="fr icon1"/>
						</div>

						<div class="portlet-body his-system">
							<c:forEach items="${list2}" var="list" varStatus="sta">
								<c:if test="${list['TYPE'] eq '1'}">
									<a href="javascript:void(0);" onclick="moreSytemSel('${list['URL']}','${list['MOREUNIT']}','${list['ID']}');">
									<i><img src="../${list['IMG_PATH']}" alt="" /></i>
									<p>${list['NAME']}</p>
									</a>
								</c:if>
							</c:forEach>
							<div class="clear"></div>
						</div>
					</div>
					</c:if>
					<c:if test="${not empty list3}">
					<div class="portlet box">

						<div class="portlet-title custom-blue">
							<div class="caption-system">
								<i class="his-icon"></i>行政系统
							</div>
							<img src="../images/title-icon.png" alt=""  class="fr icon1"/>
						</div>

						<div class="portlet-body his-system">
							<c:forEach items="${list3}" var="list" varStatus="sta">
								<c:if test="${list['TYPE'] eq '2'}">
									<a href="javascript:void(0);" onclick="moreSytemSel('${list['URL']}','${list['MOREUNIT']}','${list['ID']}');">
									<i><img src="../${list['IMG_PATH']}" alt="" /></i>
									<p>${list['NAME']}</p>
									</a>
								</c:if>
							</c:forEach>
							<div class="clear"></div>
						</div>
					</div>
					</c:if>
				</div>
				<!-- END 左侧系统-->

				<!-- BEGIN 右侧公告-->
				<div class="span7">
					<div class="portlet box">

						<div class=" portlet-title custom-gradient-gray">
							<div class="caption-news">
								<i class="news-icon"></i>最新公告
							</div>
						</div>
						<div class="border1 portlet-body announcement">
							<div class="border1 portlet-body announcement">
								<ul>
									<li><a href="#">Hosting Made For Wordpress</a>
									</li>
									<li><a href="#">Reinvent cutting-edge</a>
									</li>
									<li><a href="#">partnerships models 24/7</a>
									</li>
									<li><a href="#">Eyeballs Frictionless</a>
									</li>
									<li><a href="#">Empower deliver innovate</a>
									</li>
									<li><a href="#">Portals technologies</a>
									</li>
								</ul>
								<ul>
									<li><a href="#">Hosting Made For Wordpress</a>
									</li>
									<li><a href="#">Reinvent cutting-edge</a>
									</li>
									<li><a href="#">partnerships models 24/7</a>
									</li>
									<li><a href="#">Eyeballs Frictionless</a>
									</li>
									<li><a href="#">Empower deliver innovate</a>
									</li>
									<li><a href="#">Portals technologies</a>
									</li>
								</ul>
								<ul>
									<li><a href="#">Hosting Made For Wordpress</a>
									</li>
									<li><a href="#">Reinvent cutting-edge</a>
									</li>
									<li><a href="#">partnerships models 24/7</a>
									</li>
									<li><a href="#">Eyeballs Frictionless</a>
									</li>
									<li><a href="#">Empower deliver innovate</a>
									</li>
									<li><a href="#">Portals technologies</a>
									</li>
								</ul>
								<ul>
									<li><a href="#">Hosting Made For Wordpress</a>
									</li>
									<li><a href="#">Reinvent cutting-edge</a>
									</li>
									<li><a href="#">partnerships models 24/7</a>
									</li>
									<li><a href="#">Eyeballs Frictionless</a>
									</li>
									<li><a href="#">Empower deliver innovate</a>
									</li>
									<li><a href="#">Portals technologies</a>
									</li>
								</ul>
							</div>
						</div>
					</div>

					<div class="portlet box">

						<div class="portlet-title custom-gradient-gray">
							<div class="caption-news">
								<i class="news-icon"></i>自定义待办事项
							</div>
						</div>

						<div class="border1 portlet-body">
							<div class="text">
								<p>文字</p>
								<p>文字</p>
								<p>文字</p>
								<p>文字</p>
								<p>文字</p>
								<p>文字</p>
							</div>
						</div>
					</div>
				</div>
				<!--END 右侧公告-->
			</div>
		</div>
		<!-- END CONTAINER-fluid -->
	</div>
	<!--END CONTAINER -->
	<div id="chooseUnitwindow" class="easyui-window" title=""
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width:700px;height:400px;"></div>
</body>
</html>
