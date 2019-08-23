<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN">
<html>
<head>

<title>手术登记</title>

<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>

<script type="text/javascript" src="../js/validate/jquery.validate.js"></script>
<link rel="stylesheet" href="../js/validate/jquery.validate.css" />
<script type="text/javascript" src="../js/validate/jquery.metadata.js"></script>
<script type="text/javascript" src="../js/validate/messages_cn.js"></script>

<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>

	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<script type="text/javascript">

$(function(){
/*     $('.room').val("${his.room }"); */
	$('#anaesMethodSpan').val("${his.designedAnaesMethodName }"); 
/* 	var  aaa=  $("#operatorId").val;
	
    console.log("-------"+aaa); */




	$('.circunurse1').change(function(){
			if($(this).val()=="") {
				$('#apmx').find('.circunurse2').find('option').show();
			} else {
				$('#apmx').find('.circunurse2').find('option').show();
				$('#apmx').find('.circunurse2').find("[value='"+$(this).val()+"']").hide();
			}
		});
		$('.circunurse2').change(function(){
			if($(this).val()=="") {
				$('#apmx').find('.circunurse1').find('option').show();
			} else {
				$('#apmx').find('.circunurse1').find('option').show();
				$('#apmx').find('.circunurse1').find("[value='"+$(this).val()+"']").hide();
			}
		});
		
		$('.instrnurse1').change(function(){
			if($(this).val()=="") {
				$('#apmx').find('.instrnurse2').find('option').show();
			} else {
				$('#apmx').find('.instrnurse2').find('option').show();
				$('#apmx').find('.instrnurse2').find("[value='"+$(this).val()+"']").hide();
			}
		});
		$('.instrnurse2').change(function(){
			if($(this).val()=="") {
				$('#apmx').find('.instrnurse1').find('option').show();
			} else {
				$('#apmx').find('.instrnurse1').find('option').show();
				$('#apmx').find('.instrnurse1').find("[value='"+$(this).val()+"']").hide();
			}
		});
		
		
			var diagnosisName = $("#diagnosisName").val().trim();
	        var zhenduan = diagnosisName.split(', ');
	        for(var i=0;i<zhenduan.length;i++) {
		       if(zhenduan[i]!="") {
			      $(".xl1[value='"+zhenduan[i]+"']").remove();
			      $("#jieguo1").append("<option class=\"xll1\" value=\"" + zhenduan[i]
								+ "\">" + zhenduan[i] + "</option>");
		}
	}
		
		
			var designedOptName = $("#designedoperationName").val().trim();
	        var shoushu = designedOptName.split(', ');
	        for(var i=0;i<shoushu.length;i++) {
		      if(shoushu[i]!="") {
			  $(".xl2[value='"+shoushu[i]+"']").remove();
			   $("#jieguo2").append("<option class=\"xll2\" value=\"" + shoushu[i]
								+ "\">" + shoushu[i] + "</option>");
		}
	}
		//手术人员					  
			var operatorId = $("#operatorId").val().trim();
	          $("#yuanshi option").each(function () {
                 var txt = $(this).text();
                 var val = $(this).val(); 
                  if(operatorId==val){
                      console.log(txt+"---"+val);
                      $(".xl[value='"+val+"']").remove();
			          $("#jieguo").append("<option class=\"xll\" value=\"" + val + "\">" + txt + "</option>");
                   }
               });
	        
	        
	        
	        
	        
	        
	        
	        

		
		
});



