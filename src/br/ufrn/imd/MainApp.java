package br.ufrn.imd;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class MainApp extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage firstWindow) throws Exception {		

		// index path
		Parent root = FXMLLoader.load(getClass().getResource("view/Index.fxml"));
		Scene scene = new Scene(root);
		firstWindow.setScene(scene);
		firstWindow.setTitle("Media Player");
		firstWindow.setResizable(false);
		firstWindow.show();
	}
	
}