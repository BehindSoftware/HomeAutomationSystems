

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C1", "LightController is in off state");
	}

}
