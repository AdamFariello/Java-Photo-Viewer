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

public class photoEnhance {
	@FXML public ImageView ImageViewer;
	@FXML public Label lb_Name;
	@FXML public TextArea tf_caption;
	@FXML public TextArea tf_tags;
	
	public void loadImage (File file) throws Exception {
		//TODO ; this covers loading details from photo
		FileInputStream stream = new FileInputStream(file.toString());
		Image image = new Image(stream);
		ImageViewer.setImage(image);
		lb_Name.setText(file.getName());
		
		/*
		Media media = new Media(file.toString());
		String string = (String) media.getMetadata().get("Caption");
		System.out.println("test: " +string);
		*/
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
