package ourFilesTM;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

import javafx.scene.image.Image;

public abstract class FileTM implements Serializable{
	private static final long serialVersionUID = 5416203112695730536L;
	protected String fileName;
	protected File imageFile;

	public String getFileName() {
		return fileName;
	}
	public File getFile() {
		return imageFile;
	}
	public Image getImage() throws Exception {
		//Image, and all javafx aren't serializable
		FileInputStream stream = new FileInputStream(
			imageFile.toString()
		);
		return (new Image(stream));
	}
}