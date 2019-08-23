<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fmt.tld" prefix="fmt"%>
<%
    int xh = (Integer) request.getAttribute("xh");
	String info = "";
	if (request.getAttribute("info") != null) {
		info = (String) request.getAttribute("info");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../css/Two_navigation.css" rel="stylesheet" type="text/css">
	<link href="../css/List.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../js/easyui-1.4.1/themes/default/easyui.css" />
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../js/pagejs/jqPaginator.js"></script>
	<script type="text/javascript" src="../js/easyui-1.4.1/jquery.easyui.min.js"></script>
	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<title>医疗文书</title>
</head>
<!-- 分页代码 开始 -->
<script type="text/javascript">
		var info="<%=info%>";
	if (info.length > 0) {
		alert(info);
	}
   //console.info(info);
	//加载分页初始化信息
	function paging_init() {
		$.jqPaginator('#pageurl', {
			//总页数
			totalPages : Number("${totalP}"),
			//当前页码数量
			currentPage : Number($("#page").val()),
			//上一页和下一页中间显示的页码数量
			visiblePages : 5,
			//页码数发生改变调用查询方法重新加载数据
			onPageChange : function(num, type) {
				//表单提交请求
				if (type == 'change') {
					//查询form表单
					var queryForm = document.getElementById("form");
					document.getElementById("page").value = num;
					queryForm.submit();
				}
			}
		});
	}
	//跳转到相应页面
function gotopage(){
	  //查询form表单
	  var queryForm =document.getElementById("form");
	  document.getElementById("page").value=document.getElementById("gopage").value;
	  queryForm.submit();
}

	function guidang(){
     	$('.ylwsid').each(function(){
			if($(this).attr('checked')) {
				var id = $(this).val();
				$.post("checkSmWirtstate.action",{id:id},function(data){
					if(data=="0") {
						$.post("modArchived.action",{id:id},function(){
        					alert('操作成功！');
        					$('#form').submit();
        				});
					} else if(data=="1") {
						alert('请填写病人医疗文书并提交后归档！');
					} else {
						alert(data);
					}
				});
			}
		});
}

</script>
<!-- 分页代码 结束 -->

<body class="page-header-fixed" onload="paging_init()">
<div class="Bread_crumbs">
	<div class="page-container">
		<!--面包屑开始-->
		<div class="Bread_crumbs">
			<font class="pull-left">医疗文书</font> <img
				src="../images/title-Bread_crumbs-icon.png"
				style="margin-top: 10px;">
		</div>
			<form id="form" action="ylwsList.action" name="form" method="post">
				<input type="hidden" name="page" id="page" value="${page}" /> 
				<input type="hidden" name="userid" id="id" value="${id}" />
				<input type="hidden" name="functionid" id="functionid" value="${functionid}" />
				<table class="table table-bordered table-striped header-spcing" id="table" style="margin-left: 10px;">	
					<thead>
					<tr class="bj">
					    <td></td>
						<td>姓名</td>
						<td>住院号</td>
						<td>手术间</td>
						<td>预约日期</td>
						<td>手术状态</td>
						<td>拟施手术</td>
						<c:if test="${preVisitRole eq true}">
						<td>术前访视</td>
						</c:if>
						<c:if test="${agreementRole eq true}">
						<td>同意书</td>
						</c:if>
						<c:if test="${anesthesiaPlanRole eq true}">
						<td>麻醉计划</td>
						</c:if>
						<c:if test="${anestheticRecordRole eq true}">
						<td>麻醉记录</td>
						</c:if>
						<c:if test="${anesthesiaSummaryRole eq true}">
						<td>麻醉总结</td>
						</c:if>

						<td>是否进入恢复室</td>

						<c:if test="${followUpRole eq true}">
						<td>术后随访</td>
						</c:if>
						<c:if test="${optNurseRole eq true}">
						<td>手术护理</td>
						</c:if>
						<%-- <c:if test="${instrumentRole eq true}"> --%>
						<td>器械清单</td>
						<%-- </c:if> --%>
					</tr>
					</thead>
					<c:forEach items="${ylwsList}" var="ylws">
						<tr id="${ylws.id}"  class="No" <c:if test="${ylws.emergency eq '1'}">style="background-color: #FF99FF;"</c:if> >
						 <!--    <td><input name="ids" type="hidden" value="${ylws.id}" /><%=xh++%></td> -->
						    <td><input type="radio" name="ylwsName" class="ylwsid" value="${ylws.id}" /></td>
							<td>${ylws.name}</td>
							<td>${ylws.hid}</td>
							<td>${ylws.room}</td>
							<td><fmt:formatDate  value="${ylws.operdate}" pattern="yyyy-MM-dd" /></td>
							<td id="stateId"><c:if test="${ylws.state eq '03'}">未开始</c:if>
							<c:if test="${ylws.state eq '04'}">进行中</c:if>
							<c:if test="${ylws.state eq '05'}">已结束</c:if>
							</td>
							<td>${ylws.designedOptName}</td>
							<c:if test="${preVisitRole eq true}">
							<td><a href="../preVisit/preVisitList.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>&nbsp;
							<span class="sqfsClass" style="color:red;font-size:16px;">✖</span>
							</td>
							</c:if>
							<c:if test="${agreementRole eq true}">
							<td><a href="${pageContext.request.contextPath}/mztys/ylwsToMztys.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span class="tysClass" style="color:red;font-size:16px;">✖</span>
							</td>
							</c:if>
							<c:if test="${anesthesiaPlanRole eq true}">
							<td><a href="${pageContext.request.contextPath}/mzjh/ylwsToMzjh.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span class="mzjhClass" style="color:red;font-size:16px;">✖</span>
							</td>
							</c:if>
							<c:if test="${anestheticRecordRole eq true}">
							<td><a href="${pageContext.request.contextPath}/anesthesiaRecord/loadAnesthesiaRecord.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>&nbsp;
							<c:if test="${ylws.state eq '03'}"><span style="color:red;font-size:16px;">✖</span></c:if>
							<c:if test="${ylws.state eq '04'}"><span style="color:DarkOrange;font-size:16px;">❤</span></c:if>
							<c:if test="${ylws.state eq '05'}"><span style="color:green;font-size:16px;">✔</span></c:if>
							</td>
							</c:if>
							
							<c:if test="${anesthesiaSummaryRole eq true}">
							<td><a href="../summary/getSummaryByYlwsid.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span style="color:red;font-size:16px;">✖</span></td>
							</c:if>
							
							<td>
							<a href="../recovery/getRecoveryRecordByYlwsid.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span class="recoveryClass" style="color:red;font-size:16px;">✖</span>
							</td>
							
							<c:if test="${followUpRole eq true}">
							<td><a href="${pageContext.request.contextPath}/shsf/ylwsToShsf.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span style="color:red;font-size:16px;">✖</span>
							</td>
							</c:if>
							<c:if test="${optNurseRole eq true}">
							<td><a href="../optNurse/optNurseList.action?ylwsid=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span style="color:red;font-size:16px;">✖</span>
							</td>
							</c:if>
							<%-- <c:if test="${instrumentRole eq true}"> --%>
							<td><a href="../instrument/checkInstrumentTo.action?id=${ylws.id}&functionid=${functionid}">进入</a>
							&nbsp;<span style="color:red;font-size:16px;">✖</span>
							</td>
						<%-- 	</c:if> --%>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${archivedRole eq true}">
					<center><input type="button" id="button1" value="归档" style="margin-top: 10px;"
								class="btn btn-primary btn-sm" onclick="guidang()"></center>
				</c:if>				
				<!-----------分页文件引入----->
				<c:if test="${not empty ylwsList}">
				<%@include file="/common/page.jsp"%>
				</c:if>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	
window.onload = function(){
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);  
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var realPath=localhostPaht+projectName;
	
 var params = {};
      $.post( realPath+"/anesthesiaRecord/loadDocumentState.action", 
      		 params,     
               	function documentState(data){
                      var json = data;  
                      documentData = eval('(' + json + ')');  
                      for(var i=0;i<documentData.length;i++){
                          var ylwsId01 = documentData[i].ylwsState;
                          var sqfsState = documentData[i].sqfsState;
                          var tysState = documentData[i].tysState;
                          var mzjhState = documentData[i].mzjhState;
                          var recoveryState = documentData[i].recoveryState;
                          if(sqfsState=='1'){
                            $("#"+ylwsId01).find(".sqfsClass").text("✔"); 
                            $("#"+ylwsId01).find(".sqfsClass").attr('style','color:green');
                          }
                          if(tysState=='1'){
                           $("#"+ylwsId01).find(".tysClass").text("✔"); 
                            $("#"+ylwsId01).find(".tysClass").attr('style','color:green');
                          }
                          if(mzjhState=='1'){
                           $("#"+ylwsId01).find(".mzjhClass").text("✔"); 
                            $("#"+ylwsId01).find(".mzjhClass").attr('style','color:green');
                          }
                          if(recoveryState=='1'){
                           $("#"+ylwsId01).find(".recoveryClass").text("✔"); 
                            $("#"+ylwsId01).find(".recoveryClass").attr('style','color:green');
                          }
                          
                          
                          
                      }
                     
      });
};
	</script>
</body>
</html>