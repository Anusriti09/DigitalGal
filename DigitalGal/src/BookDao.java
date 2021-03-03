
import java.sql.*;

public class BookDao {
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
	
	public String insert(Book book) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		int id;
		String id1="";
		String result="True";
		String sql2= "insert into userdb.books values(?,?,?,?,?,?) ";
		try {
			String sql1 = "SELECT Serial FROM userdb.books WHERE Serial=(SELECT MAX(Serial) FROM userdb.books)";
			
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				id1 = rs.getString("Serial");
			}
			id = Integer.parseInt(id1);
			id = id + 1;
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, book.get_bookName());
			ps.setString(2, book.get_authorName());
			ps.setString(3, book.get_urlName());
			ps.setInt(4, book.get_pages());
			ps.setString(5, book.get_publication());
			ps.setInt(6, id);
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="False";
		}
		
		return result;
	}
	public String delete(Book book) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result="True";
		String sql= "delete from userdb.books where book_name = ? and author = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.get_bookName());
			ps.setString(2, book.get_authorName());
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="False";
		}
		
		return result;
	}

}
