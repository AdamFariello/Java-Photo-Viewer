package general;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


//proman := PROfile MANipulation
public class proMan {
	private static boolean lock;
	
	public static void init() {
		//false := there is no lock
		//true 	:= there is a lock, can't close application yet.
		lock = false;
	}
	
	public static void switchLock() {
		// "^=" := xOR
		// (true  ^ true) = false
		// (false ^ true) = true
		lock ^= true;
	}
	
	public static boolean getLock() {
		return lock;
	}
	
	public static List<String> getProfileNames(File [] files) {
		List<String> list = new ArrayList();
		for (File file: files)
			list.add(file.getName());
		
		return list;
	}
	
	public static File[] getProfiles() {
		String profileLocation =  System.getProperty("user.dir") + "/profiles";
		File dir = new File(profileLocation);
		return dir.listFiles();
	}
	
	public static File checkProfile(String fileName) {
		File[] files = getProfiles();
		for (File file : files)
			if (file.getName().equals(fileName + ".txt")) 
				return file;
		return null;
	}
	
	public static void createProfile() {
		//TODO
	}
}
