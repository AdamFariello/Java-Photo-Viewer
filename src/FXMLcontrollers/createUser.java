package FXMLcontrollers;

import java.io.File;

import general.lock;
import general.profileList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
/**
 * 
 * @author Edison & Adam
 *
 */
public class createUser {
	@FXML public TextField TextField;
	private profileList profileList;
	/**
	 * "This" function for profileList
	 * @param profileList
	 */
	public void init (profileList profileList) {
		this.profileList = profileList;
	}
	/**
	 * Action of creating a user on event
	 * @param event
	 */
	@FXML public void createUser (ActionEvent event) {
		while (lock.isLocked());
		lock.lock();

		File file = profileList.getFile(TextField.getText());
		if (file == null && !TextField.getText().equals("")) {
			String s = profileList.getDir() + "/" + TextField.getText() + ".txt";
			try {
				File newFile = new File(s);
				newFile.createNewFile();
			} catch (Exception e) {
				System.out.println("[DEBUG] creatsUser createUser");
				System.out.println(e);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Username cannot be used");
			alert.setContentText("Username is either taken or illegal");
			alert.showAndWait();
		}
		
		lock.unlock();
	}
	
	/**
	 * method to exit from the scene
	 * @param event
	 */
	@FXML public void exitUser (ActionEvent event) {
		while (lock.isLocked());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}