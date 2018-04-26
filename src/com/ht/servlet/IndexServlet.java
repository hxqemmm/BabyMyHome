package com.ht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.bean.Details;
import com.ht.bean.Index;
import com.ht.bean.Tops;
import com.ht.dao.IndexDao;

public class IndexServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			IndexDao dao=new IndexDao();
			req.setCharacterEncoding("utf-8");
				List<Index> list=dao.AllfindImage();
				req.setAttribute("index", list);
				
				List<Details> list2=dao.AllfindRecord();
				req.getSession().setAttribute("record", list2);
				
				List<Tops> list3=dao.AllfindTops();
				req.getSession().setAttribute("tops", list3);
				
				List<Details> list4=dao.DropRecord();	//查找出所有未找回的信息(审核通过)
				req.setAttribute("drop",list4);
				
				List<Details> list5=dao.RecoveredRecord();	//查找出所有已找回的信息（审核通过）
				req.setAttribute("recoverd",list5);
				
				req.getRequestDispatcher("index.jsp").forward(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
