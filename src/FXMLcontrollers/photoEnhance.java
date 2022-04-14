package FXMLcontrollers;

import java.io.File;
import java.io.FileInputStream;

import general.Serialize;
import general.lock;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import ourFilesTM.Album;
import ourFilesTM.Photo;
/**
 * Method to show details of photos
 * @author Edison & Adam
 *
 */
public class photoEnhance {
	@FXML private ImageView ImageViewer;
	@FXML private Label lb_Name;
	@FXML private TextArea tf_caption, tf_tags;
	private File profile;
	private Album currDir;
	int location;
	/**
	 * method to load and show image
	 * @param photo
	 * @throws Exception
	 */
	public void loadPhoto (Photo photo, File profile, Album currDir) throws Exception {
		ImageViewer.setImage(photo.getImage());
		lb_Name.setText(photo.getFileName());
		tf_caption.setText(photo.getCaption());
		tf_tags.setText(photo.getTags());
		
		this.profile = profile;
		this.currDir = currDir;
		location = currDir.locateFile(photo);
	}
	
	/*Task Bar*/
	/**
	 * method to exit
	 * @param Event
	 */
	@FXML public void exit (ActionEvent Event) throws Exception {
		while (lock.isLocked());
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/userPage.fxml")
		);
		Parent root = FXMLLoader.load();
		userPage userPage = FXMLLoader.getController();
		userPage.init(profile, currDir);
		
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)Event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	/**
	 * method to scroll left
	 * @param Event
	 */
	@FXML public void scrollLeft (ActionEvent Event) throws Exception{
		//TODO Add functionality
		location -= 1;
		if (location >= 0) {
			Object object = currDir.getFile(location);
			if (object instanceof Photo) {
				Photo photo = (Photo) object;
				ImageViewer.setImage(photo.getImage());
				lb_Name.setText(photo.getFileName());
				tf_caption.setText(photo.getCaption());
				tf_tags.setText(photo.getTags());
			
			} else {
				Album album = (Album) object;
				ImageViewer.setImage(album.getImage());
				lb_Name.setText(album.getFileName());
				tf_caption.setText("No caption available");
				tf_tags.setText("No tags available");
			}	
		} else {
			location = 0;
		}
	}
	/**
	 * method to scroll right
	 * @param Event
	 */
	@FXML public void scrollRight (ActionEvent Event) throws Exception{
		//TODO Add functionality
		location += 1;
		if (location < currDir.getDir().size()) {
			Object object = currDir.getFile(location);
			if (object instanceof Photo) {
				Photo photo = (Photo) object;
				ImageViewer.setImage(photo.getImage());
				lb_Name.setText(photo.getFileName());
				tf_caption.setText(photo.getCaption());
				tf_tags.setText(photo.getTags());
			
			} else {
				Album album = (Album) object;
				ImageViewer.setImage(album.getImage());
				lb_Name.setText(album.getFileName());
				tf_caption.setText("No caption available");
				tf_tags.setText("No tags available");
			}	
		} else {
			location = currDir.getDir().size() - 1;
		}
	}
	/**
	 * method to logout of page and go back to previous scene
	 * @param Event
	 */
	@FXML public void logout (ActionEvent Event) throws Exception{
		while (lock.isLocked());
		Serialize<Album> serialize = new Serialize<Album>(profile);
		serialize.serialize(currDir);

		FXMLLoader FXMLLoader = new FXMLLoader(
				getClass().getResource("../FXML/login.fxml")
			);
		Parent root = FXMLLoader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)Event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}