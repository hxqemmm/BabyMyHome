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
import com.ht.bean.Tickling;

public class ticklingDao {
	
	/**
	 * ���һ������
	 * */
	public Boolean addTickling(Tickling s){
		Connection conn = DBConn.openDB();
		String sql = "insert into tickling(names,contact,ticklings,date) values(?,?,?,?)";
		Boolean addd = false;
		try {
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1,s.getName());
			pr.setString(2,s.getContact());
			pr.setString(3, s.getTicklings());
			pr.setString(4, s.getDate());
			
			int count = pr.executeUpdate();
			if(count>0){
				addd=true;
			}
			pr.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return addd;
	}
	
	/**
	 * ����id��ѯ�ܹ��ж�������
	 * */
	public int findContTilckling(String names){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from tickling where names='"+names+"'";
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
	 * ��ѯ�ܹ��ж�������
	 * */
	public int contAllTilckling(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from tickling";
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
	 * ��̨��ҳ��ѯ���з���
	 * */
	public List<Tickling> PagingQueryAll(int pagesize,int currpage){
		List<Tickling> list = new ArrayList<Tickling>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select top "+pagesize+" * from tickling where id not in(select top "+(currpage-1)*pagesize+" s.id from tickling s)";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Tickling t=new Tickling();
				t.setID(rs.getInt("id"));
				t.setName(rs.getString("names"));
				t.setContact(rs.getString("contact"));
				t.setTicklings(rs.getString("ticklings"));
				t.setDate(rs.getString("date"));
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
	 * ����issuer��ҳ��Ѱ
	 * */
	public List<Tickling> PagingQueryIssuer(int pagesize,int currpage,String names){
		List<Tickling> list = new ArrayList<Tickling>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			
			String sql="select * from tickling  where names='"+names+"' limit "+(currpage-1)*pagesize+","+pagesize;

			
			ResultSet rs=st.executeQuery(sql);
			

			
			while(rs.next()){
				Tickling t=new Tickling();
				t.setID(rs.getInt("id"));
				t.setName(rs.getString("names"));
				t.setContact(rs.getString("contact"));
				t.setTicklings(rs.getString("ticklings"));
				t.setDate(rs.getString("date"));
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
}
