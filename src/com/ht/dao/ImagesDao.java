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
import com.ht.bean.Index;

public class ImagesDao {
	/**
	 * ��̨��ҳ��ѯ�������ֲ�ͼ
	 * */
	public List<Index> PagingQueryImages(int pagesize,int currpage){
		List<Index> list = new ArrayList<Index>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			//String sql = "select top "+pagesize+" * from images where id not in(select top "+(currpage-1)*pagesize+" s.id from images s) ";
			String sql="select * from images limit "+(currpage-1)*pagesize+","+pagesize;
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Index i=new Index();
				i.setId(rs.getInt("id"));
				i.setUrl(rs.getString("url"));
				list.add(i);
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
	 * ������ж����ֲ�ͼ
	 * */
	public int countImages(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from images ";
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
	 * �ϴ��ֲ�ͼ
	 * */
	public boolean addImages(Index i){
		boolean save=false;
		Connection con = DBConn.openDB();
		try {
			String sql = "insert into images(url) values(?)";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, i.getUrl());
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
	 * ��̨ɾ���ֲ�ͼ
	 * */
	public void deleteImages(String id){
		Connection conn = DBConn.openDB();
		String sql="delete from images where id="+id;
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
