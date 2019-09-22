package com.bubblesLaundry.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection con = null;

	public static Connection getConnection() {
		if (con != null) {
			return con;
		} else {
			try {

				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/BubbleLaundry?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
				String user = "root";
				String password = "password";
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException cnfe) {
				System.out.println(cnfe);
			} catch (SQLException sqe) {
				System.out.println(sqe);
			}
			return con;
		}

	}

}