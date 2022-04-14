package ourFilesTM;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.image.Image;

/**
 * album class
 * @author Edison & adam
 * 
 *
 */
public class Album extends FileTM implements Serializable {
	private static final long serialVersionUID = 2324073439905412687L;
	private ArrayList<Object> directory;
	public Album (String fileName) {
		//Inherited items
		this.fileName = fileName;
		String curDir = System.getProperty("user.dir");
		imageFile = new File(
			curDir + "/src/ourFilesTM/folderIcon.png"
		);	
		
		//unique
		directory = new ArrayList<Object>();
	}
	
	/*Sets*/
	/**
	 * Mehtod to add File
	 * @param object
	 */
	public void addFile (Object object) {
		directory.add(object);
	}
	
	/*Gets*/
	/**
	 * Getter for directory
	 * @return
	 */
	public ArrayList<Object> getDir() {
		//Dir := Directory
		return directory;
	}
	/**
	 * method to return certain directory
	 * @param i
	 * @return
	 */
	public Object getFile (int i) {
		return directory.get(i);
	}
	
	public void removeFile (Object o) {
		directory.remove(o);
	}
}