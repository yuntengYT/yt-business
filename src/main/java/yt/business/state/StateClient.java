package yt.business.state;

/**
 * @author yunteng
 */
public class StateClient {

	public static void main(String[] args) {

		//创建业务对象，设置数据
		LeaveRequestModel model = new LeaveRequestModel();
		model.setUser("鸟鹏");
		model.setDateBegin("20180930");
		//model.setLeaveDays(1);
		model.setLeaveDays(4);

		LeaveRequestContext context = new LeaveRequestContext();
		context.setBusinessObj(model);
		//配置上下文的初始状态，以后就随流程而动态变化（状态驱动）
		context.setState(new ProjectManagerState());
		context.doWork();


		//创建业务对象，设置数据
		LeaveRequestModel model1 = new LeaveRequestModel();
		model1.setUser("yy");
		model1.setDateBegin("20180930");
		//model.setLeaveDays(1);
		model1.setLeaveDays(4);

		LeaveRequestContext context1 = new LeaveRequestContext();
		context1.setBusinessObj(model1);
		//配置上下文的初始状态，以后就随流程而动态变化（状态驱动）
		context1.setState(new ProjectManagerState());
		context1.doWork();
	}
}
