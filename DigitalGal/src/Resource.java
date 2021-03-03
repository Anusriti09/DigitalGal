import java.net.URL; 
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resource
 */
@WebServlet("/Resource")
public class Resource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resource() {
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
		ArrayList<Book> books=new ArrayList<Book>();
		ResourceDao RDao = new ResourceDao();
		books = RDao.getBook(Bname);
		if(books == null) {
			response.getWriter().print("<script>alert('The entered book is not available')</script>");
			response.getWriter().print("<meta http-equiv='refresh' content='0.3;URL=ResourceAccesss.jsp'>");
		}
		else {
			response.setContentType("text/html");  
			response.getWriter().println("<html><body>");
			response.getWriter().println("<table border=1 width=50% height=50%>");
			response.getWriter().print("<tr><th>Book Name</th><th>Author Name</th><th>URL</th><th>Pages</th><th>Publication</th><tr>");
			for(int i=0;i<books.size();i++) {
				String bn = books.get(i).book_name;
				String an = books.get(i).author_name;
				int page = books.get(i).no_of_pages;
				String url = books.get(i).book_url;
				URL u = new URL(url);
				String pub = books.get(i).publication;
				response.getWriter().println("<tr><td>" + bn + "</td><td>" + an + "</td><td><a href =" + u + ">Link</a></td><td>" + page + "</td><td>" + pub + "</td></tr>");
				}
			response.getWriter().println("</table>");  
			response.getWriter().println("</html></body>");
		}
	}
}
