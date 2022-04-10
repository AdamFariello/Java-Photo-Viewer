package general;

import java.io.File;

//proman := PROfile MANipulation
public class proMan {
	private static boolean lock;
	
	public static void init() {
		//false := there is no lock
		//true 	:= there is a lock, can't close application yet.
		lock = false;
	}
	
	public void switchLock() {
		// "^=" := xOR
		// (true  ^ true) = false
		// (false ^ true) = true
		lock ^= true;
	}
	
	public static boolean getLock() {
		return lock;
	}
	
	public static File getProfile(String fileName) {
		try { 
			String profileLocation =  System.getProperty("user.dir") + "/profiles";
			File dir = new File(profileLocation);
			File[] files = dir.listFiles();
			for (File file : files) 
				if (file.getName().equals(fileName + ".txt")) 
					return file;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
