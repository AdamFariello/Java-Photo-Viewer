package general;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * @author Edison & Adam
 *
 */
public class main extends Application{
	private final int width  = 800;
	private final int height = 600;
	
	@Override
	/**
	 * scene 
	 */
	public void start(Stage stage) throws Exception {
		//System.out.println(System.getProperty("user.dir"));
		//"../213/photos"
		
		String string = "../FXML/login.fxml";
		FXMLLoader FXMLLoader = new FXMLLoader(getClass().getResource(string));
		Parent root = FXMLLoader.load();
		
		Scene scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	/**
	 * main method
	 */
	public static void main (String args []) {
		launch(args);
	}
}