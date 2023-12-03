package br.ufrn.imd.model;

import java.util.ArrayList;

public class Music {

	protected String name, language, path;
	protected Integer year;
	protected Double duration;
	protected ArrayList<String> authors;
	protected ArrayList<String> genres;
	
	/**
	 * 
	 */
	public Music() {
		authors = new ArrayList<String>();
		genres = new ArrayList<String>();
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
	public String getLanguage() {
		return language;
	}

	/**
	 * 
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 
	 * @return
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
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

// ------------ Authors methods ------------- //
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getAuthors() {
		return authors;
	}

	/**
	 * 
	 * @param authors
	 */
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	/**
	 * 
	 * @param a
	 */
	public void addAuthor(String a) {
		authors.add(a);
	}
	
	/**
	 * 
	 * @param a
	 */
	public void removeAuthor(String a) {
		authors.remove(a);
	}

//	------------ Genres methods ------------- //
	
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
