package general;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Edison & Adam
 * Serializes data
 * @param <T>
 */
public class Serialize <T> implements Serializable{
	private static final long serialVersionUID = 3438982363426716349L;
	private File profile;
	
	/**
	 * Gets this current profile
	 * @param profile
	 */
	public Serialize(File profile) {
		this.profile = profile;
	}
	/**
	 * Serializes 
	 * @param t
	 */
	public void serialize(T t) {
		while(lock.isLocked());
		lock.lock();
		try {
			//Wiping File (Optional?)
			profile.delete();
			profile.createNewFile();
			
			ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(profile)
			);
			oos.writeObject(t);
		} catch (Exception e) {
			System.out.println("[DEBUG] serializeAlt.serialize");
			System.out.println(e);
		}
		lock.unlock();
	}
	/**
	 * Method to deseralize
	 * @return
	 */
	public T deserialize() {
		while(lock.isLocked());
		lock.lock();
		T t = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(profile)
			);
			t = (T) ois.readObject();
		} catch (Exception e) {
			//Catches empty list or bad serializations
		}
		lock.unlock();
		return t;
	}
}