/**
 * @author Emanuel Kywal
 */

package br.ufrn.imd.model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Playlist {

	protected String name, subTitle;
	protected Integer playlistID;
//	protected Image cover;
	protected Double duration;
	protected LocalDate creationDate;
	protected ArrayList<Music> musics;
	protected ArrayList<String> genres;
	
	/**
	 * 
	 */
	public Playlist() {
		creationDate = LocalDate.now();
		musics = new ArrayList<Music>();
		genres = new ArrayList<String>();
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * 
	 * @param subTitle
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getPlaylistID() {
		return playlistID;
	}

	/**
	 * 
	 * @param playlistID
	 */
	public void setPlaylistID(Integer playlistID) {
		this.playlistID = playlistID;
	}
	
	/**
	 * 
	 * @return
	 */
	public Double getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(Double duration) {
		this.duration = duration;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getCreationDate() {
		return creationDate;
	}

//	--------------- Musics methods -------------- //
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Music> getMusics() {
		return musics;
	}

	/**
	 * 
	 * @param musics
	 */
	public void setMusics(ArrayList<Music> musics) {
		this.musics = musics;
	}
	
	/**
	 * 
	 * @param m
	 */
	public void addMusic(Music m) {
		musics.add(m);
	}
	
	/**
	 * 
	 * @param m
	 */
	public void removeMusic(Music m) {
		musics.remove(m);
	}

//	-------------- Genres methods --------------- //
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getGenres() {
		return genres;
	}

	/**
	 * 
	 * @param genres
	 */
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	
	/**
	 * 
	 * @param g
	 */
	public void addGenre(String g) {
		genres.add(g);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void removeGenre(String g) {
		genres.remove(g);
	}
	
}
