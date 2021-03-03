

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
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
		String feedback = request.getParameter("feedback");
		IssuedFeedback fb = new IssuedFeedback(feedback,email);
		FeedbackDao fDao = new FeedbackDao();
		String result = fDao.insert(fb);
		if(result == "True") {
			response.getWriter().print("<script>alert('Feedback submitted successfully...')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=Dashboard.jsp'>");
		}
		else {
			response.getWriter().print("<script>alert('Feedback not submitted...Please try Again')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='1;URL=Feedback.jsp'>");
		}
	}

}
