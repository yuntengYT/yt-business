package yt.business.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhangjiawei
 */
@Slf4j
@Component
public class PrintTask implements Runnable {

	private static boolean taskRunning = false;

	public void printTask() {
		Thread thread = new Thread(this);
		try {
			thread.start();
		} catch (Exception e) {
			log.error("An unknown exception occurred while executing the task ，error:{}", e);
		}
	}

	@Override
	public void run() {

		synchronized (PrintTask.class) {
			if (taskRunning) {
				log.info("car classify task is running , don't need to run again");
				return;
			} else {
				taskRunning = true;
			}
		}

		try {
			log.info("start to insert cars information and classify");
			long tf = System.currentTimeMillis();
			Thread.sleep(8000);
			long tt = System.currentTimeMillis();

			log.info("classify successfully , spent {} ms", (tt - tf));

		} catch (Exception e) {
			log.error("An unknown exception occurred while executing the task ，error:{}", e);
		} finally {
			taskRunning = false;
		}
	}
}
