package model;

public class Account {

	private String email;
	private String user;
	private String password;
	private String platform;
	private String image;
	
	public Account (String email, String password, String platform, String image, String user) {
		this.email = email;
		this.password = password;
		this.platform = platform;
		this.image = image;
		this.user = user;
	}
	
	public Account (String user, String password, String platform) {
		this.user = user;
		this.password = password;
		this.platform = platform;
		
		image = "###";
		user = "[no one]";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
