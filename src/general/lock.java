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
		System.out.println(
			Thread.currentThread().getStackTrace()[2].getClassName()
		);
		lock = true;
	}
	
	public static void unlock() {
		System.out.println(
				Thread.currentThread().getStackTrace()[2].getClassName()
		);
		lock = false;
	}
	
	public static boolean isLocked() {
		return lock;
	}
}