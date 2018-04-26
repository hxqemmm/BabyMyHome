package com.ht.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ht.DBC.DBConn;
import com.ht.bean.Details;
import com.ht.bean.Index;
import com.ht.bean.Tops;

public class IndexDao {
	
	/**
	 * ��ѯ������ͼƬ
	 * */
	public List<Index> AllfindImage(){
		List<Index> list = new ArrayList<Index>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from images";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Index i=new Index();
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
	 * ��ѯ�ܹ��ж���ͼƬ
	 * */
	public int countImages(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from images";
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
	 * ��ѯ�����м�¼�����ͨ����
	 * */
	public List<Details> AllfindRecord(){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from record where audit='ͨ��'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("names"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getString("birthday"));
				d.setMissday(rs.getString("missday"));
				d.setRelation(rs.getString("relation"));
				d.setNatives(rs.getString("native"));
				d.setPlace(rs.getString("place"));
				d.setFeature(rs.getString("feature"));
				d.setPhoto(rs.getString("photo"));
				d.setPass(rs.getString("pass"));
				d.setReplenish(rs.getString("replenish"));
				d.setState(rs.getString("state"));
				d.setHeadline(rs.getString("headline"));
				list.add(d);
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
	 * ��ѯ�����й���
	 * */
	public List<Tops> AllfindTops(){
		List<Tops> list = new ArrayList<Tops>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from tops";
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
	 * ��ѯ������ ���һ� �ļ�¼
	 * */
	public List<Details> RecoveredRecord(){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from record where state='找回' and audit='通过' ";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("names"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getString("birthday"));
				d.setMissday(rs.getString("missday"));
				d.setRelation(rs.getString("relation"));
				d.setNatives(rs.getString("native"));
				d.setPlace(rs.getString("place"));
				d.setFeature(rs.getString("feature"));
				d.setPhoto(rs.getString("photo"));
				d.setPass(rs.getString("pass"));
				d.setReplenish(rs.getString("replenish"));
				d.setState(rs.getString("state"));
				d.setHeadline(rs.getString("headline"));
				d.setAudit(rs.getString("audit"));
				list.add(d);
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
	 * ��ѯ������ δ�һ� �ļ�¼
	 * */
	public List<Details> DropRecord(){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from record where state='找回' and audit='通过' ";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("names"));
				d.setSex(rs.getString("sex"));
				d.setBirthday(rs.getString("birthday"));
				d.setMissday(rs.getString("missday"));
				d.setRelation(rs.getString("relation"));
				d.setNatives(rs.getString("native"));
				d.setPlace(rs.getString("place"));
				d.setFeature(rs.getString("feature"));
				d.setPhoto(rs.getString("photo"));
				d.setPass(rs.getString("pass"));
				d.setReplenish(rs.getString("replenish"));
				d.setState(rs.getString("state"));
				d.setHeadline(rs.getString("headline"));
				d.setAudit(rs.getString("audit"));
				list.add(d);
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
