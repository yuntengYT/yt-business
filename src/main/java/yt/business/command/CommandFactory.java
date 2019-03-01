package yt.business.command;

/**
 * @author yunteng
 */
public class CommandFactory {

	public static Command getCommand (CommandEnum commandEnum) {

		Command command = null;
		try {
			command = (Command) Class.forName(commandEnum.getName()).newInstance();
			return command;
		}catch (Exception e){

		}
		return null;
	}
}
