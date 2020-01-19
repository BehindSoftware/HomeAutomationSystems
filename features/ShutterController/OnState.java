
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C6", "ShutterController is in on state");
	}

}
