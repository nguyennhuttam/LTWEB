package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DBConnectSQL {
	private final String serverName ="localhost";
	private final String dbName ="LTwebt4";
	private final String portNumber ="1433";
	private final String instance ="";
	//private final String uesrID ="sa";
	//private final String password ="0961625129Tam";

	public Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:sqlserver://"+serverName+":"+portNumber +"\\"+ instance +";integratedSecurity=true;databaseName="+dbName;
			
			if(instance == null || instance.trim().isEmpty() )
				
				url = "jdbc:sqlserver://"+serverName+":"+portNumber +";integratedSecurity=true ; databasName="+dbName;
			
			conn = DriverManager.getConnection(url);
			
			if (conn != null) {
				DatabaseMetaData dm	= (DatabaseMetaData) conn.getMetaData();
				System.out.println("Drive name: "+ dm.getDriverName()) ;
				System.out.println("Drive version: "+ dm.getDriverVersion()) ;
				System.out.println("Product name: "+ dm.getDatabaseProductName()) ;
				System.out.println("Product version: "+ dm.getDatabaseProductVersion()) ;

				return conn;

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	//test chuong trinh. kich chuot phai chon run as->java application
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		}catch(Exception e) {
			e.printStackTrace();
			
		
		}
	}
	
	
}
