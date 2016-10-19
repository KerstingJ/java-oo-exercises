package Studio7;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
	private String username;
	private String passHash;
	private static ArrayList<User> allUsers = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}

	public static void setAllUsers(ArrayList<User> allUsers) {
		User.allUsers = allUsers;
	}
	
	public User(String username, String password) {
		
		if (User.isValidUsername(username)) {
			this.username = username;
		} else {
			//get mad
		}
		
		this.passHash = User.hashPassword(password);
	}
	
	private static String hashPassword(String password) {
		//TODO hash the password
		//TODO return the hashed password
		return password;
	}
	
	private static boolean isValidPassword(String password, User user) {
		if (User.hashPassword(password) == user.getPassHash()) {
			return true;
		}
		return false;
	}
	
	private static boolean isValidUsername(String username) {
		return Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
	}
}
