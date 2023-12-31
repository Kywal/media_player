/**
 * @author Emanuel Kywal
 */

package br.ufrn.imd.model;

import java.util.ArrayList;

/**
 * 
 */
public class User {
	
	protected Integer userID;
	protected String username, email, password;
	protected Boolean isVip = false;
	protected ArrayList<Folder> folders;

	/**
	 * 
	 */
	public User() {
		folders = new ArrayList<Folder>();
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean getIsVip() {
		return isVip;
	}

	/**
	 * 
	 * @param isVip
	 */
	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getUserID() {
		return userID;
	}
	
	/**
	 * 
	 * @param userID
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
// ------------------ password methods --------------------- //
	
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 */
	public boolean updatePassword(String newPassword) {
		if(password == "" || password == null) {
			password = newPassword;
			return true;
		} else {
			return false;
		}
	}
	
//	--------------- folders methods ----------------- //

	/**
	 * 
	 * @return
	 */
	public ArrayList<Folder> getFolders() {
		return folders;
	}

	/**
	 * 
	 * @param folders
	 */
	public void setFolders(ArrayList<Folder> folders) {
		this.folders = folders;
	}
	
	/**
	 * 
	 * @param f
	 */
	public void addFolder(Folder f) {
		folders.add(f);
	}
	
	/**
	 * 
	 * @param f
	 */
	public void removeFolder(Folder f) {
		folders.remove(f);
	}
	
	
}
