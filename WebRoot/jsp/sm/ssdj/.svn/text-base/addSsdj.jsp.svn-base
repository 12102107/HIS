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
	var err = "<%=info%>";
	if (err.length > 0) {
		 alert(err);
	}
	$(function() {
		//手术人员					  
			var operatorId1 = $("#operatorId").val().trim();
	          $("#yuanshi option").each(function () {
                 var txt = $(this).text();
                 var val = $(this).val(); 
                  if(operatorId1==val){
                      console.log(txt+"---"+val);
                      $(".xl[value='"+val+"']").remove();
			          $("#jieguo").append("<option class=\"xll\" value=\"" + val + "\">" + txt + "</option>");
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
		$.metadata.setType("attr", "validate");
		$("#form").validate();
		
	});

	function check() {

		if ($("#form").valid()) {
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
				document.form.submit();
		    },300);
  				
		} else {
			return;
		}
	}
		//返回
		function back(){
		window.location.href="<%=request.getContextPath()%>/ssdj/ssdjList.action?functionid="+$('#functionid').val();
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
	
	//验证年龄
	jQuery.validator.addMethod("isAgenum", function(value, element) {
		var patt = /^([0-9]|[0-9]{2}|100)$/;
		value = value.trim();
		return this.optional(element) || (patt.test(value));

	}, "请输入有效数字");
	//验证住院号
	jQuery.validator.addMethod("isZynum", function(value, element) {
		var patt = /^[0-9]*[1-9][0-9]*$/;
		value = value.trim();
		return this.optional(element) || (patt.test(value));

	}, "请输入有效数字");

	//验证手术单号
	jQuery.validator.addMethod("isPtnum", function(value, element) {
		var patt = /^[0-9]*[1-9][0-9]*$/;
		value = value.trim();
		return this.optional(element) || (patt.test(value));

	}, "请输入有效数字");

	//验证床号
	jQuery.validator.addMethod("isBednum", function(value, element) {
		var patt = /^[0-9]*[1-9][0-9]*$/;
		value = value.trim();
		return this.optional(element) || (patt.test(value));

	}, "请输入有效数字");
	//验证名称是否是中文
	jQuery.validator.addMethod("isname", function(value, element) {
		var patt = /^[\u2E80-\u9FFF]+$/;
		value = value.trim();
		return this.optional(element) || (patt.test(value));

	}, "请输入汉字");

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
	
	//术前诊断右移动到下拉
	function addZd() {
		if ($(".xl1:selected").val() != null) {
			$("#jieguo1").append(
					"<option class=\"xll1\" value=\"" + $(".xl1:selected").val()
							+ "\">" + $(".xl1:selected").html() + "</option>");
			$(".xl1:selected").remove();
			
		}
		
	}
	<%-- //根据输入文本查询对应术前诊断名称
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
	    $.post("querySqzdName.action",{zimu:d.value},function(data){
	    	$("#yuanshi1").empty();
	    	var str = "";
	    	for(var i=0;i<data.length;i++) {
	    		str += "<option class=\"xl1\" value=\"" + data[i].diseasename + "\">" + data[i].diseasename
						+ "</option>";
	    	}
	    	document.getElementById("yuanshi1").innerHTML=str;
	    },"json");
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
	
	function editPage(id){
		window.location.href="../ssdj/ssdjList.action?id="+id+"&functionid="+$('#functionid').val();
	}
	
	
	        
</script>
<style type="text/css">

input[type="radio"] {
vertical-align: baseline;
}

.hideTd {
white-space: nowrap;
text-overflow: ellipsis;
overflow: hidden;
}

</style>
<script type="text/javascript">
$(function(){
	$('.hideTd').each(function(){
		$(this).attr('title',$(this).html());
	});
	

});
</script>
</head>
<body class="page-header-fixed">

<div class="Bread_crumbs">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">手术登记</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<div class="responsive-table">
			<div style="margin-left: 10px;">
	<form id="form" name="form" action="../ssdj/addSsdj.action" class="form-horizontal" enctype="multipart/form-data" method="post">
	<input type="hidden" value="${functionid }" id="functionid" name="functionid">
		<input type="hidden" name="id" id="id" value="${requestScope.sro.id}">
		<input type="hidden" name="sro.state" value="${sro.state}">
		<input type="hidden" id="operatorId" value="${sro.operatorId}">
		<input type="hidden" id="diagnosisName" value="${sro.diagnosisName}" />
		<input type="hidden" id="designedoperationName" value="${sro.designedOptName}" />
			<table  class="table table-bordered header-spcing" >
					<tbody>
					
						<tr>
							<td>手术单号</td>
							<td style="text-align: left;padding-left: 20px;"><input type="text" id="preengagementnumber" name="sro.preengagementnumber" value="${sro.preengagementnumber}"
								validate="{required:true,isPtnum:true,messages:{required:'请填写单号'}}"/></td>
						</tr>
						<tr>
							<td>姓名</td>
							<td style="text-align: left;padding-left: 20px;"><input type="text" id="name" name="sro.name" value="${sro.name}"
								validate="{required:true,isname:true,messages:{required:'请填写姓名'}}" /></td>
						</tr>

						<tr>
							<td>性别</td>
							<td style="text-align: left;padding-left: 20px;"><select id="sex" name="sro.sex">
									<option value="0" <c:if test="${sro.sex eq '0'}">selected</c:if>>男</option>
									<option value="1"<c:if test="${sro.sex eq '1'}">selected</c:if>>女</option>
							</select>
							</td>
						</tr>

						<tr>
							<td>年龄</td>
							<td style="text-align: left;padding-left: 20px;"><input size="3" style="width: 45px;" type="text" id="age" name="sro.age" value="${sro.age}"
								validate="{isAgenum:true}" /> 岁 <input size="3" style="width: 45px;" type="text"
								id="ageMon" name="sro.ageMon" value="${sro.ageMon}" validate="{isAgenum:true}" /> 月 <input size="3" style="width: 45px;"
								type="text" id="ageDay"  name="sro.ageDay" value="${sro.ageDay}" validate="{isAgenum:true}" /> 天</td>
						</tr>

						<tr>
							<td>住院号</td>
							<td style="text-align: left;padding-left: 20px;"><input type="text" id="hid" name="sro.hid" value="${sro.hid}"
								validate="{required:true,isZynum:true,messages:{required:'请填写住院号'}}"/></td>
						</tr>

						<tr>
							<td>病区</td>
							<td style="text-align: left;padding-left: 20px;"><select id="region" name="sro.region">
									<c:forEach items="${regionList}" var="reg" varStatus="status">
										<option value="${reg.name}" <c:if test="${sro.region eq reg.name}">selected</c:if>>${reg.name}</option>
									</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td>科室</td>
							<td style="text-align: left;padding-left: 20px;"><select id="dept" name="sro.dept"  >
									<c:forEach items="${deptList}" var="dept" varStatus="status">
										<option value="${dept.name}" <c:if test="${sro.dept eq dept.name}">selected</c:if>>${dept.name}</option>
									</c:forEach>
							</select>
							</td>
						</tr>


						<tr>
							<td>床号</td>
							<td style="text-align: left;padding-left: 20px;"><input type="text" id="bed" name="sro.bed" value="${sro.bed}"
								validate="{required:true,isBednum:true,messages:{required:'请填写床号'}}"/></td>
						</tr>
						<tr>
							<td>费用类型</td>
							<td style="text-align: left;padding-left: 20px;">
							 <c:forEach items="${sysCvFyzflb}" var="l">
								<input type="radio" name="sro.chargesType" value="${l.code }" <c:if test="${sro.chargesType eq l.code}">checked</c:if>/>${l.value }
								&nbsp;
							</c:forEach>
							 
							</td>
						</tr>

						<tr>
							<td>手术类型</td>
							<td style="text-align: left;padding-left: 20px;"><input type="radio" name="sro.type" value="0" <c:if test="${sro.type eq '0'}">checked</c:if>/>急诊手术 <input
								type="radio" name="sro.type" value="1" <c:if test="${sro.type eq '1'}">checked</c:if>/>择期手术</td>
						</tr>

						<tr>
							<td>手术等级</td>
							<td style="text-align: left;padding-left: 20px;"><input type="radio" name="sro.optLevel" value="1" <c:if test="${sro.optLevel eq '1'}">checked</c:if>/>一级 <input
								type="radio" name="sro.optLevel" value="2" <c:if test="${sro.optLevel eq '2'}">checked</c:if>/>二级 <input type="radio"
								name="sro.optLevel" value="3" <c:if test="${sro.optLevel eq '3'}">checked</c:if>/>三级 <input type="radio"
								name="sro.optLevel" value="4" <c:if test="${sro.optLevel eq '4'}">checked</c:if>/>四级</td>
						</tr>
						<tr>
							<td>建议麻醉方法</td>
							<td style="text-align: left;padding-left: 20px;"><input id="anaesMethodSpan" name="sro.designedAnaesMethodName" type="text"  value="${sro.designedAnaesMethodName}"> <label
								onclick="selectMzff()" style="color: blue;display: inline-table;">添加 </label>
							</td>

						</tr>

						<tr>
							<td>手术医师</td>
							<td style="text-align: left;padding-left: 20px;"><div>
									<div  style="float:left;">
										<input style="width: 45px;" type="text" onkeyup="selectSsys(this)" >&nbsp;
									</div>
									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshi" style="width: 50%;">
											<c:forEach items="${sopList}" var="sop" varStatus="status">
												<option class="xl" id="${sop.code}" value="${sop.code}" >${sop.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addYs()"><br><input
											   type="button" value="←" onclick="delYs()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-95px ">
										<select size="5" style="width: 50%;" id="jieguo" name="sro.operatorId"
											multiple="multiple"></select>
											<input type="hidden" id="operatorName" name="sro.operatorName" value="${sro.operatorName}"/>
									</div>
								</div></td>
						</tr>
						
						<tr>
							<td>术前诊断</td>
							<td style="text-align: left;padding-left: 20px;"><div>
							        <div  style="float:left;">
										<input style="width: 45px;" type="text" onkeyup="selectSqzd(this)" >&nbsp;
									</div>
									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshi1" style="width: 50%;">
											<c:forEach items="${zdList}" var="zd" varStatus="status">
												<option class="xl1" value="${zd.diseasename}">${zd.diseasename}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addZd()"><br><input
											   type="button" value="←" onclick="delZd()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-95px ">
										<select size="5" style="width: 50%;" id="jieguo1" name="sro.diagnosisName"
											multiple="multiple"></select>
									</div>
								</div></td>
						</tr>
						
						<tr>
							<td>拟施手术</td>
							<td style="text-align: left;padding-left: 20px;"><div>
								     <div  style="float:left;">
										<input style="width: 45px;" type="text" onkeyup="selectNsss(this)" >&nbsp;
									</div>
									<div  style="float: left;width:300px;margin-left:0px">
										<select id="yuanshi2" style="width: 50%;">
											<c:forEach items="${operList}" var="oper" varStatus="status">
												<option class="xl2" value="${oper.name}">${oper.name}</option>
											</c:forEach>
										</select>
									</div>

									<div  style="float:left;margin-left:-140px ">
										<input  type="button" value="→" onclick="addOper()"><br><input
											   type="button" value="←" onclick="delOper()">
											   
									</div>

									<div style="float: left;width:300px;margin-left:-95px ">
										<select size="5" style="width: 50%;" id="jieguo2" name="sro.designedOptName"
											multiple="multiple"></select>
									</div>
								</div></td>
						</tr>
							
						<tr>
							<td class="text-left">预约日期</td>
							<td style="text-align: left;padding-left: 20px;">
							<input class="Wdate"   name="YYoperdate"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  value="${fn:substring(sro.operdate,0,10)}"/>
							  </td>
						</tr>
						<tr>
							<td>开始时间</td>
							<td style="text-align: left;padding-left: 20px;">
								<input class="Wdate"  style="width: 80px;" name="sro.starttime"  onFocus="WdatePicker({dateFmt:'HH:mm'})"  value="${sro.starttime }"/>
							</td>
						</tr>

						<tr>
							<td>结束时间</td>
							<td style="text-align: left;padding-left: 20px;">
								<input class="Wdate" style="width: 80px;"  name="sro.endtime"  onFocus="WdatePicker({dateFmt:'HH:mm'})"  value="${sro.endtime }"/>
							</td>
						</tr>
						<tr>
							<td>备注</td>
							<td style="text-align: left;padding-left: 20px;"><textarea class="form-control" id="remark"  name="sro.remark">${sro.remark}</textarea></td>
							
						</tr>

						<tr>
							<td colspan="2">
							<c:if test="${submitRole eq true }">	
							<button class="button_blue_74_33" style="border: medium none; margin-left: 10px;" onclick="check()" type="button">提交</button>
							</c:if>
							<button class="button_blue_74_33" style="border: medium none; margin-left: 10px;" type="reset">重置</button>
							<button class="button_blue_74_33" style="border: medium none; margin-left: 10px;" onclick="back()" type="button">返回</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>


			<form id="form1" action="ssdjList.action" name="form1" method="post">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" />
				<table class="table table-bordered table-striped header-spcing" style="table-layout: fixed;" id="table1">
				<thead>
					<tr class="bj">
						<td width="5%">预约单号</td>
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
						<td width="5%">手术医师</td>
						<td width="7%">预约日期</td>
						<td width="5%">开始时间</td>
						<td width="5%">结束时间</td>
						<td width="5%">备注</td>
						<td width="5%">状态</td>
						<c:if test="${updateRole eq true }">	
						<td width="5%">操作</td>
						</c:if>
					</tr>
				</thead>	
					      <c:forEach items="${sroList}" var="sro">
					<tr class="No">
							<td>${sro.preengagementnumber}</td>
							<td>${sro.name}</td>
							<td><c:if test="${sro.sex eq '0'}">男</c:if> <c:if
									test="${sro.sex eq '1'}">女</c:if></td>
							<td>${sro.age}</td>
							<td>${sro.hid}</td>
							<td>${sro.region}</td>
							<td>${sro.dept}</td>
							<td>${sro.bed}</td>
							<td>
							<c:forEach items="${sysCvFyzflb}" var="l">
								<c:if test="${sro.chargesType eq l.code}">${l.value }</c:if>
							</c:forEach>
							</td>
							<td><c:if test="${sro.type eq '0'}">急诊手术</c:if> <c:if
									test="${sro.type eq '1'}">择期手术</c:if></td>
							<td><c:if test="${sro.optLevel eq '0'}">一级</c:if> <c:if
									test="${sro.optLevel eq '1'}">二级</c:if>
									<c:if test="${sro.optLevel eq '2'}">三级</c:if> <c:if
									test="${sro.optLevel eq '3'}">四级</c:if></td>
							<td class="hideTd">${sro.diagnosisName}</td>
							<td class="hideTd">${sro.designedOptName}</td>
							<td class="hideTd">${sro.designedAnaesMethodName}</td>
							<td class="hideTd">${sro.operatorName}</td>
							<td><fmt:formatDate value="${sro.operdate}" pattern="yyyy-MM-dd"/></td>
							<td>${sro.starttime}</td>
							<td>${sro.endtime}</td>
							<td class="hideTd">${sro.remark}</td>
							<td><c:if test="${sro.state eq '02'}">已安排</c:if> <c:if
									test="${sro.state eq '01'}">未安排</c:if></td>
									
							<c:if test="${updateRole eq true }">	
							<td style="text-align:center;"><a
								href="javascript:editPage('${sro.id}')">修&nbsp;改</a></td>
							</c:if>		
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</div>
</div>
<div id="chooseMzff" class="easyui-window" title=""
	data-options="modal:true,closed:true,iconCls:'icon-save'"
	style="width:510px;height:180px;"></div>		
</body>
</html>