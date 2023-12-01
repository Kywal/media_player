package br.ufrn.imd.dao;

import java.util.Vector;

import br.ufrn.imd.model.User;

public class UserDataBase {

	private static UserDataBase instance;
	protected Vector<User> users;


// -------------- Singleton implementation -------------- //
	
	/**
	 * 
	 */
	private UserDataBase() {
		users = new Vector<User>();
		users = getUsersFromDB();
	}
	
	/**
	 * 
	 * @return
	 */
	public static UserDataBase getInstance() {
		if(instance == null) {
			instance = new UserDataBase();
		}
		
		return instance;
	}
	
// ------------------ Start/End DB methods ------------------------ //
	
	/**
	 * 
	 * @return
	 */
	private Vector<User> getUsersFromDB() {
		// Read users from users.txt
		return users;
	}
	
//	---------------- Utilitary User methods ----------------------- //
	
	/**
	 * 
	 * @param user
	 */
	public void signUpUser(User user) {
		
	}
	
// ----------------- I/O from DB methods -------------------------- //
	
	/**
	 * 
	 * @param user
	 */
	public void writeUser(User user) {
		
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public Vector<String> readUser(String filePath) {
		Vector<String> file = new Vector<String>();
		
		return file;
	}
	
}
