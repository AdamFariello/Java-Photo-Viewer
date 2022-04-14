package FXMLcontrollers;

import java.io.File;
import java.io.FileInputStream;

import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import ourFilesTM.Photo;
/**
 * Method to show details of photos
 * @author Edison & Adam
 *
 */
public class photoEnhance {
	@FXML public ImageView ImageViewer;
	@FXML public Label lb_Name;
	@FXML public TextArea tf_caption;
	@FXML public TextArea tf_tags;
	/**
	 * method to load and show image
	 * @param photo
	 * @throws Exception
	 */
	public void loadPhoto (Photo photo) throws Exception {
		ImageViewer.setImage(photo.getImage());
		lb_Name.setText(photo.getFileName());
		tf_caption.setText(photo.getCaption());
		tf_tags.setText(photo.getTags());	
	}
	
	/*Task Bar*/
	/**
	 * task bar exit scene function
	 * @param Event
	 */
	@FXML public void Exit (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to rename photo
	 * @param Event
	 */
	@FXML public void rename (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to edit the photo
	 * @param Event
	 */
	@FXML public void editPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to view the image of the photo
	 * @param Event
	 */
	@FXML public void viewPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to search for photos based on certain criteria
	 * @param Event
	 */
	@FXML public void searchPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to scroll left
	 * @param Event
	 */
	@FXML public void scrollLeft (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to scroll right
	 * @param Event
	 */
	@FXML public void scrollRight (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to logout of page and go back to previous scene
	 * @param Event
	 */
	@FXML public void logout (ActionEvent Event) {
		//TODO Add functionality
	}
}