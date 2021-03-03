import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class ResourceDao {
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
	
	public ArrayList<Book> getBook(String bname)
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
	    ArrayList<Book> books = new ArrayList<Book>();
	    try {
	    	String sql = "select book_name,author,book,page,publication from userdb.books where book_name like ?";
	    	PreparedStatement ps1 = con.prepareStatement(sql);
	    	ps1.setString(1, "%" + bname + "%");
			ResultSet rs = ps1.executeQuery();
	        while(rs.next())
	        {
	            Book book = new Book(rs.getString("book_name"),rs.getString("author"),rs.getString("book"),rs.getInt("page"),rs.getString("publication"));
	            books.add(book);

	        }
	        if(books.size()==0) {
	        	return null;
	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return books;
	}

}
