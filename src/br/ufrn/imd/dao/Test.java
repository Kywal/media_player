package br.ufrn.imd.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import br.ufrn.imd.model.Music;
import br.ufrn.imd.model.Playlist;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class Test {

	public static void main(String[] args) throws IOException {
		
		UserDataBase dbUsers = UserDataBase.getInstance();
		
//		VipUser vipUser = new VipUser();
//		vipUser.setUsername("Emanuel Kywal");
//		vipUser.setEmail("emanuelkywal@outlook.com");
//		vipUser.updatePassword("12345");
//		dbUsers.signUpUser(vipUser);
		
//		VipUser u2 = new VipUser();
//		u2.setUsername("Kywal Cabral");
//		u2.setEmail("kywalfilho@outlook.com");
//		u2.updatePassword("98765");
//		dbUsers.signUpUser(u2);
		
		PlaylistDataBase dbPlaylists = PlaylistDataBase.getInstance();
		
		for (User user : dbUsers.users) {
			for (Playlist p : ((VipUser)user).getPlaylists()) {
				System.out.println("User: " + user.getUsername() + " - Playlist " + p.getName() + " " + p.getPlaylistID());
			}			
		}
		
//		Playlist p1 = new Playlist();
//		p1.setName("Memento");
//		p1.setSubTitle("Lofi and others calm songs");
//		p1.setDuration(56.4);
//
//		Music m1 = new Music();
//		m1.setPath("teste\\musiquitas\\fifteen_minutes.wavv");
//		m1.setName("Fifteen Minutes");
//		m1.setYear(2009);
//		m1.setLanguage("Ingles");
//		m1.setDuration(3.6);
//		
//		ArrayList<String> genre1 = new ArrayList<String>();
//		genre1.add("Garage Rock");
//		m1.setGenres(genre1);
//		
//		ArrayList<String> authors1 = new ArrayList<String>();
//		authors1.add("Mike Krol");
//		m1.setAuthors(authors1);
//		
//		Music m2 = new Music();
//		m2.setPath("teste\\musiquitas\\fifteen_minutes.wavv");
//		m2.setName("Fifteen Minutes");
//		m2.setYear(2009);
//		m2.setLanguage("Ingles");
//		m2.setDuration(3.6);
//		
//		ArrayList<String> genre2 = new ArrayList<String>();
//		genre2.add("Garage Rock");
//		m2.setGenres(genre2);
//		
//		ArrayList<String> authors2 = new ArrayList<String>();
//		authors2.add("Mike Krol");
//		m2.setAuthors(authors2);
//		
//		Music m3 = new Music();
//		m3.setPath("teste\\musiquitas\\fifteen_minutes.wavv");
//		m3.setName("Fifteen Minutes");
//		m3.setYear(2009);
//		m3.setLanguage("Ingles");
//		m3.setDuration(3.6);
//		
//		ArrayList<String> genre3 = new ArrayList<String>();
//		genre3.add("Garage Rock");
//		m3.setGenres(genre3);
//		
//		ArrayList<String> authors3 = new ArrayList<String>();
//		authors3.add("Mike Krol");
//		m3.setAuthors(authors3);
//		
//		p1.addMusic(m1);
//		p1.addMusic(m2);
//		p1.addMusic(m3);
//		
//		dbPlaylists.addPlaylist(vipUser, p1);
//		dbPlaylists.addPlaylist(u2, p1);
		
	}

}
