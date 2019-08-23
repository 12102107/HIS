<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

      <script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="../js/jquery.messager.js"></script></head>
  <script type="text/javascript">
$(function () {   
 $.messager.lays(200, 200);    
 $.messager.anim('fade', 1000); 
    $.messager.show("公告", "<a  href='<%=request.getContextPath()%>/noc/nocList.action' style='font-size:16px;color:red'>请查看最新公告</a>",15000);
    }
    
    );
    </script> 
  
  <body>
    <center>
    

    <br/><br/><br/><br/><br/><br/>
    </center>
  </body>
</html>
