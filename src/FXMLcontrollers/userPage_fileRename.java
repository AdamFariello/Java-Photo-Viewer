package FXMLcontrollers;

import general.lock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ourFilesTM.Album;

public class userPage_fileRename {
	@FXML private TextField TextField;
	private Album currDir;
	private Object object;
	public void init(Album currDir, Object object) {
		this.currDir = currDir;
		this.object = object;
	}
	@FXML private void create(ActionEvent event) {
		currDir.getFile(object);
		exit(event);
	}
	@FXML private void exit(ActionEvent event) {
		while (lock.isLocked());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}