//手术医生右移动到下拉
	function addYs() {
		if ($(".xl:selected").val() != null) {
			$("#jieguo").append(
					"<option class=\"xll\" value=\"" + $(".xl:selected").val()
							+ "\">" + $(".xl:selected").html() + "</option>");
			$(".xl:selected").remove();
			
		}
		
	}

    //手术医生左移动到下拉
	function delYs() {
		if ($(".xll:selected").val() != null) {
			for ( var i = 0; i < $(".xll:selected").length; i++) {
				$("#yuanshi")
						.append(
								"<option class=\"xl\" value=\""
										+ $(".xll:selected")[i].value + "\">"
										+ $(".xll:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xll:selected").remove();
			
		}
	}
			//根据输入文本查询对应术前诊断名称
	function selectNsss(d){
		//alert(d.value);
	    $.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/ssdj/queryNsssNameBuZimu.action",
	      data:"zimu="+d.value,
	      async:false,
	      success:function(msg){
		 //console.info(msg);
		 $("#yuanshi2").html(msg);
		}           
	    });
	}
	<%-- 	//根据输入文本查询对应术前诊断名称
	function selectSqzd(d){
		//alert(d.value);
	    $.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/ssdj/querySqzdNameBuZimu.action",
	      data:"zimu="+d.value,
	      async:false,
	      success:function(msg){
		 //console.info(msg);
		 $("#yuanshi1").html(msg);
		}           
	    });
	} --%>
	//根据输入文本查询对应术前诊断名称
	function selectSqzd(d){
	    $.post("../ssdj/querySqzdName.action",{zimu:d.value},function(data){
	    	if(data!="x") {
	    		$("#yuanshi1").html(data); 
	    	}
	    });
	}
	
	//根据输入文本查询对应手术人员名称
	function selectSsys(d){
		//alert(d.value);
	    $.ajax({
	      type:"post",
	      url:"<%=request.getContextPath()%>/ssdj/queryNameBuZimu.action",
	      data:"zimu="+d.value,
	      async:false,
	      success:function(msg){
		 //console.info(msg);
		 $("#yuanshi").html(msg);
		}           
	    });
	}
	//拟施手术右移动到下拉
	function addOper() {
		if ($(".xl2:selected").val() != null) {
			$("#jieguo2").append(
					"<option class=\"xll2\" value=\"" + $(".xl2:selected").val()
							+ "\">" + $(".xl2:selected").html() + "</option>");
			$(".xl2:selected").remove();
			
		}
		
	}

    //拟施手术左移动到下拉
	function delOper() {
		if ($(".xll2:selected").val() != null) {
			for ( var i = 0; i < $(".xll2:selected").length; i++) {
				$("#yuanshi2")
						.append(
								"<option class=\"xl2\" value=\""
										+ $(".xll2:selected")[i].value + "\">"
										+ $(".xll2:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xll2:selected").remove();
			
		}
		
		

	}
//术前诊断右移动到下拉
	function addZd() {
		if ($(".xl1:selected").val() != null) {
			$("#jieguo1").append(
					"<option class=\"xll1\" value=\"" + $(".xl1:selected").val()
							+ "\">" + $(".xl1:selected").html() + "</option>");
			$(".xl1:selected").remove();
			
		}
		
	}

    //术前诊断左移动到下拉
	function delZd() {
		if ($(".xll1:selected").val() != null) {
			for ( var i = 0; i < $(".xll1:selected").length; i++) {
				$("#yuanshi1")
						.append(
								"<option class=\"xl1\" value=\""
										+ $(".xll1:selected")[i].value + "\">"
										+ $(".xll1:selected")[i].innerHTML
										+ "</option>");
			}
			
			$(".xll1:selected").remove();
			
		}

	}
	
	//选择麻醉发法模式对话窗
	function selectMzff() {
		/* var inf = "edge: Raised; center: Yes; help: Yes; resizable: no; status: No;dialogHeight:450px;dialogWidth:900px;scrolling:no";
		var anas = window.showModalDialog(
				"${pageContext.request.contextPath}/ssdj/selectMzff.action",
				inf);
		//alert(anas);
		if (anas == null) {
			return;
		}
		var strs = anas;
		document.getElementById("anaesMethodSpan").value = strs;//传回的麻醉名称 */
		$("#chooseMzff").load("../ssdj/selectMzff.action");
		$("#chooseMzff").window('open');
		$("#chooseMzff").window('center');

	}
	
	function setMzff(strs) {
		document.getElementById("anaesMethodSpan").value = strs;
	}
	function add() {
		if($('.room').val()!="") {
			if($('.circunurse1').val()!="") {
				if($('.instrnurse1').val()!="") {
					if($('.anesthetist').val()!="") {
						if($('.circuanesthetist').val()!="") {
							if($('.anaesAssistant').val()!="") {
								$(".xll").attr("selected", true);
								$(".xll1").attr("selected", true);
								$(".xll2").attr("selected", true);
			
								var name = "";

		    					$(".xll").each(function(){
		    						$.post("${pageContext.request.contextPath}/ssdj/getOperatorNameById.action",{operatorId:$(this).val()},function(data){
		    							name = name + data + ", ";
		    						});
		    					});
		    					setTimeout(function(){
		    						name = name.substring(0, name.length-2);
           							$("#operatorName").val(name); 
										//document.form1.submit();
										$.post("modHisList.action",$('#form1').serialize(),function(){
										alert('保存成功！');
										window.location.href="../his/getHisList.action"; 
									});
		    					},300);
					
							} else {
								alert('请选择灌注医师！');
							}
						} else {
							alert('请选择巡台麻醉医师！');
						}
					} else {
						alert('请选择手术麻醉医师！');
					}
				} else {
					alert('请选择第一巡回护士！');
				}
			} else {
				alert('请选择第一器械护士！');
			}
		} else {
			alert('请选择手术室！');
		}
	}
	function editPage(id){
		window.location.href="../his/getHisList.action?id="+id;
	}
	
	function editState(id){
		$.post("modStateList.action",{id:id},function(){
										alert('取消成功！');
										window.location.href="../his/getHisList.action"; 
									});
	}
</script>
<style>
input[type="checkbox"] {
vertical-align: baseline;
}
input[type="radio"] {
vertical-align: baseline;
}
</style>
</head>
<body class="page-header-fixed">

<div class="Bread_crumbs">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">HIS预约</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<div class="responsive-table">
			<div style="margin-left: 10px;">
	

			<form method="post">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" />
				<table class="table table-bordered table-striped header-spcing" style="table-layout: fixed;" id="table1">
				<thead>
					<tr class="bj">
						<td width="5%">姓名</td>
						<td width="3%">性别</td>
						<td width="5%">年龄</td>
						<td width="5%">住院号</td>
						<td width="5%">病区</td>
						<td width="5%">科室</td>
						<td width="5%">床号</td>
						<td width="5%">费用类型</td>
						<td width="5%">手术类型</td>
						<td width="5%">手术等级</td>
						<td width="5%">术前诊断</td>
						<td width="5%">拟施手术</td>
						<td width="8%">建议麻醉方法</td>
						<td width="7%">预约日期</td>
						<td colspan="2" width="5%">操作</td>
					</tr>
				</thead>	
					      <c:forEach items="${zoaList}" var="zoa">
					<tr class="No">
							<td>${zoa.name}</td>
							<td>${zoa.sex}</td>
							<td>${zoa.age}</td>
							<td>${zoa.hid}</td>
							<td>${zoa.regionName}</td>
							<td>${zoa.dept}</td>
							<td>${zoa.bed}</td>
							<td>
								<c:forEach items="${sysCvFyzflb}" var="l">
									<c:if test="${zoa.chargesType eq l.id }">${l.value }</c:if>
								</c:forEach>
							</td>
							<td></td>
							<td>${zoa.optLevel}</td>
							<td>${zoa.diagnosisName}</td>
							<td>${zoa.designedoperationName}</td>
							<td>${zoa.designedAnaesMethodName}</td>
							<td>${zoa.operationdate}</td>
							<td style="text-align:center;"><a href="javascript:editPage('${zoa.id}')">补录</a></td>
							<td style="text-align:center;"><a href="javascript:editState('${zoa.id}')">取消</a></td>	
						</tr>
					</c:forEach>
				</table>
			</form>
			<form id="form1" name="form1" action="modHisList.action" method="post">
			<input type="hidden" name="id" value="${his.id}" />
			<input type="hidden" id="diagnosisName" value="${his.diagnosisName}" />
			<input type="hidden" id="designedoperationName" value="${his.designedoperationName}" />
			<input type="hidden" id="roomId" value="${his.room}" />
			<input type="hidden" id="operatorId" value="${his.operator}">
					<div style="float:left;width:50%;">
						<table class="table table-bordered table-striped header-spcing"
					 style="width: 98%; margin-right:2%">
						<thead>
							<tr class="bj">
								<td colspan="2">基本信息</td>
							</tr>
						</thead>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">姓名</td>
								<td style="text-align: left;padding-left: 5px;">
									<input type="text" name="sro.name" readonly="readonly" value="${his.name }"/>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">性别</td>
								<td style="text-align: left;padding-left: 5px;">
									<select name="sro.sex">
										<option value="0" <c:if test="${his.sex eq '男'}">selected</c:if>>男</option>
										<option value="1" <c:if test="${his.sex eq '女'}">selected</c:if>>女</option>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">年龄</td>
								<td style="text-align: left;padding-left: 5px;">
									<input style="width: 35px;" type="text" readonly="readonly" name="sro.age" value="${his.age}"/> 岁
									<input style="width: 35px;" type="text" readonly="readonly" name="sro.ageMon" value="${his.monthage}"/> 月 
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">住院号</td>
								<td style="text-align: left;padding-left: 5px;">
									<input type="text" name="sro.hid" readonly="readonly" value="${his.hid }"/>
								</td>
							</tr>
						<tr class="No">
								<td style="text-align: right;padding-right: 5px;">病区</td>
								<td style="text-align: left;padding-left: 5px;">
									<select name="sro.region" class="region">
									<c:forEach items="${regionList}" var="reg">
										<%-- <option value="${reg.name}">${reg.name}</option> --%>
										<option value="${reg.name}"
											<c:if test="${his.regionNo eq reg.id}">selected</c:if>>${reg.name}</option>
									</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">床号</td>
								<td style="text-align: left;padding-left: 5px;">
									<input type="text" name="sro.bed" readonly="readonly" value="${his.bed}"/>
								</td>
							</tr>
							<tr class="No" style="vertical-align: middle;">
								<td style="text-align: right;padding-right: 5px;">费用类型</td>
								<td style="text-align: left;padding-left: 5px;">
									<c:forEach items="${sysCvFyzflb}" var="l">
										<input type="radio" name="sro.chargesType" value="${l.code }" <c:if test="${his.chargesType eq l.id }">checked</c:if> />${l.value }
										&nbsp;
									</c:forEach>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">手术等级</td>
								<td style="text-align: left;padding-left: 5px;" >
									<input type="radio" name="sro.optLevel"  value="1" <c:if test="${his.optLevel eq '一级'}">checked="checked"</c:if>/>一级 
									<input type="radio" name="sro.optLevel"  value="2" <c:if test="${his.optLevel eq '二级'}">checked="checked"</c:if>/>二级 
									<input type="radio" name="sro.optLevel"   value="3" <c:if test="${his.optLevel eq '三级'}">checked="checked"</c:if>/>三级 
									<input type="radio" name="sro.optLevel"  value="4" <c:if test="${his.optLevel eq '四级'}">checked="checked"</c:if>/>四级
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">建议麻醉方法</td>
								<td style="text-align: left;padding-left: 5px; ">
									<input id="anaesMethodSpan" name="sro.designedAnaesMethodName" type="text"> <label
									onclick="selectMzff()" style="color: blue;display: inline-table;">添加 </label>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;vertical-align: top;">术前诊断</td>
								<td style="text-align: left;padding-left: 5px;vertical-align: top;">
									<div>
									<div  style="float:left;">
										<input style="width: 45px;" type="text" onblur="selectSqzd(this)" >&nbsp;
									</div>
									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshi1" style="width: 50%;">
											<c:forEach items="${diagnosedefList}" var="zd" varStatus="status">
												<option class="xl1" value="${zd.diseasename}">${zd.diseasename}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addZd()"><br><input
											   type="button" value="←" onclick="delZd()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-95px ">
										<select size="5" style="width: 50%;margin-top: 15px;" id="jieguo1" name="sro.diagnosisName"
											multiple="multiple"></select>
									</div>
									</div>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;vertical-align: top;">拟施手术</td>
								<td style="text-align: left;padding-left: 5px; vertical-align: top;">
									<div>
									<div  style="float:left;">
										<input style="width: 45px;" type="text" onkeyup="selectNsss(this)" >&nbsp;
									</div>
									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshi2" style="width: 50%;">
											<c:forEach items="${designedOptNameList}" var="oper" varStatus="status">
												<option class="xl2" value="${oper.name}">${oper.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addOper()"><br><input
											   type="button" value="←" onclick="delOper()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-95px ">
										<select size="5" style="width: 50%;margin-top: 15px;" id="jieguo2" name="sro.designedOptName"
											multiple="multiple"></select>
									</div>
									</div>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;vertical-align: top;">手术医师</td>
								<td style="text-align: left;padding-left: 5px; vertical-align: top;">
									<div>
									<div  style="float:left;">
										<input style="width: 45px;" type="text" onkeyup="selectSsys(this)" >&nbsp;
									</div>
									
									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshi" style="width: 50%;">
											<c:forEach items="${operatorList}" var="sop" varStatus="status">
												<option class="xl" id="${sop.code}" value="${sop.code}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addYs()"><br><input
											   type="button" value="←" onclick="delYs()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-95px ">
										<select size="5" style="width: 50%;margin-top: 15px;" id="jieguo" name="sro.operatorId"
											multiple="multiple"></select>
											<input type="hidden" id="operatorName" name="sro.operatorName" value="${his.operator}"/>
									</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div style="float:left;width:50%;">
						<table class="table table-bordered table-striped header-spcing"
						 style="width: 98%;margin-left:2%;" id="apmx">
							<thead>
							<tr class="bj">
								<td colspan="2">手术安排明细</td>
							</tr>
						</thead>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">手术时间</td>
								<td style="text-align: left;padding-left: 5px;">
									<input size="15" name="YYoperdate" value="${fn:substring(his.operationdate, 0, 10)}" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})" style="background-color: white;border: 1px solid #95b8e7;height: 25px;line-height: 25px;">
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">开始时间</td>
								<td style="text-align: left;padding-left: 5px;">
									<input class="Wdate"  style="width: 80px;" name="sro.starttime"  onFocus="WdatePicker({dateFmt:'HH:mm'})"  value="${sro.starttime }"/>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">结束时间</td>
								<td style="text-align: left;padding-left: 5px;">
								<input class="Wdate" style="width: 80px;"  name="sro.endtime"  onFocus="WdatePicker({dateFmt:'HH:mm'})"  value="${sro.endtime }"/>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">手术室</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="room" name="sro.room"  >
										<option value=""></option>
										<c:forEach items="${roomList}"  var="room">
                                		<%-- 	<option value="${room.id}"> ${room.name}</option> --%>
                                			<option value="${room.id}"
											<c:if test="${his.room eq room.id}">selected</c:if>>${room.name}</option>
                                		</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">第一器械护士</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="circunurse1" name="sro.circunurse1"  >
										<option value=""></option>
										<c:forEach items="${circunurse}" var="cir1">
											<option value="${cir1.name}">${cir1.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">第二器械护士</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="circunurse2" name="sro.circunurse2"  >
							  			<option value=""></option>
										<c:forEach items="${circunurse}" var="cir2">
										<option value="${cir2.name}">${cir2.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">第一巡回护士</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="instrnurse1" name="sro.instrnurse1"  >
										<option value=""></option>
										<c:forEach items="${instrnurse}" var="ins1">
											<option value="${ins1.name}">${ins1.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">第二巡回护士</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="instrnurse2" name="sro.instrnurse2"  >
								        <option value=""></option>
										<c:forEach items="${instrnurse}" var="ins2">
											<option value="${ins2.name}" >${ins2.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">手术麻醉医师</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="anesthetist" name="sro.anesthetist"  >
										<option value=""></option>
										<c:forEach items="${anesthetistList}" var="ane">
											<%-- <option value="${ane.name}">${ane.name}</option> --%>
											<option value="${ane.name}"
											<c:if test="${his.anaesthetist eq ane.code}">selected</c:if>>${ane.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">巡台麻醉医师</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="circuanesthetist" name="sro.circuanesthetist"  >
										<option value=""></option>
										<c:forEach items="${circuanesthetistList}" var="cir">
											<%-- <option value="${cir.name}">${cir.name}</option> --%>
											<option value="${cir.name}"
											<c:if test="${his.circuanesthetist eq cir.code}">selected</c:if>>${cir.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">灌注医师</td>
								<td style="text-align: left;padding-left: 5px;">
									<select class="anaesAssistant" name="sro.anaesAssistant"  >
							 			<option value=""></option>
										<c:forEach items="${anaesAssistantList}" var="ana">
											<option value="${ana.name}">${ana.name}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td colspan="2" style="text-align: center;">
								
								
									<button type="button" class="button_blue_74_33" style="border: medium;" onclick="add()">确定</button>
							
								<button type="reset" class="button_blue_74_33" style="border: medium;" >重置</button>
								</td>
							</tr>
						</table>
					</div>
							</form>
				</div>
		
			</div>
	</div>
</div>
<div id="chooseMzff" class="easyui-window" title=""
	data-options="modal:true,closed:true,iconCls:'icon-save'"
	style="width:600px;height:300px;"></div>	
</body>
</html>
