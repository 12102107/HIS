<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%> 
<!doctype html>
<html>
  <head>
    <title>menu</title>
    
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
    
 <script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
    
    <link href="${pageContext.request.contextPath}/css/Two_navigation.css" rel="stylesheet" type="text/css">
 <script  type="text/javascript">
	
    	$(function(){
			$(".menu").mouseover(function(trg,event){
				var menuc=$(this).attr('menu');
				$(".selected").removeClass("selected");
				$(this).addClass("selected");
				$(".sub-nav").removeClass("show");
				$(".sub-nav").addClass("hide");
				$(".menu"+menuc).removeClass("hide");
				$(".menu"+menuc).addClass("show");
			});
 
		});
    	
    	function iFrameHeight() {   

    		var ifm= document.getElementById("iframepage");   

    		var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   

    		if(ifm != null && subWeb != null) {

    		   ifm.height = subWeb.body.scrollHeight;


    		}   

    		}   
    </script>
    
	<style type="text/css">
	.hide{
		display:none;
	}
	.show{
		display:block;
	}
	</style>
</head>
<body>

        	<div class="container-fluid" style="margin-top: -20px;">
            	<div class="top-nav">
                      <ul>
                      <c:forEach items="${functionList }" var="functions" varStatus="status">
                        <li <c:if test="${ status.index ==0&&flag=='0'}">class="selected "</c:if><c:if test="${ functions.id==fid&&flag=='1'}">class="selected "</c:if> >
                          <a href="${pageContext.request.contextPath}/user/menuframeToByfunction.action?functionid=${functionid }&fid=${functions.id}" class="menu" menu="${ status.index + 1}" >
                            <div class="fs1" aria-hidden="true" data-icon="&#xe0a0;"></div>
                            ${functions.name }
                          </a>
                        </li>
                        </c:forEach>
                       
                      </ul>
                      <div class="clearfix">
                      </div>
                    </div>
                    <c:forEach items="${functionList }" var="functions" varStatus="status">
                    <c:if test="${status.index==0 }">
                    <div  class="sub-nav"></div>
                    </c:if>
                    <c:if test="${status.index>0 }">
                    <div class="sub-nav menu${ status.index} hide" ></div>
                    </c:if>
                     <c:if test="${fn:length(functionList)==(status.index+1) }">
                    <div class="sub-nav menu${ status.index +1} hide" ></div>
                    </c:if>
                   
				   
                    </c:forEach>
                    <div class="jianju" style="margin-top: -70px;">
                    <iframe src="${pageContext.request.contextPath}/${xtFunction.url}" id="iframepage" frameborder="0" scrolling="no" height="99%" width="100%" onLoad="iFrameHeight()"></iframe>
                    </div>
                 </div>
                


</body>
</html>

	
	
	
	