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
import br.ufrn.imd.model.Music;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class MusicDataBase {

	private static MusicDataBase instance;
	private String filePath = "database\\musics.txt"; // TODO -> Remove when dinamic filePath is implemented
	protected Vector<Music> musics;

// -------------- Singleton implementation -------------- //	
	
	/**
	 * @throws IOException 
	 * 
	 */
	private MusicDataBase() throws IOException {
		musics = new Vector<Music>();
		getMusicsFromDB();
	}

	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static MusicDataBase getInstance() throws IOException {
		if(instance == null) {
			instance = new MusicDataBase();
		}
	     
		return instance;
	}
	
// ------------------ Start/End DB methods ------------------------ //		


	/**
	 * @throws IOException 
	 * 
	 */
	private void getMusicsFromDB() throws IOException {
		Vector<Vector<String>> file = readMusics();
		
		for (Vector<String> line : file) {
			Music m = new Music();
			
			m.setName(line.get(0));
			m.setPath(line.get(1));
			m.setLanguage(line.get(2));
			m.setYear(Integer.valueOf(line.get(3)));
			m.setDuration(Double.valueOf(line.get(4)));
			
			for (int i = 6; i < m.getAuthors().size(); i++) {
				m.addAuthor(line.get(i));
			}
			
			for (int i = 0; i < m.getGenres().size(); i++) {
				m.addGenre(line.get(i));
			}
			
			musics.add(m);
		}
	}
	
//	---------------- CRUD Music methods ----------------------- //
	
	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	public void addMusic(Music m) throws IOException {
		if(musics.contains(m)) {
			System.out.println("A música selecionada já está no Media Player!");
		} else {
			writeMusic(m);
		}
	}

// ----------------- I/O from DB methods -------------------------- //

	/**
	 * 
	 * @param p
	 * @throws IOException 
	 */
	public void writeMusic(Music music) throws IOException {
		String dash = "-";
		
		try {
			
			FileWriter myWriter = new FileWriter(filePath, true);	
	
			myWriter.write( music.getName() + dash +
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
			
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error ocurred while opening the music file");
			e.printStackTrace();
		}	
	}
	
	/**
	 * 
	 * Data mapping: 00 -> UserID; 01 -> Password; 10 -> Music ID; 11 -> Name; 12 -> Subtitle; 13 -> Creation Date; 14 -> Duration;
	 * @return
	 */
	private Vector<Vector<String>> readMusics() {
		Reader reader = null;
		String data = "";
		Vector<String> line = new Vector<String>();
		Vector<Vector<String>> file = new Vector<Vector<String>>();
		
		try {

			int num = 0;
			reader = new FileReader(filePath);
			
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
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}	
}
