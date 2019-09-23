package com.bubblesLaundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bubblesLaundry.dbconnection.ConnectionProvider;

public class LoginDAO {

	private Connection conn;

	public LoginDAO() {
		conn = ConnectionProvider.getConnection();
	}

	public boolean checkMember(String username, String pass) {
		if ((username != null) && (pass != null)) {
			boolean st = false;
			try {
				String sql = "select * from members where m_username=? and m_password=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				st = rs.next();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return st;
		}
		return false;
	}

	public boolean checkAdmin(String username, String pass) {
		if ((username != null) && (pass != null)) {
			boolean st = false;
			try {
				String sql = "select * from admin where a_username=? and a_password=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				st = rs.next();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return st;
		}
		return false;
	}

}
