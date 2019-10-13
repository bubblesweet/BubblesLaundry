package com.bubblesLaundry.bean;

public class ReservationBean {

	private int reservationID;
	private int machineID;
	private int memberID;
	private int storeID;
	private String appointmentDate;
	private String appointmentStartTime;
	private String appointmentEndTime;

	/**
	 * @return the reservationID
	 */
	public int getReservationID() {
		return reservationID;
	}

	/**
	 * @param reservationID the reservationID to set
	 */
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	/**
	 * @return the machineID
	 */
	public int getMachineID() {
		return machineID;
	}

	/**
	 * @param machineID the machineID to set
	 */
	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}

	/**
	 * @return the storeID
	 */
	public int getStoreID() {
		return storeID;
	}

	/**
	 * @param storeID the storeID to set
	 */
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * @return the appointmentStartTime
	 */
	public String getAppointmentStartTime() {
		return appointmentStartTime;
	}

	/**
	 * @param appointmentStartTime the appointmentStartTime to set
	 */
	public void setAppointmentStartTime(String appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}

	/**
	 * @return the appointmentEndTime
	 */
	public String getAppointmentEndTime() {
		return appointmentEndTime;
	}

	/**
	 * @param appointmentEndTime the appointmentEndTime to set
	 */
	public void setAppointmentEndTime(String appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}

	/**
	 * @return the memberID
	 */
	public int getMemberID() {
		return memberID;
	}

	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
}
