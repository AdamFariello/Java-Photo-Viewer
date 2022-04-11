package general;

import java.net.URL;

import FXMLcontrollers.login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application{
	private final int width  = 800;
	private final int height = 600;
	
	@Override
	public void start(Stage stage) throws Exception {
		String string = "../FXML/login.fxml";
		FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource(string));
		Parent root = FXMLLoader.load();
		
		Scene scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main (String args []) {
		launch(args);
	}
}