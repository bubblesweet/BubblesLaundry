package com.bubblesLaundry.bean;

public class MachineBean {
	private int machine_id;
	private int store_id;
	private String maintenance;

	/**
	 * @return the machine_id
	 */
	public int getMachine_id() {
		return machine_id;
	}

	/**
	 * @param machine_id the machine_id to set
	 */
	public void setMachine_id(int machine_id) {
		this.machine_id = machine_id;
	}

	/**
	 * @return the store_id
	 */
	public int getStore_id() {
		return store_id;
	}

	/**
	 * @param store_id the store_id to set
	 */
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	/**
	 * @return the maintenance
	 */
	public String getMaintenance() {
		return maintenance;
	}

	/**
	 * @param maintenance the maintenance to set
	 */
	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

}
