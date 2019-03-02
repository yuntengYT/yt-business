package yt.business.state.approve;

import java.util.Scanner;

public class ProjectManagerState implements LeaveRequestState{
	@Override
	public void doWork(StateMachine context) {
		//先提取业务对象
		LeaveRequestModel businessObj = (LeaveRequestModel) context.getBusinessObj();
		System.out.println("项目经理审核中。。。");
		//模拟用户界面,从控制台读取数据
		System.out.println(businessObj.getUser() + "申请从" + businessObj.getDateBegin() + "开始请假" + businessObj.getLeaveDays() + "天，请项目经理审核(1同意，2不同意)：");
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNext()) {
			int a = scanner.nextInt();
			String res = "不同意";
			if (a == 1) {
				res = "同意";
			}
			businessObj.setResult("项目经理审核结果：" + res);
			//根据选择的结果和条件选择下一步
			if (a == 1) {
				if (businessObj.getLeaveDays() > 3) {
					//3天以上的假项目经理同意了则交由部门经理审核
					context.setState(new DepManagerState());
					context.doWork();
				} else {
					//3天以内的假项目经理直接做主，就不用交给部门经理了，转向审核结束状态
					context.setState(new AuditOverState());
					context.doWork();
				}
			} else {
				//如果项目经理不同意，就不用交给部门经理了，转向审核结束状态
				context.setState(new AuditOverState());
				context.doWork();
			}
		}
	}
}
