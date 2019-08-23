package com.common.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.redis.IRedisUtil;
import com.common.redis.RedisKeys;
import com.common.util.Util;
import com.opensymphony.xwork2.ActionSupport;

public class CommAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware, ServletContextAware{

	public Map session;
	public HttpServletRequest request;
	public HttpServletResponse response;
	public ServletContext context;
	@Autowired
	private IRedisUtil redisUtil;
	public void setSession(Map session) {
		this.session=session;
		String loginUserId=Util.null2String(session.get("userid"));
		if(!Util.isBlank(loginUserId)){
		//设置session过期时间和项目保持一致
		redisUtil.expire(RedisKeys.SYSOA,RedisKeys.SESSIONPrefix+loginUserId,1800);
		}
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletContext(ServletContext arg0) {
		context = arg0;
	}

}
