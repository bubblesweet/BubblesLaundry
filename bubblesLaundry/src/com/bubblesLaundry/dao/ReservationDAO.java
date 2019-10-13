package com.bubblesLaundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bubblesLaundry.bean.ReservationBean;
import com.bubblesLaundry.bean.StoreBean;
import com.bubblesLaundry.dbconnection.ConnectionProvider;

public class ReservationDAO {
	private Connection conn;

	public ReservationDAO() {
		conn = ConnectionProvider.getConnection();
	}

	public void addStore(StoreBean storeBean) {
		try {
			String sql = "INSERT INTO stores(storeID, s_location, s_address,s_timings)" + " VALUES (?, ?, ?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, getNewReservationID());
			ps.setString(2, storeBean.getS_location());
			ps.setString(3, storeBean.getS_address());
			ps.setString(4, storeBean.getS_timings());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getNewReservationID() {
		int newStoreId = 0;
		try {
			String sql = "SELECT * FROM reservations WHERE reservationID = (SELECT MAX(reservationID) FROM reservations)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newStoreId = (rs.getInt("reservationID") + 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return newStoreId;
	}

	public int getMemberIDFromUsername(String UserName) {
		int Member_Id = 0;
		try {
			String sql = "SELECT * FROM members WHERE m_username = " + "'" + UserName + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Member_Id = rs.getInt("memberID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Member_Id;
	}

	public void addReservation(ReservationBean reservationBean) {
		try {
			String sql = "INSERT INTO reservations(reservationID, machineID, memberID,storeId, start_time,end_time,date)"
					+ " VALUES (?, ?, ?,?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, getNewReservationID());
			ps.setInt(2, reservationBean.getMemberID());
			ps.setInt(3, reservationBean.getMachineID());
			ps.setInt(4, reservationBean.getStoreID());
			ps.setString(5, reservationBean.getAppointmentStartTime());
			ps.setString(6, reservationBean.getAppointmentEndTime());
			ps.setString(7, reservationBean.getAppointmentDate());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ReservationBean getReservationByMemberID(int memberID) {
		ReservationBean reservationBean = new ReservationBean();
		try {
			String sql = "SELECT * FROM reservations WHERE memberID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, memberID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				reservationBean.setReservationID(rs.getInt("reservationID"));
				reservationBean.setMachineID(rs.getInt("machineID"));
				reservationBean.setMemberID(rs.getInt("memberID"));
				reservationBean.setStoreID(rs.getInt("storeId"));
				reservationBean.setAppointmentStartTime(rs.getString("start_time"));
				reservationBean.setAppointmentEndTime(rs.getString("end_time"));
				reservationBean.setAppointmentDate(rs.getString("date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservationBean;
	}
}
