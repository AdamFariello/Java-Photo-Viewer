package FXMLcontrollers;

import general.lock;
import general.profileList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class createUser {
	@FXML private TextField TextField;
	private profileList profileList;
	
	public void init (profileList profileList) {
		this.profileList = profileList;
		System.out.println(profileList);
	}
	
	@FXML private void createUser () {
		if (profileList.getFile(TextField.getText()) == null) {
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Profile already Exists");
			alert.setContentText("Username already taken");
			alert.showAndWait();
		}
	}
	
	@FXML private void exitUser (ActionEvent event) {
		while (lock.getLock());
		
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}
