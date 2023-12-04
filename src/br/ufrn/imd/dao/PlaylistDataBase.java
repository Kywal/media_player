package br.ufrn.imd.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Month;
import java.util.Vector;

import br.ufrn.imd.model.Music;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class PlaylistDataBase {

	private static PlaylistDataBase instance;
	private String filePath = "database\\playlists\\"; // TODO -> Remove when dinamic filePath is implemented
	protected UserDataBase users = UserDataBase.getInstance();
	protected Vector<Playlist> playlists;

// -------------- Singleton implementation -------------- //	
	
	/**
	 * @throws IOException 
	 * 
	 */
	private PlaylistDataBase() throws IOException {
		playlists = new Vector<Playlist>();
		getPlaylistsFromDB();
	}

	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static PlaylistDataBase getInstance() throws IOException {
		if(instance == null) {
			instance = new PlaylistDataBase();
		}
	     
		return instance;
	}
	
// ------------------ Start/End DB methods ------------------------ //	

	/**
	 * @throws IOException 
	 * 
	 */
	private void getPlaylistsFromDB() throws IOException {
		Vector<Vector<Vector<String>>> files = readPlaylists();
		
		for (Vector<Vector<String>> file : files) {
			Vector<String> line0 = file.get(0);
			Vector<String> line1 = file.get(1);
			
			
			Integer userID =  Integer.valueOf(line0.get(1)); 
			String password = line0.get(3);	
			User user = users.findUser(userID);
			
			
			if(users.authUser(userID, password) && user != null && user instanceof VipUser) {
				Playlist p = new Playlist();
				p.setPlaylistID(Integer.valueOf(line1.get(0)));
				p.setName(line1.get(1));
				p.setSubTitle(line1.get(2));
				p.setCreationDate(
						LocalDate.of(
								Integer.valueOf(line1.get(3)), 
								Month.of(Integer.valueOf(line1.get(4))),
								Integer.valueOf(line1.get(5))));
				p.setDuration(Double.valueOf(line1.get(6)));
				
				int i = 2;
				while(i < file.size()){
					if(!file.get(i).get(0).equals("music")) {
						break;
					}
					
					Vector<String> lineX = file.get(i);
					
					Music m = new Music();
					m.setName(lineX.get(1));
					m.setPath(lineX.get(2));
					m.setLanguage(lineX.get(3));
					m.setYear(Integer.valueOf(lineX.get(4)));
					m.setDuration(Double.valueOf(lineX.get(5)));
					
					int k;
					for (int j = k = 5; j < m.getAuthors().size();k++, j++) {
						m.addAuthor(lineX.get(j));
					}
					
					for (; k < m.getGenres().size(); k++) {
						m.addGenre(lineX.get(k));
					}
					
					i++;
				}		
				
				((VipUser)user).addPlaylist(p);
				playlists.add(p);
			}
		}
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
				((VipUser)user).addPlaylist(p);
				writePlaylist(user, p);
			} else {
				p.setPlaylistID(playlists.lastElement().getPlaylistID() + 1);
				playlists.add(p);
				((VipUser)user).addPlaylist(p);
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
	public void writePlaylist(User user, Playlist p) throws IOException {
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
	 * Data mapping: 00 -> UserID; 01 -> Password; 10 -> Playlist ID; 11 -> Name; 12 -> Subtitle; 13 -> Creation Date; 14 -> Duration;
	 * @return
	 */
	private Vector<Vector<Vector<String>>> readPlaylists() {
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
				
				@SuppressWarnings("unchecked")
				Vector<Vector<String>> newFile = (Vector<Vector<String>>) file.clone();
				filesMatrix.add(newFile);
				file.clear();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		
		return filesMatrix;
	}
	
}
