package br.ufrn.imd.model;

import java.util.ArrayList;

public class CommonUser extends User {

	protected ArrayList<Folder> folders;
	
	public CommonUser() {
		folders = new ArrayList<Folder>();
	}
	
//	--------------- folders methods ----------------- //

	/**
	 * 
	 * @return
	 */
	public ArrayList<Folder> getFolders() {
		return folders;
	}

	/**
	 * 
	 * @param folders
	 */
	public void setFolders(ArrayList<Folder> folders) {
		this.folders = folders;
	}
	
	/**
	 * 
	 * @param f
	 */
	public void addFolder(Folder f) {
		folders.add(f);
	}
	
	/**
	 * 
	 * @param f
	 */
	public void removeFolder(Folder f) {
		folders.remove(f);
	}

}
