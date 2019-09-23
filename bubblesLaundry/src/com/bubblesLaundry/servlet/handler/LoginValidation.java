package com.bubblesLaundry.servlet.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubblesLaundry.dao.AdminDAO;
import com.bubblesLaundry.dao.LoginDAO;
import com.bubblesLaundry.dao.StoreDAO;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String Member = "/Member.jsp";
	private static String Admin = "/Admin.jsp";
	private static String Error = "/Error.jsp";
	private LoginDAO dao;
	private AdminDAO admin_dao;
	private StoreDAO store_dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginValidation() {
		super();
		dao = new LoginDAO();
		admin_dao = new AdminDAO();
		store_dao = new StoreDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String redirect = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("role");

		if (userType.equalsIgnoreCase("admin")) {

			if (dao.checkAdmin(username, password)) {
				redirect = Admin;
				request.setAttribute("members", admin_dao.getAllMembers());
				request.setAttribute("stores", store_dao.getAllStores());
			} else {
				redirect = Error;
			}
		} else if (userType.equalsIgnoreCase("member")) {

			if (dao.checkMember(username, password)) {
				redirect = Member;

			} else {
				redirect = Error;
			}

		} else {
			redirect = Error;
		}

		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
