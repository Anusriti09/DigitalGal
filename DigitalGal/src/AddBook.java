

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
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
		String Bname = request.getParameter("Bname");
		String Aname = request.getParameter("Aname");
		String url = request.getParameter("url");
		int pages = Integer.parseInt(request.getParameter("pages"));
		String publication = request.getParameter("publication");
		Book b=new Book(Bname,Aname,url,pages,publication);
		BookDao BDao = new BookDao();
		String result = BDao.insert(b);
		if(result == "True") {
				response.getWriter().print("<script>alert('Book added successfully.')</script>");
				response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=AdminDashboard.jsp'>");
		}
		else {
				response.getWriter().print("<script>alert('Book cannot be added.')</script>");
				response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=AddBook.jsp'>");
		}
		
	}

}
