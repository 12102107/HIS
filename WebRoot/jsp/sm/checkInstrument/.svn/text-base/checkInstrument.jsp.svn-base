<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<title>手术器械清点</title>
<!--引入本页面整体样式文件 -->
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/GRUtility.js"></script>
<script type="text/javascript" src="../js/CreateControl.js"></script>
<script type="text/javascript">
CreateReport("Report");
function printN() {
	Report.LoadFromURL("../jsp/sm/checkInstrument/instrument.grf");
	AjaxSyncLoadReportData(Report,"loadPrint.action?id="+$("#ylws").val());
	Report.PrintPreview(true);
}

function back() {
	window.location.href="../ylws/ylwsList.action?functionid="+$('#functionid').val();
}

$(function() {
	$('.inactive').click(function(){
		if($(this).siblings('ul').css('display')=='none'){
			$(this).parent('li').siblings('li').removeClass('inactives');
			$(this).addClass('inactives');
			$(this).siblings('ul').slideDown(100).children('li');
			if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
				$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
				$(this).parents('li').siblings('li').children('ul').slideUp(100);

			}
		}else{
			//控制自身变成+号
			$(this).removeClass('inactives');
			//控制自身菜单下子菜单隐藏
			$(this).siblings('ul').slideUp(100);
			//控制自身子菜单变成+号
			$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
			//控制自身菜单下子菜单隐藏
			$(this).siblings('ul').children('li').children('ul').slideUp(100);

			//控制同级菜单只保持一个是展开的（-号显示）
			$(this).siblings('ul').children('li').children('a').removeClass('inactives');
		}
	})
	
	$(".inum").live("keyup",function(){
		$(this).val($(this).val().replace(/\D/gi,''));
	});
	
	$('.db').dblclick(function(){
		var type = $(this).attr('role');
		var id = $(this).attr('lang');
		if(type=='0') {
			var able = 0;
			$('.iid').each(function(){
				if(id==$(this).val()&&$(this).next('.itype').val()=='0') {
					alert("存在相同的手术器械！");able++;
				}
			});
			if(able==0) {
				$.post("getInstrumentInfo.action",{id:id},function(data){
					var str = "<tr class=\"cl\">";
					str += "<td>"+data[0].name+"</td>";
					str += "<td style=\"width: 155px;\">"+data[0].specifications+"</td>";
					str += "<td style=\"width: 75px;\">";
					str += "<input class=\"iid\" type=\"hidden\" value=\""+data[0].id+"\">";
					str += "<input class=\"itype\" type=\"hidden\" value=\"0\">";
					str += "<input type=\"text\" class=\"inum\" maxlength=\"4\" style=\"width: 75px;\">"
					str += "</td>";
					str += "<td>"+data[0].unit+"</td>";
					str += "<td style=\"width: 55px;\"><a href=\"javascript:void(0)\" onclick=\"delI(this)\">删除</a></td>";
					str += "</tr>";
					$('#checkList').append(str);
				},'json'); 
			}
		}
		if(type=='1') {
			var name = $(this).attr('title');
			var able = 0;
			$('.iid').each(function(){
				if(id==$(this).val()&&$(this).next('.itype').val()=='1') {
					alert("存在相同的手术包！");able++;
				}
			});
			if(able==0) {
				var str = "<tr class=\"cl\">";
				str += "<td>"+name+"</td>";
				str += "<td style=\"width: 155px;\"></td>";
				str += "<td style=\"width: 75px;\">";
				str += "<input class=\"iid\" type=\"hidden\" value=\""+id+"\">";
				str += "<input class=\"itype\" type=\"hidden\" value=\"1\">";
				str += "<input type=\"text\" class=\"inum\" maxlength=\"4\" style=\"width: 75px;\">"
				str += "</td>";
				str += "<td>件</td>";
				str += "<td style=\"width: 55px;\"><a href=\"javascript:void(0)\" onclick=\"delI(this)\">删除</a></td>";
				str += "</tr>";
				$('#checkList').append(str);
			}
		}
	});
	
});

function delI(obj) {
	$(obj).parent().parent().remove();
}

