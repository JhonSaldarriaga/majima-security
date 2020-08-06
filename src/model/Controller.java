package model;

import java.util.ArrayList;

public class Controller {

	private String password;
	private ArrayList<Account> accounts;
	
	public Controller () {
		password = null;
		accounts = new ArrayList<Account>();
	}
	
	public boolean verifyPassword(String x) {
		if(x.equals(password))
			return true;
		else
			return false;
	}
	
	public void addNewAccount(String email, String password, String platform, String image, String user) {
		accounts.add(new Account(email, password, platform, image, user));
	}
	
	public void deleteAccount(String email, String platform) {
		int x = searchPositionAccount(email, platform);
		if(x!=-1) {
			accounts.remove(x);
		}
	}
	
	public int searchPositionAccount(String email, String platform) {
		for (int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getEmail().equals(email) && accounts.get(i).getPlatform().equals(platform)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isPasswordEmpty() {
		if(password==null)
			return true;
		else
			return false;
	}
}
