package yt.business.delaytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.MessageFormat;
import java.util.Set;

/**
 * @author yunteng
 */

@Service
public class DelayTaskHandler implements Runnable {
	private Jedis jedis;

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	@Override
	public void run() {
		try {
			Set<String> ids = jedis.zrangeByScore("delay_task_queue", 0, System.currentTimeMillis(),
					0, 1);
			if (ids == null || ids.isEmpty()) {
				return;
			}
			for (String id : ids) {
				Long count = jedis.zrem("delay_task_queue", id);
				if (count != null && count == 1) {
					System.out.println(MessageFormat.format("发布资讯。id - {0} , timeStamp - {1} , " +
							"threadName - {2}", id, System.currentTimeMillis(), Thread.currentThread().getName()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//jedis.close();
		}
	}
}
