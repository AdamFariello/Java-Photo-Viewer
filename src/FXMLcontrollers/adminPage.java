package FXMLcontrollers;

import java.io.File;

import general.proMan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class adminPage {
	//TODO Add functionality to the controller
	
	public void init () {
		//TODO list users
	}
	
	/*Buttons*/
	@FXML public void logout () {
		while (proMan.getLock()) {}
		
		Parent root = FXMLLoader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	@FXML public void createUser () {
		
	}
	@FXML public void deleteUser () {
		
	}
}
