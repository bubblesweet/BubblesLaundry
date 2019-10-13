package com.bubblesLaundry.servlet.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubblesLaundry.dao.ReservationDAO;

public class ReservationHandler {

	private static final long serialVersionUID = 1L;
	private static String INSERT = "/AddStore.jsp";
	private static String Edit = "/EditStore.jsp";
	private static String AddReservation = "/AddReservation.jsp";
	private static String StoreRecord = "/ListAllStores.jsp";
	private static String StoreLanding = "/Store.jsp";
	private static String ConfirmReservation = "/ConfirmReservation.jsp";
	private ReservationDAO reservation_dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationHandler() {
		super();
		reservation_dao = new ReservationDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirect = "";
		String username = request.getParameter("username");
		String machineId = request.getParameter("machineId");
		String storeId = request.getParameter("storeId");
		int mId = Integer.parseInt(machineId);
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String date = request.getParameter("date");

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("addReservation")) {
			redirect = AddReservation;
		}

		else if (action.equalsIgnoreCase("bookReservation")) {

//			ReservationBean reservation = new ReservationBean();
//			reservation.setMachineID(mId);
//			reservation.setMemberID(reservation_dao.getMemberIDFromUsername(username));
//			reservation.setStoreID(Integer.parseInt(storeId));
//			reservation.setAppointmentStartTime(start_time);
//			reservation.setAppointmentEndTime(end_time);
//			reservation.setAppointmentDate(date);
//
//			reservation_dao.addReservation(reservation);
//
//			request.setAttribute("reservation", reservation);
			// redirect = ConfirmReservation;
			redirect = StoreRecord;
			System.out.println("Record updated Successfully");
		}

		else {
			redirect = INSERT;
		}

		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
