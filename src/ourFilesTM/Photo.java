package ourFilesTM;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javafx.scene.image.Image;

public class Photo extends FileTM implements Serializable{
	//The reason why the tags are String is that 
	//the tag data will be given as: "person:Ana person:Albert".
	//Two split methods can be applied, hence the tag. 
	private String caption;
	private LinkedList<String[]> tags;
	private Calendar calendar;
	
	public Photo (File file) throws Exception {
		//Inherited
		FileInputStream stream = new FileInputStream(file.toString());
		fileImage = new Image(stream);
		fileName = file.getName();
		
		//unique
		caption = "";
		tags = new LinkedList<String[]>();
		calendar = calendar.getInstance();
		calendar.set(Calendar.MILLISECOND,0);
	}
	
	/*Sets/Add Methods*/
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public void addTags (String tags) {
		String [] temp = tags.split(" ");
		for (int i = 0; i < temp.length; i++)
			this.tags.add(temp[i].split(":"));
	}
	public void updateDate() {
		calendar = calendar.getInstance();
	}
	
	/*Get Methods*/
	public Date getDate() {
		return calendar.getTime();
	}
	public String getTags() {
		String string = "";
		for (int i = 0; i < tags.size(); i++)
			string += tags.get(i).toString();	
		return string;
	}
	public String getCaption() {
		return caption;
	}
}
