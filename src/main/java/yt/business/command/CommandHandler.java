package yt.business.command;

import java.util.Objects;

public class CommandHandler {
	/**
	 * 处理数据
	 */

	public static Object handle (int code,Object obj) {
		CommandEnum commandEnum = CommandEnum.getStock(code);
		if(null != commandEnum) {
			return Objects.requireNonNull(CommandFactory.getCommand(commandEnum)).handle(obj);
		}
		return null;
	}
}
