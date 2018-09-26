package com.tav.store;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class MysqlConnect {
	Connection conn = null;

	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/flightmanagement?autoReconnect=true&useSSL=false", "root", "asd123");
			return conn;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}