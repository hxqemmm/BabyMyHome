package com.ht.DBC;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnFactory {	
	private static Connection con;
	private static DataSource ds;
	static{
		try {
			Context ex = new InitialContext();
			 Context env = (Context)ex.lookup("java:/comp/env");
			 ds = (DataSource)env.lookup("mylink");
			con = ds.getConnection();  
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			if(con.isClosed()){
				con = ds.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
