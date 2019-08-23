package com.common.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor{  
 
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
//    	ActionContext actionContext = intercation.getInvocationContext();   
//    	 ServletContext context = (ServletContext) actionContext.get(StrutsStatics.SERVLET_CONTEXT);   
//    	 ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
//    	 ResultRoleRiskDao resultRoleRiskDao =(ResultRoleRiskDao)ctx.getBean("resultRoleRiskDao"); 
//    	System.out.println(ServletActionContext.getRequest().getServletPath());
        HttpSession session = ServletActionContext.getRequest().getSession();  
        String userId = (String) session.getAttribute("userid");
		if(userId == "" || userId == null){//错误,回到登录界面  
		    return Action.LOGIN;  
		}else{  
		    return invocation.invoke();  
		}  
    }  
  
}  

