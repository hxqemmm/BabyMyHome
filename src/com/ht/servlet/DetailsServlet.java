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
import com.ht.bean.Tops;
import com.ht.bean.User;
import com.ht.bean.Userinfo;
import com.ht.dao.DetailsDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class DetailsServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DetailsDao dao=new DetailsDao();
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
		if(method!=null&&method.equals("details")){						//首页显示数据（根据id）
			String id=req.getParameter("id");			
			List<Details> list=dao.AllfindDetails(id);
			req.setAttribute("details", list);
			req.getRequestDispatcher("details.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("details_admin")){			//后台显示数据（根据id）
			String id=req.getParameter("id");	
			List<Details> list=dao.AllfindDetails(id);
			req.setAttribute("details", list);
			req.getRequestDispatcher("admin/MyDetails.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("details_personal")){			//个人中心显示出数据（根据id）
			String id=req.getParameter("id");	
			List<Details> list=dao.AllfindDetails(id);
			req.setAttribute("details", list);
			req.getRequestDispatcher("detailsList.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("list")){				//搜索框列表（传递关键字）
			String name=req.getParameter("name");
			int currpage = 1;
			int pagesize =4;
			int count=dao.findCount(name);
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
			List<Details> list = dao.findAllInquire(pagesize,currpage,name);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.setAttribute("list", list);
			req.getRequestDispatcher("list.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("add")){				//发布寻找信息
			SmartUpload smart = new SmartUpload();
			smart.setCharset("UTF-8");
			smart.initialize(super.getServletConfig(), req, resp);
			String fileName = null;
			try {
				smart.upload();					//把二进的字节码保存在smart对象中(服务器的内存中)
				File img = smart.getFiles().getFile(0);		//获取文件对象
				if (img != null && img.getSize() > 0) {
					fileName = UUID.randomUUID().toString() + "." + img.getFileExt();	//随机生成文件名
					img.saveAs("upload/photo/" + fileName);		//把文件从内存当中写入硬盘
					
					String issuer=smart.getRequest().getParameter("issuer");
					String name=smart.getRequest().getParameter("username");
					String sex=smart.getRequest().getParameter("sex");
					
					//出生时间
					String year1=smart.getRequest().getParameter("year1");
					String month1=smart.getRequest().getParameter("month1");
					String day1=smart.getRequest().getParameter("day1");
					String birthday=year1+"-"+month1+"-"+day1;
					//失踪时间
					String year2=smart.getRequest().getParameter("year2");
					String month2=smart.getRequest().getParameter("month2");
					String day2=smart.getRequest().getParameter("day1");
					String missday=year2+"-"+month2+"-"+day2;
					
					String relation=smart.getRequest().getParameter("guanxi");
					String natives=smart.getRequest().getParameter("jiguan");
					String place=smart.getRequest().getParameter("didian");
					String feature=smart.getRequest().getParameter("tez");
					String pass=smart.getRequest().getParameter("jingguo");
					String replenish=smart.getRequest().getParameter("shuoming");
					String state=smart.getRequest().getParameter("shifuo");
					String headline=smart.getRequest().getParameter("biaoti");
					String audit=smart.getRequest().getParameter("audit");
					
					Date date = new Date();
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String times=f.format(date);
					
					Details d=new Details();
					d.setName(name);
					d.setIssuer(issuer);
					d.setSex(sex);
					d.setBirthday(birthday);
					d.setMissday(missday);
					d.setRelation(relation);
					d.setNatives(natives);
					d.setPlace(place);
					d.setFeature(feature);
					d.setPhoto("upload/photo/"+fileName);
					d.setPass(pass);
					d.setReplenish(replenish);
					d.setState(state);
					d.setHeadline(headline);
					d.setTimes(times);
					d.setAudit(audit);
					
					boolean save=dao.addDetails(d);
					if(save){
						req.getRequestDispatcher("index").forward(req, resp);
					}else{  
						req.setAttribute("message","添加失败");
						req.getRequestDispatcher("uploading.jsp").forward(req, resp);	  
					}
				}  
			} catch (SmartUploadException e) {
				e.printStackTrace();  
			}
		}else if(method!=null&&method.equals("list_details")){			//后台分页查询失踪信息（审核通过）
			int currpage = 1;
			int pagesize =4;
			int count=dao.countDetails();
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
			List<Details> list = dao.findAllDetails(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("admin/message.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("checkpending")){			//后台分页查询发布信息（待审核）
			int currpage = 1;
			int pagesize =4;
			int count=dao.countCheckpending();
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
			List<Details> list = dao.findAllCheckpending(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("admin/stateAudit.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("recovered_list")){			//后台分页查询失踪信息（审核找回信息）
			int currpage = 1;
			int pagesize =4;
			int count=dao.countRecovered();
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
			List<Details> list = dao.findCheckpending(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("admin/Examine.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("list_record")){			//个人中心查询发布失踪信息（根据发布人issuer）
			String issuer=req.getParameter("issuer");
			int currpage = 1;
			int pagesize =4;
			int count=dao.findDetailsID(issuer);
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
			List<Details> list = dao.PagingQueryIssuer(pagesize, currpage, issuer);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("uploadingList.jsp").forward(req, resp);
		}else if(method!=null&&method.equals("delete")){				//后台删除发布信息(审核通过)
			String id=req.getParameter("id");
			dao.deleteDetails(id);
			int pagesize =4;
			int currId=dao.countDetails();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("details?method=list_details&currpage="+totalpage).forward(req, resp);
		}else if(method!=null&&method.equals("delete_personal")){				//个人中心删除发布信息(撤回)
			String id=req.getParameter("id");
			String issuer=req.getParameter("issuer");
			dao.deleteDetails(id);
			int pagesize =4;
			int currId=dao.countDetails();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("details?method=list_record&issuer="+issuer+"&currpage="+totalpage).forward(req, resp);
		}else if(method!=null&&method.equals("pass")){		//通过审核（后台）
			String id=req.getParameter("id");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updatePass(d);
			if(update){
				req.getRequestDispatcher("details?method=checkpending").forward(req, resp);
			}else{
			}
		}else if(method!=null&&method.equals("recall")){		//撤回审核（后台）
			String id=req.getParameter("id");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updateRecall(d);
			if(update){
				req.getRequestDispatcher("details?method=checkpending").forward(req, resp);
			}else{
			}
		}else if(method!=null&&method.equals("recovered")){		//审核通过找回信息（后台）
			String id=req.getParameter("id");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updaterecovered(d);
			if(update){
				req.getRequestDispatcher("details?method=checkpending").forward(req, resp);
			}else{
			}
		}else if(method!=null&&method.equals("notarize")){		//发布确认找回信息（个人中心）
			String id=req.getParameter("id");
			String issuer=req.getParameter("issuer");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updateNotarizeRecall(d);
			if(update){
				req.getRequestDispatcher("details?method=list_record&&issuer="+issuer).forward(req, resp);
			}else{
			}
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
