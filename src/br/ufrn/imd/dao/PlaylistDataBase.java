package br.ufrn.imd.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

import br.ufrn.imd.model.Music;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class PlaylistDataBase {

	private static PlaylistDataBase instance;
	private String filePath = "database\\playlists\\"; // TODO -> Remove when dinamic filePath is implemented
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
//		Vector<Vector<Vector<String>>> files = readPlaylists();
		
		
	}
	
//	---------------- CRUD Playlist methods ----------------------- //
	
	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	public void addPlaylist(VipUser user, Playlist p) throws IOException {
		try {

			if(playlists.isEmpty()) {
				p.setPlaylistID(1111);
				playlists.add(p);
				((VipUser)user).setPlaylists(playlists);
				writePlaylist(user, p);
			} else {
				p.setPlaylistID(playlists.lastElement().getPlaylistID() + 1);
				playlists.add(p);
				((VipUser)user).setPlaylists(playlists);
				writePlaylist(user, p);
			}				
			
		} catch (IOException e) {
			System.out.println("An error ocurred while adding the new Playlist");
			e.printStackTrace();
		}
		
		
	}

// ----------------- I/O from DB methods -------------------------- //

	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	private void writePlaylist(User user, Playlist p) throws IOException {
		String fileName = "playlist_" + p.getPlaylistID() + ".txt";
		String dash = "-";
		
		try {
			FileWriter myWriter = new FileWriter(filePath + fileName);	
			myWriter.write("UserID-" + user.getUserID() + "-Password-" + user.getPassword() + "\n" +
							p.getPlaylistID() + dash +
							p.getName() + dash + 
							p.getSubTitle() + dash + 
							p.getCreationDate() + dash +
							p.getDuration() + dash + 
							"\n"
							);
			
			for (Music music : p.getMusics()) {
				myWriter.write("music" + dash + 
								music.getName() + dash +
								music.getPath() + dash +
								music.getLanguage() + dash +
								music.getYear() + dash +
								music.getDuration() + dash
								);
				
				myWriter.write("author");
				for (String author : music.getAuthors()) {
					myWriter.write(dash + author);
				}
				
				
				myWriter.write(dash + "genre");
				for (String genre : music.getGenres()) {
					myWriter.write(dash + genre);
				}
				myWriter.write("\n");
			}
			
			myWriter.close();
		} catch (IOException e) {
			
		}
		
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	protected Vector<Vector<Vector<String>>> readPlaylists() {
		Reader reader = null;
		String data = "";
		Vector<String> line = new Vector<String>();
		Vector<Vector<String>> file = new Vector<Vector<String>>();
		Vector<Vector<Vector<String>>> filesMatrix = new Vector<Vector<Vector<String>>>();
		 
		File playlistFolder = new File(filePath);
		File files[] = playlistFolder.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			
			try {
				
				int num = 0;
				reader = new FileReader(filePath + fileName);
				
				while((num = reader.read()) != -1) {
					char character = (char) num;
					
					if(character == '\n') {
						line.add(data);
						data = "";
						
						@SuppressWarnings("unchecked")
						Vector<String> newLine = (Vector<String>) line.clone();
						file.add(newLine);
						line.clear();
					} 
					else if(character == '-') {
						line.add(data);
						data = "";
					} else {
						data += character;															
					}
				}
				
				filesMatrix.add(file);
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		
		return filesMatrix;
	}
	
}
