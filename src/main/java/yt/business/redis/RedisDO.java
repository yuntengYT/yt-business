package yt.business.redis;

import lombok.Data;

/**
 * RedisDO
 *
 * @author shichunyang
 */
@Data
public class RedisDO {
	/**
	 * 主机
	 */
	private String hostName;
	/**
	 * 端口
	 */
	private Integer port;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 数据库
	 */
	private Integer database;
	/**
	 * 最小空闲连接
	 */
	private Integer minIdle;
	/**
	 * 最大空闲连接
	 */
	private Integer maxIdle;
	/**
	 * 总连接
	 */
	private Integer maxTotal;
}
