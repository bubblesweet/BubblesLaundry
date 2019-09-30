package com.bubblesLaundry.servlet.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubblesLaundry.bean.MemberBean;
import com.bubblesLaundry.dao.AdminDAO;
import com.bubblesLaundry.dao.StoreDAO;

/**
 * Servlet implementation class MemberHandler
 */
@WebServlet("/MemberHandler")
public class MemberHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/AddMember.jsp";
	private static String Edit = "/EditMember.jsp";
	private static String UserRecord = "/ListAllMembers.jsp";
	private static String StoreRecord = "/StoreSelection.jsp";
	private static String Reservations = "/ListReservations.jsp";
	private AdminDAO admin_dao;
	private StoreDAO store_dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberHandler() {
		super();
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
		String uId = request.getParameter("memberId");
		String action = request.getParameter("action");

		if (!((uId) == null) && action.equalsIgnoreCase("insert")) {
			int id = Integer.parseInt(uId);
			MemberBean member = new MemberBean();
			member.setM_id(id);
			member.setM_username(request.getParameter("m_username"));
			member.setM_password(request.getParameter("m_password"));
			admin_dao.addUser(member);
			redirect = UserRecord;
			request.setAttribute("members", admin_dao.getAllMembers());
			System.out.println("Record Added Successfully");
		}

		else if (action.equalsIgnoreCase("delete")) {
			String memberId = request.getParameter("memberId");
			int uid = Integer.parseInt(memberId);
			admin_dao.removeMember(uid);
			redirect = UserRecord;
			request.setAttribute("members", admin_dao.getAllMembers());
			System.out.println("Record Deleted Successfully");
		}

		else if (action.equalsIgnoreCase("editform")) {
			redirect = Edit;
		}

		else if (action.equalsIgnoreCase("edit")) {
			String memberId = request.getParameter("memberId");
			int uid = Integer.parseInt(memberId);
			MemberBean member = new MemberBean();
			member.setM_id(uid);
			member.setM_username(request.getParameter("m_username"));
			member.setM_password(request.getParameter("m_password"));
			admin_dao.editMember(member);
			request.setAttribute("member", member);
			redirect = UserRecord;
			System.out.println("Record updated Successfully");
		}

		else if (action.equalsIgnoreCase("listMembers")) {
			redirect = UserRecord;
			request.setAttribute("members", admin_dao.getAllMembers());
		}

		else if (action.equalsIgnoreCase("listStores")) {
			redirect = StoreRecord;
			request.setAttribute("stores", store_dao.getAllStores());
		}

		else if (action.equalsIgnoreCase("listReservation")) {
			redirect = Reservations;
			// request.setAttribute("stores", store_dao.getAllStores());
		} else {
			redirect = INSERT;
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
