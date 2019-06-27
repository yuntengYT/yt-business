package yt.business.thread;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 双重检查锁的单例模式
 * 创建唯一的线程池
 *
 * @author yunteng
 */
public class ThreadPoolExecutorSingleton {

	/**
	 * corePoolSize 池中所保存的线程数，包括空闲线程。
	 */
	private static final int CORE_POOL_SIZE = 100;

	/**
	 * maximumPoolSize - 池中允许的最大线程数(采用LinkedBlockingQueue时没有作用)。
	 */
	private static final int MAXIMUM_POOL_SIZE = 100;

	/**
	 * keepAliveTime -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，线程池维护线程所允许的空闲时间
	 */
	private static final int KEEP_ALIVE_TIME = 100;

	/**
	 * 初始化大小
	 */
	private static final int INIT_CAPACITY = 1000;

	/**
	 * 线程池对象
	 */
	private volatile static ExecutorService executorService = null;

	/**
	 * 构造方法私有化
	 */
	private ThreadPoolExecutorSingleton() {
	}

	/**
	 * 获取线程池
	 *
	 * @return
	 */
	public static ExecutorService getThreadPoolExecutor() {
		if (Objects.isNull(executorService)) {
			synchronized (ThreadPoolExecutorSingleton.class) {
				if (Objects.isNull(executorService)) {
					executorService = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME,
							TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(INIT_CAPACITY),
							new ThreadPoolExecutor.DiscardOldestPolicy());
				}
			}
		}

		return executorService;
	}


}
