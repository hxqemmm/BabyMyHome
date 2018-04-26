package com.ht.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.User;
import com.ht.bean.Userinfo;
import com.ht.dao.UserinfoDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UserinfoServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserinfoDao dao=new UserinfoDao();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");//设置传输编码
		String method = req.getParameter("method");
		
		if(method!=null&&method.equals("personal")){	  //根据手机号查询出用户的全部信息，进入个人中心
			Userinfo ui=(Userinfo)req.getSession().getAttribute("userinfo");
			String phone=ui.getPhone();
			List list=dao.findUserinfo(phone);
			req.getSession().setAttribute("userinfo", list);
			req.getRequestDispatcher("personal.jsp").forward(req, resp);
		}else if(method!=null&&method.equals("personal_head")){					//前台头部进入个人中心
			
		}else if(method!=null&&method.equals("userinfo_add")){		//填写个人资料
			SmartUpload smart = new SmartUpload();
			smart.setCharset("UTF-8");
			smart.initialize(super.getServletConfig(), req, resp);
			String fileName = null;
			try {
				smart.upload();
				File img = smart.getFiles().getFile(0);
				if (img != null && img.getSize() > 0) {
					fileName = UUID.randomUUID().toString() + "." + img.getFileExt();
					img.saveAs("upload/headimage/" + fileName);
					
					String phone=smart.getRequest().getParameter("phone");
					String password=smart.getRequest().getParameter("password");
					String username=smart.getRequest().getParameter("username");
					String natives=smart.getRequest().getParameter("jiguan");
					String sex=smart.getRequest().getParameter("sex");
					String age=smart.getRequest().getParameter("age");
					String qq=smart.getRequest().getParameter("qq");
					String sdasd=smart.getRequest().getParameter("sdasd");
					
					Userinfo ui=new Userinfo();
					ui.setPhone(phone);
					ui.setPassword(password);
					ui.setUsername(username);
					ui.setHeadimage("upload/headimage/"+fileName);
					ui.setNatives(natives);
					ui.setSex(sex);
					ui.setAge(Integer.parseInt(age));
					ui.setQQ(qq);
					ui.setSdasd(sdasd);
					boolean save=dao.addUserinfo(ui);
					if(save){
						req.getSession().setAttribute("userinfo", ui);
						req.getRequestDispatcher("index").forward(req, resp);
					}else{  
						req.setAttribute("message","添加失败");
						req.getRequestDispatcher("register.jsp").forward(req, resp);	  
					}
				}  
			} catch (SmartUploadException e) {
				e.printStackTrace();  
			}
		}else if(method!=null&&method.equals("userinfo_modify")){		//修改个人资料
			SmartUpload smart = new SmartUpload();
			smart.setCharset("UTF-8");
			smart.initialize(super.getServletConfig(), req, resp);
			String fileName = null;
			try {
				smart.upload();
				File img = smart.getFiles().getFile(0);
				if (img != null && img.getSize() > 0) {
					fileName = UUID.randomUUID().toString() + "." + img.getFileExt();
					img.saveAs("upload/headimage/" + fileName);
					
					String id=req.getParameter("id");
					String phone=smart.getRequest().getParameter("phone");
					String password=smart.getRequest().getParameter("password");
					String username=smart.getRequest().getParameter("username");
					String natives=smart.getRequest().getParameter("jiguan");
					String sex=smart.getRequest().getParameter("sex");
					String age=smart.getRequest().getParameter("age");
					String qq=smart.getRequest().getParameter("qq");
					String sdasd=smart.getRequest().getParameter("sdasd");
					
					Userinfo ui=new Userinfo();
					ui.setId(Integer.parseInt(id));
					ui.setPhone(phone);
					ui.setPassword(password);
					ui.setUsername(username);
					ui.setHeadimage("upload/headimage/"+fileName);
					ui.setNatives(natives);
					ui.setSex(sex);
					ui.setAge(Integer.parseInt(age));
					ui.setQQ(qq);
					ui.setSdasd(sdasd);
					boolean update=dao.updateUserinfo(ui);
					if(update){
						req.getSession().setAttribute("userinfo", ui);
						req.getRequestDispatcher("userinfo?method=personal").forward(req, resp);
					}else{
						req.setAttribute("message","更新失败");
						req.getRequestDispatcher("register.jsp").forward(req, resp);
					}
				}  
			} catch (SmartUploadException e) {
				e.printStackTrace();  
			}
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
