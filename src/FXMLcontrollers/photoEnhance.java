package FXMLcontrollers;

import java.io.File;
import java.io.FileInputStream;
import objects.Photo;

import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

public class photoEnhance {
	@FXML public ImageView ImageViewer;
	@FXML public Label lb_Name;
	@FXML public TextArea tf_caption;
	@FXML public TextArea tf_tags;
	
	public void loadPhoto (Photo photo) throws Exception {
		ImageViewer.setImage(photo.getImage());
		lb_Name.setText(photo.getImageName());
		tf_caption.setText(photo.getCaption());
		tf_tags.setText(photo.getTags());	
	}
	
	/*Task Bar*/
	@FXML public void Exit (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void rename (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void editPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void viewPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void searchPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void scrollLeft (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void scrollRight (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void logout (ActionEvent Event) {
		//TODO Add functionality
	}
}
