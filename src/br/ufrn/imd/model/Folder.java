package br.ufrn.imd.model;

import java.util.ArrayList;

public class Folder {

	protected String folderName;
	protected String path;
	
	/**
	 * 
	 */
	public Folder() { }
	
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
	 * @return the folderName
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @param folderName the folderName to set
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

}
