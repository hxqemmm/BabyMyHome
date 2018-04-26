package com.ht.DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {		//������֮  ���ݿ�����
	
	private static String drive = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1/BabyMyHome";
	private static String user = "root";
	private static String password = "root";
	private static Connection con=null;
	
	static{			//��̬�����
		try {
			Class.forName(drive);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection openDB(){		//�������ݿ�
		try {
			if(con.isClosed()){
			con = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Connection con=DBConn.openDB();
	}
		
}
