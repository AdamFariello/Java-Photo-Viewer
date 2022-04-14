package ourFilesTM;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javafx.scene.image.Image;
/**
 * Photo Class
 * @author Edison & Adam
 *
 */
public class Photo extends FileTM implements Serializable{
	//The reason why the tags are String is that 
	//the tag data will be given as: "person:Ana person:Albert".
	//Two split methods can be applied, hence the tag. 
	private String caption;
	private LinkedList<String[]> tags;
	private Calendar calendar;

	/**
	 * Gets file name, image file
	 * tags, and date of photo
	 * @param file
	 * @throws Exception
	 */

	public Photo (File file) throws Exception {
		//Inherited
		fileName = file.getName();
		imageFile = file;
		
		//unique
		caption = "";
		tags = new LinkedList<String[]>();
		calendar = calendar.getInstance();
		calendar.set(Calendar.MILLISECOND,0);
	}
	
	/*Sets/Add Methods*/
	/**
	 * "This" for caption
	 * @param caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * "This" method for tags
	 * @param tags
	 */
	public void addTags (String tags) {
		String [] temp = tags.split(" ");
		for (int i = 0; i < temp.length; i++)
			this.tags.add(temp[i].split(":"));
	}
	/**
	 * Method for update
	 */
	public void updateDate() {
		calendar = calendar.getInstance();
	}
	
	/*Get Methods*/
	/**
	 * method to return date
	 * @return
	 */
	public Date getDate() {
		return calendar.getTime();
	}
	/**
	 * Getters for tags
	 * @return
	 */
	public String getTags() {
		String string = "";
		for (int i = 0; i < tags.size(); i++)
			string += tags.get(i).toString();	
		return string;
	}
	/**
	 * Getter for caption
	 * @return
	 */
	public String getCaption() {
		return caption;
	}
}