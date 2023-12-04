package br.ufrn.imd;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class MainApp extends Application {
	
	private static Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void changeScene(String fxml) {
		try {
			Parent pane = FXMLLoader.load(getClass().getResource(fxml));
			window.getScene().setRoot(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void start(Stage firstWindow) throws Exception {		
		window = firstWindow;
		
		// index path
		Parent root = FXMLLoader.load(getClass().getResource("view/Index.fxml"));
		Scene scene = new Scene(root);
		firstWindow.setScene(scene);
		firstWindow.setTitle("Media Player");
		firstWindow.setResizable(false);
		firstWindow.show();
	}
	
}