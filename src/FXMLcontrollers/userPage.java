package FXMLcontrollers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import objects.Album;
import javafx.scene.layout.FlowPane;

public class userPage {
	@FXML public FlowPane FlowPane;
	Album root;
	
	public void init(File file) {
		//User has been created for the first
		//time and requires a root directory
		root = new Album("/");
	}
	
	public void init(Album root) {
		//User has already used the program
		this.root = root;
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
