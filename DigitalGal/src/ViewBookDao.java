import java.sql.*;
import java.util.*;

public class ViewBookDao {
	private String dburl = "jdbc:mysql://localhost:3306/";
	private String dbname = "userdb";
	private String dbuname = "root";
	private String dbpassword = "Tinka&1965";
	private String dbdriver = "com.mysql.jdbc.Driver";
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection()
	{
		Connection con;
		try {
			con = DriverManager.getConnection(dburl+dbname, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
		return con;
	}
	
	public ArrayList<Book> getBook()
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
	    ArrayList<Book> books = new ArrayList<Book>();
	    try {
	    	String sql = "select book_name, author, page, publication from userdb.books";
	    	PreparedStatement ps1 = con.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery();
	        while(rs.next())
	        {
	            Book book = new Book(rs.getString("book_name"),rs.getString("author"),rs.getInt("page"),rs.getString("publication"));
	            books.add(book);

	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return books;
	}
	
	/*public static void main(String [] args) {
		ViewBookDao vbdao = new ViewBookDao();
		ArrayList<Book> result = new ArrayList<Book>();
		result = vbdao.getBook();
		assert result != null : "Not Viewed";
	}*/

}
