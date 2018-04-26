package com.ht.servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Userinfo;
import com.ht.dao.AdminDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class AdminServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AdminDao dao=new AdminDao();
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
				
		if(method!=null&&method.equals("list")){		//列出用户
			int currpage = 1;
			int pagesize =4;
			int count=dao.findCount();
			int totalpage = (count+pagesize-1)/pagesize;
			String curr = req.getParameter("currpage");
			if(curr!=null&&!curr.equals("")){
				currpage = Integer.parseInt(curr);
			}
			if(currpage>totalpage){
				currpage = totalpage;  
			}
			if(currpage<1){
				currpage = 1;
			}
			List<Userinfo> list = dao.findAllUserinfo(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("admin/user.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("modify")){		//修改用户
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
						//req.getSession().setAttribute("userinfo", ui);
						req.getRequestDispatcher("admin?method=list").forward(req, resp);
					}else{
						req.setAttribute("message","更新失败");
						req.getRequestDispatcher("register.jsp").forward(req, resp);
					}
				}  
			} catch (SmartUploadException e) {
				e.printStackTrace();  
			}
		}else if(method!=null&&method.equals("delete")){		//删除用户
			String id=req.getParameter("id");
			dao.deleteUserinfo(id);
			int pagesize =4;
			int currId=dao.findCount();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("admin?method=list&currpage="+totalpage).forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
