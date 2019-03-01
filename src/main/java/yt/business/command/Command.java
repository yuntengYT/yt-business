package yt.business.command;

public interface Command {

	/**
	 * 命令处理接口
	 * @param obj 处理数据
	 * @return 处理结果
	 */
	Object handle(Object obj);
}
