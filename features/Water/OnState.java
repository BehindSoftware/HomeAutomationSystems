
public class OnState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C5", "WaterDetector is in on state");
	}

}
