package br.ufrn.imd.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import br.ufrn.imd.model.User;

public class UserDataBase {

	private static UserDataBase instance;
	String filePath = "database\\users.txt"; // TODO -> Remove when dinamic filePath is implemented
	protected Vector<User> users;

// -------------- Singleton implementation -------------- //
	
	/**
	 * 
	 */
	private UserDataBase() {
		users = new Vector<User>();
		getUsersFromDB();
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
	private void getUsersFromDB() {
		
	}
	
//	---------------- Utilitary User methods ----------------------- //
	
	/**
	 * 
	 * @param user
	 * @throws IOException 
	 */
	public void signUpUser(User user) {
		if(users.isEmpty()) {
			user.setUserID(1);
			writeUser(user, filePath);
		} else {
			user.setUserID(users.lastElement().getUserID() + 1);
			writeUser(user,filePath);
		}
	}
	
// ----------------- I/O from DB methods -------------------------- //
	
	/**
	 * 
	 * @param user
	 */
	public void writeUser(User user, String filePath) {		
		try {
			
			FileWriter myWriter = new 
					FileWriter(filePath, true);
			myWriter.write(user.getEmail() +
							"-" +
							user.getPassword() +
							"-" +
							user.getUsername() +
							"-" +
							user.getUserID() +
							"-" +
							user.getIsVip() +
							"\n"
							);
			myWriter.close();			
		
		} catch (IOException e) {
			System.out.println("An error ocurred while opening the file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public Vector<Vector<String>> readUsers() {		
		Reader reader = null;
		String data = "";
		Vector<String> line = new Vector<String>();
		Vector<Vector<String>> file = new Vector<Vector<String>>();
		
		try {

			int num = 0;
			reader = new FileReader(filePath);
			
			while((num = reader.read()) != -1) {
				char character = (char) num;
				
				if(character == '\n') {
					line.add(data);
					data = "";
					
					Vector<String> newLine = (Vector<String>) line.clone();
					file.add(newLine);
					line.clear();
				} 
				else if(character == '-') {
					line.add(data);
					data = "";
				} else {
					data += character;															
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
}
