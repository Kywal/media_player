/**
 * 
 * @author Kywal
 *
 */

package model;

import java.util.ArrayList;
public class User {
	
	protected Integer userID;
	protected String username, email, password;
	protected ArrayList<Folder> folders;

	
	
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Folder> getFolders() {
		return folders;
	}


	public void setFolders(ArrayList<Folder> folders) {
		this.folders = folders;
	}

	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}


//	/**
//	 * 
//	 */
//	public void updatePassword(String newPassword) {
//		
//	}
	
	
}
