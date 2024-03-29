package com.bubblesLaundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bubblesLaundry.bean.MachineBean;
import com.bubblesLaundry.dbconnection.ConnectionProvider;

public class MachineDAO {
	private Connection conn;

	public MachineDAO() {
		conn = ConnectionProvider.getConnection();
	}

	public void addMachine(MachineBean machineBean) {
		try {
			String sql = "INSERT INTO machines(machineID, storeID, maintenance)" + " VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, getNewMachineID());
			ps.setInt(2, machineBean.getStore_id());
			ps.setString(3, machineBean.getMaintenance());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getNewMachineID() {
		int newMachineId = 0;
		try {
			String sql = "SELECT * FROM machines WHERE machineID = (SELECT MAX(machineID) FROM machines)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newMachineId = (rs.getInt("machineID") + 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return newMachineId;
	}

	public List<MachineBean> getAllMachines() {
		List<MachineBean> machines = new ArrayList<MachineBean>();

		try {
			String sql = "SELECT m.machineID, m.storeID, m.maintenance, s.s_location FROM machines m INNER JOIN stores s ON m.storeID=s.storeID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MachineBean machineBean = new MachineBean();
				machineBean.setMachine_id(rs.getInt("machineID"));
				machineBean.setStore_id(rs.getInt("storeID"));
				machineBean.setMaintenance(rs.getString("maintenance"));
				machineBean.setStore_location(rs.getString("s_location"));
				machines.add(machineBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return machines;
	}

	public List<MachineBean> getMachinesByStoreID(int Store_ID) {
		List<MachineBean> machines = new ArrayList<MachineBean>();

		try {
			String sql = "SELECT m.machineID, m.storeID, m.maintenance, s.s_location FROM machines m INNER JOIN stores s ON m.storeID=s.storeID where m.storeID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Store_ID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MachineBean machineBean = new MachineBean();
				machineBean.setMachine_id(rs.getInt("machineID"));
				machineBean.setStore_id(rs.getInt("storeID"));
				machineBean.setMaintenance(rs.getString("maintenance"));
				machineBean.setStore_location(rs.getString("s_location"));
				machines.add(machineBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return machines;
	}

}
