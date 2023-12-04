package br.ufrn.imd.controller;

import java.io.IOException;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.dao.PlayerDataBase;
import br.ufrn.imd.dao.UserDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class IndexController{

	private Stage window;
	private Scene scene;
	private Parent root;
	private PlayerDataBase player;
			
	public IndexController() throws IOException {
		player = PlayerDataBase.getInstance();	
	}
	
    @FXML
    private TextField inputEmail;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    public void login(ActionEvent event) throws IOException {
    	String email = inputEmail.getText();
    	String password = inputPassword.getText();
    	
    	
    	if(player.authUser(email, password)) {
    		MainApp m = new MainApp();
    		m.changeScene("view/MediaPlayer.fxml");
    	}
    }
    
    public void signUp(ActionEvent event) throws IOException {
    	System.out.println("TEste!");
    	Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
		window = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		window.setScene(scene);	
		window.show();
    }
}
