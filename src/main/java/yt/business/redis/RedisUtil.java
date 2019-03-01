package yt.business.redis;

import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 工具类
 *
 * @author shichunyang
 */
public class RedisUtil {
	/**
	 * 初始化 redis连接池
	 *
	 * @param jedisPoolConfig redis连接池对象
	 */
	public static void initJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {

		// 获取连接的最大等待时间(单位毫秒)
		jedisPoolConfig.setMaxWaitMillis(10_000L);
		// 逐出扫描的时间间隔(毫秒)
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(300_000L);
		// 连接最小生存时间(毫秒)
		jedisPoolConfig.setMinEvictableIdleTimeMillis(300_000L);
		// 空闲时检测连接
		jedisPoolConfig.setTestWhileIdle(true);
		// 申请连接时是否检测
		jedisPoolConfig.setTestOnBorrow(true);
		// 归还连接时是否检测
		jedisPoolConfig.setTestOnReturn(false);
	}

	/**
	 * 获取 JedisPoolConfig
	 *
	 * @param minIdle  最小空闲连接
	 * @param maxIdle  最大空闲连接
	 * @param maxTotal 最大连接
	 * @return JedisPoolConfig对象
	 */
	public static JedisPoolConfig getJedisPoolConfig(
			int minIdle,
			int maxIdle,
			int maxTotal
	) {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMinIdle(minIdle);
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxTotal(maxTotal);

		// 初始化
		initJedisPoolConfig(jedisPoolConfig);

		return jedisPoolConfig;
	}

	/**
	 * 获取JedisConnectionFactory对象
	 *
	 * @param jedisPoolConfig 连接池对象
	 * @param hostName        主机
	 * @param port            端口
	 * @param password        密码
	 * @param database        数据库
	 * @return JedisConnectionFactory对象
	 */
	public static JedisConnectionFactory getJedisConnectionFactory(
			JedisPoolConfig jedisPoolConfig,
			String hostName,
			int port,
			String password,
			int database
	) {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostName, port);
		redisStandaloneConfiguration.setDatabase(database);
		redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

		JedisClientConfiguration.DefaultJedisClientConfigurationBuilder defaultJedisClientConfigurationBuilder = (JedisClientConfiguration.DefaultJedisClientConfigurationBuilder) JedisClientConfiguration.builder();
		defaultJedisClientConfigurationBuilder.usePooling();
		defaultJedisClientConfigurationBuilder.poolConfig(jedisPoolConfig);

		return new JedisConnectionFactory(redisStandaloneConfiguration, defaultJedisClientConfigurationBuilder.build());
	}
}
