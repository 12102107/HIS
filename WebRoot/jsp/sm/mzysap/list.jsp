<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>麻醉医师安排</title>
	<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>

	
<script type="text/javascript">
	var err = "<%=info%>";
	if (err.length > 0) {
		alert(err);
	}
	
	function show_prompt(qxid){  
		    var value = prompt('取消原因：', '');  
		   if(value == null){  
		   	return;
		    }else if(value == ''){  
		       alert('原因为空，请重新输入！');  
		      show_prompt(qxid);  
		    }else{
		    window.location.href="../mzys/mzysQxList.action?qxid="+ qxid +"&value="+ value+"&functionid="+$('#functionid').val();   
		   }  
		} 
</script>
<script>
	function add() {
	var s = 0;
		$('.sro').each(function(){
			if($(this).find('.anesthetist').val()!=""
				&& $(this).find('.circuanesthetist').val()!=""
				) {
					s++;
					var obj = $(this);
					$.post("reservation.action",{sroid:$(this).attr("data-id"), anesthetist:$(this).find('.anesthetist').val(), 
							circuanesthetist:$(this).find('.circuanesthetist').val(), 
							anaesAssistant:$(this).find('.anaesAssistant').val()
					},function(){
						$(obj).remove();
						$.post("reservationList.action",function(data){
							var str = "";
							for(var i=0;i<data.length;i++) {
								str += "<tr class='yuyue'>"+
					  					"<td>"+data[i].name+"</td>"+
										"<td>"+data[i].sex+"</td>"+
										"<td>"+data[i].age+"</td>"+
										"<td>"+data[i].region+"</td>"+
										"<td>"+data[i].dept+"</td>"+
										"<td>"+data[i].diagnosisName+"</td>"+
										"<td>"+data[i].designedOptName+"</td>"+
										"<td>"+data[i].operatorName+"</td>"+
										"<td>"+data[i].room+"</td>"+
										"<td>"+data[i].operdate+"</td>"+
										"<td>"+data[i].starttime+"</td>"+
										"<td>"+data[i].circunurse1+"</td>"+
										"<td>"+data[i].circunurse2+"</td>"+
										"<td>"+data[i].instrnurse1+"</td>"+
										"<td>"+data[i].instrnurse2+"</td>"+
										"<td>"+data[i].anesthetist+"</td>"+
										"<td>"+data[i].circuanesthetist+"</td>"+
										"<td>"+data[i].anaesAssistant+"</td>"+
										"<td style='text-align:center;'><a href='javascript:void(0)' onclick='show_prompt("+data[i].id+")'>取消</a></td>"+
									"</tr>";
							}
							$('.yuyue').remove();
							$('#yytable').append(str);
						},"json");
					});
				}
		});
		if(s!=0) {
			alert("操作成功！");
		} else {
			alert("请输入安排信息！");
		}
	}	
