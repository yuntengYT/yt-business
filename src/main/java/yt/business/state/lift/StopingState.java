package yt.business.state.lift;

public class StopingState extends LiftState {

	@Override
	public void open() {
		super.context.setLiftState(Context.openingState);
		super.context.getLiftState().open();
	}

	@Override
	public void close() {

	}

	@Override
	public void stop() {
		System.out.println("关闭");
	}

	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();
	}
}
