
public class Admin {
	private String email, password;
	
	public Admin() {
		super();
	}
	
	public Admin(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

}
