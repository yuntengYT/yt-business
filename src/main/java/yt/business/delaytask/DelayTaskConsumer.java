package yt.business.delaytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * @author yunteng
 */
@Service
public class DelayTaskConsumer {

	@Autowired
	private Jedis jedis;
	@Resource
	private ScheduledExecutorService scheduledExecutorService;
	public void start() {
		//ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
		// 建立一个延时任务，10秒钟之后执行
		DelayTaskHandler delayTaskHandler = new DelayTaskHandler();
		delayTaskHandler.setJedis(jedis);
		scheduledExecutorService.scheduleWithFixedDelay(delayTaskHandler, 1, 1, TimeUnit.SECONDS);
	}

}
