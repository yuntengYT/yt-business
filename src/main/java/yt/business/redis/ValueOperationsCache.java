package yt.business.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * ValueOperationsCache
 *
 * @author shichunyang
 */
public class ValueOperationsCache extends BaseRedisTemplate {

	private ValueOperations<String, String> valueOperations;

	public ValueOperationsCache(RedisTemplate<String, String> redisTemplate) {
		super.setRedisTemplate(redisTemplate);
		this.valueOperations = redisTemplate.opsForValue();
	}

	/**
	 * 返回字符串长度
	 */
	public long size(String key) {
		return valueOperations.size(key);
	}

	/**
	 * 追加字符串,并返回追加后字符串的长度
	 */
	public int append(String key, String value) {
		return valueOperations.append(key, value);
	}

	/**
	 * 自增
	 */
	public long increment(String key, long delta) {
		return valueOperations.increment(key, delta);
	}

	/**
	 * 截取字符串
	 */
	public String subString(String key, long start, long end) {
		return valueOperations.get(key, start, end);
	}

	/**
	 * 获取key的值
	 */
	public String get(String key) {
		return valueOperations.get(key);
	}

	/**
	 * 设置值
	 */
	public void set(String key, String value) {
		valueOperations.set(key, value);
	}

	/**
	 * 设置带有过期时间的 key
	 */
	public void setEX(String key, String value, long timeout) {
		valueOperations.set(key, value, timeout, TimeUnit.MILLISECONDS);
	}

	public boolean setNX(String key, String value) {
		return valueOperations.setIfAbsent(key, value);
	}

	public boolean setNX(String key, String value, long timeout) {

		boolean isNormal = valueOperations.setIfAbsent(key, value);

		if (isNormal) {
			super.expire(key, timeout);
		}

		return isNormal;
	}
}
