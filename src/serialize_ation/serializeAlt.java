package serialize_ation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import general.lock;
/**
 * other serializaton
 * @author Edison & Adam
 *
 * @param <T>
 */
public class serializeAlt <T>{
	
	/*Regular Methods*/
	/**
	 * unserializes
	 */
	public serializeAlt() {}
	public T deepClone(T t) {
		return (T) unSerialize(serialize(t));
	}
	/**
	 * Serializes image to file
	 * @param profile
	 * @param t
	 */
	public void serializeToFile(File profile, T t) {
		//The T will be a LinkedList, but still applicable
		while(lock.isLocked());
		lock.lock();
		try {
			//Clearing the file content, arguable 
			//overkill, but not enough time.
			profile.delete();
			profile.createNewFile();
			
			FileWriter writer = new FileWriter(profile.getAbsoluteFile());
			writer.write(serialize(t).toString());
			writer.close();
			//System.out.println("[DEBUG] Success!");
		} catch (Exception e) {
			System.out.println("[DEBUG] serializeAlt.serializeToFile");
			System.out.println(e);
		}
		lock.unlock();
	}
	
	/*These methods won't be handled directly*/
	/**
	 * method for serializing
	 * @param t
	 * @return
	 */
	private ByteArrayOutputStream serialize(T t) {
		try { 
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	        objectOutputStream.writeObject(t);
	        return byteArrayOutputStream;
		} catch (Exception e) {
			System.out.println("[DEBUG] Error in serializeAlt.serialize");
			System.out.println(e);
		}
		return null;
	}
	/**
	 * method to unserialize
	 * @param byteArrayOutputStream
	 * @return
	 */
	private T unSerialize(ByteArrayOutputStream byteArrayOutputStream) {
		
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(
					byteArrayOutputStream.toByteArray()
			);
	        ObjectInputStream objectInputStream = new ObjectInputStream(bais);
	        return (T) objectInputStream.readObject();
			
		} catch (Exception e) {
			System.out.println("[DEBUG] Error in serializeAlt.unSerialize");
			System.out.println(e);
		}
		return null;
	}

}
/* Scrap Code
public static  T deepClone(T object){
  try {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(bais);
          return (T) objectInputStream.readObject();
    }
    catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}

*/