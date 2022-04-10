package FXMLcontrollers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import general.proMan;

public class login {
	@FXML private TextField TextField_login;
	@FXML private Label label_incorrectLogin;
	

	
	@FXML public void logIn(ActionEvent event) throws Exception {
		//TODO add initalization
		File file = proMan.getProfile(TextField_login.getText()); 
		if (file != null) {
			FXMLLoader FXMLLoader;
			switch (file.getName()) {
				case "admin.txt":
					FXMLLoader = new FXMLLoader(
						getClass().getResource("../FXML/adminPage.fxml")
					);
					break;
				default: 
					FXMLLoader = new FXMLLoader(
						getClass().getResource("../FXML/userPage.fxml")
					);
					break;
			}
			
			Parent root = FXMLLoader.load();
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
