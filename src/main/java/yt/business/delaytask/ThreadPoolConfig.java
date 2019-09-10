package yt.business.delaytask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author yunteng
 */
@Configuration
public class ThreadPoolConfig {


	@Bean
	public ScheduledExecutorService getScheduledExecutorService(){
		return Executors.newScheduledThreadPool(100);
	}
}
