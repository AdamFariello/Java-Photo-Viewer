package FXMLcontrollers;

import java.io.File;
import java.util.List;

import general.profileList;
import general.lock;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class adminPage {
	//TODO Add functionality to the controller
	@FXML private ListView<String> listview;
	private File selectedFile;
	private profileList profileList;
		
	public void loadList() {
		try {
			selectedFile = null;
			listview.getItems().clear();
			profileList = new profileList();
			List<String> list = profileList.toList();
			listview.getItems().addAll(FXCollections.observableList(list));
			listview.setOnMouseClicked(e-> {
				String string = listview.getSelectionModel().getSelectedItem();
				selectedFile = profileList.getFile(string);
			});
		} catch (Exception e) {
			System.out.println("[DEBUG] adminPage init()");
			System.out.println(e);
		}
	}
	
	/*Buttons*/
	@FXML public void logout (ActionEvent event) throws Exception{
		//Puts it in infinite loop until write is done
		while (lock.getLock());
		
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/login.fxml")
		);
		Parent root = FXMLLoader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	@FXML public void createUser () throws Exception {		
		//TODO work on creating a user
		createUser createUser = new createUser();
		createUser.init(profileList);
		
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/createUser.fxml")
		);
		Parent root = FXMLLoader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	@FXML public void deleteUser () {
		try {
			selectedFile.delete();
			loadList();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("No profile selected");
			alert.setContentText("Select a profile first before deleting it");
			alert.showAndWait();
		}
	}	
}