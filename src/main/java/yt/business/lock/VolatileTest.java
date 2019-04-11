package yt.business.lock;

/**
 * @author yunteng
 */
public class VolatileTest {

	public static volatile int a = 0;

	public static void main(String[] args) {
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++){
					a ++;
				}
			};
		};

		Thread thread2 = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++){
					a ++;
				}
			};
		};
		thread1.start();
		thread2.start();
		System.out.println(a);
	}
}
