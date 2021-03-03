import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class FeedbackDao {
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
	public String insert(IssuedFeedback fb)
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
		int id;
		String id1="";
		String result = "True";
		String sql2 = "insert into userdb.feedback values(?,?,?)";
		try {
			String sql1 = "SELECT serial FROM userdb.feedback WHERE serial=(SELECT MAX(serial) FROM userdb.feedback)";
	
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ResultSet rs = ps1.executeQuery();
				while (rs.next()) {
					id1 = rs.getString("serial");
				}
		id = Integer.parseInt(id1);
		id = id + 1;
		PreparedStatement ps = con.prepareStatement(sql2);
		ps.setString(1, fb.getEmail());
		ps.setString(2, fb.getFeedback());
		ps.setInt(3, id);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="False";
		}
		return result;
	}

}
