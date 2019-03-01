package yt.business.singleton;

import java.lang.reflect.Constructor;

/**
 * @author yunteng
 */
public class Client {

	public static void main(String[] args) {
		try {
			Class<Singleton> classType = Singleton.class;
			Constructor<Singleton> c = classType.getDeclaredConstructor(null);
			c.setAccessible(true);
			Singleton singleton1 = (Singleton)c.newInstance();
			Thread.sleep(100);
			Singleton singleton2 = Singleton.getInstance();
			System.out.println(singleton1 == singleton2);
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			SingletonReflex singleton1 = SingletonReflex.getInstance();
			Class<SingletonReflex> classType = SingletonReflex.class;
			Constructor<SingletonReflex> c = classType.getDeclaredConstructor(null);
			c.setAccessible(true);
			SingletonReflex singleton2 = (SingletonReflex)c.newInstance();
			System.out.println(singleton1 == singleton2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
