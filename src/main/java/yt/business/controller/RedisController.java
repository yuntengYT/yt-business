package yt.business.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import yt.business.redis.RedisConfig;
import yt.business.redis.ValueOperationsCache;

import java.io.IOException;

/**
 * @author yunteng
 */
@RestController
@Configuration
public class RedisController {
	@Autowired
	private ValueOperationsCache valueOperationsCache;
	@Autowired
	private Jedis jedis;

	@RequestMapping(value = "redis",method = RequestMethod.GET)
	public String setRedis(){
		//valueOperationsCache.set("hello","redis");
		jedis.zadd( "hackers" ,  1940 ,  "Alan Kay" );

		jedis.zadd( "hackers" ,  1953 ,  "Richard Stallman");

		jedis.zadd( "hackers" ,  1965 ,  "Yukihiro Matsumoto");

		jedis.zadd( "hackers" ,  1916 ,  "Claude Shannon");

		jedis.zadd( "hackers" ,  1969 ,  "Linus Torvalds");

		jedis.zadd( "hackers" ,  1912 ,  "Alan Turing" );

		System.out.println(jedis.zcard( "hackers" ));

		// 元素下标

		System.out.println(jedis.zscore( "hackers" ,  "hackers" ));

		// 集合子集

		System.out.println(jedis.zrange( "hackers" ,  0 , - 1 ));

		System.out.println(jedis.zcount( "hackers" ,  9.5 ,  10.5 ));

		// 整个集合值

		System.out.println(jedis.zrange( "hackers" ,  0 , - 1 ));
		return valueOperationsCache.get("hello");
	}

	public static void main(String[] args) throws IOException {
		String luaScript = "local key = \"rate.limit:\" .. KEYS[1] " +
				"local limit = ARGV[1] " +
				"local expire = ARGV[2] " +
				"local val = redis.call('incr',key) " +
				"if val == 1 then " +
				"    redis.call('expire',key,tonumber(expire)) " +
				"    return 1; " +
				"   end " +
				" if val > tonumber(limit) then " +
				" return 0; " +
				"end " +
				"return 1; ";
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("yt123");
		for (int i = 0; i < 20; i++) {
			Long eval = (Long)jedis.eval(luaScript, 1, "key", "10", "60");
			if (eval != null && eval == 0) {
				System.out.println("超了");
			} else {
				System.out.println(eval);
			}
		}
	}
}
