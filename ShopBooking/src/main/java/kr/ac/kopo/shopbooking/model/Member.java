package kr.ac.kopo.shopbooking.model;

public class Member {
	public static final int ADMIN = 99;
	public static final int SHOP = 2;
	public static final int USER = 1;
	
	private String id;
	private String passwd;
	private String title;
	private int role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
