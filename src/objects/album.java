package objects;

import java.util.ArrayList;
import java.util.LinkedList;

public class album {
	private String name;
	private ArrayList<Object> subDirectory;
	public album (String name) {
		this.name = name;
		subDirectory = new ArrayList<Object>();
	}
	
	public Object getItem (int i) {
		return subDirectory.get(i);
	}	
	public void addSubFile (Object object) {
		subDirectory.add(object);
	}
}