package serialize_ation;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
/**
 * serialization
 * @author Edison & adam
 *
 */
public class Serialize {
	private static final long serialVersionUID = -1232683273224L;
	private int width, height;
	private int[][] pixels;

	/**
	 * converts image to serializable state
	 * @param image
	 */
	public Serialize(Image image) {
		width = (int)image.getWidth();
		height = (int)image.getHeight();
		pixels = new int[width][height];
		
		PixelReader reader = image.getPixelReader();
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				pixels[x][y] = reader.getArgb(x, y);
	}

	/**
	 * converts text back into an image
	 * @return
	 */
	public Image getImage() {
		WritableImage image = new WritableImage(width, height);
		
		PixelWriter w = image.getPixelWriter();
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				w.setArgb(i, j, pixels[i][j]);
		
		return image;
	}
	/**
	 * getter for width
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	
/**
 * getter for height
 * @return
 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * getter for pixels of image
	 * @return
	 */
	public int[][] getPixels() {
		return pixels;
	}
	
	/** TODO unlock method after finding "SerializableImage"
	 * check if two images are equal
	 * @param image	The serializable image to be compared to
	 * @return true if they're equal, else false
	public boolean equals(SerializableImage image) {
		if (width != image.getWidth() || height != image.getHeight())
			return false;
		
		for (int currentRow = 0; currentRow < width; currentRow++)
			for (int currentColumn = 0; currentColumn < height; currentColumn++)
				if (pixels[currentRow][currentColumn] != image.getPixels()[currentRow][currentColumn])
					return false;
		
		return true;
	}
	*/
}
