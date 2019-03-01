package yt.business.command;

import java.util.stream.Stream;

/**
 * @author yunteng
 */

public enum  CommandEnum {

	LOOK(1, "yt.business.command.impl.LookServiceImpl"),

	PRINT(2,"yt.business.command.impl.PrintServiceImpl");

	int code;
	String name;
	CommandEnum(int code,String name) {
		this.code = code;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName (){
		return name;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static CommandEnum getStock (int code) {
		return Stream.of(CommandEnum.values()).filter(commandEnum -> code == commandEnum.code).findFirst().orElse(null);
	}
}
