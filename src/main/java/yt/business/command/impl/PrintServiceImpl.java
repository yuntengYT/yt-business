package yt.business.command.impl;

import yt.business.command.Command;

/**
 * @author yunteng
 */
public class PrintServiceImpl implements Command {
	@Override
	public Object handle(Object obj) {
		System.out.println( obj + "打印执行完成");
		return null;
	}
}
