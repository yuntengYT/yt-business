package yt.business.state;

/**
 * @author yunteng
 */
public class AuditOverState implements LeaveRequestState {
	@Override
	public void doWork(StateMachine context) {
		LeaveRequestModel businessObj = (LeaveRequestModel) context.getBusinessObj();
		System.out.println(businessObj.getUser()+",请假流程结束,结果是："+businessObj.getResult());
	}
}
