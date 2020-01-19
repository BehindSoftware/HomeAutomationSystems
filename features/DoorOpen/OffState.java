

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C3", "DoorOpenDetector is in off state");
	}

}
