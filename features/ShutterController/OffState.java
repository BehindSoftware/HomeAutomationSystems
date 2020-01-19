

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C6", "ShutterController is in off state");
	}

}
