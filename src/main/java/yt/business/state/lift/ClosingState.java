package yt.business.state.lift;

public class ClosingState extends LiftState {

	@Override
	public void open() {
		super.context.setLiftState(Context.openingState);
		super.context.getLiftState().open();
	}

	@Override
	public void close() {
		System.out.println("关闭");
	}

	@Override
	public void stop() {
		super.context.setLiftState(Context.stopingState);
		super.context.getLiftState().stop();
	}

	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();
	}
}
