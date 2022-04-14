 
package FXMLcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import ourFilesTM.Album;
import ourFilesTM.Photo;
/**
 * class to show thumbnail of image
 * @author Edison & Adam
 *
 */
public class thumbnail {
	@FXML public Label label;
	@FXML public ImageView imageview;
	@FXML public Pane pane;
	/**
	 * shows image
	 * @param album
	 */
	public void init (Album album) {
		//label.setText(album.getFileName());
		//imageview.setImage(album.getFileImage());
		
		label = new Label(album.getFileName());
		imageview = new ImageView(album.getFileImage());
		pane.getChildren().addAll(label, imageview);
	}
	/**
	 * sets label to label from file name
	 * @param photo
	 */
	public void init (Photo photo) {
		//label.setText(photo.getFileName());
		//imageview.setImage(photo.getFileImage());
	
		label = new Label(photo.getFileName());
		imageview = new ImageView(photo.getFileImage());
		pane.getChildren().addAll(label, imageview);
	}
	/**
	 * method to see if image was clicked or not
	 * @param event
	 */
	@FXML public void imageClicked (ActionEvent event) {
		System.out.println("test:");
	}
	/**
	 * getter for pane
	 * @return
	 */
	public Pane getPane() {
		return pane;
	}
}