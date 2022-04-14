package ourFilesTM;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.image.Image;
/**
 * album class
 * @author Edison & adam
 * 
 *
 */
public class Album extends FileTM{
	private ArrayList<Object> directory;
	/**
	 * creates album
	 * @param fileName
	 */
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
	/**
	 * adds file
	 * @param object
	 */
	public void addFile (Object object) {
		directory.add(object);
	}
	
	/*Gets*/
	/**
	 * return directory from arraylist
	 * @return
	 */
	public ArrayList<Object> getDir() {
		//Dir := Directory
		return directory;
	}
	/**
	 * returns directories
	 * @param i
	 * @return
	 */
	public Object getFile (int i) {
		return directory.get(i);
	}
}