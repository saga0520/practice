package model;

public class Account {

	private String id;
	private String password;

	public Account(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getid() {
		return id;
	}
	public String getpassword() {
		return password;
	}
}
