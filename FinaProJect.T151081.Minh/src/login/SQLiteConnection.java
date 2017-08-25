package login;

import java.sql.*;
import javax.swing.*;
import java.sql.DriverManager;
public class SQLiteConnection {
//	private SQLiteConnection connect() {
//		String url = "jdbc:sqlite:foc2warehouse.db";
//		SQLiteConnection conn = null;
//		try {
//			conn = (SQLiteConnection) DriverManager.getConnection(url);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return conn;
//	}
	
	Connection conn=null;
	public static Connection dbConnection() {
		
		try {
			//Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:foc2warehouse.db";
			Connection conn = DriverManager.getConnection("jdbc:sqlite:foc2warehouse.db");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}
	
	
	
	

