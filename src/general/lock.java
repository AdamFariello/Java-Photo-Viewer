package general;

public class lock {
	private static boolean lock;
	
	public static void init() {
		//false := there is no lock
		//true 	:= there is a lock, can't close application yet.
		lock = false;
	}
	
	public static void switchLock() {
		// "^=" := xOR
		// (true  ^= true) = false
		// (false ^= true) = true
		lock ^= true;
	}
	
	public static boolean getLock() {
		return lock;
	}
}
