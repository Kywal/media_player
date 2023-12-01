package br.ufrn.imd.model;

import java.util.ArrayList;

public class Folder {

	protected String name, path;
	protected ArrayList<Music> musics;
	protected Double duration;
	
	/**
	 * 
	 */
	public Folder() {
		duration = updateDuration();
		musics = new ArrayList<Music>();
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
	public String getPath() {
		return path;
	}

	/**
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

// -------------- Musics methods ------------ //
	
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


//	--------- Duration methods ----------- //

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
	private Double updateDuration() {
		Double totalDuration = 0.0;
		
		for (Music music : musics) {
			totalDuration += music.getDuration();
		}
		
		return totalDuration;
	}
}
