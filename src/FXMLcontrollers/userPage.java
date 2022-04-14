package FXMLcontrollers;

import java.awt.Desktop;
import java.io.File;
import java.util.Optional;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import ourFilesTM.Album;
import ourFilesTM.FileTM;
import ourFilesTM.Photo;
/**
 * User page
 * @author Edison & Adam
 *
 */
public class userPage {
	@FXML private VBox vbox; 
	private File profile;
	private Album currDir;
	private ColorAdjust selectedFileColor;
	private Object selectedFile;
	
	/*Initializing*/
	/**
	 * loads the files from the dir
	 * @param file
	 * @throws Exception
	 */
	public void init(File profile) throws Exception{
		//User has been created for the first
		//time and requires a root directory
		this.profile 	  = profile;
		currDir 		  = new Album("root");
		selectedFileColor = null;
		selectedFile 	  = null;
		
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
	/**
	 * loads images from the dir
	 * @param file
	 * @param root
	 * @throws Exception
	 */
	public void init(File profile, Album root) throws Exception{
		//is setup
		//User has already used the program
		this.profile 	  = profile;
		this.currDir 	  = root;
		selectedFileColor = null;
		selectedFile 	  = null;
		loadDir();
	}
	/**
	 * loads the list of files
	 * @throws Exception
	 */
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
			ColorAdjust colorAdjust = new ColorAdjust(); 
			
			if (object instanceof Album) {
				Album album = (Album) object;
				imageview   = new ImageView(album.getImage());
				imageview.setOnMouseClicked(e-> {
					if (selectedFileColor != null) {
						//TODO replace
						selectedFileColor.setContrast(0.0);     
						selectedFileColor.setHue(0.0);     
						selectedFileColor.setSaturation(0.0);
					}
					
					colorAdjust.setContrast(5.0);     
				    colorAdjust.setHue(5.0);     
				    colorAdjust.setSaturation(5.0);   
				    selectedFileColor = colorAdjust;
				    selectedFile 	  = album;
				});
				label = new Label(album.getFileName());
				
			} else {
				Photo photo = (Photo) object;
				imageview   = new ImageView(photo.getImage());
				imageview.setOnMouseClicked(e-> {
					if (selectedFileColor != null) {
						//TODO replace
						selectedFileColor.setContrast(0.0);     
						selectedFileColor.setHue(0.0);     
						selectedFileColor.setSaturation(0.0);
					}
					
					colorAdjust.setContrast(5.0);     
				    colorAdjust.setHue(5.0);     
				    colorAdjust.setSaturation(5.0);   
				    selectedFileColor = colorAdjust;   
				    selectedFile 	  = photo;
				});
				label = new Label(photo.getFileName());
			}
			
		    imageview.setEffect(colorAdjust);
			imageview.setFitHeight(100);
			imageview.setFitWidth(100);
			
			vbox_temp.getChildren().addAll(imageview, label);
			gridPane.add(vbox_temp, i % 5, 1);
		}
		if (gridPane != null)
			vbox.getChildren().add(gridPane);
		
	}	
	
	/*Task Bar; Handling buttons in File*/
	/**
	 * method to create an album
	 * @param Event
	 */
	@FXML public void file_CreateAlbum (ActionEvent event) throws Exception {
		FXMLLoader FXMLLoader = new FXMLLoader(
			getClass().getResource("../FXML/userPage_albumCreator.fxml")
		);
		Parent parent = FXMLLoader.load();
		userPage_albumCreator userPage_albumCreator = FXMLLoader.getController();
		userPage_albumCreator.init(currDir);
		
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.showAndWait();
		
        vbox.getChildren().clear();
        loadDir();
	}
	
	/**
	 * method to add a photo to file
	 * @param Event
	 */
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
	/**
	 * delete certain photo
	 * @param Event
	 */
	@FXML public void file_DeleteSelected (ActionEvent event) throws Exception{
		if (selectedFile == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No file selected");
			alert.setHeaderText("Select a file if you wish to delete it");
		
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText("Are you want to delete this?");
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() == true && result.get() == ButtonType.OK) {
				currDir.removeFile(selectedFile);
				selectedFile = null;
				vbox.getChildren().clear();
				loadDir();
			}
		}
	}
	
	/*Rest of Task Bar*/
	/**
	 * method to view the photo
	 * @param Event
	 */
	@FXML public void open (ActionEvent Event) {
		//TODO Add functionality
	}
	/**
	 * method to rename photo
	 * @param Event
	 */
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
	
	/**
	 * method to edit photo
	 * @param Event
	 */
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
	/**
	 * method to search photo
	 * @param Event
	 */
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