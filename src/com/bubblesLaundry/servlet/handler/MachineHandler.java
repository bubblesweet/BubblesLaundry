package com.bubblesLaundry.servlet.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubblesLaundry.bean.MachineBean;
import com.bubblesLaundry.dao.MachineDAO;

/**
 * Servlet implementation class MachineHandler
 */
public class MachineHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/AddMachine.jsp";
	private static String Edit = "/EditMachine.jsp";
	private static String MachineRecord = "/ListAllMachines.jsp";
	private MachineDAO machine_dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MachineHandler() {
		super();
		machine_dao = new MachineDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirect = "";
		String uId = request.getParameter("machineId");
		String action = request.getParameter("action");

		if (!((uId) == null) && action.equalsIgnoreCase("insert")) {
			int id = Integer.parseInt(uId);
			MachineBean store = new MachineBean();
			store.setMachine_id(id);
			store.setStore_id(Integer.parseInt(request.getParameter("store_id")));
			store.setMaintenance(request.getParameter("maintenance"));

			machine_dao.addMachine(store);
			redirect = MachineRecord;
			request.setAttribute("machines", machine_dao.getAllMachines());
			System.out.println("Machine Record Added Successfully");
		}

		else if (action.equalsIgnoreCase("listMachines")) {
			redirect = MachineRecord;
			request.setAttribute("machines", machine_dao.getAllMachines());
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
