

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Admin admin  = new Admin(email,password);
		AdminLoginDao lDao = new AdminLoginDao();
		String result = lDao.check(admin);
		if(result == "True") {
			response.getWriter().print("<script>alert('Login Successfully..')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=AdminDashboard.jsp'>");
		}
		else if(result == "False") {
			response.getWriter().print("<script>alert('Wrong password..Try again')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=AdminLogin.jsp'>");
		}
		else {
			response.getWriter().print("<script>alert('Login Unsuccessful...Please try Again')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='1;URL=AdminLogin.jsp'>");
		}
	}

}
