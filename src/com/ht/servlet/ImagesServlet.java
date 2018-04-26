package com.ht.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Details;
import com.ht.bean.Index;
import com.ht.dao.ImagesDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class ImagesServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ImagesDao dao=new ImagesDao();
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
		if(method!=null&&method.equals("list")){					//后台分页查询出所有轮播图
			int currpage = 1;
			int pagesize =4;
			int count=dao.countImages();
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
			List<Index> list = dao.PagingQueryImages(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.setAttribute("list", list);
			req.getRequestDispatcher("admin/slideshow.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("add")){
			SmartUpload smart = new SmartUpload();
			smart.setCharset("UTF-8");
			smart.initialize(super.getServletConfig(), req, resp);
			String fileName = null;
			try {
				smart.upload();					//把二进的字节码保存在smart对象中(服务器的内存中)
				File img = smart.getFiles().getFile(0);		//获取文件对象
				if (img != null && img.getSize() > 0) {
					fileName = UUID.randomUUID().toString() + "." + img.getFileExt();	//随机生成文件名
					img.saveAs("upload/slideshow/" + fileName);		//把文件从内存当中写入硬盘
					
					Index i=new Index();
					i.setUrl("upload/slideshow/"+fileName);
					boolean save=dao.addImages(i);
					if(save){
						req.getRequestDispatcher("images?method=list").forward(req, resp);
					}else{  
						req.setAttribute("message","添加失败");
						req.getRequestDispatcher("addshow.jsp").forward(req, resp);	  
					}
				}  
			} catch (SmartUploadException e) {
				e.printStackTrace();  
			}
			
		}else if(method!=null&&method.equals("delete")){		//后台删除轮播图
			String id=req.getParameter("id");
			dao.deleteImages(id);
			int pagesize =4;
			int currId=dao.countImages();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("images?method=list&currpage="+totalpage).forward(req, resp);
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
