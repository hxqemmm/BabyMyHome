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
import com.ht.bean.Details;

public class DetailsDao {
	/**
	 * ����id��ѯ��������Ϣ����ҳ���������ģ���̨��ʾ���飩
	 * */
	public List<Details> AllfindDetails(String id){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select * from record where id="+id;
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ��ҳģ����ѯ��������
	 * */
	public List<Details> findAllInquire(int pagesize,int currpage,String name){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select top "+pagesize+" * from record where id not in(select top "+(currpage-1)*pagesize+" s.id from record s) and names like'%"+name+"%'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ����issuer��ҳ��Ѱ���������ģ�
	 * */
	public List<Details> PagingQueryIssuer(int pagesize,int currpage,String issuer){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select * from record  where issuer='"+issuer+"' limit "+(currpage-1)*pagesize+","+pagesize;
			
			//System.out.println(sql);
			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ����issuer��ѯ�ܹ��ж��ٷ�����Ϣ���������ģ�
	 * */
	public int findDetailsID(String issuer){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from record where issuer='"+issuer+"'";
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
	 * ��ҳ��ѯ�����е�ʧ����Ϣ�ں�̨�����ͨ����
	 * */
	public List<Details> findAllDetails(int pagesize,int currpage){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			//String sql = "select top "+pagesize+" * from (select * from record where audit='通过')s where id not in(select top "+(currpage-1)*pagesize+" s.id from (select * from record where audit='通过') s)";
			String sql ="select * from record where audit='通过' limit "+(currpage-1)*pagesize+","+pagesize;
			
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ��ҳ��ѯ�����д����
	 * */
	public List<Details> findAllCheckpending(int pagesize,int currpage){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select top "+pagesize+" * from record where id not in(select top "+(currpage-1)*pagesize+" s.id from record s) and audit='����'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ��ҳ��ѯ�����д�����һ���Ϣ
	 * */
	public List<Details> findCheckpending(int pagesize,int currpage){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select top "+pagesize+" * from record where id not in(select top "+(currpage-1)*pagesize+" s.id from record s) and state='����'and audit='ͨ��' ";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ��ҳ��ѯ�һ����ݣ�����ˣ�
	 * */
	public List<Details> findAllRecovered(int pagesize,int currpage){
		List<Details> list = new ArrayList<Details>();
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql = "select top "+pagesize+" * from record where id not in(select top "+(currpage-1)*pagesize+" s.id from record s) and audit='����' and state='����'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Details d=new Details();
				d.setId(rs.getInt("id"));
				d.setIssuer(rs.getString("issuer"));
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
				d.setTimes(rs.getString("times"));
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
	 * ��ѯ�ܹ��ж���ͨ���������
	 * */
	public int countDetails(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from record  where audit='通过'";
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
	 * ��ѯ�ܹ��ж��ٴ��������
	 * */
	public int countCheckpending(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from record where audit='不通过'";
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
	 * ��ѯ�ܹ��ж����һ����ݣ�����ˣ�
	 * */
	public int countRecovered(){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from record where audit='通过' and state='未找回' ";
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
	 * ģ����ѯ�ܹ��ж������ݣ�������
	 * */
	public int findCount(String name){
		int count=0;
		Connection con = DBConn.openDB();
		try {
			Statement st=con.createStatement();
			String sql="select count(*) from record where names like'%"+name+"%'";
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
	 * ���һ����¼
	 * */
	public boolean addDetails(Details d){
		boolean save=false;
		Connection con = DBConn.openDB();
		try {
			String sql = "insert into record(issuer,names,sex,birthday,missday,relation,native,place,feature,photo,pass,replenish,state,headline,times,audit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, d.getIssuer());
			pr.setString(2,d.getName());
			pr.setString(3, d.getSex());
			pr.setString(4, d.getBirthday());
			pr.setString(5, d.getMissday());
			pr.setString(6, d.getRelation());
			pr.setString(7, d.getNatives());
			pr.setString(8, d.getPlace());
			pr.setString(9, d.getFeature());
			pr.setString(10, d.getPhoto());
			pr.setString(11, d.getPass());
			pr.setString(12, d.getReplenish());
			pr.setString(13, d.getState());
			pr.setString(14, d.getHeadline());
			pr.setString(15, d.getTimes());
			pr.setString(16, d.getAudit());
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
	 * ɾ�����ϣ���̨��
	 * */
	public void deleteDetails(String id){
		Connection conn = DBConn.openDB();
		String sql="delete from record where id="+id;
		try {
			Statement st = conn.createStatement();
			st.execute(sql);
			st.close();
			conn.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ɾ�����ϣ��������ģ�
	 * */
	public void deletePersonal(String id){
		Connection conn = DBConn.openDB();
		String sql="delete from record where id="+id;
		try {
			Statement st = conn.createStatement();
			st.execute(sql);
			st.close();
			conn.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �û��������ϣ���̨ͨ����ˣ�
	 * */
	public boolean updatePass(Details d){
		boolean update=false;
		Connection con = DBConn.openDB();
		String sql = "update record set audit='通过' where id=?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1, d.getId());
			pr.execute();
			update = true;
			con.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	/**
	 * �û�����״̬����̨������ˣ�
	 * */
	public boolean updateRecall(Details d){
		boolean update=false;
		Connection con = DBConn.openDB();
		String sql = "update record set audit='不通过' where id=?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1,d.getId());
			pr.execute();
			update = true;
			con.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	/**
	 * �û�ȷ���һأ���ͨ��������ˣ��ȴ�ȷ���һ���ˣ�
	 * */
	public boolean updateNotarizeRecall(Details d){
		boolean update=false;
		Connection con = DBConn.openDB();
		String sql = "update record set state='不通过' where audit='通过' and id=? ";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1,d.getId());
			pr.execute();
			update = true;
			con.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	/**
	 * �û�ȷ���һأ���̨ͨ����ˣ�
	 * */
	public boolean updaterecovered(Details d){
		boolean update=false;
		Connection con = DBConn.openDB();
		String sql = "update record set state='通过' where id=? ";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1,d.getId());
			pr.execute();
			update = true;
			con.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
}
