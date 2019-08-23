<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>紧急手术</title>
<!--引入本页面整体样式文件 -->

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
	
	function reseta() {
		$('#reset').submit();
	}
	
	function add() {
		if($('#sroname').val()!="") {
			if($(".xll").size()>0) {
				if($('#srodate').val()!="") {
					if($('#beginDate').val()!="") {
						if($('#sroroom').val()!="") {
							if($('#instrnurse1').val()!="") {
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
									$.post("addEmergencySro.action",$('#add').serialize(),function(){
										alert('保存成功！');
									});
		    					},300);
					
							} else {
								alert('请选择第一巡回护士！');
							}
						} else {
							alert('请选择手术室！');
						}
					} else {
						alert('请选择手术开始时间！');
					}
				} else {
					alert('请选择手术日期！');
				}
			} else {
				alert('请选择手术医师！');
			}
		} else {
			alert('请填写病人姓名！');
		}
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
<form id="reset" action="emergencyTo.action">
<input type="hidden" name="functionid" value="${functionid }" id="functionid">
</form>
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">紧急手术</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
		
	<div class="responsive-table">
			<div class="scrollable-area">
			注：<span style="color: red;">*</span>为必填项
					<form id="add" action="">
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
									<input type="text" name="sro.name" id="sroname"/>
									<span style="color: red;">*</span>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">性别</td>
								<td style="text-align: left;padding-left: 5px;">
									<select name="sro.sex">
										<option value="x"></option>
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">年龄</td>
								<td style="text-align: left;padding-left: 5px;">
									<input style="width: 35px;" type="text"  name="sro.age" /> 岁
									<input style="width: 35px;" type="text" name="sro.ageMon" /> 月 
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">住院号</td>
								<td style="text-align: left;padding-left: 5px;">
									<input type="text" name="sro.hid"/>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">病区</td>
								<td style="text-align: left;padding-left: 5px;">
									<select name="sro.region">
									<option value="x"></option>
									<c:forEach items="${regionList}" var="reg" varStatus="status">
										<option value="${reg.name}">${reg.name}</option>
									</c:forEach>
									</select>
								</td>
							</tr>
							<tr class="No">
							<td style="text-align: right;padding-right: 5px;">科室</td>
							<td style="text-align: left;padding-left: 5px;">
								<select id="dept" name="sro.dept"  >
								<option value="x"></option>
									<c:forEach items="${deptList}" var="dept" varStatus="status">
										<option value="${dept.name}" <c:if test="${sro.dept eq dept.name}">selected</c:if>>${dept.name}</option>
									</c:forEach>
								</select>
							</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">床号</td>
								<td style="text-align: left;padding-left: 5px;">
									<input type="text" name="sro.bed"/>
								</td>
							</tr>
							<tr class="No" style="vertical-align: middle;">
								<td style="text-align: right;padding-right: 5px;">费用类型</td>
								<td style="text-align: left;padding-left: 5px;">
									<c:forEach items="${sysCvFyzflb}" var="l">
										<input type="radio" name="sro.chargesType" value="${l.code }" />${l.value }
										&nbsp;
									</c:forEach>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">手术等级</td>
								<td style="text-align: left;padding-left: 5px;">
									<input type="radio" name="sro.optLevel" value="1" <c:if test="${sro.optLevel eq '1'}">checked="checked"</c:if>/>一级 
									<input type="radio" name="sro.optLevel" value="2" <c:if test="${sro.optLevel eq '2'}">checked="checked"</c:if>/>二级 
									<input type="radio" name="sro.optLevel" value="3" <c:if test="${sro.optLevel eq '3'}">checked="checked"</c:if>/>三级 
									<input type="radio" name="sro.optLevel" value="4" <c:if test="${sro.optLevel eq '4'}">checked="checked"</c:if>/>四级
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
												<option class="xl" value="${sop.code}" >${sop.name}</option>
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
											<input type="hidden" id="operatorName" name="sro.operatorName" value="${sro.operatorName}"/>
											<span style="color: red;">*</span>
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
								<td style="text-align: right;padding-right: 5px;">手术日期</td>
								<td style="text-align: left;padding-left: 5px;">
									<input id="srodate" size="10" name="operdate" value="${fn:substring(sro.operdate, 0, 10)}" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})">
									<span style="color: red;">*</span>
								</td>
							</tr>
							<tr class="No">
								<td style="text-align: right;padding-right: 5px;">开始时间</td>
								<td style="text-align: left;padding-left: 5px;">
									<input id="beginDate" class="Wdate" style="width: 80px;"  name="sro.starttime"  onFocus="WdatePicker({dateFmt:'HH:mm'})"  value="${sro.starttime }"/>
									<span style="color: red;">*</span>
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
									<select class="room" name="sro.room"  id="sroroom">
										<option value=""></option>
										<c:forEach items="${roomList}"  var="room">
                                			<option value="${room.id}"> ${room.name}</option>
                                		</c:forEach>
									</select>
									<span style="color: red;">*</span>
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
									<select class="instrnurse1" name="sro.instrnurse1"  id="instrnurse1">
										<option value=""></option>
										<c:forEach items="${instrnurse}" var="ins1">
											<option value="${ins1.name}">${ins1.name}</option>
										</c:forEach>
									</select>
									<span style="color: red;">*</span>
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
											<option value="${ane.name}">${ane.name}</option>
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
											<option value="${cir.name}">${cir.name}</option>
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
								<c:if test="${affirmRole eq true }">
									<button type="button" class="button_blue_74_33" style="border: medium;" onclick="add()">确定</button>
								</c:if>	
								<button type="button" class="button_blue_74_33" style="border: medium;" onclick="reseta()">重置</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
				</form>
			</div>
	</div>

<div id="chooseMzff" class="easyui-window" title=""
	data-options="modal:true,closed:true,iconCls:'icon-save'"
	style="width:600px;height:300px;"></div>	
</body>
</html>
