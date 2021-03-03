import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class ViewMemberDao {
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
	
	public ArrayList<Member> getMember()
	{
		loadDriver(dbdriver);
		Connection con = getConnection();
	    ArrayList<Member> members = new ArrayList<Member>();
	    try {
	    	String sql = "select uname, fname, email, password from userdb.member";
	    	PreparedStatement ps1 = con.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery();
	        while(rs.next())
	        {
	            Member member = new Member(rs.getString("uname"),rs.getString("fname"),rs.getString("email"),rs.getString("password"));
	            members.add(member);

	        }
	    }catch (SQLException e) {

	        e.printStackTrace();
	    }
	    return members;
	}
	
	/*public static void main(String [] args) {
		ViewMemberDao Mdao = new ViewMemberDao();
		ArrayList<Member> result = new ArrayList<Member>();
		result=Mdao.getMember();
		assert result != null : "Member not shown";
	}*/

}