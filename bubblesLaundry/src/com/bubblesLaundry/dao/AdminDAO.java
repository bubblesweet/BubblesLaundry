package com.bubblesLaundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bubblesLaundry.bean.MemberBean;
import com.bubblesLaundry.dbconnection.ConnectionProvider;

public class AdminDAO {

	private Connection conn;

	public AdminDAO() {
		conn = ConnectionProvider.getConnection();
	}

	public void addUser(MemberBean memberBean) {
		try {
			String sql = "INSERT INTO members(memberID, m_username, m_password)" + " VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, getNewMemberID());
			ps.setString(2, memberBean.getM_username());
			ps.setString(3, memberBean.getM_password());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeMember(int memberId) {
		try {
			String sql = "DELETE FROM members WHERE memberID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberId);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editMember(MemberBean memberBean) {
		try {
			String sql = "UPDATE members SET m_username=?, m_password=?" + " WHERE memberId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberBean.getM_username());
			ps.setString(2, memberBean.getM_password());
			ps.setInt(3, memberBean.getM_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List getAllMembers() {
		List members = new ArrayList();
		try {
			String sql = "SELECT * FROM members";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemberBean memberBean = new MemberBean();
				memberBean.setM_id(rs.getInt("memberId"));
				memberBean.setM_username(rs.getString("m_username"));
				memberBean.setM_password(rs.getString("m_password"));
				members.add(memberBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}

	public MemberBean getMemberByID(String memberId) {
		MemberBean memberBean = new MemberBean();
		try {
			String sql = "SELECT * FROM members WHERE memberId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				memberBean.setM_id(rs.getInt("memberId"));
				memberBean.setM_username(rs.getString("m_username"));
				memberBean.setM_password(rs.getString("m_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberBean;
	}

	public String getNewMemberID() {
		String newMemberId = "";
		try {
			String sql = "SELECT * FROM members WHERE memberID = (SELECT MAX(memberID) FROM members)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newMemberId = String.valueOf(rs.getInt("memberID") + 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return newMemberId;
	}

}
