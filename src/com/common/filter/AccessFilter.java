package com.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.util.Util;



public class AccessFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) arg1 ;
		String userId = (String) req.getSession().getAttribute("userid");
		response.setHeader("Cache-Control ","no-cache ");
		response.setHeader("Pragma ", "no-cache ");
		response.setDateHeader("Expires ", 0);
		request.setCharacterEncoding("UTF-8");
		if("".equals(userId)||userId==null){
			PrintWriter out=response.getWriter();
			out.print("<script language>top.location.href='"+Util.loginUrl+"index.jsp'</script>");
			//response.sendRedirect(req.getContextPath()+"/jump.jsp");
		} else{
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

	

}
