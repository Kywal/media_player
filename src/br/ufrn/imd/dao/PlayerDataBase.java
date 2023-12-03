package br.ufrn.imd.dao;

import java.io.IOException;

import br.ufrn.imd.model.User;

public class PlayerDataBase {

	private static PlayerDataBase instance;
	protected UserDataBase users;
	protected FolderDataBase folders;
	protected MusicDataBase musics; 
	
// ------------------ Singleton Implementation ------------------- //
	
	/**
	 * 
	 */
	private PlayerDataBase() {
		users = UserDataBase.getInstance();
	}
	
	/**
	 * 
	 * @return
	 */
	public static PlayerDataBase getInstance() {
		if(instance == null) {
			instance = new PlayerDataBase();
		}
		
		return instance;
	}
	
// --------------------- Users methods -------------------- //
	
	/**
	 * 
	 * @param user
	 * @throws IOException 
	 */
	public void signUpUser(User user) throws IOException {
		users.signUpUser(user);
	}
	
//	-------------------- Playlists ----------------------- //
	
}