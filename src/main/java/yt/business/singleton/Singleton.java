package yt.business.singleton;

/**
 * @author yunteng
 */
public class Singleton {
	private static Singleton instance = null;

	private Singleton() {}

	public static Singleton getInstance() {
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}
