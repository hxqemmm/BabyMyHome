package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Admin;
import com.ht.bean.Details;
import com.ht.bean.User;
import com.ht.dao.UserDao;

public class UserServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		UserDao dao=new UserDao();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");//设置响应传输编码
		String method = req.getParameter("method");
		String kaptchaExpected = (String) req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
	    String kaptchaReceived = req.getParameter("kaptcha"); //获取填写的验证码内容 
		PrintWriter out = resp.getWriter();
		
	    if(method!=null&&method.equals("verify")){		//判断验证码是否相同
			if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) {  
				req.setAttribute("verify",true);
			    req.getRequestDispatcher("register.jsp").forward(req, resp);
			}else {
			    System.out.println("验证码正确");
			}
		}else if(method!=null&&method.equals("user_register")){
			String phone=req.getParameter("phone");
			String password=req.getParameter("password");
			boolean redo=dao.findAllPhone(phone);
			if(phone!=null&&redo){
				req.setAttribute("flag", redo);
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}else{
				if(password!=null){
					User u=new User();
					u.setPhone(phone);
					u.setPassword(password);
					boolean save=dao.addUser(u);
					if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) { 
						req.setAttribute("message","验证码有误");
					    req.getRequestDispatcher("register.jsp").forward(req, resp);
					}else{
						if(save){
							req.getSession().setAttribute("material", u);
							req.getRequestDispatcher("material.jsp").forward(req, resp);
						}else{
							req.setAttribute("message","添加失败");
							req.getRequestDispatcher("register.jsp").forward(req, resp);	
						}
					}
				}else{
					
				}
			}
		}else if(method!=null&&method.equals("user_login")){
			String phone=req.getParameter("phone");
			String password=req.getParameter("password");
			User u=new User();
			u.setPhone(phone);
			u.setPassword(password);
			if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) { 
				req.setAttribute("message","验证码有误");
			    req.getRequestDispatcher("longin.jsp").forward(req, resp);
			}else {
				boolean save = dao.findAllUser(u);		//进行登录验证
				if(save){
					List list3=dao.findUserinfo(phone);		//根据手机号查询出用户的详细资料
					req.getSession().setAttribute("users", u);
					req.getSession().setAttribute("userinfo", list3);
					req.getRequestDispatcher("index").forward(req, resp);
				}else{  
					Admin a=new Admin();
					a.setUsername(phone);
					a.setPassword(password);
					boolean save2=dao.findAllAdmin(a);
					List list2=dao.findAdmin(phone);
					if(save2){
						req.getSession().setAttribute("admins", list2);
						req.getRequestDispatcher("count").forward(req, resp);
					}else{
						req.setAttribute("message","用户名或密码错误");
						req.getRequestDispatcher("longin.jsp").forward(req, resp);	
					}
				}
			}
		}else if(method!=null&&method.equals("out")){
			req.getSession().removeAttribute("users");
			resp.sendRedirect("longin.jsp");
		}
	}

protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doGet(req, resp);
	}
}
