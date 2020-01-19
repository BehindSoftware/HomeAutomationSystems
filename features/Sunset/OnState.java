
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C6", "SunsetDetector is in on state");
	}

}
