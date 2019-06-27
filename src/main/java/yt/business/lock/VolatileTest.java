package yt.business.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yunteng
 */
public class VolatileTest {

	public static final AtomicInteger atomicInteger = new AtomicInteger(0);

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++){
				atomicInteger.getAndIncrement();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++){
				atomicInteger.getAndIncrement();
			}
		});
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(atomicInteger);
	}
}
