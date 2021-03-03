import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class AdminLoginDao {
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
	
	public String check(Admin admin) {
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result;
		String sql = "select email, password from userdb.admin where email = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getEmail());
			ResultSet rs = ps.executeQuery();
			String orPass = "";
            while (rs.next()) {
                orPass = rs.getString("password");
            } 
			if(orPass.equals(admin.getPassword())) {
				result = "True";
			}
			else {
				result = "False";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Unsuccessful";
		}
		
		return result;
	}
	
	/*public static void main(String [] args) {
		Admin ad = new Admin("anusriti.choudhuri@gmail.com","Tinka&1993");
		AdminLoginDao ldao = new AdminLoginDao();
		String result = ldao.check(ad);
		assert result == "True" : "Wrong Password";
		System.out.println(result);
	}*/

}
