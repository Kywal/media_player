/**
 * @author Emanuel Kywal
 */

package br.ufrn.imd.model;

import java.util.Vector;

public class VipUser extends User {
	
	protected Vector<Playlist> playlists;
	
	/**
	 * 
	 */
	public VipUser() { 
		isVip = true;
		playlists = new Vector<Playlist>();
	}	
	
//	-------------- playlist methods -------------- //

	/**
	 * 
	 * @return
	 */
	public Vector<Playlist> getPlaylists() {
		return playlists;
	}

	/**
	 * 
	 * @param playlists
	 */
	public void setPlaylists(Vector<Playlist> playlists) {
		this.playlists = playlists;
	}

	/**
	 * 
	 * @param p
	 */
	public void addPlaylist(Playlist p) {
		playlists.add(p);
	}
	
	/**
	 * @
	 * @param p
	 */
	public void removePlaylist(Playlist p) {
		playlists.remove(p);
	}
	
	
}
