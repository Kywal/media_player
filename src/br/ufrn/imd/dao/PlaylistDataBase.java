package br.ufrn.imd.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.User;

public class PlaylistDataBase {

	private static PlaylistDataBase instance;
	private String filePath = "database\\playlists"; // TODO -> Remove when dinamic filePath is implemented
	protected Vector<Playlist> playlists;

// -------------- Singleton implementation -------------- //	
	
	/**
	 * 
	 */
	private PlaylistDataBase() {
		playlists = new Vector<Playlist>();
		getPlaylistsFromDB();
	}

	/**
	 * 
	 * @return
	 */
	public static PlaylistDataBase getInstance() {
		if(instance == null) {
			instance = new PlaylistDataBase();
		}
	     
		return instance;
	}
	
// ------------------ Start/End DB methods ------------------------ //	

	/**
	 * 
	 */
	private void getPlaylistsFromDB() {
	       
	}
	
//	---------------- CRUD Playlist methods ----------------------- //
	
	/**
	 * 
	 * @param p
	 */
	public void addPlaylist(User user, Playlist p) {
//		user.set
		
	}

// ----------------- I/O from DB methods -------------------------- //

	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	private void writePlaylist(User user, Playlist p) throws IOException {
		
		try {
			FileWriter myWriter = new FileWriter(filePath, true);	
//			myWriter.write("")
			
		} catch (IOException e) {
			
		}
		
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	private Vector<Vector<String>> readPlaylist() {
		return new Vector<Vector<String>>(); // STUB 
	}
	
}
