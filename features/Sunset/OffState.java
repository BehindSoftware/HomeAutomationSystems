

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C6", "SunsetDetector is in off state");
	}

}
