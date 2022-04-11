package general;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


//proman := PROfile MANipulation
public class profileList {	
	private static File [] files;
	private static String fileLocation;
	
	public profileList () {
		//This is covering the list of user profiles
		fileLocation = System.getProperty("user.dir") + "/profiles";
		files = loadProfileFiles();
	}
	
	public File[] loadProfileFiles() {
		File dir = new File(fileLocation);
		files = dir.listFiles();
		return files;
	}
	
	public List<String> toList() {
		List<String> list = new ArrayList();
		for (File file: files) {
			String string = file.getName().replace(".txt","");
			list.add(string);
		}
		return list;
	}
	
	public File getFile(String string) {
		for (File file : files)
			if (file.getName().equals(string + ".txt"))
				return file;
		return null;
	}
	
	public String getDir () {
		return fileLocation;
	}
}