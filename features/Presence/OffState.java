

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C1", "PresenceDetector is in off state");
	}

}
