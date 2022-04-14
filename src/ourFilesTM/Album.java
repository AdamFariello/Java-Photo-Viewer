package ourFilesTM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.image.Image;

public class Album extends FileTM implements Serializable {
	private static final long serialVersionUID = 2324073439905412687L;
	private ArrayList<Object> directory;
	public Album (String fileName) {
		//Inherited items
		this.fileName = fileName;
		String curDir = System.getProperty("user.dir");
		fileImage = new Image(
			"file: " + curDir + "/src/ourFilesTM/folderIcon.png"
		);	
		
		//unique
		directory = new ArrayList<Object>();
	}
	
	/*Sets*/
	public void addFile (Object object) {
		directory.add(object);
	}
	
	/*Gets*/
	public ArrayList<Object> getDir() {
		//Dir := Directory
		return directory;
	}
	public Object getFile (int i) {
		return directory.get(i);
	}
}