package com.bubblesLaundry.servlet.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubblesLaundry.bean.MemberBean;
import com.bubblesLaundry.dao.MemberDAO;

/**
 * Servlet implementation class MemberHandler
 */
//@WebServlet("/MemberHandler")
public class MemberHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/user.jsp";
	private static String Edit = "/edit.jsp";
	private static String UserRecord = "/listUser.jsp";
	private MemberDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberHandler() {
		super();
		dao = new MemberDAO();
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
			dao.addUser(member);
			redirect = UserRecord;
			request.setAttribute("members", dao.getAllMembers());
			System.out.println("Record Added Successfully");
		}

		else if (action.equalsIgnoreCase("delete")) {
			String memberId = request.getParameter("memberId");
			int uid = Integer.parseInt(memberId);
			dao.removeMember(uid);
			redirect = UserRecord;
			request.setAttribute("members", dao.getAllMembers());
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
			dao.editMember(member);
			request.setAttribute("member", member);
			redirect = UserRecord;
			System.out.println("Record updated Successfully");
		}

		else if (action.equalsIgnoreCase("listMembers")) {
			redirect = UserRecord;
			request.setAttribute("members", dao.getAllMembers());
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
