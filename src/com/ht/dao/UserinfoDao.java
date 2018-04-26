package com.ht.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.DBC.DBConn;
import com.ht.DBC.DBConnFactory;
import com.ht.bean.Userinfo;

public class UserinfoDao {
	
	
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
	 * ��д������Ϣ
	 * */
	public boolean addUserinfo(Userinfo ui){
		boolean save=false;
		Connection con = DBConn.openDB();
		try {
			String sql = "insert into userinfo(phone,username,password,headimage,sex,age,QQ,native,sdasd) values(?,?,?,?,?,?,?,?,?)";			
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, ui.getPhone());
			pr.setString(2, ui.getUsername());
			pr.setString(3, ui.getPassword());
			pr.setString(4, ui.getHeadimage());
			pr.setString(5, ui.getSex());
			pr.setInt(6, ui.getAge());
			pr.setString(7, ui.getQQ());
			pr.setString(8, ui.getNatives());
			pr.setString(9, ui.getSdasd());
			int count = pr.executeUpdate();
			if(count>0){
					save=true;
			}
			pr.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return save;
	}
	
	/**
	 * ���ĸ�������
	 * */
	public boolean updateUserinfo(Userinfo ui){
		boolean update=false;
		Connection con = DBConn.openDB();
		String sql = "update userinfo set phone=?,username=?,password=?,headimage=?,sex=?,age=?,QQ=?,native=?,sdasd=? where id=?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, ui.getPhone());
			pr.setString(2, ui.getUsername());
			pr.setString(3, ui.getPassword());
			pr.setString(4, ui.getHeadimage());
			pr.setString(5, ui.getSex());
			pr.setInt(6, ui.getAge());
			pr.setString(7, ui.getQQ());
			pr.setString(8, ui.getNatives());
			pr.setString(9, ui.getSdasd());
			pr.setInt(10, ui.getId());
			
			pr.execute();
			update = true;
			con.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	 /** 
	  * ��ѯ�ܹ��ж����û�
	  * */
	public int CountUserinfo(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from userinfo";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				count = rs.getInt(1);
			}
			rs.close();
			st.close();  
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
