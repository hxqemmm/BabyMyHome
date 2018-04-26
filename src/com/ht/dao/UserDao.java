package com.ht.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.DBC.DBConn;
import com.ht.bean.Admin;
import com.ht.bean.User;
import com.ht.bean.Userinfo;


public class UserDao {
	/**
	 * �û�ע��
	 * */
	public boolean addUser(User u){
		boolean save=false;
		Connection con = DBConn.openDB();
		try {
			String sql = "insert into user_register(phone,password) values(?,?)";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, u.getPhone());
			pr.setString(2, u.getPassword());
			int count = pr.executeUpdate();
			if(count>0){
				save = true;
			}
			pr.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return  save;
	}
	
	/**
	 * �û���¼��֤
	 * */
	public boolean findAllUser(User u){
		boolean save=false;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from userinfo where phone='"+u.getPhone()+"' and password='"+u.getPassword()+"'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				save=true;
			}
			rs.close();
			st.close();  
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return  save;
	}
	
	/**
	 * ����Ա��¼��֤
	 * */
	public boolean findAllAdmin(Admin a){
		boolean save=false;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from admin where username='"+a.getUsername()+"' and password='"+a.getPassword()+"'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				save=true;
			}
			rs.close();
			st.close();  
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return  save;
	}
	
	/**
	 * ����id���ҹ���Ա��������Ϣ
	 * */
	public List<Admin> findAdmin(String username){
		List<Admin> list = new ArrayList<Admin>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from admin where username ='"+username+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Userinfo ui=new Userinfo();
				Admin a=new Admin();
				a.setId(rs.getInt("id"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				list.add(a);
			}
			rs.close();
			st.close();
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * �����ֻ��Ų�ѯ���û���ȫ����Ϣ
	 * */
	public List<Userinfo> findUserinfo(String phone){
		List<Userinfo> list = new ArrayList<Userinfo>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from userinfo where phone="+phone;			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Userinfo ui=new Userinfo();
				ui.setId(rs.getInt("id"));
				ui.setPhone(rs.getString("phone"));
				ui.setUsername(rs.getString("username"));
				ui.setPassword(rs.getString("password"));
				ui.setHeadimage(rs.getString("headimage"));
				ui.setSex(rs.getString("sex"));
				ui.setAge(rs.getInt("age"));
				ui.setQQ(rs.getString("QQ"));
				ui.setNatives(rs.getString("native"));
				ui.setSdasd(rs.getString("sdasd"));
				list.add(ui);
			}
			rs.close();
			st.close();
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * ����issuer(�����˷�ҳ��ѯ�����е��ϴ�����)
	 * */
	public List<Userinfo> findRecord(String phone){
		List<Userinfo> list = new ArrayList<Userinfo>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from userinfo where phone="+phone;			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Userinfo ui=new Userinfo();
				ui.setId(rs.getInt("id"));
				ui.setPhone(rs.getString("phone"));
				ui.setUsername(rs.getString("username"));
				ui.setPassword(rs.getString("password"));
				ui.setHeadimage(rs.getString("headimage"));
				ui.setSex(rs.getString("sex"));
				ui.setAge(rs.getInt("age"));
				ui.setQQ(rs.getString("QQ"));
				ui.setNatives(rs.getString("native"));
				ui.setSdasd(rs.getString("sdasd"));
				list.add(ui);
			}
			rs.close();
			st.close();
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * �ж��ֻ����Ƿ����
	 * */
	public boolean findAllPhone(String phone){
		boolean redo=false;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from user_register where phone="+phone;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				redo=true;
			}
			rs.close();
			st.close();  
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return  redo;
	}
	
}
