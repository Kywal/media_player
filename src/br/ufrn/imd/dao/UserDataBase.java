package br.ufrn.imd.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class UserDataBase {

	private static UserDataBase instance;
	private String filePath = "database\\users.txt"; // TODO -> Remove when dinamic filePath is implemented
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
		Vector<Vector<String>> file = readUsers();
		
		for (Vector<String> line : file) {
			User user = null;
			Boolean isVip = Boolean.valueOf(line.get(4));
			
			if(isVip) {
				user = new VipUser();
			} else {
				user = new User();
			}
			
			user.setEmail(line.get(0));
			user.updatePassword(line.get(1));
			user.setUsername(line.get(2));
			user.setUserID(Integer.valueOf(line.get(3)));
			
			users.add(user);
		}
		
	}
	
//	---------------- Utilitary User methods ----------------------- //
	
	/**
	 * 
	 * @param user
	 * @throws IOException 
	 */
	public void signUpUser(User user) throws IOException {
		
		try {
			
			if(users.isEmpty()) {
				user.setUserID(1);
				users.add(user);
				writeUser(user, filePath);
			} else {
				user.setUserID(users.lastElement().getUserID() + 1);
				users.add(user);
				writeUser(user,filePath);
			}
			
		} catch (IOException e) {
			System.out.println("An error ocurred while signing the new user");
			e.printStackTrace();
		}
	}
	
// ----------------- I/O from DB methods -------------------------- //
	
	/**
	 * 
	 * @param user
	 */
	private void writeUser(User user, String filePath) throws IOException {		
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
	 * Read the users database and saves it all in a string matrix.
	 * 
	 * Data mapping in the string matrix is:
	 * 	0 -> email,
	 * 	1 -> password,
	 *  2 -> username,
	 *  3 -> userID,
	 *  4 -> isVip.
	 * 
	 * @return The string matrix.
	 */
	private Vector<Vector<String>> readUsers() {		
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
