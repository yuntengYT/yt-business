package yt.business.delaytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author yunteng
 */
@Service
public class DelayTaskProducer {

	@Autowired
	private Jedis jedis;

	public void producer(String newsId, long timeStamp) {

		try {
			jedis.zadd("delay_task_queue",timeStamp,newsId);
		}catch (Exception e) {
			jedis.close();
		}
	}
}
