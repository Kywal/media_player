package br.ufrn.imd.dao;

import java.io.File;
import java.io.IOException;

import br.ufrn.imd.model.Folder;
import br.ufrn.imd.model.Music;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class PlayerDataBase {

	private static PlayerDataBase instance;
	protected UserDataBase users;
	protected MusicDataBase musics; 
	protected PlaylistDataBase playlists;
	
// ------------------ Singleton Implementation ------------------- //
	
	/**
	 * @throws IOException 
	 * 
	 */
	private PlayerDataBase() {
		
		try {			
			users = UserDataBase.getInstance();
			musics = MusicDataBase.getInstance();
			playlists = PlaylistDataBase.getInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static PlayerDataBase getInstance() throws IOException {
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
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Boolean authUser(String email, String password) {
		return users.authUser(email, password);
	}
	
	/**
	 * 
	 * @param userID
	 * @param password
	 * @return
	 */
	public Boolean authUser(Integer userID, String password) {
		return users.authUser(userID, password);
	}
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public User findUser(Integer userID) {
		return users.findUser(userID);
	}
	
//	-------------------- Musics methods ------------------- //
	
	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	public void addMusic(Music m) throws IOException {
		musics.addMusic(m);
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public void addFolder(Folder f) throws IOException {
		musics.addFolder(f);
	}
	
//	-------------------- Playlists ----------------------- //
	
	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	public void addPlaylist(VipUser user, Playlist p) throws IOException {
		playlists.addPlaylist(user, p);
	}
	
	
}