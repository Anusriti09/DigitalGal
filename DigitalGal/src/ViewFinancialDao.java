import java.sql.*;
import java.util.*;

public class ViewFinancialDao {
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
	
	public ArrayList<FA> getFA()
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
	    ArrayList<FA> fas = new ArrayList<FA>();
	    try {
	    	String sql = "select * from userdb.financialaid";
	    	PreparedStatement ps1 = con.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery();
	        while(rs.next())
	        {
	            FA fa = new FA(rs.getString("email"),rs.getString("reason"));
	            fas.add(fa);

	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return fas;
	}

}