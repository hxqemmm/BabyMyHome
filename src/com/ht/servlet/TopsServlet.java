package com.ht.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Tops;
import com.ht.bean.Tickling;
import com.ht.dao.TopsDao;

public class TopsServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TopsDao dao=new TopsDao();
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
		if(method!=null&&method.equals("list")){		//�г������ں�̨
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
			List<Tops> list = dao.findAllTops(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("admin/notice.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("delete")){		//ɾ������
			String id=req.getParameter("id");
			dao.deletetops(id);
			int pagesize =4;
			int currId=dao.findCount();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("tops?method=list&currpage="+totalpage).forward(req, resp);
		}else if(method!=null&&method.equals("add")){			//��ӹ���
			String id=req.getParameter("id");
			String username = req.getParameter("username");
			String body=req.getParameter("editorValue");
			Date d = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			f.format(d);
			
			Tops t=new Tops();
			t.setUsername(username);
			t.setTime(f.format(d));
			t.setBody(body);
			t.setId(Integer.parseInt(id));
			boolean add =dao.addTops(t);
			if(add){
				req.getSession().setAttribute("add", t);
				req.getRequestDispatcher("tops?method=list").forward(req, resp);
			}else{ 
				req.setAttribute("message","���ʧ��");
				req.getRequestDispatcher("admin/addnotice.jsp").forward(req, resp);	
			}
		}else if(method!=null&&method.equals("tops")){			//�г����й�������ҳ
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
			List<Tops> list = dao.findAllTops(pagesize, currpage);
			req.setAttribute("currpage",Integer.toString(currpage));  
			req.setAttribute("totalpage",Integer.toString(totalpage));  
			req.setAttribute("count",Integer.toString(count));
			req.setAttribute("list", list);
			req.getRequestDispatcher("tops.jsp").forward(req, resp);
		}else if(method!=null&&method.equals("topsid")){		//����id���Ҷ�Ӧ�Ĺ���
			String id=req.getParameter("id");
			List list=dao.findTops(id);
			req.getSession().setAttribute("tops", list);
			req.getRequestDispatcher("proclamation.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
