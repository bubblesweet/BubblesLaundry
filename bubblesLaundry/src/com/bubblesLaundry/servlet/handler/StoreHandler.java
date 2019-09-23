package com.bubblesLaundry.servlet.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubblesLaundry.bean.StoreBean;
import com.bubblesLaundry.dao.StoreDAO;

/**
 * Servlet implementation class StoreHandler
 */
@WebServlet("/StoreHandler")
public class StoreHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/AddStore.jsp";
	private static String Edit = "/EditStore.jsp";
	private static String StoreRecord = "/ListAllStores.jsp";
	private StoreDAO store_dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreHandler() {
		super();
		store_dao = new StoreDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirect = "";
		String uId = request.getParameter("storeId");
		String action = request.getParameter("action");

		if (!((uId) == null) && action.equalsIgnoreCase("insert")) {
			int id = Integer.parseInt(uId);
			StoreBean store = new StoreBean();
			store.setS_id(id);
			store.setS_location(request.getParameter("s_location"));
			store.setS_address(request.getParameter("s_address"));
			String timing = request.getParameter("start_time");
			timing = timing + " to " + request.getParameter("end_time");
			store.setS_timings(timing);
			store_dao.addStore(store);
			redirect = StoreRecord;
			request.setAttribute("stores", store_dao.getAllStores());
			System.out.println("Store Record Added Successfully");
		}

		else if (action.equalsIgnoreCase("editform")) {
			redirect = Edit;
		}

		else if (action.equalsIgnoreCase("edit")) {
			String storeId = request.getParameter("storeId");
			int uid = Integer.parseInt(storeId);
			StoreBean store = new StoreBean();
			store.setS_id(uid);
			store.setS_location(request.getParameter("s_location"));
			store.setS_address(request.getParameter("s_address"));
			String timing = request.getParameter("start_time");
			timing = timing + " to " + request.getParameter("end_time");
			store.setS_timings(timing);
			store_dao.editStore(store);
			request.setAttribute("store", store);
			redirect = StoreRecord;
			System.out.println("Record updated Successfully");
		}

		else if (action.equalsIgnoreCase("listStores")) {
			redirect = StoreRecord;
			request.setAttribute("stores", store_dao.getAllStores());
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
