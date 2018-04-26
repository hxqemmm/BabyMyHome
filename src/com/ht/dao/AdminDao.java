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

public class AdminDao {

	/**
	 * ��ѯ�ܹ��ж����û�
	 * */
	public int findCount(){
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
	
	/**
	 * ��ҳ��ѯ�û�����
	 * */
	public List<Userinfo> findAllUserinfo(int pagesize,int currpage){
		List<Userinfo> list = new ArrayList<Userinfo>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select * from userinfo limit "+(currpage-1)*pagesize+","+pagesize;
			//System.out.println(sql);
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
	 * �����û�����
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
	 * ɾ���û���Ϣ
	 * */
	public void deleteUserinfo(String id){
		Connection conn = DBConn.openDB();
		String sql="delete from userinfo where id="+id;
		try {
			Statement st = conn.createStatement();
			st.execute(sql);
			st.close();
			conn.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
