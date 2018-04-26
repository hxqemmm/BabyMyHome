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
		
		if(method!=null&&method.equals("details")){						//��ҳ��ʾ���ݣ�����id��
			String id=req.getParameter("id");			
			List<Details> list=dao.AllfindDetails(id);
			req.setAttribute("details", list);
			req.getRequestDispatcher("details.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("details_admin")){			//��̨��ʾ���ݣ�����id��
			String id=req.getParameter("id");	
			List<Details> list=dao.AllfindDetails(id);
			req.setAttribute("details", list);
			req.getRequestDispatcher("admin/MyDetails.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("details_personal")){			//����������ʾ�����ݣ�����id��
			String id=req.getParameter("id");	
			List<Details> list=dao.AllfindDetails(id);
			req.setAttribute("details", list);
			req.getRequestDispatcher("detailsList.jsp").forward(req,resp);
		}else if(method!=null&&method.equals("list")){				//�������б����ݹؼ��֣�
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
		}else if(method!=null&&method.equals("add")){				//����Ѱ����Ϣ
			SmartUpload smart = new SmartUpload();
			smart.setCharset("UTF-8");
			smart.initialize(super.getServletConfig(), req, resp);
			String fileName = null;
			try {
				smart.upload();					//�Ѷ������ֽ��뱣����smart������(���������ڴ���)
				File img = smart.getFiles().getFile(0);		//��ȡ�ļ�����
				if (img != null && img.getSize() > 0) {
					fileName = UUID.randomUUID().toString() + "." + img.getFileExt();	//��������ļ���
					img.saveAs("upload/photo/" + fileName);		//���ļ����ڴ浱��д��Ӳ��
					
					String issuer=smart.getRequest().getParameter("issuer");
					String name=smart.getRequest().getParameter("username");
					String sex=smart.getRequest().getParameter("sex");
					
					//����ʱ��
					String year1=smart.getRequest().getParameter("year1");
					String month1=smart.getRequest().getParameter("month1");
					String day1=smart.getRequest().getParameter("day1");
					String birthday=year1+"-"+month1+"-"+day1;
					//ʧ��ʱ��
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
						req.setAttribute("message","���ʧ��");
						req.getRequestDispatcher("uploading.jsp").forward(req, resp);	  
					}
				}  
			} catch (SmartUploadException e) {
				e.printStackTrace();  
			}
		}else if(method!=null&&method.equals("list_details")){			//��̨��ҳ��ѯʧ����Ϣ�����ͨ����
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
		}else if(method!=null&&method.equals("checkpending")){			//��̨��ҳ��ѯ������Ϣ������ˣ�
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
		}else if(method!=null&&method.equals("recovered_list")){			//��̨��ҳ��ѯʧ����Ϣ������һ���Ϣ��
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
		}else if(method!=null&&method.equals("list_record")){			//�������Ĳ�ѯ����ʧ����Ϣ�����ݷ�����issuer��
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
		}else if(method!=null&&method.equals("delete")){				//��̨ɾ��������Ϣ(���ͨ��)
			String id=req.getParameter("id");
			dao.deleteDetails(id);
			int pagesize =4;
			int currId=dao.countDetails();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("details?method=list_details&currpage="+totalpage).forward(req, resp);
		}else if(method!=null&&method.equals("delete_personal")){				//��������ɾ��������Ϣ(����)
			String id=req.getParameter("id");
			String issuer=req.getParameter("issuer");
			dao.deleteDetails(id);
			int pagesize =4;
			int currId=dao.countDetails();
			int totalpage = (currId+pagesize-1)/pagesize;
			req.getRequestDispatcher("details?method=list_record&issuer="+issuer+"&currpage="+totalpage).forward(req, resp);
		}else if(method!=null&&method.equals("pass")){		//ͨ����ˣ���̨��
			String id=req.getParameter("id");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updatePass(d);
			if(update){
				req.getRequestDispatcher("details?method=checkpending").forward(req, resp);
			}else{
			}
		}else if(method!=null&&method.equals("recall")){		//������ˣ���̨��
			String id=req.getParameter("id");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updateRecall(d);
			if(update){
				req.getRequestDispatcher("details?method=checkpending").forward(req, resp);
			}else{
			}
		}else if(method!=null&&method.equals("recovered")){		//���ͨ���һ���Ϣ����̨��
			String id=req.getParameter("id");
			Details d=new Details();
			d.setId(Integer.parseInt(id));
			boolean update=dao.updaterecovered(d);
			if(update){
				req.getRequestDispatcher("details?method=checkpending").forward(req, resp);
			}else{
			}
		}else if(method!=null&&method.equals("notarize")){		//����ȷ���һ���Ϣ���������ģ�
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
