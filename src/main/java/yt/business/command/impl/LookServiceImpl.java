package yt.business.command.impl;

import yt.business.command.Command;

/**
 * @author yunteng
 */
public class LookServiceImpl implements Command {
	@Override
	public Object handle(Object obj) {
		System.out.println(obj + "查看数据执行成功");
		return null;
	}
}
