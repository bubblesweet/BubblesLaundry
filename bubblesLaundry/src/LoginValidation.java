

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private static String username;
	private static String password;
	private static String userType;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username = request.getParameter("username");
		password = request.getParameter("password");
		userType = request.getParameter("role");
		
		if(checkUser(username, password, userType)) {
			response.sendRedirect(userType+".jsp");
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
	public static boolean checkUser(String username,String pass, String role) 
    {
		if(username != null && pass != null && role != null) {
        boolean st =false;
        try {

            //loading drivers for mysql
         //  Class.forName("com.mysql.jdbc.Driver");
           Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BubbleLaundry?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","8281");
            PreparedStatement ps = con.prepareStatement("select * from Users where userName=? and password=? and role=?");
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, role);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;     }
		return false;            
    }   

}
