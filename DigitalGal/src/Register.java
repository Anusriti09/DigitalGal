

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Member member = new Member(fname,lname,email,password);
		RegisterDao rDao = new RegisterDao();
		String result = rDao.insert(member);
		if(result == "True") {
			response.getWriter().print("<script>alert('Registered Successfully...Please Login')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=MemberLogin.jsp'>");
		}
		else {
			response.getWriter().print("<script>alert('Email already exist...Please Login')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=MemberLogin.jsp'>");
		}
	}

}
