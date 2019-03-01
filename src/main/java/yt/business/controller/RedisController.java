package yt.business.controller;

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
}
