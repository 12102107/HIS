<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/fn.tld" prefix="fn"%>
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


	<link id="artDialog-skin" href="../js/artDialog5.0/skins/default.css" rel="stylesheet" />
	<script src="../js/artDialog5.0/source/artDialog.js" type="text/javascript"></script>
<title>麻醉方法列表</title>
</head>
<!-- 分页代码 开始 -->
<script type="text/javascript">
	//设置双击回传值方法
	function huichuan(str) {
		setMzff(str);//回传信息
		$("#chooseMzff").window('close');
	}

	//设置选择麻醉方法的回传值方法
	function selected() {
		var ids = document.getElementsByName("ids");//设置所有抓到name为ids的复选框ids
		var zhuangtai = false;//设置默认状态为false
		var str = "";//设置默认字符串为"  "最后赋值
		for ( var i = 0; i < ids.length; i++) {
			if (ids[i].checked == true) {
				zhuangtai = true;
				str = str +ids[i].value+",";
				
			}
			
		}
		str=str.substring(0, str.length-1);
		
		//判断是否有已经被选中的
		if (zhuangtai == true) {
			setMzff(str);//回传信息
			$("#chooseMzff").window('close');
		} else {
			alert("请选择麻醉方法！");//否则提示
			return;
		}
	}
 //关闭用户选择框
        function closeMzff(){
        	$("#chooseMzff").window('close');
        }
</script>
<style>
.table th, .table td {
    border-top: 1px solid #ddd;
    line-height: 20px;
    padding: 8px;
    text-align: center;
    vertical-align: top;
}
</style>

<body>
				<table class="table table-hover" id="table">
					<tr>
						<td>
						选择
						</td>
						<td>代码</td>
						<td>名称</td>
						<th>一级分类</th>
						<th>二级分类</th>
						<th>三级分类</th>
						<th>是否常用</th>
					</tr>
					<c:forEach items="${mzffList}" var="mzff" >
						<tr class="tabtd1" ondblclick="huichuan('${mzff.name}')">
							<td>
							<input type="checkbox" name="ids"
								value="${mzff.name}">
							</td>
							<td>${mzff.code}</td>
							<td>${mzff.name}</td>
							<td>${mzff.cate1}</td>
							<td>${mzff.cate2}</td>
							<td>${mzff.cate3}</td>
							<td><c:if test="${mzff.isUsually eq '0'}">常用</c:if> <c:if
									test="${mzff.isUsually eq '1'}">不常用</c:if></td>
						</tr>
							</c:forEach>
				</table>
<button type="button" class="button_blue_74_33" style="border: medium;" onclick="selected()">确定</button>
<button type="button" class="button_blue_74_33" style="border: medium;" onclick="closeMzff()">取消</button>
</body>
</html>