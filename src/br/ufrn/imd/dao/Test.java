package br.ufrn.imd.dao;

import java.io.IOException;
import java.util.Vector;

import br.ufrn.imd.model.CommonUser;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class Test {

	public static void main(String[] args) throws IOException {
		
		UserDataBase db = UserDataBase.getInstance();
		
		User user = new CommonUser();
		User vipUser = new VipUser();
		
		user.setEmail("kywalfilho@outlook.com");
		user.setUsername("Emanuel Kywal");
		user.updatePassword("12345");
		
		vipUser.setEmail("emanuelkywal@outlook.com");
		vipUser.setUsername("Kywal Cabral");
		vipUser.updatePassword("98765");
//		
//		db.signUpUser(user,"");
//		db.signUpUser(vipUser,"");
		
		
//		Vector<Vector<String>> file = new Vector<Vector<String>>();
//		file = db.readUsers();
		
//		System.out.println(file);
	}

}
