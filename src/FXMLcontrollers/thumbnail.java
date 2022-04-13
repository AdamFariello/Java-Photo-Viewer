package FXMLcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import ourFilesTM.Album;
import ourFilesTM.Photo;

public class thumbnail {
	@FXML public Label label;
	@FXML public ImageView imageview;
	@FXML public Pane pane;
	
	public void init (Album album) {
		imageview.setImage(album.getFileImage());
		label.setText(album.getFileName());
	}
	public void init (Photo photo) {
		imageview.setImage(photo.getFileImage());
		label.setText(photo.getFileName());
	}
	
	@FXML public void imageClicked (ActionEvent event) {
		System.out.println("test:");
	}
	
	public Pane getPane() {
		return pane;
	}
}
