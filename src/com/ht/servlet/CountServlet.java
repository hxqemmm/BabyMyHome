package com.ht.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.dao.DetailsDao;
import com.ht.dao.IndexDao;
import com.ht.dao.TopsDao;
import com.ht.dao.UserinfoDao;
import com.ht.dao.ticklingDao;

public class CountServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DetailsDao dao=new DetailsDao();
		int count=dao.countCheckpending();
		req.getSession().setAttribute("sum", count);	//����˷�����Ϣ	
		
		int count2=dao.countRecovered();			
		req.getSession().setAttribute("sum2", count2);		//������һ���Ϣ
		
		int count3=dao.countDetails();			
		req.getSession().setAttribute("sum3", count3);		//ͨ����˵�������Ϣ
		
		IndexDao indao=new IndexDao();
		int count4=indao.countImages();	
		req.getSession().setAttribute("sum4", count4);		//���е��ֲ�ͼ
		
		TopsDao topdao=new TopsDao();
		int count5=topdao.findCount();
		req.getSession().setAttribute("sum5", count5);		//���еĹ���
		
		UserinfoDao userdao=new UserinfoDao();
		int count6=userdao.CountUserinfo();
		req.getSession().setAttribute("sum6", count6);		//���е��û�
															
		ticklingDao tdao=new ticklingDao();
		int count7=tdao.contAllTilckling();
		req.getSession().setAttribute("sum7", count7);		//���еķ���
		
		req.getRequestDispatcher("admin/index.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
