package FXMLcontrollers;

import java.io.File;
import java.util.List;

import general.proMan;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class adminPage {
	//TODO Add functionality to the controller
	@FXML private ListView<String> listview;
	private File selectedFile;
		
	public void init () {
		selectedFile = null;
		
		try {
			List<String> list = proMan.getProfileNames(proMan.getProfiles());
			System.out.println("test: " +listview);
			listview.getItems().addAll(FXCollections.observableList(list));
			listview.setOnMouseClicked(e-> {
				String string = listview.getSelectionModel().getSelectedItem();
				System.out.println(string);
				selectedFile = new File(string);
			});
		} catch (Exception e) {
			System.out.println("[DEBUG] adminPage init()");
			System.out.println(e);
		}
	}
	
	/*Buttons*/
	@FXML public void logout (ActionEvent event) throws Exception{
		//Puts it in infinite loop until write is done
		while (proMan.getLock());
		
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
	@FXML public void createUser () throws Exception{
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
		
	}	
}