package FXMLcontrollers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ourFilesTM.Album;
import ourFilesTM.Photo;

public class userPage {
	@FXML public FlowPane FlowPane;
	private File file;
	private Album root;
	
	/*Initializing*/
	public void init(File file) throws Exception{
		//User has been created for the first
		//time and requires a root directory
		this.file = file;
		root = new Album("/");
		loadDir();
	}
	public void init(File file, Album root) throws Exception{
		//TODO Work on this when serialization
		//is setup
		//User has already used the program
		this.file = file;
		this.root = root;
		loadDir();
	}
	
	public void loadDir() throws Exception{
		for (int i = 0; i < root.getDir().size(); i++) {
			/*TODO Not required?
			FXMLLoader FXMLLoader = new FXMLLoader(
				getClass().getResource("../FXML/thumbnail.fxml")
			);
			Parent parent = FXMLLoader.load();
			*/
			
			Object object = root.getFile(i); 
			thumbnail thumbnail = new thumbnail();
			if (object instanceof Album) {
				thumbnail.init((Album) object);
			} else {
				thumbnail.init((Photo) object);
			}
			
			
		}
	}
	
	/*Task Bar; Handling buttons in File*/
	@FXML public void file_CreateAlbum (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void file_AddPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void file_DeleteSelected (ActionEvent Event) {
		//TODO Add functionality
	}
	
	/*Rest of Task Bar*/
	@FXML public void rename (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void editPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void viewPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void searchPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void scrollLeft (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void scrollRight (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void logout (ActionEvent Event) {
		//TODO Add functionality
	}
}
