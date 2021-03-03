

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class AdminDashboard
 */
@WebServlet("/AdminDashboard")
public class AdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboard() {
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
		String button = request.getParameter("button");
		if(button.equals("Add Book")) {
				response.sendRedirect("AddBook.jsp");
			}
		else if(button.equals("Remove Book")) {
			response.sendRedirect("RemoveBook.jsp");
		}
		else if(button.equals("View Members")) {
			ViewMemberDao vbd = new ViewMemberDao();
			ArrayList<Member> member = vbd.getMember();
			response.setContentType("text/html");  
	        response.getWriter().println("<html><body>");
			response.getWriter().println("<table border=1 width=50% height=50%>");
			response.getWriter().print("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Password</th><tr>");
			for(int i=0;i<member.size();i++) {
				String fn = member.get(i).fname;
				String ln = member.get(i).lname;
				String em = member.get(i).email;
				String pass = member.get(i).password;
				response.getWriter().println("<tr><td>" + fn + "</td><td>" + ln + "</td><td>" + em + "</td><td>" + pass + "</td></tr>");
			}
			response.getWriter().println("</table>");  
            response.getWriter().println("</html></body>");
		}
		else if(button.equals("View Books")) {
			
			ViewBookDao vbd = new ViewBookDao();
			ArrayList<Book> book = vbd.getBook();
			response.setContentType("text/html");  
	        response.getWriter().println("<html><body>");
			response.getWriter().println("<table border=1 width=50% height=50%>");
			response.getWriter().print("<tr><th>Book Name</th><th>Author Name</th><th>Pages</th><th>Publication</th><tr>");
			for(int i=0;i<book.size();i++) {
				String bn = book.get(i).book_name;
				String an = book.get(i).author_name;
				int page = book.get(i).no_of_pages;
				String pub = book.get(i).publication;
				response.getWriter().println("<tr><td>" + bn + "</td><td>" + an + "</td><td>" + page + "</td><td>" + pub + "</td></tr>");
			}
			response.getWriter().println("</table>");  
            response.getWriter().println("</html></body>");
		}
		else if(button.equals("View Financial Aid")) {
			
			ViewFinancialDao vfd = new ViewFinancialDao();
			ArrayList<FA> fa = vfd.getFA();
			response.setContentType("text/html");  
	        response.getWriter().println("<html><body>");
			response.getWriter().println("<table border=1 width=50% height=50%>");
			response.getWriter().print("<tr><th>Book Name</th><th>Author Name</th><tr>");
			for(int i=0;i<fa.size();i++) {
				String em = fa.get(i).email;
				String f = fa.get(i).fa;
				response.getWriter().println("<tr><td>" + em + "</td><td>" + f + "</td></tr>");
			}
			response.getWriter().println("</table>");  
            response.getWriter().println("</html></body>");
		}
		else if(button.equals("Change Payment Status")) {
			response.sendRedirect("PaymentUpdate.jsp");
		}
	}

}
