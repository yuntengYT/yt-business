package yt.business.redis;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * BaseRedisTemplate
 *
 * @author shichunyang
 */
public class BaseRedisTemplate {

	private RedisTemplate<String, String> redisTemplate;

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 移除多个key
	 */
	public void delete(String... keys) {
		redisTemplate.delete(Arrays.asList(keys));
	}

	/**
	 * 检查key是否存在
	 */
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 设置key的有效期(单位毫秒)
	 */
	public boolean expire(String key, final long timeout) {
		return redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
	}

	/**
	 * 设置过期时间
	 */
	public boolean expireAt(String key, Date date) {
		return redisTemplate.expireAt(key, date);
	}

	/**
	 * 获取key的生存周期
	 */
	public long getExpire(final String key) {
		return redisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
	}

	/**
	 * 按表达式获取key的集合
	 */
	public Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	/**
	 * 将指定的key移到指定的库中
	 */
	public boolean move(final String key, final int dbIndex) {
		return redisTemplate.move(key, dbIndex);
	}

	/**
	 * 重命名
	 */
	public void rename(final String key, final String newKey) {
		redisTemplate.rename(key, newKey);
	}

	/**
	 * 返回key的类型
	 */
	public DataType type(final String key) {
		return redisTemplate.type(key);
	}
}
