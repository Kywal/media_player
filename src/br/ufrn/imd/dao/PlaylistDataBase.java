package br.ufrn.imd.dao;

import java.util.Vector;
import br.ufrn.imd.model.Playlist;

public class PlaylistDataBase {

	private static PlaylistDataBase instance;
	protected Vector<Playlist> playlists;

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

	/**
	 * 
	 */
	private void getPlaylistsFromDB() {
	       
	}
}
