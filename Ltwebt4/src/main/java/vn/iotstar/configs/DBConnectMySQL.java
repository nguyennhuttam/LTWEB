package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import vn.iotstar.models.UserModel;

public class DBConnectMySQL {

	
	   private static String USERNAME = "root";
	   private static String PASSWORD = "0961625129Tam";
	   private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	   private static String URL = "jdbc:mysql://localhost:3306/ltwebt4";

	   public static Connection getDatabaseConnection() throws SQLException, Exception{
	       
	       try {	
	    	   Class.forName(DRIVER);
			return  DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	    }
	
	 //test chuong trinh kich phai chuot chon run as ->java application
	   public static void main(String[] args ) {
		   try {
			   new DBConnectMySQL();
			   System.out.println(DBConnectMySQL.getDatabaseConnection());
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	   }

	public void insertrehister(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkExitstUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public void updatestatus1(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	public void updatestatus(UserModel user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
