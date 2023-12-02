package br.ufrn.imd.dao;

import java.io.IOException;
import java.util.Vector;

import br.ufrn.imd.model.CommonUser;
import br.ufrn.imd.model.User;
import br.ufrn.imd.model.VipUser;

public class Test {

	public static void main(String[] args) throws IOException {
		
		UserDataBase db = UserDataBase.getInstance();
		
		VipUser vipUser = new VipUser();
		vipUser.setEmail("emanuelkywal@outlook.com");
		vipUser.updatePassword("12345");
		vipUser.setUsername("Emanuel Kywal");
		
		CommonUser cUser = new CommonUser();
		cUser.setEmail("kywalfilho@outlook.com");
		cUser.updatePassword("98765");
		cUser.setUsername("Kywal filho");
		
		db.signUpUser(vipUser);
		db.signUpUser(cUser);
		
//		db = UserDataBase.getInstance();
//		
//		for (User user : db.users) {
//			System.out.println(user.getEmail());
//			System.out.println(user.getPassword());
//			System.out.println(user.getUsername());
//			System.out.println(user.getIsVip());
//			System.out.println(user.getUserID());
//		}
	}

}