function commitCheck() {
	$('.iid').each(function(i){
		$(this).attr('name',"iid["+i+"]");
	});
	$('.inum').each(function(i){
		$(this).attr('name',"inum["+i+"]");
	});
	$('.itype').each(function(i){
		$(this).attr('name',"itype["+i+"]");
	});
	
	$.post("saveOrUpdateInstrumentCheck.action",$("#instrument").serialize(),function(){
		alert("操作成功！");
	});
}
</script>
<style type="text/css">
.cl{
	line-height: 40px;
	text-align: center;
}
.noboder {
 border-left: 0;
 border-right: 0;
 border-top: 0;
 border-bottom: 0;
 background-color: white;
}
input[type="checkbox"] {
vertical-align: baseline;
}
input[type="radio"] {
vertical-align: baseline;
}
*{margin: 0;padding: 0}
ul,li{list-style: none;}
a:link,a:visited{text-decoration: none;}
.list{width: 210px;margin:0px 10px 0 10px;}
/* .list ul li{background-color:#467ca2; border:solid 1px #316a91; border-bottom:0;} */
.list ul li a{padding-left: 10px;color: #1caad1; font-weight:bold; height:36px;line-height: 36px;display: inline-block;position: relative;vertical-align: middle;
}
.list ul li .inactive{ background:url(../images/off.png) no-repeat 10px center;}
.list ul li .inactives{background:url(../images/on.png) no-repeat 10px center;} 
.list ul li ul{display: none;}
/* .list ul li ul li { border-left:0; border-right:0; background-color:#6196bb; border-color:#467ca2;} */
.list ul li ul li ul{display: none;}
.list ul li ul li a{ padding-left:60px;}
.list ul li ul li ul li { background-color:#d6e6f1; border-color:#6196bb; }
/* .last{ background-color:#d6e6f1; border-color:#6196bb; } */
.list ul li ul li ul li a{ color:#316a91; padding-left:30px;}
</style>
</head>
<body class="page-header-fixed">
<input id="functionid" type="hidden" value="${functionid }">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">手术器械清点</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
		<!--面包屑结束-->
	<div class="responsive-table">
			<div class="scrollable-area">
						<!-- 下面显示列表内容 -->
						<form id="instrument">
						<input type="hidden" id="ylws" name="id" value="${id }">
						
						<table class="table table-bordered table-striped header-spcing">	
							<tr class="No">
								<td colspan="3" style="text-align: left;padding-left: 10px;">
									姓名：<input type="text" value="${sro.name }" disabled="disabled" >
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									年龄：<input type="text" value="${sro.age }岁" disabled="disabled" style="width: 100px;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									姓别： <input type="radio" name="sex" disabled="disabled" <c:if test="${sro.sex eq 0 }">checked</c:if>>男 
										<input type="radio" name="sex" disabled="disabled" <c:if test="${sro.sex eq 1 }">checked</c:if>>女
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									科室：<input type="text" value="${sro.dept }" disabled="disabled" >
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									床号：<input type="text" value="${sro.bed }" disabled="disabled" style="width: 100px;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									住院号：<input type="text" value="${sro.hid }" disabled="disabled" >
								</td>
							</tr>
							<tr class="No">
								<td  style="text-align: left;padding-left: 10px;vertical-align: middle;">
									手术类别：<c:if test="${sro.type eq 0 }">急诊手术</c:if>
											<c:if test="${sro.type eq 1 }">择期手术</c:if>
								</td>
								<td colspan="2" style="text-align: left;padding-left: 10px;vertical-align: middle;">
									手术名称：<input type="text" value="${sro.designedOptName }" style="width: 300px;">
								</td>
							</tr>
							
							</tbody>
							</table>
						
						<div style="display: inline-block; width: 100%;">
							<div style="float: left; width: 50%;height:500px; border-right:1px solid #1caad1;border-bottom:1px solid #1caad1;">
								<table style="width: 100%;">
									<tr style="background:#1caad1 none repeat scroll 0 0;line-height: 40px;">
										<td  style="color: white;font-size: 14px; padding-left: 10px;">选择手术包</td>
									</tr>
									<c:forEach items="${ip }" var="p">
									<tr>
										<td style="vertical-align: top; ">
										<div class="list">
											<ul class="yiji">
												<li><a href="javascript:void(0)" class="inactive" style="width: 15px;"></a>
													<a href="javascript:void(0)" lang="${p.id }" title="${p.name }" role="1" class="db" style="display: inline-block;vertical-align: middle;">${p.name }</a>
													<ul style="display: none">
														<c:forEach items="${p.instrument }" var="i">
														<li class="last">
														<a href="javascript:void(0)">
														${i.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														${i.num }&nbsp;${i.unit }
														</a></li>
														</c:forEach> 
													</ul>
												</li>
											</ul>
										</div>		
										</td>
									</tr>
									</c:forEach>
								</table>
								<table style="width: 100%;">
									<tr style="background:#1caad1 none repeat scroll 0 0;line-height: 40px;">
										<td  style="color: white;font-size: 14px; padding-left: 10px;">选择器械</td>
									</tr>
									<c:forEach items="${ilist }" var="i">
									<tr>
										<td>
											<a href="javascript:void(0)" lang="${i.id }" role="0" class="db" style="margin-left:30px; color: #1caad1; font-size:12px; font-weight:bold; height:36px;line-height: 36px;">
											${i.name }--${i.specifications }
											</a>
										</td>
									</c:forEach>
								</table>
							</div>
							<div style="float: left; width: 49%; height:500px;border-bottom:1px solid #1caad1;">
							<table style="width: 100%;" id="checkList">
									<tr style="background:#1caad1 none repeat scroll 0 0;line-height: 40px;">
										<td colspan="5" style="color: white;font-size: 14px; padding-left: 10px;">器械清单</td>
									</tr>
									<c:forEach items="${pcheck }" var="cp">
									<tr class="cl">
										<td>${cp.name }</td>
										<td style="width: 155px;"></td>
										<td style="width: 75px;">
											<input class="iid" type="hidden" value="${cp.id }"/>
											<input class="itype" type="hidden" value="1"/>
											<input type="text" class="inum" maxlength="4" value="${cp.num }" style="width: 75px;"/>
										</td>
										<td>件</td>
										<td style="width: 55px;"><a href="javascript:void(0)" onclick="delI(this)">删除</a></td>
									</tr>
									</c:forEach>
									<c:forEach items="${icheck }" var="ci">
									<tr class="cl">
										<td>${ci.name }</td>
										<td style="width: 155px;">${ci.specifications }</td>
										<td style="width: 75px;">
											<input class="iid" type="hidden" value="${ci.id }"/>
											<input class="itype" type="hidden" value="0"/>
											<input type="text" class="inum" maxlength="4" value="${ci.num }" style="width: 75px;"/>
										</td>
										<td>${ci.unit }</td>
										<td style="width: 55px;"><a href="javascript:void(0)" onclick="delI(this)">删除</a></td>
									</tr>
									</c:forEach>
							</table>		
							</div>
						</div>
						</form>
						<div style="text-align: center;clear:both;margin-top: 30px;margin-bottom: 20px;">
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="commitCheck()">确定</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="printN()">打印</button>
						<button type="button" class="button_blue_74_33"  style="border: medium none;" onclick="back()">返回</button>
						</div>
					</div>
				</div>
			</div>
</body>
</html>