</script>
<style type="text/css">
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
<input type="hidden" name="functionid" value="${functionid }" id="functionid">
<div class="Bread_crumbs">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">麻醉医师安排</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<div class="responsive-table">
			<div class="scrollable-area">
		<h5 class="text-center text-danger" style="text-align: left;margin-left: 10px;">请安排麻醉医师：</h5>
		<form id="form" action="mzysList.action" name="form" method="post">
			<input type="hidden" name="userid" id="id" value="${id}" />
			<table id="table" class="table table-bordered table-striped header-spcing"  style="table-layout: fixed;">
			<thead>
				<tr class="bj" >
					<td width="5%">姓名</td>
					<td width="2%">性别</td>
					<td width="3%">年龄</td>
					<td width="5%">住院号</td>
					<td width="5%">病区</td>
					<td width="5%">科室</td>
					<td width="5%">床号</td>
					<td width="6%">术前诊断</td>
					<td width="6%">拟施手术</td>
					<td width="7%">建议麻醉方法</td>
					<td width="6%">手术医师</td>
					<td width="5%">手术单号</td>
					<td width="7%">手术日期</td>
					<td width="5%">开始时间</td>
					<td width="5%">结束时间</td>
					<td width="7%">手术室</td>
					<td width="8%">手术麻醉医师</td>
					<td width="8%">巡台麻醉医师</td>
					<td width="8%">灌注医师</td>
				</tr>
			</thead>
				<c:forEach items="${sroList}" var="sro">
					<tr class="sro" data-id="${sro.id }">
						
						<td>${sro.name}</td>
						<td><c:if test="${sro.sex eq '0'}">男</c:if> <c:if
								test="${sro.sex eq '1'}">女</c:if></td>
						<td>${sro.age}</td>
						<td>${sro.hid}</td>
						<td>${sro.region}</td>
						<td>${sro.dept}</td>
						<td>${sro.bed}</td>
						
						<td class="hideTd">${sro.diagnosisName}</td>
						<td class="hideTd">${sro.designedOptName}</td>
						<td class="hideTd">${sro.designedAnaesMethodName}</td>
						<td class="hideTd">${sro.operatorName}</td>
						<td >${sro.preengagementnumber}</td>
						<td><fmt:formatDate value="${sro.operdate}" pattern="yyyy-MM-dd"/></td>
						<td>${sro.starttime}</td>
						<td>${sro.endtime}</td>
							
							<td>${sro.room}</td>
							<td style="vertical-align: middle;"><select class="anesthetist" name="sro.anesthetist" style="width: 85px;" >
							 <option value=""></option>
									<c:forEach items="${anesthetist}" var="ane">
										<option value="${ane.name}">${ane.name}</option>
									</c:forEach>
							</select></td>
							<td style="vertical-align: middle;"><select class="circuanesthetist" name="sro.circuanesthetist"  style="width: 85px;">
							 <option value=""></option>
									<c:forEach items="${circuanesthetist}" var="cir">
										<option value="${cir.name}">${cir.name}</option>
									</c:forEach>
							</select></td>
							<td style="vertical-align: middle;"><select class="anaesAssistant" name="sro.anaesAssistant" style="width: 85px;" >
							 <option value=""></option>
									<c:forEach items="${anaesAssistant}" var="ana">
										<option value="${ana.name}">${ana.name}</option>
									</c:forEach>
							</select></td>

					</tr>
				</c:forEach>
				<tr>
					<td colspan="20" style="text-align: left;">
					<c:if test="${affirmRole eq true }">
						<button type="button" class="button_blue_74_33"  style="border: medium none; margin-left: 10px;" onclick="add()">确定</button>
					</c:if>	
					</td>
				</tr>
			</table>
		</form>

	<br>
		<h5 class="text-center text-danger" style="text-align: left;margin-left: 10px;">预约列表：</h5>
			<table id="yytable" class="table table-bordered table-striped header-spcing" style="table-layout: fixed;">
				<thead>
				<tr class="bj" >
					<td width="5%">姓名</td>
					<td width="2%">性别</td>
					<td width="3%">年龄</td>
					<td width="5%">病区</td>
					<td width="5%">科室</td>
					<td width="5%">术前诊断</td>
					<td width="5%">拟施手术</td>
					<td width="5%">手术医师</td>
					<td width="7%">手术室</td>
					<td width="7%">预约日期</td>
					<td width="5%">开始时间</td>
					<td width="7%">第一器械护士</td>
					<td width="7%">第二器械护士</td>
					<td width="7%">第一巡回护士</td>
					<td width="7%">第二巡回护士</td>
					<td width="7%">手术麻醉医师</td>
					<td width="7%">巡台麻醉医师</td>
					<td width="5%">灌注医师</td>
					<c:if test="${removeRole eq true }">
					<td width="4%" style="text-align:center">操作</td>
					</c:if>
				</tr>
				</thead>
				<c:forEach items="${yyList}" var="sro">
					<tr class="yuyue">
						
						<td>${sro.name}</td>
						<td>${sro.sex}</td>
						<td>${sro.age}</td>
						<td class="hideTd">${sro.region}</td>
						<td class="hideTd">${sro.dept}</td>
						<td class="hideTd">${sro.diagnosisName}</td>
						<td class="hideTd">${sro.designedOptName}</td>
						<td class="hideTd">${sro.operatorName}</td>
						<td>${sro.room}</td>
						<td>${sro.operdate}</td>
						<td>${sro.starttime}</td>
						<td>${sro.circunurse1}</td>
						<td>${sro.circunurse2}</td>
						<td>${sro.instrnurse1}</td>
						<td>${sro.instrnurse2}</td>
						<td>${sro.anesthetist}</td>
						<td>${sro.circuanesthetist}</td>
						<td>${sro.anaesAssistant}</td>
						<c:if test="${removeRole eq true }">
						<td style="text-align:center;"><a href="javascript:void(0)"
							onclick="show_prompt('${sro.id}')">取消</a> 
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			</div>
			</div>
	</div>
</div>
</body>
</html>
