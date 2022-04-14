package ourFilesTM;

import javafx.scene.image.Image;
/**
 * 
 * @author Edison & Adam
 *
 */
public abstract class FileTM {
	protected String fileName;
	protected Image fileImage;
	/**
	 * getter for file name,
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * getter for file image
	 * @return
	 */
	public Image getFileImage() {
		return fileImage;
	}
}
