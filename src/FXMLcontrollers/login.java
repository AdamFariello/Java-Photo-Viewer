package FXMLcontrollers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ourFilesTM.Album;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import general.profileList;
import FXMLcontrollers.*;

public class login {
	@FXML private TextField TextField_login;
	@FXML private Label label_incorrectLogin;
	
	@FXML public void logIn(ActionEvent event) throws Exception {
		profileList profileList = new profileList();
		File file = profileList.getFile(TextField_login.getText()); 
		if (file != null) {
			FXMLLoader FXMLLoader;
			Parent root;
			switch (file.getName()) {
				//You can only load the list after you lt first. 
				case "admin.txt":
					FXMLLoader = new FXMLLoader(
						getClass().getResource("../FXML/adminPage.fxml")
					);
					root = FXMLLoader.load();
					adminPage adminPage = FXMLLoader.getController();
					adminPage.init(profileList);
					break;
				default: 
					FXMLLoader = new FXMLLoader(
						getClass().getResource("../FXML/userPage.fxml")
					);
					root = FXMLLoader.load();
					
					userPage userPage = FXMLLoader.getController();
					/*TODO implement serialization method
					Album album = File.unserialzed();
					if (album != null) {
						userPage.init(file, album);
					} else {
						userPage.init(file);
					}
					
					userPage userPage = new userPage();
					userPage.init(file);
					*/
					userPage.init(file);
					
					break;
			}

			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} else {
			label_incorrectLogin.setVisible(true);
		}
	}
}
