
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
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
	public String insert(Member member)
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result = "True";
		String sql = "insert into userdb.member values(?,?,?,?,?)";
		try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, member.getFname());
		ps.setString(2, member.getLname());
		ps.setString(3, member.getEmail());
		ps.setString(4, member.getPassword());
		ps.setInt(5, 0);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="False";
		}
		return result;
	}
}
