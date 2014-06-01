package swa.ass4.server.cxf;

public class User {
	String userName;
	String password;
	String role;

	public User() {

	}

	public User(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String toString() {
		return "User: " + userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public boolean verifyPassword(String password) {
		return this.password.equals(password);
	}
}
