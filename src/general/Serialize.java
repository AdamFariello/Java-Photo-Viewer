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

public class Serialize <T> implements Serializable{
	private static final long serialVersionUID = 3438982363426716349L;
	private File profile;
	
	/*Method to interate with privates*/
	public Serialize() {
		this.profile = null;
	}
	public Serialize(File profile) {
		this.profile = profile;
	}
	public T deepCopy(T t) {
		//TODO Make these process their own methods
		while(lock.isLocked());
		lock.lock();
		
		T t2 = null;
		try { 
			//Serialize
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	        objectOutputStream.writeObject(t);
	     
	        //Deserialized
	        ByteArrayInputStream bais = new ByteArrayInputStream(
					byteArrayOutputStream.toByteArray()
			);
	        ObjectInputStream objectInputStream = new ObjectInputStream(bais);
	        t2 = (T) objectInputStream.readObject();
		} catch (Exception e) {
			System.out.println("[DEBUG] Error in serializeAlt.serialize");
			System.out.println(e);
		}	
		lock.unlock();	
		return t2;
	}
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
			System.out.println("[DEBUG] serializeAlt.serializeToFile");
			System.out.println(e);
		}
		lock.unlock();
	}
	public T deserialize() {
		while(lock.isLocked());
		lock.lock();
		try {
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(profile)
			);
			return (T) ois.readObject();
		} catch (Exception e) {
			System.out.println("[DEBUG] Serialize.deserialize");
			System.out.println(e);
		}
		lock.unlock();
		return null;
	}
}