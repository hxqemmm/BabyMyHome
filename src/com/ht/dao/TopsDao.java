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
import com.ht.bean.Tops;
public class TopsDao {
	/**
	 * ��ѯ�ܹ��ж��ٹ���
	 * */
	public int findCount(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from tops";
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
	 * ����id��ѯ�������ȫ����Ϣ
	 * */
	public List<Tops> findTops(String id){
		List<Tops> list = new ArrayList<Tops>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from tops where id="+id;			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Tops t=new Tops();
				t.setId(rs.getInt("id"));
				t.setUsername(rs.getString("username"));
				t.setBody(rs.getString("body"));
				t.setTime(rs.getString("times"));
				list.add(t);
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
	 * ��ӹ���
	 * */
	public boolean addTops(Tops t){
		Connection conn = DBConn.openDB();
		String sql = "insert into tops(username,body,times) values(?,?,?)";
		Boolean add = false;
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, t.getUsername());
			pr.setString(2, t.getBody());
			pr.setString(3, t.getTime());
			int count = pr.executeUpdate();
			if(count>0){
				add=true;
			}
			pr.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return add;
	}
	
	/**
	 * ��ҳģ����ѯ
	 * */
	public List<Tops> findAllTops(int pagesize,int currpage){
		List<Tops> list = new ArrayList<Tops>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select top "+pagesize+" * from tops where id not in(select top "+(currpage-1)*pagesize+" s.id from record s)";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Tops t=new Tops();
				t.setId(rs.getInt("id"));
				t.setUsername(rs.getString("username"));
				t.setBody(rs.getString("body"));
				t.setTime(rs.getString("times"));
				list.add(t);
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
	 * ɾ������
	 * */
	public void deletetops(String id){
		Connection conn = DBConn.openDB();
		String sql="delete from tops where id="+id;
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
