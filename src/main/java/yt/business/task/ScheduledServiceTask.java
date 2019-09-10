package yt.business.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import yt.business.thread.PrintTask;

/**
 * @author yunteng
 */
@Slf4j
@Component
public class ScheduledServiceTask {

	@Autowired
	private PrintTask printTask;

	//@Scheduled(cron = "0/5 * * * * ?")
	public void scheduled(){
		log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
		printTask.printTask();
	}
}
