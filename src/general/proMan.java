package general;

import java.io.File;

//proman := PROfile MANipulation
public class proMan {
	public File getProfile(String fileName) {
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
