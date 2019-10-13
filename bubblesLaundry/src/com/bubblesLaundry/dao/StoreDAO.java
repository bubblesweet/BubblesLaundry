package com.bubblesLaundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bubblesLaundry.bean.StoreBean;
import com.bubblesLaundry.dbconnection.ConnectionProvider;

public class StoreDAO {
	private Connection conn;

	public StoreDAO() {
		conn = ConnectionProvider.getConnection();
	}

	public void addStore(StoreBean storeBean) {
		try {
			String sql = "INSERT INTO stores(storeID, s_location, s_address,s_timings)" + " VALUES (?, ?, ?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, getNewStoreID());
			ps.setString(2, storeBean.getS_location());
			ps.setString(3, storeBean.getS_address());
			ps.setString(4, storeBean.getS_timings());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editStore(StoreBean storeBean) {
		try {
			String sql = "UPDATE stores SET s_location=?, s_address=?,s_timings=? " + " WHERE storeID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, storeBean.getS_location());
			ps.setString(2, storeBean.getS_address());
			ps.setString(3, storeBean.getS_timings());
			ps.setInt(4, storeBean.getS_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public StoreBean getStoreByID(String storeID) {
		StoreBean storeBean = new StoreBean();
		try {
			String sql = "SELECT * FROM stores WHERE storeID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, storeID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				storeBean.setS_id(rs.getInt("storeID"));
				storeBean.setS_location(rs.getString("s_location"));
				storeBean.setS_address(rs.getString("s_address"));
				storeBean.setS_timings(rs.getString("s_timings"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storeBean;
	}

	public String getStoreIdFromMachineId(int machineID) {
		String store_ID = "";
		try {
			String sql = "SELECT s.storeID FROM stores s INNER JOIN machines m ON m.storeID=s.storeID where m.machineID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, machineID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				store_ID = String.valueOf(rs.getInt("storeID"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return store_ID;
	}

	public String getNewStoreID() {
		String newStoreId = "";
		try {
			String sql = "SELECT * FROM stores WHERE storeID = (SELECT MAX(storeID) FROM stores)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newStoreId = String.valueOf(rs.getInt("storeID") + 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return newStoreId;
	}

	public List getAllStores() {
		List stores = new ArrayList();
		try {
			String sql = "SELECT * FROM stores";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StoreBean storeBean = new StoreBean();
				storeBean.setS_id(rs.getInt("storeID"));
				storeBean.setS_location(rs.getString("s_location"));
				storeBean.setS_address(rs.getString("s_address"));
				storeBean.setS_timings(rs.getString("s_timings"));
				stores.add(storeBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stores;
	}
}
