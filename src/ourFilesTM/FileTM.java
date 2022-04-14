package ourFilesTM;

import java.io.File;
import java.io.Serializable;

import javafx.scene.image.Image;

public abstract class FileTM implements Serializable{
	private static final long serialVersionUID = 5416203112695730536L;
	protected String fileName;
	protected File fileImage;
	
	//Image, and all javafx aren't serializable
	//protected Image fileImage;

	public String getFileName() {
		return fileName;
	}
	public File getFileImage() {
		return fileImage;
	}
	public Image getImage() {
		Image image = new Image(
			fileImage.getAbsolutePath()
		);
		return image;
	}
}
