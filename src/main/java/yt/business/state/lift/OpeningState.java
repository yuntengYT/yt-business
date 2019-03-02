package yt.business.state.lift;

public class OpeningState extends LiftState {

	@Override
	public void open() {
		System.out.println("打开");
	}

	@Override
	public void close() {
		super.context.setLiftState(Context.closingState);
		super.context.getLiftState().close();
	}

	@Override
	public void stop() {

	}

	@Override
	public void run() {

	}
}
