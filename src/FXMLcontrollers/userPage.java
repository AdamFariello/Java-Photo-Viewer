package FXMLcontrollers;

import java.awt.Desktop;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import general.Serialize;
import general.lock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import ourFilesTM.Album;
import ourFilesTM.Photo;

public class userPage {
	@FXML private VBox vbox; 
	
	private File profile;
	private Album currDir;
	
	/*Initializing*/
	public void init(File profile) throws Exception{
		//User has been created for the first
		//time and requires a root directory
		this.profile = profile;
		currDir = new Album("root");
		
		if (profile.getName().equals("stock.txt")) {
			String dirPath = System.getProperty("user.dir");
			File dir = new File(dirPath + "/stockPhotos");
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				Photo photo = new Photo(files[i]);
				currDir.addFile(photo);
			}
		}
		
		loadDir();
	}
	public void init(File profile, Album root) throws Exception{
		//is setup
		//User has already used the program
		this.profile = profile;
		this.currDir = root;
		loadDir();
	}
	
	public void loadDir() throws Exception {
		//Presents folder view visual
		GridPane gridPane = null;
		for (int i = 0; i < currDir.getDir().size(); i++) {
			//TODO switch method with thumbnail
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
			
			Object object = currDir.getFile(i);
			VBox vbox_temp = new VBox();
			Label label;
			ImageView imageview = null;
			if (object instanceof Album) {
				Album album = (Album) object;
				imageview   = new ImageView(album.getImage());
				imageview.setOnMouseClicked(e-> {
					//TODO replace
					System.out.println(album.getFileName());
					
				});
				label 		= new Label(album.getFileName());
				
			} else {
				Photo photo = (Photo) object;
				imageview   = new ImageView(photo.getImage());
				imageview.setOnMouseClicked(e-> {
					//TODO replace
					System.out.println(photo.getFileName());
				});
				label 	    = new Label(photo.getFileName());
			}
			imageview.setFitHeight(100);
			imageview.setFitWidth(100);
			vbox_temp.getChildren().addAll(imageview, label);
			gridPane.add(vbox_temp, i % 5, 1);
		}
		if (gridPane != null)
			vbox.getChildren().add(gridPane);
		
	}	
	
	/*Task Bar; Handling buttons in File*/
	@FXML public void file_CreateAlbum (ActionEvent event) {
		//TODO Add functionality
	}
	@FXML public void file_AddPhoto (ActionEvent event) throws Exception{
        FileChooser fileChooser = new FileChooser();  
        fileChooser.setTitle("Open File");  
        fileChooser.getExtensionFilters().addAll(
    		new ExtensionFilter(
    			"Image Files", "*.bmp", "*.gif", "*.jpeg", "*.png", "*.jpg"
    		)
        );
        
        Stage stage = new Stage();
        stage.setTitle("Import image");  
        File selectedFile = fileChooser.showOpenDialog(stage);
        
        Photo photo = new Photo(selectedFile);
        currDir.addFile(photo);
        vbox.getChildren().clear();
        loadDir();
	}
	@FXML public void file_DeleteSelected (ActionEvent event) {
		//TODO Add functionality
	}
	
	/*Rest of Task Bar*/
	@FXML public void open (ActionEvent event) {
		/*
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/searchPhoto.fxml")
		);
		Parent root = FXMLLoader.load();
		searchPhoto searchPhoto = FXMLLoader.getController();
		searchPhoto.init();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		*/
	}
	@FXML public void rename (ActionEvent event) {
		/*
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/searchPhoto.fxml")
		);
		Parent root = FXMLLoader.load();
		searchPhoto searchPhoto = FXMLLoader.getController();
		searchPhoto.init();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		*/
	}	
	@FXML public void editPhoto (ActionEvent event) {
		//TODO
		/*
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/searchPhoto.fxml")
		);
		Parent root = FXMLLoader.load();
		searchPhoto searchPhoto = FXMLLoader.getController();
		searchPhoto.init();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		*/
	}
	@FXML public void searchPhoto (ActionEvent event) {
		/* TODO proper evaluation
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/searchPhoto.fxml")
		);
		Parent root = FXMLLoader.load();
		searchPhoto searchPhoto = FXMLLoader.getController();
		searchPhoto.init();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		*/
	}
	@FXML public void logout (ActionEvent event) throws Exception{
		while (lock.isLocked());
		Serialize<Album> serialize = new Serialize<Album>(profile);
		serialize.serialize(currDir);

		FXMLLoader FXMLLoader = new FXMLLoader(
				getClass().getResource("../FXML/login.fxml")
			);
		Parent root = FXMLLoader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}