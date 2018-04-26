package com.ht.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Admin;
import com.ht.bean.User;

public class UserFilter implements Filter{
	FilterConfig  c;
	public void destroy() {
		System.out.println("destory");
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
		FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		User u=(User) request.getSession().getAttribute("users");
		Admin a=(Admin)request.getSession().getAttribute("admin");
		if(u==null&&a==null){
			req.getRequestDispatcher("longin.jsp").forward(req,resp);
		}else{
			chain.doFilter(req, resp);
		} 
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("init");
		this.c=config;
	}

}
