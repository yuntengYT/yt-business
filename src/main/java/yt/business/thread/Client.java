package yt.business.thread;

import yt.business.thread.service.AddNumService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) {
		AddNumService addNumService = new AddNumService();
		Future<Integer> aa = ThreadPoolExecutorSingleton.getThreadPoolExecutor().submit(addNumService);
		Future<Integer> bb = ThreadPoolExecutorSingleton.getThreadPoolExecutor().submit(addNumService);
		Future<Integer> cc = ThreadPoolExecutorSingleton.getThreadPoolExecutor().submit(addNumService);
		Future<Integer> dd = ThreadPoolExecutorSingleton.getThreadPoolExecutor().submit(addNumService);
		try {
			System.out.println(aa.get() + 1);
			System.out.println(bb.get() + 2);
			System.out.println(cc.get() + 3);
			System.out.println(dd.get() + 4);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}
}
