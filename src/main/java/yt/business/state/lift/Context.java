package yt.business.state.lift;

public class Context {

	public final static OpeningState openingState = new OpeningState();

	public final static StopingState stopingState = new StopingState();

	public final static RunningState runningState = new RunningState();

	public final static ClosingState closingState = new ClosingState();

	private LiftState liftState;

	public LiftState getLiftState(){
		return liftState;
	}

	public void setLiftState(LiftState _liftState) {
		this.liftState = _liftState;
		this.liftState.setContext(this);
	}

	public void open (){
		this.liftState.open();
	}

	public void stop (){
		this.liftState.stop();
	}

	public void run (){
		this.liftState.run();
	}

	public void close (){
		this.liftState.close();
	}
}
