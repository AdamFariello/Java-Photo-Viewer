package serialize_ation;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Serialize {
	private static final long serialVersionUID = -1266447099158556616L;
	private int width, height;
	private int[][] pixels;
	
	/**
	 * Converts an Image object to a serializable representation
	 * @param image the image to be converted
	 */
	public Serialize(Image image) {
		width = (int)image.getWidth();
		height = (int)image.getHeight();
		pixels = new int[width][height];
		
		PixelReader reader = image.getPixelReader();
		for (int currentWidth = 0; currentWidth < width; currentWidth++)
			for (int currentHeight = 0; currentHeight < height; currentHeight++)
				pixels[currentWidth][currentHeight] = reader.getArgb(currentWidth, currentHeight);
	}
	
	/**
	 * Converts the serialized representation back to an Image
	 * @return Image object
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
	 * Gets the width of this image
	 * @return the width of this image
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets the height of this image
	 * @return the height of this image
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * 2D Pixels array accessor
	 * @return a 2D int array representing the color values
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
