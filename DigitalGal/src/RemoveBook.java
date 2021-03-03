

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveBook
 */
@WebServlet("/RemoveBook")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBook() {
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
		Book b=new Book(Bname,Aname);
		BookDao BDao = new BookDao();
		String result = BDao.delete(b);
		if(result == "True") {
			response.getWriter().print("<script>alert('Book deleted successfully.')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='1;URL=RemoveBook.jsp'>");
			}
		else {
			response.getWriter().print("<script>alert('Book cannot be deleted.')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='1;URL=RemoveBook.jsp'>");
			}
		}
	}


