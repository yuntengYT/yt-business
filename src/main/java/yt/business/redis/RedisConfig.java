package yt.business.redis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.text.SimpleDateFormat;

/**
 * RedisConfig
 *
 * @author shichunyang
 */
@Configuration
public class RedisConfig {

	@Bean("redisSetting")
	@ConfigurationProperties(prefix = "redis")
	public RedisDO redisDO() {
		return new RedisDO();
	}

	@Bean("jedisPoolConfig")
	public JedisPoolConfig getJedisPoolConfig(@Qualifier("redisSetting") RedisDO redisDO) {
		return RedisUtil.getJedisPoolConfig(redisDO.getMinIdle(), redisDO.getMaxIdle(), redisDO.getMaxTotal());
	}

	@Bean("jedisConnectionFactory")
	public JedisConnectionFactory getJedisConnectionFactory(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig, @Qualifier("redisSetting") RedisDO redisDO) {
		return RedisUtil.getJedisConnectionFactory(jedisPoolConfig, redisDO.getHostName(), redisDO.getPort(), redisDO.getPassword(), redisDO.getDatabase());
	}

	@Bean("stringRedisSerializer")
	public StringRedisSerializer getStringRedisSerializer() {
		return new StringRedisSerializer();
	}

	@Bean("genericJackson2JsonRedisSerializer")
	public GenericJackson2JsonRedisSerializer getGenericJackson2JsonRedisSerializer() {
		return new GenericJackson2JsonRedisSerializer(new ObjectMapper() {
			{
				disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		});
	}

	@Bean("redisTemplate")
	public RedisTemplate<String, String> getRedisTemplate(
			@Qualifier("stringRedisSerializer") StringRedisSerializer stringRedisSerializer,
			@Qualifier("genericJackson2JsonRedisSerializer") GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer,
			@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory

	) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		redisTemplate.setKeySerializer(stringRedisSerializer);
		redisTemplate.setValueSerializer(stringRedisSerializer);
		redisTemplate.setHashKeySerializer(stringRedisSerializer);
		redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);

		return redisTemplate;
	}

	@Bean("valueOperationsCache")
	public ValueOperationsCache getValueOperationsCache(@Qualifier("redisTemplate") RedisTemplate<String, String> redisTemplate) {
		return new ValueOperationsCache(redisTemplate);
	}

	@Bean("jedis")
	public static Jedis getJedis(@Qualifier("redisSetting") RedisDO redisDO){
		JedisPool pool = null;
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		//最大连接数
		poolConfig.setMaxTotal(Integer.parseInt( redisDO.getMaxTotal().toString()));
		//最大空闲连接数
		poolConfig.setMaxIdle(Integer.parseInt( redisDO.getMaxIdle().toString()));
		//最小空闲连接数
		poolConfig.setMinIdle(Integer.parseInt( redisDO.getMinIdle().toString()));
		pool = new JedisPool(poolConfig, redisDO.getHostName(),Integer.parseInt( redisDO.getPort()
				.toString()),2000,redisDO.getPassword());
		return pool.getResource();
	}
}
