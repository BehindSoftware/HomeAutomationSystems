

public class OffState implements State {

	@Override
	public void doAction() {
		ChannelPublish.publish("C5", "WaterDetector is in off state");
	}

}
