
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C1", "PresenceDetector is in on state");
	}

}
