

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("role");
		
		if(userType.equals("customer") && username.equals("Test") && password.equals("1234")) {
			response.sendRedirect("Customer.jsp");
		}else if(userType.equals("retailer") && username.equals("Test") && password.equals("1234")) {
			response.sendRedirect("Retailer.jsp");
		}else if(userType.equals("supplier") && username.equals("Test") && password.equals("1234")) {
			response.sendRedirect("Supplier.jsp");
		}else if(userType.equals("wholesaler") && username.equals("Test") && password.equals("1234")) {
			response.sendRedirect("Wholesaler.jsp");
		}else {
			response.sendRedirect("Error.jsp");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
