package objects;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private ArrayList<Object> directory;
	public Album (String name) {
		this.name = name;
		directory = new ArrayList<Object>();
	}
	
	/*Sets*/
	public void addSubFile (Object object) {
		directory.add(object);
	}
	
	/*Gets*/
	public ArrayList<Object> getDir() {
		//Dir := Directory
		return directory;
	}
	public Object getItem (int i) {
		return directory.get(i);
	}
}