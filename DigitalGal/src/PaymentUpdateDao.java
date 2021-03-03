
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentUpdateDao {
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
	public String update(String email) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result="True";
		String sql= "update userdb.member set payment=1 where email=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1, 1);
			ps.setString(1, email);
			ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="False";
		}
		
		return result;
	}

}