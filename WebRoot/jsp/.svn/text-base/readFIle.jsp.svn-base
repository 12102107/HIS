<%@ page language="java" import="java.util.*,java.io.File;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'readFIle.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<%    
		String paths = "F:\\"; 
		String names = ""; 
		try { 
			File f = new File(paths); 
			out.print("ccc");
			if (f.isDirectory()) 
			{ 
				File[] fList = f.listFiles(); 
				for (int j = 0; j < fList.length; j++) { 
					File file = fList[j]; if (file.isFile()) 
					{ 
						names += file.getName(); 
						out.print(names);
					} 
				} 
			} 
		} catch (Exception e){
			e.printStackTrace();
		} 
	%>  

  </head>
  
  <body>

  </body>
</html>
