
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C1", "LightController is in on state");
	}

}
