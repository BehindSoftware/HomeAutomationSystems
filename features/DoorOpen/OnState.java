
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C3", "DoorOpenDetector is in on state");
	}

}
