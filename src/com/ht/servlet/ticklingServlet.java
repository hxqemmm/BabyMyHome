package com.ht.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Details;
import com.ht.bean.Tickling;
import com.ht.dao.ticklingDao;

@SuppressWarnings("serial")
public class ticklingServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");//设置响应传输编码
		
		ticklingDao dao = new ticklingDao();
		String mothod = req.getParameter("method");
		if(mothod!=null&&mothod.equals("add")){
			String name = req.getParameter("username");
			String phone = req.getParameter("phone");
			String ticklings = req.getParameter("editorValue");
			
			Date d = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			f.format(d);
			
			Tickling s = new Tickling();
			s.setName(name);
			s.setContact(phone);
			s.setTicklings(ticklings);
			s.setDate(f.format(d));
			Boolean is = dao.addTickling(s);
			
			if(is){
				req.getRequestDispatcher("personal.jsp").forward(req,resp);
			}else{  
				req.getRequestDispatcher("tickling.jsp").forward(req, resp);	  
			}
		}else if(mothod!=null&&mothod.equals("list_titckling")){		//根据issuer查寻出所有反馈
			String names=req.getParameter("username");
			int currpage = 1;
			int pagesize = 4;
			int count=dao.findContTilckling(names);
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
			List<Tickling> list = dao.PagingQueryIssuer(pagesize, currpage, names);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.setAttribute("list", list);
			req.getRequestDispatcher("ticklingList.jsp").forward(req, resp);
		}else if(mothod!=null&&mothod.equals("admin_list")){		//后台分页查询出所有反馈
			int currpage = 1;
			int pagesize = 4;
			int count=dao.contAllTilckling();
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
			List<Tickling> list = dao.PagingQueryAll(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.setAttribute("list", list);
			req.getRequestDispatcher("admin/ticklingList.jsp").forward(req, resp);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);	
	}

}
