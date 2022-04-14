package FXMLcontrollers;

import java.io.File;

import general.Serialize;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ourFilesTM.Album;
import ourFilesTM.Photo;

public class userPage {
	@FXML private VBox vbox; 
	
	private File file;
	private Album root;
	
	/*Initializing*/
	public void init(File file) throws Exception{
		//User has been created for the first
		//time and requires a root directory
		this.file = file;
		root = new Album("root");
		loadDir();
	}
	public void init(File file, Album root) throws Exception{
		//is setup
		//User has already used the program
		this.file = file;
		this.root = root;
		loadDir();
	}
	
	public void loadDir() throws Exception {
		String dirPath = System.getProperty("user.dir");
		File dir = new File(dirPath + "/stockPhotos");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			Photo photo = new Photo(files[i]);
			root.addFile(photo);
		}
		
		//Presents folder view visual
		GridPane gridPane = null;
		for (int i = 0; i < root.getDir().size(); i++) {
			if (i % 5 == 0) {
				if (i != 0) 
					vbox.getChildren().add(gridPane);
				
				FXMLLoader FXMLLoader = new FXMLLoader(
						getClass().getResource("../FXML/userPage_GridPane.fxml")
				);
				FXMLLoader.load();
				userPage_GridPane userPage_GridPane = 
					FXMLLoader.getController();
				
				gridPane = userPage_GridPane.getGridPane();
			}
			
			Object object = root.getFile(i);
			VBox vbox_temp = new VBox();
			Label label;
			ImageView imageview = null;
			if (object instanceof Album) {
				Album album = (Album) object;
				imageview   = new ImageView(album.getFileImage());
				imageview.setOnMouseClicked(e-> {
					//TODO replace
					System.out.println("test");
				});
				label 		= new Label(album.getFileName());
				vbox_temp.getChildren().addAll(imageview, label);
			} else {
				Photo photo = (Photo) object;
				imageview   = new ImageView(photo.getFileImage());
				imageview.setOnMouseClicked(e-> {
					//TODO replace
					System.out.println("test");
				});
				label 	    = new Label(photo.getFileName());
			}
			imageview.setFitHeight(100);
			imageview.setFitWidth(100);
			vbox_temp.getChildren().addAll(imageview, label);
			gridPane.add(vbox_temp, i % 5, 1);
		}
		vbox.getChildren().add(gridPane);
		
	}	
	
	/*Task Bar; Handling buttons in File*/
	@FXML public void file_CreateAlbum (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void file_AddPhoto (ActionEvent Event) {
		//TODO Add functionality
	}
	@FXML public void file_DeleteSelected (ActionEvent Event) {
		//TODO Add functionality
	}
	
	/*Rest of Task Bar*/
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