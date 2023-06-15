package FXMLcontrollers;

import general.lock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ourFilesTM.Album;

public class userPage_albumCreator {
	@FXML private TextField TextField;
	private Album currDir;
	public void init(Album currDir) {
		this.currDir = currDir;
	}
	@FXML private void create(ActionEvent event) {
		Album album = new Album(TextField.getText());
		currDir.addFile(album);
		exit(event);
	}
	@FXML private void exit(ActionEvent event) {
		while (lock.isLocked());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}