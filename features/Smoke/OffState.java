

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C4", "SmokeDetector is in off state");
	}

}
