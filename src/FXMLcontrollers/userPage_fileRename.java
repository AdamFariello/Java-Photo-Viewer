package FXMLcontrollers;

import general.lock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ourFilesTM.Album;
import ourFilesTM.Photo;

public class userPage_fileRename {
	@FXML private TextField TextField;
	private Object object;
	public void init(Object object) {
		this.object = object;
	}
	@FXML private void rename(ActionEvent event) {
		if (object instanceof Photo) {
			Photo photo = (Photo) object;
			photo.setFileName(TextField.getText());
		
		} else {
			Album album = (Album) object;
			album.setFileName(TextField.getText());
		}
		exit(event);
	}
	@FXML private void exit(ActionEvent event) {
		while (lock.isLocked());
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}