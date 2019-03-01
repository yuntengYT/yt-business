package yt.business.state;

import org.springframework.stereotype.Component;


/**
 * @author yunteng
 */
@Component
public class StateMachine {

	private State state;

	private Object businessObj;

	public void doWork(){
		this.state.doWork(this);
	}

	public State getState(){
		return state;
	}

	public void setState(State state){
		this.state = state;
	}

	public Object getBusinessObj(){
		return businessObj;
	}

	public void setBusinessObj(Object businessObj) {
		this.businessObj = businessObj;
	}
}
