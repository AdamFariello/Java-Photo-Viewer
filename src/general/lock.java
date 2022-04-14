package general;

public class lock {
	private static boolean lock;
	
	public static void init() {
		//false := it is not locked
		//true 	:= it is locked
		lock = false;
	}
	
	//Originally I used xOR, but I thought
	//this would look better 
	public static void lock() {
		lock = true;
	}
	
	public static void unlock() {
		lock = false;
	}
	
	public static boolean isLocked() {
		return lock;
	}
}