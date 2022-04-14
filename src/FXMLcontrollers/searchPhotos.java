package FXMLcontrollers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ourFilesTM.Album;
import java.awt.Desktop;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import general.Serialize;
import general.lock;
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
import ourFilesTM.Photo;

public class searchPhotos {
	private File profile;
	private Album currDir;
	
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
	/**
	 * loads images from the dir
	 * @param file
	 * @param root
	 * @throws Exception
	 */

		//TODO Work on this when serialization
	public void init(File profile, Album root) throws Exception{
		//is setup
		//User has already used the program
		this.profile = profile;
		this.currDir = root;
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
	
    @FXML
    private RadioButton andRadio;

    @FXML
    private TextField fromDate;

    @FXML
    private RadioButton orRadio;

    @FXML
    private Button searchButton;

    @FXML
    private TextField tag1;

    @FXML
    private TextField tag2;

    @FXML
    private TextField toDate;
    @FXML
    private VBox vbox;

    @FXML
    void exitPage(ActionEvent event) {
    		//sends you to user screen
    }

    @FXML
    void logout(ActionEvent event) {
    	//sends you to login screen
    }

    @FXML
    void searchPhotos(ActionEvent event) {
    	
    	//traverse through albums, looking through each photo's contents to find date/tags
    	
    	//check if radio button is clicked
    	//if and radio button is clicked, consider both tags when searching
    	//if or radio button is clicked, show either tag when searching
    	//show date range, if any
    	
    	//if fromDate textbox != null then look for photos from the two date ranges
    	//if it is null, then go on to looking for tags b/c you don't have to search for 
    	//tags AND date
    	
    	if(fromDate.getText()!=null) {
    			//display photos from range
    		if()
    		
    	}
    	
    	//if(AND radio button = clicked) 
    	//if no tag in second box, just look for photos with one tag
    	
    	//else if (OR radio button = clicked)
    	//show either of the tags displayed
    	
    	//else if there's no tags at all, display nothing
    	
    }

    @FXML
    void viewPhoto(ActionEvent event) {
    	
    	//IF IMAGE IS clicked AND view photo is clicked as well, open a separate scene with photo
    	
    }

}
