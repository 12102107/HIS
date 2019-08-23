<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="js/easyui-1.4.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui-1.4.1/themes/icon.css">
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/easyui-1.4.1/jquery.easyui.min.js"></script>
  </head>
  
  <body>
    <center>
    <div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="padding:5px">

    	<ul id="tt" class="easyui-tree" data-options="
				url: 'user/ajaxTree',
				method: 'post',
			    lines: true,
				onClick: function(node){
					$(this).tree('update',node.target);
				}"></ul>
    	
        </div>
    </center>
  </body>
</html>
