package yt.business.state.lift;

public class RunningState extends LiftState {

	@Override
	public void open() {

	}

	@Override
	public void close() {

	}

	@Override
	public void stop() {
		super.context.setLiftState(Context.stopingState);
		super.context.getLiftState().stop();
	}

	@Override
	public void run() {
		System.out.println("运行");
	}
}
