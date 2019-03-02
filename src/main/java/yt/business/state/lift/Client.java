package yt.business.state.lift;

public class Client {

	public static void main(String[] args) {
		Context context = new Context();
		context.setLiftState(new OpeningState());

		context.stop();
	}
}
