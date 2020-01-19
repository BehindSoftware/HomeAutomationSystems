
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C4", "SmokeDetector is in on state");
	}

}
