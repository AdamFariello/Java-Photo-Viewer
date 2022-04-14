package general;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/**
 * showing list of profiles
 * @author Edison & Adam
 *
 */

//proman := PROfile MANipulation
public class profileList {	
	private static File [] files;
	private static String fileLocation;
	/**
	 * constructor for profile list
	 */
	public profileList () {
		//This is covering the list of user profiles
		fileLocation = System.getProperty("user.dir") + "/profiles";
		files = loadProfileFiles();
	}
	/**
	 * loads the profile lists
	 * @return
	 */
	public File[] loadProfileFiles() {
		lock.lock();
		File dir = new File(fileLocation);
		files = dir.listFiles();
		lock.unlock();
		return files;
	}
	/**
	 * replaces all strings with .txt to ""
	 * @return
	 */
	public List<String> toList() {
		List<String> list = new ArrayList();
		for (File file: files) {
			String string = file.getName().replace(".txt","");
			list.add(string);
		}
		return list;
	}
	/**
	 * getter for file
	 * @param string
	 * @return
	 */
	public File getFile(String string) {
		for (File file : files)
			if (file.getName().equals(string + ".txt"))
				return file;
		return null;
	}
	/**
	 * getter for file location
	 * @return
	 */
	public String getDir () {
		return fileLocation;
	}
}