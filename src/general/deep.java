package general;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class deep <T>{
	public T copy (T t) {
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
	        System.out.println(t);
	        System.out.println(t2);
		} catch (Exception e) {
			System.out.println("[DEBUG] Error in serializeAlt.serialize");
			System.out.println(e);
		}	
		
		lock.unlock();	
		return t2;
	}
}